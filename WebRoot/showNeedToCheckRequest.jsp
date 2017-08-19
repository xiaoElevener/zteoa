<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-datetimepicker.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap-table.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap-editable.css" />
<link rel="stylesheet" type="text/css" href="css/sweetalert.css" />
<link rel="stylesheet" type="text/css" href="css/toastr.css" />

<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap-datetimepicker.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/bootstrap-datetimepicker.zh-CN.js"
	type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap-table.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/bootstrap-table-zh-CN.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/bootstrap-editable.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/sweetalert.min.js" type="text/javascript"
	charset="utf-8"></script>
<script src="js/toastr.js" type="text/javascript" charset="utf-8"></script>
 <link rel="stylesheet" type="text/css" href="css/metisMenu.min.css"/>
 <link href="css/mm-vertical.css" rel="stylesheet" type="text/css"/>
 <script src="js/metisMenu.min.js" type="text/javascript" charset="utf-8"></script>
 <script>
 
   $(function () {
       $('#menu1').metisMenu();

   });
 </script>
</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid">
				<div class="row">
					<!-- 左部导航条 -->
					<jsp:include page="leftbar.jsp"></jsp:include>
				
		
					<div class="col-md-8">
						<div class="panel-body" style="padding-bottom:0px;">
							<div class="panel panel-default">
								<div class="panel-heading">查看待审批的申请单</div>
								<div class="panel-body">
								
								<div id="toolbar" class="btn-group">
								<button id="btn_add" type="button" class="btn btn-default"
									data-toggle="modal" data-target="#addModel">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
								</button>
								<button id="btn_edit" type="button" class="btn btn-default">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
								</button>
								<button id="btn_delete" type="button" class="btn btn-default">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
								</button>
							</div>
							<table id="table"></table>
								
									
						</div>
					</div>
				</div>

</body>
<script type="text/javascript">
	toastr.options.positionClass = 'toast-top-center';
	$('#table')
			.bootstrapTable(
					{
						striped : true, //是否显示行间隔色
						toolbar : '#toolbar', //工具按钮用哪个容器
						pagination : true, //是否显示分页（*）
						sortable : true, //是否启用排序
						sortOrder : "desc", //排序方式
						showColumns : true, //是否显示所有的列
						pageNumber : 1, //初始化加载第一页，默认第一页
						pageSize : 5, //每页的记录行数（*）
						pageList : [ 5, 10, 20, 30 ], //可供选择的每页的行数（*）
						showRefresh : true, //是否显示刷新按钮
						search : true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
						showToggle : true, //是否显示详细视图和列表视图的切换按钮
						cardView : false, //是否显示详细视图 detailView: false, //是否显示父子表
						clickToSelect : true, //是否启用点击选中行
						uniqueId : "id", //每一行的唯一标识，一般为主键列
						url : "${pageContext.request.contextPath }/chaim_findCheckChaim",
						columns : [
								{
									checkbox : true
								},
								{
									field : 'cvId',
									sortable : true,
									title : '申请表id'
								},
								{
									field : 'formType',
									sortable : true,
									title : '类型'
								},
								{
									field : 'cvStatus',
									sortable : true,
									title : '申请表状态',
								},
								{
									field : 'cvCreateTime',
									sortable : true,
									title : '创建时间',
									formatter : function(value, row, index) {
										return new Date(value).toLocaleString();
									}
								},
								{
									formatter : function(value, row, index) {
										//通过formatter可以自定义列显示的内容 
										//value：当前field的值，即id 
										//row：当前行的数据 
										var a = '<a href="${pageContext.request.contextPath }/chaim_showCheckDetail?cvid='
												+ row.cvId + '" >审批</a>';
										return a;
									},
									title : '查看详情'
								} ]

					});
</script>

</html>