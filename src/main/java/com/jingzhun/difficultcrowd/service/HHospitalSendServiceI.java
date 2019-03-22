package com.jingzhun.difficultcrowd.service;
import com.jingzhun.difficultcrowd.entity.HHospitalSendEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HHospitalSendServiceI extends CommonService{
	
 	public void delete(HHospitalSendEntity entity) throws Exception;
 	
 	public Serializable save(HHospitalSendEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HHospitalSendEntity entity) throws Exception;
 	
}
