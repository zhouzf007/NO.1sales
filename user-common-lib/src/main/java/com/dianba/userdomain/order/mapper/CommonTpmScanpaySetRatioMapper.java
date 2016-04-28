package com.dianba.userdomain.order.mapper;

import java.util.List;

import com.dianba.userdomain.order.entity.TpmScanpaySetRatio;
import com.dianba.web.repository.MyBatisRepository;

@MyBatisRepository
public interface CommonTpmScanpaySetRatioMapper {
    public List<TpmScanpaySetRatio> getMerchantProportion(Integer merchantId);
}
