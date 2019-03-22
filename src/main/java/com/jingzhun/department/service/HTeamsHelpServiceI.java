package com.jingzhun.department.service;
import com.jingzhun.department.entity.HTeamsHelpEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HTeamsHelpServiceI extends CommonService{
	
 	public void delete(HTeamsHelpEntity entity) throws Exception;
 	
 	public Serializable save(HTeamsHelpEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HTeamsHelpEntity entity) throws Exception;
 	
}
