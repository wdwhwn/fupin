package com.jingzhun.department.controller;
import com.jingzhun.department.entity.HTeamsEntity;
import com.jingzhun.department.service.HTeamsServiceI;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

/**   
 * @Title: Controller  
 * @Description: 爱心助困党员先锋队
 * @author onlineGenerator
 * @date 2019-03-22 17:18:32
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hTeamsController")
public class HTeamsController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(HTeamsController.class);

	@Autowired
	private HTeamsServiceI hTeamsService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 爱心助困党员先锋队列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/department/hTeamsList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(HTeamsEntity hTeams,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HTeamsEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hTeams, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hTeamsService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除爱心助困党员先锋队
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HTeamsEntity hTeams, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hTeams = systemService.getEntity(HTeamsEntity.class, hTeams.getId());
		message = "爱心助困党员先锋队删除成功";
		try{
			hTeamsService.delete(hTeams);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "爱心助困党员先锋队删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除爱心助困党员先锋队
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "爱心助困党员先锋队删除成功";
		try{
			for(String id:ids.split(",")){
				HTeamsEntity hTeams = systemService.getEntity(HTeamsEntity.class, 
				Integer.parseInt(id)
				);
				hTeamsService.delete(hTeams);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "爱心助困党员先锋队删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加爱心助困党员先锋队
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HTeamsEntity hTeams, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "爱心助困党员先锋队添加成功";
		try{
			hTeamsService.save(hTeams);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "爱心助困党员先锋队添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新爱心助困党员先锋队
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HTeamsEntity hTeams, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "爱心助困党员先锋队更新成功";
		HTeamsEntity t = hTeamsService.get(HTeamsEntity.class, hTeams.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hTeams, t);
			hTeamsService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "爱心助困党员先锋队更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 爱心助困党员先锋队新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HTeamsEntity hTeams, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hTeams.getId())) {
			hTeams = hTeamsService.getEntity(HTeamsEntity.class, hTeams.getId());
			req.setAttribute("hTeams", hTeams);
		}
		return new ModelAndView("com/jingzhun/department/hTeams-add");
	}
	/**
	 * 爱心助困党员先锋队编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HTeamsEntity hTeams, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hTeams.getId())) {
			hTeams = hTeamsService.getEntity(HTeamsEntity.class, hTeams.getId());
			req.setAttribute("hTeams", hTeams);
		}
		return new ModelAndView("com/jingzhun/department/hTeams-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hTeamsController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HTeamsEntity hTeams,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HTeamsEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hTeams, request.getParameterMap());
		List<HTeamsEntity> hTeamss = this.hTeamsService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"爱心助困党员先锋队");
		modelMap.put(NormalExcelConstants.CLASS,HTeamsEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("爱心助困党员先锋队列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hTeamss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HTeamsEntity hTeams,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"爱心助困党员先锋队");
    	modelMap.put(NormalExcelConstants.CLASS,HTeamsEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("爱心助困党员先锋队列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HTeamsEntity> listHTeamsEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HTeamsEntity.class,params);
				for (HTeamsEntity hTeams : listHTeamsEntitys) {
					hTeamsService.save(hTeams);
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
	
	
}
