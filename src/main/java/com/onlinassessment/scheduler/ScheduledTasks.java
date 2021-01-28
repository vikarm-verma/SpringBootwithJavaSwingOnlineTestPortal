package com.onlinassessment.scheduler;

import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.onlineassessment.entity.ScheduleMT;
import com.onlineassessment.entity.StudentMT;
import com.onlineassessment.service.ScheduleMTService;
import com.onlineassessment.service.StudentMTService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledTasks {
	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	@Autowired
	private ScheduleMTService scheduleMTService;

	@Autowired
	private StudentMTService studentMTService;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	@Scheduled(fixedRate = 1000 * 60)
	public void scheduleTaskWithFixedRate() throws ParseException {
		System.out.println("date time now is " + new Date());
		List<ScheduleMT> list = scheduleMTService.getAllMTS();
		Iterator<ScheduleMT> iterator = list.iterator();
		Date d2 = new Date();
		Date d3 = new Date();

		while (iterator.hasNext()) { 
			ScheduleMT sch = iterator.next();
			String s2 = sdf.format(new Date());
			if (sch.isActive() == false) {
				if ((d3.getYear() == sch.getFromDate().getYear()) && (d3.getMonth() == sch.getFromDate().getMonth())
						&& (d3.getDay() == sch.getFromDate().getDay())
						&& (d3.getHours() == sch.getFromDate().getHours())
						&& (d3.getMinutes() == sch.getFromDate().getMinutes())) {
					System.out.println("yes real loop	 working");
					System.out.println("in for loop");
					sch.setActive(true);
					scheduleMTService.updateMT(true, sch.getSchmtid());
					studentMTService.update(true, sch.getSchmtid());
					logger.info("mt is active now", dateTimeFormatter.format(LocalDateTime.now()));
					return;
				} 

			}
		
			if (sch.isActive() == true) {
				if ((d2.getYear() == sch.getToDate().getYear()) && (d2.getMonth() == sch.getToDate().getMonth())
						&& (d2.getDay() == sch.getToDate().getDay()) && (d2.getHours() == sch.getToDate().getHours())
						&& (d2.getMinutes() == sch.getToDate().getMinutes())) {
					System.out.println("yes real loop	 working");
					System.out.println("in for loop");
					sch.setActive(false);
					scheduleMTService.updateMT(false, sch.getSchmtid());
					studentMTService.update(false, sch.getSchmtid());
					logger.info("mt is inactive now", dateTimeFormatter.format(LocalDateTime.now()));
					return;
				}
			}
		}

	}

	public void scheduleTaskWithFixedDelay() {
	}

	public void scheduleTaskWithInitialDelay() {
	}

	public void scheduleTaskWithCronExpression() {
	}
}