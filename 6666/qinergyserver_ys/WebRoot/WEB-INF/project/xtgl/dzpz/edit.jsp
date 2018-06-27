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
<title>电站配置</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/pop.css?pubVersion=201802070001">
</head>

<body >
<div class="pt18">
	<input type="hidden" id="id" value="${id }">
	<input type="hidden" id="use_id" value="${user.id}">
	<table cellpadding="0" cellspacing="0" border="0" width="100%" class="poptable">
		<tr>
			<th>电站名称</th>
			<td><input type="text" placeholder="请输入电站名称" class="popinput quinputcol t_th_ts_span1 requiredInp"></td>
			<th>电站类型</th>
			<td>
			<select class="popinput quinputcol t_th_ts_span2 requiredInp">
			 
			</select>
			</td>
		</tr>
		<tr>
			<th>运维类型</th>
			<td>
			<select class="popinput quinputcol t_th_ts_span3 requiredInp"  onchange="getOptCom(this.value)">
				<option  value="1">独立运维</option>
				<option  value="2">统一运维</option>
			</select>
			</td>
			<th>当前状态</th> 
			<td><select class="popinput quinputcol t_th_ts_span4 requiredInp" >
				<option  value="1">计划</option>
				<option  value="2">在建</option>
				<option  value="3">投运</option>
			</select></td>
		</tr>
		<tr>
			<th>运维公司</th>
			<td>
			<select class="popinput quinputcol t_th_ts_span13 requiredInp">
	  		</select>
	  		</td>
			<th>运维负责人</th>
			<td><input type="text" placeholder="请输入运维负责人" class="popinput quinputcol t_th_ts_span26 requiredInp"></td>
		</tr>
		<tr>
			<th>省级</th> 
			<td>
			 <select class="popinput quinputcol  t_th_ts_span5 requiredInp" id="pro_id"  placeholder="请选择省" onchange="getShi(this.value)">	 
			 <option value="0">--请选择--</option>   
			 </select>
			</td>
			<th>市级</th>
			<td>
			<select class="popinput quinputcol t_th_ts_span6 requiredInp" id="cit_id"  placeholder="请选择市"   onchange="getQu(0,this.value)">	   
			  <option value="0">--请选择--</option> 
			  </select></td>
		</tr>
		<tr>
			<th>区级</th> 
			<td>
			 <select class="popinput quinputcol t_th_ts_span7 requiredInp" id="are_id"  placeholder="请选择区" >	
		      <option value="0">--请选择--</option>    
			  </select>
			</td>
			<th>所属公司</th>
			<td>
			<select class="popinput quinputcol t_th_ts_span18 requiredInp">
	  		</select>
			</td>
		</tr>
		<tr>
			<th>地址</th>
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入地址"    onfocus="" class="poptextarea t_th_ts_span12 requiredInp"></textarea>
			</td>
		</tr>
		<tr>
			<th>经度(°)</th>
			<td><input type="number" placeholder="请输入经度" class="popinput quinputcol t_th_ts_span14 requiredInp"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
			<th>纬度(°)</th> 
			<td><input type="number" placeholder="请输入纬度" class="popinput quinputcol t_th_ts_span15 requiredInp"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
		</tr>
		<tr>
			<th>电站编号</th>
			<td><input type="text" placeholder="请输入电站编号" class="popinput t_th_ts_span20 quinputcol requiredInp"></td>
			<th>排序号</th> 
			<td><input type="number" placeholder="请输入排序号" class="popinput t_th_ts_span19 quinputcol requiredInp"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
		</tr>
		<tr>
			<th>电站容量(kW)</th> 
			<td><input type="number" placeholder="请输入额定功率" class="popinput t_th_ts_span21 quinputcol requiredInp"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
			<th>光伏容量(kW)</th>
			<td><input type="number" placeholder="请输入光伏容量" class="popinput t_th_ts_span22 quinputcol requiredInp"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
		</tr>
		<tr>
			<th>储能功率(kW)</th> 
			<td><input type="number" placeholder="请输入储能功率" class="popinput t_th_ts_span23 quinputcol requiredInp"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
			<th>储能容量(AH)</th>
			<td><input type="number" placeholder="请输入储能容量" class="popinput t_th_ts_span24 quinputcol requiredInp"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
		</tr>
		<tr>
			<th>充电容量(kW)</th> 
			<td><input type="number" placeholder="请输入充电容量" class="popinput t_th_ts_span25 quinputcol requiredInp"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
		</tr>
		<tr>
			<th>联系人</th>
			<td><input type="text" placeholder="请输入联系人" class="popinput quinputcol t_th_ts_span8"></td>
			<th>联系电话</th> 
			<td><input type="text" placeholder="请输入联系电话" class="popinput quinputcol t_th_ts_span9" onkeyup="value=value.replace(/[^\d]/g,'') "  maxlength="11"></td>
		</tr>
		<tr>
			<th>投运时间</th>
			<td><input type="text" placeholder="请输入投运时间" class="popinput Wdate quinputcol t_th_ts_span10 "  onFocus="WdatePicker()"></td>
			<th>占地面积(㎡)</th> 
			<td><input type="number" placeholder="请输入占地面积" class="popinput quinputcol t_th_ts_span11"  oninput="if(value.length>11)value=value.slice(0,11)"></td>
		</tr>
		<tr>
			<th>业主名称</th>
			<td><input type="text" placeholder="请输入业主名称" class="popinput quinputcol t_th_ts_span16"></td>
			
		</tr>
		
		<tr>
			<th>备注</th> 
			<td colspan="3">
			<textarea    cols="3"  rows="3" placeholder="请输入备注" id="remark"   onfocus="" class="poptextarea t_th_ts_span17"></textarea>
			</td>

		</tr>
	</table>
	<div class="tc popbutbox">
		<button class="popbut cancle"  >取消</button>
		<button class="popbut" onclick="return update();" >确定</button>
	</div>
