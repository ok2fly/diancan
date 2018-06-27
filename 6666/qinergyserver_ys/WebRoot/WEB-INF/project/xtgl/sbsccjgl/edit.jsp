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
	<input type = "hidden" value="${id}" name="" id="id">
	<input type = "hidden" value="${user.id}" name="" id="use_id">
 	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>厂家名称</th>
			<td><input type="text"  placeholder="请输入厂家名称"   id="man_nam" class="popinput quinputcol requiredInp" ></td>
			<th>厂家状态</th>
			<td>
				<select id="man_sta" class="popinput requiredInp"  placeholder="请选择厂家状态">
					<option value ="1">可用</option>
					<option value ="0">不可用</option>
				</select>
			</td>
		</tr>
		<tr>	
			<th>省级</th> 
			<td><select class="popinput tjcs17 requiredInp" placeholder="请选择省" id="pro_id"  onchange="getShi(this.value,'','')"></select></td>
			<th>市级</th>
			<td><select class="popinput tjcs18 requiredInp"  placeholder="请选择市" id="cit_id"    onchange="getQu('',this.value,'')"></select></td>
		</tr>
		<tr>
			<th>区级</th> 
			<td><select class="popinput tjcs19 requiredInp"  placeholder="请选择区" id="are_id"></select></td>	
		</tr>
		<tr>
			<th>厂家地址</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入厂家地址" id="man_add"   onfocus="" class="poptextarea quinputcol requiredInp"></textarea>
			</td>
		</tr>
		<tr>
			<th>联系人</th>
			<td><input type="text"  placeholder="请输入联系人"   id="man_cot" class="popinput quinputcol" ></td>
			<th>联系电话</th>
			<td><input type="text"  placeholder="请输入联系电话"   id="man_mob" class="popinput quinputcol"  onkeyup="value=value.replace(/[^\d]/g,'') "  maxlength="11" ></td>
		</tr>
		<tr>
			<th>备用电话</th>
			<td><input type="text"  placeholder="请输入备用电话" id="man_spa" class="popinput quinputcol" onkeyup="value=value.replace(/[^\d]/g,'') "  maxlength="11"></td>
		</tr>
		<tr>	
			<th>厂家经度(°)</th>
			<td><input type="number" placeholder="请输入厂家经度"  id="sta_lon" class="popinput quinputcol"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
<!-- 			<td><input type="number" placeholder="请输入厂家经度"  id="sta_lon" class="popinput quinputcol"  onkeypress="return (/[/d.]/.test(String.fromCharCode(event.keyCode)))" style="ime-mode:Disabled"></td> -->
			<th>厂家纬度(°)</th>
			<td><input type="number"  placeholder="请输入厂家纬度"   id="sta_lat" class="popinput quinputcol"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
<!-- 			<td><input type="number"  placeholder="请输入厂家纬度"   id="sta_lat" class="popinput quinputcol"  onkeypress="return (/[/d.]/.test(String.fromCharCode(event.keyCode)))" style="ime-mode:Disabled"></td> -->
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
	getType();
})


function getById(id){
	 $.ajax({
	    	url:url+"getManInf.htm",
	    	data : "man_id="+id,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 var htmls = "";
	    			 for(var i = 0; i< data.data.length ; i++){
	    				 var d =  data.data[i];
	    				 if(d.id == id){
	    					 $("#man_cot").val(d.man_cot);
	    					 $("#man_mob").val(d.man_mob);
	    					 $("#man_spa").val(d.man_spa);
	    					 $("#man_nam").val(d.man_nam);
	    					 $("#man_add").val(d.man_add);
	    					 $("#remark").val(d.remark);
	    					 $("#man_sta").val(d.man_sta);
	    					 $("#sta_lon").val(d.sta_lon);
	    					 $("#sta_lat").val(d.sta_lat);
	    					 $("#use_nam").val(d.use_nam);
	    	   	    		 getSheng(d.pro_id,d.cit_id,d.are_id);
	    				 }
	    			 } 
				} else {
	               layer.alert(data.desc);
				}
	    	}
  })
}

