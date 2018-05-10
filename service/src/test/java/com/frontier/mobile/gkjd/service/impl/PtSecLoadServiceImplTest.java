package com.frontier.mobile.gkjd.service.impl;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.frontier.mobile.gkjd.common.GsonUtil;
import com.frontier.mobile.gkjd.service.PtSecLoadService;

import lombok.extern.slf4j.Slf4j;

/**
 * PT二次负荷服务测试类
 * 
 * @author 纪云行
 */
@Slf4j
public class PtSecLoadServiceImplTest {
	/**
	 * PT二次负荷服务接口
	 */
	private static PtSecLoadService ptSecLoadService;

	/**
	 * 初始化资源
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		ptSecLoadService = new PtSecLoadServiceImpl();
	}

	/**
	 * 清理资源
	 */
	@AfterClass
	public static void tearDownAfterClass() {
		ptSecLoadService = null;
	}

	/**
	 * 查询检定数据
	 */
	@Test
	public void testListVerificationData() {
		String resultMsg = ptSecLoadService.listVerificationData(168939L, 105574L, 993500L);
		log.info("查询PT二次负荷检定数据：{}", resultMsg);
	}

	/**
	 * 新增/修改检定数据
	 */
	@Test
	public void testAddOrUpdateVerificationData() {
		String verificationData = "{\"mpPtSecLoadCommon.cerNo\":\"1\",\"mpPtSecLoadCommon.checkDate\":\"2018-01-09\",\"mpPtSecLoadCommon.checkUserId1\":800000001,\"mpPtSecLoadCommon.deviceId\":175,\"mpPtSecLoadCommon.editUser\":\"1\",\"mpPtSecLoadCommon.examineUserId\":\"\",\"mpPtSecLoadCommon.humidity\":\"1\",\"mpPtSecLoadCommon.notes\":\"\",\"mpPtSecLoadCommon.periodId\":814842,\"mpPtSecLoadCommon.temperature\":\"1\",\"mpPtSecLoadCommon.testUnitId\":10000000775555,\"mpPtSecLoadCommon.itSetId\":1450,\"mpPtSecLoadCommon.measurePointId\":488,\"mpPtSecLoadCommon.stationId\":640,\"mpPtSecLoadData1.phase\":\"A\",\"mpPtSecLoadData1.manuNo\":\"0920244-4\",\"mpPtSecLoadData1.itId\":117801,\"mpPtSecLoadData1.lineTypeAcreage\":4,\"mpPtSecLoadData1.lineTypeCores\":1,\"mpPtSecLoadData1.lineLength\":150,\"mpPtSecLoadData1.powerCurrent\":\"\",\"mpPtSecLoadData1.powerFactor\":\"\",\"mpPtSecLoadData1.powerVolt\":\"\",\"mpPtSecLoadData1.G\":\"\",\"mpPtSecLoadData1.realLoad\":\"\",\"mpPtSecLoadData1.S\":\"\",\"mpPtSecLoadData2.phase\":\"B\",\"mpPtSecLoadData2.manuNo\":\"0920244-1\",\"mpPtSecLoadData2.itId\":117803,\"mpPtSecLoadData2.lineTypeAcreage\":4,\"mpPtSecLoadData2.lineTypeCores\":1,\"mpPtSecLoadData2.lineLength\":150,\"mpPtSecLoadData2.powerCurrent\":\"\",\"mpPtSecLoadData2.powerFactor\":\"\",\"mpPtSecLoadData2.powerVolt\":\"\",\"mpPtSecLoadData2.G\":\"\",\"mpPtSecLoadData2.realLoad\":\"\",\"mpPtSecLoadData2.S\":\"\",\"mpPtSecLoadData3.phase\":\"C\",\"mpPtSecLoadData3.manuNo\":\"0920244-2\",\"mpPtSecLoadData3.itId\":117805,\"mpPtSecLoadData3.lineTypeAcreage\":4,\"mpPtSecLoadData3.lineTypeCores\":1,\"mpPtSecLoadData3.lineLength\":150,\"mpPtSecLoadData3.powerCurrent\":\"\",\"mpPtSecLoadData3.powerFactor\":\"\",\"mpPtSecLoadData3.powerVolt\":\"\",\"mpPtSecLoadData3.G\":\"\",\"mpPtSecLoadData3.realLoad\":\"\",\"mpPtSecLoadData3.S\":\"\"}";
		Map<String, String> verificationDataMap = GsonUtil.jsonToMap(verificationData);
		String resultMsg = ptSecLoadService.addOrUpdateVerificationData(verificationDataMap);
		log.info("新增/修改PT二次负荷检定数据：{}", resultMsg);
	}

	/**
	 * 删除检定数据
	 */
	@Test
	public void testDeleteVerificationData() {
		String resultMsg = ptSecLoadService.deleteVerificationData(102769L, 105574L, 105024L, 993500L);
		log.info("删除PT二次负荷检定数据：{}", resultMsg);
	}
}