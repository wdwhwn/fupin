package com.jingzhun.poordatemanager.service;
import com.jingzhun.poordatemanager.entity.HPoorHouseholdEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HPoorHouseholdServiceI extends CommonService{
	
 	public void delete(HPoorHouseholdEntity entity) throws Exception;
 	
 	public Serializable save(HPoorHouseholdEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HPoorHouseholdEntity entity) throws Exception;
 	
}
