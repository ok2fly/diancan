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
<title>培训计划</title>
<link rel="stylesheet" type="text/css"	href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css"	href="<%=basePath%>css/common.css?pubVersion=201802070001">
<link rel="stylesheet" href="<%=basePath%>/js/jquery-treeview/jquery.treeview.css?pubVersion=201802070001" />
</head>
<body> 
<input type="hidden" id="type" >
<input type="hidden" id="userId" value="${user.id}" >
<input type="hidden" id="com_id" value="${user.com_id}">
  <input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  <input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
 <!-- viewFramework   -->
  <div class=viewFramework> 
  <div class="rc-body">
		<div class="rc-left">
			<ul id="navigation" class="filetree"></ul>
		</div>
		<div class="rc-right">
	     <div class="bg-ff pb18 pl15 pt10 clr pl8">
	        <div class="query">
	          <div class="fl">
				<input type="text" id="start_tim" class="fl quinput popinput Wdate " placeholder="开始时间" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end_tim\')}'})" style="margin-left:8px;">
				<input type="text" id="end_tim" class="fl quinput popinput Wdate" placeholder="结束时间" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'start_tim\')}'})" style="margin-left:8px;">
				<input type="text" value="" id="words" placeholder="主讲人、被培训对象" class="fl quinput" style="margin-left:8px;">
	          	<input type="button" value="查询" class="querybut" >
	          </div>
	          <div class="fr mr15">
	          	<a class="queryicon TJJH_QX"   onclick="add()" data-title="添加计划"  data-height="350px"  ><i class="add"></i>添加计划</a>
	          	<a class="queryicon layer XJLX_QX"  data-url="<%=basePath%>/commens/jhgl/pxjh/addType.htm" data-title="新建类型"  data-height="250px"  ><i class="add"></i>新建类型</a>
	          	<a class="queryicon ml15 XGLX_QX"    onclick="editType();"    ><i class="edit"></i>修改类型</a>
	          	<a class="queryicon ml15 SCLX_QX"    onclick="delType();"   ><i class="del"></i>删除类型</a>
	          </div>
	        </div>
	      </div>
		  <div  class="mt15 pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-list">
			            <tr>
			              <!-- <th><input type="checkbox" onclick="selectCheck(this)"></th> -->
			              <th>序号</th>
			              <th>培训内容</th>
			              <th>主讲人</th>
			              <th>被培训对象</th>
			              <th>开始时间</th>
			              <th>结束时间</th>
			              <th>培训地点</th>
			              <th>备注</th>
			              <th>操作</th>
			            </tr>
			            <tbody id="datalist"></tbody>
			         </table>
			        </div>
			        <div class="tcdPageCode" id="tcdPageCode1"></div> 
	          </div>
	          <div class="blank0"></div>
	  </div>
  </div>
   <!-- ./ viewFramework --> 
   <script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script type="text/javascript" 	src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jquery-treeview/jquery.treeview.js?pubVersion=201802070001" type="text/javascript"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>

