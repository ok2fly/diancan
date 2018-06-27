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
</head>
<body> 
 <!-- viewFramework   -->
  <div class=viewFramework> 
	 	<input type="hidden" id="userId" value="${user.id}" >
		<input type="hidden" id="use_typ" value="${user.use_typ}" >
		<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
		  <input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  <input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
  		<div class="bge  pr8 pt10 pl8" style="padding-bottom:8px;">
  			<div class="bg-ff pb18 pl15 pt10 clr pl8">
  				<h4>前置条件</h4>
  			</div>
	  		<div class="bg-ff pl15 pt10 clr pl8"  style="padding-bottom:8px;">
		        <div class="query">
			          <div class="fl">
			          	 	<select class="fl quinput w20"  id="companyOne"  onchange="setCompanytwo(this.value);">
	        	   			 	<option value="qxz">请选择一级公司</option>
	        	   			 </select>
	        	   			 <select class="fl quinput w20"  id="companyTwo" style="margin-left:15px;" onchange="setCompanyThree(this.value);">
	        	   			 	<option value="qxz">请选择二级公司</option>
	        	   			 </select>
	        	   			 <select class="fl quinput w20"  id="companyThree" style="margin-left:15px;" onchange="setPws(this.value);">
	        	   			 	<option value="qxz">请选择三级公司</option>
	        	   			 </select>
	        	   			  <select class="fl quinput w20"  id="companyPwsNew" style="margin-left:22px;"   >
	        	   			 	<option value="qxz">请选择电站</option>
	        	   			 </select>
			          </div>
	            </div>
	      	</div>
        </div>
        <div class="bge  pr8 pt10 pl8" style="padding-bottom:8px;">
        	<div class="bg-ff pl15 pt10 clr pl8">
        	 	<div class="query">
		          <div class="fl">
		          	<select class="fl quinput w20"  id="app_typ_ide"  onchange="getAppType(this.value)" >
       	   			 	 	<option value="qxz">-设备类型-</option>
							<!-- <option value="GFNBQ">光伏逆变器</option>
							<option value="CNNBQ">储能逆变器</option>
							<option value="DCDC">DC/DC</option>
							<option value="BYQ">变压器</option>
							<option value="DB">电表</option>
							<option value="DNZLJCZZ">电能质量检测</option>
							<option value="HLX">汇流箱</option>
							<option value="JLPDG">交流配电柜</option>
							<option value="ZLPDG">直流配电柜</option>
							<option value="HJJCY">环境检测仪</option>
							<option value="CNDC">储能电池</option>
							<option value="JLZZ">解列</option>
							<option value="XLBH">线路保护</option>
							<option value="ZLCDZ">直流充电桩</option>
							<option value="JLCDZ">交流充电桩</option>
							<option value="KZQ">控制器</option> -->
       	   			 </select>
       	   			 <select class="fl quinput w20"  id="app_id" style="margin-left:15px;"   >
       	   			 	 	<option value="qxz">-设备型号-</option>
       	   			 </select>
	          		 <input type="button" value="查询" class="querybut" onclick="currentPage  = 1; getData();">
		          </div>
		          <div class="fr mr15">
		             <a class="queryicon XJJCSB_QX"     onclick="return add();"><i class="add"></i>添加设备</a>
		          </div>
		         </div>
	        </div>
		  	<div  class="pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto" >
					<table  width="100%"  border="0" cellpadding="0" cellspacing="0" class="table-list">
			            <tr>
			              <th>序号</th>
			              <th>设备名称</th>
			              <th>设备型号</th>
			              <th>电站名称</th>
			              <th>安装地址</th>
			              <th>出厂日期</th>
			              <th>操作</th>
			            </tr>
			            <tbody id="datalist"> 
			            	<tr><td colspan='8'>暂无数据</td></tr>
			            </tbody>
			         </table>
		        </div>
		         <div class="tcdPageCode"></div>  
          </div>
          <div class="blank0"></div>
  		</div>
  </div>
   <!-- ./ viewFramework --> 
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript" src="<%=basePath%>js/xtCheckCom.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jquery.qx.js?pubVersion=201802070001"></script>
<script>
var checkId = "";
$(function () {
	getCompanyOne();
	getApp();
	
	
	$("#companyOne").change(function(){
		setPwsNew($(this).val(),1);
	})
	$("#companyTwo").change(function(){
		setPwsNew($(this).val(),2);
	})
	$("#companyThree").change(function(){
		setPwsNew($(this).val(),3);
	})
})

function setPwsNew(val,lev){
	if(val == 'qxz'){
		 if(lev == 1){
			 $("#companyPwsNew").empty().append('<option value="qxz">请选择电站</option');
			 return ;
		 }else if(lev == 2){
			 val = $("#companyOne").val();
		 }else if(lev == 3){
			 val = $("#companyTwo").val();
		 }
	} 
		 
	var html = '<option value="qxz">请选择电站</option>';
	var param = 'com_id='+val;
	$.ajax({
    	url:url+"getPwsInfLstByComId.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			for (var l = 0; l < data.data.length; l++) {
					 var pws = data.data[l];
					 var selectHtm = "";
					 /* if(sessionStorage.getItem("pwsIdXt") && sessionStorage.getItem("pwsIdXt") == pws.id){
						   selectHtm = "selected";
					 } */
					 html += '<option value="'+pws.id+'" '+selectHtm+'>'+pws.pws_nam+'</option>'
				 }
    			$("#companyPwsNew").empty().append(html);
			} else {
               layer.alert(data.desc);
			}
    	}
    })
	 
}

