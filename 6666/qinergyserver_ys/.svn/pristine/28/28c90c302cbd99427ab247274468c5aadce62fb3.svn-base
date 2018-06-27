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
<title></title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${user.id}" id="crt_use_id" name="crt_use_id">
	<input type="hidden" value="${user.com_id}" id="sub_com_id" name="sub_com_id">

	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			
			<th>类型</th>
			<td><select value="" id="def_typ_id" placeholder="请选择类型" class="popinput requiredInp"></select></td>
		
			<th>缺陷状态</th> 
			<td>
				<select   id="def_sta" placeholder="请选择缺陷状态" class="popinput requiredInp" >
							<option value="0">未消除</option>
							<option value="1">已消除</option>
							<option value="2">不处理</option> 
				</select>
			</td>
		</tr>
		<tr>
			<th>缺陷等级</th> 
			<td>
			 <select value="" id="def_grade" placeholder="请选择缺陷等级" class="popinput requiredInp">
						<option value="1">一级</option>
						<option value="2">二级</option>
						<option value="3">三级</option></select>
			 </td>
		</tr>
		<!-- <tr>
			<th>描述</th>
			<td colspan="3">
				<textarea    cols="3"  rows="3"   placeholder="请输入描述"  id="def_desc" name="def_desc"  class="poptextarea"></textarea>
			</td>
		</tr> -->
		<tr>
			<th>备注</th> 
			<td colspan="3">
				<textarea    cols="3"  rows="3"   placeholder="请输入备注"  id="remark" name="remark"  class="poptextarea"></textarea>
			</td>
		</tr>
		<tr>
			
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="insert()">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>
$(function(){
	getDefectTyp();
})
function getDefectTyp(){
	$.ajax({
		url:url+"getDefectTypList.htm",
		dataType:"json",
		type:"post",
		success:function(data){
			if(data.resultcode=="USR000"){
				var htmls="";
				if(data.data.length>0){
					for(var i=0;i<data.data.length;i++){
						var d=data.data[i];
						 htmls +=  "<option value='"+d.id+"'>"+d.typ_nam+"</option>";
					}
				}
				$("#def_typ_id").html(htmls);
			}else{
				layer.alert(data.desc);
			}
			
		}
	})
}
function insert(){
	 var crt_use_id=$("#crt_use_id").val();
	 var  sub_com_id = $("#sub_com_id").val();
	 var param = "";
	 var  def_typ_id = $("#def_typ_id").val();
	 var  def_sta = $("#def_sta").val();
	 var  def_grade = $("#def_grade").val();
	 //var  def_desc = $("#def_desc").val();
	 var  remark = $("#remark").val();
	 
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
	 
	 param += "&def_typ_id="+def_typ_id+"&def_sta="+def_sta+"&def_grade="+def_grade+
	 //"&def_desc="+def_desc+
	 "&remark="+remark+"&crt_use_id="+crt_use_id+"&sub_com_id="+sub_com_id;
	 
	layer.confirm("确定保存？",function(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
	    	url:url+"insDefectInfo.htm",
	    	data: param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer);  //关闭 loading 
	    		if (data.resultcode=="USR000") {
	    			window.parent.currentPage = 1 ;
	            	window.parent.getData();
	    			layer.alert("保存成功",function(){
	    				$(".cancle").click();
	    			});
	            	
				} else {
	               layer.alert(data.desc);
				}
	    	}
		});
	 })
	 
	
	
	 
}
</Script>
</body>
</html>
