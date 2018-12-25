package com.test.mongo;

import com.hanxiaocu.mongodb.repository.primary.PrimaryRepository;
import com.hanxiaocu.mongodb.repository.secondary.SecondaryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/25 4:41 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MultiDatabaseTest {


	@Autowired
	private PrimaryRepository primaryRepository;

	@Autowired
	private SecondaryRepository secondaryRepository;



	@Test
	public void testSave() {

	}
}
