package com.dianba.userdomain.sysdictionary.mapper;

import java.util.List;

import com.dianba.userdomain.sysdictionary.entity.SysCode;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonSysCodeMapper {

	public List<SysCode> getSysCodeList();

	public PageList<SysCode> getSysCodeList( PageBounds pageBounds );
	
	public List<SysCode> getSysCodePageList( SysCode sysCode );
	
	public PageList<SysCode> getSysCodePageList(SysCode sysCode, PageBounds pageBounds );
	
	public SysCode getSysCodeByPrimaryKey(Integer id);
	
	public void createSysCode(SysCode sysCode);
	
	public void updateSysCode(SysCode sysCode);
	
	public void updateSysCodeSelective(SysCode sysCode);
	
	public void deleteSysCode(Integer id);
}