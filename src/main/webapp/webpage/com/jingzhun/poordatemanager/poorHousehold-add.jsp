<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>贫困户表</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,bootstrap-table,layer,validform,webuploader,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="poorHouseholdController.do?doAdd" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id"/>
		<div class="row">
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					行政县：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a1" type="text" class="form-control input-sm" maxlength="100"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					乡镇：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a2" type="text" class="form-control input-sm" maxlength="100"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					行政村：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a3" type="text" class="form-control input-sm" maxlength="100"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					自然村：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a4" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					户编号：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a5" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					人编号：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a6" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					姓名：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a7" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					证件号码：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a8" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					人数：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a9" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					与户主关系：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
	            	<t:dictSelect field="a10" type="select" hasLabel="false" title="与户主关系" extendJson="{class:'form-control input-sm'}"   typeGroupCode="与户主关系" ></t:dictSelect>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					民族：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a11" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					文化程度：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a12" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					在校生状况：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a13" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					健康状况：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a14" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					劳动技能：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a15" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					务工状况：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a16" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					务工时间：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a17" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					参加大病医疗：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a18" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					脱贫属性：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a19" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					脱贫年度：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a20" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					贫困户属性：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
	            	<div style="padding-top:5px">
	            	<t:dictSelect field="a21" extendJson="{class:'i-checks'}" type="radio" hasLabel="false"  title="贫困户属性"  typeGroupCode="" ></t:dictSelect>
	            	</div>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					主要致贫原因：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a22" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					危房户：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a23" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					饮水安全：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a24" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					饮水困难：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a25" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					人均纯收入：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a26" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					联系电话：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a27" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					长号码：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a28" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					短号码：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="a29" type="text" class="form-control input-sm" maxlength="100"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					用户照片：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
				<t:webUploader name="a30" outJs="true" auto="true" showImgDiv="filediv_a30" type="image" buttonText='添加图片' displayTxt="false"></t:webUploader>
				<div class="form" id="filediv_a30"></div>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					帮扶责任人手机号：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="helperMobile" type="text" class="form-control input-sm" maxlength="30"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					定位：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="location" type="text" class="form-control input-sm" maxlength="100"  datatype="*"  ignore="checked"  />
				</div>
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