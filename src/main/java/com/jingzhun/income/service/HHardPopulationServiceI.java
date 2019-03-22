package com.jingzhun.income.service;
import com.jingzhun.income.entity.HHardPopulationEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HHardPopulationServiceI extends CommonService{
	
 	public void delete(HHardPopulationEntity entity) throws Exception;
 	
 	public Serializable save(HHardPopulationEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HHardPopulationEntity entity) throws Exception;
 	
}
