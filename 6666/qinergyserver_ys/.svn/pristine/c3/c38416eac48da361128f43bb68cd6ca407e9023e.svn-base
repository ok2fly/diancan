<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>故障类型管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" id="com_id" name="com_id" value="${id}" class="tjcs3">
	<input type="hidden" value="${user.id}" id="userId">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>上级公司</th> 
			<td><input type="text" id="com_name" placeholder="请输入上级公司" class="popinput requiredInp requiredInp"  readonly="readonly"></td>
			<th>部门名称</th>
			<td><input type="text" placeholder="请输入部门名称" class="popinput quinputcol tjcs1 requiredInp"></td>
		</tr>
		<tr>
			<th>部门标识</th>
			<td><input type="text" placeholder="请输入部门标识" placeholder="请输入部门标识" class="popinput quinputcol tjcs2 requiredInp"></td>
			<th>部门状态</th> 
			<td>
			<select class="popinput  tjcs4 requiredInp" placeholder="请输入部门状态">
				<option value="1">可用</option>
				<option value="2">不可用</option>
			</select></td>
		</tr>
		<tr>
			<th>排序号</th>
			<td><input type="number" placeholder="请输入排序号" class="popinput quinputcol tjcs5 requiredInp"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
		</tr>
		<tr>
			<th>备注</th> 
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入备注"    onfocus="" class="poptextarea quinputcol tjcs6"></textarea>
			</td>
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="insert()" >确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script>
$(function(){
	$.ajax({                
		type : "post",
		url: url + "getAllComNam.htm",
		success: function(data){                          
			if('USR000' == data.resultcode){
				 var html="";
				$.each(data.data,function(index,reg){
					if($("#com_id").val() == reg.id) {
						html = reg.com_nam;
					}
					else if ($("#com_id").val()=="0") {
						html = "启能光科";
					}
				})												
				$("#com_name").val(html);
			}else{
				layer.alert(data.desc);
			}
		}
	});	
	
	if ($("#com_id").val()=="0") {
			$("#com_name").attr("value","启能光科")
	} 
		
}) 
function insert(){
	//必填项的校验 
	var reFlag = false ; 
	 $(".requiredInp").each(function(){
	  		if($(this).val().trim() == "" || $(this).val() == undefined ){
			   reFlag = true;
			   layer.alert($(this).attr("placeholder"))
			   return false;
		   	} 
	  		if(reFlag){
	  			return false;
	  		}
	 }); 
	 if(reFlag){
		   return false;
	 }
   	var param = "";
	var datas=["dep_nam","dep_ide","com_id","dep_sta","dep_sor","remark"]
	for (var i = 0; i < datas.length; i++) {
		var v = $(".tjcs"+(i+1)).val();
		param += "&&"+datas[i]+"="+v;
	} 
   	
	param = substringParam(param);
	console.log("param--"+param);
   	/* if(pro_id == 0 || pro_id =="0" || cit_id == 0 || cit_id == "0" || are_id == 0 || are_id == "0"){
	   layer.alert("请完善信息！");
	   return;
   	} */
   	layer.confirm("是否确认添加该部门？",function(){
	   	var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({                
			type : "post",
			url: url+ "insDepInf.htm",
			data : param ,
			dataType : "json",
			success : function(data) {		
				layer.close(indexlayer); //关闭 loading 
				if (data.resultcode == "USR000") {
					window.parent.refreshData();
					$(".cancle").click();
					window.parent.layer.alert("新增成功");
				}else{
					layer.alert(data.desc);
				}
			}
		});	
    })
}

</script>
</body>
</html>
