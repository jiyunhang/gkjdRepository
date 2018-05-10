package com.frontier.mobile.gkjd.service.impl;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.frontier.mobile.gkjd.common.GsonUtil;
import com.frontier.mobile.gkjd.service.PtErrorVerService;

import lombok.extern.slf4j.Slf4j;

/**
 * PT误差服务测试类
 * 
 * @author 纪云行
 */
@Slf4j
public class PtErrorVerServiceImplTest {
	/**
	 * PT误差检定服务
	 */
	private static PtErrorVerService ptErrorVerService;
	
	/**
	 * 初始化资源
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		ptErrorVerService = new PtErrorVerServiceImpl();
	}

	/**
	 * 清理资源
	 */
	@AfterClass
	public static void tearDownAfterClass() {
		ptErrorVerService = null;
	}

	/**
	 * 查询检定数据
	 */
	@Test
	public void testListVerificationData() {
		String resultMsg = ptErrorVerService.listVerificationData(2535L, 1450L, 640L);
		log.info("查询PT误差检定数据：{}", resultMsg);
	}

	/**
	 * 新增/修改检定数据
	 */
	@Test
	public void testAddOrUpdateVerificationData() {
		String verificationData = "{\"mPtCheckCommon.cerNo\":\"1\",\"mPtCheckCommon.checkDate\":\"2018-01-09\",\"mPtCheckCommon.checkUserId1\":913669569,\"mPtCheckCommon.deviceId\":175,\"mPtCheckCommon.editUser\":\"3\",\"mPtCheckCommon.examineUserId\":913480119,\"mPtCheckCommon.humidity\":\"2\",\"mPtCheckCommon.notes\":\"7\",\"mPtCheckCommon.temperature\":\"1\",\"mPtCheckCommon.testUnitId\":10000005,\"mPtCheckCommon.appearanceTest\":\"4\",\"mPtCheckCommon.insulatedR\":\"5\",\"mPtCheckCommon.polarityTest\":\"6\",\"mPtCheckCommon.periodId\":814769,\"mPtCheckCommon.ptSetId\":1450,\"mobileMpPtData1.phase\":\"A\",\"mobileMpPtData1.madeNo\":\"0920244-4\",\"mobileMpPtData1.rcRatioCodeName\":\"110/√3/0.1/√3kV\",\"mobileMpPtData1.ptPreCodeName\":\"0.2\",\"mobileMpPtData1.checkResult\":\"01\",\"mobileMpPtData1.testPoint1\":\"1\",\"mobileMpPtData1.testPoint2\":\"6\",\"mobileMpPtData1.testPoint3\":\"11\",\"mobileMpPtData1.sxfh_bzc_data1\":\"2\",\"mobileMpPtData1.sxfh_bzc_data2\":\"7\",\"mobileMpPtData1.sxfh_bzc_data3\":\"12\",\"mobileMpPtData1.sxfh_xwc_data1\":\"3\",\"mobileMpPtData1.sxfh_xwc_data2\":\"8\",\"mobileMpPtData1.sxfh_xwc_data3\":\"13\",\"mobileMpPtData1.xxfh_bzc_data1\":\"4\",\"mobileMpPtData1.xxfh_bzc_data2\":\"9\",\"mobileMpPtData1.xxfh_bzc_data3\":\"14\",\"mobileMpPtData1.xxfh_xwc_data1\":\"5\",\"mobileMpPtData1.xxfh_xwc_data2\":\"10\",\"mobileMpPtData1.xxfh_xwc_data3\":\"15\",\"mobileMpPtData1.sxfh_powerFactor\":\"16\",\"mobileMpPtData1.sxfh_testSecondLoad\":\"17\",\"mobileMpPtData1.sxfh_testSecondLoad1\":\"18\",\"mobileMpPtData1.sxfh_testSecondLoad2\":\"19\",\"mobileMpPtData1.xxfh_powerFactor\":\"20\",\"mobileMpPtData1.xxfh_testSecondLoad\":\"21\",\"mobileMpPtData1.xxfh_testSecondLoad1\":\"22\",\"mobileMpPtData1.xxfh_testSecondLoad2\":\"23\",\"mobileMpPtData2.phase\":\"B\",\"mobileMpPtData2.madeNo\":\"0920244-1\",\"mobileMpPtData2.rcRatioCodeName\":\"110/√3/0.1/√3kV\",\"mobileMpPtData2.ptPreCodeName\":\"0.2\",\"mobileMpPtData2.checkResult\":\"01\",\"mobileMpPtData2.testPoint1\":\"24\",\"mobileMpPtData2.testPoint2\":\"29\",\"mobileMpPtData2.testPoint3\":\"34\",\"mobileMpPtData2.sxfh_bzc_data1\":\"25\",\"mobileMpPtData2.sxfh_bzc_data2\":\"30\",\"mobileMpPtData2.sxfh_bzc_data3\":\"35\",\"mobileMpPtData2.sxfh_xwc_data1\":\"26\",\"mobileMpPtData2.sxfh_xwc_data2\":\"21\",\"mobileMpPtData2.sxfh_xwc_data3\":\"36\",\"mobileMpPtData2.xxfh_bzc_data1\":\"27\",\"mobileMpPtData2.xxfh_bzc_data2\":\"32\",\"mobileMpPtData2.xxfh_bzc_data3\":\"37\",\"mobileMpPtData2.xxfh_xwc_data1\":\"28\",\"mobileMpPtData2.xxfh_xwc_data2\":\"33\",\"mobileMpPtData2.xxfh_xwc_data3\":\"38\",\"mobileMpPtData2.sxfh_powerFactor\":\"39\",\"mobileMpPtData2.sxfh_testSecondLoad\":\"40\",\"mobileMpPtData2.sxfh_testSecondLoad1\":\"41\",\"mobileMpPtData2.sxfh_testSecondLoad2\":\"42\",\"mobileMpPtData2.xxfh_powerFactor\":\"43\",\"mobileMpPtData2.xxfh_testSecondLoad\":\"44\",\"mobileMpPtData2.xxfh_testSecondLoad1\":\"45\",\"mobileMpPtData2.xxfh_testSecondLoad2\":\"46\",\"mobileMpPtData3.phase\":\"C\",\"mobileMpPtData3.madeNo\":\"0920244-2\",\"mobileMpPtData3.rcRatioCodeName\":\"110/√3/0.1/√3kV\",\"mobileMpPtData3.ptPreCodeName\":\"0.2\",\"mobileMpPtData3.checkResult\":\"02\",\"mobileMpPtData3.testPoint1\":\"47\",\"mobileMpPtData3.testPoint2\":\"52\",\"mobileMpPtData3.testPoint3\":\"57\",\"mobileMpPtData3.sxfh_bzc_data1\":\"48\",\"mobileMpPtData3.sxfh_bzc_data2\":\"53\",\"mobileMpPtData3.sxfh_bzc_data3\":\"58\",\"mobileMpPtData3.sxfh_xwc_data1\":\"49\",\"mobileMpPtData3.sxfh_xwc_data2\":\"54\",\"mobileMpPtData3.sxfh_xwc_data3\":\"59\",\"mobileMpPtData3.xxfh_bzc_data1\":\"50\",\"mobileMpPtData3.xxfh_bzc_data2\":\"55\",\"mobileMpPtData3.xxfh_bzc_data3\":\"60\",\"mobileMpPtData3.xxfh_xwc_data1\":\"51\",\"mobileMpPtData3.xxfh_xwc_data2\":\"56\",\"mobileMpPtData3.xxfh_xwc_data3\":\"61\",\"mobileMpPtData3.sxfh_powerFactor\":\"62\",\"mobileMpPtData3.sxfh_testSecondLoad\":\"63\",\"mobileMpPtData3.sxfh_testSecondLoad1\":\"64\",\"mobileMpPtData3.sxfh_testSecondLoad2\":\"65\",\"mobileMpPtData3.xxfh_powerFactor\":\"66\",\"mobileMpPtData3.xxfh_testSecondLoad\":\"67\",\"mobileMpPtData3.xxfh_testSecondLoad1\":\"68\",\"mobileMpPtData3.xxfh_testSecondLoad2\":\"69\"}";
		Map<String, String> verificationDataMap = GsonUtil.jsonToMap(verificationData);
		String resultMsg = ptErrorVerService.addOrUpdateVerificationData(verificationDataMap);
		log.info("新增/修改PT误差检定数据：{}", resultMsg);
	}

	/**
	 * 删除检定数据
	 */
	@Test
	public void testDeleteVerificationData() {
		String resultMsg = ptErrorVerService.deleteVerificationData(538814L, 1453L);
		log.info("删除PT误差检定数据：{}", resultMsg);
	}
}