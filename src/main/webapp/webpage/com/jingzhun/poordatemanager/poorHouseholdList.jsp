<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<link rel="stylesheet" href="plug-in/ztree/css/zTreeStyle.css" type="text/css">
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/ztreeCreator.js"></script>
<style>
 .ztree li span.button.SCHEMA_ico_open,
 .ztree li span.button.SCHEMA_ico_close,
 .ztree li span.button.SCHEMA_ico_docu{
  display: inline-block;
  font: normal normal normal 16px/1 FontAwesome;
  padding: 3px;
  background-image: none !important;
 }
 .ztree li span.button.SCHEMA_ico_open:before
 {
  content: "\f07c";
 }
 .ztree li span.button.SCHEMA_ico_docu:before,
 .ztree li span.button.SCHEMA_ico_close:before{
  content: "\f07b";
 }
</style>
<div class="easyui-layout" fit="true">
 <div  data-options="region:'west',title:'乡镇数据',split:true" style="width:200px;overflow: auto;">
  <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="self.parent.addOneTab('弹出窗','poorHouseholdController.do?list1&id={id}','icon-add')">文字</a>
  <div class="list-group">
   <div class="list-group-item" id="boxing" style="font-size: 13" href="#">&nbsp;&nbsp;&nbsp;<i class="fa fa-home fa-fw"></i>&nbsp;&nbsp; 博兴县</div>
   <div id="orgTree" class="ztree"></div>
  </div>
 </div>
  <div region="center" style="padding:0px;border:0px">

  <t:datagrid name="poorHouseholdList" pageSize="15" checkbox="true" pagination="true" fitColumns="false" title="" actionUrl="poorHouseholdController.do?datagrid" idField="id" sortName="id" fit="false" queryMode="group">
   <t:dgCol title="主键自增"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="行政县"  field="a1"  queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="乡镇"  field="a2"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="行政村"  field="a3"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgCol title="自然村"  field="a4"  queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="户编号"  field="a5"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgCol title="人编号"  field="a6"  queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="姓名"  field="a7"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="证件号码"  field="a8"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="人数"  field="a9"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="与户主关系"  field="a10"  queryMode="single"  dictionary="与户主关系"  width="120"></t:dgCol>
   <%--<t:dgCol title="民族"  field="a11"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="文化程度"  field="a12"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="在校生状况"  field="a13"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="健康状况"  field="a14"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="劳动技能"  field="a15"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="务工状况"  field="a16"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="务工时间"  field="a17"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="参加大病医疗"  field="a18"  queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="脱贫属性"  field="a19"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgCol title="脱贫年度"  field="a20"  queryMode="group"  dictionary="贫困户属性"  width="120"></t:dgCol>--%>
   <t:dgCol title="贫困户属性"  field="a21"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="主要致贫原因"  field="a22"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="危房户"  field="a23"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="饮水安全"  field="a24"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="饮水困难"  field="a25"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="人均纯收入"  field="a26"  queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="联系电话"  field="a27"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="长号码"  field="a28"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="短号码"  field="a29"  queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="用户照片"  field="a30"  queryMode="group"  image="true" imageSize="50,50" formatterjs="btListImgFormatter" width="120"></t:dgCol>
   <%--<t:dgCol title="帮扶责任人手机号"  field="helperMobile"  queryMode="group"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="定位"  field="location"  queryMode="group"  width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt"   width="500"></t:dgCol>
   <t:dgDelOpt title="删除" url="poorHouseholdController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <%--<t:dgOpenOpt url="poorHouseholdController.do?list1&id={id}" title="弹出窗"></t:dgOpenOpt>--%>
   <t:dgFunOpt funname="alertId(id)" title="查看" urlclass="ace_button"  urlfont="fa-trash-o"></t:dgFunOpt>
   <t:dgToolBar title="录入" icon="icon-add" url="poorHouseholdController.do?goAdd" funname="add"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="poorHouseholdController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="poorHouseholdController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="poorHouseholdController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>

 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });

//导入
function ImportXls() {
	openuploadwin('Excel导入', 'poorHouseholdController.do?upload', "poorHouseholdList");
}

