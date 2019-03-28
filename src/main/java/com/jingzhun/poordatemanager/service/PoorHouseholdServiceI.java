package com.jingzhun.poordatemanager.service;
import com.jingzhun.poordatemanager.entity.PoorHouseholdEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface PoorHouseholdServiceI extends CommonService{
	
 	public void delete(PoorHouseholdEntity entity) throws Exception;
 	
 	public Serializable save(PoorHouseholdEntity entity) throws Exception;
 	
 	public void saveOrUpdate(PoorHouseholdEntity entity) throws Exception;
 	
}
