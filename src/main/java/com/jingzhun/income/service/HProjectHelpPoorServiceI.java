package com.jingzhun.income.service;
import com.jingzhun.income.entity.HProjectHelpPoorEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HProjectHelpPoorServiceI extends CommonService{
	
 	public void delete(HProjectHelpPoorEntity entity) throws Exception;
 	
 	public Serializable save(HProjectHelpPoorEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HProjectHelpPoorEntity entity) throws Exception;
 	
}
