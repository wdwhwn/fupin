package com.jingzhun.property.noji.controller;
import com.jingzhun.property.noji.entity.HFarmMachineryEntity;
import com.jingzhun.property.noji.service.HFarmMachineryServiceI;

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
 * @Description: 大型农机局信息
 * @author onlineGenerator
 * @date 2019-03-22 13:00:00
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hFarmMachineryController")
public class HFarmMachineryController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(HFarmMachineryController.class);

	@Autowired
	private HFarmMachineryServiceI hFarmMachineryService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 大型农机局信息列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/property.noji/hFarmMachineryList");
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
	public void datagrid(HFarmMachineryEntity hFarmMachinery,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HFarmMachineryEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hFarmMachinery, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hFarmMachineryService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除大型农机局信息
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HFarmMachineryEntity hFarmMachinery, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hFarmMachinery = systemService.getEntity(HFarmMachineryEntity.class, hFarmMachinery.getId());
		message = "大型农机局信息删除成功";
		try{
			hFarmMachineryService.delete(hFarmMachinery);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "大型农机局信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除大型农机局信息
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "大型农机局信息删除成功";
		try{
			for(String id:ids.split(",")){
				HFarmMachineryEntity hFarmMachinery = systemService.getEntity(HFarmMachineryEntity.class, 
				Integer.parseInt(id)
				);
				hFarmMachineryService.delete(hFarmMachinery);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "大型农机局信息删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加大型农机局信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HFarmMachineryEntity hFarmMachinery, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "大型农机局信息添加成功";
		try{
			hFarmMachineryService.save(hFarmMachinery);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "大型农机局信息添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新大型农机局信息
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HFarmMachineryEntity hFarmMachinery, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "大型农机局信息更新成功";
		HFarmMachineryEntity t = hFarmMachineryService.get(HFarmMachineryEntity.class, hFarmMachinery.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hFarmMachinery, t);
			hFarmMachineryService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "大型农机局信息更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 大型农机局信息新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HFarmMachineryEntity hFarmMachinery, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hFarmMachinery.getId())) {
			hFarmMachinery = hFarmMachineryService.getEntity(HFarmMachineryEntity.class, hFarmMachinery.getId());
			req.setAttribute("hFarmMachinery", hFarmMachinery);
		}
		return new ModelAndView("com/jingzhun/property.noji/hFarmMachinery-add");
	}
	/**
	 * 大型农机局信息编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HFarmMachineryEntity hFarmMachinery, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hFarmMachinery.getId())) {
			hFarmMachinery = hFarmMachineryService.getEntity(HFarmMachineryEntity.class, hFarmMachinery.getId());
			req.setAttribute("hFarmMachinery", hFarmMachinery);
		}
		return new ModelAndView("com/jingzhun/property.noji/hFarmMachinery-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hFarmMachineryController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HFarmMachineryEntity hFarmMachinery,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HFarmMachineryEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hFarmMachinery, request.getParameterMap());
		List<HFarmMachineryEntity> hFarmMachinerys = this.hFarmMachineryService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"大型农机局信息");
		modelMap.put(NormalExcelConstants.CLASS,HFarmMachineryEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("大型农机局信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hFarmMachinerys);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HFarmMachineryEntity hFarmMachinery,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"大型农机局信息");
    	modelMap.put(NormalExcelConstants.CLASS,HFarmMachineryEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("大型农机局信息列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HFarmMachineryEntity> listHFarmMachineryEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HFarmMachineryEntity.class,params);
				for (HFarmMachineryEntity hFarmMachinery : listHFarmMachineryEntitys) {
					hFarmMachineryService.save(hFarmMachinery);
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
