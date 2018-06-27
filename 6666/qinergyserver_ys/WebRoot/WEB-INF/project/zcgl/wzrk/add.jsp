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
<input type="hidden" value="${user.id}" id="crt_use_id" name="crt_use_id">
	<input type="hidden" value="${user.com_id}" id="sub_com_id" name="sub_com_id">
<div class="pt18">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
			<tr>
				<th>资产类型</th>
				<td><select value="" id="ass_typ_id" placeholder="请选择资产类型"  class="popinput requiredInp " ></select></td>
				<th>资产名称</th>
				<td><input type="text" id="ass_nam" placeholder="请输入资产名称"  class="popinput quinputcol requiredInp"></td>
			</tr>
			<tr>	
				<th>设备型号</th>
				<td><select  id="app_mod_id" placeholder="请选择设备型号"  class="popinput requiredInp"></select></td>
				<th>生产厂家</th>
				<td><select  id="man_id" placeholder="请选择生产厂家"  class="popinput requiredInp"></select></td>
			</tr>
			<tr>	
				<th>资产编号</th>
				<td><input type="text" id="ass_num1" placeholder="请输入资产编号"  class="popinput quinputcol requiredInp" ></td>
				<th>排序号</th>
				<td><input type="number" id="equ_sor" placeholder="请输入排序号"  class="popinput quinputcol requiredInp"   oninput="if(value.length>11)value=value.slice(0,11)"></td>
			</tr>
			<tr>	
				<th>计量单位</th>
				<td><input type="text" id="unit" placeholder="请输入计量单位"  class="popinput quinputcol requiredInp" ></td>
				<th>入库数量</th>
				<td><input type="number" id="cou" placeholder="请输入入库数量" class="popinput quinputcol requiredInp"   oninput="if(value.length>11)value=value.slice(0,11)"></td>
			</tr>
			<tr>	
				<th>出厂日期</th>
				<td><input type="text" id="pro_tim"class="popinput quinputcol Wdate requiredInp" placeholder="请输入出厂日期"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"></td>
				<th>购买日期</th>
				<td><input type="text" id="pur_tim"class="popinput quinputcol Wdate requiredInp" placeholder="请输入购买日期"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" ></td>
			</tr>
			<tr>	
				<th>单价(元)</th>
				<td><input type="number" id="price" placeholder="请输入单价" class="popinput quinputcol"   oninput="if(value.length>11)value=value.slice(0,11)"></td>
			</tr>
			
			<tr>	
				<th>长*宽*深(mm)</th>
				<td><input type="number" placeholder="长" id="size_lon" class="inp"   oninput="if(value.length>11)value=value.slice(0,11)">*
					<input type="number"  placeholder="宽" id="size_wid" class="inp"   oninput="if(value.length>11)value=value.slice(0,11)">*
					<input type="number" placeholder="深" id="size_hig"  class="inp"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
				<th>重量(kg)</th>
				<td><input type="number" placeholder="请输入重量"  id="weight"class="popinput quinputcol"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
			</tr>
			<tr>	
				<th>输入电压(V)</th>
				<td><input type="number" placeholder="请输入输入电压"  id="inp_vol"class="popinput quinputcol"  oninput="if(value.length>11)value=value.slice(0,11)" ></td>
				<th>输入电流(A)</th>
				<td><input type="number" placeholder="请输入输入电流"  id="inp_elc"class="popinput quinputcol"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
			</tr>
			<tr>	
				<th>输出电压(V)</th>
				<td><input type="number" placeholder="请输入输出电压"  id="out_vol"class="popinput quinputcol"  oninput="if(value.length>11)value=value.slice(0,11)" ></td>
				<th>输出电流(A)</th>
				<td><input type="number" placeholder="请输入输出电流"  id="out_elc"  class="popinput quinputcol"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
			</tr>
			<tr>	
				<th>额定容量(kW)</th>
				<td><input type="number" placeholder="请输入额定容量"  id="rtd_pow"class="popinput quinputcol"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
				<th>工作温度(℃)</th>
				<td><input type="text" placeholder="请输入工作温度"  id="work_temp"class="popinput quinputcol" ></td>
			</tr>
			<tr>	
				<th>海拔(m)</th>
				<td><input type="text" placeholder="请输入海拔" id="altitude"class="popinput quinputcol " ></td>
				<th>防护等级</th>
				<td><input type="text" placeholder="请输入防护等级" id="prtc_grade"class="popinput quinputcol " ></td>
			</tr>
			<tr>	
				<th>残值率(%)</th>
				<td><input type="number" placeholder="请输入残值率" id="res_val"class="popinput quinputcol"   oninput="if(value.length>11)value=value.slice(0,11)"></td>
				<th>折旧年限(年) </th>
				<td><input type="number" placeholder="请输入折旧年限" id="dep_fix_num_year"class="popinput quinputcol"   oninput="if(value.length>11)value=value.slice(0,11)"></td>
			</tr>
			<tr>	
				<th>月折旧额(元)</th>
				<td><input type="number" placeholder="请输入月折旧额" id="mon_dep"class="popinput quinputcol"  oninput="if(value.length>11)value=value.slice(0,11)" ></td>
				<th>累计折旧额(元)</th>
				<td><input type="number" placeholder="请输入累计折旧额" id="acc_dep"class="popinput quinputcol"   oninput="if(value.length>11)value=value.slice(0,11)"></td>
			</tr>
			<tr>	
				<th>所在仓库</th>
				<td><select  id="war_id" placeholder="请选择所在仓库"  class="popinput requiredInp"></select></td>
			</tr>
			<tr>
			<th>备注</th> 
			<td colspan="3">
				<textarea    cols="3"  rows="3"  placeholder="请输入备注"  id="remark" name="remark"   class="poptextarea"></textarea>
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
	getMan();
	getType();
	getCk();
})
function getDefectTyp(){
	$.ajax({
		url:url+"getAssetsTypList.htm",
		data:"",
		dataType:"json",
		type:"post",
		success:function(data){
			if(data.resultcode=="USR000"){
				var htmls="";
				var pCheckT = window.parent.checkId ; 
				if(data.data.length>0){
					for(var i=0;i<data.data.length;i++){
						var d=data.data[i];
						if(pCheckT && pCheckT == d.id){
							 htmls +=  "<option value='"+d.id+"' selected >"+d.typ_nam+"</option>";
						}else{
							 htmls +=  "<option value='"+d.id+"'>"+d.typ_nam+"</option>";
						}
					}
				}
				$("#ass_typ_id").html(htmls);
			}else{
				layer.alert(data.desc);
			}
			
		}
	})
}



