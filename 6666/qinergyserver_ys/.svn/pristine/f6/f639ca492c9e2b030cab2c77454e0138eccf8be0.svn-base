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
<title>电站配置</title>
<link rel="stylesheet" type="text/css"	href="<%=basePath%>css/style.css?pubVersion=201802070001">
<link rel="stylesheet" type="text/css"	href="<%=basePath%>css/common.css?pubVersion=201802070001">
</head>
<body> 
<input type="hidden" id="userId" value="${user.id}" >
  <input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  <input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
 <!-- viewFramework   -->
  <div class=viewFramework> 
  		<input type="hidden" id="userId" value="${user.id}" >
		<input type="hidden" id="use_typ" value="${user.use_typ}" >
		<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
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
	        	   			  <select class="fl quinput w20"   id="companyPws" style="margin-left:22px;display:none;"   >
	        	   			 	<option value="qxz">请选择电站</option>
	        	   			 </select>
	        	   			 <input type="button" value="查询" class="querybut" onclick="currentPage = 1 ; getData();">
			          </div>
	            </div>
	      	</div>
        </div>
        <div class="bge  pr8 pt10 pl8" style="padding-bottom:8px;">
		     <div class="bg-ff pb18 pl15 pt10 clr pl8">
		        <div class="query">
		          <!-- <div class="fl">
		          	<input type="text" value="" placeholder="请输入编号" class="fl quinput">
		          	<input type="button" value="查询" class="querybut">
		          </div>
		          <div class="fl">
		          	<input type="text" value=""  class="fl quinput ml15 Wdate" onFocus="WdatePicker()">
		          	<span class="fl ml5 ">&nbsp;&nbsp;-</span>
		          	<input type="text"  class="fl quinput ml15 Wdate" onFocus="WdatePicker()">
		          </div> -->
		          <div class="fr mr15">
		            <a class="queryicon DZPZXJDZ"   onclick="return add();"   ><i class="add"></i>添加电站</a>
		          </div>
		        </div>
		     </div>
	    	 <div  class=" pl8 pr8 pb18 bg-ff pt10">
				<div class="clr wauto" >
					<table  width="100%"  border="0" cellpadding="0" cellspacing="0" class="table-list">
			            <tr>
			              <th>序号</th>
			              <th>电站名称</th>
			              <th>业主名称</th>
			              <th>电站状态</th>
			              <th>电站类型</th>
			              <th>运营类型</th>
			              <th>地址</th>
			              <th>操作</th>
			            </tr>
						<tbody id="datalist">
							<tr><td colspan="8">暂无数据</td></tr>
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
//设置宽高
var ScreenWidth  = (document.documentElement.clientWidth);  
//设置地图高
$(".wauto").css("width",ScreenWidth-30);

var tab = $('.table-list');
var td = $(tab.find('tr')[0]).find('th');
if(td.length * 90 > ScreenWidth-10){ // 300是td的平均值，800是table外div的宽度，如果大于这个就给table一个宽度
	tab[0].width = td.length * 90;
}

$(function(){
	getCompanyOne();
})

