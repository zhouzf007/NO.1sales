package com.dianba.userdomain.sysdictionary.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.dianba.userdomain.sysdictionary.entity.VersionManager;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonVersionManagerMapper {

	public List<VersionManager> getVersionManagerList();

	public PageList<VersionManager> getVersionManagerList( PageBounds pageBounds );
	
	public List<VersionManager> getVersionManagerPageList( VersionManager versionManager );
	
	public PageList<VersionManager> getVersionManagerPageList(VersionManager versionManager, PageBounds pageBounds );
	
	public VersionManager getVersionManagerByPrimaryKey(BigDecimal id);
	
	public void createVersionManager(VersionManager versionManager);
	
	public void updateVersionManager(VersionManager versionManager);
	
	public void updateVersionManagerSelective(VersionManager versionManager);
	
	public void deleteVersionManager(BigDecimal id);
}