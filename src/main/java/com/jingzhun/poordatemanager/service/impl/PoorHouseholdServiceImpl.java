package com.jingzhun.poordatemanager.service.impl;
import com.jingzhun.income.service.impl.HSpringKindergartenServiceImpl;
import com.jingzhun.poordatemanager.service.PoorHouseholdServiceI;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jingzhun.poordatemanager.entity.PoorHouseholdEntity;
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

@Service("poorHouseholdService")
@Transactional
public class PoorHouseholdServiceImpl extends CommonServiceImpl implements PoorHouseholdServiceI {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HSpringKindergartenServiceImpl.class);
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(PoorHouseholdEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(PoorHouseholdEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(PoorHouseholdEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
	@Override
	public List<Map<String, Object>> getPoorDate(Map<String, Object> conditionMap, DataGrid dataGrid, String id) {
		List<Map<String, Object>> resultMapList=new ArrayList<Map<String,Object>>();
		logger.error("id为："+id);
		String sql=null;
		if(id==null){
			sql="select * from h_poor_household";
		}else {
			sql = "select h.*,t.id id1,t.tid,t.vsname from h_poor_household h left join h_sys_village_tree t  on h.A3=t.vsname  where t.id=" + id +
					" union all \n" +
					"select h.*,t.id id1,t.tid,t.vsname from h_poor_household h left join h_sys_village_tree t  on h.A3=t.vsname  where t.tid=" + id;
		}
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
//   查询贫困户详情
	@Override
	public List<Map<String, Object>> datagridSelectOne(Map<String, Object> conditionMap, DataGrid dataGrid, String id) {
		List<Map<String, Object>> resultMapList=new ArrayList<Map<String,Object>>();
		logger.error("id为："+id);
		String sql=null;
		sql="select * from h_poor_household where id="+id;
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
//	查询家庭成员
	@Override
	public List<Map<String, Object>> datagridFamily(Map<String, Object> conditionMap, DataGrid dataGrid, String id) {
		List<Map<String, Object>> resultMapList=new ArrayList<Map<String,Object>>();
		logger.error("id为："+id);
		String sql=null;
		sql="select* from h_poor_household where A5 =(select A5 from h_poor_household where id="+id+") and ID !="+id;
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

	@Override
	public List<Map<String, Object>> datagridHelpTerms(Map<String, Object> conditionMap, DataGrid dataGrid, String id) {
		List<Map<String, Object>> resultMapList=new ArrayList<Map<String,Object>>();
		logger.error("id为："+id);
		String sql=null;
		sql="select id,district,town,village,name,idno,unit,person_liable personLiable,mobile_help mobileHelp,contact from h_teams_help where idno=(select A8 from h_poor_household where id ="+id+")";
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