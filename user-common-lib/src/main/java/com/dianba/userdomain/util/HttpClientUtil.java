package com.dianba.userdomain.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.dianba.userdomain.commons.entity.AjaxJson;

public class HttpClientUtil {

	public static Logger logger = LoggerFactory.getLogger( HttpClientUtil.class );

	private static MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();

	private static HttpClient httpClient = new HttpClient( connectionManager );

	private final static String ENCODING = "UTF-8";

	private final static int newTimeoutInMilliseconds = 30 * 1000;

	public static String post( String url, List<NameValuePair> nameValuePairs ) {
		PostMethod postMethod = new PostMethod( url );
		postMethod.getParams().setParameter( HttpMethodParams.HTTP_CONTENT_CHARSET, ENCODING );
		if( nameValuePairs != null && !nameValuePairs.isEmpty() ) {
			postMethod.addParameters( nameValuePairs.toArray( new NameValuePair[nameValuePairs.size()] ) );
		}
		return executeMethod( postMethod );
	} 
	
	/**
	 * 获取完整的带参数的url
	 * 
	 * @param url 例如:http://www.baidu.com/
	 * @param paramMap
	 * @return 返回值 例如: http://www.baidu.com/?name=hello&pwd=XMSDX322ZSD
	 */
	public static String getParamUrl( String url, Map<String, String> paramMap ) {
		StringBuffer sb = new StringBuffer();
		if( paramMap == null || paramMap.isEmpty() ) {
			return "";
		}
		else {
			for( String key : paramMap.keySet() ) {
				String value = paramMap.get( key );
				if( sb.length() < 1 ) {
					sb.append( key ).append( "=" ).append( value );
				}
				else {
					sb.append( "&" ).append( key ).append( "=" ).append( value );
				}
			}
			return url += "?" + sb.toString();
		}
	}

	/**
	 * Map转List< NameValuePair >
	 * 
	 * @param paramMap
	 * @return
	 */
	public static List<NameValuePair> getNameValuePairList( Map<String, String> paramMap ) {
		if( paramMap == null || paramMap.isEmpty() ) {
			return null;
		}
		List<NameValuePair> lsNameValuePair = new ArrayList<NameValuePair>();
		for( Entry<String, String> entry : paramMap.entrySet() ) {
			lsNameValuePair.add( new NameValuePair( entry.getKey(), entry.getValue() ) );
		}
		return lsNameValuePair;
	}

	public static String get( String url, Header header ) {
		GetMethod getMethod = new GetMethod( url );
		getMethod.addRequestHeader( header );
		return executeMethod( getMethod );
	}

	public static String get( String url ) {
		GetMethod getMethod = new GetMethod( url );
		return executeMethod( getMethod );
	}

	public static String get( String url, Map<String, String> paramMap ) {
		String urlParam = getParamUrl( url, paramMap );
		return get( urlParam );
	}

	public static String uploadFile( String url, List<NameValuePair> nameValuePairs, File file ) {
		if( !file.exists() ) {
			return null;
		}
		PostMethod postMethod = new PostMethod( url );
		postMethod.getParams().setParameter( HttpMethodParams.HTTP_CONTENT_CHARSET, ENCODING );
		try {
			// FilePart：用来上传文件的类
			FilePart fp = new FilePart( "filedata", file );
			Part[] parts = new Part[nameValuePairs.size() + 1];
			if( nameValuePairs != null && !nameValuePairs.isEmpty() ) {
				for( int i = 0; i < nameValuePairs.size(); i++ ) {
					StringPart param = new StringPart( nameValuePairs.get( i ).getName(), nameValuePairs.get( i ).getValue() );
					parts[i] = param;
				}
			}
			parts[parts.length - 1] = fp;
			// 对于MIME类型的请求，httpclient建议全用MulitPartRequestEntity进行包装
			MultipartRequestEntity mre = new MultipartRequestEntity( parts, postMethod.getParams() );
			postMethod.setRequestEntity( mre );

		}
		catch( FileNotFoundException e ) {
			logger.error( e.getMessage(), e );
			return null;
		}
		catch( Exception e ) {
			logger.error( e.getMessage(), e );
			return null;
		}
		return executeMethod( postMethod );
	}

	private static String executeMethod( HttpMethod httpMethod ) {
		String result = "";
		try {
			// 设置连接时间
			httpClient.getHttpConnectionManager().getParams().setConnectionTimeout( newTimeoutInMilliseconds );
			int statusCode = httpClient.executeMethod( httpMethod );
			logger.info( " Status Code is " + statusCode );
			if( statusCode == HttpStatus.SC_OK ) {
				result = httpMethod.getResponseBodyAsString();
				// logger.info( result );
			}
		}
		catch( HttpException e ) {
			logger.error( e.getMessage() );
		}
		catch( IOException e ) {
			logger.error( e.getMessage() );
		}
		finally {
			httpMethod.releaseConnection();
		}
		return result;
	}

	/**
	 * 循环获取request的参数值并转成普通Map
	 * 
	 * @param request
	 */
	public static Map<String, String> getParamterMap( HttpServletRequest request ) {
		Map<String, String[]> map = request.getParameterMap();
		// 返回值Map
		Map<String, String> returnMap = new LinkedHashMap<String, String>();
		Iterator<Entry<String, String[]>> entries = map.entrySet().iterator();
		Entry<String, String[]> entry;
		String name = "";
		String value = "";
		while( entries.hasNext() ) {
			entry = entries.next();
			name = entry.getKey();
			Object valueObj = entry.getValue();
			if( null == valueObj ) {
				value = "";
				continue;
			}
			else if( valueObj instanceof String[] ) {
				String[] values = (String[])valueObj;
				for( int i = 0; i < values.length; i++ ) {
					value = values[i] + ",";
				}
				value = value.substring( 0, value.length() - 1 );
			}
			else {
				value = valueObj.toString();
			}
			if( value != null && value.trim().length() > 0 ) {
				returnMap.put( name, value );
			}
		}
		return returnMap;
	}
	
	public static AjaxJson getAjaxJson( String url,Map<String, String> dataMap ) {
		GetMethod getMethod = new GetMethod( getParamUrl(url,dataMap) );
		String result = executeMethod( getMethod );
		AjaxJson ajaxJson = JSON.parseObject(result, AjaxJson.class);
		return ajaxJson;
	}
	
	public static AjaxJson postAjaxJson( String url,List<NameValuePair> nameValuePairs ) {
		PostMethod postMethod = new PostMethod( url );
		postMethod.getParams().setParameter( HttpMethodParams.HTTP_CONTENT_CHARSET, ENCODING );
		if( nameValuePairs != null && !nameValuePairs.isEmpty() ) {
			postMethod.addParameters( nameValuePairs.toArray( new NameValuePair[nameValuePairs.size()] ) );
		}
		String result = executeMethod( postMethod );
		AjaxJson ajaxJson = JSON.parseObject(result, AjaxJson.class);
		return ajaxJson;
	} 
}
