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

<link rel="stylesheet" href="<%=basePath%>/js/jquery-treeview/jquery.treeview.css?pubVersion=201802070001" />
<style>
td{
	word-wrap:break-word;word-break:break-all;
}
</style>
</head>
<body>
	<input  type="hidden" name="userId" id="userId" value="${user.id}">
	  <input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  <input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
	<div class="rc-body">
		<div class="rc-left">
			<ul id="navigation" class="filetree"></ul>
		</div>
		<div class="rc-right">
			<div class="bg-ff pb18 pl15 pt10 clr pl8">
				<div class="query">
					<div class="fl">
						<input type="text" value="" id="info" placeholder="请输入文档名"
							class="fl quinput"> <input type="button" value="查询"
							class="querybut">
					</div>
					<div class="fr mr15">
						<a class="queryicon layer SCWJ_QX"  data-url="<%=basePath%>commens/rcbg/wdgl/add.htm" data-title="上传文件"  data-height="250px"><i class="add"></i>上传文件</a>
						<a class="queryicon layer XJWJLX_QX" data-url="<%=basePath%>commens/rcbg/wdgl/addType.htm" data-title="新增类型" data-height="200px"><i class="add"></i>新建类型</a> 
						<a class="queryicon ml15 XGWJLX_QX" onclick="editType();"  ><i class="edit"></i>修改类型</a> 
						<a class="queryicon ml15 SCWJLX_QX" onclick="delType();"><i class="del"></i>删除类型</a>
					</div>
				</div>
			</div>
			<div class="mt15 pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="table-list">
						<tr>
							<!-- <th><input type="checkbox" onclick="selectCheck(this)"></th> -->
							<th>序号</th>
							<th>文件名</th>
							<th>文件所属公司名</th>
							<th>创建用户</th>
							<th>创建时间</th>
							<th>备注</th>
							<th>操作</th>
						</tr>
						<tbody id="datalist"></tbody>
					</table>
				</div>
				<div class="tcdPageCode" id="tcdPageCode1">
			</div>
			<div class="blank0"></div>
		</div>
	</div>
	<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script type="text/javascript"
	src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jquery-treeview/jquery.treeview.js?pubVersion=201802070001"
	type="text/javascript"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery.qx.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script type="text/javascript">
    var checkId = "";
    $(function () {
		filetype();
	    $(".querybut").click(function(){
	    	getData();
	    }) 
	})
    
    function filetype(){
    	 $.ajax({
		    	url:url+"filetype.htm",
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		    			 var htmls = "";
		    			 if(data.data.length > 0 ){
		    				 htmls +=  "<li><span class='folder' onclick='checkTyp('qb')'>全部</span>";
		    				 htmls +=  "<ul>";
		    				 for(var i = 0; i< data.data.length ; i++){
				    				var d =  data.data[i];
				    				htmls +=  "<li><span class='file' onclick='checkTyp("+d.id+")'>"+d.fil_typ_nam+"</span></li>";
			    			 }
		    				 htmls +=  "</ul>";
			    			 htmls += "</li>";
		    			 }else{
		    					htmls +=  "<li><span class='file'>全部</span></li>";
		    			 }
		    			
		   	    		$("#navigation").html(htmls); 
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
    
    
	
	
	function checkTyp(id){
		checkId = id ; 
		getData();
	}
	
	var getPageData ;
	var countAll = 0;
	var currentPage  = 1;
	var everyPageCount = 25 ;
	function getData(){
		/* var param = "&&user_id=7"; */
		var userId = $("#userId").val();
		var param = "&&user_id="+userId;

		if(checkId != "" || checkId != 'qb' ){
			param +="&&id="+checkId;
		}
		
	
		var info = $("#info").val();
		if(!isNull(info)){
			param +="&&info="+info;
		}
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});

		param = substringParam(param);
		console.log("param="+param)
		$.ajax({
	    	url:url+"getFileList.htm",
	    	data : param,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 var htmls = "";
	    			 if(data.data.length > 0 ){
	    				 for(var i = 0; i< data.data.length ; i++){
	    					 var d =  data.data[i];
	    					 if(i < (currentPage*everyPageCount)){
	    						 htmls += "<tr>"+
					              	"<td>"+(i+1)+"</td>"+
					              	"<td>"+getIsNull(d.fil_nam)+"</td>"+
					              	"<td>"+d.com_nam+"</td>"+
					              	"<td>"+d.use_nam+"</td>"+
					              	"<td>"+getLocalDateAndTime(d.crt_tim,2)+"</td>"+
					              	"<td>"+getIsNull(d.comment)+"</td>"+
					              	"<td><a  class='SHCWJ_QX' href='javascript:void(0);' onclick='del("+d.id+")'>删除 </a>"+
					              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a href='javascript:void(0);' class='XZWJ_QX' onclick='down("+d.id+")'>下载 </a>"+
					              	"</tr>";
	    					 }
	    				 }
	    			 }else{
 						htmls +=  "<tr><td colspan='7'>暂无数据</td></tr>";
    				 }
	   	    		$("#datalist").html(htmls); 
	   	    		getPageData=data.data;
	   	    		countAll = 0 ;
					  if(getPageData.length/everyPageCount > parseInt(getPageData.length/everyPageCount)){   
						  countAll=parseInt(getPageData.length/everyPageCount)+1;   
				      }else{   
				    	  countAll=parseInt(getPageData.length/everyPageCount);   
				       };
				       
			       $("#tcdPageCode1").createPage({
 				        pageCount:countAll,
 				        current:currentPage,
 				        backFn:function(p){
 				        	currentPage = p;
 				        	getPagedData();
 				        }
 			    	});   
				       
				       
	   	    		layer.close(indexlayer);
	   	    		$("#datalist").createQx();
	    		}else{
	    			layer.close(indexlayer);
	           	  	  layer.alert(data.desc);
				}
	    	}
	    })
	}
	
	
	function getPagedData(){
		 var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		 var htmls = "";
		 var max = 0 ;
		 if ( (currentPage*everyPageCount) >  getPageData.length-1 ){
			 max = getPageData.length; 
		 }else{
			 max = (currentPage*everyPageCount) ;
		 }
		 for(var i=((currentPage-1)*everyPageCount);i<max;i++){
			 var lst = getPageData[i];
			 
			 htmls += "<tr>"+
           	"<td>"+(i+1)+"</td>"+
           	"<td>"+getIsNull(lst.fil_nam)+"</td>"+
           	"<td>"+lst.com_nam+"</td>"+
           	"<td>"+lst.use_nam+"</td>"+
           	"<td>"+getLocalDateAndTime(lst.crt_tim,2)+"</td>"+
           	"<td>"+getIsNull(lst.comment)+"</td>"+
           	"<td><a  class='SHCWJ_QX' href='javascript:void(0);' onclick='del("+lst.id+")'>删除 </a>"+
           	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a href='javascript:void(0);' class='XZWJ_QX' onclick='down("+lst.id+")'>下载 </a>"+
           	"</tr>";
		 }
		 $("#datalist").html(htmls);
		 layer.close(indexlayer);  //关闭 loading 
		
	}
	
	
	function del(id){
		layer.confirm("确定删除？",function(){
			$.ajax({
		    	url:url+"removeFile.htm",
		    	data : "id="+id,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		   	    		layer.alert("删除成功");
		   	    		currentPage  = 1;
		   	    		getData();
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		})
	}
	
	function editType(){
		if(checkId == "" || checkId == 'qb' ){
			layer.alert("请选择待修改的知识库类型");
		}else{
			layer.open({
				  type: 2,
				  skin: 'layer-class' ,
				  title:"修改类型",
				  shadeClose: false,
				  area: ['770px','450px'],
				  content: "<%=basePath%>/commens/rcbg/wdgl/editType.htm?id="+ checkId //iframe的url
				  
			});
			
		}
		
	}
	function delType() {
		if (checkId == "" || checkId == 'qb') {
			layer.alert("请选择待删除的知识库类型");
		} else {
			layer.confirm("确定删除？",function(){
				$.ajax({
					url : url + "removeFileType.htm",
					data : "id=" + checkId,
					dataType : "json",
					type : "post",
					success : function(data) {
						if (data.resultcode == "USR000") {
							layer.alert("删除类型成功");
							currentPage  = 1; 
							filetype();
						} else {
							layer.alert(data.desc);
						}
					}
				})
			})
		}
		
	}
	function down(id){
		layer.confirm("确定下载？",function(){
			layer.closeAll();
			$.ajax({
				url : url + "download.htm",
				data : "id=" + id,
				dataType : "json",
				type : "post",
				success : function(data) {
					if (data.resultcode && data.resultcode != "USER000") {
						layer.alert(data.desc);
						return ;
					} else {
						location.href = url+"download.htm?id="+id;
					}
				},
				error : function(){
					location.href = url+"download.htm?id="+id;
				}
			}) 
		}) 
		
	}
</script>
</body>
</html>

