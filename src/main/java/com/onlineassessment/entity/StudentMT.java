package com.onlineassessment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity  
@Table (name="studentmt")
public class StudentMT {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mtid")
	private long mtid;
	
	@NotBlank(message="studentId cannot be empty")
	@NotNull
	private String sId;
	@NotBlank(message="studentEmail cannot be empty")
	@NotNull
	private String email;
	@NotBlank(message="studentName cannot be empty")
	@NotNull
	private String fullName;
	
	@ManyToOne(cascade=CascadeType.ALL)
@JoinColumn(name="schmtid", nullable=false)
	private ScheduleMT schedulemt;

	
	@Column(columnDefinition = "boolean default false")
	private Boolean mtActive=false;
	 
	
	
	public Boolean getMtActive() {
		return mtActive;
	}
 
	public void setMtActive(Boolean mtActive) {
		this.mtActive = mtActive;
	}


	
	
	public StudentMT() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentMT(@NotBlank(message = "studentId cannot be empty") @NotNull String sId,
			@NotBlank(message = "studentEmail cannot be empty") @NotNull String email,
			@NotBlank(message = "studentName cannot be empty") @NotNull String fullName,ScheduleMT schedulemt) {
		this.sId = sId;
		this.email = email;
		this.fullName = fullName;
		this.schedulemt = schedulemt; 
	}
	
//	public StudentMT(long mtid, @NotBlank(message = "studentId cannot be empty") @NotNull String sId,
//			@NotBlank(message = "studentEmail cannot be empty") @NotNull String email,
//			@NotBlank(message = "studentName cannot be empty") @NotNull String fullName, ScheduleMT schedulemt) {
//		super();
//		this.mtid = mtid;
//		this.sId = sId;
//		this.email = email;
//		this.fullName = fullName;
//		this.schedulemt = schedulemt;
//	}

	public long getMtid() {
		return mtid;
	}

	public void setMtid(long mtid) {
		this.mtid = mtid;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public ScheduleMT getSchedulemt() {
		return schedulemt; 
	}

	public void setSchedulemt(ScheduleMT schedulemt) {
		this.schedulemt = schedulemt;
	}

	@Override
	public String toString() {
		return "StudentMT [mtid=" + mtid + ", sId=" + sId + ", email=" + email + ", fullName=" + fullName
				+ ", schedulemt=" + schedulemt + "]";
	}
}
