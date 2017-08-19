<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>测试bootstrap table</title>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap-datetimepicker.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap-table.css" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap-editable.css" />
		<link rel="stylesheet" type="text/css" href="css/sweetalert.css" />
		<link rel="stylesheet" type="text/css" href="css/toastr.css" />

		<script src="js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap-datetimepicker.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap-datetimepicker.zh-CN.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap-table.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap-table-zh-CN.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap-editable.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/sweetalert.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/toastr.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap-table-editable.js" type="text/javascript" charset="utf-8"></script>
		 <link rel="stylesheet" type="text/css" href="css/metisMenu.min.css"/>
		 <link href="css/mm-vertical.css" rel="stylesheet" type="text/css"/>
		 <script src="js/metisMenu.min.js" type="text/javascript" charset="utf-8"></script>
		 <script>
		 
		   $(function () {
		       $('#menu1').metisMenu();
		
		   });
		 </script>
    </head>
    <!--个人通讯录的网页-->

		<body>
			<!--导航条-->
			<jsp:include page="header.jsp"></jsp:include>
			<!--个人信息管理主体-->
			<div class="container-fluid">
				<div class="row">
					<!-- 左部导航条 -->
					<jsp:include page="leftbar.jsp"></jsp:include>
					<!--修改通讯录-->
					
					
					<div class="col-md-8">
						<div class="panel-body" style="padding-bottom:0px;">
							<div class="panel panel-default">
								<div class="panel-heading">管理员，在这里管理部门</div>
								<div class="panel-body">
									<div id="toolbar" class="btn-group">
									<button id="btn_add" type="button" class="btn btn-default" data-toggle="modal" data-target="#addModel">
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

			</div>
<!-- 模态框（Modal） -->
		<div class="modal fade" id="addModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
							&times;
						</button>
						<h4 class="modal-title" id="myModalLabel">
							新增部门
						</h4>
					</div>
					<!--添加部门主体-->
					<div class="modal-body">
						<form action="${pageContext.request.contextPath }/department_addDepartment" id="addDeptForm" method="post">
							<div class="form-group">
								<label for="depName">部门名称</label>
								<input type="text" class="form-control" id="depName" placeholder="部门" name ="department.dpName">
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="button" class="btn btn-primary" id="addDep" data-dismiss="modal">
							提交
						</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>

		


		</body>
<script type="text/javascript">
		toastr.options.positionClass = 'toast-top-center';
		$('#table').bootstrapTable({
			striped: true, //是否显示行间隔色
			toolbar: '#toolbar', //工具按钮用哪个容器
			pagination: true, //是否显示分页（*）
			sortable: true, //是否启用排序
			sortOrder: "asc", //排序方式
			showColumns: true, //是否显示所有的列
			pageNumber: 1, //初始化加载第一页，默认第一页
			pageSize: 5, //每页的记录行数（*）
			pageList: [5, 10, 20, 30], //可供选择的每页的行数（*）
			showRefresh: true, //是否显示刷新按钮
			search: true, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			showToggle: true, //是否显示详细视图和列表视图的切换按钮
			cardView: false, //是否显示详细视图 detailView: false, //是否显示父子表
			clickToSelect: true, //是否启用点击选中行
			uniqueId: "id", //每一行的唯一标识，一般为主键列
			url: "${pageContext.request.contextPath }/department_find",
			columns: [{
				checkbox: true
			}, {
				field: 'dpId',
				title: '部门id'
			}, {
				field: 'dpName',
				title: '部门名称',
				editable:true
			}],
			onEditableSave: function (field, row, oldValue, $el) {
				// field:修改的欄位
	            // row:修改後的資料(JSON Object)
	            // oldValue:修改前的值
	            // -------------------------------------------------
	            // 可用ajax方法去更新資料
	            
	            var newrow = JSON.stringify(row);
	          	
	             $.ajax({
	                type: "post",
	                url: "${pageContext.request.contextPath }/department_updateDepartment",
	                data: {"myrow": newrow},
	                //dataType: 'JSON',
	                success: function() {
	                       toastr.success('修改信息成功');
	                       //$('#table').bootstrapTable('refresh');
	                 },
	                 error: function() {
	                   	toastr.warning('修改信息成功');
	                    //$('#table').bootstrapTable('refresh');
	                }
	            });
            }
		});
		
		//新增行操作
		//新增行操作
		$("#addDep").click(function() {
			 var depName = $("#depName").val();     
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath }/department_addDepartment",
				//提交表单中序列化的值
				data: $("#addDeptForm").serialize(),
				async:true,
				success:function(){
					toastr.success("添加成功!");  
					$('#table').bootstrapTable('refresh');
				}
			});
		});
		
		var $table = $('#table'),
			$btn_delete = $('#btn_delete');
		$(function() {
			$btn_delete.click(function() {
			swal({
					title: "确定删除吗？",
					text: "你将无法撤销此操作！",
					type: "warning",
					showCancelButton: true,
					confirmButtonColor: "#DD6B55",
					confirmButtonText: "确定删除！",
					cancelButtonText: "取消！",
					closeOnConfirm: false,
					closeOnCancel: false
				},
				function(isConfirm) {
					if(isConfirm) {
						//将json对象转为json字符串
						var myjson = $table.bootstrapTable('getSelections');
						/*for(var i = 0; i < myjson.length; i++) {
							alert(myjson[i].dpId);
						}*/
						$.ajax({
							type: "post",
							url: "${pageContext.request.contextPath }/department_deleteDepartment",
							//提交表单中序列化的值
							data: {"myjson": JSON.stringify(myjson)},
							async: true,
							success: function() {
								swal("删除！", "删除成功。","success");
								$('#table').bootstrapTable('refresh');
							}
						});
					} else {
						swal("取消！", "你的虚拟文件是安全的:)",
							"error");
					}
				});
			
			
			
				

			});
		});
		

		
	</script>		
</html>