function getMan(){
 	$.ajax({
	    	url:url+"getManInfAll.htm",
	    	dataType:"json",
	    	async : false,
	    	type:"post",
	    	success:function(data1){
	    		if (data1.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data1.data.length > 0 ){
	    				 for(var i = 0; i< data1.data.length ; i++){
			    				var d =  data1.data[i];
			    				 htmls +=  "<option value='"+d.id+"'>"+d.man_nam+"</option>";
		    			 }
	    				 $("#man_id").html(htmls); 
	    			 } 
				} else {
	               layer.alert(data.desc);
				}
	    	}
    })
}

function getType(){
 	$.ajax({
	    	url:url+"getBasAppById.htm",
	    	dataType:"json",
	    	async : false,
	    	type:"post",
	    	success:function(data2){
	    		if (data2.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data2.data.length > 0 ){
	    				 for(var i = 0; i< data2.data.length ; i++){
			    				var d =  data2.data[i];
			    				 htmls +=  "<option value='"+d.id+"'>"+d.app_mod+"</option>";
		    			 }
	    				 $("#app_mod_id").html(htmls); 
	    			 } 
				} else {
	               layer.alert(data.desc);
				}
	    	}
    })
}


function getCk(){
	$.ajax({
		url:url+"getAllWareHouseName.htm",
		data:"",
		dataType:"json",
		type:"post",
		success:function(data){
			if(data.resultcode=="USR000"){
				var htmls="";
				if(data.data.length>0){
					 var htmls = "";
	    			 if(data.data.length > 0 ){
	    				 for(var i = 0; i< data.data.length ; i++){
			    				var d =  data.data[i];
			    				 htmls +=  "<option value='"+d.id+"'>"+d.ware_nam+"</option>";
		    			 }
	    				 $("#war_id").html(htmls); 
	    			 } 
				}
				$("#war_id").html(htmls);
			}else{
				layer.alert(data.desc);
			}
			
		}
	})
}

