package com.dianba.userdomain.sysdictionary.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.dianba.userdomain.sysdictionary.entity.VersionManager;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface VersionManagerService {

	public List<VersionManager> getVersionManagerList();
	
	public PageList<VersionManager> getVersionManagerList(PageBounds pageBounds);
	
	public List<VersionManager> getVersionManagerPageList(VersionManager versionManager);
	
	public PageList<VersionManager> getVersionManagerPageList(VersionManager versionManager, PageBounds pageBounds);
	
	public VersionManager getVersionManagerByPrimaryKey(BigDecimal id);
	
	public void createVersionManager(VersionManager versionManager);
	
	public void createVersionManagerBitch(List<VersionManager> versionManagerList);
	
	public void updateVersionManager(VersionManager versionManager);
	
	public void updateVersionManagerBitch(List<VersionManager> versionManagerList);
	
	public void updateVersionManagerSelective(VersionManager versionManager);
	
	public void updateVersionManagerSelectiveBitch(List<VersionManager> versionManagerList);
	
	public void deleteVersionManager(BigDecimal id);
	
	public void deleteVersionManagerBitch(List<BigDecimal> idList);
	
	public Map<String, Object> updateVersionManager(int type);

}