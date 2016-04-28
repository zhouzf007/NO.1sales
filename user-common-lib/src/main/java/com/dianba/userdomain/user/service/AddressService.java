package com.dianba.userdomain.user.service;

import java.util.List;
import java.util.Map;

import com.dianba.userdomain.user.entity.Address;
import com.dianba.userdomain.user.vo.AddressDetailVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface AddressService {

	public List<Address> getAddressList();

	public PageList<Address> getAddressList( PageBounds pageBounds );
	
	public List<Address> getAddressPageList( Address address );
	
	public PageList<Address> getAddressPageList(Address address, PageBounds pageBounds );
	
	public Address getAddressByPrimaryKey(Long id);
	
	public void createAddress(Address address);
	
	public void updateAddress(Address address);
	
	public void updateAddressSelective(Address address);
	
	public void deleteAddress(Long id);
    
	public AddressDetailVo getAddressById (Long id);
	
	public AddressDetailVo getAddressByUserId (Long userId);
	
	
	public void setDefaultAddress(Long id);
	
	public List<Address> getDefaultAddress(Long id);
	
	public Long getMaxIdFromUserId(Integer id);
	
	public Address isDefaultAddress(Long id); 

	/**
	 * 根据用户ID 清空该用户的默认地址
	 * @param userId
	 */
    public void updateAddressSetDefaultByUserId(Integer userId); 
    
    public List<Map<String, Object>>  getAddressPageList(Integer userId);
    
    public List<Map<String, Object>>  getAddressValidatedList(Integer userId ,long merchantId);
    
}