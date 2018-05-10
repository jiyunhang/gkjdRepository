package com.frontier.mobile.gkjd.service.impl;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.frontier.mobile.gkjd.service.VerificationTaskService;
import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

/**
 * 检定任务服务测试类
 * 
 * @author 纪云行
 */
@Slf4j
public class VerificationTaskServiceImplTest {
	/**
	 * 检定任务服务接口
	 */
	private static VerificationTaskService verificationTaskService;
	
	/**
	 * 初始化资源
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		verificationTaskService = new VerificationTaskServiceImpl();
	}

	/**
	 * 清理资源
	 */
	@AfterClass
	public static void tearDownAfterClass() {
		verificationTaskService = null;
	}

	/**
	 * 查询检定任务
	 */
	@Test
	public void testListVerificationData() {
		String resultMsg = verificationTaskService.listVerificationTask(42L, 814592L, 1);
		log.info("查询检定任务：{}", resultMsg);
	}

	/**
	 * 新增检定任务
	 */
	@Test
	public void testAddVerificationTask() {
		String resultMsg = null;
		Map<String, String> verificationTaskMap = Maps.newHashMap();
		
		verificationTaskMap.put("stationId", "990042");
		verificationTaskMap.put("checkType", "01");
		verificationTaskMap.put("yearIndex", "2019");
		verificationTaskMap.put("measurePointId", "559");
		verificationTaskMap.put("quarterIndex", "6");
		resultMsg = verificationTaskService.addVerificationTask(verificationTaskMap, 1);
		log.info("新增电能表误差检定任务：{}", resultMsg);
		
		verificationTaskMap.clear();
		
		verificationTaskMap.put("stationId", "990042");
		verificationTaskMap.put("checkType", "01");
		verificationTaskMap.put("yearIndex", "2018");
		verificationTaskMap.put("itSetId", "524");
		resultMsg = verificationTaskService.addVerificationTask(verificationTaskMap, 2);
		log.info("新增CT误差检定任务：{}", resultMsg);
		
		verificationTaskMap.clear();
		
		verificationTaskMap.put("stationId", "991196");
		verificationTaskMap.put("checkType", "03");
		verificationTaskMap.put("yearIndex", "2020");
		verificationTaskMap.put("itSetId", "610");
		resultMsg = verificationTaskService.addVerificationTask(verificationTaskMap, 3);
		log.info("新增CT二次负荷检定任务：{}", resultMsg);
		
		verificationTaskMap.clear();
		
		verificationTaskMap.put("stationId", "990042");
		verificationTaskMap.put("checkType", "03");
		verificationTaskMap.put("yearIndex", "2014");
		verificationTaskMap.put("itSetId", "559");
		resultMsg = verificationTaskService.addVerificationTask(verificationTaskMap, 4);
		log.info("新增PT误差检定任务：{}", resultMsg);
		
		verificationTaskMap.clear();
		
		verificationTaskMap.put("stationId", "990042");
		verificationTaskMap.put("checkType", "03");
		verificationTaskMap.put("yearIndex", "2014");
		verificationTaskMap.put("itSetId", "559");
		resultMsg = verificationTaskService.addVerificationTask(verificationTaskMap, 5);
		log.info("新增PT二次负荷检定任务：{}", resultMsg);
		
		verificationTaskMap.clear();
		
		verificationTaskMap.put("stationId", "990042");
		verificationTaskMap.put("checkType", "03");
		verificationTaskMap.put("yearIndex", "2014");
		verificationTaskMap.put("measurePointId", "559");
		resultMsg = verificationTaskService.addVerificationTask(verificationTaskMap, 6);
		log.info("新增PT二次压降检定任务：{}", resultMsg);
	}

	/**
	 * 删除检定任务
	 */
	@Test
	public void testDeleteVerificationData() {
		String resultMsg = null;
		resultMsg = verificationTaskService.deleteVerificationTask(814012L, 1);
		log.info("删除电能表误差检定任务：{}", resultMsg);
		
		resultMsg = verificationTaskService.deleteVerificationTask(3005L, 2);
		log.info("删除CT误差检定任务：{}", resultMsg);
		
		resultMsg = verificationTaskService.deleteVerificationTask(812035L, 3);
		log.info("删除CT二次负荷检定任务：{}", resultMsg);
		
		resultMsg = verificationTaskService.deleteVerificationTask(812035L, 4);
		log.info("删除PT误差检定任务：{}", resultMsg);
		
		resultMsg = verificationTaskService.deleteVerificationTask(812035L, 5);
		log.info("删除PT二次负荷检定任务：{}", resultMsg);
		
		resultMsg = verificationTaskService.deleteVerificationTask(812035L, 6);
		log.info("删除PT二次压降检定任务：{}", resultMsg);
	}
}