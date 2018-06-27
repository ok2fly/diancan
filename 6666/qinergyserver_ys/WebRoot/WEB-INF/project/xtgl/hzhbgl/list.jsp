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
  	 <input type="hidden" value="${user.id}" id="userId" >
  	   <input type="hidden" id="menu_id" name="menu_id" value="${menu_id}" >
  <input type="hidden" id="is_button" name="is_button" value="${is_button}"  >
     <div class="bg-ff pb18 pl15 pt10 clr pl8">
        <div class="query">
        	<div class="fl">
		        <select class="fl quinput" id="fl_qusele_qu1" style="display:none;">
		            <option value="0">--请选择一级公司--</option>
		        </select>
	            <select class="fl quinput" id="fl_qusele_qu2"  onchange="getDesc(this.value)">
	               	<option value="0">--请选择二级公司--</option>
	            </select>
          </div>
          <div class="fr mr15">
            <a class="queryicon  xzzz XJHZHB_QX"  data-url="<%=basePath%>/commens/xtgl/hzhbgl/add.htm?id=0&level=1" data-title="新增合作伙伴"  onclick="addOrg(this)" ><i class="add"></i>添加合作伙伴</a>
          </div>
        </div>
      </div>
	  <div  class="pl8 pr8 pb18 bg-ff pt10">
			<div class="clr wauto" style="overflow-x:scroll">
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="table-list zjjg">
		           <tr>
		              <th>序号</th>
		              <th>公司名称</th>
		              <th>联系人</th>
		              <th>联系电话</th>
		              <th>公司地址</th>
		              <th>操作</th>
		            </tr>
		            <tbody id="jigou">
		           		 <tr><td colspan="21">暂无数据</td></tr>
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
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.qx.js?pubVersion=201802070001"></script>
<script>

//设置宽高
var ScreenWidth  = (document.documentElement.clientWidth);  
//设置地图高
$(".wauto").css("width",ScreenWidth-20);

var tab = $('.zjjg');
var td = $(tab.find('tr')[0]).find('th');
if(td.length * 90 > ScreenWidth-10){ // 300是td的平均值，800是table外div的宽度，如果大于这个就给table一个宽度
	tab[0].width = td.length * 90;
}
 
var menuButData = [];

$(function() {
	getCom();
});

//一级公司选中的值
var laId ;
//当前选中的级别
var checkLevel = 1 ;
//选中的下拉框公司  查询部门
var checkId = "";


function getCom(){
	var userId = $("#userId").val();
	$.ajax({                
		type : "post",
		url: url + "getOrgFatComInfByComId.htm",
		data : "id="+userId+"&com_rol=2&com_lev="+checkLevel+"&com_fat_id="+checkId,
		success: function(data){                          
			if('USR000' == data.resultcode){
				var html = [];
				html[html.length] = "<option value='0'>--请选择一级公司--</option>";
				if(data.data.length > 0 ){
					$.each(data.data,function(index,org){
						html[html.length] = "<option value='"+org.id+"'  >"+org.com_nam+"</option>";
					});
				}
				$("#fl_qusele_qu1").empty().append(html.join(""));
				 
				 
				if(data.data.length > 0 ){
					getXj(data.data[0].id);
				}
				
			}else{
				layer.alert('数据解析错误');
			}
			
		}
	});
}


