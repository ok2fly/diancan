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
<title>地区信息管理</title>
<link rel="stylesheet" type="text/css"	href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css"	href="<%=basePath%>css/common.css?pubVersion=201802070001">
</head>
<body> 
<input type="hidden" id="userId" value="${user.id}" >
  <input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  <input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
 <!-- viewFramework   -->
  <div class=viewFramework> 
     <div class="bg-ff pb18 pl15 pt10 clr pl8">
        <div class="query">
          <div class="fl">
          	 <select class="fl quinput" id="sheng"  style="margin-right: 20px;"  onchange="getShi(this.value)">
           	 	<option value='0'>--请选择--</option>
            </select> 
          	 <select class="fl quinput" id="shi"  style="margin-right: 20px;"  onchange="getQu(this.value)">
            <option value='0'>--请选择--</option>
           </select> 
          </div>
          <div class="fr mr15">
            <a class="queryicon layer XJDQ_QX"     id="xinzeng"   data-title="新增地区"   ><i class="add"></i>添加地区</a>
          </div>
        </div>
      </div>
	  <div  class="mt15 pl8 pr8 pb18 bg-ff pt10">
			<div class="clr wauto" style="overflow-x:scroll">
				<div>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-list">
		            <tr>
		              <th width="5%">序号</th>
		              <th width="5%">区域名称</th>
		              <th width="5%">区域简称</th>
		              <th width="10%">上级区域名称</th>
		              <th width="10%">操作</th>
		            </tr>
		             <tbody id="shuju">
			            <tr>
			              <td colspan="6">暂无数据</td>
			            </tr>             
		            </tbody>   
		         </table>
		         </div>
	        </div>
       </div>
       <div class="tcdPageCode" ></div>
       <div class="blank0"></div>
  </div>
   <!-- ./ viewFramework --> 
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>

<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.qx.js?pubVersion=201802070001"></script>
<script>
var sheng="";
var shi = "";
$(function() {
	getSheng();
	
	/* $("#xinzeng").click(function(){
		layer.open({
			  type: 2,
			  skin: 'layer-class' ,
			  title: '地区管理',
			  shadeClose: false,
			  area: ["600px","350px"],
			  content: $("#xinzeng").attr("data-url") //iframe的url
		});
	})  */
})

function getSheng(){
	$("#xinzeng").attr("data-url","<%=basePath%>commens/xtgl/dqxxgl/add.htm?reg_ide=0&tim=1");
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	$.ajax({                
		type : "post",
		url: url + "getBasRegLst1LevAll.htm",
		success: function(data){            
			layer.close(indexlayer); //关闭 loading 
			if('USR000' == data.resultcode){
				var html = "<option value='0' >-请选择-</option>";
				/* var htmlTr = ""; */
				$.each(data.data,function(index,reg){
					html += "<option value="+reg.id+" >"+reg.reg_nam+"</option>"
					/* htmlTr +=' <tr> '+
						 ' <td>'+(index+1)+'</td> '+
						 '  <td>'+reg.reg_nam+'</td>'+
						 '  <td>'+reg.fir_let+'</td>'+
						 ' <td>中国</td>'+
						 ' <td></td>'+
						 ' <td><a href="javascript:void(0);" onclick="del('+reg.id+',1)">删除</a></td>'+
		           		 '  </tr>  '; */
				})
			/* 	if(data.data.length == 0){
					htmlTr = "<tr><td colspan='6'>暂无数据</td></tr>"
				} */
				$("#sheng").empty().append(html);
				/* $("#shuju").empty().append(htmlTr); */
				
			}else{
				layer.alert(data.desc);
			}
		}
	});
	getShengPageData();
	
	
}

function getShi(reg_ide){
	var html = "<option value='0' >-请选择-</option>";
	if("0" == reg_ide){
		$("#shi").empty().append(html);
		getSheng();
		return ;
	}
	sheng = reg_ide;
	$("#xinzeng").attr("data-url","<%=basePath%>commens/xtgl/dqxxgl/add.htm?reg_ide="+sheng+"&tim=2");
	
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	$.ajax({                
		type : "post",
		url: url + "getBasRegInfBySubId.htm",
		data : "id="+reg_ide ,
		success: function(data){               
			layer.close(indexlayer); //关闭 loading 
			if('USR000' == data.resultcode){
				/* var htmlTr = ""; */
				$.each(data.data,function(index,reg){
					html += "<option value="+reg.id+">"+reg.reg_nam+"</option>"
					/* htmlTr +=' <tr> '+
					 ' <td>'+(index+1)+'</td> '+
					 '  <td>'+reg.reg_nam+'</td>'+
					 '  <td>'+reg.fir_let+'</td>'+
					 ' <td>'+reg.reg_nam+'</td>'+
					 ' <td></td>'+
					 ' <td><a href="javascript:void(0);" onclick="del('+reg.id+',2)">删除</a></td>'+
	           		 '  </tr>  '; */
				})
				/* if(data.data.length == 0){
					htmlTr = "<tr><td colspan='6'>暂无数据</td></tr>"
				} */
				$("#shi").empty().append(html);
				/* $("#shuju").empty().append(htmlTr); */
			}else{
				layer.alert(data.desc);
			}
		}
	});
	getShiPageData(reg_ide);
}

 

