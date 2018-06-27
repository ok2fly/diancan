<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>告警码报表</title>
<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
<script type="text/javascript" language="javascript">
        var idTmr;
        function  getExplorer() {
            var explorer = window.navigator.userAgent ;
            //ie 
            if (explorer.indexOf("MSIE") >= 0) {
                return 'ie';
            }
            //firefox 
            else if (explorer.indexOf("Firefox") >= 0) {
                return 'Firefox';
            }
            //Chrome
            else if(explorer.indexOf("Chrome") >= 0){
                return 'Chrome';
            }
            //Opera
            else if(explorer.indexOf("Opera") >= 0){
                return 'Opera';
            }
            //Safari
            else if(explorer.indexOf("Safari") >= 0){
                return 'Safari';
            }
        }
        
        
        function method1(tableid) {//整个表格拷贝到EXCEL中
        	layer.confirm("确定下载？",function(){
        		layer.closeAll();
        		getData(2);	//标识查询数据同时下载
        	})
        }
        	
        function Cleanup() {
            window.clearInterval(idTmr);
            CollectGarbage();
        }
        var tableToExcel = (function() {
              var uri = 'data:application/vnd.ms-excel;base64,',
              template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>',
                base64 = function(s) { return window.btoa(unescape(encodeURIComponent(s))) },
                format = function(s, c) {
                    return s.replace(/{(\w+)}/g,
                    function(m, p) { return c[p]; }) }
                return function(table, name) {
                if (!table.nodeType) table = document.getElementById(table)
                var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML}
                window.location.href = uri + base64(format(template, ctx))
              }
            })()
    </script>
