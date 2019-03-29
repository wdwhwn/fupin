package com.jingzhun.poordatemanager.service;
import com.jingzhun.poordatemanager.entity.HPoorIncomeEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HPoorIncomeServiceI extends CommonService{
	
 	public void delete(HPoorIncomeEntity entity) throws Exception;
 	
 	public Serializable save(HPoorIncomeEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HPoorIncomeEntity entity) throws Exception;
 	
}
