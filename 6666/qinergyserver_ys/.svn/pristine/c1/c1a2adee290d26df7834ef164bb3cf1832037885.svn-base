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
	<input type="hidden" id="ass_num" value="${ass_num }">
		<div class="pt18 fl " style="width: 100%">
		<div class=" tabxq ">
			<table cellpadding="0" cellspacing="0" border="0" width="100%"  >
				<tr>
					<th>资产类型</th>
					<td id="ass_typ_id"  > </td>
					<th>资产名称</th>
					<td id="ass_nam" ></td>
				</tr>
				<tr>	
					<th>设备型号</th>
					<td id="app_mod_id" > </td>
					<th>生产厂家</th>
					<td id="man_id" > </td>
				</tr>
				<tr>	
					<th>计量单位</th>
					<td id="unit"  ></td>
					<th>排序号</th>
					<td id="equ_sor" ></td>
				</tr>
				<tr>	
					<th>单价(元)</th>
					<td id="price" ></td>
					<th>出厂日期</th>
					<td id="pro_tim" ></td>
				</tr>
				<tr>	
					<th>购买日期</th>
					<td id="pur_tim" ></td>
					<th>长*宽*深(mm)</th>
					<td id="size"></td>
				</tr>
				<tr>	
					<th>重量(kg)</th>
					<td id="weight" ></td>
					<th>输入电压(V)</th>
					<td id="inp_vol" ></td>
				</tr>
				<tr>	
					<th>输入电流(A)</th>
					<td id="inp_elc"></td>
					<th>输出电压(V)</th>
					<td id="out_vol" ></td>
				</tr>
				<tr>	
					<th>输出电流(A)</th>
					<td id="out_elc" ></td>
					<th>额定容量(kW)</th>
					<td id="rtd_pow" ></td>
				</tr>
				<tr>	
					<th>工作温度(℃)</th>
					<td id="work_temp" ></td>
					<th>海拔(m)</th>
					<td id="altitude" ></td>
				</tr>
				<tr>	
					<th>防护等级</th>
					<td id="prtc_grade" ></td>
					<th>残值率(%)</th>
					<td id="res_val" ></td>
				</tr>
				<tr>	
					<th>折旧年限(年) </th>
					<td id="dep_fix_num_year" ></td>
					<th>月折旧额(元)</th>
					<td id="mon_dep" ></td>
				</tr>
				<tr>	
					<th>累计折旧额(元)</th>
					<td id="acc_dep" ></td>
					<th>所在仓库</th>
					<td id="war_id" ></td>
				</tr>
				<tr>	
					<th>备注</th> 
					<td id="remark"></td>
			</tr>
		</table>
	</div>
</div>
		
		
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/getText.js?pubVersion=201802070001"></script>
<script type="text/javascript">
$(function(){
	var mod_use_id=$("#mod_use_id").val();
	var ass_num = $("#ass_num").val();
	getData(ass_num);
})

function getDefectTyp(ass_typ_id){
	$.ajax({
		url:url+"getAssetsTypList.htm",
		dataType:"json",
		type:"post",
		success:function(data){
			if(data.resultcode=="USR000"){
				var html="";
				if(data.data.length>0){
					for(var i=0;i<data.data.length;i++){
						var d=data.data[i];
						var selHtml="";
						if(ass_typ_id==d.id){
							$("#ass_typ_id").html(d.typ_nam);
						}
					}
				}
				
			}else{
				layer.alert(data.desc);
			}
			
		}
	})
}

function getData(ass_num){
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	$.ajax({
		url:url+"getAssetsByAssNum.htm",
		type:"post",
		data:"ass_num="+ass_num,
		dataType:"json",
		success:function(data){
			if(data.resultcode=="USR000"){
				var d=data.data[0];
				$("#ass_nam").html(d.ass_nam);
				$("#pro_tim").html(d.pro_tim);
				$("#pur_tim").html(getLocalDateAndTime(d.pur_tim,2));
				$("#ass_num1").html(d.ass_num);
				$("#remark").html(d.remark);
				$("#equ_sor").html(d.equ_sor);
				$("#app_mod_id").html(d.app_mod_id);
				$("#man_id").html(d.man_id);
				$("#unit").html(d.unit);
				$("#price").html(d.price);
				$("#size").html(d.siz);
				$("#weight").html(d.weight);
				$("#inp_elc").html(d.inp_elc);
				$("#inp_vol").html(d.inp_vol);
				$("#rtd_pow").html(d.rtd_pow);
				$("#out_elc").html(d.out_elc);
				$("#out_vol").html(d.out_vol);
				$("#work_temp").html(d.work_temp);
				$("#altitude").html(d.altitude);
				$("#prtc_grade").html(d.prtc_grade);
				$("#res_html").html(d.res_html);
				$("#dep_fix_num_year").html(d.dep_fix_num_year);
				$("#mon_dep").html(d.mon_dep);
				$("#acc_dep").html(d.acc_dep);
				$("#res_val").html(d.res_val);
				$("#war_id").html(d.war_id);
				getDefectTyp(d.ass_typ_id);
				getMan(d.man_id);
				getType(d.app_mod_id);
				layer.close(indexlayer);
			}else{
				layer.close(indexlayer);
				layer.alert(data.desc);
			}
		}
	})
}

function getMan(id){
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
			    				if(d.id == id){
				    				 $("#man_id").html(d.man_nam); 
			    				}
		    			 }
	    			 } 
				} else {
	               layer.alert(data.desc);
				}
	    	}
    })
}

function getType(id){
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
			    				if(id == d.id){
				    				 $("#app_mod_id").html(d.app_mod); 
			    				}
		    			 }
	    			 } 
				} else {
	               layer.alert(data.desc);
				}
	    	}
    })
}
</script>		

</body>
</html>