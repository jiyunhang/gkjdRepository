package com.frontier.mobile.gkjd.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 关口检定WebService服务接口
 * 
 * @author 纪云行
 */
@WebService(targetNamespace="http://platserver.mpbiffyx.frontier.com/")
public interface GkjdWebService {
	/**
	 * 获取数据
	 * 
	 * @param json 终端请求报文
	 * @return 终端响应报文
	 */
	String getData(@WebParam(name = "pkgData") String json);
}