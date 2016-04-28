package com.dianba.userdomain.sysdictionary.service;

import java.util.List;

import com.dianba.userdomain.sysdictionary.entity.SystemConfig;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface SystemConfigService {

	public List<SystemConfig> getSystemConfigList();
	
	public PageList<SystemConfig> getSystemConfigList(PageBounds pageBounds);
	
	public List<SystemConfig> getSystemConfigPageList(SystemConfig systemConfig);
	
	public PageList<SystemConfig> getSystemConfigPageList(SystemConfig systemConfig, PageBounds pageBounds);
	
	public SystemConfig getSystemConfigByPrimaryKey(Integer id);
	
	public void createSystemConfig(SystemConfig systemConfig);
	
	public void createSystemConfigBitch(List<SystemConfig> systemConfigList);
	
	public void updateSystemConfig(SystemConfig systemConfig);
	
	public void updateSystemConfigBitch(List<SystemConfig> systemConfigList);
	
	public void updateSystemConfigSelective(SystemConfig systemConfig);
	
	public void updateSystemConfigSelectiveBitch(List<SystemConfig> systemConfigList);
	
	public void deleteSystemConfig(Integer id);
	
	public void deleteSystemConfigBitch(List<Integer> idList);
	
	public List<SystemConfig> getScoreConfig();

}