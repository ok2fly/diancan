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
					<th>厂家名称</th>
					<td id="man_nam"  ></td>
					<th>厂家状态</th>
					<td id="man_sta" ></td>
				</tr>
				<tr>	
					<th>省级</th> 
					<td id="pro_id" > </td>
					<th>市级</th>
					<td id="cit_id"> </td>
				</tr>
				<tr>
					<th>区级</th> 
					<td id="are_id"> </td>	
					<th>厂家地址</th>
					<td id="man_add" > </td>
				</tr>
				<tr>
					<th>联系人</th>
					<td id="man_cot" ></td>
					<th>联系电话</th>
					<td id="man_mob" ></td>
				</tr>
				<tr>
					<th>备用电话</th>
					<td  id="man_spa" ></td>
					<th>厂家经度(°)</th>
					<td id="sta_lon" ></td>
				</tr>
				<tr>	
					<th>厂家纬度(°)</th>
					<td id="sta_lat" ></td>
					<th>备注</th>
					<td id="remark" > </td>
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
	var id = $("#id").val();
	getById(id);  
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
	    					 $("#man_cot").html(d.man_cot);
	    					 $("#man_mob").html(d.man_mob);
	    					 $("#man_spa").html(d.man_spa);
	    					 $("#man_nam").html(d.man_nam);
	    					 $("#man_add").html(d.man_add);
	    					 $("#remark").html(d.remark);
							 var man_sta=d.man_sta==1?"可用":d.man_sta==0?"不可用":"";
	    					 $("#man_sta").html(man_sta);
	    					 $("#sta_lon").html(d.sta_lon);
	    					 $("#sta_lat").html(d.sta_lat);
	    					 $("#use_nam").html(d.use_nam);
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
						 getQu(id,cityId,areaId);
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