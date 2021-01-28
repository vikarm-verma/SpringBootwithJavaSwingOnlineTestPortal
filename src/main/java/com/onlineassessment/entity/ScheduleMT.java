package com.onlineassessment.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.onlineassesment.customidgenerator.StringPrefixedSequenceIdGenerator;

@Entity  
@Table (name="schedulemt")
public class ScheduleMT {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mt_seq")
  	@GenericGenerator(
        name = "mt_seq",  
        strategy = "com.onlineassesment.customidgenerator.StringPrefixedSequenceIdGenerator", 
        parameters = {
        		@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
        		@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "JUMPMTID"),
        		@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String schmtid;
	
//	@NotBlank(message="modules cannot be empty")
	//@NotNull
	private String module;
	

//	@Column(columnDefinition = "DATE") 
	//@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm aa")
	private Date fromDate; 
	 
//	
//	@Column(columnDefinition = "DATE") 
	//@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm aa")
	private Date toDate;     
 
 
	
	@Column(columnDefinition = "boolean default true")
	private Boolean active=false;
	 
	  public boolean isActive() {
		return active;
	}
 
	public void setActive(boolean active) { 
		this.active = active;
	}

	@OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.EAGER,
	            mappedBy = "schedulemt")
	    private List<StudentMT> studentmt = new ArrayList<>();

	
	
	public ScheduleMT() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ScheduleMT(String module,
			Date fromDate2, Date toDate2) {
		this.module = module;
		this.fromDate = fromDate2;
		this.toDate = toDate2;
		
	}	
	 

//	public ScheduleMT(String schmtid, @NotBlank(message = "modules cannot be empty") @NotNull String module,
//			Date fromDate, Date toDate, List<StudentMT> studentmt) {
//		super();
//		this.schmtid = schmtid;
//		this.module = module;
//		this.fromDate = fromDate;
//		this.toDate = toDate;
//		this.studentmt = studentmt;
//	}

	public String getSchmtid() {
		return schmtid;
	}

	public void setSchmtid(String schmtid) {
		this.schmtid = schmtid;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public List<StudentMT> getStudentmt() {
		return studentmt;
	}

	public void setStudentmt(List<StudentMT> studentmt) {
		this.studentmt = studentmt;
	}

	@Override
	public String toString() {
		return "ScheduleMT [schmtid=" + schmtid + ", module=" + module + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", studentmt=" + studentmt + "]";
	}
	  
	  

}