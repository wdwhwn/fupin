package com.jingzhun.difficultcrowd.controller;
import com.jingzhun.difficultcrowd.entity.HHardOrphanEntity;
import com.jingzhun.difficultcrowd.service.HHardOrphanServiceI;

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
 * @Description: 孤儿人员信息数据
 * @author onlineGenerator
 * @date 2019-03-22 11:15:53
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hHardOrphanController")
public class HHardOrphanController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(HHardOrphanController.class);

	@Autowired
	private HHardOrphanServiceI hHardOrphanService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 孤儿人员信息数据列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/difficultcrowd/hHardOrphanList");
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
	public void datagrid(HHardOrphanEntity hHardOrphan,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HHardOrphanEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hHardOrphan, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hHardOrphanService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除孤儿人员信息数据
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HHardOrphanEntity hHardOrphan, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hHardOrphan = systemService.getEntity(HHardOrphanEntity.class, hHardOrphan.getId());
		message = "孤儿人员信息数据删除成功";
		try{
			hHardOrphanService.delete(hHardOrphan);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "孤儿人员信息数据删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除孤儿人员信息数据
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "孤儿人员信息数据删除成功";
		try{
			for(String id:ids.split(",")){
				HHardOrphanEntity hHardOrphan = systemService.getEntity(HHardOrphanEntity.class, 
				Integer.parseInt(id)
				);
				hHardOrphanService.delete(hHardOrphan);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "孤儿人员信息数据删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加孤儿人员信息数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HHardOrphanEntity hHardOrphan, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "孤儿人员信息数据添加成功";
		try{
			hHardOrphanService.save(hHardOrphan);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "孤儿人员信息数据添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新孤儿人员信息数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HHardOrphanEntity hHardOrphan, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "孤儿人员信息数据更新成功";
		HHardOrphanEntity t = hHardOrphanService.get(HHardOrphanEntity.class, hHardOrphan.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hHardOrphan, t);
			hHardOrphanService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "孤儿人员信息数据更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 孤儿人员信息数据新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HHardOrphanEntity hHardOrphan, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hHardOrphan.getId())) {
			hHardOrphan = hHardOrphanService.getEntity(HHardOrphanEntity.class, hHardOrphan.getId());
			req.setAttribute("hHardOrphan", hHardOrphan);
		}
		return new ModelAndView("com/jingzhun/difficultcrowd/hHardOrphan-add");
	}
	/**
	 * 孤儿人员信息数据编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HHardOrphanEntity hHardOrphan, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hHardOrphan.getId())) {
			hHardOrphan = hHardOrphanService.getEntity(HHardOrphanEntity.class, hHardOrphan.getId());
			req.setAttribute("hHardOrphan", hHardOrphan);
		}
		return new ModelAndView("com/jingzhun/difficultcrowd/hHardOrphan-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hHardOrphanController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HHardOrphanEntity hHardOrphan,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HHardOrphanEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hHardOrphan, request.getParameterMap());
		List<HHardOrphanEntity> hHardOrphans = this.hHardOrphanService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"孤儿人员信息数据");
		modelMap.put(NormalExcelConstants.CLASS,HHardOrphanEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("孤儿人员信息数据列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hHardOrphans);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HHardOrphanEntity hHardOrphan,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"孤儿人员信息数据");
    	modelMap.put(NormalExcelConstants.CLASS,HHardOrphanEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("孤儿人员信息数据列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HHardOrphanEntity> listHHardOrphanEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HHardOrphanEntity.class,params);
				for (HHardOrphanEntity hHardOrphan : listHHardOrphanEntitys) {
					hHardOrphanService.save(hHardOrphan);
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
