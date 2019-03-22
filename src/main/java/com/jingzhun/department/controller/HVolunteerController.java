package com.jingzhun.department.controller;
import com.jingzhun.department.entity.HVolunteerEntity;
import com.jingzhun.department.service.HVolunteerServiceI;

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
 * @Description: 志愿者服务队
 * @author onlineGenerator
 * @date 2019-03-22 17:24:43
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hVolunteerController")
public class HVolunteerController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(HVolunteerController.class);

	@Autowired
	private HVolunteerServiceI hVolunteerService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 志愿者服务队列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/department/hVolunteerList");
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
	public void datagrid(HVolunteerEntity hVolunteer,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HVolunteerEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hVolunteer, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hVolunteerService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除志愿者服务队
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HVolunteerEntity hVolunteer, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hVolunteer = systemService.getEntity(HVolunteerEntity.class, hVolunteer.getId());
		message = "志愿者服务队删除成功";
		try{
			hVolunteerService.delete(hVolunteer);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "志愿者服务队删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除志愿者服务队
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "志愿者服务队删除成功";
		try{
			for(String id:ids.split(",")){
				HVolunteerEntity hVolunteer = systemService.getEntity(HVolunteerEntity.class, 
				Integer.parseInt(id)
				);
				hVolunteerService.delete(hVolunteer);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "志愿者服务队删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加志愿者服务队
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HVolunteerEntity hVolunteer, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "志愿者服务队添加成功";
		try{
			hVolunteerService.save(hVolunteer);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "志愿者服务队添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新志愿者服务队
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HVolunteerEntity hVolunteer, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "志愿者服务队更新成功";
		HVolunteerEntity t = hVolunteerService.get(HVolunteerEntity.class, hVolunteer.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hVolunteer, t);
			hVolunteerService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "志愿者服务队更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 志愿者服务队新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HVolunteerEntity hVolunteer, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hVolunteer.getId())) {
			hVolunteer = hVolunteerService.getEntity(HVolunteerEntity.class, hVolunteer.getId());
			req.setAttribute("hVolunteer", hVolunteer);
		}
		return new ModelAndView("com/jingzhun/department/hVolunteer-add");
	}
	/**
	 * 志愿者服务队编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HVolunteerEntity hVolunteer, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hVolunteer.getId())) {
			hVolunteer = hVolunteerService.getEntity(HVolunteerEntity.class, hVolunteer.getId());
			req.setAttribute("hVolunteer", hVolunteer);
		}
		return new ModelAndView("com/jingzhun/department/hVolunteer-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hVolunteerController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HVolunteerEntity hVolunteer,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HVolunteerEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hVolunteer, request.getParameterMap());
		List<HVolunteerEntity> hVolunteers = this.hVolunteerService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"志愿者服务队");
		modelMap.put(NormalExcelConstants.CLASS,HVolunteerEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("志愿者服务队列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hVolunteers);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HVolunteerEntity hVolunteer,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"志愿者服务队");
    	modelMap.put(NormalExcelConstants.CLASS,HVolunteerEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("志愿者服务队列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HVolunteerEntity> listHVolunteerEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HVolunteerEntity.class,params);
				for (HVolunteerEntity hVolunteer : listHVolunteerEntitys) {
					hVolunteerService.save(hVolunteer);
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
