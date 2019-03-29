package com.jingzhun.poordatemanager.controller;
import com.jingzhun.poordatemanager.entity.HPoorHouseholdEntity;
import com.jingzhun.poordatemanager.entity.PoorHouseholdEntity;
import com.jingzhun.poordatemanager.service.PoorHouseholdServiceI;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import java.util.HashMap;
/**   
 * @Title: Controller  
 * @Description: 贫困户表
 * @author onlineGenerator
 * @date 2019-03-28 14:30:00
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/poorHouseholdController")
public class PoorHouseholdController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(PoorHouseholdController.class);

	@Autowired
	private PoorHouseholdServiceI poorHouseholdService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	@RequestMapping(params="getTreeDemoData",method ={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public AjaxJson getTreeDemoData(TSDepart depatr, HttpServletResponse response, HttpServletRequest request ){
		AjaxJson j = new AjaxJson();
		try{
//			+++++++++++++
			String sql	="select id,tid,vsname from h_sys_village_tree ";
			List<Map<String, Object>> forJdbc = poorHouseholdService.findForJdbc(sql);
			logger.error(forJdbc.toString()+"AAAAAAAAAAAAAA");
//			+++++++++++++++++++++
			List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
			Map<String,Object> map = null;
			for (Map<String,Object> map1 : forJdbc) {
				map = new HashMap<String,Object>();
				map.put("chkDisabled",false);
				map.put("click", true);
				map.put("id", map1.get("id"));
				map.put("name", map1.get("vsname"));
				map.put("nocheck", false);
				map.put("struct","TREE");
				map.put("title",map1.get("vsname"));
				map.put("iconSkin","SCHEMA");
				if (map1.get("tid") != null) {
					map.put("parentId",map1.get("tid"));
				}else {
					map.put("parentId","0");
				}
				dataList.add(map);
			}
			j.setObj(dataList);
		}catch(Exception e){
			e.printStackTrace();
		}
		return j;
	}
	/**
	 * easyui AJAX请求数据
	 *
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(HPoorHouseholdEntity hPoorHousehold, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		/*CriteriaQuery cq = new CriteriaQuery(HPoorHouseholdEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hPoorHousehold, request.getParameterMap());
		try{
		//自定义追加查询条件

		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hPoorHouseholdService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);*/
//		String bomType =request.getParameter("bomType");
		String curSelectNodeId=request.getParameter("id");
		String orgCode = ResourceUtil.getSessionUser().getCurrentDepart().getOrgCode();
		HashMap<String, Object> conditionMap = new HashMap<>();
//        logger.error("bomType"+bomType+"  "+orgCode);
		conditionMap.put("orgCode",orgCode);
//		conditionMap.put("bomType",bomType);
		try {
			List<Map<String, Object>> resultMapList = poorHouseholdService.getPoorDate(conditionMap, dataGrid,curSelectNodeId);
			dataGrid.setResults(resultMapList);
		} catch (Exception e) {
			logger.error(e.toString(),e);
			e.printStackTrace();
		}
		TagUtil.datagrid(response,dataGrid);
	}


	/**
	 * 贫困户表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/poordatemanager/poorHouseholdList");
	}

	
	/**
	 * 删除贫困户表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(PoorHouseholdEntity poorHousehold, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		poorHousehold = systemService.getEntity(PoorHouseholdEntity.class, poorHousehold.getId());
		message = "贫困户表删除成功";
		try{
			poorHouseholdService.delete(poorHousehold);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "贫困户表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除贫困户表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "贫困户表删除成功";
		try{
			for(String id:ids.split(",")){
				PoorHouseholdEntity poorHousehold = systemService.getEntity(PoorHouseholdEntity.class, 
				Integer.parseInt(id)
				);
				poorHouseholdService.delete(poorHousehold);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "贫困户表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加贫困户表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(PoorHouseholdEntity poorHousehold, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "贫困户表添加成功";
		try{
			poorHouseholdService.save(poorHousehold);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "贫困户表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新贫困户表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(PoorHouseholdEntity poorHousehold, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "贫困户表更新成功";
		PoorHouseholdEntity t = poorHouseholdService.get(PoorHouseholdEntity.class, poorHousehold.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(poorHousehold, t);
			poorHouseholdService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "贫困户表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 贫困户表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(PoorHouseholdEntity poorHousehold, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(poorHousehold.getId())) {
			poorHousehold = poorHouseholdService.getEntity(PoorHouseholdEntity.class, poorHousehold.getId());
			req.setAttribute("poorHousehold", poorHousehold);
		}
		return new ModelAndView("com/jingzhun/poordatemanager/poorHousehold-add");
	}
	/**
	 * 贫困户表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(PoorHouseholdEntity poorHousehold, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(poorHousehold.getId())) {
			poorHousehold = poorHouseholdService.getEntity(PoorHouseholdEntity.class, poorHousehold.getId());
			req.setAttribute("poorHousehold", poorHousehold);
		}
		return new ModelAndView("com/jingzhun/poordatemanager/poorHousehold-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","poorHouseholdController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(PoorHouseholdEntity poorHousehold,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(PoorHouseholdEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, poorHousehold, request.getParameterMap());
		List<PoorHouseholdEntity> poorHouseholds = this.poorHouseholdService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"贫困户表");
		modelMap.put(NormalExcelConstants.CLASS,PoorHouseholdEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("贫困户表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,poorHouseholds);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(PoorHouseholdEntity poorHousehold,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"贫困户表");
    	modelMap.put(NormalExcelConstants.CLASS,PoorHouseholdEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("贫困户表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<PoorHouseholdEntity> listPoorHouseholdEntitys = ExcelImportUtil.importExcel(file.getInputStream(),PoorHouseholdEntity.class,params);
				for (PoorHouseholdEntity poorHousehold : listPoorHouseholdEntitys) {
					poorHouseholdService.save(poorHousehold);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	/**
	 * 获取文件附件信息
	 * 
	 * @param id poorHousehold主键id
	 */
	@RequestMapping(params = "getFiles")
	@ResponseBody
	public AjaxJson getFiles(String id){
		List<CgUploadEntity> uploadBeans = cgFormFieldService.findByProperty(CgUploadEntity.class, "cgformId", id);
		List<Map<String,Object>> files = new ArrayList<Map<String,Object>>(0);
		for(CgUploadEntity b:uploadBeans){
			String title = b.getAttachmenttitle();//附件名
			String fileKey = b.getId();//附件主键
			String path = b.getRealpath();//附件路径
			String field = b.getCgformField();//表单中作为附件控件的字段
			Map<String, Object> file = new HashMap<String, Object>();
			file.put("title", title);
			file.put("fileKey", fileKey);
			file.put("path", path);
			file.put("field", field==null?"":field);
			files.add(file);
		}
		AjaxJson j = new AjaxJson();
		j.setObj(files);
		return j;
	}
    /**
     * 贫困户表列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "list1")
    public ModelAndView list1(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("com/jingzhun/poordatemanager/table");
        modelAndView.addObject("id",request.getParameter("id"));
        logger.error(request.getParameter("id"));
        return modelAndView;
    }
	@RequestMapping(params = "selectOne")
    @ResponseBody
	public AjaxJson selectOne(HPoorHouseholdEntity hPoorHousehold, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        AjaxJson j = new AjaxJson();
        Map<String, Object> id1 = null;
        try {
            String id=request.getParameter("id");
            id1 = poorHouseholdService.selectOne("id");
        } catch (Exception e) {
            j.setMsg("查询失败");
            e.printStackTrace();
        }
            j.setMsg("查询成功");
            j.setObj(id1);
            return j;
    }
	
}
