package com.jingzhun.difficultcrowd.controller;
import com.jingzhun.difficultcrowd.entity.HHardBasicLivingAllowancesEntity;
import com.jingzhun.difficultcrowd.service.HHardBasicLivingAllowancesServiceI;

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
 * @Description: 低保人员信息数据
 * @author onlineGenerator
 * @date 2019-03-22 11:28:09
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hHardBasicLivingAllowancesController")
public class HHardBasicLivingAllowancesController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(HHardBasicLivingAllowancesController.class);

	@Autowired
	private HHardBasicLivingAllowancesServiceI hHardBasicLivingAllowancesService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 低保人员信息数据列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/difficultcrowd/hHardBasicLivingAllowancesList");
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
	public void datagrid(HHardBasicLivingAllowancesEntity hHardBasicLivingAllowances,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HHardBasicLivingAllowancesEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hHardBasicLivingAllowances, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hHardBasicLivingAllowancesService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除低保人员信息数据
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HHardBasicLivingAllowancesEntity hHardBasicLivingAllowances, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hHardBasicLivingAllowances = systemService.getEntity(HHardBasicLivingAllowancesEntity.class, hHardBasicLivingAllowances.getId());
		message = "低保人员信息数据删除成功";
		try{
			hHardBasicLivingAllowancesService.delete(hHardBasicLivingAllowances);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "低保人员信息数据删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除低保人员信息数据
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "低保人员信息数据删除成功";
		try{
			for(String id:ids.split(",")){
				HHardBasicLivingAllowancesEntity hHardBasicLivingAllowances = systemService.getEntity(HHardBasicLivingAllowancesEntity.class, 
				Integer.parseInt(id)
				);
				hHardBasicLivingAllowancesService.delete(hHardBasicLivingAllowances);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "低保人员信息数据删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加低保人员信息数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HHardBasicLivingAllowancesEntity hHardBasicLivingAllowances, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "低保人员信息数据添加成功";
		try{
			hHardBasicLivingAllowancesService.save(hHardBasicLivingAllowances);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "低保人员信息数据添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新低保人员信息数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HHardBasicLivingAllowancesEntity hHardBasicLivingAllowances, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "低保人员信息数据更新成功";
		HHardBasicLivingAllowancesEntity t = hHardBasicLivingAllowancesService.get(HHardBasicLivingAllowancesEntity.class, hHardBasicLivingAllowances.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hHardBasicLivingAllowances, t);
			hHardBasicLivingAllowancesService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "低保人员信息数据更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 低保人员信息数据新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HHardBasicLivingAllowancesEntity hHardBasicLivingAllowances, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hHardBasicLivingAllowances.getId())) {
			hHardBasicLivingAllowances = hHardBasicLivingAllowancesService.getEntity(HHardBasicLivingAllowancesEntity.class, hHardBasicLivingAllowances.getId());
			req.setAttribute("hHardBasicLivingAllowances", hHardBasicLivingAllowances);
		}
		return new ModelAndView("com/jingzhun/difficultcrowd/hHardBasicLivingAllowances-add");
	}
	/**
	 * 低保人员信息数据编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HHardBasicLivingAllowancesEntity hHardBasicLivingAllowances, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hHardBasicLivingAllowances.getId())) {
			hHardBasicLivingAllowances = hHardBasicLivingAllowancesService.getEntity(HHardBasicLivingAllowancesEntity.class, hHardBasicLivingAllowances.getId());
			req.setAttribute("hHardBasicLivingAllowances", hHardBasicLivingAllowances);
		}
		return new ModelAndView("com/jingzhun/difficultcrowd/hHardBasicLivingAllowances-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hHardBasicLivingAllowancesController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HHardBasicLivingAllowancesEntity hHardBasicLivingAllowances,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HHardBasicLivingAllowancesEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hHardBasicLivingAllowances, request.getParameterMap());
		List<HHardBasicLivingAllowancesEntity> hHardBasicLivingAllowancess = this.hHardBasicLivingAllowancesService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"低保人员信息数据");
		modelMap.put(NormalExcelConstants.CLASS,HHardBasicLivingAllowancesEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("低保人员信息数据列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hHardBasicLivingAllowancess);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HHardBasicLivingAllowancesEntity hHardBasicLivingAllowances,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"低保人员信息数据");
    	modelMap.put(NormalExcelConstants.CLASS,HHardBasicLivingAllowancesEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("低保人员信息数据列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HHardBasicLivingAllowancesEntity> listHHardBasicLivingAllowancesEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HHardBasicLivingAllowancesEntity.class,params);
				for (HHardBasicLivingAllowancesEntity hHardBasicLivingAllowances : listHHardBasicLivingAllowancesEntitys) {
					hHardBasicLivingAllowancesService.save(hHardBasicLivingAllowances);
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
