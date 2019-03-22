package com.jingzhun.department.service;
import com.jingzhun.department.entity.HVolunteerEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HVolunteerServiceI extends CommonService{
	
 	public void delete(HVolunteerEntity entity) throws Exception;
 	
 	public Serializable save(HVolunteerEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HVolunteerEntity entity) throws Exception;
 	
}
