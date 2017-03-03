<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.demo.User" %>
<%@ page import="com.example.demo.Plan" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
HttpSession session1= request.getSession();
String uname=(String)session1.getAttribute("uname");
	if(uname==null){uname="我的账户";}
	request.setAttribute("uname", uname);
	User user =new User();
	user = (User)request.getAttribute("user");
	request.setAttribute("user", user);
	@SuppressWarnings("unchecked")
	ArrayList<Plan> plist  =(ArrayList<Plan>) request.getAttribute("plist");
	request.setAttribute("plist", plist);
%>
<!doctype html>
<html lang="en">

<head>
	<meta charset="utf-8"/>
	 <base href="<%=basePath%>">
	<title>System of Emergency Plan</title>
	
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="js/hideshow.js" type="text/javascript"></script>
	<script src="js/jquery.tablesorter.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.equalHeight.js"></script>
	<script type="text/javascript">
	$(document).ready(function() 
    	{ 
      	  $(".tablesorter").tablesorter(); 
   	 } 
	);
	$(document).ready(function() {

	//When page loads...
	$(".tab_content").hide(); //Hide all content
	$("ul.tabs li:first").addClass("active").show(); //Activate first tab
	$(".tab_content:first").show(); //Show first tab content

	//On Click Event
	$("ul.tabs li").click(function() {

		$("ul.tabs li").removeClass("active"); //Remove any "active" class
		$(this).addClass("active"); //Add "active" class to selected tab
		$(".tab_content").hide(); //Hide all tab content

		var activeTab = $(this).find("a").attr("href"); //Find the href attribute value to identify the active tab + content
		$(activeTab).fadeIn(); //Fade in the active ID content
		return false;
	});

});
    </script>
    <script type="text/javascript">
    $(function(){
        $('.column').equalHeight();
    });
</script>

    <style type="text/css">
<!--
.STYLE2 {font-size: 14}
.STYLE3 {font-size: 16px}
-->
    </style>
</head>


<body>

	<header id="header">
		<hgroup>
			<h1 class="site_title"><a href="index.jsp">System Administrator</a></h1>
			<h2 class="section_title">Board</h2>
		</hgroup>
	</header> <!-- end of header bar -->
	
	<section id="secondary_bar">
		<div class="user">
			<p><c:out value="${uname}"></c:out>		
			 <a href="login.jsp" ><input style="margin-left:80px" name="submit2" type="submit" class="logout_user" value="退出" ></a>
			</p>
			
			
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
	  </div>
		<div class="breadcrumbs_container">
		  <article class="breadcrumbs"><a href="index.jsp">System Admin</a> <div class="breadcrumb_divider"></div> <a class="current">Board</a></article>
	  </div>
	</section><!-- end of secondary bar -->
	
<aside id="sidebar" class="column">
		<h3>用户管理</h3>
		<ul class="toggle">
			<li><a class="ajax-link" href="index.jsp"><i class="icn_add_user"></i><span class="hidden-tablet"> 添加管理员</span></a></li>
			<li><a class="ajax-link" href="UserlistServlet"><i class="icon-user"></i><span class="hidden-tablet"> 用户列表</span></a></li>
	  </ul>
		<h3>预案管理</h3>
		<ul class="toggle">
			<li ><a href="PlanlistServlet">预案列表</a></li>
		</ul>
		<h3>字段管理</h3>
<ul class="toggle">
			  <li ><a href="FieldlistServlet">字段列表</a></li>
			  
  </ul>
		
		<h3>公告管理</h3>
		<ul class="toggle">
		  <li >
		    <div align="left"><a href="inform_add.jsp">发布公告</a></div>
		  </li>
          <li >
            <div align="left"><a href="InformlistServlet">公告列表</a></div>
          </li>
  </ul>
	<footer>
		<hr />
		
	</footer>
</aside><!-- end of sidebar -->
	
	<section id="main" class="column">
	  <article class="module width_full">
		<header>
		  <h3>用户详情</h3>
		</header>
			<div class="module_content">
				<article class="stats_graph">
					<fieldset style="width:150%; float:left;">
                    <p><h4>用户名：<c:out value="${user.uname}"></c:out></h4> 
                    <p><h4>用户id：<c:out value="${user.userid}"></c:out></h4>
                    <p><h4>用户密码：<c:out value="${user.upassword}"></c:out></h4>
                    <p><h4>邮箱：<c:out value="${user.uemail}"></c:out></h4>
                    <p><h4>性别：<c:out value="${user.usex}"></c:out></h4>
                    <p><h4>年龄：<c:out value="${user.uage}"></c:out></h4>
                    <p><h4>用户等级：<c:out value="${user.ulevel}"></c:out></h4>
                     <p>&nbsp;</p>
                    <h3>预案表</h3>
					<c:forEach items="${plist}" var="p">
                    <p><h4>预案名：<c:out value="${p.pname}"></c:out></h4> 
                    <p><h4>预案类型：<c:out value="${p.ptype}"></c:out></h4> 
                    </c:forEach>
					</fieldset>
				    <blockquote>	
				      <p>&nbsp;</p>
			        </blockquote>
				    <p>&nbsp;</p>
				</article>
				<div class="clear">
				  <p>&nbsp;</p>
				  <p>
				    <span class="submit_link">
				      <a href="UserlistServlet"> <input name="submit3" type="submit" class="alt_btn" value="Return"> </a>
				    </span> 
				  </div>
			</div>
	  </article><!-- end of stats article --><!-- end of content manager article -->
      <!-- end of messages article -->
      <!-- end of post new article -->
      <!-- end of styles article -->
<div class="spacer"></div>
</section>


</body>

</html>