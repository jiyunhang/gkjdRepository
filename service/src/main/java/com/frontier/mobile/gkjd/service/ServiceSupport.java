package com.frontier.mobile.gkjd.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.frontier.mobile.gkjd.service.exception.GkjdSystemException;

import lombok.extern.slf4j.Slf4j;

/**
 * 关口检定服务支持类
 * 
 * @author 纪云行
 */
@Slf4j
public class ServiceSupport {
	/**
	 * 发送get请求
	 * 
	 * @param url 包含参数的请求地址
	 * @return JSON格式响应字符串
	 */
	protected String sendGetRequest(String url) {
		log.info("GET方式请求地址：{}", url);
		String responseContent = null;
		CloseableHttpClient client = createHttpClient();
		try {
			HttpGet get = new HttpGet(url.trim());
			try {
				CloseableHttpResponse response = null;
				try {
					response = client.execute(get);
					HttpEntity responseEntity = response.getEntity();
					responseContent = EntityUtils.toString(responseEntity);
					EntityUtils.consume(responseEntity);
				} catch (ClientProtocolException e) {
					log.error("客户端协议异常：{}", e);
					throw new GkjdSystemException("客户端协议异常：" + e.getMessage());
				} catch (IOException e) {
					log.error("输入输出异常：{}", e);
					throw new GkjdSystemException("输入输出异常：" + e.getMessage());
				} finally {
					IOUtils.closeQuietly(response);
				}
			} finally {
				get.releaseConnection();
			}
		} finally {
			IOUtils.closeQuietly(client);
		}
		log.info("GET方式响应数据：{}", responseContent);
		return responseContent;
	}

	/**
	 * 发送post请求
	 * 
	 * @param paramMap post请求参数map
	 * @param url 包含参数的请求地址
	 * @return 成功或失败
	 */
	protected String sendPostRequest(Map<String, String> paramMap, String url) {
		log.info("POST方式请求地址：{}", url);
		log.info("POST方式请求参数：{}", paramMap);
		String responseContent = null;
		CloseableHttpClient client = createHttpClient();
		try {
			HttpPost post = new HttpPost(url.trim());
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			if (!paramMap.isEmpty()) {
				Set<Entry<String, String>> entrySet = paramMap.entrySet();
				Iterator<Entry<String, String>> iter = entrySet.iterator();
				while (iter.hasNext()) {
					Entry<String, String> entry = iter.next();
					nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
				}
			}
			try {
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvps, "UTF-8");
				post.setEntity(entity);
			} catch (UnsupportedEncodingException e) {
				log.error("不支持的编码异常：{}", e);
				throw new GkjdSystemException("不支持的编码异常：" + e.getMessage());
			}
			try {
				CloseableHttpResponse response = null;
				try {
					response = client.execute(post);
					HttpEntity responseEntity = response.getEntity();
					responseContent = EntityUtils.toString(responseEntity);
					EntityUtils.consume(responseEntity);
				} catch (ClientProtocolException e) {
					log.error("客户端协议异常：{}", e);
					throw new GkjdSystemException("客户端协议异常：" + e.getMessage());
				} catch (IOException e) {
					log.error("输入输出异常：{}", e);
					throw new GkjdSystemException("输入输出异常：" + e.getMessage());
				} finally {
					IOUtils.closeQuietly(response);
				}
			} finally {
				post.releaseConnection();
			}
		} finally {
			IOUtils.closeQuietly(client);
		}
		log.info("POST方式响应数据：{}", responseContent);
		return responseContent;
	}
	
	/**
	 * Map转换操作（在进行post提交时，将元素的name前面加上bean的前缀，方便服务端进行bean的赋值）
	 * 
	 * @param map 待转换的map
	 * @param beanPrefix bean的前缀名
	 * @return 加上bean前缀转换后的map
	 */
	protected Map<String, String> wrapKeyForMap(Map<String, String> map, String beanPrefix) {
		Map<String, String> dataMap = new HashMap<String, String>();
		Set<Entry<String, String>> dataSet = map.entrySet();
		Iterator<Entry<String, String>> iter = dataSet.iterator();
		while (iter.hasNext()) {
			Entry<String, String> entry = iter.next();
			// 对象名.属性名，方面struts赋值
			dataMap.put(beanPrefix + "." + entry.getKey(), entry.getValue());
		}
		return dataMap;
	}
	
	/**
	 * 创建HttpClient
	 * 
	 * @return HttpClient实例
	 */
	private CloseableHttpClient createHttpClient() {
		return HttpClients.createDefault();
	}
}