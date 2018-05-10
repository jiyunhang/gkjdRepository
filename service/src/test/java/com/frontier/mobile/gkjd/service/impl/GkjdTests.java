package com.frontier.mobile.gkjd.service.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * 关口检定测试套件
 * 
 * @author 纪云行
 */
@RunWith(Suite.class)
@SuiteClasses({ CommonServiceImplTest.class, CtErrorVerServiceImplTest.class, CtSecLoadServiceImplTest.class,
		MeterErrorServiceImplTest.class, PtErrorVerServiceImplTest.class, PtSecLoadServiceImplTest.class,
		PtSecVolServiceImplTest.class, VerificationTaskServiceImplTest.class })
public class GkjdTests {
	
}