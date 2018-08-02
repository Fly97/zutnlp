package edu.zut.cs.zutnlp.text.base.service.impl;

import edu.zut.cs.zutnlp.text.base.config.JpaConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes =Application.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
public class GenericGenerator {
}
