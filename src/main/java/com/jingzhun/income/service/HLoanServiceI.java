package com.jingzhun.income.service;
import com.jingzhun.income.entity.HLoanEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface HLoanServiceI extends CommonService{
	
 	public void delete(HLoanEntity entity) throws Exception;
 	
 	public Serializable save(HLoanEntity entity) throws Exception;
 	
 	public void saveOrUpdate(HLoanEntity entity) throws Exception;
 	
}
