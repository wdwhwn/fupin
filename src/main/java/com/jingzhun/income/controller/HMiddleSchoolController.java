package com.jingzhun.income.controller;
import com.jingzhun.income.entity.HMiddleSchoolEntity;
import com.jingzhun.income.service.HMiddleSchoolServiceI;

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
 * @Description: 中学教育补助金
 * @author onlineGenerator
 * @date 2019-03-23 10:28:30
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hMiddleSchoolController")
public class HMiddleSchoolController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(HMiddleSchoolController.class);

	@Autowired
	private HMiddleSchoolServiceI hMiddleSchoolService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 中学教育补助金列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/income/hMiddleSchoolList");
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
	public void datagrid(HMiddleSchoolEntity hMiddleSchool,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		/*CriteriaQuery cq = new CriteriaQuery(HMiddleSchoolEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hMiddleSchool, request.getParameterMap());
		try{
		//自定义追加查询条件

		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hMiddleSchoolService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);*/
		String bomType =request.getParameter("bomType");
		String orgCode = ResourceUtil.getSessionUser().getCurrentDepart().getOrgCode();
		HashMap<String, Object> conditionMap = new HashMap<>();
		conditionMap.put("orgCode",orgCode);
		conditionMap.put("bomType",bomType);
		try {
			List<Map<String, Object>> resultMapList = hMiddleSchoolService.getBomList(conditionMap, dataGrid);
			dataGrid.setResults(resultMapList);
		} catch (Exception e) {
			logger.error(e.toString(),e);
			e.printStackTrace();
		}
		TagUtil.datagrid(response,dataGrid);
	}
	
	/**
	 * 删除中学教育补助金
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HMiddleSchoolEntity hMiddleSchool, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hMiddleSchool = systemService.getEntity(HMiddleSchoolEntity.class, hMiddleSchool.getId());
		message = "中学教育补助金删除成功";
		try{
			hMiddleSchoolService.delete(hMiddleSchool);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "中学教育补助金删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除中学教育补助金
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "中学教育补助金删除成功";
		try{
			for(String id:ids.split(",")){
				HMiddleSchoolEntity hMiddleSchool = systemService.getEntity(HMiddleSchoolEntity.class, 
				Integer.parseInt(id)
				);
				hMiddleSchoolService.delete(hMiddleSchool);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "中学教育补助金删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加中学教育补助金
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HMiddleSchoolEntity hMiddleSchool, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "中学教育补助金添加成功";
		try{
			hMiddleSchoolService.save(hMiddleSchool);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "中学教育补助金添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新中学教育补助金
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HMiddleSchoolEntity hMiddleSchool, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "中学教育补助金更新成功";
		HMiddleSchoolEntity t = hMiddleSchoolService.get(HMiddleSchoolEntity.class, hMiddleSchool.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hMiddleSchool, t);
			hMiddleSchoolService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "中学教育补助金更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 中学教育补助金新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HMiddleSchoolEntity hMiddleSchool, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hMiddleSchool.getId())) {
			hMiddleSchool = hMiddleSchoolService.getEntity(HMiddleSchoolEntity.class, hMiddleSchool.getId());
			req.setAttribute("hMiddleSchool", hMiddleSchool);
		}
		return new ModelAndView("com/jingzhun/income/hMiddleSchool-add");
	}
	/**
	 * 中学教育补助金编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HMiddleSchoolEntity hMiddleSchool, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hMiddleSchool.getId())) {
			hMiddleSchool = hMiddleSchoolService.getEntity(HMiddleSchoolEntity.class, hMiddleSchool.getId());
			req.setAttribute("hMiddleSchool", hMiddleSchool);
		}
		return new ModelAndView("com/jingzhun/income/hMiddleSchool-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hMiddleSchoolController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HMiddleSchoolEntity hMiddleSchool,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HMiddleSchoolEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hMiddleSchool, request.getParameterMap());
		List<HMiddleSchoolEntity> hMiddleSchools = this.hMiddleSchoolService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"中学教育补助金");
		modelMap.put(NormalExcelConstants.CLASS,HMiddleSchoolEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("中学教育补助金列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hMiddleSchools);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HMiddleSchoolEntity hMiddleSchool,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"中学教育补助金");
    	modelMap.put(NormalExcelConstants.CLASS,HMiddleSchoolEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("中学教育补助金列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HMiddleSchoolEntity> listHMiddleSchoolEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HMiddleSchoolEntity.class,params);
				for (HMiddleSchoolEntity hMiddleSchool : listHMiddleSchoolEntitys) {
					hMiddleSchoolService.save(hMiddleSchool);
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
