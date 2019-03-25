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
	public List<Map<String, Object>> getPoorStarList(Map<String, Object> conditionMap, DataGrid dataGrid) {
		List<Map<String, Object>> resultMapList=new ArrayList<Map<String,Object>>();
		String sql="SELECT " +
				" p6.id, " +
				" p6.jiedao, " +
				" p6.NAME, " +
				" p6.idno, " +
				" p6.cunzhuang, " +
				" p6.selfFee, " +
				" p6.canji, " +
				" p6.dibao, " +
				" p6.tekun, " +
				" p6.guer, " +
				" p6.kunjingertong, " +
				" p6.tuopinbuxiangshou, " +
				" p6.result, " +
				" ( canji + dibao + tekun + guer + kunjingertong + tuopinbuxiangshou + 1 ) count  " +
				"FROM " +
				" ( " +
				" SELECT " +
				"  p5.id, " +
				"  p5.jiedao, " +
				"  p5.NAME, " +
				"  p5.idno, " +
				"  p5.cunzhuang, " +
				"  p5.selfFee, " +
				"  p5.canji, " +
				"  p5.dibao, " +
				"  p5.tekun, " +
				"  p5.guer, " +
				"  p5.kunjingertong, " +
				"  p5.result, " +
				" IF " +
				"  ( h5.id, 1, 0 ) tuopinbuxiangshou  " +
				" FROM " +
				"  ( " +
				"  SELECT " +
				"   p4.id, " +
				"   p4.jiedao, " +
				"   p4.NAME, " +
				"   p4.idno, " +
				"   p4.cunzhuang, " +
				"   p4.selfFee, " +
				"   p4.canji, " +
				"   p4.dibao, " +
				"   p4.tekun, " +
				"   p4.guer, " +
				"   p4.result, " +
				"  IF " +
				"   ( h4.id, 1, 0 ) kunjingertong  " +
				"  FROM " +
				"   ( " +
				"   SELECT " +
				"    p3.id, " +
				"    p3.jiedao, " +
				"    p3.NAME, " +
				"    p3.idno, " +
				"    p3.cunzhuang, " +
				"    p3.selfFee, " +
				"    p3.canji, " +
				"    p3.dibao, " +
				"    p3.tekun, " +
				"    p3.result, " +
				"   IF " +
				"    ( h3.id, 1, 0 ) guer  " +
				"   FROM " +
				"    ( " +
				"    SELECT " +
				"     p2.id, " +
				"     p2.jiedao, " +
				"     p2.NAME, " +
				"     p2.idno, " +
				"     p2.cunzhuang, " +
				"     p2.selfFee, " +
				"     p2.canji, " +
				"     p2.dibao, " +
				"     p2.result, " +
				"    IF " +
				"     ( h2.id, 1, 0 ) tekun  " +
				"    FROM " +
				"     ( " +
				"     SELECT " +
				"      p1.id, " +
				"      p1.jiedao, " +
				"      p1.NAME, " +
				"      p1.idno, " +
				"      p1.cunzhuang, " +
				"      p1.selfFee, " +
				"      p1.canji, " +
				"      p1.result, " +
				"     IF " +
				"      ( a1.id, 1, 0 ) dibao  " +
				"     FROM " +
				"      ( " +
				"      SELECT " +
				"       h1.id, " +
				"       h1.jiedao, " +
				"       h1.cunzhuang, " +
				"       h1.NAME, " +
				"       h1.IDNO, " +
				"      IF " +
				"       ( c.hid, 1, 0 ) canji, " +
				"       h1.result, " +
				"       h1.selfFee  " +
				"      FROM " +
				"       ( " +
				"       SELECT " +
				"        t.id, " +
				"        t.jiedao, " +
				"        t.cunzhuang, " +
				"        t.NAME, " +
				"        t.IDNO, " +
				"        t.result, " +
				"        t.selfFee  " +
				"       FROM " +
				"        ( " +
				"        SELECT " +
				"         h.id, " +
				"         h.jiedao, " +
				"         h.cunzhuang, " +
				"         h.NAME, " +
				"         h.IDNO, " +
				"         result, " +
				"         Round(sum( self_fee  ),2) selfFee  " +
				"        FROM " +
				"         h_hospital_send h  " +
				"        WHERE " +
				"         result BETWEEN 0  " +
				"         AND 1  " +
				"        GROUP BY " +
				"         idno, " +
				"         result_date  " +
				"        ORDER BY " +
				"         id  " +
				"        ) t  " +
				"       WHERE " +
				"        t.selfFee >= 20000  " +
				"       ) h1 " +
				"       LEFT JOIN ( SELECT SUBSTRING( idno, 1, 18 ) idno, id hid FROM h_hard_household ) c ON h1.idno = c.idno  " +
				"      ) p1 " +
				"      LEFT JOIN h_hard_basic_living_allowances a1 ON p1.idno = a1.IDNO  " +
				"     ) p2 " +
				"     LEFT JOIN h_hard_insurance h2 ON p2.idno = h2.IDNO  " +
				"    ) p3 " +
				"    LEFT JOIN h_hard_orphan h3 ON p3.idno = h3.idno  " +
				"   ) p4 " +
				"   LEFT JOIN h_hard_children h4 ON p4.idno = h4.idno  " +
				"  ) p5 " +
				" LEFT JOIN h_poor_tuopin h5 ON p5.idno = h5.idno  " +
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