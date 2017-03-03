<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
HttpSession session1= request.getSession();
String uname=(String)session1.getAttribute("uname");
	if(uname==null){uname="我的账户";}
	request.setAttribute("uname", uname);
%>
<html>
  <head>  
   <base href="<%=basePath%>">
    
   <script>  
var Checking = {};  
Checking = {  
  
    $ : function(id) {  
        return document.getElementById(id);  
    },  
  
    color : ['#FF0000', '#00FF66', '#FFFF00', '#FFCC00', '#6600FF', '#0000FF','#99FFFF', '#66CCFF'],  
    cacheValue : null,// 缓存画布上的值,比对时用  
  
    draw : function() {  
        var div = this.$('ieContainer'), sty = div.style;  
        div.onselectstart = new Function("return false");// 禁止选中  
        div.oncopy = new Function("return false");// 禁止复制  
        sty.height = "30px";  
        sty.width = "125px";  
        var bgColor = this.getRandomColor();// div背景色  
        sty.backgroundColor = bgColor;  
        sty.font = "26pt Kristen ITC";  //Calibri  
        var fontColor = this.getRandomColor();// 文字颜色  
        sty.color = bgColor == fontColor ? this.getRandomColor() : fontColor;// 保证文字色基本不会跟背景色一样  
        sty.textAlign = "center";  
        // 设置div颜色渐变效果  
        sty.filter = "progid:DXImageTransform.Microsoft.Gradient(GradientType=1, StartColorStr= "  
                + bgColor + ", EndColorStr= " + this.getRandomColor() + ")";  
        var newText = this.getRandomDigit_Letters(5);  
        this['cacheValue'] = newText;// 临时存贮生成的验证码，校验时使用  
        div.innerHTML = newText;  
    },  
    //画背景  
    //createLinearGradient() 方法创建一条线性颜色渐变。返回一个线性颜色渐变的一个 CanvasGradient对象。  
    drawBgColor : function(context) {  
        var grd = context.createLinearGradient(100, 100, 70, 18);  
        var startColor = this.getRandomColor();  
        var endColor = this.getRandomColor();  
        grd.addColorStop(0, startColor);  
        grd.addColorStop(1, startColor == endColor  
                ? this.getRandomColor()  
                : endColor);  
        context.fillStyle = grd;  
        context.fillRect(100,100, 800, 600);  
    },  
  
    //画文字  
    drawText : function(context) {  
        var x = 60;  
        var y = 30;  
        context.font = "30pt Kristen ITC";  
        context.textAlign = "center";  
        context.fillStyle = this.getRandomColor();  
        var newText = this.getRandomDigit_Letters(5);  
        this['cacheValue'] = newText;  
        context.fillText(newText, x, y);  
    },  
  
    //获得随机颜色  
    getRandomColor : function() {  
        var len = this.color.length, random = this.getBigRandom(len);  
        return this['color'][random];  
    },  
  
    //根据scale以内的随机整数  
    getBigRandom : function(scale) {  
        return Math.floor(Math.random() * (scale || 10));  
    },  
  
    //获得画布上的字符串,字母与数字的随机组合  
    getRandomDigit_Letters : function(length) {  
        var result = [];  
        var arr = this.getLetters().concat(this.getDigit());  
        for (var i = 0; i < length; i++) {  
            result.push(arr[this.getBigRandom(35)]);  
        }  
        return result.join("");  
  
    },  
  
    //获得0～9的数组  
    getDigit : function() {  
        var arr = [];  
        for (var i = 0; i < 10; i++) {  
            arr.push(i);  
        }  
        return arr;  
    },  
  
    //获得a～z的字母数组  
    getLetters : function() {  
        var arr = [];  
        var start = "a".charCodeAt();  
        var end = "z".charCodeAt();  
  
        for (var i = start; i <= end; i++) {  
            if (i % 2 == 0) {  
                arr.push(String.fromCharCode(i));  
            } else {  
                arr.push(String.fromCharCode(i).toUpperCase());  
            }  
  
        }  
        return arr;  
    },  
  
    // 判断  
    check : function()  
  
    {  
        var chkValue = this['cacheValue'].toUpperCase();  
        var inputValue = this.$('chk').value.toUpperCase();  
        if (chkValue !== inputValue)  
        {  
            alert("验证码输入错误！");  
            return false;  
        }  
        else  
            return true;  
    }  
}; 
  
function Juge(theForm)  
{  
    var a=Checking.check();  
    if(a)  
        return true;  
    else  
    {   Checking.draw();  
        return false;  
    }  
}  
</script>  
	<title>管理员登录</title>
	
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
  
  <body onLoad="Checking.draw()" >

	<header id="header">
	<hgroup>
			<h1 class="site_title"><a href="index.jsp">System Administrator</a></h1>
			<h2 class="section_title">LoginBoard</h2>
		</hgroup>
	</header> 
    <article  class="module width_half"  style="margin-left:25%;width:50%;">
<header>
		  <h3 align="center">管理员登录</h3>
</header>
								
					    <form id="loginform" action="LoginServlet" method="Get">
                        <p>
                            <label style="margin-left:25%"><span class="STYLE2"><span class="STYLE3">用户名</span>：<br>
                            </span><br>
                            </label>
							<input style="margin-left:30%" type="text" name="uname" />
                        </p >
                        <p class="col">
                            <label style="margin-left:25%"> <span class="STYLE3">密码</span>：</label>
                        </p>
                        <p class="col">
                          <input style="margin-left:30%" type="password"  name="upassword" />
                        </p>
                        <div>
                        <p>
                           <label style="margin-left:25%"> <span class="STYLE3">验证码</span>：</label>
                        </p>			
                				<div style="margin-left:30%" id="ieContainer" onDblClick="Checking.init()"> </div>  
        
                <br/>  
                <p>
                    <label style="margin-left:30%" ><input type='text' id="chk"> </label>  
                   </p>  
            </div>  
						
                        <p>
						    <input style="margin-left:33%" type="submit" value="登陆" />
                        </p>
                   </form>
			<div class="module_content">
			  <div class="clear"></div>
			</div>
	  <!-- end of stats article -->
	  </article>
	  
</body>
</html>
