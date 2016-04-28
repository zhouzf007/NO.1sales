package com.dianba.userdomain.user.mapper;

import java.util.List;

import com.dianba.userdomain.user.entity.Address;
import com.dianba.userdomain.user.vo.AddressDetailVo;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonAddressMapper {

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
}