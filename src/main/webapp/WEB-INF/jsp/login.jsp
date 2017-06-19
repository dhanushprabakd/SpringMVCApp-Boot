<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
</head>

<script type="text/javascript">
	function submitForm() {
		var userName = document.getElementById('userName').value;
		var password = document.getElementById('password').value;
		console.log(userName + ' ' + password);
		debugger;
		if(userName == '' || password == '') {
			alert('please enter username and password');
			return;
		}
		
		document.getElementById('loginForm').submit();
	}
	
</script>
<body>


	<div class="container">
		<div class="row">
			<div class="col-md-offset-5 col-md-3">
				<div class="form-login">
					<h4><span class="label label-danger">${message}</span></h4>
					<h4>Login</h4>
					<form id='loginForm' action="<%=request.getContextPath()%>/login.do" method="post">
					
						<input type="text" id="userName" name="userName"
							class="form-control input-sm chat-input" placeholder="username" />
						</br> <input type="password" id="password" name='password'
							class="form-control input-sm chat-input" placeholder="password" />
						</br>
						<div class="wrapper">
							<button type="button" class="btn btn-default" onclick="submitForm()">Login</button>
						</div>
					</form>
				</div>

			</div>
		</div>


		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
			integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
			crossorigin="anonymous"></script>
</body>
</html>