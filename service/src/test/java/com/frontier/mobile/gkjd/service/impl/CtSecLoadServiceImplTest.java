package com.frontier.mobile.gkjd.service.impl;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.frontier.mobile.gkjd.common.GsonUtil;
import com.frontier.mobile.gkjd.service.CtSecLoadService;

import lombok.extern.slf4j.Slf4j;

/**
 * CT二次负荷服务测试类
 * 
 * @author 纪云行
 */
@Slf4j
public class CtSecLoadServiceImplTest {
	/**
	 * CT二次负荷服务接口
	 */
	private static CtSecLoadService ctSecLoadService;

	/**
	 * 初始化资源
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		ctSecLoadService = new CtSecLoadServiceImpl();
	}

	/**
	 * 清理资源
	 */
	@AfterClass
	public static void tearDownAfterClass() {
		ctSecLoadService = null;
	}

	/**
	 * 查询检定数据
	 */
	@Test
	public void testListVerificationData() {
		String resultMsg = ctSecLoadService.listVerificationData(2001L, 3213L, 4532L);
		log.info("查询CT二次负荷检定数据：{}", resultMsg);
	}

	/**
	 * 新增/修改检定数据
	 */
	@Test
	public void testAddOrUpdateVerificationData() {
		String verificationData = "{\"mpCtSecLoadCommon.cerNo\":\"123\",\"mpCtSecLoadCommon.checkDate\":\"2018-01-03\",\"mpCtSecLoadCommon.checkUserId1\":913669569,\"mpCtSecLoadCommon.deviceId\":89,\"mpCtSecLoadCommon.editUser\":\"123\",\"mpCtSecLoadCommon.examineUserId\":913480119,\"mpCtSecLoadCommon.humidity\":\"123\",\"mpCtSecLoadCommon.measurePointId\":0,\"mpCtSecLoadCommon.notes\":\"\",\"mpCtSecLoadCommon.periodId\":0,\"mpCtSecLoadCommon.resultId\":\"\",\"mpCtSecLoadCommon.temperature\":\"123\",\"mpCtSecLoadCommon.testUnitId\":10000000775555,\"mpCtSecLoadCommon.itSetId\":0,\"mpCtSecLoadData1.phase\":\"A\",\"mpCtSecLoadData1.manuNo\":\"0920244-4\",\"mpCtSecLoadData1.lineTypeAcreage\":\"4\",\"mpCtSecLoadData1.lineTypeCores\":\"1\",\"mpCtSecLoadData1.lineLength\":\"150\",\"mpCtSecLoadData1.powerCurrent\":0,\"mpCtSecLoadData1.powerFactor\":0,\"mpCtSecLoadData1.powerVolt\":0,\"mpCtSecLoadData1.r\":0,\"mpCtSecLoadData1.realLoad\":0,\"mpCtSecLoadData1.x\":0,\"mpCtSecLoadData2.phase\":\"B\",\"mpCtSecLoadData2.manuNo\":\"0920244-1\",\"mpCtSecLoadData2.lineTypeAcreage\":\"4\",\"mpCtSecLoadData2.lineTypeCores\":\"1\",\"mpCtSecLoadData2.lineLength\":\"150\",\"mpCtSecLoadData2.powerCurrent\":0,\"mpCtSecLoadData2.powerFactor\":0,\"mpCtSecLoadData2.powerVolt\":0,\"mpCtSecLoadData2.r\":0,\"mpCtSecLoadData2.realLoad\":0,\"mpCtSecLoadData2.x\":0,\"mpCtSecLoadData3.phase\":\"C\",\"mpCtSecLoadData3.manuNo\":\"0920244-2\",\"mpCtSecLoadData3.lineTypeAcreage\":\"4\",\"mpCtSecLoadData3.lineTypeCores\":\"1\",\"mpCtSecLoadData3.lineLength\":\"150\",\"mpCtSecLoadData3.powerCurrent\":0,\"mpCtSecLoadData3.powerFactor\":0,\"mpCtSecLoadData3.powerVolt\":0,\"mpCtSecLoadData3.r\":0,\"mpCtSecLoadData3.realLoad\":0,\"mpCtSecLoadData3.x\":0}";
		Map<String, String> verificationDataMap = GsonUtil.jsonToMap(verificationData);
		String resultMsg = ctSecLoadService.addOrUpdateVerificationData(verificationDataMap);
		log.info("新增/修改CT二次负荷检定数据：{}", resultMsg);
	}

	/**
	 * 删除检定数据
	 */
	@Test
	public void testDeleteVerificationData() {
		String resultMsg = ctSecLoadService.deleteVerificationData(123456L, 105016L, 2332L);
		log.info("删除CT二次负荷检定数据：{}", resultMsg);
	}
}