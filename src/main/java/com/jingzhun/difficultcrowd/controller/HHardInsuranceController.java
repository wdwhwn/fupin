package com.jingzhun.difficultcrowd.controller;
import com.jingzhun.difficultcrowd.entity.HHardInsuranceEntity;
import com.jingzhun.difficultcrowd.service.HHardInsuranceServiceI;

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
 * @Description: 特困供养人员信息
 * @author onlineGenerator
 * @date 2019-03-22 09:41:48
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hHardInsuranceController")
public class HHardInsuranceController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(HHardInsuranceController.class);

	@Autowired
	private HHardInsuranceServiceI hHardInsuranceService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 特困供养人员信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/difficultcrowd/hHardInsuranceList");
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
	public void datagrid(HHardInsuranceEntity hHardInsurance,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HHardInsuranceEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hHardInsurance, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hHardInsuranceService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除特困供养人员信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HHardInsuranceEntity hHardInsurance, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hHardInsurance = systemService.getEntity(HHardInsuranceEntity.class, hHardInsurance.getId());
		message = "特困供养人员信息删除成功";
		try{
			hHardInsuranceService.delete(hHardInsurance);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "特困供养人员信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除特困供养人员信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "特困供养人员信息删除成功";
		try{
			for(String id:ids.split(",")){
				HHardInsuranceEntity hHardInsurance = systemService.getEntity(HHardInsuranceEntity.class, 
				Integer.parseInt(id)
				);
				hHardInsuranceService.delete(hHardInsurance);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "特困供养人员信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加特困供养人员信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HHardInsuranceEntity hHardInsurance, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "特困供养人员信息添加成功";
		try{
			hHardInsuranceService.save(hHardInsurance);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "特困供养人员信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新特困供养人员信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HHardInsuranceEntity hHardInsurance, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "特困供养人员信息更新成功";
		HHardInsuranceEntity t = hHardInsuranceService.get(HHardInsuranceEntity.class, hHardInsurance.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hHardInsurance, t);
			hHardInsuranceService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "特困供养人员信息更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 特困供养人员信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HHardInsuranceEntity hHardInsurance, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hHardInsurance.getId())) {
			hHardInsurance = hHardInsuranceService.getEntity(HHardInsuranceEntity.class, hHardInsurance.getId());
			req.setAttribute("hHardInsurance", hHardInsurance);
		}
		return new ModelAndView("com/jingzhun/difficultcrowd/hHardInsurance-add");
	}
	/**
	 * 特困供养人员信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HHardInsuranceEntity hHardInsurance, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hHardInsurance.getId())) {
			hHardInsurance = hHardInsuranceService.getEntity(HHardInsuranceEntity.class, hHardInsurance.getId());
			req.setAttribute("hHardInsurance", hHardInsurance);
		}
		return new ModelAndView("com/jingzhun/difficultcrowd/hHardInsurance-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hHardInsuranceController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HHardInsuranceEntity hHardInsurance,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HHardInsuranceEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hHardInsurance, request.getParameterMap());
		List<HHardInsuranceEntity> hHardInsurances = this.hHardInsuranceService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"特困供养人员信息");
		modelMap.put(NormalExcelConstants.CLASS,HHardInsuranceEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("特困供养人员信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hHardInsurances);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HHardInsuranceEntity hHardInsurance,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"特困供养人员信息");
    	modelMap.put(NormalExcelConstants.CLASS,HHardInsuranceEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("特困供养人员信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HHardInsuranceEntity> listHHardInsuranceEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HHardInsuranceEntity.class,params);
				for (HHardInsuranceEntity hHardInsurance : listHHardInsuranceEntitys) {
					hHardInsuranceService.save(hHardInsurance);
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
