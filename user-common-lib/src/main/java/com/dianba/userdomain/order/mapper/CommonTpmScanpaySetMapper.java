package com.dianba.userdomain.order.mapper;

import com.dianba.userdomain.order.entity.TpmScanpaySet;
import com.dianba.web.repository.MyBatisRepository;

@MyBatisRepository
public interface CommonTpmScanpaySetMapper{
	public Integer getMerchantMoneyMin(Integer merchantId);
	
	public TpmScanpaySet getTpmScanpaySetByPrimaryKey(Integer id);
}