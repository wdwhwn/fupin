<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        $(function(){
            jQuery.ajax({
                type: 'POST',
                dataType : "json",
                url: 'poorHouseholdController.do?getTreeDemoData',//请求的action路径
                error: function () {//请求失败处理函数
                    alert('请求失败');
                },
                success:function(data){ //请求成功后处理函数。
                    console.log(data.obj);
                    zNodes = data.obj;   //把后台封装好的简单Json格式赋给zNodes
                }
            });
        });
    </script>
</head>
<body>
<table class="easyui-datagrid">
    <thead>
    <tr>
        <th data-options="field:'code'">编码</th>
        <th data-options="field:'name'">名称</th>
        <th data-options="field:'price'">价格</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>001</td><td>name1</td><td>2323</td>
    </tr>
    <tr>
        <td>002</td><td>name2</td><td>4612</td>
    </tr>
    </tbody>
    <thead>
    <tr>
        <th data-options="field:'code'">编码</th>
        <th data-options="field:'name'">名称</th>
        <th data-options="field:'price'">价格</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>001</td><td>name1</td><td>2323</td>
    </tr>
    <tr>
        <td>002</td><td>name2</td><td>4612</td>
    </tr>
    </tbody>
</table>
</body>
</html>
