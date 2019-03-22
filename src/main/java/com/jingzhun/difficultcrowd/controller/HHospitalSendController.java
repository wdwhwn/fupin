package com.jingzhun.difficultcrowd.controller;
import com.jingzhun.difficultcrowd.entity.HHospitalSendEntity;
import com.jingzhun.difficultcrowd.service.HHospitalSendServiceI;

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
 * @Description: 居民医保报销数据总
 * @author onlineGenerator
 * @date 2019-03-22 09:47:18
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hHospitalSendController")
public class HHospitalSendController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(HHospitalSendController.class);

	@Autowired
	private HHospitalSendServiceI hHospitalSendService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 居民医保报销数据总列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/difficultcrowd/hHospitalSendList");
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
	public void datagrid(HHospitalSendEntity hHospitalSend,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HHospitalSendEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hHospitalSend, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hHospitalSendService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除居民医保报销数据总
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HHospitalSendEntity hHospitalSend, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hHospitalSend = systemService.getEntity(HHospitalSendEntity.class, hHospitalSend.getId());
		message = "居民医保报销数据总删除成功";
		try{
			hHospitalSendService.delete(hHospitalSend);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "居民医保报销数据总删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除居民医保报销数据总
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "居民医保报销数据总删除成功";
		try{
			for(String id:ids.split(",")){
				HHospitalSendEntity hHospitalSend = systemService.getEntity(HHospitalSendEntity.class, 
				Integer.parseInt(id)
				);
				hHospitalSendService.delete(hHospitalSend);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "居民医保报销数据总删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加居民医保报销数据总
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HHospitalSendEntity hHospitalSend, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "居民医保报销数据总添加成功";
		try{
			hHospitalSendService.save(hHospitalSend);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "居民医保报销数据总添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新居民医保报销数据总
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HHospitalSendEntity hHospitalSend, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "居民医保报销数据总更新成功";
		HHospitalSendEntity t = hHospitalSendService.get(HHospitalSendEntity.class, hHospitalSend.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hHospitalSend, t);
			hHospitalSendService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "居民医保报销数据总更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 居民医保报销数据总新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HHospitalSendEntity hHospitalSend, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hHospitalSend.getId())) {
			hHospitalSend = hHospitalSendService.getEntity(HHospitalSendEntity.class, hHospitalSend.getId());
			req.setAttribute("hHospitalSend", hHospitalSend);
		}
		return new ModelAndView("com/jingzhun/difficultcrowd/hHospitalSend-add");
	}
	/**
	 * 居民医保报销数据总编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HHospitalSendEntity hHospitalSend, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hHospitalSend.getId())) {
			hHospitalSend = hHospitalSendService.getEntity(HHospitalSendEntity.class, hHospitalSend.getId());
			req.setAttribute("hHospitalSend", hHospitalSend);
		}
		return new ModelAndView("com/jingzhun/difficultcrowd/hHospitalSend-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hHospitalSendController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HHospitalSendEntity hHospitalSend,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HHospitalSendEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hHospitalSend, request.getParameterMap());
		List<HHospitalSendEntity> hHospitalSends = this.hHospitalSendService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"居民医保报销数据总");
		modelMap.put(NormalExcelConstants.CLASS,HHospitalSendEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("居民医保报销数据总列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hHospitalSends);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HHospitalSendEntity hHospitalSend,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"居民医保报销数据总");
    	modelMap.put(NormalExcelConstants.CLASS,HHospitalSendEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("居民医保报销数据总列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HHospitalSendEntity> listHHospitalSendEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HHospitalSendEntity.class,params);
				for (HHospitalSendEntity hHospitalSend : listHHospitalSendEntitys) {
					hHospitalSendService.save(hHospitalSend);
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
