package com.jingzhun.income.service;
import com.jingzhun.income.entity.HMiddleSchoolEntity;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface HMiddleSchoolServiceI extends CommonService{
	
 	public void delete(HMiddleSchoolEntity entity) throws Exception;
 	
 	public Serializable save(HMiddleSchoolEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HMiddleSchoolEntity entity) throws Exception;

	// 	分页
	public List<Map<String,Object>> getMiddleStudentList(Map<String,Object> conditionMap, DataGrid dataGrid);
 	
}
