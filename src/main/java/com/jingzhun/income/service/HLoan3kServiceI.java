package com.jingzhun.income.service;
import com.jingzhun.income.entity.HLoan3kEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HLoan3kServiceI extends CommonService{
	
 	public void delete(HLoan3kEntity entity) throws Exception;
 	
 	public Serializable save(HLoan3kEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HLoan3kEntity entity) throws Exception;
 	
}
