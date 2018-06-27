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
<title>组织机构管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" id="fat_id" name="fat_id" value="${id}" class="tjcs7">
	<input type="hidden"  value="0" id="com_rol" name="com_rol" class="tjcs21">
	<input type="hidden"  value="${level}" class="tjcs20">
	<input type="hidden" value="${user.id}" id="userId">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>上级单位</th> 
			<td><input type="text" id="com_name" class="popinput requiredInp" placeholder="请选择上级单位"  readonly="readonly"></td>
			<th>单位类型</th> 
			<td><select class="popinput tjcs8 requiredInp" placeholder="请选择单位类型" id="com_typ_id"></select></td>
		</tr>
		<tr>
			<th>公司名称</th>
			<td><input type="text" placeholder="请输入公司名称" class="popinput quinputcol tjcs1 requiredInp"></td>
			<th>公司标识</th>
			<td><input type="text" placeholder="请输入公司标识" class="popinput quinputcol tjcs2 requiredInp"></td>
		</tr>
		<tr>
			<th>省级</th> 
			<td><select class="popinput tjcs17 requiredInp"  id="sheng" placeholder="请选择省"  value="" onchange="getShi(this.value)"></select></td>
			<th>市级</th>
			<td><select class="popinput tjcs18 requiredInp"  id="shi"  placeholder="请选择市"  onchange="getQu(this.value)"></select></td>
		</tr>
		<tr>
			<th>区级</th> 
			<td><select class="popinput tjcs19 requiredInp" placeholder="请选择区"   id="qu"></select></td>
			<th>单位状态</th> 
			<td>
			<select class="popinput  tjcs4 requiredInp" >
				<option value="1">可用</option>
				<option value="2">不可用</option>
			</select></td>
		</tr>
		<tr>
			<th>公司地址</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入公司地址" onfocus="" class="poptextarea quinputcol tjcs3 requiredInp"></textarea>
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
			<textarea    cols="3"  rows="3" placeholder="请输入备注" id="remark"   onfocus="" class="poptextarea quinputcol tjcs22"></textarea>
			</td>
		</tr>
		<!-- 
		<tr>
			<th>公司角色</th>
			<td>
				<select class="popinput tjcs21" >
					<option value="0">自己公司</option>
					<option value="1">业主公司</option>
					<option value="2">合作伙伴</option>
				</select>
			</td>
			
		</tr> -->
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="insert()" >确定</button>
		<input class="popbut" type="reset" value="重置" class="cz" onclick="reset()" >
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
		url: url + "getBasRegLst1LevAll.htm",
		success: function(data){                          
			if('USR000' == data.resultcode){
				var html = "<option value='0' >-请选择-</option>";
				$.each(data.data,function(index,reg){
					html += "<option value="+reg.id+">"+reg.reg_nam+"</option>"
				})
				$("#sheng").empty().append(html);
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
					html += "<option value="+reg.id+">"+reg.com_typ+"</option>"
				})
				$("#com_typ_id").empty().append(html);
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
					if($("#fat_id").val() == reg.id) {
						html = reg.com_nam;
					}
					else if ($("#fat_id").val()=="0") {
						html = "启能光科";
					}
				})												
				$("#com_name").val(html);
			}else{
				layer.alert(data.desc);
			}
		}
	});	
	
	if ($("#fat_id").val()=="0") {
			$("#com_name").attr("value","启能光科")
	} 
		
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
					$.each(data.data,function(index,reg){
						html += "<option value="+reg.id+">"+reg.reg_nam+"</option>"
					})
					$("#shi").empty().append(html);
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
					html += "<option value="+reg.id+">"+reg.reg_nam+"</option>"
				})
				$("#qu").empty().append(html);
			}else{
				layer.alert('数据解析错误');
			}
		}
	});
}

function insert(){
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
   	var param = "";
	var datas=["com_nam","com_ide","com_add","com_sta","com_con","com_tel",
	           "com_fat_id","com_typ_id","com_lep","com_lep_cod","com_lon", 
	           "com_lat","com_cen_lon","com_cen_lat","com_sor","com_zoo_lev","pro_id","cit_id",
	           "are_id","com_lev","com_rol","remark"]
	for (var i = 0; i < datas.length; i++) {
		var v = $(".tjcs"+(i+1)).val();
		param += "&&"+datas[i]+"="+v;
	} 
	var use_id=$("#userId").val();
	param += "&&use_id="+use_id;
	param = substringParam(param);
	console.log("param--"+param);
   	/* if(pro_id == 0 || pro_id =="0" || cit_id == 0 || cit_id == "0" || are_id == 0 || are_id == "0"){
	   layer.alert("请完善信息！");
	   return;
   	} */
   	layer.confirm("是否添加？",function(){
   		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({                
			type : "post",
			url: url+ "insertComInfo.htm",
			data : param ,
			dataType : "json",
			success : function(data) {				
				layer.close(indexlayer); //关闭 loading 
				if (data.resultcode == "USR000") {
					window.parent.refreshData();
					layer.alert("保存成功");
				}else{
					layer.alert(data.desc);
				}
			}
		})
   	})
	   	
}


function reset(){
	window.location.reload();
}
</script>
</body>
</html>
