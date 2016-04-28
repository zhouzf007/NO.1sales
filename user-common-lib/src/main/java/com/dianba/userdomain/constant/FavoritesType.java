package com.dianba.userdomain.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum FavoritesType {

	/**
	 * 菜品
	 */
	MENU(1, "菜品"),
	/**
	 * 商家
	 */
	MERCHANT(2, "商家");
	

	private int id;

	private String name;

	private static Map<Integer, String> map = new HashMap<Integer, String>();

	private static List<FavoritesType> list = new ArrayList<FavoritesType>();

	static {
		for (FavoritesType status : FavoritesType.values()) {
			map.put(status.getId(), status.getName());
		}
		list.addAll(Arrays.asList(FavoritesType.values()));
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

	private FavoritesType(int id, String name) {
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
	public static List<FavoritesType> getList() {
		return list;
	}

	/**
	 * 根据id获取枚举类型
	 * 
	 * @param id
	 * @return
	 */
	public static FavoritesType getCategory(int id) {
		for (FavoritesType status : list) {
			if (status.getId() == id) {
				return status;
			}
		}
		return null;
	}

}
