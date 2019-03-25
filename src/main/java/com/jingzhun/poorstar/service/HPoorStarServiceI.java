package com.jingzhun.poorstar.service;
import com.jingzhun.poorstar.entity.HPoorStarEntity;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface HPoorStarServiceI extends CommonService{
	
 	public void delete(HPoorStarEntity entity) throws Exception;
 	
 	public Serializable save(HPoorStarEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HPoorStarEntity entity) throws Exception;
	// 	分页
	public List<Map<String,Object>> getBomList(Map<String,Object> conditionMap, DataGrid dataGrid);
 	
}
