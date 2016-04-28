package com.dianba.userdomain.sysdictionary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.sysdictionary.entity.SysCode;
import com.dianba.userdomain.sysdictionary.mapper.CommonSysCodeMapper;
import com.dianba.userdomain.sysdictionary.service.SysCodeService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional 
public class CommonSysCodeServiceImpl implements SysCodeService { 

    @Autowired
	private CommonSysCodeMapper sysCodeMapper;
	
	public List<SysCode> getSysCodeList(){
		return sysCodeMapper.getSysCodeList();
	}
	
	public PageList<SysCode> getSysCodeList(PageBounds pageBounds){
		return sysCodeMapper.getSysCodeList(pageBounds);
	}
	
	public List<SysCode> getSysCodePageList(SysCode sysCode){
		return sysCodeMapper.getSysCodePageList(sysCode);
	}
	
	public PageList<SysCode> getSysCodePageList(SysCode sysCode, PageBounds pageBounds){
		return sysCodeMapper.getSysCodePageList(sysCode,pageBounds);
	}
	
	public SysCode getSysCodeByPrimaryKey(Integer id){
		return sysCodeMapper.getSysCodeByPrimaryKey(id);
	}
	
	public void createSysCode(SysCode sysCode){
		sysCodeMapper.createSysCode(sysCode);
	}
	
	public void createSysCodeBitch(List<SysCode> sysCodeList){
		for( SysCode sysCode : sysCodeList ) {
			sysCodeMapper.createSysCode(sysCode);
		}
	}
	
	public void updateSysCode(SysCode sysCode){
		sysCodeMapper.updateSysCode(sysCode);
	}
	
	public void updateSysCodeBitch(List<SysCode> sysCodeList){
	    for( SysCode sysCode : sysCodeList ) {
		    sysCodeMapper.updateSysCode(sysCode);
		}
	}
	
	public void updateSysCodeSelective(SysCode sysCode){
	    sysCodeMapper.updateSysCodeSelective(sysCode);
	}
	
	public void updateSysCodeSelectiveBitch(List<SysCode> sysCodeList){
	    for( SysCode sysCode : sysCodeList ) {
		    sysCodeMapper.updateSysCodeSelective(sysCode);
		}
	}
	
	public void deleteSysCode(Integer id){
		sysCodeMapper.deleteSysCode(id);
	}
	
	public void deleteSysCodeBitch(List<Integer> idList){
		for( Integer id : idList ) {
			sysCodeMapper.deleteSysCode(id);
		}
	}

}