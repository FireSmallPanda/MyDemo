package cn.danywer.util;

import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommonUtil {
	/**
	 * 获取请求ip
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1")
					|| ipAddress.equals("0:0:0:0:0:0:0:1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
															// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}

	/**
	 * 检测管理员状态
	 * 
	 * @param request
	 * @return
	 */
	public static Boolean getAdminFlag(HttpServletRequest request) {
		HttpSession session = request.getSession(); // session
		String adminFlag = (String) session.getAttribute("adminFlag");
		if ("ADMIN".equals(adminFlag)) {
			return true;

		} else {
			return false;
		}
	}

	/**
	 * 判断是否存在中文
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isContainChinese(String str) {

		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}

	public static Double getTaxMoney(double money, String type) {
		double retnMoney = 0.0;
		if ("finish".equals(type)) {// 违约计算 违约收取5%佣金
			double[] tax = { 0.05 };

			retnMoney = money * (1 - tax[0]);
		} else { // 默认为违约
			double[] tax = { 0.00 };

			retnMoney = money * (1 - tax[0]);

		}
		// 保留两位小数
		BigDecimal b = new BigDecimal(retnMoney);
		retnMoney = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return retnMoney;

	}

	/**
	 * 查询是否为管理员
	 * 
	 * @param request
	 * @return
	 */
	public static boolean checkAdmin(HttpServletRequest request) {
		HttpSession session = request.getSession(); // session
		if ("ADMIN".equals(session.getAttribute("adminFlag"))) {

			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		System.out.println(stampToDate(new Date()));

	}

	/*
	 * 将时间戳转换为时间
	 */
	public static String stampToDate(Date s) {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyyMMddHHmmss");
		res = simpleDateFormat.format(s);
		return res;
	}

	/**
	 * 获取页面大小
	 * @param count
	 * @param pageSize
	 * @return
	 */
	public static Integer getPage(Long count,int pageSize) {
		int iPageCount= Integer.parseInt(String.valueOf(count)) /pageSize ;
		int mod=iPageCount %pageSize ;
		if(mod>0){
			iPageCount++;
		}
		return  iPageCount;
	}

}
