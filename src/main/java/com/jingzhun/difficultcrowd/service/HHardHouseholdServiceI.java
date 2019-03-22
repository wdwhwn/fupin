package com.jingzhun.difficultcrowd.service;
import com.jingzhun.difficultcrowd.entity.HHardHouseholdEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HHardHouseholdServiceI extends CommonService{
	
 	public void delete(HHardHouseholdEntity entity) throws Exception;
 	
 	public Serializable save(HHardHouseholdEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HHardHouseholdEntity entity) throws Exception;
 	
}