function getSheng(id,cityId,areaId){
	 $.ajax({                
			type : "post",
			url: url + "getBasRegLst1LevAll.htm",
			success: function(data){                          
				if('USR000' == data.resultcode){
					var html = "<option value='0' >-请选择-</option>";
					$.each(data.data,function(index,reg){
						if(id == reg.id){
							html += "<option value="+reg.id+" selected >"+reg.reg_nam+"</option>"
							getShi(id,cityId,areaId);
						}else{
							html += "<option value="+reg.id+">"+reg.reg_nam+"</option>"
						}
					})
					$("#pro_id").empty().append(html);
				}else{
					layer.alert('数据解析错误');
				}
			}
		});
		 
}

function getShi(reg_ide,cityId,areaId){
	var html = "<option value='0' >-请选择-</option>";
	if("0" == reg_ide){
		$("#cit_id").empty().append(html);
		return ;
	}
	$.ajax({                
		type : "post",
		url: url + "getBasRegInfByFatIdNotPage.htm",
		data : "id="+reg_ide ,
		success: function(data){                          
			if('USR000' == data.resultcode){
				$.each(data.data,function(index,reg){
					if(cityId == reg.id){
						html += "<option value="+reg.id+" selected>"+reg.reg_nam+"</option>"
						 getQu(id,cityId,areaId);
					}else{
						html += "<option value="+reg.id+">"+reg.reg_nam+"</option>"
					}
				})
				$("#cit_id").empty().append(html);
			}else{
				layer.alert('数据解析错误');
			}
		}
	});
}

function getQu(id,reg_ide,areaId){
	var html = "<option value='0' >-请选择-</option>";
	if("0" == reg_ide){
		$("#are_id").empty().append(html);
		return ;
	}
	$.ajax({                
		type : "post",
		url: url + "getBasRegInfByFatIdNotPage.htm",
		data : "id="+reg_ide ,
		success: function(data){                          
			if('USR000' == data.resultcode){
				$.each(data.data,function(index,reg){
					if(areaId == reg.id){
						html += "<option value="+reg.id+" selected >"+reg.reg_nam+"</option>"
					}else{
						html += "<option value="+reg.id+">"+reg.reg_nam+"</option>"
					}
				})
				$("#are_id").empty().append(html);
			}else{
				layer.alert('数据解析错误');
			}
		}
	});
}




function update(){
		var reFlag = false ; 
		 $(".requiredInp").each(function(){
		  		if($(this).val().trim() == "" || $(this).val() == undefined ){
				   reFlag = true;
				   layer.alert($(this).attr("placeholder"))
				   return false;
			   	}else{
			   		if($(this).attr("id") == "pro_id" || $(this).attr("id") == "cit_id" || $(this).attr("id") == "are_id" ){
		 		 		if($(this).val() == "0"){
		 		 		   reFlag = true;
						   layer.alert($(this).attr("placeholder"))
						   return false;
		 		 		}
		 		 	} 
			   	}
		  		if(reFlag){
		  			return false;
		  		}
		 }); 
		 if(reFlag){
			   return false;
		 }
		 
		var id = $("#id").val();
		var man_cot = $("#man_cot").val();
		var man_mob = $("#man_mob").val();
		var man_spa = $("#man_spa").val();
		var man_add = $("#man_add").val();
		var remark = $("#remark").val();
		var man_sta = $("#man_sta").val();
		var sta_lon = $("#sta_lon").val();
		var sta_lat = $("#sta_lat").val();
		var pro_id = $("#pro_id").val();
		var cit_id = $("#cit_id").val();
		var are_id = $("#are_id").val();
		var man_nam = $("#man_nam").val();
		var use_id = $("#use_id").val();
		
		layer.confirm("确定修改？",function(){

		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		 $.ajax({
		    	url:url+"updMan.htm",
		    	data : "man_id="+id+
		    			"&&man_cot="+man_cot+
		    			"&&man_mob="+man_mob+
		    			"&&man_spa="+man_spa+
		    			"&&man_add="+man_add+
		    			"&&remark="+remark+
		    			"&&man_sta="+man_sta+
		    			"&&sta_lon="+sta_lon+
		    			"&&sta_lat="+sta_lat+
		    			"&&pro_id="+pro_id+
		    			"&&cit_id="+cit_id+
		    			"&&are_id="+are_id+	
		    			"&&man_nam="+man_nam+
		    			"&&use_id="+use_id,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		layer.close(indexlayer); //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    			window.parent.currentPage = 1 ;
		    			  window.parent.getData();
		    			  layer.alert("修改成功");
		    			  $(".cancle").click();
					} else {
		               layer.alert(data.desc);
					}
		    	}
		})
	})
	//必填项的校验 
	
}

</script>
</body>
</html>
