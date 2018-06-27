<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>   
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	response.setHeader("P3P","CP=CAO PSA OUR");  
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
		
	</head>
	<body >
	<input type="hidden" id="id" value="${id }">
		<div class="pt18 fl " style="width: 100%">
		<div class=" tabxq ">
			<table cellpadding="0" cellspacing="0" border="0" width="100%"  >
				<tr>
					<th>上级单位</th> 
					<td id="com_name" ></td>
					<th>单位类型</th> 
					<td id="com_typ"></td>
				</tr>
				<tr>
					<th>公司名称</th>
					<td class=" tjcs1 "></td>
					<th>公司标识</th>
					<td class=" tjcs2 "></td>
				</tr>
				<tr>
					<th>省级</th> 
					<td class=" tjcs17 "  id="sheng" onchange="getShi(this.value)"> </td>
					<th>市级</th>
					<td class=" tjcs18 "   id="shi"   onchange="getQu(this.value)"> </td>
				</tr>
				<tr>
					<th>区级</th> 
					<td class=" tjcs19 "   id="qu"> </td>
					<th>单位状态</th> 
					<td class=" tjcs4 "  >
						<option value="1">可用</option>
						<option value="2">不可用</option> </td>
				</tr>
				<tr>
					<th>公司地址</th>
					<td id="remark" class=" tjcs3 "> </td>
					<th>公司联系人</th>
					<td class=" tjcs5"></td>
				</tr>
				<tr>
					<th>公司联系电话</th>
					<td class=" tjcs6"></td>
					<th>公司法人名称</th>
					<td class=" tjcs9"></td>
				</tr>
				<tr>
					<th>公司法人代码</th> 
					<td class=" tjcs10"></td>
					<th>经度(°)</th>
					<td class=" tjcs11"></td>
				</tr>
				<tr>
					<th>纬度(°)</th> 
					<td class=" tjcs12"></td>
					<th>中心点坐标经度(°)</th>
					<td class=" tjcs13"></td>
				</tr>
				<tr>
					<th>中心点坐标纬度(°)</th> 
					<td class=" tjcs14"></td>
					<th>地图缩放级别</th> 
					<td class=" tjcs16"></td>
				</tr>
				<tr>
					<th>排序号</th>
					<td class=" tjcs15 "></td>
					<th>备注</th> 
					<td id="remark" class="tjcs22" ></td>
				</tr>
				</table>
			</div>
		</div>
		
		
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/getText.js?pubVersion=201802070001"></script>
<script type="text/javascript">
var shengId = "";
var shiId = "";
var quId = "";
var com_typ = "";
var com_fat_id = "";
$(function(){
	var id =$("#id").val();
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
			 	
			 	$(".tjcs1").html(d.com_nam);
			 	$(".tjcs2").html(d.com_ide);
			 	$(".tjcs3").html(d.com_add);
			 	var com_sta=d.com_sta==1?"可用":d.com_sta==2?"不可用":"";
			 	$(".tjcs4").html(com_sta);
			 	$(".tjcs5").html(d.com_con);
			 	$(".tjcs6").html(d.com_tel);
			 	$(".tjcs7").html(d.com_fat_id);
			 	$(".tjcs8").html(d.com_typ);
			 	$(".tjcs9").html(d.com_lep);
			 	$(".tjcs10").html(d.com_lep_cod);
			 	$(".tjcs11").html(d.com_lon);
			 	$(".tjcs12").html(d.com_lat);
			 	$(".tjcs13").html(d.com_cen_lon);
			 	$(".tjcs14").html(d.com_cen_lat);
			 	$(".tjcs15").html(d.com_sor);
			 	$(".tjcs16").html(d.com_zoo_lev);
			 	$(".tjcs17").html(d.pro_id);
			 	$(".tjcs18").html(d.cit_id);
			 	$(".tjcs19").html(d.are_id);
			 	$(".tjcs20").html(d.com_lev);
			 	$(".tjcs21").html(d.com_rol);
			 	$(".tjcs22").html(d.remark);
			 	
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
						$("#com_typ").html(reg.com_typ);
					}
				})
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
						$("#com_name").html(reg.com_nam);
					}
				})												
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
				var isSel = false;
				$.each(data.data,function(index,reg){
					if(shengId == reg.id ){
						isSel = true;
						$("#sheng").html(reg.reg_nam);
					}
				})
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
		
		$.ajax({                
			type : "post",
			url: url + "getBasRegInfByFatIdNotPage.htm",
			data : "id="+reg_ide ,
			success: function(data){                          
				if('USR000' == data.resultcode){
					var isSel = false;
					$.each(data.data,function(index,reg){
						if(shiId == reg.id ){
							isSel = true;
							$("#shi").html(reg.reg_nam);
						}
					})
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
		$.ajax({                
			type : "post",
			url: url + "getBasRegInfByFatIdNotPage.htm",
			data : "id="+reg_ide ,
			success: function(data){                          
				if('USR000' == data.resultcode){
					$.each(data.data,function(index,reg){
						if(quId == reg.id ){
							$("#qu").html(reg.reg_nam);
						}
					})
				}else{
					layer.alert('数据解析错误');
				}
			}
		});
	}
</script>		

</body>
</html>