package com.jingzhun.income.service;
import com.jingzhun.income.entity.HHighSchoolEntity;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface HHighSchoolServiceI extends CommonService{
	
 	public void delete(HHighSchoolEntity entity) throws Exception;
 	
 	public Serializable save(HHighSchoolEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HHighSchoolEntity entity) throws Exception;
	// 	分页
	public List<Map<String,Object>> getHighStudentList(Map<String,Object> conditionMap, DataGrid dataGrid);
 	
}
