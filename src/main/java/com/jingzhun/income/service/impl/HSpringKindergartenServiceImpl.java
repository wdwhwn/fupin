package com.jingzhun.income.service.impl;
import com.jingzhun.income.service.HSpringKindergartenServiceI;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jingzhun.income.entity.HSpringKindergartenEntity;
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

@Service("hSpringKindergartenService")
@Transactional
public class HSpringKindergartenServiceImpl extends CommonServiceImpl implements HSpringKindergartenServiceI {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HSpringKindergartenServiceImpl.class);
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(HSpringKindergartenEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(HSpringKindergartenEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(HSpringKindergartenEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}

	@Override
	public List<Map<String, Object>> getBomList(Map<String, Object> conditionMap, DataGrid dataGrid) {
		List<Map<String, Object>> resultMapList=new ArrayList<Map<String,Object>>();
		String sql="SELECT\n" +
				"\te.id id,\n" +
				"\te.NAME name,\n" +
				"\te.IDNO idno,\n" +
				"\te.type type,\n" +
				"\te.MONTH month,\n" +
				"\te.money money,\n" +
				"\tsex,\n" +
				"\ts.school school,\n" +
				"\ts.address,\n" +
				"\ts.huzhu huzhu,\n" +
				"\ts.idcard idcard,\n" +
				"\ts.idcard_name idcardName,\n" +
				"\tidcard_num idcardNum \n" +
				"FROM\n" +
				"\th_bureau_of_education e\n" +
				"\tINNER JOIN h_spring_kindergarten s ON e.IDNO = s.IDNO";
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