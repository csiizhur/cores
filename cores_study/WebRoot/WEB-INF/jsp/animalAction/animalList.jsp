<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>main</title>
<%@ include file="/WEB-INF/jsp/public/easyui.jspf"%>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/css/style.css" media="screen" />
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/css/tblAnimal.css" media="screen" />
<script language="javascript" src="${pageContext.request.contextPath}/script/javascript/tblAnimal.js" charset="utf-8"></script>
<script language="javascript" src="${pageContext.request.contextPath}/script/javascript/commCheck.js" charset="utf-8"></script>
<script language="javascript" src="${pageContext.request.contextPath}/script/javascript/qianming.js" charset="utf-8"></script>
<script type="text/javascript">
	var talAnimalTable;
	var editRow ;
	var studyNoPara=$('#studyNoPara').val();
	var editanimalsDie;
	$(function(){
		
		editRow = 'undefined';
		talAnimalTable=$('#talAnimalTable').datagrid({
			url : sybp()+"/tblAnimalAction_loadList.action?studyNoPara="+$('#studyNoPara').val(),
			title:'',
			//height: 540,
			//width:560,
			iconCls:'',//'icon-save',
			pagination:false,//下面状态栏
			//pageSize:50,
			//pageList:[50,100],
			fit:true,
			fitColumns:false,//不出现横向滚动条
			nowarp:  false,//单元格里自动换行
			border:false,
			idField:'id', //pk
			singleSelect:true,
			//sortName:'aniSerialNum',//排序字段
			//sortOrder:'desc',//排序方法
			columns :[[{
				title :'',
				field :'id',
				//checkbox:true
				hidden:true
			},{
				title : 'No.',
				field : 'aniSerialNum',
				width : 30,
			},{
				title:'专题编号',
				field:'studyNo',
				width:100
			},{
				title:'动物ID号',
				field:'animalId',
				width:100,
				//formartter 一定要返回个字符串
				formatter : function(value,rowData,rowIndex){
					return '<span title="'+value+'">'+value+'</span>';
				}
			},{
				title:'动物编号',
				field:'animalCode',
				width:100,
				align:'center',
				editor:{
					type:'validatebox',
					options:{
						required:true
					}
				},
				//formartter 一定要返回个字符串
				formatter : function(value,rowData,rowIndex){
					return '<span title="'+value+'">'+value+'</span>';
				}
			},{
				title:'性别',
				field:'gender',
				width:50,
				align:'center',
				formatter :function(value,rowData,rowIndex){
					if(value == 1){
						return '♂';
					}else if(value == 2){
						return '♀';
					}else
					{
						return '';
					}
				}
			},{
				title:'体重',
				field:'weight',
				width:70
			},{
				title:'计划解剖次数',
				field:'dissectBatch',
				width:80,
				formatter:function(value,rowData,rowIndex){
					if(value==0){
						return '';
					}else{
						return value;
					}
				}
			},{
				title:'状态',
				field:'deadFlag',
				width:70,
				align:'center',
				formatter :function(value,rowData,rowIndex){
					if(value == 1  ){
						return '试验过程中解剖';
					}else if(value ==2){
						return '计划解剖';
					}else {
						return '';
					}
				}
			},{
				title:'死亡原因',
				field:'deadReason',
				width:100,
				align:'left'
			},{
				title:'死亡日期',
				field:'showdeadDate',
				width:100,
				align:'center'
			},{
				title:'记录人',
				field:'deadFlagUser',
				width:100,
				align:'center'
			}]],
			//工具栏
			toolbar:'#toolbar',
			//保存（编辑或增加后的保存）
			onAfterEdit : function(rowIndex,rowData,changes){
			}
		
		}); //end datagrid

		
		//表头居中
		$('.datagrid-header div').css('textAlign','center');
		//管理按钮状态
		manageButtonState();
        //动物死亡
		editanimalsDie();
		//解剖计划下拉
		initSerialNum();

		$('#animalListMainDiv').css('display','');  
		
		 $('#Selectionsbox').combobox({
			    onSelect: function(param){
			    var peo = $('#Selectionsbox').combobox('getValue');
			    if(peo == 2){
			    	$('#OneCauseofdeathSerialNum').combobox('setValue', '计划解剖');
			    	$('#OneCauseofdeathSerialNum').combobox('disable');
			      }else if(peo == 1){
			    	  $('#OneCauseofdeathSerialNum').combobox('enable');
			    	  $('#OneCauseofdeathSerialNum').combobox('setValue', '');
				  }
				 }
			
			});

		//根据下拉选，勾选死亡动物
			var OneCurrentSerialNum;

			OneCurrentSerialNum=$('#OneCurrentSerialNum').combobox({
			    onChange:function(newValue, oldValue){
				$('#editanimalsDie').datagrid('uncheckAll');
				var rows =$('#editanimalsDie').datagrid('getRows');
				for(var i = 0;i<rows.length;i++){
				var  dissectBatch= $('#editanimalsDie').datagrid('getRows')[i].dissectBatch;
	              if( dissectBatch == newValue){
	            	  $('#editanimalsDie').datagrid('checkRow',i);
	                }
				  }
	             }
			   }
	        );

		
	});
	/**管理按钮状态*/
	function manageButtonState(){
		var isAnimalIdES=$('#isAnimalIdES').val();
		var isAnimalCodeES=$('#isAnimalCodeES').val();		
	    var	member = $('#left_member').val();
	 if(member==''){
		if(isAnimalIdES == 1 && isAnimalCodeES == 1){
			$('#animalIdButton').linkbutton('disable');
			$('#animalCodeButton').linkbutton('disable');
			$('#animalDieButton').linkbutton('enable');
		}else if(isAnimalIdES == 1){
			$('#animalIdButton').linkbutton('disable');
			$('#animalCodeButton').linkbutton('enable');
			$('#animalDieButton').linkbutton('enable');
		}else if( isAnimalCodeES == 1){
			$('#animalIdButton').linkbutton('disable');
			$('#animalCodeButton').linkbutton('disable');
			$('#animalDieButton').linkbutton('enable');
		}else{
			$('#animalIdButton').linkbutton('enable');
			$('#animalCodeButton').linkbutton('disable');
			$('#animalDieButton').linkbutton('disable');
		}
      }else{
    	  $('#animalIdButton').linkbutton('disable');
		  $('#animalCodeButton').linkbutton('disable');
		  $('#animalDieButton').linkbutton('disable');
      }
	}
	/**点击动物id号按钮方法*/
	function onAnimalIdButton(){
		var isAnimalIdES=$('#isAnimalIdES').val();
		var isAnimalCodeES=$('#isAnimalCodeES').val();
		if(isAnimalIdES==0 && isAnimalCodeES==0){
			window.location.href= sybp()+"/tblAnimalAction_animalView.action?studyNoPara="+$('#studyNoPara').val();
		}
	}
	/**点击动物编号按钮方法*/
	function onAnimalCodeButton(){
		var isAnimalIdES=$('#isAnimalIdES').val();
		var isAnimalCodeES=$('#isAnimalCodeES').val();
		if(isAnimalIdES==1 && isAnimalCodeES==0){
			window.location.href= sybp()+"/tblAnimalAction_animalCode.action?studyNoPara="+$('#studyNoPara').val();
		}
	}
	/**序号下拉框初始化*/ 
	function initSerialNum(){
		$.ajax({
	        type:"POST",
	        url:"${pageContext.request.contextPath}/tblAnimalAction_Plananatomy.action",
	        contentType: "application/x-www-form-urlencoded; charset=utf-8",
	        dataType:"json",
	        data:"studyNoPara="+$('#studyNoPara').val(),
	        async:false,
	        success:function(r)
	        {
				if(r){
					$('#OneCauseofdeathSerialNum').combobox('loadData',r.serialNumList1);
					$('#OneCauseofdeathSerialNum').combobox('select',r.currentSerialNum);
					$('#CauseofdeathSerialNums').combobox('loadData',r.serialNumList1);
					$('#CauseofdeathSerialNums').combobox('select',r.currentSerialNum);
					
					$('#OneCurrentSerialNum').combobox('loadData',r.serialNumList);
					$('#OneCurrentSerialNum').combobox('select',r.currentSerialNum);
					$('#currentSerialNum').combobox('loadData',r.serialNumList);
					$('#currentSerialNum').combobox('select',r.currentSerialNum);
				}
	        }
	   });
	}


	
