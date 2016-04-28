package com.dianba.userdomain.sysdictionary.mapper;

import java.util.List;

import com.dianba.userdomain.sysdictionary.entity.SystemConfig;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonSystemConfigMapper {

	public List<SystemConfig> getSystemConfigList();

	public PageList<SystemConfig> getSystemConfigList( PageBounds pageBounds );
	
	public List<SystemConfig> getSystemConfigPageList( SystemConfig systemConfig );
	
	public PageList<SystemConfig> getSystemConfigPageList(SystemConfig systemConfig, PageBounds pageBounds );
	
	public SystemConfig getSystemConfigByPrimaryKey(Integer id);
	
	public void createSystemConfig(SystemConfig systemConfig);
	
	public void updateSystemConfig(SystemConfig systemConfig);
	
	public void updateSystemConfigSelective(SystemConfig systemConfig);
	
	public void deleteSystemConfig(Integer id);
	
	public List<SystemConfig> getScoreConfig();
	
	public String systemconfigAppId();
	
	public String systemconfigAppSecret();
}