</div>
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
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
					 $(".t_th_ts_span1").val(d.pws_nam);
					 getPwsType(d.pws_typ);
					 $(".t_th_ts_span3").val(d.ope_typ);
					 $(".t_th_ts_span4").val(d.cur_sta);
					 getSheng(d.pro_id,d.cit_id,d.are_id);
					 $(".t_th_ts_span8").val(d.con_nam);
					 $(".t_th_ts_span9").val(d.con_mob);
					 $(".t_th_ts_span10").val(getLocalDateAndTime(d.ope_tim,2));
					 $(".t_th_ts_span11").val(d.are_cov);
					 $(".t_th_ts_span12").val(d.pws_add);
					 optComId = d.org_nam;
					 optComName = d.opt_com_nam;
					 //$(".t_th_ts_span13").html("<option value='"+d.org_nam+"'>"+d.opt_com_nam+"</option>");
					 $(".t_th_ts_span14").val(d.pws_lon);
					 $(".t_th_ts_span15").val(d.pws_lat);
					 $(".t_th_ts_span16").val(d.own_nam);
					 $(".t_th_ts_span17").val(d.rem);
					 comId = d.com_id;
					 $(".t_th_ts_span18").html("<option value='"+d.com_id+"'>"+d.com_nam+"</option>");
					 $(".t_th_ts_span19").val(d.pws_sor);
					 $(".t_th_ts_span20").val(d.pws_num);
					 $(".t_th_ts_span21").val(d.rat_pow);
					 $(".t_th_ts_span22").val(getIsZero(d.pv_rtd_pow));
					 $(".t_th_ts_span23").val(getIsZero(d.pc_rtd_pow));
					 $(".t_th_ts_span24").val(getIsZero(d.pc_cap));
					 $(".t_th_ts_span25").val(getIsZero(d.chp_rtd_pow));
					 $(".t_th_ts_span26").val(d.dev_add_num);
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
							html += "<option value='"+reg.id+"' selected >"+reg.typ_nam+"</option>";
						}else{
							html += "<option value='"+reg.id+"' >"+reg.typ_nam+"</option>";
						}
					})
					$(".t_th_ts_span2").html(html);
				}else{
					layer.alert(data.desc);
				}
			}
		});
 }
	function getOptCom(value){
	  
	 $.ajax({                
			type : "post",
			url: url + "getAllComNam.htm",
			success: function(data){                          
				if('USR000' == data.resultcode){
					 var html="";
					$.each(data.data,function(index,reg){
						if(value  == 1) {
							if(optComId  == reg.id) {
								html += "<option value='"+reg.id+"' >"+reg.com_nam+"</option>";
							} 
						}else{
							html += "<option value='"+reg.id+"' >"+reg.com_nam+"</option>";
						}
					})
					$(".t_th_ts_span13").html(html);
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
					 var html="";
					$.each(data.data,function(index,reg){
						if(value  == 1) {
							if(optComId  == reg.id) {
								html += "<option value='"+reg.id+"' >"+reg.com_nam+"</option>";
							} 
						}else{
							if(optComName && optComName  == reg.com_nam) {
								html += "<option value='"+reg.id+"' selected >"+reg.com_nam+"</option>";
							}else{
								html += "<option value='"+reg.id+"' >"+reg.com_nam+"</option>";
							}
						}
					})
					$(".t_th_ts_span13").html(html);
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
						 getQu(reg_ide,cityId,areaId);
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
	var use_id=$("#use_id").val();
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
	   var datas=[];
	   var data="";
	   var data3s=""	  
	   
	   datas1=["pws_nam","pws_typ","ope_typ","cur_sta","pro_id",
               "cit_id","are_id","con_nam","con_mob",
               "ope_tim","are_cov","pws_add","org_nam","pws_lon",
               "pws_lat","own_nam","rem","com_id",
               "pws_sor","pws_num","rat_pow",
              "pv_rtd_pow","pc_rtd_pow","pc_cap","chp_rtd_pow","dev_add_num"];
	   
	 
	    for (var i = 0; i < datas1.length; i++) {
			 datas[i]=$(".t_th_ts_span"+(i+1)).val().trim();	  
		 	 data+=(datas1[i]+"="+datas[i]+"&");
	    }   
	    data += "pws_id="+id+"&&";
	    data=data.substring(0,data.length-1);
	    
	    layer.confirm("是否修改？",function(){
	    	var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
		   $.ajax({
		       url:url+"updatePwsInfo.htm",
		       data:data+"&use_id="+use_id,
		       dataType:"json",
		       type:"post",
		       success:function(data){
		    	   layer.close(indexlayer);
		    	   if(data.resultcode=="USR000"){
		    		   window.parent.getData();
		    		   $(".cancle").click();
		    		  window.parent.layer.msg("修改成功！");	
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
