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
<title>物资出入库</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>
<body >
<div class="pt18">
	<input type="hidden" value="${ass_num}" id="ass_num" name="ass_num">
	<input type="hidden" value="${user.id} " id="mod_use_id" name="mod_use_id">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
			<!-- <tr>
				<th>设备型号</th>
				<td><input type="text" id="app_mod_id"class="popinput quinputcol" readonly="readonly" ></td>
				<th>资产类型</th>
				<td><input type="text" id="ass_nam"  class="popinput quinputcol "  readonly="readonly"></td>
			</tr>
			<tr>	
				<th>资产编号</th>
				<td><input type="text" id="ass_num1"class="popinput quinputcol"  readonly="readonly"></td>
				<th>资产类型 </th>
				<td><input type="text" id="ass_typ_id"class="popinput quinputcol"  readonly="readonly"></td>
			</tr>
			<tr>
				<th>创建时间</th>
				<td><input type="text" id="crt_tim"class="popinput quinputcol"  readonly="readonly"></td>
				<th>创建人</th>
				<td><input type="text" id="crt_use_id"  class="popinput"  readonly="readonly"></td>
			</tr>
			<tr>
				<th>资产状态状态</th>
				<td><input type="text" id="cur_sta"  class="popinput"  readonly="readonly"></td>
				<th>排序号</th>
				<td><input type="text" id="equ_sor"class="popinput quinputcol"  readonly="readonly"></td>
			</tr>
			<tr>	
				<th>生产厂家ID</th>
				<td><input type="text" id="man_id"class="popinput quinputcol"  readonly="readonly"></td>
				<th>修改时间</th>
				<td><input type="text" id="mod_tim"class="popinput quinputcol"  readonly="readonly"></td>
			</tr>
			<tr>	
				<th>出入库单号</th>
				<td><input type="text" id="ord_num"class="popinput quinputcol"  readonly="readonly"></td>
				<th>出厂日期</th>
				<td><input type="text" id="pro_tim"class="popinput quinputcol"  readonly="readonly"></td>
			</tr>
			<tr>	
				<th>购买日期</th>
				<td><input type="text" id="pur_tim"class="popinput quinputcol" readonly="readonly"></td>
				<th>库存数量</th>
				<td><input type="text" id="stock_num"class="popinput quinputcol"  readonly="readonly"></td>
			</tr>
			<tr>
				<th>所属公司</th>
				<td><input type="text" id="sub_com_id"class="popinput quinputcol"  readonly="readonly"></td>
				<th>所在仓库</th>
				<td><input type="text" id="war_id"class="popinput quinputcol" readonly="readonly"></td>
			</tr> -->
			<tr>
				<th>资产名称</th>
				<td><input type="text" id="ass_nam" placeholder="请输入资产名称"  class="popinput quinputcol" readonly="readonly"></td>
				<th>出库数量</th>
				<td><input type="text" id="cou" placeholder="请输入入库数量" class="popinput quinputcol requiredInp"></td>
			</tr>
			<!-- <tr>
				<th>备注</th> 
			<td colspan="3"><input type="text" placeholder="请输入备注"  id="remark" name="remark"  style="width:96%;" class="popinput quinputcol"></td>
			</tr> -->
		<tr>
			
		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="update()">确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/ajaxfileupload.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<Script>


$(function(){
	var mod_use_id=$("#mod_use_id").val();
	var ass_num = $("#ass_num").val();
	getDataById(ass_num);
})

function getDataById(ass_num){
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	$.ajax({
		url:url+"getAssetsByAssNum.htm",
		type:"post",
		data:"ass_num="+ass_num,
		dataType:"json",
		success:function(data){
			layer.close(indexlayer);  //关闭 loading
			if(data.resultcode=="USR000"){
				var d=data.data[0];
					$("#app_mod_id").val(d.app_mod_id);
					$("#ass_nam").val(d.ass_nam);
					$("#ass_num1").val(d.ass_num);
					$("#ass_typ_id").val(d.ass_typ_id);
					$("#crt_tim").val(getLocalDateAndTime(d.crt_tim,2));
					$("#crt_use_id").val(d.crt_use_id);
					$("#cur_sta").val(d.cur_sta);
					$("#equ_sor").val(d.equ_sor);
					$("#man_id").val(d.man_id);
					$("#mod_tim").val(getLocalDateAndTime(d.mod_tim,2));
					$("#ord_num").val(d.ord_num);
					$("#pro_tim").val(getLocalDateAndTime(d.pro_tim,2));
					$("#pur_tim").val(getLocalDateAndTime(d.pur_tim,2));
					$("#remark").val(d.remark);
					$("#stock_num").val(d.stock_num);
					$("#sub_com_id").val(d.sub_com_id);
					$("#war_id").val(d.war_id);
				
			}else{
				layer.alert(data.desc);
			}
		}
	})
}


function update(){
	 var  cou = $("#cou").val();
	 var  use_id = $("#mod_use_id").val();
	 var  ass_num = $("#ass_num").val();

	 var  param="bround_typ=2";
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
	 param += "&cou="+cou+"&use_id="+use_id+"&ass_num="+ass_num;
	 
	layer.confirm("确定保存？",function(){
		 
		$.ajax({
	   	url:url+"assetsInOutBround.htm",
	   	data: param,
	   	dataType:"json",
	   	type:"post",
	   	success:function(data){
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
