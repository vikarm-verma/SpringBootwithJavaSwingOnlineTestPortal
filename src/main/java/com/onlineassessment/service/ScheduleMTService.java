package com.onlineassessment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineassessment.entity.ScheduleMT;
import com.onlineassessment.repository.ScheduleMTRepository;

@Service
public class ScheduleMTService {

	
	@Autowired
	ScheduleMTRepository scheduleMTRepository;

	public List<ScheduleMT> getAllMTS() {
		List<ScheduleMT> list = new ArrayList<ScheduleMT>();
		this.scheduleMTRepository.findAll().forEach(mts -> list.add(mts));
		return list;
	}

	public ScheduleMT getExamById(String id) {

		return scheduleMTRepository.findByMTId(id);
	}

	public void addMT(ScheduleMT stMT) {
		scheduleMTRepository.save(stMT);
	}

	public void deleteMT(String id) {
		this.scheduleMTRepository.deleteById(id);
	}

	public void updateExam(ScheduleMT sr, String examId) {
		// sr.setId=id;
		this.scheduleMTRepository.save(sr);
	}
	
	public void updateMT(Boolean active,String id)
	{
		this.scheduleMTRepository.updateMT(active, id);
	}
}
