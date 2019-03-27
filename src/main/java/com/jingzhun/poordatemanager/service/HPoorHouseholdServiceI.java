package com.jingzhun.poordatemanager.service;
import com.jingzhun.poordatemanager.entity.HPoorHouseholdEntity;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface HPoorHouseholdServiceI extends CommonService{
	
 	public void delete(HPoorHouseholdEntity entity) throws Exception;
 	
 	public Serializable save(HPoorHouseholdEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HPoorHouseholdEntity entity) throws Exception;
	// 	分页
	public List<Map<String,Object>> getPoorDate(Map<String,Object> conditionMap, DataGrid dataGrid,String id);
 	
}
