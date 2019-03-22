package com.jingzhun.difficultcrowd.service;
import com.jingzhun.difficultcrowd.entity.HHardInsuranceEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HHardInsuranceServiceI extends CommonService{
	
 	public void delete(HHardInsuranceEntity entity) throws Exception;
 	
 	public Serializable save(HHardInsuranceEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HHardInsuranceEntity entity) throws Exception;
 	
}
