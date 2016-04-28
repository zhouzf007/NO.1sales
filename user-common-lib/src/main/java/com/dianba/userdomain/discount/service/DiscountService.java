package com.dianba.userdomain.discount.service;

import java.util.Map;

public interface DiscountService {
	
	public Map<String, Object> getMemberSubtractMoney(long userId,String money,String merchantId,String saleType);
	
}
