package com.jingzhun.difficultcrowd.service.impl;
import com.jingzhun.difficultcrowd.service.HHardHouseholdServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jingzhun.difficultcrowd.entity.HHardHouseholdEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

import org.jeecgframework.minidao.util.FreemarkerParseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.jeecgframework.core.util.ResourceUtil;

@Service("hHardHouseholdService")
@Transactional
public class HHardHouseholdServiceImpl extends CommonServiceImpl implements HHardHouseholdServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(HHardHouseholdEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(HHardHouseholdEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(HHardHouseholdEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}