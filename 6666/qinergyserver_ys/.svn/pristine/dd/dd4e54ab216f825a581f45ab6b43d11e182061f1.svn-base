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
	<input type="hidden" id="use_typ" value="${user.use_typ}" >
	<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >	
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
						<input type="text" value="" id="words"  placeholder="请输入账号/手机号/姓名" class="fl quinput">
						<input type="button" value="查询" class="querybut" onclick="currentPage  = 1; getData();">
					</div>
					<div class="fr mr10">
						<a  class="queryicon XJYG_QX"   onclick="return add();" ><i class="add"></i>添加员工</a>
					</div>
				</div>
			</div>
			<div class="mt15 pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto" >
					<table width="100%" border="0" cellpadding="0"   class="table-list">
						<tr>
							<th >序号</th>
							<th>姓名</th>
							<th >用户状态</th>
							<th >部门</th>
							<th >性别</th>
							<th >手机</th>
							<th >邮箱</th>
							<th >告警查看状态</th>
							<th >站查看状态</th>
							<th >操作</th>
						</tr>
						 <tbody id="datalist">
						 	<tr><td colspan="10">暂无数据</td></tr>
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
	<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
	<script src="<%=basePath%>js/jquery-treeview/jquery.treeview.js?pubVersion=201802070001" type="text/javascript"></script>
	<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.qx.js?pubVersion=201802070001"></script>
	<script type="text/javascript">
	var userId = $("#userId").val();
	var checkComId = "";
	$(function () {

	 	/*  //设置宽高
   		var ScreenWidth  = (document.documentElement.clientWidth);  
   		ScreenWidth = ScreenWidth*0.85;
   		
   		//设置地图高
   		$(".wauto").css("width",ScreenWidth-30);
   		var tab = $('.table-list');
   		var td = $(tab.find('tr')[0]).find('th');
   		if(td.length * 120 > ScreenWidth-30){ // 300是td的平均值，800是table外div的宽度，如果大于这个就给table一个宽度
   			tab[0].width = td.length *120;
   		}  */
   		 
		getCom();
		
		$(".querybut").click(function(){
			getData();
		})
	});
	
	function add(){
		if(checkComId == ""){
			layer.alert("请选择公司添加员工");
		}else{
			layer.open({
			  type: 2,
			  skin: 'layer-class' ,
			  title: '新增员工',
			  shadeClose: false,
			  area: ['770px','450px'],
			  content: "<%=basePath%>/commens/rcbg/yggl/add.htm?type="+checkComId,
			});
		}
	}
	
	function getCom(){
		$.ajax({
	    	url:url+"getOptComLst.htm",
	    	data : "id="+userId,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 var html = "";
	    			 if(data.data.length > 0 ){
	    				 html += "<li>";
	    				 $.each(data.data,function(index,org){
	    					var isFolder = "file";
	    					if(org.comLev2Lst.length > 0){
	    						isFolder = "folder";
	    					}
	    					html += "<span  class='"+isFolder+"' onclick='setCheckData("+org.id+")'>"+org.com_nam+"</span>";
	    					if(org.comLev2Lst.length > 0){
	    						html += "<ul>";
	    						$.each(org.comLev2Lst,function(index,org2){
	    	    					var isFolderTwo = "file";
	    	    					if(org2.comLev3Lst.length > 0){
	    	    						isFolderTwo = "folder";
	    	    					}
	    	    					html += "<li><span  class='"+isFolderTwo+"'  onclick='setCheckData("+org2.id+")'>"+org2.com_nam+"</span>";
	    	    					if(org2.comLev3Lst.length > 0){
	    	    						html += "<ul>";
	    	    						$.each(org2.comLev3Lst,function(index,org3){
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
			var use_typ = $("#use_typ").val();
			curParam = "use_typ="+1+"&com_id="+checkComId;
			var words = $("#words").val();
			if(words != "" && words != undefined ){
				curParam += "&words="+words;
			}
			
		}
		
		var param = curParam + "&currentPage="+currentPage;
		
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});

		$.ajax({
	    	url:url+"getUserInfListByType.htm",
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
		    					var ahtm = "";
		    					if(basSci.use_sta == 1){
		    						 state =  "在职"  ;
		    					}else{
		    						 state =  "离职" ;
		    					}
		    					var sex =  "" ;
		    					if(basSci.use_sex == 1){
		    						sex =  "男"  ;
		    					}else{
		    						sex =  "女" ;
		    					}
		    					var isDefSta=basSci.is_def_sta==1?"可查看":basSci.is_def_sta ==2?"不可查看":"";
		    					var sltOptSta=basSci.slt_opt_sta==1?"可查看":basSci.slt_opt_sta ==2?"不可查看":"";
			    				 html  +=   "<tr>"+        
								  "<td>"+(i+1)+"</td>"+
								  "<td>"+getIsNull(basSci.use_nam)+"</td>"+
								  "<td>"+state+"</td>"+
								  "<td>"+getIsNull(basSci.dep_nam)+"</td>"+
								  "<td>"+sex+"</td>"+
								  "<td>"+getIsNull(basSci.use_mob)+"</td>"+
								  "<td>"+getIsNull(basSci.use_mal)+"</td>"+
								  /* "<td>"+getIsNull(basSci.com_nam)+"</td>"+
								  "<td>"+getIsNull(basSci.com_nam)+"</td>"+
								  "<td>"+getIsNull(basSci.com_nam)+"</td>"+
								  "<td>"+getIsNull(basSci.com_nam)+"</td>"+
								  "<td>"+getIsNull(basSci.com_nam)+"</td>"+
								  "<td>"+getIsNull(basSci.com_nam)+"</td>"+
					              
					              
					              "<td>"+getIsNull(basSci.edu_nam)+"</td>"+
					              "<td>"+getIsNull(basSci.rol_nam)+"</td>"+
					              
					              "<td>"+getIsNull(basSci.use_nam)+"</td>"+
					              
					              
					              "<td>"+getIsNull(basSci.use_idc)+"</td>"+
					              
					              "<td>"+getIsNull(basSci.use_add)+"</td>"+
					              "<td>"+getIsNull(basSci.use_maj)+"</td>"+
					              "<td>"+getIsNull(getLocalDateAndTime(basSci.tak_tim,2))+"</td>"+ */
					              "<td>"+getIsNull(isDefSta)+"</td>"+
					              "<td>"+getIsNull(sltOptSta)+"</td>"+
			              		   "<td><a href='#' target='_self' class='layer XGYG_QX' data-title='员工修改'  data-url='"+jumpPageUrl+"commens/rcbg/yggl/edit.htm?id="+basSci.id+"' >修改</a>"+
			         		 	   "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a href='#' target='_self' class='layer' data-title='详细'  data-url='"+jumpPageUrl+"commens/rcbg/yggl/detal.htm?id="+basSci.id+"' >详细</a>"+
			         		 	   "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a href='#' target='_self' class='layer' data-title='上传头像'  data-url='"+jumpPageUrl+"commens/rcbg/yggl/addlogo.htm?id="+basSci.id+"' >上传头像</a>"+
			         		 	   "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a href='#' target='_self' class='layer YWFSXG_QX' data-title='分数修改' data-height='200px' data-url='"+jumpPageUrl+"commens/rcbg/yggl/ywfsxg.htm?id="+basSci.id+"' >分数修改</a>"+
			         		 	   "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a href='#' target='_self' class='layer RWZP_QX' data-title='任务转派' data-height='200px' data-url='"+jumpPageUrl+"commens/rcbg/yggl/zp.htm?id="+basSci.id+"' >任务转派</a>"+
			         		 	   "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a href='#' onclick=delThis('"+basSci.id+"') class='SCYG_QX' target='_self'>删除</a>"+ 
			         		 	   "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a href='#' onclick=resetPas('"+basSci.id+"') class='CZMM_QX' target='_self'>重置密码</a>"+ 
			         		 	   "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span>"+
			         		 	   "<a href='<%=basePath%>commens/rcbg/yggl/editGx.htm?id="+basSci.id+"' class='DZPZ_QX'>电站配置 </a></td>"+
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
	    				 html += "<tr><td colspan = '10' >暂无数据</td></tr>";
	    				 $("#tcdPageCode1").empty();
	    			 }
	    			
	    			 $("#datalist").html(html); 
	    			
	    			 layer.close(indexlayer);
	    			 
	    			 $("#datalist").createQx();
	    			/*  //设置宽高
	   	    		var ScreenWidth  = (document.documentElement.clientWidth);  
	   	    		ScreenWidth = ScreenWidth*0.85;
	   	    		//设置地图高
	   	    		$(".wauto").css("width",ScreenWidth-20);
	   	    		var tab = $('.table-list');
	   	    		var td = $(tab.find('tr')[1]).find('td');
	   	    		if(td.length * 150 > ScreenWidth-10){ // 300是td的平均值，800是table外div的宽度，如果大于这个就给table一个宽度
	   	    			tab[0].width = td.length *150;
	   	    		}  */

				} else {
					layer.close(indexlayer);
	               layer.alert(data.desc);
				}
	    	}
   		 })
	}
	
	function delThis(id){
		layer.confirm("确定删除？",function(){
			$.ajax({
				url:url+"delUserInfo.htm",
				type:"post",
				data:"id="+id,
				dataType:"json",
				success:function(data){
					if (data.resultcode=="USR000") {
						currentPage  = 1; 
						layer.alert("删除成功");
						getData();
					} else {
						layer.alert("删除失败")
					}
				}
			})
		});
	}
	
	function resetPas(id){
		layer.confirm("确定重置？",function(){
			$.ajax({
				url:url+"resetPwd.htm",
				type:"post",
				data:"id="+id+"&use_pas=123456",
				dataType:"json",
				success:function(data){
					if (data.resultcode=="USR000") {
						layer.msg("重置成功");
						getData();
					} else {
						layer.alert("删除失败")
					}
				}
			})
		})
		
	}
	
	
	
	
	</script>
</body>
</html>

