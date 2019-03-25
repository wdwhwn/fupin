package com.jingzhun.income.service.impl;
import com.jingzhun.income.service.HMiddleSchoolServiceI;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jingzhun.income.entity.HMiddleSchoolEntity;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.io.Serializable;
import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.core.util.MyClassLoader;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.cgform.enhance.CgformEnhanceJavaInter;

import org.jeecgframework.minidao.util.FreemarkerParseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.jeecgframework.core.util.ResourceUtil;

@Service("hMiddleSchoolService")
@Transactional
public class HMiddleSchoolServiceImpl extends CommonServiceImpl implements HMiddleSchoolServiceI {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HSpringKindergartenServiceImpl.class);
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(HMiddleSchoolEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(HMiddleSchoolEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(HMiddleSchoolEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}

	@Override
	public List<Map<String, Object>> getMiddleStudentList(Map<String, Object> conditionMap, DataGrid dataGrid) {
		List<Map<String, Object>> resultMapList=new ArrayList<Map<String,Object>>();
		String sql="SELECT\n" +
				"\te.id id,\n" +
				"\te.NAME NAME,\n" +
				"\te.IDNO IDNO,\n" +
				"\te.type type,\n" +
				"\te.MONTH MONTH,\n" +
				"\te.money money,\n" +
				"\tschool,\n" +
				"\tsex,\n" +
				"\tis_lodging isLodging,\n" +
				"\taddress,\n" +
				"\thouseholder_name householderName,\n" +
				"\tbank,\n" +
				"\tbank_account bankAccount,\n" +
				"\tbank_no bankNo\n" +
				"FROM\n" +
				"\th_bureau_of_education e\n" +
				"\tINNER JOIN h_middle_school s ON e.IDNO = s.IDNO";
		logger.error(sql);
		if(dataGrid!=null){
			List<Map<String, Object>> totalList = super.findForJdbc("select count(0) total from (" + sql + ")t");
			Integer total = Integer.valueOf(totalList.get(0).get("total") + "");
			dataGrid.setTotal(total);
			if(total>0){
				resultMapList= super.findForJdbcParam(sql , dataGrid.getPage(), dataGrid.getRows());
			}else{
				resultMapList = new ArrayList<Map<String,Object>>();
			}
		}else{
			resultMapList=this.findForJdbc(sql);
		}
		return resultMapList;
	}

}