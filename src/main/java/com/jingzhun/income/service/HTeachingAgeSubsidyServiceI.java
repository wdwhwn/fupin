package com.jingzhun.income.service;
import com.jingzhun.income.entity.HTeachingAgeSubsidyEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HTeachingAgeSubsidyServiceI extends CommonService{
	
 	public void delete(HTeachingAgeSubsidyEntity entity) throws Exception;
 	
 	public Serializable save(HTeachingAgeSubsidyEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HTeachingAgeSubsidyEntity entity) throws Exception;
 	
}