function getApp(){
	 $.ajax({
	    	url:url+"getBasAppTypAll.htm",
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	    			 var htmls = "<option value='qxz'>-设备类型-</option>";
	    			 if(data.data.length > 0 ){
	    				 for(var i = 0; i< data.data.length ; i++){
			    				var d =  data.data[i];
		    					 htmls +=  "<option value='"+d.typ_ide+"'>"+d.typ_nam+"</option>";
		    			 }
	    			 } 
	   	    		 
	   	    	     $("#app_typ_ide").html(htmls);
	    			
	   	    	  	 getAppType($("#app_typ_ide").val());
				} else {
	               layer.alert(data.desc);
				}
	    	}
	})
}



function add(){
	var companyPws = $("#companyPwsNew").val();
	if(companyPws == "qxz"  || companyPws == undefined){
		 layer.alert("请选择前置条件");
		 return;
	}else{
		layer.open({
		  type: 2,
		  skin: 'layer-class' ,
		  title: "新增设备",
		  shadeClose: false,
		  area: ['770px','450px'],
		  content: "<%=basePath%>commens/xtgl/jcsbwh/add.htm?id="+companyPws
		});
	}
}

var countAll=0;
var currentPage = 1;
function getData(param2){
	
	var curParam = "" ;
	if(param2 != undefined){
		curParam = param2 ;
	}else{
		var companyPws = $("#companyPwsNew").val();
		if(companyPws == "qxz"  || companyPws == undefined){
			 layer.alert("请选择前置条件");
			 return;
		}
		
		curParam  += "pws_id="+companyPws ;
		
		var app_typ_ide = $("#app_typ_ide").val();
		if(app_typ_ide != "qxz"  &&  app_typ_ide != undefined){
			curParam += "&&app_typ_ide="+app_typ_ide;
		}
		
		var app_id = $("#app_id").val();
		if(app_id != "qxz"  &&  app_id != undefined){
			curParam += "&&app_id="+app_id;
		}
	}
	
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	var param = curParam + "&currentPage="+currentPage ;
	$.ajax({
    	url:url+"getEquInfLst.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 var htmls = "";
   				 if(data.data.length > 0 ){
   					countAll = data.totalPage;
					currentPage = data.currentPage;
       				 for(var i = 0; i< data.data.length ; i++){
   		    				var d =  data.data[i];
   		    				htmls += "<tr>"+
   		    					"<td>"+((currentPage-1)*25+i+1)+"</td>"+
   		    					"<td>"+getIsNull(d.equ_nam)+"</td>"+
   				              	"<td>"+getIsNull(d.app_mod)+"</td>"+
   				              	"<td>"+getIsNull(d.pws_nam)+"</td>"+
   				              	"<td>"+getIsNull(d.ins_add)+"</td>"+
   				              	"<td>"+getIsNull(d.pro_tim)+"</td>"+
   				              	"<td><a  class='layer XGJCSB_QX' data-url='<%=basePath%>commens/xtgl/jcsbwh/edit.htm?id="+d.id+"' data-title='修改' data-height='450px' data-height='650px'  href='javascript:void(0);' >修改 </a>"+
   				              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a class='layer' data-url='<%=basePath%>commens/xtgl/jcsbwh/detal.htm?id="+d.id+"' data-title='详细' data-height='450px' data-height='650px'  href='javascript:void(0);' >详细</a>"+
   				              	"<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a class='SCJCSB_QX' href='javascript:void(0);' onclick='del("+d.id+")'>删除</a>"+
   				              	"</tr>";
   	    			 }
       				 $("#datalist").html(htmls); 
       	    		 $(".tcdPageCode").createPage({
    				        pageCount:countAll,
    				        current:currentPage,
    				        backFn:function(p){
    				        	currentPage = p ;
    				        	getData(curParam);
    				        }
    				 });
       	    		 
       	    		 $("#datalist").createQx();
       			 }else{
       				 htmls +=  "<tr><td colspan='8'>暂无数据</td></tr>";
       				 $("#datalist").html(htmls); 
       	    		 $(".tcdPageCode").empty();
       			 }
   	    		 
   	    		layer.close(indexlayer);
			} else {

				layer.close(indexlayer);
               layer.alert(data.desc);
			}
    	}
    })
}

function getAppType(val){
	 if(val != "0" && val != undefined){
		 var param = "app_typ_ide="+val;
			$.ajax({
		    	url:url+"getBasAppByAppTypIde.htm",
		    	data : param,
		    	dataType:"json",
		    	type:"post",
		    	success:function(data){
		    		if (data.resultcode=="USR000") {
		    			 var htmls = "<option value='qxz'>-设备型号-</option>";
		    			 if(data.data){
		    				 if(data.data.length > 0 ){
		        				 for(var i = 0; i< data.data.length ; i++){
		    		    				var d =  data.data[i];
		    		    				htmls +=  "<option value='"+d.id+"'>"+d.app_mod+"</option>";
		    	    			 }
		        				 $("#app_id").html(htmls); 
		        			 } 
		    			 } 
					} else {
		               layer.alert(data.desc);
					}
		    	}
		    })
	 }
}
 
function del(id){
	layer.confirm("确定删除？",function(){
		$.ajax({
	    	url:url+"delectEquInfo.htm",
	    	data : "equ_id="+id,
	    	dataType:"json",
	    	type:"post",
	    	success:function(data){
	    		if (data.resultcode=="USR000") {
	   	    		layer.alert("删除成功");
	   	    		currentPage = 1;
	   	    		getData();
				} else {
	               layer.alert(data.desc);
				}
	    	}
	    })
	})
} 
 

</script>
</body>
</html>
 
