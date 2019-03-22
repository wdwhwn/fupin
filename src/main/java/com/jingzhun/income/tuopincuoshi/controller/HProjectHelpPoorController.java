package com.jingzhun.income.tuopincuoshi.controller;
import com.jingzhun.income.tuopincuoshi.entity.HProjectHelpPoorEntity;
import com.jingzhun.income.tuopincuoshi.service.HProjectHelpPoorServiceI;

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
 * @Description: 项目脱贫
 * @author onlineGenerator
 * @date 2019-03-22 12:54:56
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hProjectHelpPoorController")
public class HProjectHelpPoorController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(HProjectHelpPoorController.class);

	@Autowired
	private HProjectHelpPoorServiceI hProjectHelpPoorService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 项目脱贫列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/income.tuopincuoshi/hProjectHelpPoorList");
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
	public void datagrid(HProjectHelpPoorEntity hProjectHelpPoor,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HProjectHelpPoorEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hProjectHelpPoor, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hProjectHelpPoorService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除项目脱贫
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HProjectHelpPoorEntity hProjectHelpPoor, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hProjectHelpPoor = systemService.getEntity(HProjectHelpPoorEntity.class, hProjectHelpPoor.getId());
		message = "项目脱贫删除成功";
		try{
			hProjectHelpPoorService.delete(hProjectHelpPoor);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "项目脱贫删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除项目脱贫
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "项目脱贫删除成功";
		try{
			for(String id:ids.split(",")){
				HProjectHelpPoorEntity hProjectHelpPoor = systemService.getEntity(HProjectHelpPoorEntity.class, 
				Integer.parseInt(id)
				);
				hProjectHelpPoorService.delete(hProjectHelpPoor);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "项目脱贫删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加项目脱贫
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HProjectHelpPoorEntity hProjectHelpPoor, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "项目脱贫添加成功";
		try{
			hProjectHelpPoorService.save(hProjectHelpPoor);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "项目脱贫添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新项目脱贫
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HProjectHelpPoorEntity hProjectHelpPoor, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "项目脱贫更新成功";
		HProjectHelpPoorEntity t = hProjectHelpPoorService.get(HProjectHelpPoorEntity.class, hProjectHelpPoor.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hProjectHelpPoor, t);
			hProjectHelpPoorService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "项目脱贫更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 项目脱贫新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HProjectHelpPoorEntity hProjectHelpPoor, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hProjectHelpPoor.getId())) {
			hProjectHelpPoor = hProjectHelpPoorService.getEntity(HProjectHelpPoorEntity.class, hProjectHelpPoor.getId());
			req.setAttribute("hProjectHelpPoor", hProjectHelpPoor);
		}
		return new ModelAndView("com/jingzhun/income.tuopincuoshi/hProjectHelpPoor-add");
	}
	/**
	 * 项目脱贫编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HProjectHelpPoorEntity hProjectHelpPoor, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hProjectHelpPoor.getId())) {
			hProjectHelpPoor = hProjectHelpPoorService.getEntity(HProjectHelpPoorEntity.class, hProjectHelpPoor.getId());
			req.setAttribute("hProjectHelpPoor", hProjectHelpPoor);
		}
		return new ModelAndView("com/jingzhun/income.tuopincuoshi/hProjectHelpPoor-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hProjectHelpPoorController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HProjectHelpPoorEntity hProjectHelpPoor,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HProjectHelpPoorEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hProjectHelpPoor, request.getParameterMap());
		List<HProjectHelpPoorEntity> hProjectHelpPoors = this.hProjectHelpPoorService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"项目脱贫");
		modelMap.put(NormalExcelConstants.CLASS,HProjectHelpPoorEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("项目脱贫列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hProjectHelpPoors);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HProjectHelpPoorEntity hProjectHelpPoor,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"项目脱贫");
    	modelMap.put(NormalExcelConstants.CLASS,HProjectHelpPoorEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("项目脱贫列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HProjectHelpPoorEntity> listHProjectHelpPoorEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HProjectHelpPoorEntity.class,params);
				for (HProjectHelpPoorEntity hProjectHelpPoor : listHProjectHelpPoorEntitys) {
					hProjectHelpPoorService.save(hProjectHelpPoor);
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
