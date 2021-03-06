package com.jingzhun.income.controller;
import com.jingzhun.income.entity.HHardPopulationEntity;
import com.jingzhun.income.service.HHardPopulationServiceI;

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
 * @Description: 农商行博华农业
 * @author onlineGenerator
 * @date 2019-03-22 16:54:06
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hHardPopulationController")
public class HHardPopulationController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(HHardPopulationController.class);

	@Autowired
	private HHardPopulationServiceI hHardPopulationService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 农商行博华农业列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/income/hHardPopulationList");
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
	public void datagrid(HHardPopulationEntity hHardPopulation,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HHardPopulationEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hHardPopulation, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hHardPopulationService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除农商行博华农业
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HHardPopulationEntity hHardPopulation, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hHardPopulation = systemService.getEntity(HHardPopulationEntity.class, hHardPopulation.getId());
		message = "农商行博华农业删除成功";
		try{
			hHardPopulationService.delete(hHardPopulation);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "农商行博华农业删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除农商行博华农业
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "农商行博华农业删除成功";
		try{
			for(String id:ids.split(",")){
				HHardPopulationEntity hHardPopulation = systemService.getEntity(HHardPopulationEntity.class, 
				Integer.parseInt(id)
				);
				hHardPopulationService.delete(hHardPopulation);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "农商行博华农业删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加农商行博华农业
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HHardPopulationEntity hHardPopulation, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "农商行博华农业添加成功";
		try{
			hHardPopulationService.save(hHardPopulation);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "农商行博华农业添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新农商行博华农业
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HHardPopulationEntity hHardPopulation, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "农商行博华农业更新成功";
		HHardPopulationEntity t = hHardPopulationService.get(HHardPopulationEntity.class, hHardPopulation.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hHardPopulation, t);
			hHardPopulationService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "农商行博华农业更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 农商行博华农业新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HHardPopulationEntity hHardPopulation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hHardPopulation.getId())) {
			hHardPopulation = hHardPopulationService.getEntity(HHardPopulationEntity.class, hHardPopulation.getId());
			req.setAttribute("hHardPopulation", hHardPopulation);
		}
		return new ModelAndView("com/jingzhun/income/hHardPopulation-add");
	}
	/**
	 * 农商行博华农业编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HHardPopulationEntity hHardPopulation, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hHardPopulation.getId())) {
			hHardPopulation = hHardPopulationService.getEntity(HHardPopulationEntity.class, hHardPopulation.getId());
			req.setAttribute("hHardPopulation", hHardPopulation);
		}
		return new ModelAndView("com/jingzhun/income/hHardPopulation-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hHardPopulationController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HHardPopulationEntity hHardPopulation,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HHardPopulationEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hHardPopulation, request.getParameterMap());
		List<HHardPopulationEntity> hHardPopulations = this.hHardPopulationService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"农商行博华农业");
		modelMap.put(NormalExcelConstants.CLASS,HHardPopulationEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("农商行博华农业列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hHardPopulations);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HHardPopulationEntity hHardPopulation,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"农商行博华农业");
    	modelMap.put(NormalExcelConstants.CLASS,HHardPopulationEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("农商行博华农业列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HHardPopulationEntity> listHHardPopulationEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HHardPopulationEntity.class,params);
				for (HHardPopulationEntity hHardPopulation : listHHardPopulationEntitys) {
					hHardPopulationService.save(hHardPopulation);
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
