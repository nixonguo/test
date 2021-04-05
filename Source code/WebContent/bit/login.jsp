<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<html:form action="/login">
		Username:<html:text property="username"/>
		Password:<html:password property="password"/>
		<input type="button" value="Login" onclick="home()"/>
		<input type="button" value="Hello" onclick="hello()"/>
		
		<br />
		<logic:notEmpty name="loginForm" property="actMsg">
		  <span style="color:blue;"><bean:write name="loginForm" property="actMsg" /></span><br />
		</logic:notEmpty>
		<logic:notEmpty name="loginForm" property="errMsg">
		  <span style="color:red;"><bean:write name="loginForm" property="errMsg" /></span><br />
		</logic:notEmpty>
				
		<%

		out.println("********** READ PROPERTIES *******************");
		out.println(setting.PropsReader.getValue("/mnt/multiconfig/example.property.file.properties", "property.1"));
		out.println(setting.PropsReader.getValue("/mnt/multiconfig/example.property.file.properties", "property.2"));
		out.println(setting.PropsReader.getValue("/mnt/multiconfig/example.property.file.properties", "property.3"));
		%>		
				
				
		<html:hidden property="task"/>
	</html:form>
	
	<script language="javascript" type="text/javascript">
		function home() {
			document.forms[0].task.value='home';
			document.forms[0].submit();
		}
		
		function hello(){
			document.forms[0].action='hello.do';
			document.forms[0].task.value='';
			document.forms[0].submit();
		}
	</script>
</body>
</html>