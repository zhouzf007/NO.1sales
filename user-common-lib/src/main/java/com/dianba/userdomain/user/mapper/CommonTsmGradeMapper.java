package com.dianba.userdomain.user.mapper;

import java.util.List;

import com.dianba.userdomain.user.entity.TsmGrade;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonTsmGradeMapper {

	public List<TsmGrade> getTsmGradeList();

	public PageList<TsmGrade> getTsmGradeList( PageBounds pageBounds );
	
	public List<TsmGrade> getTsmGradePageList( TsmGrade tsmGrade );
	
	public PageList<TsmGrade> getTsmGradePageList(TsmGrade tsmGrade, PageBounds pageBounds );
	
	public TsmGrade getTsmGradeByPrimaryKey(Long id);
	
	public void createTsmGrade(TsmGrade tsmGrade);
	
	public void updateTsmGrade(TsmGrade tsmGrade);
	
	public void updateTsmGradeSelective(TsmGrade tsmGrade);
	
	public void deleteTsmGrade(Long id);
	
	public TsmGrade getTsmGradeByGrade(Long grade);
}