function getXj(id){
	var userId = $("#userId").val();
	if(id == '0'){
		$("#fl_qusele_qu2").empty().append("<option value='0'>--请选择二级公司--</option>");
		$(".xzzz").attr("data-url","<%=basePath%>commens/xtgl/hzhbgl/add.htm?id=0&level=1");
		checkId = 0 ;
		checkLevel = 1 ;
		getCom();
		return;
	}		
	
	checkId = id;
	checkLevel = 2 ; 
	laId = id ;
	
	
	$.ajax({                
		type : "post",
		url: url + "getOrgFatComInfByComId.htm",
		data : "id="+userId+"&com_rol=2&com_lev="+checkLevel+"&com_fat_id="+checkId,
		success: function(data){                          
			if('USR000' == data.resultcode){
				var html = [];
				html[html.length] = "<option value='0'>--请选择二级公司--</option>";
				if(data.data.length > 0 ){
					$.each(data.data,function(index,org){
						html[html.length] = "<option value='"+org.id+"'  >"+org.com_nam+"</option>";
					});
				}
				$("#fl_qusele_qu2").empty().append(html.join(""));
				 
				refreshTable(data.data);
				
				$(".xzzz").attr("data-url","<%=basePath%>commens/xtgl/hzhbgl/add.htm?id="+id+"&level=2");
				
			}else{
				layer.alert('数据解析错误');
			}
			
		}
	});
	
}


function getDesc(id){
	var userId = $("#userId").val();
	if(id == "0"){
		getXj(laId);
		return;
	}else{
		checkId = id; 
		checkLevel = 3 ;
		$.ajax({                
			type : "post",
			url: url + "getOrgFatComInfByComId.htm",
			data : "id="+userId+"&com_rol=2&com_lev="+checkLevel+"&com_fat_id="+checkId,
			success: function(data){                          
				if('USR000' == data.resultcode){
					refreshTable(data.data);
					
					$(".xzzz").attr("data-url","<%=basePath%>commens/xtgl/hzhbgl/add.htm?id="+id+"&level=3");
				}else{
					layer.alert('数据解析错误');
				}
				
			}
		});
	}
}

 
function clearTable(){
	$("#jigou").empty().append("<tr><td colspan = '21' >暂无数据</td></tr>");
}
 

//刷新表格数据 单位和部门列表
var basSciList;
var countAll1 = 0;
var currentPage1  = 1;
var everyPageCount1 = 25 ;

function refreshTable(data){
	if(data == null || data == undefined ){
		clearTable();
		return ; 
	}
	
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	
	//下级公司列表
	basSciList = data;
	var html = "";
	if(basSciList.length > 0 ){
		for(var i = 0 ;i < basSciList.length ; i++){
			var basSci = basSciList[i];
			var state =  "" ;
			if(basSci.com_sta == 1){
				 state =  "可用"  ;
			}else{
				 state =  "不可用" ;
			}
			
			if(i<(currentPage1*everyPageCount1)){
				html  +=   "<tr>"+        
				  "<td>"+(i+1)+"</td>"+
				  "<td>"+getIsNull(basSci.com_nam)+"</td>"+
	              "<td>"+getIsNull(basSci.com_con)+"</td>"+
	              "<td>"+getIsNull(basSci.com_tel)+"</td>"+
	              "<td>"+basSci.pro_nam+basSci.cit_nam+basSci.are_nam+basSci.com_add+"</td>"+
        		   "<td><a href='#' target='_self' class='layer ZZXGGS' data-title='组织机构修改'  data-url='"+jumpPageUrl+"commens/xtgl/hzhbgl/edit.htm?id="+basSci.id+"' >修改</a>"+
   		 	   "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a href='#' target='_self' class='layer ZZXGGS' data-title='组织机构修改'  data-url='"+jumpPageUrl+"commens/xtgl/hzhbgl/detal.htm?id="+basSci.id+"' >详细</a>"+ 
        		 "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a href='#' target='_self' class='layer ZZSCTB' data-title='上传图标' data-height='200px' data-url='"+jumpPageUrl+"commens/xtgl/hzhbgl/addlogo.htm?id="+basSci.id+"' >上传图标</a>"+	   
   		 	   "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='ZZSCGS' href='#'id='"+basSci.id+"' onclick=delThis(this) target='_self'>删除</a>"+ 
   		 	    "</td>"+
   		 	    "</tr>";
			} 
			
		}
		
	}else{
		html += "<tr><td colspan = '21' >暂无数据</td></tr>";
	}
	$("#jigou").empty().append(html);
	
	countAll1=0;
	if(basSciList.length/everyPageCount1>parseInt(basSciList.length/everyPageCount1)){
		countAll1=parseInt(basSciList.length/everyPageCount1)+1;
	}else{
		countAll1=parseInt(basSciList.length/everyPageCount1);
	};
	 $("#tcdPageCode1").createPage({
	        pageCount:countAll1,
	        current:currentPage1,
	        backFn:function(p){
	        	currentPage1 = p;
	        	getPagedData1();
	        }
  	});
	$("#jigou").createQx();
	 
			
	var tab = $('.zjjg');
	var td = $(tab.find('tr')[1]).find('td');
	if(td.length * 100 > ScreenWidth-10){ // 300是td的平均值，800是table外div的宽度，如果大于这个就给table一个宽度
		tab[0].width = td.length * 100;
	}
	layer.close(indexlayer); //关闭 loading 
}

