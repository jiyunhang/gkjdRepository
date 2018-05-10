package com.frontier.mobile.gkjd.service.impl;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.frontier.mobile.gkjd.common.GsonUtil;
import com.frontier.mobile.gkjd.service.PtSecVolService;

import lombok.extern.slf4j.Slf4j;

/**
 * PT二次压降服务测试类
 * 
 * @author 纪云行
 */
@Slf4j
public class PtSecVolServiceImplTest {
	/**
	 * PT二次压降服务接口
	 */
	private static PtSecVolService ptSecVolService;
	
	/**
	 * 初始化资源
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		ptSecVolService = new PtSecVolServiceImpl();
	}

	/**
	 * 清理资源
	 */
	@AfterClass
	public static void tearDownAfterClass() {
		ptSecVolService = null;
	}

	/**
	 * 查询检定数据
	 */
	@Test
	public void testListVerificationData() {
		String resultMsg = ptSecVolService.listVerificationData(1000020679L, 980L);
		log.info("查询PT二次压降检定数据：{}", resultMsg);
	}

	/**
	 * 新增/修改检定数据
	 */
	@Ignore
	@Test
	public void testAddOrUpdateVerificationData() {
		String verificationData = null;
		Map<String, String> verificationDataMap = GsonUtil.jsonToMap(verificationData);
		String resultMsg = ptSecVolService.addOrUpdateVerificationData(verificationDataMap);
		log.info("新增/修改PT二次压降检定数据：{}", resultMsg);
	}

	/**
	 * 删除检定数据
	 */
	@Test
	public void testDeleteVerificationData() {
		String resultMsg = ptSecVolService.deleteVerificationData(812059L, 990647L, 1000000982L, "2011-12-29");
		log.info("删除PT二次压降检定数据：{}", resultMsg);
	}
}