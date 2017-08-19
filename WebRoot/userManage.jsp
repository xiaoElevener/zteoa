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
<script src="js/bootstrap-table-editable.js" type="text/javascript"
	charset="utf-8"></script>
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
								<div class="panel-heading">管理员，在这里管理所有员工</div>
								<div class="panel-body">	
									<div id="toolbar" class="btn-group">
									<button id="btn_add" type="button" class="btn btn-default"
										data-toggle="modal" data-target="#addModel">
										<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
									</button>
									<button id="edit" type="button" class="btn btn-default"
										data-toggle="modal" data-target="#myModal">
										<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改角色
									</button>
									<button id="btn_edit" type="button" class="btn btn-default"
										data-toggle="modal" data-target="#addFamilyDetail"
										data-placement="bottom">
										<span class="glyphicon glyphicon-home" aria-hidden="true"></span>新增家庭
									</button>
									<button id="btn_edit" type="button" class="btn btn-default"
										data-toggle="modal" data-target="#addHistory">
										<span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>新增经历
									</button>
									<button id="btn_delete" type="button" class="btn btn-default">
										<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
									</button>
								</div>
								<table id="table"></table>
								<!-- 模态框（Modal） -->
								<div class="modal fade" id="addModel" tabindex="-1" role="dialog"
									aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
												<h4 class="modal-title" id="myModalLabel">新增用户</h4>
											</div>
											<!--添加部门主体-->
											<div class="modal-body">
												<form class="form-horizontal" id="addUserForm">
													<input type="hidden" value="123456" name="user.userPassword">
													<input type="hidden" value="在职" name="user.userStatus">
													<div class="form-group">
														<label for="inputEmail3" class="col-sm-2 control-label">工号</label>
														<div class="col-sm-10">
															<input class="form-control" id="disabledInput" type="text"
																name="user.userId">
														</div>
													</div>
													<div class="form-group">
														<label for="inputEmail3" class="col-sm-2 control-label">员工姓名</label>
														<div class="col-sm-10">
															<input class="form-control" id="disabledInput" type="text"
																name="user.userName">
														</div>
													</div>
													<div class="form-group">
														<label for="inputEmail3" class="col-sm-2 control-label">性别</label>
														<div class="col-sm-4">
															<select class="form-control" name="user.userSex">
																<option value="男">男</option>
																<option value="女">女</option>
															</select>
														</div>
														<label for="inputEmail3" class="col-sm-2 control-label">设置部门</label>
														<div class="col-sm-4">
															<select class="form-control" name="department.dpId">
																<option value="1">人事部</option>
																<option value="2">平台研发部</option>
																<option value="3">产品设计部</option>
																<option value="4">财务部</option>
																<option value="5">总裁办公室</option>
															</select>
														</div>
													</div>
							
													<div class="form-group">
														<label for="inputEmail3" class="col-sm-2 control-label">添加职位</label>
														<div class="col-sm-10">
															<label class="checkbox-inline"> <input type="checkbox"
																id="inlineCheckbox1" value="1" name="roles">普通员工 </label> <label
																class="checkbox-inline"> <input type="checkbox"
																id="inlineCheckbox2" value="2" name="roles">部门经理 </label> <label
																class="checkbox-inline"> <input type="checkbox"
																id="inlineCheckbox3" value="3" name="roles">总经理 </label> <label
																class="checkbox-inline"> <input type="checkbox"
																id="inlineCheckbox3" value="4" name="roles">财务 </label> <label
																class="checkbox-inline"> <input type="checkbox"
																id="inlineCheckbox3" value="5" name="roles">管理员 </label>
														</div>
													</div>
													<div class="form-group">
														<label for="inputEmail3" class="col-sm-2 control-label">手机号</label>
														<div class="col-sm-10">
															<input type="email" class="form-control" id="inputEmail3"
																name="user.userTelephone">
														</div>
													</div>
													<!--个人生日修改框-->
													<div class="form-group">
														<label for="dtp_input2" class="col-md-2 control-label">生日</label>
														<div class="col-sm-10">
															<div class="input-group date form_date" id='datetimepicker2'>
																<input class="form-control" size="16" type="text" value=""
																	readonly name="user_birthday"> <span
																	class="input-group-addon"><span
																	class="glyphicon glyphicon-remove"></span> </span> <span
																	class="input-group-addon"><span
																	class="glyphicon glyphicon-calendar"></span> </span>
															</div>
							
														</div>
							
													</div>
							
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<button type="button" class="btn btn-primary" id="addUser"
													data-dismiss="modal">提交</button>
											</div>
										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal -->
								</div>
							
							
								<!--添加家庭情况模态框-->
								<!-- 模态框（Modal） -->
								<div class="modal fade" id="addFamilyDetail" tabindex="-1"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
												<h4 class="modal-title" id="myModalLabel">在这里添加家庭信息详情</h4>
											</div>
											<!--添加家庭详情主体-->
											<div class="modal-body">
												<form action="" id="addFamilyForm" method="post">
													<div class="form-group">
														<label for="depName">关系名称</label> <input type="text"
															class="form-control" id="relationName" placeholder="关系">
													</div>
													<div class="form-group">
														<label for="depName">亲属名称</label> <input type="text"
															class="form-control" id="name" placeholder="名称">
													</div>
													<div class="form-group">
														<label for="depName">联系方式</label> <input type="text"
															class="form-control" id="telephone" placeholder="联系方式">
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<button type="button" class="btn btn-primary" id="addFam"
													data-dismiss="modal">提交</button>
											</div>
										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal -->
								</div>
							
								<!--添加个人经历模态框-->
								<!-- 模态框（Modal） -->
								<div class="modal fade" id="addHistory" tabindex="-1" role="dialog"
									aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-hidden="true">&times;</button>
												<h4 class="modal-title" id="myModalLabel">在这里添加个人经历</h4>
											</div>
											<!--添加个人经历主体-->
											<div class="modal-body">
												<form action="" id="addHistoryForm" method="post">
													<div class="form-group">
														<label for="depName">经历名称</label> <input type="text"
															class="form-control" id="uhEvent">
													</div>
							
													<!--开始时间-->
													<div class="form-group">
														<label for="dtp_input2">选择开始时间</label>
							
														<div class="input-group date form_date" id='datetimepicker4'>
															<input class="form-control" size="16" type="text" value=""
																readonly id="startTime"> <span
																class="input-group-addon"><span
																class="glyphicon glyphicon-remove"></span> </span> <span
																class="input-group-addon"><span
																class="glyphicon glyphicon-calendar"></span> </span>
														</div>
													</div>
													<!--结束时间-->
													<div class="form-group">
														<label for="dtp_input2">选择结束时间</label>
							
														<div class="input-group date form_date" id='datetimepicker3'>
															<input class="form-control" size="16" type="text" value=""
																readonly id="endTime"> <span class="input-group-addon"><span
																class="glyphicon glyphicon-remove"></span> </span> <span
																class="input-group-addon"><span
																class="glyphicon glyphicon-calendar"></span> </span>
														</div>
							
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭
												</button>
												<button type="button" class="btn btn-primary" id="addHis"
													data-dismiss="modal">提交</button>
											</div>
										</div>
										<!-- /.modal-content -->
									</div>
									<!-- /.modal -->
								</div>
							
							
								<!-- Modal -->
								<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
									aria-labelledby="myModalLabel">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title" id="myModalLabel">管理角色</h4>
											</div>
											<div class="modal-body">
												<form id="roleForm" method="post">
													<input type="hidden" name="userId" id="userId"/>
													<div class="form-group">
														<label for="inputEmail3" class="col-sm-2 control-label">添加职位</label>
														<div class="col-sm-10">
															<label class="checkbox-inline"> <input type="checkbox"
																id="role1" value="1" name="roles">普通员工 </label> <label
																class="checkbox-inline"> <input type="checkbox"
																id="role2" value="2" name="roles">部门经理 </label> <label
																class="checkbox-inline"> <input type="checkbox"
																id="role3" value="3" name="roles">总经理 </label> <label
																class="checkbox-inline"> <input type="checkbox"
																id="role4" value="4" name="roles">财务 </label> <label
																class="checkbox-inline"> <input type="checkbox"
																id="role5" value="5" name="roles">管理员 </label>
														</div>
													</div>
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
												<button type="button" class="btn btn-primary" id="saveRoles" data-dismiss="modal">确认修改</button>
											</div>
										</div>
									</div>
								</div>
							</div>

					</div>
				</div>

			</div>

		


		</body>
