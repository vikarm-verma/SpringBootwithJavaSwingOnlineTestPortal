package com.onlineassessment.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.Valid;

import org.hibernate.query.Query;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.onlineassessment.entity.Module1Questions;
import com.onlineassessment.entity.ScheduleMT;
import com.onlineassessment.entity.StudentMT;
import com.onlineassessment.entity.ScheduleMT;
import com.onlineassessment.entity.StudentRegistration;
import com.onlineassessment.service.ScheduleMTService;
import com.onlineassessment.service.StudentMTService;
import com.onlineassessment.service.ScheduleMTService;
import com.onlineassessment.service.StudentService;

import ch.qos.logback.core.status.OnPrintStreamStatusListenerBase;

@Controller
public class ExamScheduleController {

	@Autowired
	StudentService studentService;

	@Autowired
	private ScheduleMTService scheduleMTService;

	@Autowired
	private StudentMTService studentMTService;
	@PersistenceContext
	EntityManager em;

	boolean showDiv = false;

	static int value =0;
	@GetMapping("/ta/viewstudentmts")
	public String examSchedule(Model model) {

//		TypedQuery<ScheduleMT> query
//	      = entityManager.createQuery(
//	    		  "SELECT e.schedulemt FROM StudentMT e", ScheduleMT.class);
//	    List<ScheduleMT> resultList = query.getResultList();
		// System.out.println(resultList);
		Query q = (Query) em.createNativeQuery("SELECT smt.s_id,sch.module,sch.schmtid,sch.from_date,sch.to_date"
				+ ",smt.mt_active FROM schedulemt sch inner join studentmt smt on sch.schmtid=smt.schmtid ");
		List<Object[]> result = q.getResultList();

		for (Object[] a : result) {
			System.out.println(a[0] + "," + a[1] + "," + a[2] + "," + a[3] + "," + a[4] + "," + a[5]);
		}
		model.addAttribute("studentmts", studentMTService.getAllMTS());
		model.addAttribute("schedulemts", scheduleMTService.getAllMTS());
		model.addAttribute("result",result);
		// model.addAttribute("studentmts", resultList);
		
		return "viewstudentmts";
	}


	Date d = new Date();
	@GetMapping("/ta/mtschedule")
	public String mtSchedule(Model model ) 
	{
String path="";
		model.addAttribute("students", studentService.getAllStudents());
		// model.addAttribute("scheduleMT",new ScheduleMT());
		showDiv = true;
		model.addAttribute("showDiv",showDiv);
		path= "mtschedule";
		
	return path;
	}

	@ModelAttribute("scheduleMT")
	public ScheduleMT scheduleMT() {
		return new ScheduleMT();
	}

//	we need to add this else we will get date tpye format exception , while sending request as post mapping
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {

		// transition date
		DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy, HH:mm a");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true)); // CustomDateEditor date custom
																							// editor
	}

	Date fromDate = null;
	Date toDate = null;
	@PostMapping("/ta/addScheduleMT")
	@ResponseBody
	public String addScheduleMT(@Valid @ModelAttribute("scheduleMT") ScheduleMT scheduleMT, StudentMT studentMT,
			BindingResult result, Model model, @RequestBody String dataArrayToSend[]) throws ParseException {
		try {
			List<String> list1 = new ArrayList<>();
			List<String> list = new ArrayList<>();
			String[] data;

			for (int i = 0; i < dataArrayToSend.length; i++) {
				data = dataArrayToSend[i].split("-");
				for (int j = 0; j < 1; j++) {
					list.add(data[j]);
				}
				for (int j = 1; j < 2; j++) {
					list1.add(data[j]);
				}
			}
			String[] s1 = new String[list1.size()];
			String data2[];
			String module = " ";
			

			for (int i = 0; i < s1.length; i++) {
				s1[i] = list1.get(i);
				System.out.println("schmt-" + s1[i]);
				data2 = s1[i].split(",", 3);
				for (int j = 0; j < data2.length; j++) {
					if (j == 0) {
						SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
						fromDate = formatter.parse(data2[j]);
					}
					if (j == 1) {
						SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
						toDate = formatter.parse(data2[j]);
					}
					if (j == 2) {
						module = data2[j];
					}
				}
			}

			System.out.println(module + " " + fromDate + " " + toDate);
			ScheduleMT schmt = new ScheduleMT(module, fromDate, toDate);
			scheduleMTService.addMT(schmt);

			dataArrayToSend = null;
			System.out.println(list);
			System.out.println(list1);
			String[] s = new String[list.size()];
			String[] data1;
			String sId = " ", email = " ", name = "";

			for (int i1 = 0; i1 < s.length; i1++) {
				s[i1] = list.get(i1);
				// System.out.println("schmt-"+s[i1]);
				data1 = s[i1].split(" ", 3);
				for (int j = 0; j < data1.length; j++) {
					// System.out.println("data 1 is"+data1[j]+" = "+j);
					if (j == 0) {
						sId = data1[j];
					}
					if (j == 1) {
						email = data1[j];
					}
					if (j == 2) {
						name = data1[j];
					}
				}
				// System.out.println(" id is "+sId+"\nemail is "+email+"\nname is "+name);
				StudentMT smt = new StudentMT(sId, email, name, schmt);
				studentMTService.addMT(smt);
			//	currentDate1=new Date();
				showDiv = false;
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("error ->" + e);
		}
		value=value+1;
		showDiv=false;
		
		model.addAttribute("showDiv",showDiv);
		// System.out.println(list5);
		return "commondashboard";
	}
}
