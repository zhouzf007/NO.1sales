package com.dianba.userdomain.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.merchant.service.MerchantService;
import com.dianba.userdomain.sysdictionary.entity.SysCode;
import com.dianba.userdomain.sysdictionary.service.SysCodeService;
import com.dianba.userdomain.user.entity.Address;
import com.dianba.userdomain.user.mapper.CommonAddressMapper;
import com.dianba.userdomain.user.service.AddressService;
import com.dianba.userdomain.user.vo.AddressDetailVo;
import com.dianba.userdomain.util.ListUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional
public class CommonAddressServiceImpl implements AddressService {

	@Autowired
	private CommonAddressMapper addressMapper;
	
	@Autowired
	private SysCodeService sysCodeService;
	
	@Autowired
	private MerchantService merchantService;

	public List<Address> getAddressList() {
		return addressMapper.getAddressList();
	}

	public PageList<Address> getAddressList(PageBounds pageBounds) {
		return addressMapper.getAddressList(pageBounds);
	}

	public List<Address> getAddressPageList(Address address) {
		return addressMapper.getAddressPageList(address);
	}

	 public PageList<Address> getAddressPageList(Address address,
	 PageBounds pageBounds) {
	 return addressMapper.getAddressPageList(address, pageBounds);
	 }

	public Address getAddressByPrimaryKey(Long id) {
		return addressMapper.getAddressByPrimaryKey(id);
	}

	public void createAddress(Address address) {
		addressMapper.createAddress(address);
	}

	public void createAddressBitch(List<Address> addressList) {
		for (Address address : addressList) {
			addressMapper.createAddress(address);
		}
	}

	public void updateAddress(Address address) {
		addressMapper.updateAddress(address);
	}

	public void updateAddressBitch(List<Address> addressList) {
		for (Address address : addressList) {
			addressMapper.updateAddress(address);
		}
	}

	public void updateAddressSelective(Address address) {
		addressMapper.updateAddressSelective(address);
	}

	public void updateAddressSelectiveBitch(List<Address> addressList) {
		for (Address address : addressList) {
			addressMapper.updateAddressSelective(address);
		}
	}

	public void deleteAddress(Long id) {
		addressMapper.deleteAddress(id);
	}

	public void deleteAddressBitch(List<Long> idList) {
		for (Long id : idList) {
			addressMapper.deleteAddress(id);
		}
	}

	public AddressDetailVo getAddressById(Long id) {
		return addressMapper.getAddressById(id);
	}

	public AddressDetailVo getAddressByUserId(Long userId) {
		return addressMapper.getAddressByUserId(userId);
	}

	public void setDefaultAddress(Long id) {
		addressMapper.setDefaultAddress(id);

	}

	public List<Address> getDefaultAddress(Long id) {
		return addressMapper.getDefaultAddress(id);
	}

	public Long getMaxIdFromUserId(Integer id) {
		return addressMapper.getMaxIdFromUserId(id);
	}

	public Address isDefaultAddress(Long id) {
		return addressMapper.isDefaultAddress(id);
	}

	public void updateAddressSetDefaultByUserId(Integer userId) {
		addressMapper.updateAddressSetDefaultByUserId(userId);
	}

