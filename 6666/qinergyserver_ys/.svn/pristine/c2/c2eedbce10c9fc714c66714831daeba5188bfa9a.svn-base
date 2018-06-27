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
					<th>电站名称</th>
					<td class="t_th_ts_span1"></td>
					<th>电站类型</th>
					<td class="t_th_ts_span2"></td>
				</tr>
				<tr>
					<th>运维类型</th>
					<td class="t_th_ts_span3"  onchange="getOptCom(this.value)">
						
					</td>
					<th>当前状态</th> 
					<td class="t_th_ts_span4" ></td>
					
				</tr>
				<tr>
					<th>运维公司</th>
					<td class="t_th_ts_span13"></td>
					<th>运维负责人</th>
					<td class="t_th_ts_span26"></td>
				</tr>
				<tr>
					<th>省级</th> 
					<td class=" t_th_ts_span5  " id="pro_id"></td>
					<th>市级</th>
					<td class="t_th_ts_span6" id="cit_id"></td>
				</tr>
				<tr>
					<th>区级</th> 
					<td class="t_th_ts_span7" id="are_id"  ></td>
					<th>所属公司</th>
					<td class="t_th_ts_span18 "></td>
				</tr>
				<tr>
					<th>地址</th>
					<td class="t_th_ts_span12"></td>
					<th>经度(°)</th>
					<td class=" t_th_ts_span14"></td>
				</tr>
				<tr>
					<th>纬度(°)</th> 
					<td class=" t_th_ts_span15 "></td>
					<th>电站编号</th>
					<td class=" t_th_ts_span20"></td>
				</tr>
				<tr>
					<th>排序号</th> 
					<td class=" t_th_ts_span19"></td>
					<th>电站容量(kW)</th> 
					<td class=" t_th_ts_span21 "></td>
				</tr>
				<tr>
					<th>光伏容量(kW)</th>
					<td class=" t_th_ts_span22 "></td>
					<th>储能功率(kW)</th> 
					<td class=" t_th_ts_span23 "></td>
				</tr>
				<tr>
					<th>储能容量(AH)</th>
					<td class=" t_th_ts_span24 "></td>
					<th>充电容量(AH)</th> 
					<td class=" t_th_ts_span25"></td>
				</tr>
				<tr>
					<th>联系人</th>
					<td class=" t_th_ts_span8"></td>
					<th>联系电话</th> 
					<td class="t_th_ts_span9"></td>
				</tr>
				<tr>
					<th>投运时间</th>
					<td class=" t_th_ts_span10 "></td>
					<th>占地面积(㎡)</th> 
					<td class=" t_th_ts_span11"></td>
				</tr>
				<tr>
					<th>业主名称</th>
					<td class=" t_th_ts_span16"></td>
					<th>备注</th> 
					<td id="remark" class="t_th_ts_span17"></td>
				</tr>
				</table>
			</div>
		</div>
		
		
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/getText.js?pubVersion=201802070001"></script>
<script type="text/javascript">
var datas1=[];
var id = $("#id").val();
var comId = "";
var optComId = "";
var optComName = "";
$(function(){
	 var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	 $.ajax({                
		type : "post",
		url: url + "getPwsInfLstByPwsId.htm",
		data : "pws_id="+id,
		success: function(data){                          
			if('USR000' == data.resultcode){
				 layer.close(indexlayer);  //关闭 loading 
				 if(data.data.length > 0){
					 var d = data.data[0];
					 $(".t_th_ts_span1").html(d.pws_nam);
					 getPwsType(d.pws_typ);
					 var ope_typ=d.ope_typ==1?"独立运维":d.ope_typ==2?"统一运维":"";
					 $(".t_th_ts_span3").html(ope_typ);
					 var cur_sta=d.cur_sta==1?"计划":d.cur_sta==2?"在建":d.cur_sta==3?"投运":"";
					 $(".t_th_ts_span4").html(cur_sta);
					 getSheng(d.pro_id,d.cit_id,d.are_id);
					 $(".t_th_ts_span8").html(d.con_nam);
					 $(".t_th_ts_span9").html(d.con_mob);
					 $(".t_th_ts_span10").html(getLocalDateAndTime(d.ope_tim,2));
					 $(".t_th_ts_span11").html(d.are_cov);
					 $(".t_th_ts_span12").html(d.pws_add);
					 optComId = d.org_nam;
					 optComName = d.opt_com_nam;
					 //$(".t_th_ts_span13").html("<option value='"+d.org_nam+"'>"+d.opt_com_nam+"</option>");
					 $(".t_th_ts_span14").html(d.pws_lon);
					 $(".t_th_ts_span15").html(d.pws_lat);
					 $(".t_th_ts_span16").html(d.own_nam);
					 $(".t_th_ts_span17").html(d.rem);
					 comId = d.com_id;
					 $(".t_th_ts_span18").html(d.com_nam);
					 $(".t_th_ts_span19").html(d.pws_sor);
					 $(".t_th_ts_span20").html(d.pws_num);
					 $(".t_th_ts_span21").html(d.rat_pow);
					 $(".t_th_ts_span22").html(getIsZero(d.pv_rtd_pow));
					 $(".t_th_ts_span23").html(getIsZero(d.pc_rtd_pow));
					 $(".t_th_ts_span24").html(getIsZero(d.pc_cap));
					 $(".t_th_ts_span25").html(getIsZero(d.chp_rtd_pow));
					 $(".t_th_ts_span26").html(d.dev_add_num);
					 getOptComHx(d.ope_typ);
				 }
			}else{
				layer.alert('数据解析错误');
			}
		}
	});
})

