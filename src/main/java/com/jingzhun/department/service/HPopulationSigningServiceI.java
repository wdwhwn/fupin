package com.jingzhun.department.service;
import com.jingzhun.department.entity.HPopulationSigningEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HPopulationSigningServiceI extends CommonService{
	
 	public void delete(HPopulationSigningEntity entity) throws Exception;
 	
 	public Serializable save(HPopulationSigningEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HPopulationSigningEntity entity) throws Exception;
 	
}
