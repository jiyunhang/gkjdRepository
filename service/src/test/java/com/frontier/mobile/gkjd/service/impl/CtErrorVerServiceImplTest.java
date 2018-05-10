package com.frontier.mobile.gkjd.service.impl;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.frontier.mobile.gkjd.common.GsonUtil;
import com.frontier.mobile.gkjd.service.CtErrorVerService;

import lombok.extern.slf4j.Slf4j;

/**
 * CT误差服务测试类
 * 
 * @author 纪云行
 */
@Slf4j
public class CtErrorVerServiceImplTest {
	/**
	 * CT误差服务
	 */
	private static CtErrorVerService ctErrorVerService;

	/**
	 * 初始化资源
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		ctErrorVerService = new CtErrorVerServiceImpl();
	}

	/**
	 * 清理资源
	 */
	@AfterClass
	public static void tearDownAfterClass() {
		ctErrorVerService = null;
	}

	/**
	 * 查询检定数据
	 */
	@Test
	public void testListVerificationData() {
		String resultMsg = ctErrorVerService.listVerificationData(2624L, 469L);
		log.info("查询CT误差检定数据：{}", resultMsg);
	}

	/**
	 * 新增/修改检定数据
	 */
	@Test
	public void testAddOrUpdateVerificationData() {
		String verificationData = "{\"mpCtCheckCommon.cerNo\":\"123123\",\"mpCtCheckCommon.checkDate\":\"2007-10-15\",\"mpCtCheckCommon.deviceId\":133,\"mpCtCheckCommon.editUser\":\"123123\",\"mpCtCheckCommon.humidity\":\"55\",\"mpCtCheckCommon.notes\":\"\",\"mpCtCheckCommon.temperature\":\"18\",\"mpCtCheckCommon.specialOrgId\":10000000775557,\"mpCtCheckCommon.appearanceTest\":\"\",\"mpCtCheckCommon.insulatedR\":\"合格\",\"mpCtCheckCommon.polarityTest\":\"正确\",\"mpCtCheckCommon.checkUserId2\":913480119,\"mpCtCheckCommon.checkUserId1\":800000001,\"mpCtCheckCommon.periodId\":2736,\"mpCtCheckCommon.itSetId\":485,\"mpCtCheckCommon.stationId\":990632,\"mpCtCheck1.phase\":\"A\",\"mpCtCheck1.madeNo\":\"040812\",\"mpCtCheck1.itRatioId\":4953,\"mpCtCheck1.ctPreCode\":\"02\",\"mpCtCheck1.checkResult\":\"01\",\"mpCtCheck1.testPoint1\":\"1\",\"mpCtCheck1.testPoint2\":\"5\",\"mpCtCheck1.testPoint3\":\"20\",\"mpCtCheck1.testPoint4\":\"100\",\"mpCtCheck1.testPoint5\":\"120\",\"mpCtCheck1.sxfh_bzc_data1\":\"-0.052\",\"mpCtCheck1.sxfh_bzc_data2\":\"-0.046\",\"mpCtCheck1.sxfh_bzc_data3\":\"-0.044\",\"mpCtCheck1.sxfh_bzc_data4\":\"-0.045\",\"mpCtCheck1.sxfh_bzc_data5\":\"-0.046\",\"mpCtCheck1.sxfh_xwc_data1\":\"3\",\"mpCtCheck1.sxfh_xwc_data2\":\"2.2\",\"mpCtCheck1.sxfh_xwc_data3\":\"1.2\",\"mpCtCheck1.sxfh_xwc_data4\":\"0.8\",\"mpCtCheck1.sxfh_xwc_data5\":\"0.8\",\"mpCtCheck1.xxfh_bzc_data1\":\"\",\"mpCtCheck1.xxfh_bzc_data2\":\"-0.02\",\"mpCtCheck1.xxfh_bzc_data3\":\"-0.019\",\"mpCtCheck1.xxfh_bzc_data4\":\"-0.021\",\"mpCtCheck1.xxfh_bzc_data5\":\"\",\"mpCtCheck1.xxfh_xwc_data1\":\"\",\"mpCtCheck1.xxfh_xwc_data2\":\"1.1\",\"mpCtCheck1.xxfh_xwc_data3\":\"0.5\",\"mpCtCheck1.xxfh_xwc_data4\":\"0.2\",\"mpCtCheck1.xxfh_xwc_data5\":\"\",\"mpCtCheck1.sxfh_powerFactor\":0.8,\"mpCtCheck1.sxfh_testSecondLoad\":40,\"mpCtCheck1.xxfh_powerFactor\":0.8,\"mpCtCheck1.xxfh_testSecondLoad\":10,\"mpCtCheck1.dataCibao\":\"\",\"mpCtCheck1.dataYudu\":\"\",\"mpCtCheck2.phase\":\"B\",\"mpCtCheck2.madeNo\":\"040815\",\"mpCtCheck2.itRatioId\":4953,\"mpCtCheck2.ctPreCode\":\"02\",\"mpCtCheck2.checkResult\":\"01\",\"mpCtCheck2.testPoint1\":\"1\",\"mpCtCheck2.testPoint2\":\"5\",\"mpCtCheck2.testPoint3\":\"20\",\"mpCtCheck2.testPoint4\":\"100\",\"mpCtCheck2.testPoint5\":\"120\",\"mpCtCheck2.sxfh_bzc_data1\":\"-0.07\",\"mpCtCheck2.sxfh_bzc_data2\":\"-0.044\",\"mpCtCheck2.sxfh_bzc_data3\":\"-0.045\",\"mpCtCheck2.sxfh_bzc_data4\":\"-0.046\",\"mpCtCheck2.sxfh_bzc_data5\":\"-0.046\",\"mpCtCheck2.sxfh_xwc_data1\":\"3.9\",\"mpCtCheck2.sxfh_xwc_data2\":\"2.1\",\"mpCtCheck2.sxfh_xwc_data3\":\"1.3\",\"mpCtCheck2.sxfh_xwc_data4\":\"0.9\",\"mpCtCheck2.sxfh_xwc_data5\":\"0.9\",\"mpCtCheck2.xxfh_bzc_data1\":\"\",\"mpCtCheck2.xxfh_bzc_data2\":\"-0.02\",\"mpCtCheck2.xxfh_bzc_data3\":\"-0.019\",\"mpCtCheck2.xxfh_bzc_data4\":\"-0.02\",\"mpCtCheck2.xxfh_bzc_data5\":\"\",\"mpCtCheck2.xxfh_xwc_data1\":\"\",\"mpCtCheck2.xxfh_xwc_data2\":\"1\",\"mpCtCheck2.xxfh_xwc_data3\":\"0.4\",\"mpCtCheck2.xxfh_xwc_data4\":\"0.2\",\"mpCtCheck2.xxfh_xwc_data5\":\"\",\"mpCtCheck2.sxfh_powerFactor\":0.8,\"mpCtCheck2.sxfh_testSecondLoad\":40,\"mpCtCheck2.xxfh_powerFactor\":0.8,\"mpCtCheck2.xxfh_testSecondLoad\":10,\"mpCtCheck2.dataCibao\":\"\",\"mpCtCheck2.dataYudu\":\"\",\"mpCtCheck3.phase\":\"C\",\"mpCtCheck3.madeNo\":\"040811\",\"mpCtCheck3.itRatioId\":4953,\"mpCtCheck3.ctPreCode\":\"02\",\"mpCtCheck3.checkResult\":\"01\",\"mpCtCheck3.testPoint1\":\"1\",\"mpCtCheck3.testPoint2\":\"5\",\"mpCtCheck3.testPoint3\":\"20\",\"mpCtCheck3.testPoint4\":\"100\",\"mpCtCheck3.testPoint5\":\"120\",\"mpCtCheck3.sxfh_bzc_data1\":\"-0.059\",\"mpCtCheck3.sxfh_bzc_data2\":\"-0.046\",\"mpCtCheck3.sxfh_bzc_data3\":\"-0.099\",\"mpCtCheck3.sxfh_bzc_data4\":\"-0.048\",\"mpCtCheck3.sxfh_bzc_data5\":\"-0.04\",\"mpCtCheck3.sxfh_xwc_data1\":\"3.2\",\"mpCtCheck3.sxfh_xwc_data2\":\"1.9\",\"mpCtCheck3.sxfh_xwc_data3\":\"0.8\",\"mpCtCheck3.sxfh_xwc_data4\":\"0.1\",\"mpCtCheck3.sxfh_xwc_data5\":\"0.1\",\"mpCtCheck3.xxfh_bzc_data1\":\"\",\"mpCtCheck3.xxfh_bzc_data2\":\"-0.021\",\"mpCtCheck3.xxfh_bzc_data3\":\"-0.018\",\"mpCtCheck3.xxfh_bzc_data4\":\"-0.021\",\"mpCtCheck3.xxfh_bzc_data5\":\"\",\"mpCtCheck3.xxfh_xwc_data1\":\"\",\"mpCtCheck3.xxfh_xwc_data2\":\"1\",\"mpCtCheck3.xxfh_xwc_data3\":\"0.3\",\"mpCtCheck3.xxfh_xwc_data4\":\"0\",\"mpCtCheck3.xxfh_xwc_data5\":\"\",\"mpCtCheck3.sxfh_powerFactor\":0.8,\"mpCtCheck3.sxfh_testSecondLoad\":40,\"mpCtCheck3.xxfh_powerFactor\":0.8,\"mpCtCheck3.xxfh_testSecondLoad\":10,\"mpCtCheck3.dataCibao\":\"\",\"mpCtCheck3.dataYudu\":\"\"}";
		Map<String, String> verificationDataMap = GsonUtil.jsonToMap(verificationData);
		String resultMsg = ctErrorVerService.addOrUpdateVerificationData(verificationDataMap);
		log.info("新增/修改CT误差检定数据：{}", resultMsg);
	}

	/**
	 * 删除检定数据
	 */
	@Test
	public void testDeleteVerificationData() {
		String resultMsg = ctErrorVerService.deleteVerificationData(2603L, 466L, 5350L);
		log.info("删除CT误差检定数据：{}", resultMsg);
	}
}