function add(){
	var companyThree = $("#companyThree").val();
	if(companyThree == "qxz"  || companyThree == undefined){
		 layer.alert("请选择三级公司");
		 return;
	}else{
		var checkCom = '';
		var companyOne = $("#companyOne").val();
		var companyTwo = $("#companyTwo").val();
		var companyThree = $("#companyThree").val();
		if(companyThree == "qxz"  || companyThree == undefined){
			if(companyTwo == "qxz"  || companyTwo == undefined){
				if(companyOne != "qxz"  &&  companyOne != undefined){
					checkCom = companyOne ;
				} 
			}else{
				checkCom = companyTwo ;
			}
		}else{
			checkCom = companyThree ;
		}
		
		layer.open({
		  type: 2,
		  skin: 'layer-class' ,
		  title: "新增电站",
		  shadeClose: false,
		  area: ['770px','450px'],
		  content: "<%=basePath%>/commens/xtgl/dzpz/add.htm?id="+checkCom
		});
	}
}
var countAll = 0;
var currentPage  = 1;
function getData(param2){
	var curParam = "" ;
	if(param2 != undefined){
		curParam = param2 ;
	}else{
		var companyOne = $("#companyOne").val();
		if(companyOne == "qxz"  || companyOne == undefined){
			 layer.alert("请至少选择一级公司");
			 return;
		}
		
		var checkCom = '';
		var companyOne = $("#companyOne").val();
		var companyTwo = $("#companyTwo").val();
		var companyThree = $("#companyThree").val();
		if(companyThree == "qxz"  || companyThree == undefined){
			if(companyTwo == "qxz"  || companyTwo == undefined){
				if(companyOne != "qxz"  &&  companyOne != undefined){
					checkCom = companyOne ;
				} 
			}else{
				checkCom = companyTwo ;
			}
		}else{
			checkCom = companyThree ;
		}
		
		curParam  += "com_id="+checkCom ;
	}
	
	var param = curParam+"&currentPage="+currentPage;
	
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});

	$.ajax({
    	url:url+"getPwsInfLst.htm",
    	data : param,
    	dataType:"json",
    	type:"post",
    	success:function(data){
    		if (data.resultcode=="USR000") {
    			 var html = "";
   				 if(data.data.length > 0 ){
   					countAll = data.totalPage;
					currentPage = data.currentPage;
					BasChsData=data.data;
					   for (var i = 0; i < BasChsData.length; i++) {
						   switch (BasChsData[i].ope_typ) {
								case 1:
									ope_typ="独立运维"
									break;
								case 2:
									ope_typ="统一运维"
									break;
								default:
									break;
							}
							   
							switch (BasChsData[i].cur_sta) {
								case 1:
									chsTyp="计划"
									break;
								case 2:
									chsTyp="在建"
									break;
								case 3:
									chsTyp="投运"
									break;
								default:
									break;
							}
						   html+=(        	
				   						'<tr id="'+BasChsData[i].id+'"><td>'+(i+1)+'</td>'+
				     				    '<td><span>'+getIsNull(BasChsData[i].pws_nam )+'</span></td>'+
				     				    '<td><span>'+getIsNull(BasChsData[i].own_nam)+'</span></td>'+
				     				    '<td><span>'+chsTyp+'</span></td>'+
				     				    '<td><span>'+getIsNull(BasChsData[i].pws_typ_nam)+'</span></td>'+
				     				    '<td><span>'+ope_typ+'</span></td>'+
				     				    '<td><span>'+BasChsData[i].pro_nam+BasChsData[i].cit_nam+BasChsData[i].are_nam+BasChsData[i].pws_add+'</span></td>'+
				   				        '<td><a href="javascript:void(0);" id="'+BasChsData[i].id+'" data-url="'+jumpPageUrl+'commens/xtgl/dzpz/edit.htm?id='+BasChsData[i].id+'" class="layer DZPZXGDZ" data-height="500px" data-width="650px" data-title="电站修改" >修改</a><span>&nbsp;&nbsp; |&nbsp;&nbsp;</span>'+
				   				        '<a href="javascript:void(0);" id="'+BasChsData[i].id+'" data-url="'+jumpPageUrl+'commens/xtgl/dzpz/detal.htm?id='+BasChsData[i].id+'" class="layer" data-height="500px" data-width="650px" data-title="详细" >详细</a><span>&nbsp;&nbsp; |&nbsp;&nbsp;</span>'+
				   				        '<a href="javascript:void(0);" id="'+BasChsData[i].id+'" data-url="'+jumpPageUrl+'commens/xtgl/dzpz/addlogo.htm?id='+BasChsData[i].id+'" class="layer DZPZSCTP" data-height="500px" data-width="650px" data-title="上传图片" >上传图片</a><span>&nbsp;&nbsp; |&nbsp;&nbsp;</span>'+
				                             '<a href="javascript:void(0);" class="DZPZSCDZ" onclick="del('+BasChsData[i].id+')">删除</a></td></tr>'
				   				      )
					 }
					 
					   $(".tcdPageCode").createPage({
					        pageCount:countAll,
					        current:currentPage,
					        backFn:function(p){
					        	currentPage = p;
					        	getData(curParam);
					        }
				    	});
			   }else{
				   html +=  "<tr><td colspan='8'>暂无数据</td></tr>";
				   $(".tcdPageCode").empty();
			   } 
  	    		$("#datalist").html(html); 
  	    		layer.close(indexlayer);
  	    		$("#datalist").createQx();
			} else {
               layer.alert(data.desc);
			}
    	}
    })
}
	
	function del(id){
		layer.confirm("确定删除？",function(){
			$.ajax({
		    	url:url+"delectPwsInfo.htm",
		    	data : "pws_id="+id,
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
</script>
</body>
</html>
 
