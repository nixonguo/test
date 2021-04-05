<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<html:form action="/customer">
		<%-- Hello, <bean:write name="customerForm" property="username"/>--%>
		<br/>
		<h2>CUSTOMER LIST</h2>
		<bean:write name="customerForm" property="message"/>
		<bean:write name="customerForm" property="address"/>
		
		
		<%  
			form.LoginForm frm = (form.LoginForm)session.getAttribute("loginForm");
	      	out.print("session frm.getUsername()) = " + frm.getUsername());
	    %>
		
		<input type="button" value="Add Customer" onclick="openAdd()"/>
		<table border=1>
			<tr>
				<td>Name</td>
				<td>Gender</td>
				<td>Address</td>
			</tr>
			<logic:empty name="customerForm" property="listCustomer">
				<tr><td colspan=3>TIDAK ADA DATA</td></tr>
			</logic:empty>
			<logic:notEmpty name="customerForm" property="listCustomer">
				<logic:iterate id="list" name="customerForm" property="listCustomer">
					<tr>
						<td>
							<a href="javascript:openEdit('<bean:write name="list" property="id"/>')">
								<bean:write name="list" property="name"/>
							</a>
						</td>
						<td><bean:write name="list" property="gender"/></td>
						<td><bean:write name="list" property="address"/></td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>
		</table>
		
		<html:hidden property="id"/>
		<html:hidden property="task"/>
	</html:form>
	
	<script language="javascript" type="text/javascript">
		if ( window.history.replaceState ) {
	        window.history.replaceState( null, null, window.location.href );
	    }
		
		function openEdit(id) {
			document.forms[0].task.value='edit';
			document.forms[0].id.value=id;
			document.forms[0].submit();
		}
		
		function openAdd() {
			document.forms[0].task.value='add';
			document.forms[0].submit();
		}
		
		function openTes() {
			document.forms[0].task.value='tes';
			document.forms[0].submit();
		}
	</script>
</body>
</html>