function getPwsType(id){
	 $.ajax({                
			type : "post",
			url: url + "getBasPwsTypLst.htm",
			success: function(data){                          
				if('USR000' == data.resultcode){
					 var html="";
					$.each(data.data,function(index,reg){
						if(id == reg.id){
							$(".t_th_ts_span2").html(reg.typ_nam);
						}
					})
				}else{
					layer.alert(data.desc);
				}
			}
		});
}
function getOptComHx(value){
 $.ajax({                
		type : "post",
		url: url + "getAllComNam.htm",
		success: function(data){                          
			if('USR000' == data.resultcode){
				for(var i=0;i<data.data.length;i++){
					var reg=data.data[i];
					
					if(value  == 1) {
						if(optComId  == reg.id) {
							$(".t_th_ts_span13").html(reg.com_nam);
						} 
					}else{
						if(optComName && optComName  == reg.com_nam) {
							$(".t_th_ts_span13").html(reg.com_nam);
						} 
					}
					
				}
			}else{
				layer.alert(data.desc);
			}
		}
	});
} 
	
function getSheng(id,cityId,areaId){
	 $.ajax({                
			type : "post",
			url: url + "getBasRegLst1LevAll.htm",
			success: function(data){                          
				if('USR000' == data.resultcode){
					$.each(data.data,function(index,reg){
						if(id == reg.id){
							$("#pro_id").html(reg.reg_nam);
							getShi(id,cityId,areaId);
						}
					})
				}else{
					layer.alert('数据解析错误');
				}
			}
		});
		 
}
function getShi(reg_ide,cityId,areaId){
	$.ajax({                
		type : "post",
		url: url + "getBasRegInfByFatIdNotPage.htm",
		data : "id="+reg_ide ,
		success: function(data){                          
			if('USR000' == data.resultcode){
				$.each(data.data,function(index,reg){
					if(cityId == reg.id){
						$("#cit_id").html(reg.reg_nam);
						 getQu(reg_ide,cityId,areaId);
					}
				})
			}else{
				layer.alert('数据解析错误');
			}
		}
	});
}

function getQu(id,reg_ide,areaId){
	$.ajax({                
		type : "post",
		url: url + "getBasRegInfByFatIdNotPage.htm",
		data : "id="+reg_ide ,
		success: function(data){                          
			if('USR000' == data.resultcode){
				$.each(data.data,function(index,reg){
					if(areaId == reg.id){
						$("#are_id").html(reg.reg_nam);
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