</head>
<body class="bgfc">
	<input type="hidden" id="userId" value="${user.id}" >
	<input type="hidden" id="use_typ" value="${user.use_typ}" >
	<input type="hidden" id="slt_opt_sta" value="${user.slt_opt_sta}" >
	<a style="display:none" href="#" id="exportExcel"></a>
	<div  class="pl15 ml15 mr15 mt15">
		<div class="w100 h670">
			<div class="bg-ff pb18 pl15 pt10 clr pl8 tjfx-box">
				<div class="query">
					<div class="fl">
						 <select class="fl quinput w20"  id="companyOne"  onchange="setCompanytwo(this.value);">
           	   			 	<option value="qxz">请选择一级公司</option>
           	   			 </select>
           	   			 <select class="fl quinput w20"  id="companyTwo" style="margin-left:10px;" onchange="setCompanyThree(this.value);">
           	   			 	<option value="qxz">请选择二级公司</option>
           	   			 </select>
           	   			 <select class="fl quinput w20"  id="companyThree" style="margin-left:10px;" onchange="setPws(this.value);">
           	   			 	<option value="qxz">请选择三级公司</option>
           	   			 </select>
           	   			  <select class="fl quinput w20"  id="companyPws" style="margin-left:10px;"  >
           	   			 	<option value="qxz">请选择电站</option>
           	   			 </select>
					</div>
				</div>
				<div class="query mt15">
					<div class="fl">
						<select  id="typ_ide"  class="fl quinput">
							<option value="">-请选择设备类型-</option>
							<option value="GFNBQ">-光伏逆变器-</option>
							<option value="CNNBQ">-储能逆变器-</option>
							<option value="CNDC">-储能电池-</option>
							<option value="HJJCY">-环境监测仪-</option>
							<option value="DCDC">-DC/DC-</option>
							<option value="BYQ">-变压器-</option>
							<option value="DB">-电表-</option>
							<option value="DNZLJCZZ">-电能质量检测-</option>
							<option value="HLX">-汇流箱-</option>
							<option value="JLPDG">-交流配电柜-</option>
							<option value="ZLPDG">-直流配电柜-</option>
							<option value="JLZZ">-解列装置-</option>
							<option value="XLBH">-线路保护-</option>
							<option value="JLCDZ">-交流充电桩-</option>
							<option value="ZLCDZ">-直流充电桩-</option>
							<option value="KZQ">-控制器-</option>
							<option value="WWXT">-微网系统-</option>
						</select> 
						<input type="text" value="" id="equ_num" style="margin-left:10px;" placeholder="请输入设备编号/设备名称" class="fl quinput"  > 
						<input type="text" value="" id="sta_tim" placeholder="请输入开始时间" class="fl quinput Wdate" style="margin-left:10px;" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end_tim\')}'})"> 
						<input type="text" value="" id="end_tim" placeholder="请输入结束时间" class="fl quinput Wdate" style="margin-left:10px;" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'sta_tim\')}'})"> 
					</div>
					<div class="fr pr30">
						<input type="button" value="查询" class="querybut" onclick="currentPage  = 1; getData();">
						<input type="button" value="下载" class="querybut down" onclick="getDataDown();" >
					</div>
				</div>
			</div>
			<div class="mt15 pl8 pr8 pb18 bg-ff pt10 mb50 bb-box">
				<div class="clr wauto">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="table-list" id="datalist1">
						 <tr >
							<th>序号</th>
							<th>设备编号</th>
							<th>设备名称</th>
							<th>设备类型</th>
							<th>故障或告警级别</th>
							<th>故障码</th>
							<th>故障索引</th>
							<th>故障信息</th>
							<th>故障标志</th>
							<th>故障变化时间</th>
						</tr>
						<tbody id="datalist">
							<tr><td colspan="10">暂无数据</td></tr>
						</tbody>
					</table>
				</div>
				<table width="100%" border="0" cellpadding="0" cellspacing="0"
						class="table-list" id="datalist3"  style="display:none;">
					 <tr >
						<th>设备编号</th>
						<th>设备名称</th>
						<th>设备类型</th>
						<th>故障或告警级别</th>
						<th>故障码</th>
						<th>故障索引</th>
						<th>故障信息</th>
						<th>故障标志</th>
						<th>故障变化时间</th>
					</tr>
					<tbody id="datalist2">
						<tr><td colspan="9">暂无数据</td></tr>
					</tbody>
				</table>
				<div class="tcdPageCode" id="tcdPageCode1"></div> 
			</div>
			<div class="blank0"></div>
		</div>
	</div>
	<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.page.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js?pubVersion=201802070001" ></script>
