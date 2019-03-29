package com.jingzhun.poordatemanager.controller;
import com.jingzhun.poordatemanager.entity.HPoorIncomeEntity;
import com.jingzhun.poordatemanager.service.HPoorIncomeServiceI;

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
 * @Description: 财产收入
 * @author onlineGenerator
 * @date 2019-03-29 15:27:30
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hPoorIncomeController")
public class HPoorIncomeController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(HPoorIncomeController.class);

	@Autowired
	private HPoorIncomeServiceI hPoorIncomeService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 财产收入列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/poordatemanager/hPoorIncomeList");
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
	public void datagrid(HPoorIncomeEntity hPoorIncome,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HPoorIncomeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hPoorIncome, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hPoorIncomeService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除财产收入
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HPoorIncomeEntity hPoorIncome, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hPoorIncome = systemService.getEntity(HPoorIncomeEntity.class, hPoorIncome.getId());
		message = "财产收入删除成功";
		try{
			hPoorIncomeService.delete(hPoorIncome);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "财产收入删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除财产收入
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "财产收入删除成功";
		try{
			for(String id:ids.split(",")){
				HPoorIncomeEntity hPoorIncome = systemService.getEntity(HPoorIncomeEntity.class, 
				Integer.parseInt(id)
				);
				hPoorIncomeService.delete(hPoorIncome);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "财产收入删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加财产收入
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HPoorIncomeEntity hPoorIncome, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "财产收入添加成功";
		try{
			hPoorIncomeService.save(hPoorIncome);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "财产收入添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新财产收入
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HPoorIncomeEntity hPoorIncome, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "财产收入更新成功";
		HPoorIncomeEntity t = hPoorIncomeService.get(HPoorIncomeEntity.class, hPoorIncome.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hPoorIncome, t);
			hPoorIncomeService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "财产收入更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 财产收入新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HPoorIncomeEntity hPoorIncome, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hPoorIncome.getId())) {
			hPoorIncome = hPoorIncomeService.getEntity(HPoorIncomeEntity.class, hPoorIncome.getId());
			req.setAttribute("hPoorIncome", hPoorIncome);
		}
		return new ModelAndView("com/jingzhun/poordatemanager/hPoorIncome-add");
	}
	/**
	 * 财产收入编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HPoorIncomeEntity hPoorIncome, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hPoorIncome.getId())) {
			hPoorIncome = hPoorIncomeService.getEntity(HPoorIncomeEntity.class, hPoorIncome.getId());
			req.setAttribute("hPoorIncome", hPoorIncome);
		}
		return new ModelAndView("com/jingzhun/poordatemanager/hPoorIncome-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hPoorIncomeController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HPoorIncomeEntity hPoorIncome,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HPoorIncomeEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hPoorIncome, request.getParameterMap());
		List<HPoorIncomeEntity> hPoorIncomes = this.hPoorIncomeService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"财产收入");
		modelMap.put(NormalExcelConstants.CLASS,HPoorIncomeEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("财产收入列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hPoorIncomes);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HPoorIncomeEntity hPoorIncome,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"财产收入");
    	modelMap.put(NormalExcelConstants.CLASS,HPoorIncomeEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("财产收入列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HPoorIncomeEntity> listHPoorIncomeEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HPoorIncomeEntity.class,params);
				for (HPoorIncomeEntity hPoorIncome : listHPoorIncomeEntitys) {
					hPoorIncomeService.save(hPoorIncome);
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
