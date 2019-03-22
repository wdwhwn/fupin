package com.jingzhun.difficultcrowd.controller;
import com.jingzhun.difficultcrowd.entity.HMedicalAssistanceEntity;
import com.jingzhun.difficultcrowd.service.HMedicalAssistanceServiceI;

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
 * @Description: 低保五保救助台账
 * @author onlineGenerator
 * @date 2019-03-22 11:29:15
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hMedicalAssistanceController")
public class HMedicalAssistanceController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(HMedicalAssistanceController.class);

	@Autowired
	private HMedicalAssistanceServiceI hMedicalAssistanceService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 低保五保救助台账列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/difficultcrowd/hMedicalAssistanceList");
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
	public void datagrid(HMedicalAssistanceEntity hMedicalAssistance,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HMedicalAssistanceEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hMedicalAssistance, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hMedicalAssistanceService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除低保五保救助台账
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HMedicalAssistanceEntity hMedicalAssistance, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hMedicalAssistance = systemService.getEntity(HMedicalAssistanceEntity.class, hMedicalAssistance.getId());
		message = "低保五保救助台账删除成功";
		try{
			hMedicalAssistanceService.delete(hMedicalAssistance);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "低保五保救助台账删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除低保五保救助台账
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "低保五保救助台账删除成功";
		try{
			for(String id:ids.split(",")){
				HMedicalAssistanceEntity hMedicalAssistance = systemService.getEntity(HMedicalAssistanceEntity.class, 
				Integer.parseInt(id)
				);
				hMedicalAssistanceService.delete(hMedicalAssistance);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "低保五保救助台账删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加低保五保救助台账
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HMedicalAssistanceEntity hMedicalAssistance, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "低保五保救助台账添加成功";
		try{
			hMedicalAssistanceService.save(hMedicalAssistance);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "低保五保救助台账添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新低保五保救助台账
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HMedicalAssistanceEntity hMedicalAssistance, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "低保五保救助台账更新成功";
		HMedicalAssistanceEntity t = hMedicalAssistanceService.get(HMedicalAssistanceEntity.class, hMedicalAssistance.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hMedicalAssistance, t);
			hMedicalAssistanceService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "低保五保救助台账更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 低保五保救助台账新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HMedicalAssistanceEntity hMedicalAssistance, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hMedicalAssistance.getId())) {
			hMedicalAssistance = hMedicalAssistanceService.getEntity(HMedicalAssistanceEntity.class, hMedicalAssistance.getId());
			req.setAttribute("hMedicalAssistance", hMedicalAssistance);
		}
		return new ModelAndView("com/jingzhun/difficultcrowd/hMedicalAssistance-add");
	}
	/**
	 * 低保五保救助台账编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HMedicalAssistanceEntity hMedicalAssistance, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hMedicalAssistance.getId())) {
			hMedicalAssistance = hMedicalAssistanceService.getEntity(HMedicalAssistanceEntity.class, hMedicalAssistance.getId());
			req.setAttribute("hMedicalAssistance", hMedicalAssistance);
		}
		return new ModelAndView("com/jingzhun/difficultcrowd/hMedicalAssistance-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hMedicalAssistanceController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HMedicalAssistanceEntity hMedicalAssistance,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HMedicalAssistanceEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hMedicalAssistance, request.getParameterMap());
		List<HMedicalAssistanceEntity> hMedicalAssistances = this.hMedicalAssistanceService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"低保五保救助台账");
		modelMap.put(NormalExcelConstants.CLASS,HMedicalAssistanceEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("低保五保救助台账列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hMedicalAssistances);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HMedicalAssistanceEntity hMedicalAssistance,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"低保五保救助台账");
    	modelMap.put(NormalExcelConstants.CLASS,HMedicalAssistanceEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("低保五保救助台账列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HMedicalAssistanceEntity> listHMedicalAssistanceEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HMedicalAssistanceEntity.class,params);
				for (HMedicalAssistanceEntity hMedicalAssistance : listHMedicalAssistanceEntitys) {
					hMedicalAssistanceService.save(hMedicalAssistance);
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
