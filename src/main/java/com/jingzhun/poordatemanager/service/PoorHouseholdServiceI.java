package com.jingzhun.poordatemanager.service;
import com.jingzhun.poordatemanager.entity.PoorHouseholdEntity;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface PoorHouseholdServiceI extends CommonService{
	
 	public void delete(PoorHouseholdEntity entity) throws Exception;
 	
 	public Serializable save(PoorHouseholdEntity entity) throws Exception;
 	
 	public void saveOrUpdate(PoorHouseholdEntity entity) throws Exception;

	// 	分页
	public List<Map<String,Object>> getPoorDate(Map<String,Object> conditionMap, DataGrid dataGrid, String id);

	// 	datagridSelectOne
	public List<Map<String,Object>> datagridSelectOne(Map<String,Object> conditionMap, DataGrid dataGrid, String id);
//	   家庭成员
	public List<Map<String,Object>> datagridFamily(Map<String,Object> conditionMap, DataGrid dataGrid, String id);
//	   帮扶责任人
	public List<Map<String,Object>> datagridHelpTerms(Map<String,Object> conditionMap, DataGrid dataGrid, String id);

}