<script type="text/javascript" src="<%=basePath%>js/checkCom.js?pubVersion=201802070001"></script>
<script type="text/javascript" src="<%=basePath%>js/exportExcel.js?pubVersion=201802070001"></script>
<script>
	$(function(){
		getCompanyOne();
	})
	
	function getDataDown(){
		var param="";
		var pws_id = $("#companyPws").val();
		if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
			param  += "type=2&&pws_id="+pws_id;
		}else{
			layer.alert("请选择电站");
			return;
		}
		
		var equ_num=$("#equ_num").val();
		if(equ_num!=""){
			param+="&&equ_num="+equ_num;
		}
		if($("#sta_tim").val()!=""){
			param+="&&sta_tim="+$("#sta_tim").val();
		}
		if($("#end_tim").val()!=""){
			param+="&&end_tim="+$("#end_tim").val();
		}
		if($("#typ_ide").val()!=""){
			param+="&&typ_ide="+$("#typ_ide").val();
		} 
		param+="&&use_id="+$("#userId").val();
		var layC = layer.confirm("确定下载？",function(){
			var indexlayer = layer.load(1, {
				  shade: [0.5,'#fff'] //0.1透明度的白色背景
			});
			
   		 	layer.close(layC);
			location.href = url + "FatDataLstExport.htm?"+param;
   		    layer.close(indexlayer);
			/* $.ajax({
				url:url+"FatDataLstExport.htm",
				data:param,
				type:"post",
				dataType:"json",
				success:function(data){
					if(data.resultcode=="USR000"){
						countAll = data.totalPage;
						currentPage = data.currentPage;
						var html="";
						for(var i=0;i<data.data.length;i++){
							var d =  data.data[i];
							html+="<tr>"+
							"<td  style='mso-number-format:\"\@\";'>"+getIsNull(d.PID)+"</td>"+
							"<td>"+getIsNull(d.name)+"</td>"+
							"<td>"+getIsNull(d.type)+"</td>"+
							"<td>"+getIsNull(d.level)+"</td>"+
							"<td>"+getIsNull(d.num)+"</td>"+
							"<td>"+getIsNull(d.index)+"</td>"+
							"<td>"+getIsNull(d.info)+"</td>"+
							"<td>"+getIsNull(d.flag)+"</td>"+
							"<td>"+getLocalDateAndTime(d.time,1)+"</td>"+
							"</tr>" 
						}
						if(html != ""){
							$("#datalist2").html(html);
						}
	  					 
	  					layer.close(indexlayer);
	  					
						downLoadFile("datalist3","告警数据报表");
						
					}else{
						layer.close(indexlayer);
						layer.alert(data.desc);
					}
				}
			}) */
		})
	}
	
	
	var countAll = 0;
	var currentPage  = 1;
	function getData(param2){
		
		var curParam = "" ;
		if(param2 != undefined){
			curParam = param2 ;
		}else{
			var pws_id = $("#companyPws").val();
			if(pws_id != '' && pws_id != undefined && pws_id != 'qxz'){
				curParam  += "type=2&&pws_id="+pws_id;
			}else{
				layer.alert("请选择电站");
				return;
			}
			
			var equ_num=$("#equ_num").val();
			if(equ_num!=""){
				curParam+="&&equ_num="+equ_num;
			}
			if($("#sta_tim").val()!=""){
				curParam+="&&sta_tim="+$("#sta_tim").val();
			}
			if($("#end_tim").val()!=""){
				curParam+="&&end_tim="+$("#end_tim").val();
			}
			if($("#typ_ide").val()!="" && $("#typ_ide").val()!="qxz" ){
				curParam+="&&typ_ide="+$("#typ_ide").val();
			} 
			
			curParam+="&&use_id="+$("#userId").val();
		}
		 
		var param = curParam + "&currentPage="+currentPage;
		
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
			url:url+"getFatDataLst.htm",
			data:param,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					countAll = data.totalPage;
					currentPage = data.currentPage;
					var html="";
					for(var i=0;i<data.data.length;i++){
						var d =  data.data[i];
						var flag = d.flag==0?"消失":d.flag==1?"发生":"无";
						var level = d.level==1?"告警":d.level==2?"故障":"无";
						html+="<tr>"+
						"<td>"+(i+1)+"</td>"+
						"<td>"+getIsNull(d.PID)+"</td>"+
						"<td>"+getIsNull(d.name)+"</td>"+
						"<td>"+getIsNull(d.type)+"</td>"+
						"<td>"+getIsNull(level)+"</td>"+
						"<td>"+getIsNull(d.num)+"</td>"+
						"<td>"+getIsNull(d.index)+"</td>"+
						"<td>"+getIsNull(d.info)+"</td>"+
						"<td>"+getIsNull(flag)+"</td>"+
						"<td>"+getLocalDateAndTime(d.time,1)+"</td>"+
						"</tr>" 
					}
					if(html != ""){
						$("#datalist").html(html);
					}else{
						$("#datalist").html("<tr><td colspan='10'>暂无数据</td></tr>");
					}
  					$("#tcdPageCode1").createPage({
				        pageCount:countAll,
				        current:currentPage,
				        backFn:function(p){
				        	currentPage = p;
				        	getData(curParam);
				        }
			    	});
  					layer.close(indexlayer);
  					 
				}else{
					layer.close(indexlayer);
					layer.alert(data.desc);
				}
			}
		})
	}
	 
	</script>
</body>
</html>