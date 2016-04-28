package com.dianba.userdomain.sysdictionary.service;

import java.util.List;

import com.dianba.userdomain.sysdictionary.entity.SysCode;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface SysCodeService {

	public List<SysCode> getSysCodeList();
	
	public PageList<SysCode> getSysCodeList(PageBounds pageBounds);
	
	public List<SysCode> getSysCodePageList(SysCode sysCode);
	
	public PageList<SysCode> getSysCodePageList(SysCode sysCode, PageBounds pageBounds);
	
	public SysCode getSysCodeByPrimaryKey(Integer id);
	
	public void createSysCode(SysCode sysCode);
	
	public void createSysCodeBitch(List<SysCode> sysCodeList);
	
	public void updateSysCode(SysCode sysCode);
	
	public void updateSysCodeBitch(List<SysCode> sysCodeList);
	
	public void updateSysCodeSelective(SysCode sysCode);
	
	public void updateSysCodeSelectiveBitch(List<SysCode> sysCodeList);
	
	public void deleteSysCode(Integer id);
	
	public void deleteSysCodeBitch(List<Integer> idList);

}