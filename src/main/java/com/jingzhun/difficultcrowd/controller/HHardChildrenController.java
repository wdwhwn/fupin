package com.jingzhun.difficultcrowd.controller;
import com.jingzhun.difficultcrowd.entity.HHardChildrenEntity;
import com.jingzhun.difficultcrowd.service.HHardChildrenServiceI;

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
 * @Description: 困境儿童数据
 * @author onlineGenerator
 * @date 2019-03-22 11:23:50
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hHardChildrenController")
public class HHardChildrenController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(HHardChildrenController.class);

	@Autowired
	private HHardChildrenServiceI hHardChildrenService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 困境儿童数据列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/difficultcrowd/hHardChildrenList");
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
	public void datagrid(HHardChildrenEntity hHardChildren,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HHardChildrenEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hHardChildren, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hHardChildrenService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除困境儿童数据
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HHardChildrenEntity hHardChildren, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hHardChildren = systemService.getEntity(HHardChildrenEntity.class, hHardChildren.getId());
		message = "困境儿童数据删除成功";
		try{
			hHardChildrenService.delete(hHardChildren);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "困境儿童数据删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除困境儿童数据
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "困境儿童数据删除成功";
		try{
			for(String id:ids.split(",")){
				HHardChildrenEntity hHardChildren = systemService.getEntity(HHardChildrenEntity.class, 
				Integer.parseInt(id)
				);
				hHardChildrenService.delete(hHardChildren);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "困境儿童数据删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加困境儿童数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HHardChildrenEntity hHardChildren, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "困境儿童数据添加成功";
		try{
			hHardChildrenService.save(hHardChildren);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "困境儿童数据添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新困境儿童数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HHardChildrenEntity hHardChildren, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "困境儿童数据更新成功";
		HHardChildrenEntity t = hHardChildrenService.get(HHardChildrenEntity.class, hHardChildren.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hHardChildren, t);
			hHardChildrenService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "困境儿童数据更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 困境儿童数据新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HHardChildrenEntity hHardChildren, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hHardChildren.getId())) {
			hHardChildren = hHardChildrenService.getEntity(HHardChildrenEntity.class, hHardChildren.getId());
			req.setAttribute("hHardChildren", hHardChildren);
		}
		return new ModelAndView("com/jingzhun/difficultcrowd/hHardChildren-add");
	}
	/**
	 * 困境儿童数据编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HHardChildrenEntity hHardChildren, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hHardChildren.getId())) {
			hHardChildren = hHardChildrenService.getEntity(HHardChildrenEntity.class, hHardChildren.getId());
			req.setAttribute("hHardChildren", hHardChildren);
		}
		return new ModelAndView("com/jingzhun/difficultcrowd/hHardChildren-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hHardChildrenController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HHardChildrenEntity hHardChildren,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HHardChildrenEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hHardChildren, request.getParameterMap());
		List<HHardChildrenEntity> hHardChildrens = this.hHardChildrenService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"困境儿童数据");
		modelMap.put(NormalExcelConstants.CLASS,HHardChildrenEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("困境儿童数据列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hHardChildrens);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HHardChildrenEntity hHardChildren,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"困境儿童数据");
    	modelMap.put(NormalExcelConstants.CLASS,HHardChildrenEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("困境儿童数据列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HHardChildrenEntity> listHHardChildrenEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HHardChildrenEntity.class,params);
				for (HHardChildrenEntity hHardChildren : listHHardChildrenEntitys) {
					hHardChildrenService.save(hHardChildren);
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
