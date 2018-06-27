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
	<input type="hidden" value="${user.id}" id="user_id" name="useId">
	
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>数据类型</th>
			<td><select   id="dic_typ_id"  placeholder="请选择数据类型"  class="popinput requiredInp"></select></td>
			<th>数据字典名称</th>
			<td><input type="text" placeholder="请输入数据字典名称"  id="par_nam"   class="popinput quinputcol requiredInp"></td>
		</tr>
		<tr>
			<th>字典唯一标识</th>
			<td><input type="text" placeholder="请输入数据字典唯一标识"  id="par_ide"   class="popinput quinputcol requiredInp"></td>
			<th>数据字典参数值</th>
			<td><input type="text" placeholder="请输入参数值"  id="par_val"   class="popinput quinputcol requiredInp"></td>
		</tr>
		<tr>
			<th>排序号</th>
			<td><input type="number" placeholder="请输入排序号"  id="sor_num"   class="popinput quinputcol requiredInp"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="insert()"  >确定</button>
		<input class="popbut" type="reset" value="重置" class="cz" onclick="reset()">
	
	</form>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>
$(function(){
	getType();
})
 
function getType(){
 	$.ajax({
	    	url:url+"getDataDicTypList.htm",
	    	dataType:"json",
	    	async : false,
	    	type:"post",
	    	success:function(data2){
	    		if (data2.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data2.data.length > 0 ){
	    				 for(var i = 0; i< data2.data.length ; i++){
			    				var d =  data2.data[i];
			    				 htmls +=  "<option value='"+d.id+"'>"+d.dic_typ_nam +"</option>";
		    			 }
	    				 $("#dic_typ_id").html(htmls); 
	    			 } 
				} else {
	               layer.alert(data.desc);
				}
	    	}
    })
}

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
	 
	 var  useId = $("#user_id").val();
	 var  par_ide = $("#par_ide").val();
	 var  par_nam = $("#par_nam").val();
	 var  par_val = $("#par_val").val();
	 var  sor_num = $("#sor_num").val();
	 var  dic_typ_id = $("#dic_typ_id").val();
	 
	 layer.confirm("是否添加？",function(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
	    	url:url+"insDataDic.htm",
	    	data:"crt_use_id="+useId+"&par_ide="+par_ide+"&par_nam="+par_nam+"&par_val="+par_val+"&sor_num="+sor_num+"&dic_typ_id="+dic_typ_id,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer); //关闭 loading 
	    		if (data.resultcode=="USR000") {
	    			window.parent.currentPage = 1 ; 
	    			window.parent.getData();	
	    			layer.alert("保存成功");
				} else {
	               layer.alert(data.desc);
				}
	    	}
		});
	 })
		
	
	 
}
function reset(){
	window.location.reload();
}
</Script>
</body>
</html>
