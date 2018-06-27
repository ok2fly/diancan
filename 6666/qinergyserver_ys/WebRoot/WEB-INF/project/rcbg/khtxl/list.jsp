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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/common.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/rcbg.css?pubVersion=201802070001">
<link rel="stylesheet" href="<%=basePath%>/js/jquery-treeview/jquery.treeview.css?pubVersion=201802070001" />
	
</head>
<body>
	<input type="hidden" value="${user.id}" id="userId" >
	  <input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  <input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
	<div class="rc-body">
		<div class="rc-left">
			<ul id="navigation" class="filetree"></ul>
		</div>
		<div class="rc-right" >
			<div class="bg-ff pb18 pl15 pt10 clr pl8">
				<div class="query">
					<div class="fl">
						<input type="text" value="" id="use_nam"  placeholder="请输入姓名" class="fl quinput ml15">
						<input type="text" value="" id="use_mob"  placeholder="请输入手机号" class="fl quinput ml15">
						<input type="button" value="查询" class="querybut">
					</div>
				</div>
			</div>
			<div class="mt15 pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="table-list">
						<tr>
							<th>序号</th>
							<th>姓名</th>
							<th>性别</th>
							<th>职位名称</th>
							<th>手机号码</th>
							<th>邮箱</th>
							<th>通讯地址</th>
						</tr>
						 <tbody id="datalist">
						 	<tr><td colspan="9">暂无数据</td></tr>
					 	</tbody>
					</table>
				</div>
				<div class="tcdPageCode" id="tcdPageCode1"></div> 
			</div>
			<div class="blank0"></div>
		</div>
	</div>
	<!-- ./ viewFramework -->
	<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
	<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
	<script src="<%=basePath%>js/jquery-treeview/jquery.treeview.js?pubVersion=201802070001" type="text/javascript"></script>
	<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
	

	<script type="text/javascript">
	var userId = $("#userId").val();
	var checkComId = "";
	$(function () {
		getCom();
		
		$(".querybut").click(function(){
			getData();
		})
	});
	
	/* function getCom(){ */
		/* $.ajax({
	    	url:url+"getCustomerAddressBook.htm",
	    	dataType:"json",
	    	data : "use_id="+userId,
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 var html = "";
	    			 if(data.data.length > 0 ){
	    				 html += "<li>";
	    				 $.each(data.data,function(index,org){
	    					var isFolder = "file";
	    					if(org.towComLst.length > 0){
	    						isFolder = "folder";
	    					}
	    					html += "<span  class='"+isFolder+"' onclick='setCheckData("+org.id+")'>"+org.com_nam+"</span>";
	    					if(org.towComLst.length > 0){
	    						html += "<ul>";
	    						$.each(org.towComLst,function(index,org3){
	    	    					html += "<li><span  class='file'  onclick='setCheckData("+org3.id+")'>"+org3.com_nam+"</span></li>";
	    	 					});
	    						html += "</ul>";
	    						html += "</li>";
	    					}else{
	    						html += "</li>"
	    					}
	 					});
	    			 }else{
	    					html+="无"; 
	    			 }
	    			
	   	    		$("#navigation").html(html); 
	   	    	    $("#navigation").treeview();
	    			
	   	    	    
	   	    	    $(".treeview span").on("click",function(){
			   	  		$(".treeview").find("span").css("background-color","transparent");
			   	  		$(this).css("background-color","#f0f0f0");
			   	  	});	
	   	    	    
	   	    		 if(data.data.length > 0){
		   	    	    $($("#navigation").find(".file")[0]).click();
	   	    	 	}
				} else {
	               layer.alert(data.desc);
				}
	    	}
   		 }) */
		 
		/* 	$.ajax({
		    	url:url+"getCustomerAddressBook.htm",
		    	data : "use_id="+userId,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		    			 var html = "";
		    			 if(data.data.length > 0 ){
		    				 html += "<li>";
		    				 $.each(data.data,function(index,org){
		    					var isFolder = "file";
		    					if(org.comLev3Lst != null && org.comLev3Lst.length > 0){
		    						isFolder = "folder";
		    					}
		    					html += "<li><span  class='"+isFolder+"' onclick='setCheckData("+org.id+")'>"+org.com_nam+"</span>";
		    					if(org.comLev3Lst != null && org.comLev3Lst.length > 0){
		    						html += "<ul>";
		    						$.each(org.comLev3Lst != null && org.comLev3Lst,function(index,org3){
		    	    					html += "<li><span  class='file'  onclick='setCheckData("+org3.id+")'>"+org3.com_nam+"</span></li>";
		    	 					});
		    						html += "</ul>";
		    						html += "</li>";
		    					}else{
		    						html += "</li>"
		    					}
		 					});
		    			 }else{
		    					html+="无"; 
		    			 }
		    			
		   	    		$("#navigation").html(html); 
		   	    	    $("#navigation").treeview();
		    			
		   	    	 	$(".treeview span").on("click",function(){
				   	  		$(".treeview").find("span").css("background-color","transparent");
				   	  		$(this).css("background-color","#f0f0f0");
				   	  	});	
		   	    	 if(data.data.length > 0){
			   	    	    $($("#navigation").find("ul").find("li")[0]).find("span").click();
		   	    	 	}
					} else {
		               layer.alert(data.desc);
					}
		    	}
	   		 })
		 
	} */
	function getCom(){
		$.ajax({
	    	url:url+"getCustomerAddressBook.htm",
	    	data : "use_id="+userId,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 var html = "";
	    			 if(data.data.length > 0 ){
	    				 html += "<li>";
	    				 $.each(data.data,function(index,org){
	    					var isFolder = "file";
	    					if(org.towComLst != null && org.towComLst.length > 0){
	    						isFolder = "folder";
	    					}
	    					html += "<span  class='"+isFolder+"' onclick='setCheckData("+org.id+")'>"+org.com_nam+"</span>";
	    					if(org.towComLst != null && org.towComLst.length > 0){
	    						html += "<ul>";
	    						$.each(org.towComLst,function(index,org2){
	    	    					var isFolderTwo = "file";
	    	    					if(org2.thrComLst != null && org2.thrComLst.length > 0){
	    	    						isFolderTwo = "folder";
	    	    					}
	    	    					html += "<li><span  class='"+isFolderTwo+"'  onclick='setCheckData("+org2.id+")'>"+org2.com_nam+"</span>";
	    	    					if(org2.thrComLst != null && org2.thrComLst.length > 0){
	    	    						html += "<ul>";
	    	    						$.each(org2.thrComLst,function(index,org3){
	    	    	    					html += "<li><span  class='file'  onclick='setCheckData("+org3.id+")'>"+org3.com_nam+"</span></li>";
	    	    	 					});
	    	    						html += "</ul>";
	    	    						html += "</li>";
	    	    					}else{
	    	    						html += "</li>"
	    	    					}
	    	 					});
	    						html += "</ul>";
	    					}else{
	    						html += "</li>"
	    					}
	 					});
	    			 }else{
	    					html+="无"; 
	    			 }
	    			
	   	    		$("#navigation").html(html); 
	   	    	    $("#navigation").treeview();
	    			
	   	    	 	$(".treeview span").on("click",function(){
			   	  		$(".treeview").find("span").css("background-color","transparent");
			   	  		$(this).css("background-color","#f0f0f0");
			   	  	});	
	   	    	 
	   	    	 	if(data.data.length > 0){
		   	    	    $($("#navigation").find(".file")[0]).click();
	   	    	 	}
				} else {
	               layer.alert(data.desc);
				}
	    	}
   		 })
	}
	function setCheckData(id){
		checkComId = id ; 
		getData();
	}
	
	var countAll = 0;
	var currentPage  = 1; 
	function getData(param2){
		
		var curParam = "" ;
		if(param2 != undefined){
			curParam = param2 ;
		}else{
			comId = checkComId   ;
			curParam= "use_typ=2&com_id="+comId;
			var use_nam = $("#use_nam").val();
			var use_mob = $("#use_mob").val();
			curParam = curParam+"&use_id="+userId;
			if(use_nam != "" && use_nam != undefined ){
				curParam += "&use_nam="+use_nam;
			}
			if(use_mob != "" && use_mob != undefined ){
				curParam += "&use_mob="+use_mob;
			}
		}
		var param = curParam +  "&currentPage="+currentPage;
		
		
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
	    	url:url+"getUseByCustomerAddressBook.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			countAll = data.totalPage;
 					currentPage = data.currentPage;
	    			 var html = "";
	    			 if(data.data.length > 0 ){
		    			 for(var i = 0 ;i < data.data.length ; i++){
		    					var basSci = data.data[i];
		    					var state =  "" ;
		    					var sex =  "" ;
		    					if(basSci.use_sex == 1){
		    						sex =  "男"  ;
		    					}else{
		    						sex =  "女" ;
		    					}
			    				 html  +=   "<tr>"+        
			    				 "<td>"+(i+1)+"</td>"+
					              "<td>"+getIsNull(basSci.use_nam)+"</td>"+
					              "<td>"+sex+"</td>"+
					              "<td>"+getIsNull(basSci.pos_nam)+"</td>"+
					              "<td>"+getIsNull(basSci.use_mob)+"</td>"+
					              "<td>"+getIsNull(basSci.use_mal)+"</td>"+
					              "<td>"+getIsNull(basSci.use_add)+"</td>"+
			         		 	    "</tr>";
			         		 }
		    			 $("#tcdPageCode1").createPage({
		 				        pageCount:countAll,
		 				        current:currentPage,
		 				        backFn:function(p){
		 				        	currentPage = p;
		 				        	getData(curParam);
		 				        }
		 			    	});
	    			 }else{
	    				 html += "<tr><td colspan = '9' >暂无数据</td></tr>";
	    				 $("#tcdPageCode1").empty();
	    			 }
	    			
	    			 $("#datalist").html(html); 
	    			 layer.close(indexlayer);

				} else {
					layer.close(indexlayer);
	               layer.alert(data.desc);
				}
	    	}
   		 })
	}
	
	
	</script>
</body>
</html>

