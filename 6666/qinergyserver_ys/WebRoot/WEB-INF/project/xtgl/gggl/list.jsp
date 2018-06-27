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
<title>公告管理</title>
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
          	  <input type="text" value="" placeholder="请输入公告内容"  id="ann_cont" class="fl quinput">
          	  <select  class="fl quinput ml15" id="ann_typ">
          	  	<option value="qxz">请选择</option>
          	  	<option value="1">播出</option>
          	  	<option value="2">不播出</option>
          	  </select>
          	 <input type="button" value="查询" class="querybut">
          </div>
          <div class="fr mr15">
            <a class="queryicon layer XJGG_QX"  data-url="<%=basePath%>commens/xtgl/gggl/add.htm" data-title="添加公告" data-height="300px"  ><i class="add"></i>添加公告</a>
          </div>
        </div>
      </div>
	  <div  class="mt15 pl8 pr8 pb18 bg-ff pt10">
			<div class="clr wauto">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-list">
		            <tr>
		              <th width="5%">序号</th>
		              <th width="5%">公告内容</th>
		              <th width="5%">公告状态</th>
		              <th width="5%">公告排序号</th>
		              <th width="10%">备注</th>
		              <th width="10%">操作</th>
		            </tr>
		             <tbody id="shuju">
			            <tr>
			              <td colspan="6">暂无数据</td>
			            </tr>             
		            </tbody>   
		         </table>
	        </div>
		    <div class="tcdPageCode" id="tcdPageCode1"></div> 
       </div>
       <div class="blank0"></div>
  </div>
   <!-- ./ viewFramework --> 
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script src="<%=basePath%>js/jquery.qx.js?pubVersion=201802070001"></script>
<script>
$(function() {
	
	$(".querybut").click(function(){
		currentPage  = 1;
		getData();
	});
	getData();
})

var countAll = 0;
var currentPage  = 1;
function getData(param2){
	
	var curParam = "" ;
	if(param2 != undefined){
		curParam = param2 ;
	}else{
		var ann_cont = $("#ann_cont").val();
		var ann_typ = $("#ann_typ").val();
		if(ann_cont != "" && ann_cont != undefined){
			curParam += "&&ann_cont="+ann_cont;
		}
		if(ann_typ != "" && ann_typ != undefined && ann_typ != 'qxz'){
			curParam += "&&ann_typ="+ann_typ;
		}
		
	}
	
	 
	
	
	var param = curParam + "&&currentPage="+currentPage;
	param = substringParam(param);
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	$.ajax({                
		type : "post",
		url: url + "getAnnInfLst.htm",
		data : param,
		success: function(data){  
			layer.close(indexlayer);
			if('USR000' == data.resultcode){
				countAll = data.totalPage;
				currentPage = data.currentPage;
				var htmlTr = "";
				$.each(data.data,function(index,d){
					var s  = d.ann_typ == 1 ?"播出":"不播出";
					htmlTr +=' <tr> '+
						 '  <td>'+(index+1)+'</td>'+
						 '  <td>'+getIsNull(d.ann_cont)+'</td>'+
						 '  <td>'+s+'</td>'+
						 '  <td>'+getIsNull2(d.ann_sort)+'</td>'+
						 '  <td>'+getIsNull(d.remark) +'</td>'+
						 ' <td><a href="javascript:void(0);" id="'+d.id+'" data-height="300px"  data-url="'+jumpPageUrl+'commens/xtgl/gggl/edit.htm?id='+d.id+'" class="layer XGGG_QX" data-height="500px" data-width="650px" data-title="公告修改" >修改</a><span>&nbsp;&nbsp; |&nbsp;&nbsp;</span>'+
						 ' <a href="javascript:void(0);" class="SCGG_QX" onclick="del('+d.id+')">删除</a></td>'+
		           		 '  </tr>  ';
				})
				 
				if(htmlTr != ""){
					 $("#shuju").empty().append(htmlTr);
					 $("#tcdPageCode1").createPage({
					        pageCount:countAll,
					        current:currentPage,
					        backFn:function(p){
					        	currentPage = p;
					        	getData(curParam);
					        }
				    	});
					 $("#shuju").createQx();
				}else{
					$("#shuju").empty().append("<tr><td colspan='6'>暂无数据</td></tr>");
					$("#tcdPageCode1").empty();
				}
				
			}else{
				layer.alert(data.desc);
			}
		}
	});
}
 
function del(id){
	layer.confirm("确定删除？",function(){
		$.ajax({                
			type : "post",
			url: url + "delAnnInf.htm",
			data : "ann_id="+id ,
			success: function(data){                          
				if('USR000' == data.resultcode){
					currentPage  = 1;
					layer.msg("删除成功");
					getData();
					window.parent.getData();
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
 