function getQu(reg_ide){
	if("0" == reg_ide){
		getShi(sheng);
		return ;
	}
	shi = reg_ide;
	$("#xinzeng").attr("data-url","<%=basePath%>commens/xtgl/dqxxgl/add.htm?reg_ide="+reg_ide+"&tim=3");
	var param = "id="+reg_ide;
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	$.ajax({                
		type : "post",
		url: url + "getBasRegInfBySubId.htm",
		data : param ,
		success: function(data){     
			layer.close(indexlayer); //关闭 loading 
			if('USR000' == data.resultcode){
				var htmlTr = "";
				if(data.data.length == 0){
					htmlTr = "<tr><td colspan='6'>暂无数据</td></tr>"
				}else{
					countAll = data.totalPage;
					currentPage = data.currentPage;
					$.each(data.data,function(index,reg){
						htmlTr +=' <tr> '+
						 ' <td>'+(index+1)+'</td> '+
						 ' <td>'+getIsNull(reg.reg_nam)+'</td>'+
						 ' <td>'+getIsNull(reg.fir_let)+'</td>'+
						 ' <td>'+getIsNull(reg.reg_fat_id)+'</td>'+
						 ' <td><a  class="layer XGDQ_QX"  data-url="<%=basePath%>commens/xtgl/dqxxgl/edit.htm?id='+reg.id+'" data-title="修改" data-height="200px"  href="javascript:void(0);" >修改 </a>'+
						 '<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a href="javascript:void(0);" class="SCDQ_QX" onclick="del('+reg.id+',3)">删除</a></td>'+
		           		 '  </tr>  ';
					})
					$(".tcdPageCode").createPage({
				        pageCount:countAll,
				        current:currentPage,
				        backFn:function(p){
				        	 getQuPageData(param,p);
				        }
				    });
				}
				/* $("#qu").empty().append(html); */
				$("#shuju").empty().append(htmlTr);
				$("#shuju").createQx();
			}else{
				layer.alert(data.desc);
			}
		}
	});
}

