<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html>
<head>
</head>
<body>
	<br/>
	
	<html:form action="/province">
	<h2>
		<logic:equal name="provinceForm" property="task" value="openAdd">
			Add&nbsp;
		</logic:equal>
		<logic:equal name="provinceForm" property="task" value="openEdit">
			Edit&nbsp;
		</logic:equal>
		Province
	</h2>
		
		<table border="1" width="100%" cellspacing="0">
			<tr>
				<td>Code</td>
				<td>
				<logic:equal name="provinceForm" property="task" value="openAdd">
					<html:text property="code"/>
					
				</logic:equal>
				<logic:equal name="provinceForm" property="task" value="openEdit">
					<%-- <html:text property="code" disabled="true"/> --%>

					<html:hidden property="code" write="true"/>
				</logic:equal>
				</td>
			</tr>
			<tr>
				<td>Description</td>
				<td><html:text property="dsc"/></td>
			</tr>
			
		</table>
		
		<logic:equal name="provinceForm" property="task" value="openAdd">
			<input type="button" value="Save" onclick="save('insertData')"/>
		</logic:equal>
		<logic:equal name="provinceForm" property="task" value="openEdit">
			<input type="button" value="Save" onclick="save('updateData')"/>
		</logic:equal>
		<input type="button" value="Back" onclick="openTask('openList')"/>
		
		<html:hidden property="task"/>
		<html:hidden property="searchBy"/>
		<html:hidden property="searchValue"/>
	</html:form>
	
	<script language="javascript" type="text/javascript">
		function openTask(task) {
			document.forms[0].task.value=task;
			document.forms[0].submit();
		}
		
		function save(task) {
			if (document.forms[0].code.value == '') {
				alert('Code is required');
				document.forms[0].code.focus();
				return false;
			}
			if (document.forms[0].dsc.value == '') {
				alert('Description is required');
				document.forms[0].dsc.focus();
				return false;
			}
			
			openTask(task);
		}
	</script>
</body>
</html>