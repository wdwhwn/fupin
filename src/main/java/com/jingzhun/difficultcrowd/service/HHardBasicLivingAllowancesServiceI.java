package com.jingzhun.difficultcrowd.service;
import com.jingzhun.difficultcrowd.entity.HHardBasicLivingAllowancesEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HHardBasicLivingAllowancesServiceI extends CommonService{
	
 	public void delete(HHardBasicLivingAllowancesEntity entity) throws Exception;
 	
 	public Serializable save(HHardBasicLivingAllowancesEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HHardBasicLivingAllowancesEntity entity) throws Exception;
 	
}
