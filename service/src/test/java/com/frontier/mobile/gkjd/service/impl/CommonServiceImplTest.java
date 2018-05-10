package com.frontier.mobile.gkjd.service.impl;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.frontier.mobile.gkjd.service.CommonService;

import lombok.extern.slf4j.Slf4j;

/**
 * 公共服务测试类
 * 
 * @author 纪云行
 */
@Slf4j
public class CommonServiceImplTest {
	/**
	 * 公共服务
	 */
	private static CommonService commonService;

	/**
	 * 初始化资源
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		commonService = new CommonServiceImpl();
	}

	/**
	 * 清理资源
	 */
	@AfterClass
	public static void tearDownAfterClass() {
		commonService = null;
	}

	/**
	 * 查询所有统调电厂
	 */
	@Test
	public void testListTreeNode() {
		String resultMsg = commonService.listTreeNode();
		log.info("查询所有统调电厂列表：{}", resultMsg);
	}

	/**
	 * 查询测试单位
	 */
	@Test
	public void testListSpecialOrg() {
		String resultMsg = commonService.listSpecialOrg();
		log.info("查询测试单位列表：{}", resultMsg);
	}

	/**
	 * 查询检验员、核验员
	 */
	@Test
	public void testListCheckUser() {
		String resultMsg = commonService.listCheckUser();
		log.info("查询检验员、核验员列表：{}", resultMsg);
	}

	/**
	 * 查询设备信息
	 */
	@Test
	public void testListCriterionDevice() {
		String resultMsg = commonService.listCriterionDevice();
		log.info("查询设备信息：{}", resultMsg);
	}
	
	/**
	 * 查询关口列表
	 */
	@Test
	public void testListStationMp() {
		String resultMsg = commonService.listStationMp(7L, null, 1);
		log.info("查询关口列表：{}", resultMsg);
	}
}