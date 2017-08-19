<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title> 
 
     
    </head>
    <body>
    
		<aside class="col-md-2 col-md-offset-1">
       <nav class="sidebar-nav">
         <ul class="metismenu" id="menu1">
           <li>
             <a class="has-arrow" href="#">
               <span class="fa fa-fw fa-github fa-lg"></span>
               	个人空间
             </a>
             <ul aria-expanded="true">
             	 <li>
                 <a href="${pageContext.request.contextPath }/scheduleManage.jsp">
                   <span class="fa fa-fw fa-exclamation-triangle"></span>个人日程
                 </a>
               </li>
               <li>
               <a href="${pageContext.request.contextPath }/alterInfo.jsp">
                   <span class="fa fa-fw fa-code-fork"></span>修改个人资料
                 </a>
               </li>
               <li>
                <a href="${pageContext.request.contextPath }/contacts.jsp">
                   <span class="fa fa-fw fa-star"></span>个人通讯录
                 </a>
               </li>
               <li>
                 <a href="${pageContext.request.contextPath }/alterPassword.jsp">
                   <span class="fa fa-fw fa-exclamation-triangle"></span>修改密码
                 </a>
               </li>
               <li>
                 <a href="${pageContext.request.contextPath }/Myfamily.jsp">
                   <span class="fa fa-fw fa-exclamation-triangle"></span>个人家庭关系管理
                 </a>
               </li>
               <li>
                 <a href="${pageContext.request.contextPath }/myHistory.jsp">
                   <span class="fa fa-fw fa-exclamation-triangle"></span>个人履历管理
                 </a>
               </li>
               <li>
                 <a href="${pageContext.request.contextPath }/myAttendance.jsp">
                   <span class="fa fa-fw fa-exclamation-triangle"></span>个人考勤查询
                 </a>
               </li>
             </ul>
           </li>
           <c:if test="${not empty sessionScope.admin}">
           <li>
             <a class="has-arrow" href="#" aria-expanded="false">系统管理</a>
             <ul aria-expanded="false">
               <li><a href="${pageContext.request.contextPath }/departmentManage.jsp">部门管理</a></li>
               <li><a href="${pageContext.request.contextPath }/roleManage.jsp">角色管理</a></li>
               <li><a href="${pageContext.request.contextPath }/userManage.jsp">员工管理</a></li>
               <li><a href="#">考勤管理</a></li>
               <li><a href="${pageContext.request.contextPath }/historyManage.jsp">员工履历管理</a></li>
               <li><a href="${pageContext.request.contextPath }/familyManage.jsp">员工家庭关系管理</a></li>
             </ul>
           </li>
           </c:if>
           <li id="removable">
             <a class="has-arrow" href="#" aria-expanded="false">个人事务</a>
             <ul aria-expanded="false">
               <li><a href="${pageContext.request.contextPath }/showMyRequest.jsp">查看我的申请</a></li>
               <li><a href="${pageContext.request.contextPath }/showNeedToCheckRequest.jsp">待我审批</a></li>
               <li>
                 <a class="has-arrow" href="#" aria-expanded="false">提交申请</a>
                 <ul aria-expanded="false">
                   <li><a href="${pageContext.request.contextPath }/leaveRequest.jsp">提交请假申请</a></li>
	               <li><a href="${pageContext.request.contextPath }/expenseRequest.jsp">提交报销申请</a></li>
	               <li><a href="${pageContext.request.contextPath }/overtimeRequest.jsp">提交加班申请</a></li>
                 </ul>
               </li>
              
             </ul>
           </li>
           
         </ul>
       </nav>
     </aside>
    
 	</body>
<script>
   $(function () {
       $('#menu1').metisMenu();
   });
 </script>
 	
</html>