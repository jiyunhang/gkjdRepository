package com.frontier.mobile.gkjd.webservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

/**
 * 关口检定WebService测试类
 * 
 * @author 纪云行
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class GkjdWebServiceImplTest {
	/**
	 * 关口检定服务接口
	 */
	@Autowired
	private GkjdWebService gkjdWebService;

	/**
	 * 获取数据
	 */
	@Test
	public void testGetData() {
		String requestJsonStr = null;
		String responseJsonStr = null;
		
//		requestJsonStr = "{\"MOD\":\"3001\", \"FUN\":\"0101\", \"PKG_TYPE\":\"0\", \"USR\":\"125153\", \"ORG_NO\":\"3241201\", \"PKG\":{}}";
//		responseJsonStr = gkjdWebService.getData(requestJsonStr);
//		log.info("查询所有统调电厂列表响应报文：{}", responseJsonStr);
		
//		requestJsonStr = "{\"MOD\":\"3001\", \"FUN\":\"0102\", \"PKG_TYPE\":\"0\", \"USR\":\"125153\", \"ORG_NO\":\"3241201\", \"PKG\":{}}";
//		responseJsonStr = gkjdWebService.getData(requestJsonStr);
//		log.info("查询测试单位列表响应报文：{}", responseJsonStr);
		
//		requestJsonStr = "{\"MOD\":\"3001\", \"FUN\":\"0103\", \"PKG_TYPE\":\"0\", \"USR\":\"125153\", \"ORG_NO\":\"3241201\", \"PKG\":{}}";
//		responseJsonStr = gkjdWebService.getData(requestJsonStr);
//		log.info("查询检验员、核验员列表响应报文：{}", responseJsonStr);
		
//		requestJsonStr = "{\"MOD\":\"3001\", \"FUN\":\"0104\", \"PKG_TYPE\":\"0\", \"USR\":\"125153\", \"ORG_NO\":\"3241201\", \"PKG\":{}}";
//		responseJsonStr = gkjdWebService.getData(requestJsonStr);
//		log.info("查询设备信息响应报文：{}", responseJsonStr);
		
//		requestJsonStr = "{\"MOD\":\"3001\", \"FUN\":\"0105\", \"PKG_TYPE\":\"0\", \"USR\":\"125153\", \"ORG_NO\":\"3241201\", \"PKG\":{\"stationId\":\"\", \"itSetType\":\"\", \"moduleType\":1}}";
//		responseJsonStr = gkjdWebService.getData(requestJsonStr);
//		log.info("查询关口列表响应报文：{}", responseJsonStr);
		
//		requestJsonStr = "{\"MOD\":\"3001\", \"FUN\":\"0201\", \"PKG_TYPE\":\"0\", \"USR\":\"125153\", \"ORG_NO\":\"3241201\", \"PKG\":{\"stationId\":992677, \"primaryId\":1041, \"moduleType\":1}}";
//		responseJsonStr = gkjdWebService.getData(requestJsonStr);
//		log.info("查询检定列表响应报文：{}", responseJsonStr);
		
//		requestJsonStr = "{\"MOD\":\"3001\", \"FUN\":\"0202\", \"PKG_TYPE\":\"0\", \"USR\":\"125153\", \"ORG_NO\":\"3241201\", \"PKG\":{\"moduleType\":3, \"stationId\":990042, \"checkType\":\"01\", \"yearIndex\":2017, \"itSetId\": \"524\"}}";
//		responseJsonStr = gkjdWebService.getData(requestJsonStr);
//		log.info("新增检定任务响应报文：{}", responseJsonStr);
		
//		requestJsonStr = "{\"MOD\":\"3001\", \"FUN\":\"0203\", \"PKG_TYPE\":\"0\", \"USR\":\"125153\", \"ORG_NO\":\"3241201\", \"PKG\":{\"periodId\":814012, \"moduleType\":1}}";
//		responseJsonStr = gkjdWebService.getData(requestJsonStr);
//		log.info("删除检定任务响应报文：{}", responseJsonStr);
		
		requestJsonStr = "{\"MOD\":\"3001\",\"FUN\":\"0502\",\"PKG_TYPE\":\"0\",\"ORG_NO\":\"3240101\",\"USR\":\"03000001\",\"IS_WX_USER\":\"1\",\"PKG\":{\"mpCtSecLoadCommon.cerNo\":\"JL-FC-2008-0011\",\"mpCtSecLoadCommon.testUnitId\":704639,\"mpCtSecLoadCommon.notes\":\"线排太紧\",\"mpCtSecLoadCommon.deviceId\":89,\"mpCtSecLoadCommon.resultId\":\"\",\"mpCtSecLoadCommon.examineUserId\":913480119,\"mpCtSecLoadCommon.checkUserId1\":370656,\"mpCtSecLoadCommon.checkDate\":\"2008-11-19\",\"mpCtSecLoadCommon.humidity\":\"39\",\"mpCtSecLoadCommon.temperature\":\"11\",\"mpCtSecLoadCommon.periodId\":2744,\"mpCtSecLoadCommon.itSetId\":486,\"mpCtSecLoadCommon.measurePointId\":492,\"mpCtSecLoadCommon.editUser\":\"123\",\"mpCtSecLoadData1.realLoad\":0,\"mpCtSecLoadData1.powerFactor\":0,\"mpCtSecLoadData1.x\":0,\"mpCtSecLoadData1.r\":0,\"mpCtSecLoadData1.powerCurrent\":0,\"mpCtSecLoadData1.powerVolt\":0,\"mpCtSecLoadData1.lineLength\":\"\",\"mpCtSecLoadData1.lineTypeAcreage\":\"6\",\"mpCtSecLoadData1.lineTypeCores\":\"1\",\"mpCtSecLoadData1.itId\":1030000004095,\"mpCtSecLoadData1.phase\":\"A\",\"mpCtSecLoadData2.realLoad\":0,\"mpCtSecLoadData2.powerFactor\":0,\"mpCtSecLoadData2.x\":0,\"mpCtSecLoadData2.r\":0,\"mpCtSecLoadData2.powerCurrent\":0,\"mpCtSecLoadData2.powerVolt\":0,\"mpCtSecLoadData2.lineLength\":\"\",\"mpCtSecLoadData2.lineTypeAcreage\":\"6\",\"mpCtSecLoadData2.lineTypeCores\":\"1\",\"mpCtSecLoadData2.itId\":1030000004096,\"mpCtSecLoadData2.phase\":\"B\",\"mpCtSecLoadData3.realLoad\":0,\"mpCtSecLoadData3.powerFactor\":0,\"mpCtSecLoadData3.x\":0,\"mpCtSecLoadData3.r\":0,\"mpCtSecLoadData3.powerCurrent\":0,\"mpCtSecLoadData3.powerVolt\":0,\"mpCtSecLoadData3.lineLength\":\"\",\"mpCtSecLoadData3.lineTypeAcreage\":\"6\",\"mpCtSecLoadData3.lineTypeCores\":\"1\",\"mpCtSecLoadData3.itId\":1030000004097,\"mpCtSecLoadData3.phase\":\"C\"}}";
		responseJsonStr = gkjdWebService.getData(requestJsonStr);
		log.info("新增CT二次负荷检定数据响应报文：{}", responseJsonStr);
	}
}