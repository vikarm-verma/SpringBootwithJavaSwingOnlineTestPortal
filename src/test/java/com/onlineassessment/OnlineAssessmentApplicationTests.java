package com.onlineassessment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineassessment.entity.ScheduleMT;
import com.onlineassessment.entity.StudentMT;
import com.onlineassessment.repository.StudentMTRepository;

@SpringBootTest
class OnlineAssessmentApplicationTests {

	@Test
	void contextLoads() {
	}
	
//	@Autowired
//	StudentMTRepository stm;
	
//	@Test
//	  public void myTest() throws Exception {
//        stm.update(false, "JUMPMTID00001");
//    }
//	@PersistenceContext
//	EntityManager entityManager;
//	@Test
//	public void whenPathExpressionIsUsedForSingleValuedAssociation_thenCreatesImplicitInnerJoin() {
//	  
////		TypedQuery<ScheduleMT> query
////	      = entityManager.createQuery(
////	          "SELECT scmt.fromDate,scmt.toDate,sctmt.module,stmt.sId,stmt.email,stmt.fullName,stmt.mtActive"
////	          + " from ScheduleMT scmt inner join "
////	          + "StudentMT stmt on scmt.schmtid = stmt.schmtid ", ScheduleMT.class);
////	    List<ScheduleMT> resultList = query.getResultList();
//	    
//	    
////		TypedQuery<ScheduleMT> query
////	      = entityManager.createQuery(
////	    		  "SELECT e.schedulemt FROM StudentMT e", ScheduleMT.class);
////	    List<ScheduleMT> resultList = query.getResultList();
////	//    System.out.println(resultList);
////	    // Assertions...
//	}
}
