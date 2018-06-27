<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<tr>
<th>备注</th>
<td colspan="3">

<tr>
				<th>备注</th> 
				<td colspan="3"><input type="text" placeholder="请输入备注" style="width: 96%;" class="popinput quinputcol t_th_ts_span18"></td>
			</tr>
requiredInp


placeholder="请选择告警等级" 
placeholder="请输入厂家类型名称"


<input  style="width:96%;" ></td>
</tr>
<script type="text/javascript">

//必填项的校验 
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

 
 var discardPageData ;
	var countAll = 0;
	var currentPage  = 1;
	var everyPageCount = 10 ;
	function getDiscard(){
		var param  = "";
		var pws_id = $("#companyPws").val();
		if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
			param  += "pws_id="+pws_id;
		}else{
			layer.alert("请选择电站");
			return;
		}
		
		var qglTime = $("#qglTime").val(); 
		if(qglTime != '' && qglTime != undefined){
			param += "&tim_type="+2+"&tim_point="+qglTime;
		}else{
			layer.alert("请选择时间");
			return;
		}
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
			data:param,
			url:url+"getDiscardRate.htm",
			type:"post",
			dataType:"json",
				success:function(data){
					layer.close(indexlayer);  //关闭 loading 
		    		if (data.resultcode=="USR000") {
		    			 if(data.data.length> 0){
		    				 discardPageData = data.data;
		    				 $("#list-qgl").empty();
		    				 var htm = "";
		    				 for(var i = 0 ; i < data.data.length ; i++){
	    						 var lst = data.data[i];
	    						  if(i < (currentPage*everyPageCount)){
			    					 htm += "<tr>"+
	 						 		"<td>"+lst.tol_tim +"</td>"+
	 						 		"<td>"+getFixedNum5(lst.plan_power) +"</td>"+
	 						 		"<td>"+getFixedNum5(lst.mai_dis_power)+"</td>"+
	 						 		"<td>"+getFixedNum5(lst.fal_dis_power)+"</td>"+
	 						 		"<td>"+getFixedNum5(lst.rat_dis_power) +"</td>"+
	 						 		"<td>"+getFixedNum5(lst.dis_rate)+"</td>"+
	 						 		"<td>"+getFixedNum5(lst.mai_dis_rate)+"</td>"+
	 						 		"<td>"+getFixedNum5(lst.fal_dis_rate)+"</td>"+
	 						 		"<td>"+getFixedNum5(lst.rat_dis_rate)+"</td>"+
	 						 		"</tr>";
	    						  }
	    					 }
		    				 $("#list-qgl").html(htm);
		    				 discardPageData = data.data;
		    				  //算出总页数
		    				  countAll = 0 ;
	    					  if(discardPageData.length/everyPageCount > parseInt(discardPageData.length/everyPageCount)){   
	    						  countAll=parseInt(discardPageData.length/everyPageCount)+1;   
	    				      }else{   
	    				    	  countAll=parseInt(discardPageData.length/everyPageCount);   
	    				       };
		    				  //countAll = data.totalPage;
		    				  $("#tcdPageCode1").createPage({
		 				        pageCount:countAll,
		 				        current:currentPage,
		 				        backFn:function(p){
		 				        	currentPage = p;
		 				        	getPagedData();
		 				        }
		 			    	});
		    			 }
	    				setChart5(data.data);
					} else {
		               layer.alert(data.desc);
					}
		    	}
		})
	}
	function getPagedData(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		 $("#list-qgl").empty();
		 var htm = "";
		 var max = 0 ;
		 if ( (currentPage*everyPageCount) >  discardPageData.length-1 ){
			 max = discardPageData.length; 
		 }else{
			 max = (currentPage*everyPageCount) ;
		 }
		 for(var i=((currentPage-1)*everyPageCount);i<max;i++){
			 var lst = discardPageData[i];
			 
			 htm += "<tr>"+
		 		"<td>"+lst.tol_tim +"</td>"+
		 		"<td>"+getFixedNum5(lst.plan_power) +"</td>"+
		 		"<td>"+getFixedNum5(lst.mai_dis_power)+"</td>"+
		 		"<td>"+getFixedNum5(lst.fal_dis_power)+"</td>"+
		 		"<td>"+getFixedNum5(lst.rat_dis_power) +"</td>"+
		 		"<td>"+getFixedNum5(lst.dis_rate)+"</td>"+
		 		"<td>"+getFixedNum5(lst.mai_dis_rate)+"</td>"+
		 		"<td>"+getFixedNum5(lst.fal_dis_rate)+"</td>"+
		 		"<td>"+getFixedNum5(lst.rat_dis_rate)+"</td>"+
		 		"</tr>";
		 }
		 $("#list-qgl").html(htm);
		 layer.close(indexlayer);  //关闭 loading 
	}
 
	<div class="tcdPageCode" id="tcdPageCode1">
 
 
 
 
 
 
 
</script>
</body>
</html>