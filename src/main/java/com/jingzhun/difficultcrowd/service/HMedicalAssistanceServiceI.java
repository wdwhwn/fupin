package com.jingzhun.difficultcrowd.service;
import com.jingzhun.difficultcrowd.entity.HMedicalAssistanceEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HMedicalAssistanceServiceI extends CommonService{
	
 	public void delete(HMedicalAssistanceEntity entity) throws Exception;
 	
 	public Serializable save(HMedicalAssistanceEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HMedicalAssistanceEntity entity) throws Exception;
 	
}
