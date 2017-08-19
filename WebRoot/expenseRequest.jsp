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
 
		<body>
			<!--导航条-->
			<jsp:include page="header.jsp"></jsp:include>
			<!--个人信息管理主体-->
			<div class="container-fluid">
				<div class="row">
				
					<jsp:include page="leftbar.jsp"></jsp:include>
				
		
					<div class="col-md-8">
						<div class="panel-body" style="padding-bottom:0px;">
							<div class="panel panel-default">
								<div class="panel-heading">提交报销申请</div>
								<div class="panel-body">
								
								<form action="chaim_addExpenseForm" method="post">
								<div class="form-group">
									<label for="exampleInputEmail1">报销原由</label> <input type="text"
										class="form-control" name="reason" placeholder="原由">
								</div>
								<div class="form-group">
									<label for="exampleInputPassword1">报销金额</label> <input type="text"
										class="form-control" name="money" placeholder="报销金额">
								</div>
								<button type="submit" class="btn btn-default btn-primary">提交报销</button>
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