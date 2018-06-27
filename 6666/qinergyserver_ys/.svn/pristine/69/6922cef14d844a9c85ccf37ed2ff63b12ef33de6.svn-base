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
<title>告警类型管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type = "hidden" value="${id}" name="" id="id" >
	<input type = "hidden" value="${user.id}" name="" id="use_nam">
	<input type="hidden" value="${user.id}" id="use_id" name="use_id">
 	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
			<tr>
				<th>告警名称</th> 
				<td><input type="text" id="ala_info"  placeholder="请输入告警名称" class="popinput quinputcol requiredInp"  ></td>
				 <th>告警等级</th> 
				<td><select  id="flt_lev" class="popinput quinputcol requiredInp"   placeholder="请选择告警等级" >
						<option value="1">告警</option>
						<option value="2">故障</option>
				</select></td>
			</tr>
			<tr>
				<th>设备类型</th>
				<td><select  id="app_typ_id"  placeholder="请选择设备类型"   class="popinput requiredInp" ></select></td>
				<th>索引位置</th> 
				<td><input type="number" class="popinput quinputcol requiredInp" id="idx_pst"  placeholder="请输入索引位置"   oninput="if(value.length>11)value=value.slice(0,11)"  ></input></td>
			</tr>
			<tr>
				<th>备注</th>
				<td colspan="3">
				<textarea    cols="3"  rows="3" placeholder="请输入备注" id="remark"   onfocus="" class="poptextarea"></textarea>
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
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script>
$(function(){
	var id = $("#id").val();
	getById(id);  
	
})
 
function getApp(app_typ_nam){
	 $.ajax({
	    	url:url+"getAppInfo.htm",
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data.data.length > 0 ){
	    				 for(var i = 0; i< data.data.length ; i++){
			    				var d =  data.data[i];
			    				if(app_typ_nam == d.typ_nam ){
			    					 htmls +=  "<option value='"+d.id+"' selected >"+d.typ_nam+"</option>";
			    				}else{
			    					 htmls +=  "<option value='"+d.id+"'>"+d.typ_nam+"</option>";
			    				}
		    			 }
	    			 } 
	   	    		 
	   	    	     $("#app_typ_id").html(htmls);
	    			
				} else {
	               layer.alert(data.desc);
				}
	    	}
})
}
function getById(id){
	 $.ajax({
	    	url:url+"getAlaCode.htm",
	    	data : "id="+id,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			if(data.data.length>0) {
	    				 var htmls = "";
		    			 for(var i = 0; i<data.data.length; i++){
		    				 var d =  data.data[i];
		    				 if(d.id == id){
		    	   	    		 getApp(d.app_typ_nam);
		    					 $("#ala_info").val(d.ala_info);
		    					 $("#flt_lev").val(d.flt_lev);
		    					 $("#app_typ_id").val(d.app_typ_id);
		    	   	    		 $("#idx_pst").val(d.idx_pst);
		    	   	    		 $("#remark").val(d.remark);
		    				 }
		    			 } 
	    			}
	    			
				} else {
	               layer.alert(data.desc);
				}
	    	}
  })
}




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
	 
	 
	var id = $("#id").val();
	var ala_info = $("#ala_info").val();
	var flt_lev = $("#flt_lev").val();
	var app_typ_id = $("#app_typ_id").val();
	var idx_pst = $("#idx_pst").val();
	var use_nam = $("#use_nam").val();
	var remark = $("#remark").val();
	var use_id = $("#use_id").val();
	layer.confirm("是否修改？",function(){
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		 $.ajax({
		    	url:url+"updateAlaCode.htm",
		    	data : "id="+id+
		    			"&&ala_info="+ala_info+
		    			"&&flt_lev="+flt_lev+
		    			"&&app_typ_id="+app_typ_id+
		    			"&&idx_pst="+idx_pst+
		    			"&&use_nam="+use_nam+
		    			"&&remark="+remark+
		    			"&&use_id="+use_id,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer); //关闭 loading 
		    		if (data.resultcode=="USR000") {
			    		  window.parent.currentPage = 1 ;
			    		  window.parent.getData();
		    			  layer.alert("修改成功",function(){
		    				  $(".cancle").click();
		    			  });
		    			 
					} else {
		               layer.alert(data.desc);
					}
		    		
		    	}
		})
	})
	
}

</script>
</body>
</html>
