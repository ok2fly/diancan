<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>   
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	response.setHeader("P3P","CP=CAO PSA OUR");  
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="<%=basePath %>css/common.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/style.css?pubVersion=201802070001" />
		<link rel="stylesheet" href="<%=basePath %>css/dc.css?pubVersion=201802070001" />
		
	</head>
	<body >
		<input type="hidden" id="equNum" value="${equNum}">
		<div class="pt18 fl " style="width: 100%">
				<div class=" tabxq ">
					 	<table cellpadding="0" cellspacing="0" border="0" width="100%"  >
						<tr>
							<th>设备编号</th>
							<td id="equ_num"></td>
							<th>设备状态</th>
							<td id="stat"></td>
						</tr>
						<tr>
							<th>Uab线电压(V)</th>
							<td id="uab"></td>
							<th>Ubc线电压(V)</th>
							<td id="ubc"></td>
						</tr>
						<tr>
							<th>Uca线电压(V)</th>
							<td id="uca"></td>
							<th>A相电压(V)</th>
							<td id="ua"></td>
						</tr>
						<tr>
							<th>B相电压(V)</th>
							<td id="ub"></td>
							<th>C相电压(V)</th>
							<td id="uc"></td>
						</tr>
						<tr>
							<th>A相谐波电压(V)</th>
							<td id="fua"></td>
							<th>B相谐波电压(V)</th>
							<td id="fub"></td>
						</tr>
						<tr>
							<th>C相谐波电压(V)</th>
							<td id="fuc"></td>
							<th>A相电流(A)</th>
							<td id="ia"></td>
						</tr>
						<tr>
							<th>B相电流(A)</th>
							<td id="ib"></td>
							<th>C相电流(A)</th>
							<td id="ic"></td>
						</tr>
						<tr>
							<th>A相谐波电流(A)</th>
							<td id="fia"></td>
							<th>B相谐波电流(A)</th>
							<td id="fib"></td>
						</tr>
						<tr>
							<th>C相谐波电流(A)</th>
							<td id="fic"></td>
							<th>A相有功(kW)</th>
							<td id="pa"></td>
						</tr>
						<tr>
							<th>B相有功(kW)</th>
							<td id="pb"></td>
							<th>C相有功(kW)</th>
							<td id="pc"></td>
						</tr>
						<tr>
							<th>A相谐波有功(kW)</th>
							<td id="fpa"></td>
							<th>B相谐波有功(kW)</th>
							<td id="fpb"></td>
						</tr>
						<tr>
							<th>C相谐波有功(kW)</th>
							<td id="fpc"></td>
							<th>有功功率(P)</th>
							<td id="psum"></td>
						</tr>
						<tr>
							<th>A相无功(kW)</th>
							<td id="qa"></td>
							<th>B相无功(kW)</th>
							<td id="qb"></td>
						</tr>
						<tr>
							<th>C相无功(kVar)</th>
							<td id="qc"></td>
							<th>A相谐波无功(kVar)</th>
							<td id="fqa"></td>
						</tr>
						<tr>
							<th>B相谐波无功(kVar)</th>
							<td id="fqb"></td>
							<th>C相谐波无功(kVar)</th>
							<td id="fqc"></td>
						</tr>
						<tr>
							<th>无功功率(P)</th>
							<td id="qsum"></td>
							<th>正向有功电能(kWh)</th>
							<td id="phi"></td>
						</tr>
						<tr>
							<th>反向有功电能(kWh)</th>
							<td id="phe"></td>
							<th>正向无功电能(kWh)</th>
							<td id="qhi"></td>
						</tr>
						<tr>
							<th>反向无功电能(kVarh)</th>
							<td id="qhe"></td>
							<th>A相功率因数</th>
							<td id="pfa"></td>
						</tr>
						<tr>
							<th>B相功率因数</th>
							<td id="pfb"></td>
							<th>C相功率因数</th>
							<td id="pfc"></td>
						</tr>
						<tr>
							<th>功率因数</th>
							<td id="pf"></td>
							<th>频率(Hz)</th>
							<td id="freq"></td>
						</tr>
						<tr>
							<th>正序电压(V)</th>
							<td id="psv"></td>
							<th>负序电压(V)</th>
							<td id="nsv"></td>
						</tr>
						<tr>
							<th>零序电压(V)</th>
							<td id="zsv"></td>
							<th>正序电流(A)</th>
							<td id="psc"></td>
						</tr>
						<tr>
							<th>负序电流(A)</th>
							<td id="nsc"></td>
							<th>零序电流(A)</th>
							<td id="zsc"></td>
						</tr>
						<tr>
							<th>电压不平衡度</th>
							<td id="ublk"></td>
							<th>电流不平衡度</th>
							<td id="iblk"></td>
						</tr>
						<tr>
							<th>A相电压波动</th>
							<td id="vfa"></td>
							<th>B相电压波动</th>
							<td id="vfb"></td>
						</tr>
						<tr>
							<th>C相电压波动</th>
							<td id="vfc"></td>
							<th>A相短时闪变</th>
							<td id="psta"></td>
						</tr>
						<tr>
							<th>B相短时闪变</th>
							<td id="pstb"></td>
							<th>C相短时闪变</th>
							<td id="pstc"></td>
						</tr>
						<tr>
							<th>A相长时闪变</th>
							<td id="plta"></td>
							<th>B相长时闪变</th>
							<td id="pltb"></td>
						</tr>
						<tr>
							<th>C相长时闪变</th>
							<td id="pltc"></td>
							<th>A相电压总谐波畸变率(%)</th>
							<td id="thdua"></td>
						</tr>
						<tr>
							<th>B相电压总谐波畸变率(%)</th>
							<td id="thdub"></td>
							<th>C相电压总谐波畸变率(%)</th>
							<td id="thduc"></td>
						</tr>
						<tr>
							<th>A相电流总谐波畸变率(%)</th>
							<td id="thdia"></td>
							<th>B相电流总谐波畸变率(%)</th>
							<td id="thdib"></td>
						</tr>
						<tr>
							<th>C相电流总谐波畸变率(%)</th>
							<td id="thdic"></td>
							<th>创建时间</th>
							<td id="crtTim"></td>
						</tr>
					</table>
				</div>
		</div>
		
		