function getPagedData1(){
	var indexlayer = layer.load(1, {
		  shade: [0.5,'#fff'] //0.1透明度的白色背景
	});
	var html="";
	var max = 0 ;
	
	 if ( (currentPage1*everyPageCount1) >  basSciList.length-1 ){
		 max = basSciList.length; 
	 }else{
		 max = (currentPage1*everyPageCount1) ;
	 }
	 
	 for(var i=((currentPage1-1)*everyPageCount1);i<max;i++){
		 var basSci = basSciList[i];
		 html  +=   "<tr>"+        
		  "<td>"+(i+1)+"</td>"+
		  "<td>"+getIsNull(basSci.com_nam)+"</td>"+
         "<td>"+getIsNull(basSci.com_con)+"</td>"+
         "<td>"+getIsNull(basSci.com_tel)+"</td>"+
         "<td>"+basSci.pro_nam+basSci.cit_nam+basSci.are_nam+basSci.com_add+"</td>"+
		   "<td><a href='#' target='_self' class='layer ZZXGGS' data-title='组织机构修改'  data-url='"+jumpPageUrl+"commens/xtgl/hzhbgl/edit.htm?id="+basSci.id+"' >修改</a>"+
	 	   "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a>详细</a>"+ 
		 "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a href='#' target='_self' class='layer ZSCTB' data-title='上传图标' data-height='200px' data-url='"+jumpPageUrl+"commens/xtgl/hzhbgl/addlogo.htm?id="+basSci.id+"' >上传图标</a>"+	   
	 	   "<span>&nbsp;&nbsp;|&nbsp;&nbsp;</span><a  class='ZZSCGS' href='#'id='"+basSci.id+"' onclick=delThis(this) target='_self'>删除</a>"+ 
	 	    "</td>"+
	 	    "</tr>";
	 }
	 $("#jigou").empty().append(html);
	 layer.close(indexlayer);  //关闭 loading 

}

 

function refreshData(){
	currentPage1=1;
	if(checkLevel == 1){
		getCom();
	}else if(checkLevel == 2){
		getXj(checkId);
	}else if(checkLevel == 3){
		getDesc(checkId);
	}
}

function delThis(key){
	var keys=$(key).attr("id");	
	layer.confirm("确定删除？",function(){
		$.ajax({
			url:url+"delComLev.htm",
			type:"post",
			data:"id="+keys,
			dataType:"json",
			success:function(data){
				if (data.resultcode=="USR000") {
					layer.msg("删除成功");
					refreshData();
				} else {
					layer.alert("删除失败")
				}
			}
		})
	});
}
 
 

/*判断是否可添加*/
function addOrg(thi){
	var title = $(thi).attr("data-title");
	var ull = $(thi).attr("data-url");
	if($(thi).attr("data-url").indexOf("?") > -1){
		var par = $(thi).attr("data-url").split("?")[1];
		if(par == 'id=0&level=1'){
			layer.alert("请选择一级公司");
		}else{
			layer.open({
				  type: 2,
				  skin: 'layer-class' ,
				  title: title,
				  shadeClose: false,
				  area: ['770px','450px'],
				  content: ull 
			});
		}
	}
}

 

</script>
</body>
</html>
 
