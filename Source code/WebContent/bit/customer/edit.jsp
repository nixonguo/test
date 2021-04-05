<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<br/>
	<h2>DETAIL CUSTOMER PAGE 1</h2>
	<html:form action="/customer">
		<table>
			<tr>
				<td>Name</td>
				<td><html:text property="name"/></td>
			</tr>
			<tr>
				<td>Address</td>
				<td>
					<html:textarea property="address" cols="100" rows="3"/><br/>
				</td>
			</tr>
			
		</table>
		<logic:equal name="customerForm" property="task" value="add">
			<input type="button" value="Next Page" onclick="openTask('addPage2')"/>
		</logic:equal>
		<logic:equal name="customerForm" property="task" value="edit">
			<input type="button" value="Next Page" onclick="openTask('editPage2')"/>
			<input type="button" value="Delete" onclick="deleteData()"/>
		</logic:equal>
		<logic:equal name="customerForm" property="task" value="addPage1">
			<input type="button" value="Next Page" onclick="openTask('addPage2')"/>
		</logic:equal>
		<logic:equal name="customerForm" property="task" value="editPage1">
			<input type="button" value="Next Page" onclick="openTask('editPage2')"/>
			<input type="button" value="Delete" onclick="deleteData()"/>
		</logic:equal>
		<input type="button" value="Back" onclick="openTask('list')"/>
		
		<html:hidden property="task"/>
		<html:hidden property="id"/>
		<html:hidden property="gender"/>
		<html:hidden property="idType"/>
		<html:hidden property="idNo"/>
		<html:hidden property="isDeactivated"/>
	</html:form>
	
	<script language="javascript" type="text/javascript">
		if ( window.history.replaceState ) {
	        window.history.replaceState( null, null, window.location.href );
	    }
		
		function deleteData() {
			if(confirm("Delete Data?")) {
				document.forms[0].task.value='delete';
				document.forms[0].submit();
			}
		}
		function openTask(task) {
			document.forms[0].task.value=task;
			document.forms[0].submit();
		}
	</script>
</body>
</html>