function insert(){
	var param="";
	var ass_nam = $("#ass_nam").val();
	var ass_typ_id = $("#ass_typ_id").val();
	var pro_tim = $("#pro_tim").val();
	var pur_tim = $("#pur_tim").val();
	var remark = $("#remark").val();
	var equ_sor = $("#equ_sor").val();
	var app_mod_id = $("#app_mod_id").val();
	var man_id = $("#man_id").val();
	var unit = $("#unit").val();
	var ass_num = $("#ass_num1").val();
	var price = $("#price").val();
	var sub_com_id=$("#sub_com_id").val();
	var size_lon = $("#size_lon").val();
	var size_wid = $("#size_wid").val();
	var size_hig = $("#size_hig").val();
	var weight = $("#weight").val();
	var inp_elc = $("#inp_elc").val();
	var inp_vol = $("#inp_vol").val();
	var rtd_pow = $("#rtd_pow").val();
	var out_elc = $("#out_elc").val();
	var out_vol = $("#out_vol").val();
	var work_temp = $("#work_temp").val();
	var altitude = $("#altitude").val();
	var prtc_grade = $("#prtc_grade").val();
	var res_val = $("#res_val").val();
	var dep_fix_num_year = $("#dep_fix_num_year").val();
	var mon_dep = $("#mon_dep").val();
	var acc_dep = $("#acc_dep").val();
	var war_id = $("#war_id").val();
	var crt_use_id = $("#crt_use_id").val();
	var cou = $("#cou").val();

	 var reFlag = false ; 
	 $(".requiredInp").each(function(){
	  		if($(this).val().trim() == "" || $(this).val() == undefined ){
	  			/* if($(this).attr("id") == "size_hig" ){
	 		 		if($(this).val() == ""){
	 		 		   reFlag = true;
					   layer.alert("请输入尺寸长宽高")
					   return false;
	 		 		}
	 		 	}else{ */
	 		 		 reFlag = true;
	 				 layer.alert($(this).attr("placeholder"))
	 				 return false;
	 		 	/* } */
		   	} 
	  		
	 }); 
	 if(reFlag){
		return false;
	}else{
		/*  if($("#size_lon").val() == "" || $("#size_wid").val() == "" || $("#size_hig").val() == ""){
			 layer.alert("请输入尺寸长宽高");
			 return false;
		 } */
	 } 
	 layer.confirm("确定保存？",function(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		 param += "&ass_nam="+ass_nam+"&ass_typ_id="+ass_typ_id+
		 "&pro_tim="+pro_tim+"&pur_tim="+pur_tim+"&ass_num="+ass_num+
		 "&remark="+remark+"&equ_sor="+equ_sor+"&app_mod_id="+app_mod_id+
		 "&man_id="+man_id+"&unit="+unit+"&price="+price+
		 "&size_lon="+size_lon+"&size_wid="+size_wid+"&size_hig="+size_hig+"&weight="+weight+"&inp_elc="+inp_elc+
		 "&inp_vol="+inp_vol+"&rtd_pow="+rtd_pow+"&out_elc="+out_elc+
		 "&out_vol="+out_vol+"&work_temp="+work_temp+"&altitude="+altitude+
		 "&prtc_grade="+prtc_grade+"&res_val="+res_val+"&dep_fix_num_year="+dep_fix_num_year+
		 "&mon_dep="+mon_dep+"&acc_dep="+acc_dep+"&war_id="+war_id+"&crt_use_id="+crt_use_id+"&sub_com_id="+sub_com_id+"&cou="+cou,
		 
		
		$.ajax({
	    	url:url+"insAssetsInfo.htm",
	    	data: param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer);  //关闭 loading 
	    		if (data.resultcode=="USR000") {
	    			window.parent.currentPage = 1 ;
	            	window.parent.getData(ass_typ_id);
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
