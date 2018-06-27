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
<title>部门修改</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${user.id}" id="userId">
	<input type="hidden" value="${id}" id="id">
	<input type="hidden" value="${com_id}" id="com_id">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>上级单位</th> 
			<td><select id="com_name" placeholder="请选择上级单位" class="popinput requiredInp tjcs3 requiredInp"></select></td>
			<th>部门名称</th>
			<td><input type="text" placeholder="请输入公司名称" class="popinput quinputcol tjcs1 requiredInp"></td>
		</tr>
		<tr>
			<th>部门标识</th>
			<td><input type="text" placeholder="请输入公司标识" class="popinput quinputcol tjcs2 requiredInp"></td>
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
		<button class="popbut" onclick="update()" >确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script>
var id =$("#id").val();
var com_id =$("#com_id").val();
$(function(){
	
	$.ajax({                
		type : "post",
		url: url + "getDepInfById.htm",
		data : "id="+id+"&com_id="+com_id,
		async : false,
		success: function(data){                          
			if('USR000' == data.resultcode){
			 	var d = data.data;
			 	$(".tjcs1").val(d.dep_nam);
			 	$(".tjcs2").val(d.dep_ide);
			 	$(".tjcs3").val(d.com_id);
			 	$(".tjcs4").val(d.dep_sta);
			 	$(".tjcs5").val(d.dep_sor);
			 	$(".tjcs6").val(d.remark);
			 	
			}else{
				layer.alert('数据解析错误');
			}
		}
	});
	 
	
	$.ajax({                
		type : "post",
		url: url + "getAllComNam.htm",
		success: function(data){                          
			if('USR000' == data.resultcode){
				 var html="";
				 if(com_id == 0 ){
					html += "<option value='0' selected >启能光科</option>";
				}
				$.each(data.data,function(index,reg){
					if(com_id ==  reg.id){
						html += "<option value="+reg.id+" selected >"+reg.com_nam+"</option>"
					}else{
						/* html += "<option value="+reg.id+">"+reg.com_nam+"</option>" */
					}
				})												
				$("#com_name").html(html);
			}else{
				layer.alert(data.desc);
			}
		}
	});	
	
	 
})

 

function update(){
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
   	var param = "id="+id;
   	var datas=["dep_nam","dep_ide","com_id","dep_sta","dep_sor","remark"]
	for (var i = 0; i < datas.length; i++) {
		var v = $(".tjcs"+(i+1)).val();
		param += "&&"+datas[i]+"="+v;
	} 
   	
	console.log("param--"+param);
   	/* if(pro_id == 0 || pro_id =="0" || cit_id == 0 || cit_id == "0" || are_id == 0 || are_id == "0"){
	   layer.alert("请完善信息！");
	   return;
   	} */
   	
	layer.confirm("是否确认修改该部门？",function(){
	   	var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({                
			type : "post",
			url: url+ "updDepInf.htm",
			data : param ,
			dataType : "json",
			success : function(data) {	
				layer.close(indexlayer); //关闭 loading 
				if (data.resultcode == "USR000") {
					window.parent.refreshData();
					$(".cancle").click();
					window.parent.layer.alert("修改成功");
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
