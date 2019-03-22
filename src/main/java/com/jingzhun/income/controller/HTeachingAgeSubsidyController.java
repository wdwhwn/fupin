package com.jingzhun.income.controller;
import com.jingzhun.income.entity.HTeachingAgeSubsidyEntity;
import com.jingzhun.income.service.HTeachingAgeSubsidyServiceI;

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
 * @Description: 原民办代课教师教龄补助
 * @author onlineGenerator
 * @date 2019-03-22 16:58:20
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hTeachingAgeSubsidyController")
public class HTeachingAgeSubsidyController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(HTeachingAgeSubsidyController.class);

	@Autowired
	private HTeachingAgeSubsidyServiceI hTeachingAgeSubsidyService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 原民办代课教师教龄补助列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/income/hTeachingAgeSubsidyList");
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
	public void datagrid(HTeachingAgeSubsidyEntity hTeachingAgeSubsidy,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HTeachingAgeSubsidyEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hTeachingAgeSubsidy, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hTeachingAgeSubsidyService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除原民办代课教师教龄补助
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HTeachingAgeSubsidyEntity hTeachingAgeSubsidy, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hTeachingAgeSubsidy = systemService.getEntity(HTeachingAgeSubsidyEntity.class, hTeachingAgeSubsidy.getId());
		message = "原民办代课教师教龄补助删除成功";
		try{
			hTeachingAgeSubsidyService.delete(hTeachingAgeSubsidy);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "原民办代课教师教龄补助删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除原民办代课教师教龄补助
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "原民办代课教师教龄补助删除成功";
		try{
			for(String id:ids.split(",")){
				HTeachingAgeSubsidyEntity hTeachingAgeSubsidy = systemService.getEntity(HTeachingAgeSubsidyEntity.class, 
				Integer.parseInt(id)
				);
				hTeachingAgeSubsidyService.delete(hTeachingAgeSubsidy);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "原民办代课教师教龄补助删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加原民办代课教师教龄补助
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HTeachingAgeSubsidyEntity hTeachingAgeSubsidy, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "原民办代课教师教龄补助添加成功";
		try{
			hTeachingAgeSubsidyService.save(hTeachingAgeSubsidy);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "原民办代课教师教龄补助添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新原民办代课教师教龄补助
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HTeachingAgeSubsidyEntity hTeachingAgeSubsidy, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "原民办代课教师教龄补助更新成功";
		HTeachingAgeSubsidyEntity t = hTeachingAgeSubsidyService.get(HTeachingAgeSubsidyEntity.class, hTeachingAgeSubsidy.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hTeachingAgeSubsidy, t);
			hTeachingAgeSubsidyService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "原民办代课教师教龄补助更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 原民办代课教师教龄补助新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HTeachingAgeSubsidyEntity hTeachingAgeSubsidy, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hTeachingAgeSubsidy.getId())) {
			hTeachingAgeSubsidy = hTeachingAgeSubsidyService.getEntity(HTeachingAgeSubsidyEntity.class, hTeachingAgeSubsidy.getId());
			req.setAttribute("hTeachingAgeSubsidy", hTeachingAgeSubsidy);
		}
		return new ModelAndView("com/jingzhun/income/hTeachingAgeSubsidy-add");
	}
	/**
	 * 原民办代课教师教龄补助编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HTeachingAgeSubsidyEntity hTeachingAgeSubsidy, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hTeachingAgeSubsidy.getId())) {
			hTeachingAgeSubsidy = hTeachingAgeSubsidyService.getEntity(HTeachingAgeSubsidyEntity.class, hTeachingAgeSubsidy.getId());
			req.setAttribute("hTeachingAgeSubsidy", hTeachingAgeSubsidy);
		}
		return new ModelAndView("com/jingzhun/income/hTeachingAgeSubsidy-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hTeachingAgeSubsidyController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HTeachingAgeSubsidyEntity hTeachingAgeSubsidy,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HTeachingAgeSubsidyEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hTeachingAgeSubsidy, request.getParameterMap());
		List<HTeachingAgeSubsidyEntity> hTeachingAgeSubsidys = this.hTeachingAgeSubsidyService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"原民办代课教师教龄补助");
		modelMap.put(NormalExcelConstants.CLASS,HTeachingAgeSubsidyEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("原民办代课教师教龄补助列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hTeachingAgeSubsidys);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HTeachingAgeSubsidyEntity hTeachingAgeSubsidy,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"原民办代课教师教龄补助");
    	modelMap.put(NormalExcelConstants.CLASS,HTeachingAgeSubsidyEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("原民办代课教师教龄补助列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HTeachingAgeSubsidyEntity> listHTeachingAgeSubsidyEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HTeachingAgeSubsidyEntity.class,params);
				for (HTeachingAgeSubsidyEntity hTeachingAgeSubsidy : listHTeachingAgeSubsidyEntitys) {
					hTeachingAgeSubsidyService.save(hTeachingAgeSubsidy);
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