<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001" type="text/javascript"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.qx.js?pubVersion=201802070001"></script>
<script type="text/javascript">
    var checkId = "";
	$(function () {
		getData();
		getTypeData();
	    $(".querybut").click(function(){
	    	currentPage  = 1;
	    	getData();
	    }) 
	})
	
	function getTypeData(){
		$.ajax({
	    	url:url+"getTrainingTypList.htm",
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
			    				htmls +=  "<li><span class='file' onclick='checkTyp("+d.id+")'>"+d.typ_nam+"</span></li>";
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
		   	    	    $($("#navigation").find("ul").find("li")[0]).find("span").click();
	   	    	 	}
	   	    	 	
				} else {
	               layer.alert(data.desc);
				}
	    	}
    })
	}
	
	function checkTyp(id){
		checkId = id ; 
		$("#type").val(checkId);
		currentPage  = 1;
		getData();
	}
	
	var countAll = 0;
	var currentPage  = 1;
	function getData(param2){
		
		var curParam = "" ;
		if(param2 != undefined){
			curParam = param2 ;
		}else{
			if($("#words").val()!=""){
				curParam+="&&words="+$("#words").val();
			}
			if($("#start_tim").val()!=""){
				curParam+="&&start_tim="+$("#start_tim").val();
			}
			if($("#end_tim").val()!=""){
				curParam+="&&end_tim="+$("#end_tim").val();
			}
			
		}
		
		
		var param  = curParam + "&&currentPage="+currentPage;
		
		var com_id=$("#com_id").val();
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});

		$.ajax({
	    	url:url+"getTrainingPlanList.htm",
	    	data : param+"&&com_id="+com_id+"&&typ_id="+checkId,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			countAll = data.totalPage;
					currentPage = data.currentPage;
	    			 var htmls = "";
	    			 if(data.data.length > 0 ){
	    				 for(var i = 0; i< data.data.length ; i++){
	    					 var d =  data.data[i];
	    					 var is_exec = d.is_exec == 0 ?"待执行" : d.is_exec == 1 ? "已执行" : "无" ;
	    						 htmls += "<tr>"+
			    					/* "<td><input type='checkbox' name='check' id='"+d.id+"'></td>"+ */
			    					"<td>"+((currentPage-1)*25+i+1)+"</td>"+
					              	"<td>"+getIsNull(d.tra_cont)+"</td>"+
					              	"<td>"+getIsNull(d.tra_speaker)+"</td>"+
					              	"<td>"+getIsNull(d.tra_target)+"</td>"+
					              	"<td>"+getLocalDateAndTime(d.begin_tim,2)+"</td>"+
					              	"<td>"+getLocalDateAndTime(d.finish_tim,2)+"</td>"+
					              	"<td>"+getIsNull(d.tra_place)+"</td>"+
					              	"<td>"+getIsNull(d.remark)+"</td>"+
					              	"<td><a  class='layer CKWJ_QX'  data-url='<%=basePath%>commens/jhgl/pxjh/query.htm?tra_num="+d.tra_num+"' data-title='查看'   href='javascript:void(0);' >查看文件</a>"+
					              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a class='layer XGJH_QX'  data-url='<%=basePath%>commens/jhgl/pxjh/edit.htm?id="+d.id+"' data-title='修改' data-height='400px'  href='javascript:void(0);' >修改 </a>"+
					              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  href='javascript:void(0);' class='SCJH_QX' onclick='del(&quot;"+d.id+"&quot;,&quot;"+d.tra_num+"&quot;)'>删除</a>"+
					              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='layer SCWJ_QX'  data-url='<%=basePath%>commens/jhgl/pxjh/file.htm?id="+d.id+"&tra_num="+d.tra_num+"' data-title='上传文件' data-height='300px'  href='javascript:void(0);' >上传文件</a></td>"+
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
	    					htmls +=  "<tr><td colspan='9'>暂无数据</td></tr>";
	    					$("#tcdPageCode1").empty();
	    			 }
	    			
	   	    		$("#datalist").html(htmls); 
	   	    	 
	   	    		layer.close(indexlayer);
	   	    		$("#datalist").createQx();
				} else {
		   	    	layer.close(indexlayer);
	               layer.alert(data.desc);
				}
	    	}
	    })
	}
	
	function del(id,tra_num){
		layer.confirm("确定删除？",function(){
			$.ajax({
		    	url:url+"delTrainingPlanById.htm",
		    	data : "id="+ id + "&tra_num="+tra_num,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		    			currentPage  = 1;
		   	    		layer.alert("删除成功");
		   	    		getData();
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
		})
	}
	function delType(){
		if(checkId == "" || checkId == 'qb' ){
			layer.alert("请选择待删除的知识库类型");
		}else{
			layer.confirm("确定删除？",function(){
				$.ajax({
			    	url:url+"delTrainingTyp.htm",
			    	data : "id="+checkId,
			    	dataType:"json",
			    	type:"post",
			    	success:function(data){
			    		if (data.resultcode=="USR000") {
			   	    		layer.alert("删除类型成功");
			   	    		getTypeData();
						} else {
			               layer.alert(data.desc);
						}
			    	}
			    })
			})
		} 
	}
	function editType(){
		if(checkId == "" || checkId == 'qb' ){
			layer.alert("请选择待修改的培训类型");
		}else{
			layer.open({
				  type: 2,
				  skin: 'layer-class' ,
				  title:"修改类型",
				  shadeClose: false,
				  area: ['770px','450px'],
				  content: "<%=basePath%>commens/jhgl/pxjh/editType.htm?id="+checkId   //iframe的url
			});
			
		} 
	}	
	function add(){
		var type=$("#type").val();
		layer.open({
			  type: 2,
			  skin: 'layer-class' ,
			  title:"新建",
			  shadeClose: false,
			  area: ['770px','450px'],
			  content: "<%=basePath%>commens/jhgl/pxjh/add.htm?type="+type  //iframe的url
		});
	}
	</script>
</body>
</html>
 
