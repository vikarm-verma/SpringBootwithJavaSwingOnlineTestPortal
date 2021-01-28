package com.onlineassessment.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name="moduletestresult")
public class ModuleTestResult {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int resultId;

	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm a")
	@NotNull
	private Date moduleTestDate;
	private String studentId;
	private String mtkey;
	private int totalQuestions;
	private int correctQuestions;
	private int incorrectQuestions;
	private float percentage;
	public ModuleTestResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModuleTestResult(int resultId, @NotNull Date moduleTestDate, String studentId, String mtkey,
			int totalQuestions, int correctQuestions, int incorrectQuestions, float percentage) {
		super();
		this.resultId = resultId;
		this.moduleTestDate = moduleTestDate;
		this.studentId = studentId;
		this.mtkey = mtkey;
		this.totalQuestions = totalQuestions;
		this.correctQuestions = correctQuestions;
		this.incorrectQuestions = incorrectQuestions;
		this.percentage = percentage;
	}
	public int getResultId() {
		return resultId;
	}
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
	public Date getModuleTestDate() {
		return moduleTestDate;
	}
	public void setModuleTestDate(Date moduleTestDate) {
		this.moduleTestDate = moduleTestDate;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getMtkey() {
		return mtkey;
	}
	public void setMtkey(String mtkey) {
		this.mtkey = mtkey;
	}
	public int getTotalQuestions() {
		return totalQuestions;
	}
	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	public int getCorrectQuestions() {
		return correctQuestions;
	}
	public void setCorrectQuestions(int correctQuestions) {
		this.correctQuestions = correctQuestions;
	}
	public int getIncorrectQuestions() {
		return incorrectQuestions;
	}
	public void setIncorrectQuestions(int incorrectQuestions) {
		this.incorrectQuestions = incorrectQuestions;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "ModuleTestResult [resultId=" + resultId + ", moduleTestDate=" + moduleTestDate + ", studentId="
				+ studentId + ", mtkey=" + mtkey + ", totalQuestions=" + totalQuestions + ", correctQuestions="
				+ correctQuestions + ", incorrectQuestions=" + incorrectQuestions + ", percentage=" + percentage + "]";
	}

}
