package com.jingzhun.income.service;
import com.jingzhun.income.entity.HVocationalSchoolEntity;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface HVocationalSchoolServiceI extends CommonService{
	
 	public void delete(HVocationalSchoolEntity entity) throws Exception;
 	
 	public Serializable save(HVocationalSchoolEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HVocationalSchoolEntity entity) throws Exception;

	// 	分页
	public List<Map<String,Object>> getVocationStudentList(Map<String,Object> conditionMap, DataGrid dataGrid);
 	
}
