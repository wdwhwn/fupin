package com.jingzhun.poordatemanager.controller;
import com.jingzhun.poordatemanager.entity.HPoorHouseholdEntity;
import com.jingzhun.poordatemanager.service.HPoorHouseholdServiceI;

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

import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import java.util.HashMap;
/**   
 * @Title: Controller  
 * @Description: 贫困户表
 * @author onlineGenerator
 * @date 2019-03-25 19:32:01
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hPoorHouseholdController")
public class HPoorHouseholdController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(HPoorHouseholdController.class);

	@Autowired
	private HPoorHouseholdServiceI hPoorHouseholdService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	


	/**
	 * 贫困户表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/poordatemanager/hPoorHouseholdList");
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
	public void datagrid(HPoorHouseholdEntity hPoorHousehold,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HPoorHouseholdEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hPoorHousehold, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hPoorHouseholdService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除贫困户表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HPoorHouseholdEntity hPoorHousehold, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hPoorHousehold = systemService.getEntity(HPoorHouseholdEntity.class, hPoorHousehold.getId());
		message = "贫困户表删除成功";
		try{
			hPoorHouseholdService.delete(hPoorHousehold);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "贫困户表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除贫困户表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "贫困户表删除成功";
		try{
			for(String id:ids.split(",")){
				HPoorHouseholdEntity hPoorHousehold = systemService.getEntity(HPoorHouseholdEntity.class, 
				Integer.parseInt(id)
				);
				hPoorHouseholdService.delete(hPoorHousehold);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "贫困户表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加贫困户表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HPoorHouseholdEntity hPoorHousehold, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "贫困户表添加成功";
		try{
			hPoorHouseholdService.save(hPoorHousehold);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "贫困户表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新贫困户表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HPoorHouseholdEntity hPoorHousehold, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "贫困户表更新成功";
		HPoorHouseholdEntity t = hPoorHouseholdService.get(HPoorHouseholdEntity.class, hPoorHousehold.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hPoorHousehold, t);
			hPoorHouseholdService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "贫困户表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 贫困户表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HPoorHouseholdEntity hPoorHousehold, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hPoorHousehold.getId())) {
			hPoorHousehold = hPoorHouseholdService.getEntity(HPoorHouseholdEntity.class, hPoorHousehold.getId());
			req.setAttribute("hPoorHousehold", hPoorHousehold);
		}
		return new ModelAndView("com/jingzhun/poordatemanager/hPoorHousehold-add");
	}
	/**
	 * 贫困户表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HPoorHouseholdEntity hPoorHousehold, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hPoorHousehold.getId())) {
			hPoorHousehold = hPoorHouseholdService.getEntity(HPoorHouseholdEntity.class, hPoorHousehold.getId());
			req.setAttribute("hPoorHousehold", hPoorHousehold);
		}
		return new ModelAndView("com/jingzhun/poordatemanager/hPoorHousehold-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hPoorHouseholdController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HPoorHouseholdEntity hPoorHousehold,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HPoorHouseholdEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hPoorHousehold, request.getParameterMap());
		List<HPoorHouseholdEntity> hPoorHouseholds = this.hPoorHouseholdService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"贫困户表");
		modelMap.put(NormalExcelConstants.CLASS,HPoorHouseholdEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("贫困户表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hPoorHouseholds);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HPoorHouseholdEntity hPoorHousehold,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"贫困户表");
    	modelMap.put(NormalExcelConstants.CLASS,HPoorHouseholdEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("贫困户表列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HPoorHouseholdEntity> listHPoorHouseholdEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HPoorHouseholdEntity.class,params);
				for (HPoorHouseholdEntity hPoorHousehold : listHPoorHouseholdEntitys) {
					hPoorHouseholdService.save(hPoorHousehold);
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
	
	/**
	 * 获取文件附件信息
	 * 
	 * @param id hPoorHousehold主键id
	 */
	@RequestMapping(params = "getFiles")
	@ResponseBody
	public AjaxJson getFiles(String id){
		List<CgUploadEntity> uploadBeans = cgFormFieldService.findByProperty(CgUploadEntity.class, "cgformId", id);
		List<Map<String,Object>> files = new ArrayList<Map<String,Object>>(0);
		for(CgUploadEntity b:uploadBeans){
			String title = b.getAttachmenttitle();//附件名
			String fileKey = b.getId();//附件主键
			String path = b.getRealpath();//附件路径
			String field = b.getCgformField();//表单中作为附件控件的字段
			Map<String, Object> file = new HashMap<String, Object>();
			file.put("title", title);
			file.put("fileKey", fileKey);
			file.put("path", path);
			file.put("field", field==null?"":field);
			files.add(file);
		}
		AjaxJson j = new AjaxJson();
		j.setObj(files);
		return j;
	}
	
}
