<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Jadi usernamenya adalah <bean:write name="loginForm" property="username"/>
	dan passwordnya adalah <bean:write name="loginForm" property="password"/>
	<html:form action="/login">
		<input type="button" value="Open Customer" onclick="openCustomer()"/>
		<a href="customer.do?task=list" >link customer</a>
		
		<logic:empty name="loginForm" property="password">
			password dikosongkan
		</logic:empty>
		<logic:notEmpty name="loginForm" property="password">
			<html:text property="password"/>
		</logic:notEmpty>
		
		<logic:present name="loginForm" property="listData">
		<br />
		<br />
		
		<%  
			form.LoginForm frm = (form.LoginForm)session.getAttribute("loginForm");
	      	out.print("session frm.getUsername()) = " + frm.getUsername());
	      	
			out.println("********** READ PROPERTIES *******************");
			out.println(setting.PropsReader.getValue("/mnt/multiconfig/example.property.file.properties", "property.1"));
			out.println(setting.PropsReader.getValue("/mnt/multiconfig/example.property.file.properties", "property.2"));
			out.println(setting.PropsReader.getValue("/mnt/multiconfig/example.property.file.properties", "property.3"));
	    %>
		
		<logic:iterate id="list" name="loginForm" property="listData">
			<bean:write name="list" property="nama_debitur"/>-<bean:write name="list" property="no_cis"/><br/>
		</logic:iterate>
		</logic:present>
		<html:hidden property="task" styleId="task"/>
	</html:form>
	
	
	<script language="javascript" type="text/javascript">
		function openCustomer() {
			document.forms[0].task.value='list';
			document.forms[0].action='customer.do';
			document.forms[0].submit();
		}
	</script>
</body>
</html>