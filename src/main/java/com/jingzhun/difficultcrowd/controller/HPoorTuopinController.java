package com.jingzhun.difficultcrowd.controller;
import com.jingzhun.difficultcrowd.entity.HPoorTuopinEntity;
import com.jingzhun.difficultcrowd.service.HPoorTuopinServiceI;

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
 * @Description: 脱贫不享受政策
 * @author onlineGenerator
 * @date 2019-03-22 09:47:48
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hPoorTuopinController")
public class HPoorTuopinController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(HPoorTuopinController.class);

	@Autowired
	private HPoorTuopinServiceI hPoorTuopinService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 脱贫不享受政策列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/difficultcrowd/hPoorTuopinList");
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
	public void datagrid(HPoorTuopinEntity hPoorTuopin,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HPoorTuopinEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hPoorTuopin, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hPoorTuopinService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除脱贫不享受政策
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HPoorTuopinEntity hPoorTuopin, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hPoorTuopin = systemService.getEntity(HPoorTuopinEntity.class, hPoorTuopin.getId());
		message = "脱贫不享受政策删除成功";
		try{
			hPoorTuopinService.delete(hPoorTuopin);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "脱贫不享受政策删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除脱贫不享受政策
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "脱贫不享受政策删除成功";
		try{
			for(String id:ids.split(",")){
				HPoorTuopinEntity hPoorTuopin = systemService.getEntity(HPoorTuopinEntity.class, 
				Integer.parseInt(id)
				);
				hPoorTuopinService.delete(hPoorTuopin);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "脱贫不享受政策删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加脱贫不享受政策
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HPoorTuopinEntity hPoorTuopin, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "脱贫不享受政策添加成功";
		try{
			hPoorTuopinService.save(hPoorTuopin);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "脱贫不享受政策添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新脱贫不享受政策
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HPoorTuopinEntity hPoorTuopin, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "脱贫不享受政策更新成功";
		HPoorTuopinEntity t = hPoorTuopinService.get(HPoorTuopinEntity.class, hPoorTuopin.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hPoorTuopin, t);
			hPoorTuopinService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "脱贫不享受政策更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 脱贫不享受政策新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HPoorTuopinEntity hPoorTuopin, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hPoorTuopin.getId())) {
			hPoorTuopin = hPoorTuopinService.getEntity(HPoorTuopinEntity.class, hPoorTuopin.getId());
			req.setAttribute("hPoorTuopin", hPoorTuopin);
		}
		return new ModelAndView("com/jingzhun/difficultcrowd/hPoorTuopin-add");
	}
	/**
	 * 脱贫不享受政策编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HPoorTuopinEntity hPoorTuopin, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hPoorTuopin.getId())) {
			hPoorTuopin = hPoorTuopinService.getEntity(HPoorTuopinEntity.class, hPoorTuopin.getId());
			req.setAttribute("hPoorTuopin", hPoorTuopin);
		}
		return new ModelAndView("com/jingzhun/difficultcrowd/hPoorTuopin-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hPoorTuopinController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HPoorTuopinEntity hPoorTuopin,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HPoorTuopinEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hPoorTuopin, request.getParameterMap());
		List<HPoorTuopinEntity> hPoorTuopins = this.hPoorTuopinService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"脱贫不享受政策");
		modelMap.put(NormalExcelConstants.CLASS,HPoorTuopinEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("脱贫不享受政策列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hPoorTuopins);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HPoorTuopinEntity hPoorTuopin,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"脱贫不享受政策");
    	modelMap.put(NormalExcelConstants.CLASS,HPoorTuopinEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("脱贫不享受政策列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HPoorTuopinEntity> listHPoorTuopinEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HPoorTuopinEntity.class,params);
				for (HPoorTuopinEntity hPoorTuopin : listHPoorTuopinEntitys) {
					hPoorTuopinService.save(hPoorTuopin);
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
