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
	<input type="hidden" value="${user.id}" id="use_id">
	<input type="hidden" value="${id}" id="id">
	<input type="hidden"  value="2" class="tjcs21">
	<input type="hidden"  value="" class="tjcs20">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>上级单位</th> 
			<td><select id="com_name" placeholder="请选择上级单位" class="popinput requiredInp tjcs7 requiredInp"></select></td>
			<th>单位类型</th> 
			<td><select class="popinput tjcs8 requiredInp" placeholder="请选择单位类型"  id="com_typ"></select></td>
		</tr>
		<tr>
			<th>公司名称</th>
			<td><input type="text" placeholder="请输入公司名称" class="popinput quinputcol tjcs1 requiredInp"></td>
			<th>公司标识</th>
			<td><input type="text" placeholder="请输入公司标识" class="popinput quinputcol tjcs2 requiredInp"></td>
		</tr>
		<tr>
			<th>省级</th> 
			<td><select class="popinput tjcs17 requiredInp"  placeholder="请选择省"  id="sheng" value="" onchange="getShi(this.value)"></select></td>
			<th>市级</th>
			<td><select class="popinput tjcs18 requiredInp"  placeholder="请选择市"   id="shi"   onchange="getQu(this.value)"></select></td>
		</tr>
		<tr>
			<th>区级</th> 
			<td><select class="popinput tjcs19 requiredInp"  placeholder="请选择区"  id="qu"></select></td>
			<th>单位状态</th> 
			<td>
			<select class="popinput  tjcs4 requiredInp"  >
				<option value="1">可用</option>
				<option value="2">不可用</option>
			</select></td>
		</tr>
		<tr>
			<th>公司地址</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入公司地址"    onfocus="" class="poptextarea tjcs3 requiredInp"></textarea>
			</td>
			
		</tr>
		<tr>
			<th>公司联系人</th>
			<td><input type="text" placeholder="请输入公司联系人" class="popinput quinputcol  tjcs5"></td>
			<th>公司联系电话</th>
			<td><input type="text" placeholder="请输入公司联系电话" class="popinput quinputcol tjcs6" onkeyup="value=value.replace(/[^\d]/g,'') "  maxlength="11"></td>
		</tr>
		
		<tr>
			<th>公司法人名称</th>
			<td><input type="text" placeholder="请输入公司法人名称" class="popinput quinputcol tjcs9"></td>
			<th>公司法人代码</th> 
			<td><input type="text" placeholder="请输入公司法人代码" class="popinput quinputcol tjcs10"></td>
		</tr>
		<tr>
			<th>经度(°)</th>
			<td><input type="number" placeholder="请输入经度" class="popinput quinputcol tjcs11"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
			<th>纬度(°)</th> 
			<td><input type="number" placeholder="请输入纬度" class="popinput quinputcol tjcs12"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
		</tr>
		<tr>
			<th>中心点坐标经度(°)</th>
			<td><input type="number" placeholder="请输入中心点坐标经度" class="popinput quinputcol tjcs13"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
			<th>中心点坐标纬度(°)</th> 
			<td><input type="number" placeholder="请输入中心点坐标纬度" class="popinput quinputcol tjcs14"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
		</tr>
		<tr>
			<th>地图缩放级别</th> 
			<td><input type="number" placeholder="请输入地图缩放级别" class="popinput quinputcol tjcs16"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
			<th>排序号</th>
			<td><input type="number" placeholder="请输入排序号" class="popinput quinputcol tjcs15 requiredInp"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
		</tr>
		
		<tr>
			<th>备注</th> 
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入备注"    onfocus="" class="poptextarea tjcs22"></textarea>
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
var id =$("#id").val();
var shengId = "";
var shiId = "";
var quId = "";
var com_typ = "";
var com_fat_id = "";
$(function(){
	
	$.ajax({                
		type : "post",
		url: url + "getBasComInfoRol.htm",
		data : "id="+id,
		async : false,
		success: function(data){                          
			if('USR000' == data.resultcode){
			 	var d = data.data[0];
			 	shengId = d.pro_id;
			 	shiId = d.cit_id;
			 	quId = d.are_id;
			 	com_typ = d.com_typ;
			 	com_fat_id = d.com_fat_id;
			 /* 	var datas=["com_nam","com_ide","com_add","com_sta","com_con","com_tel",
				           "com_typ_id","com_fat_id","com_lep","com_lep_cod","com_lon", 
				           "com_lat","com_sor","com_cen_lon","com_cen_lat","com_zoo_lev","pro_id","cit_id",
				           "are_id","com_lev","com_rol","remark"]
				for (var i = 0; i < datas.length; i++) {
					$(".tjcs"+(i+1)).val(d.datas[i]);
				}  */
			 	
			 	$(".tjcs1").val(d.com_nam);
			 	$(".tjcs2").val(d.com_ide);
			 	$(".tjcs3").val(d.com_add);
			 	$(".tjcs4").val(d.com_sta);
			 	$(".tjcs5").val(d.com_con);
			 	$(".tjcs6").val(d.com_tel);
			 	$(".tjcs7").val(d.com_fat_id);
			 	$(".tjcs8").val(d.com_typ);
			 	$(".tjcs9").val(d.com_lep);
			 	$(".tjcs10").val(d.com_lep_cod);
			 	$(".tjcs11").val(d.com_lon);
			 	$(".tjcs12").val(d.com_lat);
			 	$(".tjcs13").val(d.com_cen_lon);
			 	$(".tjcs14").val(d.com_cen_lat);
			 	$(".tjcs15").val(d.com_sor);
			 	$(".tjcs16").val(d.com_zoo_lev);
			 	$(".tjcs17").val(d.pro_id);
			 	$(".tjcs18").val(d.cit_id);
			 	$(".tjcs19").val(d.are_id);
			 	$(".tjcs20").val(d.com_lev);
			 	$(".tjcs21").val(d.com_rol);
			 	$(".tjcs22").val(d.remark);
			 	
			}else{
				layer.alert('数据解析错误');
			}
		}
	});
	
	$.ajax({                
		type : "post",
		url: url + "getAllComTyp.htm",
		success: function(data){                          
			if('USR000' == data.resultcode){
				var html = "";
				$.each(data.data,function(index,reg){
					if(com_typ == reg.com_typ){
						html += "<option value="+reg.id+" selected >"+reg.com_typ+"</option>"
					}else{
						html += "<option value="+reg.id+">"+reg.com_typ+"</option>"
					}
				})
				$("#com_typ").empty().append(html);
			}else{
				layer.alert(data.desc);
			}
		}
	});
	
	
	$.ajax({                
		type : "post",
		url: url + "getAllComNam.htm",
		success: function(data){                          
			if('USR000' == data.resultcode){
				 var html="";
				$.each(data.data,function(index,reg){
					if(com_fat_id ==  reg.id){
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
	
	
	$.ajax({                
		type : "post",
		url: url + "getBasRegLst1LevAll.htm",
		success: function(data){                          
			if('USR000' == data.resultcode){
				var html = "<option value='0' >-请选择-</option>";
				var isSel = false;
				$.each(data.data,function(index,reg){
					var selected = "";
					if(shengId == reg.id ){
						selected = "selected";
						isSel = true;
					}
					html += "<option value="+reg.id+" "+selected+">"+reg.reg_nam+"</option>"
				})
				$("#sheng").empty().append(html);
				if(isSel){
					getShi(shengId);
				}
			}else{
				layer.alert('数据解析错误');
			}
		}
	});
})


	function getShi(reg_ide){
		var html = "<option value='0' >-请选择-</option>";
		if("0" == reg_ide){
			$("#shi").empty().append(html);
			return ;
		}
		$.ajax({                
			type : "post",
			url: url + "getBasRegInfByFatIdNotPage.htm",
			data : "id="+reg_ide ,
			success: function(data){                          
				if('USR000' == data.resultcode){
					var isSel = false;
					$.each(data.data,function(index,reg){
						var selected = "";
						if(shiId == reg.id ){
							selected = "selected";
							isSel = true;
						}
						html += "<option value="+reg.id+" "+selected+">"+reg.reg_nam+"</option>"
					})
					$("#shi").empty().append(html);
					if(isSel){
						getQu(shiId);
					}
				}else{
					layer.alert('数据解析错误');
				}
			}
		});
	}

	function getQu(reg_ide){
		var html = "<option value='0' >-请选择-</option>";
		if("0" == reg_ide){
			$("#qu").empty().append(html);
			return ;
		}
		$.ajax({                
			type : "post",
			url: url + "getBasRegInfByFatIdNotPage.htm",
			data : "id="+reg_ide ,
			success: function(data){                          
				if('USR000' == data.resultcode){
					$.each(data.data,function(index,reg){
						var selected = "";
						if(quId == reg.id ){
							selected = "selected";
						}
						html += "<option value="+reg.id+" "+selected+">"+reg.reg_nam+"</option>"
					})
					$("#qu").empty().append(html);
				}else{
					layer.alert('数据解析错误');
				}
			}
		});
	}
	

function update(){
		var use_id=$("#use_id").val(); 
		var id=$("#id").val();
		//必填项的校验 
		var reFlag = false ; 
		 $(".requiredInp").each(function(){
		  		if($(this).val().trim() == "" || $(this).val() == undefined ){
				   reFlag = true;
				   layer.alert($(this).attr("placeholder"))
				   return false;
			   	}else{
			   		if($(this).attr("id") == "sheng" || $(this).attr("id") == "shi" || $(this).attr("id") == "qu" ){
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
	   	var param = "id="+id;
		var datas=["com_nam","com_ide","com_add","com_sta","com_con","com_tel",
		           "com_fat_id","com_typ","com_lep","com_lep_cod","com_lon", 
		           "com_lat","com_cen_lon","com_cen_lat","com_sor","com_zoo_lev","pro_id","cit_id",
		           "are_id","com_lev","com_rol","remark"]
		for (var i = 0; i < datas.length; i++) {
			var v = $(".tjcs"+(i+1)).val();
			param += "&&"+datas[i]+"="+v;
		} 
		param += "&&use_id="+use_id;
		console.log("param--"+param);
	   	/* if(pro_id == 0 || pro_id =="0" || cit_id == 0 || cit_id == "0" || are_id == 0 || are_id == "0"){
		   layer.alert("请完善信息！");
		   return;
	   	} */
		layer.confirm("确认修改?",function(){

	   	var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({                
			type : "post",
			url: url+ "insertOrUpdateComInfoRol2.htm",
			data : param +"&use_id="+use_id,
			dataType : "json",
			success : function(data) {		
				layer.close(indexlayer); //关闭 loading 
				if (data.resultcode == "USR000") {
					window.parent.refreshData();
					layer.alert("修改成功",function(){
						$(".cancle").click();				
					});
				}else{
					layer.alert(data.desc);
				}
			}
		})
	})
	
}

</script>
</body>
</html>
