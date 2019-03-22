package com.jingzhun.property.service;
import com.jingzhun.property.entity.HFarmMachineryEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HFarmMachineryServiceI extends CommonService{
	
 	public void delete(HFarmMachineryEntity entity) throws Exception;
 	
 	public Serializable save(HFarmMachineryEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HFarmMachineryEntity entity) throws Exception;
 	
}