	@Override
	public List<Map<String, Object>> getAddressPageList(Integer userId) {
		List<Address> addList = getAddressPageList(new Address(userId));
		SysCode code = new SysCode();
		code.setCode("address_type");
		List<SysCode> codeList = sysCodeService.getSysCodePageList(code);
		Map<String, String> typeMap = new HashMap<String, String>();
		// 初始化地址标签静态数据
		for (int i = 0; i < codeList.size(); i++) {
			typeMap.put(codeList.get(i).getCodeValue(), codeList.get(i).getCodeName());
		}
		// 构建出参
		List<Map<String, Object>> addressList = new ArrayList<Map<String, Object>>();
		if (ListUtil.isNotNullOrEmpty(addList)) {
			for (Address ar : addList) {
				Map<String, Object> arm = new HashMap<String, Object>();
				String isDefaultAddress = ar.getIsDefault();
				if (isDefaultAddress != null) {
					arm.put("isDefaultAddress", isDefaultAddress);
				}
				arm.put("id", ar.getId());// 地址ID
				arm.put("userId", ar.getUserId());// 用户ID
				arm.put("name", ar.getName());// 姓名
				arm.put("mobile", ar.getMobile());// 电话
				arm.put("sex", ar.getSex());// 性别
				arm.put("buildingName",ar.getBuildingName());// (已更改为百度地图地址名称)
				// addressDetail 由 大楼信息 + 用户自主添加信息组合而成
				arm.put("addressDetail", ar.getBuildingName()==null?""+ ar.getAddressDetail():ar.getBuildingName()+ " " + ar.getAddressDetail());// 地址详情
				arm.put("longitude", ar.getLongitude());// 经度
				arm.put("latitude", ar.getLatitude());// 纬度
				arm.put("addressTypeCode", ar.getAddressType());// '地址标签：1:公司/2:家/3:无/4:学校
				arm.put("addressTypeName", typeMap.get(ar.getAddressType().toString()));// '地址标签：1:公司/2:家/3:无/4:学校
				addressList.add(arm);
			}
		}
		return addressList;
	}

	@Override
	public List<Map<String, Object>> getAddressValidatedList(Integer userId, long merchantId) {
		List<Address> addList = getAddressPageList(new Address(userId));
		// 构建出参
		List<Map<String, Object>> addressList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> deliverableAddress = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> undeliverableAddress = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> unavailableAddress = new ArrayList<Map<String, Object>>();
		SysCode code = new SysCode();
		code.setCode("address_type");
		List<SysCode> codeList = sysCodeService.getSysCodePageList(code);
		// 初始化地址标签静态数据
		Map<String, String> typeMap = new HashMap<String, String>();
		for (int i = 0; i < codeList.size(); i++) {
			typeMap.put(codeList.get(i).getCodeValue(), codeList.get(i).getCodeName());
		}
		if (ListUtil.isNotNullOrEmpty(addList)) {
			for (Address ar : addList) {
				Map<String, Object> arm = new HashMap<String, Object>();
				String isDefaultAddress = ar.getIsDefault();
				if (isDefaultAddress != null) {
					arm.put("isDefaultAddress", isDefaultAddress);
				}
				arm.put("id", ar.getId());// 地址ID
				arm.put("userId", ar.getUserId());// 用户ID
				arm.put("name", ar.getName());// 姓名
				arm.put("mobile", ar.getMobile());// 电话
				arm.put("sex", ar.getSex());// 性别
				arm.put("buildingName", ar.getBuildingName());// (已更改为百度地图地址名称)
				// addressDetail 由 百度地图地址 + 用户自主添加信息组合而成
				arm.put("addressDetail",  ar.getBuildingName()==null?""+ ar.getAddressDetail():ar.getBuildingName()+ " " + ar.getAddressDetail());// 地址详情
				arm.put("longitude", ar.getLongitude());// 经度
				arm.put("latitude", ar.getLatitude());// 纬度
				arm.put("addressTypeCode", ar.getAddressType());// '地址标签：1:公司/2:家/3:无/4:学校
				arm.put("addressTypeName", typeMap.get(ar.getAddressType().toString()));// '地址标签：1:公司/2:家/3:无/4:学校
				int result = merchantService.deliverable(merchantId, ar.getLatitude(), ar.getLongitude());
				if (result == 0) {
					deliverableAddress.add(arm);
				} else if (result == 1) {
					undeliverableAddress.add(arm);
				} else {
					unavailableAddress.add(arm);
				}
				arm.put("result", result);
			}
			addressList.addAll(deliverableAddress);
			addressList.addAll(undeliverableAddress);
			addressList.addAll(unavailableAddress);
		}
		return addressList;
	}
}