var countAll = 0;
var currentPage  = 1;
/*获取区的分页数据*/
function getQuPageData(param,p){	
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});

	$.ajax({                
		type : "post",
		url: url + "getBasRegInfBySubId.htm",
		data : param +"&currentPage="+p,
		success: function(data){              
			layer.close(indexlayer); //关闭 loading 
			if('USR000' == data.resultcode){
				countAll = data.totalPage;
				currentPage = data.currentPage;
					
				var htmlTr = "";
				var htmlTr2= 10*(parseInt(p)-1) ;											
					$.each(data.data,function(index,reg){
						htmlTr +=' <tr> '+
						 ' <td>'+(htmlTr2+index+1)+'</td> '+
						 ' <td>'+reg.reg_nam+'</td>'+
						 ' <td>'+reg.fir_let+'</td>'+
						 ' <td>'+reg.reg_fat_id+'</td>'+
						 ' <td><a  class="layer XGDQ_QX"  data-url="<%=basePath%>commens/xtgl/dqxxgl/edit.htm?id='+reg.id+'" data-title="修改" data-height="200px"  href="javascript:void(0);" >修改 </a>'+
						 ' <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a href="javascript:void(0);"  class="SCDQ_QX"  onclick="del('+reg.id+',3)">删除</a></td>'+
		           		 '  </tr>  ';
					})
				
				if(htmlTr != ""){
					$("#shuju").empty().append(htmlTr);
					$(".tcdPageCode").createPage({
					        pageCount:countAll,
					        current:currentPage,
					        backFn:function(p){
					        	getQuPageData(param,p);
					        }
				    	});
					$("#shuju").createQx();
				}else{
					$("#shuju").empty().append("<tr><td colspan='6'>暂无数据</td></tr>");
					$(".tcdPageCode").empty();
				}
				
			}else{
				layer.alert(data.desc);
			}
		}
	});
}
var countAll2 = 0;
var currentPage2  = 1;
function getShiPageData(reg_ide){

	var param = "&currentPage="+currentPage2;

	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	$.ajax({                
		type : "post",
		url: url + "getBasRegInfBySubId.htm",
		data : param+"&id="+reg_ide ,
		success: function(data){               
			layer.close(indexlayer); //关闭 loading 
			if('USR000' == data.resultcode){
				countAll2 = data.totalPage;
				currentPage2 = data.currentPage;
				var htmlTr = "";
				$.each(data.data,function(index,reg){
					htmlTr +=' <tr> '+
					 ' <td>'+(index+1)+'</td> '+
					 '  <td>'+getIsNull(reg.reg_nam)+'</td>'+
					 '  <td>'+getIsNull(reg.fir_let)+'</td>'+
					 ' <td>中国</td>'+
					 ' <td><a  class="layer XGDQ_QX"  data-url="<%=basePath%>commens/xtgl/dqxxgl/edit.htm?id='+reg.id+'" data-title="修改" data-height="200px"  href="javascript:void(0);" >修改 </a>'+
					 ' <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a href="javascript:void(0);" class="SCDQ_QX"  onclick="del('+reg.id+',2)">删除</a></td>'+
	           		 '  </tr>  ';
				})
				 
				
				if(htmlTr != ""){
					$("#shuju").empty().append(htmlTr);
					$(".tcdPageCode").createPage({
	 				        pageCount:countAll2,
	 				        current:currentPage2,
	 				        backFn:function(p){
	 				        	currentPage2 = p;
	 				        	getShiPageData(reg_ide);
	 				        }
	 			    	});
					$("#shuju").createQx();
				}else{
					$("#shuju").empty().append("<tr><td colspan='6'>暂无数据</td></tr>");
					$(".tcdPageCode").empty();
				}
				
				
			}else{
				layer.alert(data.desc);
			}
		}
	});
}

var countAll3 = 0;
var currentPage3  = 1;
function getShengPageData(){
	var param = "&currentPage="+currentPage3;
	
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	
	$.ajax({                
		type : "post",
		url: url + "getBasRegLst1Lev.htm",
		data : param,
		success: function(data){            
			layer.close(indexlayer); //关闭 loading 
			if('USR000' == data.resultcode){
				countAll3 = data.totalPage;
				currentPage3 = data.currentPage;
				var htmlTr = "";
				$.each(data.data,function(index,reg){
					
					htmlTr +=' <tr> '+
						 ' <td>'+(index+1)+'</td> '+
						 '  <td>'+getIsNull(reg.reg_nam)+'</td>'+
						 '  <td>'+getIsNull(reg.fir_let)+'</td>'+
						 ' <td>中国</td>'+
						 ' <td><a  class="layer XGDQ_QX"  data-url="<%=basePath%>commens/xtgl/dqxxgl/edit.htm?id='+reg.id+'" data-title="修改" data-height="200px"  href="javascript:void(0);" >修改 </a>'+
						 ' <span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a href="javascript:void(0);" class="SCDQ_QX"  onclick="del('+reg.id+',1)">删除</a></td>'+
		           		 '  </tr>  ';
				})
				
				
				if(htmlTr != ""){
					$("#shuju").empty().append(htmlTr);
					$(".tcdPageCode").createPage({
					        pageCount:countAll3,
					        current:currentPage3,
					        backFn:function(p){
					        	currentPage3 = p;
					        	getShengPageData();
					        }
				    	});
					$("#shuju").createQx();
				}else{
					$("#shuju").empty().append("<tr><td colspan='6'>暂无数据</td></tr>");
					$(".tcdPageCode").empty();
				}
				
				
			}else{
				layer.alert(data.desc);
			}
		}
	});
}

function del(id,flag){
	layer.confirm("确定删除？",function(){
		$.ajax({                
			type : "post",
			url: url + "delReg.htm",
			data : "reg_id="+id ,
			success: function(data){                          
				if('USR000' == data.resultcode){
					layer.alert("删除成功");
					if(flag == "1"){
						getSheng();
					}else if(flag == "2"){
						getShi(sheng);
					}else if(flag == "3"){
						getQu(shi);
					} 
				}else{
					layer.alert(data.desc);
				}
			}
		});
	});
}
</script>
</body>
</html>
 
