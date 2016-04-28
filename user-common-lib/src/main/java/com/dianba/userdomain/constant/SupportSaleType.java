package com.dianba.userdomain.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商家支持的销售类型
 */
public enum SupportSaleType {
	/**
	 * 都支持
	 */
	BOTH(1, "都支持"),
	/**
	 * 外卖
	 */
	WM(2, "外卖"),
	/**
	 * 门店
	 */
	TS(3, "门店"),
	
	/**
	 * 私厨上门自提
	 */
	SMZT(4, "上门自提");

	private int id;

	private String name;

	private static Map<Integer, String> map = new HashMap<Integer, String>();

	private static List<SupportSaleType> list = new ArrayList<SupportSaleType>();

	static {
		for (SupportSaleType status : SupportSaleType.values()) {
			map.put(status.getId(), status.getName());
		}
		list.addAll(Arrays.asList(SupportSaleType.values()));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private SupportSaleType(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * 返回map类型形式
	 * 
	 * @return
	 */
	public static Map<Integer, String> getMap() {
		return map;
	}

	/**
	 * 返回list类型形式
	 * 
	 * @return
	 */
	public static List<SupportSaleType> getList() {
		return list;
	}

	/**
	 * 根据id获取枚举类型
	 * 
	 * @param id
	 * @return
	 */
	public static SupportSaleType getCategory(int id) {
		for (SupportSaleType status : list) {
			if (status.getId() == id) {
				return status;
			}
		}
		return null;
	}
}
