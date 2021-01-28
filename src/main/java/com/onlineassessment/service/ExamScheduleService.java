package com.onlineassessment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineassessment.entity.ScheduleExam;
import com.onlineassessment.repository.ScheduleExamRepository;

@Service
public class ExamScheduleService {

	@Autowired
	ScheduleExamRepository scheduleExamRepository;

	public List<ScheduleExam> getAllExams() {
		List<ScheduleExam> list = new ArrayList<ScheduleExam>();
		this.scheduleExamRepository.findAll().forEach(questions -> list.add(questions));
		;
		return list;
	}

	public ScheduleExam getExamById(String id) {

		return scheduleExamRepository.findByExamId(id);
	}

	public void addExam(ScheduleExam stReg) {
		scheduleExamRepository.save(stReg);
	}

	public void deleteExam(String id) {
		this.scheduleExamRepository.deleteById(id);
	}

	public void updateExam(ScheduleExam sr, String examId) {
		// sr.setId=id;
		this.scheduleExamRepository.save(sr);
	}
//	public ScheduleExam findByExam(String question) {
//		return scheduleExamRepository.findByExam(question);
//	}

}
