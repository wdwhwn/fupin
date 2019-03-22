package com.jingzhun.difficultcrowd.service;
import com.jingzhun.difficultcrowd.entity.HHardOrphanEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HHardOrphanServiceI extends CommonService{
	
 	public void delete(HHardOrphanEntity entity) throws Exception;
 	
 	public Serializable save(HHardOrphanEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HHardOrphanEntity entity) throws Exception;
 	
}
