package com.jingzhun.income.controller;
import com.jingzhun.income.entity.HLoan3kEntity;
import com.jingzhun.income.service.HLoan3kServiceI;

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
 * @Description: 农发行香驰3000
 * @author onlineGenerator
 * @date 2019-03-22 16:56:45
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/hLoan3kController")
public class HLoan3kController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(HLoan3kController.class);

	@Autowired
	private HLoan3kServiceI hLoan3kService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 农发行香驰3000列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jingzhun/income/hLoan3kList");
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
	public void datagrid(HLoan3kEntity hLoan3k,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HLoan3kEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hLoan3k, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.hLoan3kService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除农发行香驰3000
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HLoan3kEntity hLoan3k, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		hLoan3k = systemService.getEntity(HLoan3kEntity.class, hLoan3k.getId());
		message = "农发行香驰3000删除成功";
		try{
			hLoan3kService.delete(hLoan3k);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "农发行香驰3000删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除农发行香驰3000
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "农发行香驰3000删除成功";
		try{
			for(String id:ids.split(",")){
				HLoan3kEntity hLoan3k = systemService.getEntity(HLoan3kEntity.class, 
				Integer.parseInt(id)
				);
				hLoan3kService.delete(hLoan3k);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "农发行香驰3000删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加农发行香驰3000
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HLoan3kEntity hLoan3k, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "农发行香驰3000添加成功";
		try{
			hLoan3kService.save(hLoan3k);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "农发行香驰3000添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新农发行香驰3000
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HLoan3kEntity hLoan3k, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "农发行香驰3000更新成功";
		HLoan3kEntity t = hLoan3kService.get(HLoan3kEntity.class, hLoan3k.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(hLoan3k, t);
			hLoan3kService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "农发行香驰3000更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 农发行香驰3000新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HLoan3kEntity hLoan3k, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hLoan3k.getId())) {
			hLoan3k = hLoan3kService.getEntity(HLoan3kEntity.class, hLoan3k.getId());
			req.setAttribute("hLoan3k", hLoan3k);
		}
		return new ModelAndView("com/jingzhun/income/hLoan3k-add");
	}
	/**
	 * 农发行香驰3000编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HLoan3kEntity hLoan3k, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(hLoan3k.getId())) {
			hLoan3k = hLoan3kService.getEntity(HLoan3kEntity.class, hLoan3k.getId());
			req.setAttribute("hLoan3k", hLoan3k);
		}
		return new ModelAndView("com/jingzhun/income/hLoan3k-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","hLoan3kController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(HLoan3kEntity hLoan3k,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(HLoan3kEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, hLoan3k, request.getParameterMap());
		List<HLoan3kEntity> hLoan3ks = this.hLoan3kService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"农发行香驰3000");
		modelMap.put(NormalExcelConstants.CLASS,HLoan3kEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("农发行香驰3000列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,hLoan3ks);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(HLoan3kEntity hLoan3k,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"农发行香驰3000");
    	modelMap.put(NormalExcelConstants.CLASS,HLoan3kEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("农发行香驰3000列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
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
				List<HLoan3kEntity> listHLoan3kEntitys = ExcelImportUtil.importExcel(file.getInputStream(),HLoan3kEntity.class,params);
				for (HLoan3kEntity hLoan3k : listHLoan3kEntitys) {
					hLoan3kService.save(hLoan3k);
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
