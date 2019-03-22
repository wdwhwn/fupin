package com.jingzhun.department.service;
import com.jingzhun.department.entity.HTeamsEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HTeamsServiceI extends CommonService{
	
 	public void delete(HTeamsEntity entity) throws Exception;
 	
 	public Serializable save(HTeamsEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HTeamsEntity entity) throws Exception;
 	
}
