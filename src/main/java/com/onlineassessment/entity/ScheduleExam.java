package com.onlineassessment.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.format.annotation.DateTimeFormat;

import com.onlineassesment.customidgenerator.StringPrefixedSequenceIdGenerator;



@Entity  
//defining class name as Table name  
@Table (name="scheduleexam")
public class ScheduleExam {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "exam_seq")
  	@GenericGenerator(
        name = "exam_seq", 
        strategy = "com.onlineassesment.customidgenerator.StringPrefixedSequenceIdGenerator", 
        parameters = {
        		@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
        		@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "JUMPEXAMID"),
        		@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String examId;
	
	@NotBlank(message="modules cannot be empty")
	@NotNull
	private String module;
	
	@DateTimeFormat(pattern = "mm/dd/yyyy hh:mm a")
	@NotNull
	private Date fromDate;
	
	@DateTimeFormat(pattern = "mm/dd/yyyy hh:mm a")
	@NotNull
	private Date toDate;
	
	@NotBlank(message="studentId cannot be empty")
	@NotNull
	private String studentId;
	@NotBlank(message="studentEmail cannot be empty")
	@NotNull
	private String studentEmail;
	@NotBlank(message="studentName cannot be empty")
	@NotNull
	private String studentName;
	public ScheduleExam() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScheduleExam(String examId, @NotBlank(message = "modules cannot be empty") String module,
			 Date fromDate,
			 Date toDate,
			@NotBlank(message = "studentId cannot be empty") String studentId,
			@NotBlank(message = "studentEmail cannot be empty") String studentEmail,
			@NotBlank(message = "studentName cannot be empty") String studentName) {
		super();
		this.examId = examId;
		this.module = module;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.studentId = studentId;
		this.studentEmail = studentEmail;
		this.studentName = studentName;
	}
	public String getExamId() {
		return examId;
	}
	public void setExamId(String examId) {
		this.examId = examId;
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
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	@Override
	public String toString() {
		return "ScheduleExam [examId=" + examId + ", module=" + module + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", studentId=" + studentId + ", studentEmail=" + studentEmail + ", studentName=" + studentName + "]";
	}
		
	
}
