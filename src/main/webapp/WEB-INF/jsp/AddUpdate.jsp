<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript">
	function registerWithPost() {
		alert('registerWithPost called');
		this.form.action = "<%= request.getContextPath() %>/user/registerUser";
		this.form.method = 'post';
		alert('Before called');
		this.form.submit();
		alert('after called');
	}
	
	function registerWithGet() {
		alert('registerWithGet called');
		this.form.action = "<%= request.getContextPath() %>/user/registerUserInfo";
		this.form.method = 'get';
		alert('Before called');
		this.form.submit();
		alert('after called');
	}
</script>

<style>
.error {
	color: #ff0000;
}

.errorblock{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding:8px;
	margin:16px;
}
</style>
</head>
<script type="text/javascript">
	function submitForm() {

		var salary = document.getElementById('Salary').value;
		var firstName = document.getElementById('firstName').value;
		var lastName = document.getElementById('lastName').value;

		if (salary < 10000 || (firstName + lastName).length < 8) {

			alert('Salary should be greater than 1000 and the name should be of min 8 characters');
			return;
		}

		document.getElementById('addUpdateform').submit();
	}
</script>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-5 col-md-3">
				<div class="form-login">
					<h4>
						<span class="label label-danger">${message}</span>
					</h4>
					<h4>Add/Update Employee Details</h4>
					<form:form id='addUpdateform'
						action="/employee/addUpdate.do"
						method="post" commandName="employee">
						<form:errors path="*" cssClass="errorblock" element="div" />
	
		${message}
	
	    <table>
							<tr>
								<td><spring:message code="employee.number.lbl" />:</td>
								<td><form:input path="number" /></td>
								<td><form:errors path="number" /></td>
							</tr>

							<tr>
								<td><spring:message code="employee.FirstName.lbl" />:</td>
								<td><form:input path="firstName" /></td>
								<td><form:errors path="firstName" cssClass="error" /></td>
							</tr>
							<tr>
								<td><spring:message code="employee.LastName.lbl" />:</td>
								<td><form:input path="lastName" /></td>
								<td><form:errors path="lastName" cssClass="error" /></td>
							</tr>
							<tr>
								<td><spring:message code="employee.gender.lbl" />:</td>
								<td><form:checkbox path="gender" value="M" />Male <form:checkbox
										path="gender" value="F" />Female</td>
								<td><form:errors path="gender" cssClass="error" /></td>
							</tr>

							<tr>
								<td><spring:message code="employee.dob.lbl" />:</td>
								<td><form:input path="birthDate" />(MM-DD-YYYY)</td>
								<td><form:errors path="birthDate" cssClass="error" /></td>
							</tr>

							<tr>
								<td><spring:message code="employee.hireDate.lbl" />:</td>
								<td><form:input path="hireDate" />(MM-DD-YYYY)</td>
								<td><form:errors path="hireDate" cssClass="error" /></td>
							</tr>
							<tr>
								<td><spring:message code="employee.Salary.lbl" />:</td>
								<td><form:input path="salary" /></td>
								<td><form:errors path="salary" cssClass="error" /></td>
							</tr>
							<tr>
								<td><spring:message code="employee.deptName.lbl" />:</td>
								<td><form:select path="deptName">
										<form:options items="${deptNames}" />
									</form:select></td>
								<td><form:errors path="deptName" /></td>
							</tr>
							<tr>
								<td colspan="3"><input type="submit" value="Add/Update" /></td>
							</tr>
						</table>
					</form:form>
				</div>

			</div>
		</div>



	</div>
</body>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</html>