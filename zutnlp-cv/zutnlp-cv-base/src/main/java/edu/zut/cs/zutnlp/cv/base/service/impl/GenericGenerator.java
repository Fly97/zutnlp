package edu.zut.cs.zutnlp.cv.base.service.impl;

import edu.zut.cs.zutnlp.cv.base.config.JpaConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =TestApplication.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
public class GenericGenerator {

}