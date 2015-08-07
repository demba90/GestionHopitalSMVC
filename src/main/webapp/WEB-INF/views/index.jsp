<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Connexion</title>
	    <!-- Bootstrap -->
	    <link href="<%=request.getContextPath()%>/resources/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
	    <link href="<%=request.getContextPath()%>/resources/assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
	    <link href="<%=request.getContextPath()%>/resources/assets/css/styles.css" rel="stylesheet" media="screen">
	      <link rel="icon" href="<%=request.getContextPath()%>/resources/assets/images/favicon.png" sizes="16x16" type="image/png">
	     <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	    <!--[if lt IE 9]>
	      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	    <![endif]-->
	    <script src="<%=request.getContextPath()%>/resources/assets/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
	</head>
	<body id="login">
	    <div class="container">
			
	      <f:form class="form-signin" action="accueil" method="post">
	        <h2 class="form-signin-heading" >Connexion</h2>
	        <input type="text" class="input-block-level" name="username" placeholder="Username">
	        <input type="password" class="input-block-level" name="password" placeholder="Password">
	        <label class="checkbox">
	          <input type="checkbox" value="remember-me"> Se souvenir de moi
	        </label>
	        <button class="btn btn-large btn-primary" type="submit" name="signin">Connexion</button>
	      </f:form>
	
	    </div> <!-- /container -->
	    <script src="<%=request.getContextPath()%>/resources/assets/jquery-1.9.1.min.js"></script>
	    <script src="<%=request.getContextPath()%>/resources/assets/bootstrap/js/bootstrap.min.js"></script>
  	</body>
</html>