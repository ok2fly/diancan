<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>   
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
<title>采购计划</title>
<link rel="stylesheet" type="text/css"	href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css"	href="<%=basePath%>css/common.css?pubVersion=201802070001">
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001" type="text/javascript"></script>
<script type="text/javascript">
	$(function () {
    	 getData(); 
	})
	
	function getData(){
		var  id= $("#id").val();
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
	    	url:url+"getAssetsPurPlanList.htm",
	    	data : "",
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		layer.close(indexlayer);
	    		if (data.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data.data.length > 0 ){
	    				 for(var i=0;i<data.data.length;i++){
	    					 var d=data.data[i];
	    					 if(d.id==id){
	    						 if(d.fileList.length>0){
	    							 for(var a=0;a<d.fileList.length;a++){
	 			    					var t=d.fileList[a];
	 			    					var fil_typ=t.fil_typ==1?"文件":t.fil_typ==2?"图片":"无";
	 			    					htmls += "<tr>"+
	 					              	"<td>"+(a+1)+"</td>"+
	 					              	"<td>"+getIsNull(t.fil_nam)+"</td>"+
	 					              	"<td>"+getIsNull(t.fil_url)+"</td>"+
	 					              	"<td>"+getIsNull(fil_typ)+"</td>"+
	 					              	"<td>"+getIsNull(t.remark)+"</td>"+
	 					              	"<td><a onclick='downFile("+t.id+")'   href='javascript:void(0);' >下载 </a>"+
	 					              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  href='javascript:void(0);' onclick='del("+t.id+")'>删除</a></td>"+ 
	 					              	"</tr>";
	    						 }
	    					 }else{
	 	    					htmls +=  "<tr><td colspan='5'>暂无数据</td></tr>";
	    	    			 }
	    				 }

	    			 }
				} 
	    	$("#filedatalist").html(htmls); 
	    	
	    	}else {
	               layer.alert(data.desc);
			}
	    	}
	    })
	}
	
	function downFile(id){
		
		var layerC = layer.confirm("确定下载？",function(){
			$.ajax({
				url : url+"downloadPurPlan.htm?id="+id,
				dataType : "json",
				type : "post",
				success : function(data) {
					if (data.resultcode && data.resultcode != "USR000") {
						layer.alert(data.desc);
						return ;
					} else {
						location.href = url+"KnowXiaZai.htm?path="+data.data.path+"&file_name="+data.data.file_name ;
						layer.close(layerC);
					}
					
				},
				error : function(){
					layer.alert("下载请求失败");
					layer.close(layerC);
				}
			})  
			
		})
		
	}
	function del(id){
		layer.confirm("确定删除？",function(){
			var use_id=$("#use_id").val();
			$.ajax({
		    	url:url+"delPurPlanFile.htm",
		    	data : "id="+id+"&use_id="+use_id,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		   	    		layer.alert("删除成功");
		   	    		getData();
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
	    })
	}
	 
	</script>
</head>
<body> 
 <!-- viewFramework   -->
  <div class=viewFramework> 
 		  <input type="hidden" id="id" value="${id}" >
 		  <input type="hidden" id="use_id" value="${user.id}" >
		  <div  class="mt15 pl8 pr8 pb18 bg-ff pt10">
			<div class="clr wauto">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-list">
		            <tr>
		              <th>序号</th>
		              <th>文件名</th>
		              <th>文件路径</th>
		              <th>文件类型</th>
		              <th>备注</th>
		              <th>操作</th>
		            </tr>
		            <tbody id="filedatalist"></tbody>
		         </table>
	        </div>
          </div>
	  </div>
   <!-- ./ viewFramework --> 
</body>
</html>
 
