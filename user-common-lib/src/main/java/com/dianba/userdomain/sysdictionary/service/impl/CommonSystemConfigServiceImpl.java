package com.dianba.userdomain.sysdictionary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.sysdictionary.entity.SystemConfig;
import com.dianba.userdomain.sysdictionary.mapper.CommonSystemConfigMapper;
import com.dianba.userdomain.sysdictionary.service.SystemConfigService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional 
public class CommonSystemConfigServiceImpl implements SystemConfigService { 

    @Autowired
	private CommonSystemConfigMapper systemConfigMapper;
	
	public List<SystemConfig> getSystemConfigList(){
		return systemConfigMapper.getSystemConfigList();
	}
	
	public PageList<SystemConfig> getSystemConfigList(PageBounds pageBounds){
		return systemConfigMapper.getSystemConfigList(pageBounds);
	}
	
	public List<SystemConfig> getSystemConfigPageList(SystemConfig systemConfig){
		return systemConfigMapper.getSystemConfigPageList(systemConfig);
	}
	
	public PageList<SystemConfig> getSystemConfigPageList(SystemConfig systemConfig, PageBounds pageBounds){
		return systemConfigMapper.getSystemConfigPageList(systemConfig,pageBounds);
	}
	
	public SystemConfig getSystemConfigByPrimaryKey(Integer id){
		return systemConfigMapper.getSystemConfigByPrimaryKey(id);
	}
	
	public void createSystemConfig(SystemConfig systemConfig){
		systemConfigMapper.createSystemConfig(systemConfig);
	}
	
	public void createSystemConfigBitch(List<SystemConfig> systemConfigList){
		for( SystemConfig systemConfig : systemConfigList ) {
			systemConfigMapper.createSystemConfig(systemConfig);
		}
	}
	
	public void updateSystemConfig(SystemConfig systemConfig){
		systemConfigMapper.updateSystemConfig(systemConfig);
	}
	
	public void updateSystemConfigBitch(List<SystemConfig> systemConfigList){
	    for( SystemConfig systemConfig : systemConfigList ) {
		    systemConfigMapper.updateSystemConfig(systemConfig);
		}
	}
	
	public void updateSystemConfigSelective(SystemConfig systemConfig){
	    systemConfigMapper.updateSystemConfigSelective(systemConfig);
	}
	
	public void updateSystemConfigSelectiveBitch(List<SystemConfig> systemConfigList){
	    for( SystemConfig systemConfig : systemConfigList ) {
		    systemConfigMapper.updateSystemConfigSelective(systemConfig);
		}
	}
	
	public void deleteSystemConfig(Integer id){
		systemConfigMapper.deleteSystemConfig(id);
	}
	
	public void deleteSystemConfigBitch(List<Integer> idList){
		for( Integer id : idList ) {
			systemConfigMapper.deleteSystemConfig(id);
		}
	}

	@Override
	public List<SystemConfig> getScoreConfig() {
		return systemConfigMapper.getScoreConfig();
	}

}