<script type="text/javascript">
	$(function() {
		$('#datetimepicker2').datetimepicker({
			minView : "month",
			format : 'yyyy-mm-dd',
		});

		$('#datetimepicker3').datetimepicker({
			minView : "month",
			format : 'yyyy-mm-dd',
		});
		$('#datetimepicker4').datetimepicker({
			minView : "month",
			format : 'yyyy-mm-dd',
		});
	});

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
						url : "${pageContext.request.contextPath }/UserAction_find",
						columns : [ {
							checkbox : true
						}, {
							field : 'userId',
							title : '员工工号',
							sortable : true
						}, {
							field : 'department.dpId',
							title : '员工部门',
							sortable : true,
							editable : {
								type : 'select',
								source : [ {
									value : 1,
									text : "人事部"
								}, {
									value : 2,
									text : "产品研发部"
								}, {
									value : 3,
									text : "产品设计部"
								}, {
									value : 4,
									text : "财务部"
								}, {
									value : 5,
									text : "总裁办公室"
								} ],
								validate : function(v) {
									if (!v)
										return '用户名不能为空';
								}
							}
						}, {
							field : 'userName',
							title : '员工姓名',
							sortable : true,
							editable : {
								type : 'text',
								validate : function(v) {
									if (!v)
										return '员工姓名不能为空';
								}
							}
						}, {
							field : 'userSex',
							title : '员工性别',
							sortable : true,
							editable : {
								type : 'select',
								source : [ {
									value : "男",
									text : "男"
								}, {
									value : "女",
									text : "女"
								} ],
								validate : function(v) {
									if (!v)
										return '用户名不能为空';
								}
							}
						}, {
							field : 'userTelephone',
							title : '员工手机号',
							editable : {
								type : 'text',
								validate : function(v) {
									if (!v)
										return '用户名不能为空';
								}
							}
						}, {
							field : 'userBirthday',
							title : '员工生日',
							sortable : true,
							editable : {
								type : 'text',
								validate : function(v) {
									if (!v)
										return '员工生日为空';
								}
							}
						} ],

						onEditableSave : function(field, row, oldValue, $el) {
							// field:修改的欄位
							// row:修改後的資料(JSON Object)
							// oldValue:修改前的值
							// -------------------------------------------------
							// 可用ajax方法去更新資料

							var newrow = JSON.stringify(row);

							$
									.ajax({
										type : "post",
										url : "${pageContext.request.contextPath }/UserAction_updateUser",
										data : {
											"myrow" : newrow
										},
										//dataType: 'JSON',
										success : function() {
											toastr.success('修改信息成功');

											//$('#table').bootstrapTable('refresh');
										},
										error : function() {
											toastr.warning('修改信息成功');
											//$('#table').bootstrapTable('refresh');
										}
									});
						}
					});
	//回显角色
	$("#edit").click(function() {
		$('input[name=roles]', '#roleForm').removeAttr("checked");
		var myjson = $table.bootstrapTable('getSelections');
		//alert(JSON.stringify(myjson));
		var roles=myjson[0].roles;
		
		$('#userId').val(myjson[0].userId);
		for(var i=0;i<roles.length;i++){
			 var n=roles[i].roleId;
			 var boxid='#role'+n;
			 $(boxid).attr("checked","checked");
		}
	});
	
	
	//保存修改角色
	$("#saveRoles").click(function() {
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/UserAction_updateUserRole",
			//提交表单中序列化的值
			data : $("#roleForm").serialize(),
			async : true,
			success : function() {
				toastr.success("添加成功!");
				$('#table').bootstrapTable('refresh');
			}
		});
	});
	
	//模态框新增用户按钮触发事件
	$("#addUser").click(function() {

		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath }/UserAction_addUser",
			//提交表单中序列化的值
			data : $("#addUserForm").serialize(),
			async : true,
			success : function() {
				toastr.success("添加成功!");
				$('#table').bootstrapTable('refresh');
			}
		});
	});

	//添加家庭详情
	$("#addFam").click(function() {
		var myjson = $table.bootstrapTable('getSelections');
		var relationName = $("#relationName").val();
		var name = $("#name").val();
		var telephone = $("#telephone").val();
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath }/UserAction_addFamily",
			//提交表单中序列化的值
			data : {
				"r_rname" : relationName,
				"r_name" : name,
				"r_tele" : telephone,
				"myjson" : JSON.stringify(myjson)
			},
			async : true,
			success : function() {
				toastr.success("添加成功!");
				$('#table').bootstrapTable('refresh');
			}
		});
	});

	//添加个人经历
	$("#addHis")
			.click(
					function() {
						var myjson = $table.bootstrapTable('getSelections');
						var startTime = $("#startTime").val();
						var endTime = $("#endTime").val();
						var uhEvent = $("#uhEvent").val();
						//alert(startTime + '  ' + endTime+'      '+uhEvent);
						$
								.ajax({
									type : "post",
									url : "${pageContext.request.contextPath }/UserAction_addPersonHistory",
									//提交表单中序列化的值
									data : {
										"startTime" : startTime,
										"endTime" : endTime,
										"uhEvent" : uhEvent,
										"myjson" : JSON.stringify(myjson)
									},
									async : true,
									success : function() {
										toastr.success("添加成功!");
										$('#table').bootstrapTable('refresh');
									}
								});
					});

	//删除  
	var $table = $('#table'), $btn_delete = $('#btn_delete');
	$(function() {
		$btn_delete
				.click(function() {
					swal(
							{
								title : "确定删除吗？",
								text : "你将无法撤销此操作！",
								type : "warning",
								showCancelButton : true,
								confirmButtonColor : "#DD6B55",
								confirmButtonText : "确定删除！",
								cancelButtonText : "取消！",
								closeOnConfirm : false,
								closeOnCancel : false
							},
							function(isConfirm) {
								if (isConfirm) {
									//将json对象转为json字符串
									var myjson = $table
											.bootstrapTable('getSelections');
									//alert(myjson);
									$
											.ajax({
												type : "post",
												url : "${pageContext.request.contextPath }/UserAction_deleteUser",
												//提交表单中序列化的值
												data : {
													"myjson" : JSON
															.stringify(myjson)
												},
												async : true,
												success : function() {
													swal("删除！", "删除成功。",
															"success");
													$('#table').bootstrapTable(
															'refresh');
												}
											});
								} else {
									swal("取消！", "你的虚拟文件是安全的:)", "error");
								}
							});

				});
	});
</script>		
</html>