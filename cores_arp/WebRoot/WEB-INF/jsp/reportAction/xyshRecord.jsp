<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>血生化检测记录</title>
<%@ include file="/WEB-INF/jsp/public/easyui.jspf"%>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/css/style.css" media="screen" />
<script type="text/javascript">
	var tableHeight;//当前页面可见区域高度 - 30
	var tableWidth;
	$(function(){
		tableHeight = document.body.clientHeight - 60;
		tableWidth  = document.body.clientWidth;
		$('#SearchButton').searchbox({ 
		    height:19,
		    width:450,
			searcher:function(value,name){ 
			 var monkeyId=$('#searchmonkeyid').val();
          	 var xyshDate=$('#xyshdate').datebox('getValue');
		     showXyshTable(monkeyId,xyshDate);
			}, 
			prompt:'模糊查询,请输入结论关键字' 
			}); 
				
		showXyshTable('','');
		
		var checkid=$('#checkId').val();
		if(checkid!=''){$('#printButton_list').linkbutton('enable');}
		$('#layoutMainDiv').css('display','');
    });//匿名函数结束
    function showXyshTable(monkeyid,xyshdate){
    	$('#xyshTable').datagrid({
			url : sybp()+'/xyshAction_xyshByJson.action?monkeyid='+monkeyid+'&cdate='+encodeURIComponent(xyshdate),
			title:'',
			height:tableHeight,
			width:tableWidth,
			nowarp:  false,//单元格里自动换行
			singleSelect:true,
			fitColumns:false,
		    pagination:true,//分页
			sortName:'id',
			columns :[[{
				title:'id',
				field:'id',
				width:150,
				hidden:true
			},{
				title:'房号',
				field:'roomid',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'笼号',
				field:'lhao',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'猴子编号',
				field:'monkeyid',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'性别',
				field:'sex',
				width:80,
				halign:'center',
				align:'center',
				formatter:function(value,row,index){
					if(value=='0'){
						return "公";
					}else{
						return "母";
					}
				}
			},{
				title:'体重(kg)',
				field:'weight',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'检疫编号',
				field:'checkId',
				width:120,
				halign:'center',
				align:'center'
			},{
				title:'血样号',
				field:'xueyh',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'采样',
				field:'caiy',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'AST',
				field:'ast',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'ALT',
				field:'alt',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'ALP',
				field:'alp',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'TP',
				field:'tp',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'ALB',
				field:'alb',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'GGT',
				field:'ggt',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'TBIL',
				field:'tbil',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'BUN',
				field:'bun',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'CREA',
				field:'crea',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'GLU',
				field:'glu',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'TG',
				field:'tg',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'CHOL',
				field:'chol',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'LDH',
				field:'ldh',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'CK',
				field:'ck',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'NA',
				field:'na',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'K',
				field:'k',
				width:80,
				halign:'center',
				align:'center'
			},{
				title:'CI',
				field:'ci',
				width:80,
				halign:'center',
				align:'center'
			}
			]],
			onSelect:function(rowIndex, rowData){
    		  $('#addWeaningButton').linkbutton('enable');
    		  $('#editWeaningButton').linkbutton('enable');
    		  $('#deleteWeaningButton').linkbutton('enable');
			},
			onLoadSuccess:function(data){
			   $('#addWeaningButton').linkbutton('enable');
	    	   $('#editWeaningButton').linkbutton('disable');
	           $('#deleteWeaningButton').linkbutton('disable');
	           var selectid=$('#wid').val();
	           if(selectid != ""){
			          for(var i = 0 ; i< data.rows.length;i++){
			             if(selectid == data.rows[i].id){
			            	$('#vaccineTable').datagrid('selectRow',i);
			             }
			          }
			   }
			},
			toolbar:'#toolbar',
			pageSize : 12,//默认选择的分页是每页5行数据         
			pageList : [ 5, 10, 12, 15, 20 ],//可以选择的分页集合       
		    nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取       
		    striped : true,//设置为true将交替显示行背景。      
		    collapsible : true//显示可折叠按钮 
			
	   	});
    }

     function onSearchButton(){
          var monkeyId=$('#searchmonkeyid').val();
          var xyshdate=$('#xyshdate').datebox('getValue');
          showXyshTable(monkeyId,xyshdate);
      }
      
      function onPrintButton(){
        var xyshdate=$('#xyshdate').datebox('getValue');
    	var checkId=$('#checkId').val();
    	/*if(xyshdate==""){
    		return;
    	}else{
    		parent.parent.showMessager(2,'数据加载中...',true,5000);
    		window.location.href=sybp()+'/xyshAction_reportXYSH.action?xyshdate='+xyshdate;
    	}*/
    	if(checkId!=""){
    		parent.parent.parent.showMessager(2,'数据加载中...',true,5000);
    		window.location.href=sybp()+'/xyshAction_reportXYSH.action?xyshdate='+xyshdate+'&checkId='+checkId;
    	}else{
    		parent.parent.parent.showMessager(3,'请先输入检疫编号',true,5000);
    	}
    }
</script>
</head>
<body>
<s:hidden id="onchange" name="onchange"></s:hidden>
<div id = "progressBar" style="position:absolute;z-index:100;left:30%; top:50%; "> <div id="p" style="width:400px;"></div> 
</div>
<div id="layoutMainDiv" class="easyui-layout"  style="width:100%;height:100%; display:none;"> 
 	<div region="center" title="" style="overflow: hidden;">
 	 	<!-- <div id="tabs" class="easyui-tabs" fit="true" border="false">-->
            <div title="血生化检测记录" border="false" style="overflow: auto;">
                <div style="height:30px;">
			       <div style="float:left; width:100%;padding-top:5px;height:22px;">
			    		&nbsp;&nbsp;猴子编号:
			    		<input id="searchmonkeyid" type="text" name="monkeyid"   style="width:100px;"></input>
			    	    &nbsp;&nbsp;&nbsp;&nbsp; 采样日期:
		                &nbsp;
			        	&nbsp;<input id="xyshdate" type="text" class="easyui-datebox" style="width:100px;height:16px;" editable="false"></input>	
			      	  	<a id="searchButton" class="easyui-linkbutton" onclick="onSearchButton();" data-options="iconCls:'icon-search',plain:true">搜索</a>
			    	</div>
			    </div>
				<table id="xyshTable" ></table>
            </div>
		<!--</div> -->
        <div id="toolbar">
			&nbsp;检疫编号：<input id="checkId" name="checkId" style="width:180px;height:16px;"/><a id="printButton_list"  class="easyui-linkbutton" onclick="onPrintButton()" data-options="iconCls:'icon-print',plain:true">打印</a>
		</div>
 	</div>
</div>
</body>
</html>