//导出
function ExportXls() {
	JeecgExcelExport("poorHouseholdController.do?exportXls","poorHouseholdList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("poorHouseholdController.do?exportXlsByT","poorHouseholdList");
}

//bootstrap列表图片格式化
function btListImgFormatter(value,row,index){
	return listFileImgFormat(value,"image");
}
//bootstrap列表文件格式化
function btListFileFormatter(value,row,index){
	return listFileImgFormat(value);
}
</script>
<script>
    //加载树
    var orgTree ;
    function loadTree() {
        var zNodes;
        jQuery.ajax({
            async : false,
            cache:false,
            type: 'POST',
            dataType : "json",
            url: 'poorHouseholdController.do?getTreeDemoData',//请求的action路径
            error: function () {//请求失败处理函数
                alert('请求失败');
            },
            success:function(data){ //请求成功后处理函数。
             /* for(var i;i <data.obj.length;i++){
              data.obj[i].put("iconSkin","SCHEMA");
              console.log("AAAA")
              console.log(data[i].get("iconSkin"));
              }*/
                console.log(data.obj);
                zNodes = data.obj;   //把后台封装好的简单Json格式赋给zNodes
            }
        });
        var ztreeCreator = new ZtreeCreator('orgTree',"poorHouseholdController.do?getTreeDemoData",zNodes)
            .setCallback({onClick:zTreeOnLeftClick,onRightClick:zTreeOnRightClick})
            .initZtree({},0,function(treeObj){orgTree = treeObj});
    };
    //左击
    function zTreeOnLeftClick(event, treeId, treeNode) {
        console.log("12346579");
        curSelectNode = treeNode;
        var parentId = treeNode.parentId;
        console.log(parentId+"     "+curSelectNode.id)
        var url = "poorHouseholdController.do?datagrid&id=" + curSelectNode.id;
     /* if(curSelectNode.parentId=="0"){
      $.topCall.warn('该节点为根节点，请点击具体的组织');
      return false;
      }*/
//        $("#listFrame").attr("src", url);
     /* console.log($("[id='ttt']").prop("id"))
      console.log($("[name='hPoorHouseholdList1']"))*/
        console.log($("#poorHouseholdList"));
        $("#poorHouseholdList").datagrid("reload",{'id':curSelectNode.id });
    };

    /**
     * 树右击事件
     */
    function zTreeOnRightClick(e, treeId, treeNode) {
        if (treeNode) {
            orgTree.selectNode(treeNode);
            curSelectNode=treeNode;
            var isfolder = treeNode.isFolder;
            var h = $(window).height();
            var w = $(window).width();
            var menuWidth = 120;
            var menuHeight = 75;
            var menu = null;
            if (treeNode != null) {
                menu = $('#orgMenu');
            }
            var x = e.pageX, y = e.pageY;
            if (e.pageY + menuHeight > h) {
                y = e.pageY - menuHeight;
            }
            if (e.pageX + menuWidth > w) {
                x = e.pageX - menuWidth;
            }
            menu.menu('show', {
                left : x,
                top : y
            });
        }
    };
    //菜单对应项
    function menuHandler(item) {
        if ('add' == item.name) {
            addNode();
        } else if ('remove' == item.name) {
            delNode();
        } else if ('sort' == item.name) {
            sortNode();
        } else if ('edit' == item.name) {
            editNode(1);
        } else if ('fresh' == item.name) {
            refreshNode();
        }
    };
    function refreshNode() {
        loadTree();
    };

    //添加节点
    function addNode() {
        var selectNode = getSelectNode();
        if (!selectNode) 	return;
        var url = "departController.do?add&id=" + selectNode.id;
        $("#listFrame").attr("src", url);

    };

    //编辑节点
    function editNode(type) {
        var selectNode = getSelectNode();
        if (!selectNode) 	return;
        //根节点 不能编辑
        if(selectNode.id=="0" && type==1 ){
            $.topCall.warn('该节点为根节点，不可编辑');
            return;
        }
        var url = "departController.do?update&id=" + selectNode.id;
        $("#listFrame").attr("src", url);
    };

    //删除
    function delNode() {
        var selectNode = getSelectNode();
        var nodeId = selectNode.id;
        if (nodeId == "0") {
            $.topCall.warn('该节点为根节点，不可删除');
            return;
        }
        var url = "jeecgFormDemoController.do?del&id="+nodeId;
        if(!confirm('温馨提示', '确定删除该组织以及该组织下的所有子组织？')){
            return;
        }
        jQuery.ajax({
            async : false,
            cache:false,
            type: 'GET',
            dataType : "json",
            url: url,//请求的action路径
            error: function () {//请求失败处理函数
                alert('请求失败');
            },
            success:function(data){ //请求成功后处理函数。
                if(data.success){
                    orgTree.removeNode(selectNode);
                    $("#lsitFrame").attr("src", "about:blank");
                }else{
                    alert(data.msg);
                }
            }
        });

    };
    //选择资源节点。
    function getSelectNode() {
        orgTree = $.fn.zTree.getZTreeObj("orgTree");
        var nodes = orgTree.getSelectedNodes();
        var node = nodes[0];
        return node;
    };
</script>
<script>
    function alertId(id,index){
        self.parent.addOneTab('弹出窗','poorHouseholdController.do?list1&id='+id,'icon-add')
    }
    $(function() {
        loadTree();
    });
    $(function(){
        $("#boxing").click(function(){
            $("#poorHouseholdList").datagrid("reload",{});

        })
        $("#boxing").mouseover(function(){
            $("#boxing").css("color","red");
        })
        $("#boxing").mouseout(function(){
            $("#boxing").css("color","#333333");
        })
    })

</script>
