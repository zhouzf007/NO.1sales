package com.dianba.userdomain.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商家来源类型
 */
public enum MerchantSourceType {
	/**
	 * 默认商家
	 */
	BOTH(0, "默认商家"),
	/**
	 * 乡村基商家
	 */
	WM(1, "乡村基商家"),
	/**
	 * 私厨
	 */
	TS(2, "私厨");

	private int id;

	private String name;

	private static Map<Integer, String> map = new HashMap<Integer, String>();

	private static List<MerchantSourceType> list = new ArrayList<MerchantSourceType>();

	static {
		for (MerchantSourceType status : MerchantSourceType.values()) {
			map.put(status.getId(), status.getName());
		}
		list.addAll(Arrays.asList(MerchantSourceType.values()));
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

	private MerchantSourceType(int id, String name) {
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
	public static List<MerchantSourceType> getList() {
		return list;
	}

	/**
	 * 根据id获取枚举类型
	 * 
	 * @param id
	 * @return
	 */
	public static MerchantSourceType getCategory(int id) {
		for (MerchantSourceType status : list) {
			if (status.getId() == id) {
				return status;
			}
		}
		return null;
	}
}
