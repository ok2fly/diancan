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
<title>知识库查看</title>
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
	    	url:url+"fileInfoByKnw.htm",
	    	data : "id="+id,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data.data.length > 0 ){
	    				 for(var i = 0; i< data.data.length ; i++){
			    				var d =  data.data[i];
			    				htmls += "<tr>"+
					              	"<td>"+getIsNull(d.fil_nam)+"</td>"+
					              	"<td>"+getIsNull(d.use_nam)+"</td>"+
					              	"<td>"+getLocalDateAndTime(d.crt_tim,1)+"</td>"+
					              	"<td>"+getIsNull(d.remark)+"</td>"+
					              	"<td><a onclick='downFile("+d.id+")'   href='javascript:void(0);' >下载 </a>"+
					              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  href='javascript:void(0);' onclick='del("+d.id+")'>删除</a></td>"+
					              	"</tr>";
		    			 }
	    			 }else{
	    					htmls +=  "<tr><td colspan='5'>暂无数据</td></tr>";
	    			 }
	    			
	   	    		$("#filedatalist").html(htmls); 
	   	    		layer.close(indexlayer);
				} else {
					layer.close(indexlayer);
	               layer.alert(data.desc);
				}
	    	}
	    })
	}
	
	function downFile(id){
		var layerC = layer.confirm("确定下载？",function(){
			$.ajax({
				url : url+"knwDownload.htm?id="+id,
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
			$.ajax({
		    	url:url+"removeKnwFile.htm",
		    	data : "id="+id,
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
		  <div  class="mt15 pl8 pr8 pb18 bg-ff pt10">
			<div class="clr wauto">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-list">
		            <tr>
		              <th>文件名称</th>
		              <th>创建人名称</th>
		              <th>创建时间</th>
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
 