</script>
</head>
<body>
<div id="animalListMainDiv"   style="width:100%;height:100%; display:none;"> 
    <s:hidden id="Automatic" name="Automatic"></s:hidden>
    <s:hidden id="left_member" name="left_member"></s:hidden>
	<s:hidden id="studyNoPara" name="studyNoPara"></s:hidden>
	<s:hidden id="isAnimalIdES" name="isAnimalIdES"></s:hidden>
	<s:hidden id="isAnimalCodeES" name="isAnimalCodeES"></s:hidden>
	<div class="easyui-layout" fit="true" border="false" >
		<!-- table start -->
		<div region="center" border="false" style="border: 1px solid #c8c8c8;">
			<table id="talAnimalTable" ></table>
		</div>
		<div region="south" border="false" style="height:30px; border-bottom:  1px solid #c8c8c8;border-right:  1px solid #c8c8c8;border-left:  1px solid #c8c8c8;">
		<!-- 状态栏  开始 -->
			<div style="width:100%;height:20px; padding-top:10px; ">
			<span style="position:absolute;right:20px;">共&nbsp;${listSize}&nbsp;条记录</span>
			</div>
		<!-- 状态栏  结束 -->
		</div>
		<!-- table end -->
	<div id="toolbar" style="height:28px;">
		<a id="animalIdButton" class="easyui-linkbutton" onclick="onAnimalIdButton();" data-options="iconCls:'icon-edit',plain:true">动物Id号</a>
		<a id="animalCodeButton" class="easyui-linkbutton"onclick="onAnimalCodeButton();" data-options="iconCls:'icon-edit',plain:true">动物编号</a>
		<!-- 标记动物死亡 -->
		<a id="animalDieButton" class="easyui-linkbutton"onclick="onAnimalRegistraDeath();" data-options="iconCls:'icon-edit',plain:true">死亡/解剖登记</a>
	</div>
	<%@ include file="/WEB-INF/jsp/animalAction/animalDies.jspf" %>
	 <%@ include file="/WEB-INF/jsp/public/qianming.jspf"%>
	 <%@ include file="/WEB-INF/jsp/animalAction/determinationofdeath.jspf" %>
	</div>
</div>	
</body>
</html>