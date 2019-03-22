package com.jingzhun.income.service;
import com.jingzhun.income.entity.HHumanSocietyEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HHumanSocietyServiceI extends CommonService{
	
 	public void delete(HHumanSocietyEntity entity) throws Exception;
 	
 	public Serializable save(HHumanSocietyEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HHumanSocietyEntity entity) throws Exception;
 	
}
