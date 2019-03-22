package com.jingzhun.difficultcrowd.service;
import com.jingzhun.difficultcrowd.entity.HHardChildrenEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HHardChildrenServiceI extends CommonService{
	
 	public void delete(HHardChildrenEntity entity) throws Exception;
 	
 	public Serializable save(HHardChildrenEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HHardChildrenEntity entity) throws Exception;
 	
}
