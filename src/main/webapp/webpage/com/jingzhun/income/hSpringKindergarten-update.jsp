<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title></title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="hSpringKindergartenController.do?doUpdate" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id" value="${hSpringKindergarten.id}"/>
	<div class="form-group">
		<label for="name" class="col-sm-3 control-label">姓名：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="name" name="name" value='${hSpringKindergarten.name}' type="text" maxlength="30" class="form-control input-sm" placeholder="请输入姓名"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="sex" class="col-sm-3 control-label">性别：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect field="sex" type="radio" extendJson="{class:'i-checks'}"  typeGroupCode="csex"  hasLabel="false"  title="性别" defaultVal="${hSpringKindergarten.sex}"></t:dictSelect>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="idno" class="col-sm-3 control-label">证件号码：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="idno" name="idno" value='${hSpringKindergarten.idno}' type="text" maxlength="50" class="form-control input-sm" placeholder="请输入证件号码"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="school" class="col-sm-3 control-label">所在学校班级：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="school" name="school" value='${hSpringKindergarten.school}' type="text" maxlength="255" class="form-control input-sm" placeholder="请输入所在学校班级"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="address" class="col-sm-3 control-label">家庭住址：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="address" name="address" value='${hSpringKindergarten.address}' type="text" maxlength="255" class="form-control input-sm" placeholder="请输入家庭住址"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="huzhu" class="col-sm-3 control-label">户主：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="huzhu" name="huzhu" value='${hSpringKindergarten.huzhu}' type="text" maxlength="255" class="form-control input-sm" placeholder="请输入户主"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="idcard" class="col-sm-3 control-label">开户行：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="idcard" name="idcard" value='${hSpringKindergarten.idcard}' type="text" maxlength="255" class="form-control input-sm" placeholder="请输入开户行"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="idcardName" class="col-sm-3 control-label">开户行用户名：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="idcardName" name="idcardName" value='${hSpringKindergarten.idcardName}' type="text" maxlength="255" class="form-control input-sm" placeholder="请输入开户行用户名"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="idcardNum" class="col-sm-3 control-label">开户行账号：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="idcardNum" name="idcardNum" value='${hSpringKindergarten.idcardNum}' type="text" maxlength="255" class="form-control input-sm" placeholder="请输入开户行账号"  ignore="ignore" />
			</div>
		</div>
	</div>
	</form>
	</div>
 </div>
<script type="text/javascript">
var subDlgIndex = '';
$(document).ready(function() {
	//单选框/多选框初始化
	$('.i-checks').iCheck({
		labelHover : false,
		cursor : true,
		checkboxClass : 'icheckbox_square-green',
		radioClass : 'iradio_square-green',
		increaseArea : '20%'
	});
	
	//表单提交
	$("#formobj").Validform({
		tiptype:function(msg,o,cssctl){
			if(o.type==3){
				validationMessage(o.obj,msg);
			}else{
				removeMessage(o.obj);
			}
		},
		btnSubmit : "#btn_sub",
		btnReset : "#btn_reset",
		ajaxPost : true,
		beforeSubmit : function(curform) {
		},
		usePlugin : {
			passwordstrength : {
				minLen : 6,
				maxLen : 18,
				trigger : function(obj, error) {
					if (error) {
						obj.parent().next().find(".Validform_checktip").show();
						obj.find(".passwordStrength").hide();
					} else {
						$(".passwordStrength").show();
						obj.parent().next().find(".Validform_checktip").hide();
					}
				}
			}
		},
		callback : function(data) {
			var win = frameElement.api.opener;
			if (data.success == true) {
				frameElement.api.close();
			    win.reloadTable();
			    win.tip(data.msg);
			} else {
			    if (data.responseText == '' || data.responseText == undefined) {
			        $.messager.alert('错误', data.msg);
			        $.Hidemsg();
			    } else {
			        try {
			            var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
			            $.messager.alert('错误', emsg);
			            $.Hidemsg();
			        } catch (ex) {
			            $.messager.alert('错误', data.responseText + "");
			            $.Hidemsg();
			        }
			    }
			    return false;
			}
		}
	});
});
</script>
</body>
</html>