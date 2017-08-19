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
<link rel="stylesheet" type="text/css" href="css/metisMenu.min.css" />
<link href="css/mm-vertical.css" rel="stylesheet" type="text/css" />
<script src="js/metisMenu.min.js" type="text/javascript" charset="utf-8"></script>
<script>
	$(function() {
		$('#menu1').metisMenu();

	});
</script>
</head>


<body>
	<!--导航条-->
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<!-- 左部导航条 -->
			<jsp:include page="leftbar.jsp"></jsp:include>


			<div class="col-md-8">
				<div class="panel-body" style="padding-bottom:0px;">
					<div class="panel panel-default">
						<div class="panel-heading">提交加班申请</div>
						<div class="panel-body">
							<form action="chaim_addOvertimeForm" method="post">
								<div class="form-group">
									<label for="dtp_input2">预计加班日期</label>

									<div class="input-group date form_date" id='datetimepicker4'>
										<input class="form-control" size="16" type="text" value=""
											readonly name="date"> <span class="input-group-addon"><span
											class="glyphicon glyphicon-remove"></span> </span> <span
											class="input-group-addon"><span
											class="glyphicon glyphicon-calendar"></span> </span>
									</div>
								</div>


								<button type="submit" class="btn btn-default btn-primary">提交申请</button>
								<button type="reset" class="btn btn-default">重填申请</button>
							</form>

						</div>

					</div>
				</div>

			</div>
</body>
<script type="text/javascript">
	$(function() {
		$('#datetimepicker2').datetimepicker({
			minView : "hour",
			format : 'yyyy-mm-dd hh:ii',
		});

		$('#datetimepicker3').datetimepicker({
			minView : "hour",
			format : 'yyyy-mm-dd hh:ii',
		});
		$('#datetimepicker4').datetimepicker({
			minView : "month",
			format : 'yyyy-mm-dd',
		});
	});
</script>

</html>