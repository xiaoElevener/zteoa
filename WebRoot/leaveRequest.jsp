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
								<div class="panel-heading">请假申请</div>
								<div class="panel-body">
								
								<form action="chaim_addLeaveForm" method="post">
									<!--开始时间-->
									<div class="form-group">
										<label for="dtp_input2">选择开始时间</label>
							
										<div class="input-group date form_date" id='datetimepicker4'>
											<input class="form-control" size="16" type="text" value="" readonly
												name="startTime"> <span class="input-group-addon"><span
												class="glyphicon glyphicon-remove"></span> </span> <span
												class="input-group-addon"><span
												class="glyphicon glyphicon-calendar"></span> </span>
										</div>
									</div>
									<!--结束时间-->
									<div class="form-group">
										<label for="dtp_input2">选择结束时间</label>
							
										<div class="input-group date form_date" id='datetimepicker3'>
											<input class="form-control" size="16" type="text" value="" readonly
												name="endTime"> <span class="input-group-addon"><span
												class="glyphicon glyphicon-remove"></span> </span> <span
												class="input-group-addon"><span
												class="glyphicon glyphicon-calendar"></span> </span>
										</div>
									</div>
							
									<div class="form-group">
										<label>请假理由</label>
										<textarea class="form-control" rows="3" placeholder="请输入请假理由"
											name="reason"></textarea>
									</div>
							
									<button type="submit" class="btn btn-default btn-primary">提交申请</button>
									<button type="reset" class="btn btn-default">重新填写</button>
								</form>
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
</script>		
</html>