package com.onlineassessment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="practicequestions")
public class PracticeQuestions {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	@Column(name = "qId")
	private int qId;
	@NotBlank(message="write a questions") 
	@Column(columnDefinition="varchar(1000)")
	private String question;
	@NotBlank(message="write answer option")
	@Column(columnDefinition="varchar(1000)")
	private String opt1;
	@NotBlank(message="write answer option")
	@Column(columnDefinition="varchar(1000)")
	private String opt2;
	@NotBlank(message="write answer option") 
	@Column(columnDefinition="varchar(1000)")
	private String opt3;
	@NotBlank(message="write answer option")
	@Column(columnDefinition="varchar(1000)")
	private String opt4;
	private int ans;
	public PracticeQuestions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PracticeQuestions(int qId, @NotBlank(message = "write a questions") String question,
			@NotBlank(message = "write answer option") String opt1,
			@NotBlank(message = "write answer option") String opt2,
			@NotBlank(message = "write answer option") String opt3,
			@NotBlank(message = "write answer option") String opt4, int ans) {
		super();
		this.qId = qId;
		this.question = question;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.opt3 = opt3;
		this.opt4 = opt4;
		this.ans = ans;
	}
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOpt1() {
		return opt1;
	}
	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}
	public String getOpt2() {
		return opt2;
	}
	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}
	public String getOpt3() {
		return opt3;
	}
	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}
	public String getOpt4() {
		return opt4;
	}
	public void setOpt4(String opt4) {
		this.opt4 = opt4;
	}
	public int getAns() {
		return ans;
	}
	public void setAns(int ans) {
		this.ans = ans;
	}
	@Override
	public String toString() {
		return "PracticeQuestions [qId=" + qId + ", question=" + question + ", opt1=" + opt1 + ", opt2=" + opt2
				+ ", opt3=" + opt3 + ", opt4=" + opt4 + ", ans=" + ans + "]";
	}
		
}
