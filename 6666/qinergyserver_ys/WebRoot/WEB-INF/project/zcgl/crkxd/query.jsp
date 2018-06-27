<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001" type="text/javascript"></script>
<script type="text/javascript">
	$(function () {
    	 getData(); 
	})
	
	function getData(){
		var  ord_num= $("#ord_num").val();
		$.ajax({
	    	url:url+"getAssetsListByOrdNum.htm",
	    	data : "ord_num="+ord_num,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data.data.length > 0 ){
	    				 for(var i=0;i<data.data.length;i++){
	    					 if(data.data.length>0){
	    						 var d=data.data[i];
				    					$("#ass_nam").val(d.ass_nam);
				    					$("#ass_num").val(d.ass_num);
				    					$("#remark").val(d.remark);
				    					$("#man_nam").val(d.man_nam);
				    					$("#app_mod").val(d.app_mod);
				    					$("#unit").val(d.unit);
				    					$("#price").val(d.price);
				    					$("#size").val(d.size);
				    					$("#weight").val(d.weight);
				    					$("#inp_elc").val(d.inp_elc);
				    					$("#inp_vol").val(d.inp_vol);
				    					$("#rtd_pow").val(d.rtd_pow);
				    					$("#out_elc").val(d.out_elc);
				    					$("#out_vol").val(d.out_vol);
				    					$("#work_temp").val(d.work_temp);
				    					$("#altitude").val(d.altitude);
				    					$("#prtc_grade").val(d.prtc_grade);
				    					$("#res_val").val(d.res_val);
				    					$("#dep_fix_num_year").val(d.dep_fix_num_year);
				    					$("#mon_dep").val(d.mon_dep);
				    					$("#acc_dep").val(d.acc_dep);
				    					$("#is_scrap").val(d.is_scrap);
				    					$("#ware_nam").val(d.ware_nam);
				    					$("#cur_sta").val(d.cur_sta);
				    					$("#ord_num").val(d.ord_num);
 						 	} else{
	 	    					htmls +=  "<tr><td colspan='5'>暂无数据</td></tr>";
    	    			 	}
    				   }	
	    			 }
	    			}else {
	            	   layer.alert(data.desc);
					}
	    			$("#filedatalist").html(htmls); 
	    	}
	    })
	}
	
	 
	</script>
</head>
<body>
	<!-- viewFramework   -->
	<div class="pt18" style="height:800px;">
			<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
					<tr>
						<th>资产名称</th>
						<td><input type="text" id="ass_nam" class="popinput quinputcol" readonly="readonly"></td>
						<th>资产编号</th>
						<td><input type="text" id="ass_num" class="popinput quinputcol" readonly="readonly"></td>
					</tr>
					<tr>	
						<th>备注 </th>
						<td><input type="text" id="remark" class="popinput quinputcol" readonly="readonly"></td>
						<th>设备型号</th>
						<td><input type="text" id="app_mod" class="popinput quinputcol" readonly="readonly"></td>
					</tr>
					<tr>	
						<th>生产厂家</th>
						<td><input type="text" id="man_nam" class="popinput quinputcol" readonly="readonly"></td>
						<th>计量单位  </th>
						<td><input type="text" id="unit" class="popinput quinputcol" readonly="readonly"></td>
					</tr>
					<tr>		
						<th>价格</th>
						<td><input type="text" id="price" class="popinput quinputcol" readonly="readonly"></td>
						<th>尺寸</th>
						<td><input type="text" id="size" class="popinput quinputcol" readonly="readonly"></td>
					</tr>
					<tr>		
						<th>重量</th>
						<td><input type="text" id="weight" class="popinput quinputcol" readonly="readonly"></td>
						<th>输入电流</th>
						<td><input type="text" id="inp_elc" class="popinput quinputcol" readonly="readonly"></td>
					</tr>
					<tr>		
						<th>输入电压</th>
						<td><input type="text" id="inp_vol" class="popinput quinputcol" readonly="readonly"></td>
						<th>额定容量</th>
						<td><input type="text" id=rtd_pow class="popinput quinputcol" readonly="readonly"></td>
					</tr>
					<tr>		
						<th>输出电流</th>
						<td><input type="text" id="out_elc" class="popinput quinputcol" readonly="readonly"></td>
						<th>输出电压</th>
						<td><input type="text" id="out_vol" class="popinput quinputcol" readonly="readonly"></td>
					</tr>
					<tr>		
						<th>工作温度</th>
						<td><input type="text" id="work_temp" class="popinput quinputcol" readonly="readonly"></td>
						<th>海拔</th>
						<td><input type="text" id="altitude" class="popinput quinputcol" readonly="readonly"></td>
					</tr>
					<tr>		
						<th>防护等级</th>
						<td><input type="text" id="prtc_grade" class="popinput quinputcol" readonly="readonly"></td>
						<th>残值率</th>
						<td><input type="text" id="res_val" class="popinput quinputcol" readonly="readonly"></td>
					</tr>
					<tr>		
						<th>折旧年限</th>
						<td><input type="text" id="dep_fix_num_year" class="popinput quinputcol" readonly="readonly"></td>
						<th>月折旧额</th>
						<td><input type="text" id="mon_dep" class="popinput quinputcol" readonly="readonly"></td>
					</tr>
					<tr>		
						<th>累计折旧额</th>
						<td><input type="text" id="acc_dep" class="popinput quinputcol" readonly="readonly"></td>
						<th>是否报废</th>
						<td><input type="text" id="is_scrap" class="popinput quinputcol" readonly="readonly"></td>
					</tr>
					<tr>		
						<th>所在仓库</th>
						<td><input type="text" id="ware_nam" class="popinput quinputcol" readonly="readonly"></td>
						<th>资产状态状态</th>
						<td><input type="text" id="cur_sta" class="popinput quinputcol" readonly="readonly"></td>
					</tr>
					<tr>		
						<th>出入库单号</th>
						<td><input type="text" id="ord_num" class="popinput quinputcol" readonly="readonly"></td>
					</tr>
					</table>
	</div>
	<!-- ./ viewFramework -->
</body>
</html>

