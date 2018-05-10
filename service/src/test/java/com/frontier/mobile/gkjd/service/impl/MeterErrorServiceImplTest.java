package com.frontier.mobile.gkjd.service.impl;

import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.frontier.mobile.gkjd.common.GsonUtil;
import com.frontier.mobile.gkjd.service.MeterErrorService;

import lombok.extern.slf4j.Slf4j;

/**
 * 电能表误差服务测试类
 * 
 * @author 纪云行
 */
@Slf4j
public class MeterErrorServiceImplTest {
	/**
	 * 电能表误差服务
	 */
	private static MeterErrorService meterErrorService;

	/**
	 * 初始化资源
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		meterErrorService = new MeterErrorServiceImpl();
	}

	/**
	 * 清理资源
	 */
	@AfterClass
	public static void tearDownAfterClass() {
		meterErrorService = null;
	}

	/**
	 * 查询检定数据
	 */
	@Test
	public void testListVerificationData() {
		String resultMsg = meterErrorService.listVerificationData(1000021354L, 105024L);
		log.info("查询电能表检定数据：{}", resultMsg);
	}

	/**
	 * 新增/修改检定数据
	 */
	@Test
	public void testAddOrUpdateVerificationData() {
		String verificationData = "{\"meterSerial\":0,\"meterId\":1010000032353,\"periodId\":4765,\"measurePointId\":488,\"cerNo\":\"JL-GK-2006-1010\",\"checkDate\":\"2006-01-04\",\"testUnitId\":10000000775555,\"temperature\":\"1\",\"humidity\":\"2\",\"editUser\":\"2\",\"checkUserId1\":170053,\"examineUserId\":370636,\"deviceId\":89,\"notes\":\"2\",\"madeNo\":\"79172802\",\"dMeterModel\":\"ZMU\",\"apPreLevelCode\":\"0.5\",\"appearance\":\"\",\"wiringResult\":\"\",\"measureResult\":\"\",\"secondVoltageA\":\"1\",\"secondVoltageB\":\"1\",\"secondVoltageC\":\"1\",\"secondCurrentA\":\"1\",\"secondCurrentB\":\"1\",\"secondCurrentC\":\"1\",\"error1\":\"1\",\"error2\":\"1\",\"errorR\":1,\"zhwcZValue\":\"\",\"zhwcFValue\":\"\",\"standardTimer\":\"\",\"meterTimer\":\"\",\"powerFactor\":\"1\",\"resultId\":\"02\"}";
		Map<String, String> verificationDataMap = GsonUtil.jsonToMap(verificationData);
		String resultMsg = meterErrorService.addOrUpdateVerificationData(verificationDataMap);
		log.info("新增/修改电能表检定数据：{}", resultMsg);
	}

	/**
	 * 删除检定数据
	 */
	@Test
	public void testDeleteVerificationData() {
		String resultMsg = meterErrorService.deleteVerificationData(1010000032353L, 488L, 4765L);
		log.info("删除电能表检定数据：{}", resultMsg);
	}
}