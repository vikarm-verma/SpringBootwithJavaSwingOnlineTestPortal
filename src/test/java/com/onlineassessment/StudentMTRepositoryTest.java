package com.onlineassessment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.onlineassessment.repository.StudentMTRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMTRepositoryTest {

	@Autowired
	StudentMTRepository stm;
	
	@Test
	  public void myTest() throws Exception {
        stm.update(false, "JUMPMTID00001");
    }
}
