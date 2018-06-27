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
<title></title>
<link rel="stylesheet" type="text/css"	href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css"	href="<%=basePath%>css/common.css?pubVersion=201802070001">
<link rel="stylesheet" href="<%=basePath%>/js/jquery-treeview/jquery.treeview.css?pubVersion=201802070001" />

</head>
<body> 
 <!-- viewFramework   -->
  <div class=viewFramework> 
  <input type="hidden" id="userId" name="userId" value="${user.id}" >
  <input type="hidden" id="app_typ_id"> 
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
	          	<!-- <input type="text" value="" id="search" placeholder="告警等级/设备类型" class="fl quinput"> -->
	          	<select  id="search" class="fl quinput"   placeholder="请选择告警等级" >
						<option value="">全部</option>
						<option value="1">告警</option>
						<option value="2">故障</option>
				</select>
	          	
	          	<input type="button" value="查询" class="querybut" onclick="currentPage  = 1; getData();">
	          </div>
	          <div class="fr mr15">
	            <a class="queryicon GJMXJ_QX" onclick="add()" data-url="" data-title="新建告警码"  ><i class="add"></i>新建</a>
	  <!--         	<a class="queryicon "  onclick="addTyp();" ><i class="add"></i>新建类型</a>
	          	<a class="queryicon ml15"    onclick="editType();"   ><i class="edit"></i>修改类型</a>
	          	<a class="queryicon ml15"    onclick="delType();"   ><i class="del"></i>删除类型</a> -->
	          </div>
	        </div>
	      </div>
		  <div  class="mt15 pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-list">
			            <tr>
			              <!-- <th><input type="checkbox" onclick="selectCheck(this)"></th> -->
					       <th>编号</th>
	     			       <th>告警名称</th>
	     			       <th>告警等级</th>
					       <th>设备类型</th>
					       <th>索引位置</th>
					       <th>创建时间</th>
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
		getTypeData();
	})
	
	function getApp(app_typ_id){
		 $.ajax({
		    	url:url+"getAppInfo.htm",
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		    			 var htmls = "";
		    			 if(data.data.length > 0 ){
		    				 for(var i = 0; i< data.data.length ; i++){
				    				var d =  data.data[i];
				    				if(app_typ_id == d.id ){
				    					 htmls +=  "<option value='"+d.id+"' selected >"+d.typ_nam+"</option>";
				    				}else{
				    					 htmls +=  "<option value='"+d.id+"'>"+d.typ_nam+"</option>";
				    				}
			    			 }
		    			 } 
		   	    		 
		   	    	     $("#app_typ_id").html(htmls);
		    			
					} else {
		               layer.alert(data.desc);
					}
		    	}
		})
	}
	
	function getTypeData(){
		$.ajax({
	    	url:url+"getBasAppTypAll.htm",
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
			    				htmls +=  "<li><span class='file' onclick='checkTyp(&apos;"+d.typ_ide+"&apos;)'>"+d.typ_nam+"</span></li>";
		    			 }
	    				 htmls +=  "</ul>";
		    			 htmls += "</li>";
	    			 }else{
	    					htmls +=  "<li><span class='file'>全部类型</span></li>";
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
		$("#app_typ_id").val(checkId);
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
			var userId = $("#userId").val();
			var search=$("#search").val();
			
			curParam += "&&user_id="+userId;
			if(checkId != ""  && checkId != 'qb' ){
				curParam +="&&typeId="+checkId;
			}
			if(search!=""){
				curParam+="&&search="+search;
			}

		}
		

		var param = curParam+"&currentPage="+currentPage;
		param = substringParam(param);
		console.log("param="+param)
		
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
	    	url:url+"getAlaCode.htm",
	    	data : param,
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
			    				var ide = i+1;
			    				var flt_lev = d.flt_lev == 1 ? "告警" :d.flt_lev == 2 ? "故障" : "其它" ;
			    				htmls += "<tr>"+
			    					/* "<td><input type='checkbox' name='check' id='"+d.id+"'></td>"+ */
			    					"<td>"+ide+"</td>"+
					              	"<td>"+getIsNull(d.ala_info)+"</td>"+
					              	"<td>"+flt_lev+"</td>"+
					              	"<td>"+getIsNull(d.app_typ_nam)+"</td>"+
					              	"<td>"+getIsNull(d.idx_pst)+"</td>"+
					              	"<td>"+getLocalDateAndTime(d.crt_tim,1)+"</td>"+
					              	"<td>"+getIsNull(d.remark)+"</td>"+
					              	"<td><a  class='layer GJMXG_QX' data-url='<%=basePath%>commens/xtgl/gjmwh/edit.htm?id="+d.id+"' data-title='修改' data-height='300px'  href='javascript:void(0);' >修改 </a>"+
					              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  href='javascript:void(0);' class='GJMSC_QX' onclick='del("+d.id+")'>删除</a>"+
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
	    					htmls +=  "<tr><td colspan='7'>暂无数据</td></tr>";
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
	
	function del(id){
		layer.confirm("确定删除？",function(){
			$.ajax({
		    	url:url+"removeAlaCode.htm",
		    	data : "id="+id,
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
	
	function editType(){
		if(checkId == "" || checkId == 'qb' ){
			layer.alert("请选择待修改的告警码类型");
		}else{
			layer.open({
				  type: 2,
				  skin: 'layer-class' ,
				  title:"修改类型",
				  shadeClose: false,
				  area: ['770px','450px'],
				  content: "<%=basePath%>commens/xtgl/gjmwh/editType.htm?id="+checkId   //iframe的url
			});
			
		} 
	}	
	function delType(){
		if(checkId == "" || checkId == 'qb' ){
			layer.alert("请选择待删除的告警码类型");
		}else{
			layer.confirm("确定删除？",function(){
				$.ajax({
			    	url:url+"reomveAlaType.htm",
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
	<%-- function addTyp(){
		   var app_typ_id=$("#app_typ_id").val();
		   layer.open({
				  type: 2,
				  skin: 'layer-class' ,
				  title:"新建类型",
				  shadeClose: false,
				   area: ['770px','450px'],
				  content: "<%=basePath%>commens/xtgl/gjmwh/addType.htm?app_typ_id="+app_typ_id  //iframe的url
			});
		} --%>
	function add(){
		   var app_typ_id=$("#app_typ_id").val();
		   layer.open({
				  type: 2,
				  skin: 'layer-class' ,
				  title:"新建",
				  shadeClose: false,
				  area: ['770px','450px'],
				  content: "<%=basePath%>commens/xtgl/gjmwh/add.htm?app_typ_id="+app_typ_id  //iframe的url
			});
		}
	</script> 
</body>
</html>
 
