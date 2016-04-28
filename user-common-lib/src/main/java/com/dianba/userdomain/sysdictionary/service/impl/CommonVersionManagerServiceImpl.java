package com.dianba.userdomain.sysdictionary.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.commons.exception.core.AssertCore;
import com.dianba.userdomain.sysdictionary.entity.VersionManager;
import com.dianba.userdomain.sysdictionary.mapper.CommonVersionManagerMapper;
import com.dianba.userdomain.sysdictionary.service.VersionManagerService;
import com.dianba.userdomain.util.ListUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional 
public class CommonVersionManagerServiceImpl implements VersionManagerService { 

    @Autowired
	private CommonVersionManagerMapper versionManagerMapper;
	
	public List<VersionManager> getVersionManagerList(){
		return versionManagerMapper.getVersionManagerList();
	}
	
	public PageList<VersionManager> getVersionManagerList(PageBounds pageBounds){
		return versionManagerMapper.getVersionManagerList(pageBounds);
	}
	
	public List<VersionManager> getVersionManagerPageList(VersionManager versionManager){
		return versionManagerMapper.getVersionManagerPageList(versionManager);
	}
	
	public PageList<VersionManager> getVersionManagerPageList(VersionManager versionManager, PageBounds pageBounds){
		return versionManagerMapper.getVersionManagerPageList(versionManager,pageBounds);
	}
	
	public VersionManager getVersionManagerByPrimaryKey(BigDecimal id){
		return versionManagerMapper.getVersionManagerByPrimaryKey(id);
	}
	
	public void createVersionManager(VersionManager versionManager){
		versionManagerMapper.createVersionManager(versionManager);
	}
	
	public void createVersionManagerBitch(List<VersionManager> versionManagerList){
		for( VersionManager versionManager : versionManagerList ) {
			versionManagerMapper.createVersionManager(versionManager);
		}
	}
	
	public void updateVersionManager(VersionManager versionManager){
		versionManagerMapper.updateVersionManager(versionManager);
	}
	
	public void updateVersionManagerBitch(List<VersionManager> versionManagerList){
	    for( VersionManager versionManager : versionManagerList ) {
		    versionManagerMapper.updateVersionManager(versionManager);
		}
	}
	
	public void updateVersionManagerSelective(VersionManager versionManager){
	    versionManagerMapper.updateVersionManagerSelective(versionManager);
	}
	
	public void updateVersionManagerSelectiveBitch(List<VersionManager> versionManagerList){
	    for( VersionManager versionManager : versionManagerList ) {
		    versionManagerMapper.updateVersionManagerSelective(versionManager);
		}
	}
	
	public void deleteVersionManager(BigDecimal id){
		versionManagerMapper.deleteVersionManager(id);
	}
	
	public void deleteVersionManagerBitch(List<BigDecimal> idList){
		for( BigDecimal id : idList ) {
			versionManagerMapper.deleteVersionManager(id);
		}
	}

	@Override
	public Map<String, Object>  updateVersionManager(int type) {
		VersionManager versionManager = new VersionManager();
		versionManager.setType(type);
		List<VersionManager> manager =getVersionManagerPageList(versionManager);
		Map<String, Object> mapr = new HashMap<String, Object>();
		AssertCore.G9016.notNull(manager);
		BigDecimal bigCurrentVersion = new BigDecimal(0);
		for (VersionManager vm : manager) {
			if (vm.getCurrentVersion().compareTo(bigCurrentVersion) == 1) {
				bigCurrentVersion = vm.getCurrentVersion();
			}
		}
		versionManager.setCurrentVersion(bigCurrentVersion);
		List<VersionManager> manager2 = getVersionManagerPageList(versionManager);
		if (ListUtil.isNotNullOrEmpty(manager2)) {
			versionManager = manager2.get(0);
			mapr.put("id", versionManager.getId());
			mapr.put("message", versionManager.getMessage());
			mapr.put("minVersion", versionManager.getMinVersion());
			mapr.put("time", versionManager.getTime());
			mapr.put("type", versionManager.getType());
			mapr.put("forceupdate", versionManager.getForceupdate());
			mapr.put("downLoadUrl", versionManager.getDownloadUrl());
			mapr.put("currentVersion", versionManager.getCurrentVersion());
		}
		return mapr;
	}

}