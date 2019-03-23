package com.jingzhun.income.service;
import com.jingzhun.income.entity.HSpringKindergartenEntity;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface HSpringKindergartenServiceI extends CommonService{
	
 	public void delete(HSpringKindergartenEntity entity) throws Exception;
 	
 	public Serializable save(HSpringKindergartenEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HSpringKindergartenEntity entity) throws Exception;
// 	分页
public List<Map<String,Object>> getBomList(Map<String,Object> conditionMap, DataGrid dataGrid);
}
