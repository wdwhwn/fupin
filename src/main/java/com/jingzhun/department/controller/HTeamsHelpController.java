package com.jingzhun.department.controller;
import com.jingzhun.department.entity.HTeamsHelpEntity;
import com.jingzhun.department.service.HTeamsHelpServiceI;

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
 * @Description: 帮扶责任人
 * @author onlineGenerator
 * @date 2019-03-22 17:02:11
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hTeamsHelpController")
public class HTeamsHelpController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(HTeamsHelpController.class);

	@Autowired
	private HTeamsHelpServiceI hTeamsHelpService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 帮扶责任人列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/department/hTeamsHelpList");
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
	public void datagrid(HTeamsHelpEntity hTeamsHelp,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HTeamsHelpEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hTeamsHelp, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hTeamsHelpService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除帮扶责任人
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HTeamsHelpEntity hTeamsHelp, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hTeamsHelp = systemService.getEntity(HTeamsHelpEntity.class, hTeamsHelp.getId());
		message = "帮扶责任人删除成功";
		try{
			hTeamsHelpService.delete(hTeamsHelp);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "帮扶责任人删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除帮扶责任人
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "帮扶责任人删除成功";
		try{
			for(String id:ids.split(",")){
				HTeamsHelpEntity hTeamsHelp = systemService.getEntity(HTeamsHelpEntity.class, 
				Integer.parseInt(id)
				);
				hTeamsHelpService.delete(hTeamsHelp);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "帮扶责任人删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加帮扶责任人
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HTeamsHelpEntity hTeamsHelp, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "帮扶责任人添加成功";
		try{
			hTeamsHelpService.save(hTeamsHelp);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "帮扶责任人添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新帮扶责任人
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HTeamsHelpEntity hTeamsHelp, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "帮扶责任人更新成功";
		HTeamsHelpEntity t = hTeamsHelpService.get(HTeamsHelpEntity.class, hTeamsHelp.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hTeamsHelp, t);
			hTeamsHelpService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "帮扶责任人更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 帮扶责任人新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HTeamsHelpEntity hTeamsHelp, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hTeamsHelp.getId())) {
			hTeamsHelp = hTeamsHelpService.getEntity(HTeamsHelpEntity.class, hTeamsHelp.getId());
			req.setAttribute("hTeamsHelp", hTeamsHelp);
		}
		return new ModelAndView("com/jingzhun/department/hTeamsHelp-add");
	}
	/**
	 * 帮扶责任人编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HTeamsHelpEntity hTeamsHelp, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hTeamsHelp.getId())) {
			hTeamsHelp = hTeamsHelpService.getEntity(HTeamsHelpEntity.class, hTeamsHelp.getId());
			req.setAttribute("hTeamsHelp", hTeamsHelp);
		}
		return new ModelAndView("com/jingzhun/department/hTeamsHelp-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hTeamsHelpController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HTeamsHelpEntity hTeamsHelp,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HTeamsHelpEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hTeamsHelp, request.getParameterMap());
		List<HTeamsHelpEntity> hTeamsHelps = this.hTeamsHelpService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"帮扶责任人");
		modelMap.put(NormalExcelConstants.CLASS,HTeamsHelpEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("帮扶责任人列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hTeamsHelps);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HTeamsHelpEntity hTeamsHelp,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"帮扶责任人");
    	modelMap.put(NormalExcelConstants.CLASS,HTeamsHelpEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("帮扶责任人列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HTeamsHelpEntity> listHTeamsHelpEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HTeamsHelpEntity.class,params);
				for (HTeamsHelpEntity hTeamsHelp : listHTeamsHelpEntitys) {
					hTeamsHelpService.save(hTeamsHelp);
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
