package com.jingzhun.difficultcrowd.service;
import com.jingzhun.difficultcrowd.entity.HChildrenEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HChildrenServiceI extends CommonService{
	
 	public void delete(HChildrenEntity entity) throws Exception;
 	
 	public Serializable save(HChildrenEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HChildrenEntity entity) throws Exception;
 	
}
