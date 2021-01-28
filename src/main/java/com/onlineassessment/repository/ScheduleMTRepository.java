package com.onlineassessment.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.onlineassessment.entity.ScheduleExam;
import com.onlineassessment.entity.ScheduleMT;

public interface ScheduleMTRepository extends CrudRepository<ScheduleMT,String> {
	@Query("select s from ScheduleMT s where s.schmtid=:schmtid")
	public ScheduleMT findByMTId(@Param ("schmtid")String schmtid);
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE ScheduleMT SET active= :active where schmtid=:schmtid")
	public void updateMT(@Param("active") Boolean active, @Param("schmtid") String schmtid); 
}
