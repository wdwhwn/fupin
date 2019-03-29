<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <link rel="stylesheet" href="plug-in/easyui/themes/metrole/easyui.css" type="text/css"></link>
    <link rel="stylesheet" href="plug-in/easyui/themes/metrole/icon.css" type="text/css"></link>
    <link rel="stylesheet" href="plug-in/ace/css/font-awesome.css" type="text/css"></link>
    <link rel="stylesheet" href="plug-in/mutitables/mutitables.mainpage.css" type="text/css"></link>
    <t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
    <script type="text/javascript" src="plug-in/themes/fineui/jquery/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="plug-in/layer/layer.js"></script>
    <script type="text/javascript" src="plug-in/mutitables/mutitables.mainpage.js" ></script>
    <script type="text/javascript" src="plug-in/mutitables/jquery.resize.y.js"></script>
</head>
<body>
<%--<div class="easyui-layout" fit="true">--%>

    <div region="center" style="padding:0px;border:1px;overflow-x:hidden;">
        <!-- 上方 -->
        <div  id="accDiv"  class="easyui-accordion" data-options="multiple:true" style="height:200px;padding-right:0px;overflow-x:hidden;box-sizing: border-box;">
            <!-- 主表 必须-->
            <div title="" data-options="iconCls:'icon-ok',selected:true"  >
                <div id="easyui_mainList" class="resize-y-iframe" style="height:200px;padding-bottom:0px;">
                    <iframe id="mainList" height="100%" width="100%" frameborder="0"
                            src="poorHouseholdController.do?list2&id=${requestScope.id}"></iframe>
                </div>
                <%--<div id="easyui_mainList1" class="resize-y-iframe" style="height:80px;padding-bottom:6px;">
                    <iframe id="mainList1" height="100%" width="100%" frameborder="0"
                            src="poorHouseholdController.do?list3&id=${requestScope.id}"></iframe>
                </div>--%>
            </div>
        </div>
        <!-- 上方end -->
        <!-- 从表 -->
        <%--<div id="tabsok" style="height:200px">
            <div title="家庭成员" data-options="closable:false" style="overflow:hidden;box-sizing: border-box;">
                <iframe id="jformOrderCustomer2Iframe" scrolling="yes" frameborder="0" height="100%" width="100%"
                        src="${webRoot}/jformOrderCustomer2Controller.do?list">
                </iframe>
            </div>
            <div title="帮扶责任人" data-options="closable:false" style="overflow:hidden;box-sizing: border-box;">
                <iframe id="jformOrderTicket2Iframe1" scrolling="yes" frameborder="0" height="100%" width="100%"
                        src="${webRoot}/jformOrderTicket2Controller.do?list">
                </iframe>
            </div>
            <div title="综合评分" data-options="closable:false" style="overflow:hidden;box-sizing: border-box;">
                <iframe id="jformOrderTicket2Iframe2" scrolling="yes" frameborder="0" height="100%" width="100%"
                        src="${webRoot}/jformOrderTicket2Controller.do?list">
                </iframe>
            </div>
          <div title="信息修改" data-options="closable:false" style="overflow:hidden;box-sizing: border-box;">
                <iframe id="jformOrderTicket2Iframe4" scrolling="yes" frameborder="0" height="100%" width="100%"
                        src="${webRoot}/jformOrderTicket2Controller.do?list">
                </iframe>
            </div>
            <div title="财产上报" data-options="closable:false" style="overflow:hidden;box-sizing: border-box;">
                <iframe id="jformOrderTicket2Iframe5" scrolling="yes" frameborder="0" height="100%" width="100%"
                        src="${webRoot}/jformOrderTicket2Controller.do?list">
                </iframe>
            </div>
            <div title="收入管理" data-options="closable:false" style="overflow:hidden;box-sizing: border-box;">
                <iframe id="jformOrderTicket2Iframe6" scrolling="yes" frameborder="0" height="100%" width="100%"
                        src="${webRoot}/jformOrderTicket2Controller.do?list">
                </iframe>
            </div>
        </div>--%>
        <!-- 从表end -->
    </div>
    <!-- center end -->
<%--</div>--%>

<%--<div style="display:none">
    <!-- 激活选项卡再刷新页面需要该隐藏域 -->
    <input type="hidden" id="mainPageHiddenId">
    <select id="mainPageFrameActived" style="display:none">
        <option value="jformOrderCustomer2" selected="selected"></option>
        <option value="jformOrderTicket2"></option>
    </select>
</div>--%>
<div>
    <t:tabs id="tabsFive" iframe="true" heigth="800px" tabPosition="top" fit="false">
        <t:tab href="poorHouseholdController.do?listFamily&id=${requestScope.id}" icon="icon-search" title="家庭成员" id="tab6"></t:tab>
        <t:tab href="poorHouseholdController.do?listHelpTerms&id=${requestScope.id}" icon="icon-search" title="帮扶责任人" id="tab7"></t:tab>
        <t:tab href="http://www.jeecg.org" icon="icon-search" title="综合评分" id="tab7"></t:tab>
        <t:tab href="http://www.jeecg.org" icon="icon-search" title="困难需求" id="tab7"></t:tab>
        <t:tab href="http://www.jeecg.org" icon="icon-search" title="信息修改" id="tab7"></t:tab>
        <t:tab href="http://www.jeecg.org" icon="icon-search" title="财产上报" id="tab7"></t:tab>
        <t:tab href="javascript:void(0)"  icon="icon-search" title="收入管理" id="tab7"></t:tab>
    </t:tabs>
</div>
<!-- 需要改变的是每个iframe的src;子表iframe的id ;mainPageFrameActived中的option的value -->
</body>
<script type="text/javascript">
    $(function(){
        console.log("132456");
        console.log("13");
        $(".tabs-last").find(".tabs-inner").click(function(){
            self.parent.addOneTab('财产管理','poorHouseholdController.do?incomeManageTabs&id='+${requestScope.id},'icon-add')
        });
    });
</script>