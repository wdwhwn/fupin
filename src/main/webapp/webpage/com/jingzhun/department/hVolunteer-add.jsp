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
	<form class="form-horizontal" role="form" id="formobj" action="hVolunteerController.do?doAdd" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id"/>
		<div class="form-group">
			<label for="sort" class="col-sm-3 control-label">序号：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="sort" name="sort" type="text" maxlength="10" class="form-control input-sm" placeholder="请输入序号"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-3 control-label">姓名：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="name" name="name" type="text" maxlength="30" class="form-control input-sm" placeholder="请输入姓名"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="mobile" class="col-sm-3 control-label">电话：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="mobile" name="mobile" type="text" maxlength="15" class="form-control input-sm" placeholder="请输入电话"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="unit" class="col-sm-3 control-label">单位：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="unit" name="unit" type="text" maxlength="50" class="form-control input-sm" placeholder="请输入单位"  ignore="ignore" />
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