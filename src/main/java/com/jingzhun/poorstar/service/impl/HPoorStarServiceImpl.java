package com.jingzhun.poorstar.service.impl;
import com.jingzhun.income.service.impl.HSpringKindergartenServiceImpl;
import com.jingzhun.poorstar.service.HPoorStarServiceI;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.jingzhun.poorstar.entity.HPoorStarEntity;
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

@Service("hPoorStarService")
@Transactional
public class HPoorStarServiceImpl extends CommonServiceImpl implements HPoorStarServiceI {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(HSpringKindergartenServiceImpl.class);
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(HPoorStarEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(HPoorStarEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(HPoorStarEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
	@Override
	public List<Map<String, Object>> getBomList(Map<String, Object> conditionMap, DataGrid dataGrid) {
		List<Map<String, Object>> resultMapList=new ArrayList<Map<String,Object>>();
		String sql="SELECT  " +
				"p6.id id,p6.jiedao jiedao,p6.name name,p6.idno idno,p6.cunzhung cunzhung,p6.selfFee selfFee,p6.canji canji,p6.dibao dibao,p6.tekun tekun,p6.guer guer,p6.kunjingertong,p6.tuopinbuxiangshou tuopinbuxiangshou,  " +
				" ( canji + dibao + tekun + guer + kunjingertong + tuopinbuxiangshou + 1 ) count   " +
				"FROM  " +
				" (  " +
				" SELECT  " +
				" p5.id id,p5.jiedao jiedao,p5.name name,p5.idno idno,p5.cunzhung cunzhung,p5.selfFee selfFee,p5.canji canji,p5.dibao dibao,p5.tekun tekun,p5.guer guer,p5.kunjingertong,  " +
				" IF  " +
				"  ( h5.id, 1, 0 ) tuopinbuxiangshou   " +
				" FROM  " +
				"  (  " +
				"  SELECT  " +
				"  p4.id id,p4.jiedao jiedao,p4.name name,p4.idno idno,p4.cunzhung cunzhung,p4.selfFee selfFee,p4.canji canji,p4.dibao dibao,p4.tekun tekun,p4.guer guer,  " +
				"  IF  " +
				"   ( h4.id, 1, 0 ) kunjingertong   " +
				"  FROM  " +
				"   (  " +
				"   SELECT  " +
				"   p3.id id,p3.jiedao jiedao,p3.name name,p3.idno idno,p3.cunzhung cunzhung,p3.selfFee selfFee,p3.canji canji,p3.dibao dibao,p3.tekun tekun,  " +
				"   IF  " +
				"    ( h3.id, 1, 0 ) guer   " +
				"   FROM  " +
				"    (  " +
				"    SELECT  " +
				"    p2.id id,p2.jiedao jiedao,p2.name name,p2.idno idno,p2.cunzhung cunzhung,p2.selfFee selfFee,p2.canji canji,p2.dibao dibao,  " +
				"    IF  " +
				"     ( h2.id, 1, 0 ) tekun   " +
				"    FROM  " +
				"     (  " +
				"     SELECT  " +
				"     p1.id id,p1.jiedao jiedao,p1.name name,p1.idno idno,p1.cunzhung cunzhung,p1.selfFee selfFee,p1.canji canji,  " +
				"       " +
				"     IF  " +
				"      ( a1.id, 1, 0 ) dibao   " +
				"     FROM  " +
				"      (  " +
				"      SELECT  " +
				"       s.id id,  " +
				"       s.jiedao jiedao,  " +
				"       s.cunzhuang cunzhung,  " +
				"       s.NAME NAME,  " +
				"       s.idno idno,  " +
				"      IF  " +
				"       ( c.id, 1, 0 ) canji,  " +
				"       s.self_fee selfFee   " +
				"      FROM  " +
				"       h_hospital_send s  " +
				"       LEFT JOIN (  " +
				"       SELECT  " +
				"        SUBSTRING( idno, 1, 18 ) idno,  " +
				"        id,  " +
				"        sex,  " +
				"        type,  " +
				"        LEVEL,  " +
				"        cert_time,  " +
				"        address,  " +
				"        mobile   " +
				"       FROM  " +
				"        h_hard_household   " +
				"       ) c ON s.idno = c.idno   " +
				"      WHERE  " +
				"       self_fee >= 20000   " +
				"      ) p1  " +
				"      LEFT JOIN h_hard_basic_living_allowances a1 ON p1.idno = a1.IDNO   " +
				"     ) p2  " +
				"     LEFT JOIN h_hard_insurance h2 ON p2.idno = h2.IDNO   " +
				"    ) p3  " +
				"    LEFT JOIN h_hard_orphan h3 ON p3.idno = h3.idno   " +
				"   ) p4  " +
				"   LEFT JOIN h_hard_children h4 ON p4.idno = h4.idno   " +
				"  ) p5  " +
				"  LEFT JOIN h_poor_tuopin h5 ON p5.idno = h5.idno   " +
				" ) p6";
		logger.error(sql);
		if(dataGrid!=null){
			List<Map<String, Object>> totalList = super.findForJdbc("select count(0) total from (" + sql + ") t");
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