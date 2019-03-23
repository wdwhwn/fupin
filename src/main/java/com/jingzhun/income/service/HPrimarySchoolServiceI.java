package com.jingzhun.income.service;
import com.jingzhun.income.entity.HPrimarySchoolEntity;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface HPrimarySchoolServiceI extends CommonService{
	
 	public void delete(HPrimarySchoolEntity entity) throws Exception;
 	
 	public Serializable save(HPrimarySchoolEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HPrimarySchoolEntity entity) throws Exception;
	// 	分页
	public List<Map<String,Object>> getBomList(Map<String,Object> conditionMap, DataGrid dataGrid);
 	
}
