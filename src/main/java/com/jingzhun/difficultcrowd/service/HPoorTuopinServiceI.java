package com.jingzhun.difficultcrowd.service;
import com.jingzhun.difficultcrowd.entity.HPoorTuopinEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HPoorTuopinServiceI extends CommonService{
	
 	public void delete(HPoorTuopinEntity entity) throws Exception;
 	
 	public Serializable save(HPoorTuopinEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HPoorTuopinEntity entity) throws Exception;
 	
}