<script src="<%=basePath%>js/jquery.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/layer/layer.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/jsall.js?pubVersion=201802070001"></script>
<script src="<%=basePath%>js/getText.js?pubVersion=201802070001"></script>
<script type="text/javascript">
	$(function (){
		var equ_num=$("#equNum").val();
		var indexlayer = layer.load(1, {
			  shade: [0.5,'#fff'] //0.1透明度的白色背景
		});
		$.ajax({
			url:url+"getPqsmsInfByEquNumNew.htm",
			data:"equ_num="+equ_num,
			type:"post",
			dataType:"json",
			success:function(data){
				if(data.resultcode=="USR000"){
					if(data.data.length>0){
						var d=data.data[0];
						var stat=d.stat==0 ?"通讯中断": d.stat == 1 ? "正常运行" :d.stat == 2 ? "告警运行" :"--";
						var healthStat = d.healthStat == 1 ? "优秀" : d.healthStat == 2 ? "良好":d.healthStat == 3 ? "中等":d.healthStat == 4 ? "差" :"--";

						$("#equ_num").html(d.equ_num);
						$("#stat").html(stat);
						$("#uab").html(d.uab);
						$("#ubc").html(d.ubc);
						$("#uca").html(d.uca);
						$("#ua").html(d.ua);
						$("#ub").html(d.ub);
						$("#uc").html(d.uc);
						$("#fua").html(d.fua);
						$("#fub").html(d.fub);
						$("#fuc").html(d.fuc);
						$("#ia").html(d.ia);
						$("#ib").html(d.ib);
						$("#ic").html(d.ic);
						$("#fia").html(d.fia);
						$("#fib").html(d.fib);
						$("#fic").html(d.fic);
						$("#pa").html(d.pa);
						$("#pb").html(d.pb);
						$("#pc").html(d.pc);
						$("#fpa").html(d.fpa);
						$("#fpb").html(d.fpb);
						$("#fpc").html(d.fpc);
						$("#psum").html(d.psum);
						$("#qa").html(d.qa);
						$("#qb").html(d.qb);
						$("#qc").html(d.qc);
						$("#fqa").html(d.fqa);
						$("#fqb").html(d.fqb);
						$("#fqc").html(d.fqc);
						$("#qsum").html(d.qsum);
						$("#phi").html(d.phi);
						$("#phe").html(d.phe);
						$("#qhi").html(d.qhi);
						$("#qhe").html(d.qhe);
						$("#pfa").html(d.pfa);
						$("#pfb").html(d.pfb);
						$("#pfc").html(d.pfc);
						$("#pf").html(d.pf);
						$("#freq").html(d.freq);
						$("#psv").html(d.psv);
						$("#nsv").html(d.nsv);
						$("#zsv").html(d.zsv);
						$("#psc").html(d.psc);
						$("#nsc").html(d.nsc);
						$("#zsc").html(d.zsc);
						$("#ublk").html(d.ublk);
						$("#iblk").html(d.iblk);
						$("#vfa").html(d.vfa);
						$("#vfb").html(d.vfb);
						$("#vfc").html(d.vfc);
						$("#psta").html(d.psta);
						$("#pstb").html(d.pstb);
						$("#pstc").html(d.pstc);
						$("#plta").html(d.plta);
						$("#pltb").html(d.pltb);
						$("#pltc").html(d.pltc);
						$("#thdua").html(d.thdua);
						$("#thdub").html(d.thdub);
						$("#thduc").html(d.thduc);
						$("#thdia").html(d.thdia);
						$("#thdib").html(d.thdib);
						$("#thdic").html(d.thdic);
						$("#crtTim").html(getLocalDateAndTime(d.crtTim,1));

					}
						
					
					//$("#").val(d.);
					layer.close(indexlayer);

				}else{
					layer.close(indexlayer);
					layer.alert(data.desc);
				}
			}
		})
	})
</script>		

</body>
</html>