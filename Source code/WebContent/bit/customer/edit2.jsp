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
	<h2>DETAIL CUSTOMER PAGE 2</h2>
	<html:form action="/customer">
		<table>
			<tr>
				<td>Gender</td>
				<td>
					<html:radio property="gender" value="M"/>Male<br/>
					<html:radio property="gender" value="F"/>Female
				</td>
			</tr>
			<tr>
				<td>ID Type</td>
				<td>
		         	<html:select property="idType">
			            <html:option value=""/>
			            <%-- <html:options collection="cbIdType" property="key" labelProperty="value"/> --%>
			            <html:optionsCollection property="cbIdType" value="key" label="value"/>
		          	</html:select>
				</td>
			</tr>
			<tr>
				<td>ID No</td>
				<td><html:text property="idNo"/></td>
			</tr>
			<tr>
				<td>Is Deactivated</td>
				<td>
					<html:checkbox property="isDeactivated"/>
					<html:hidden property="isDeactivated" value="false"/>
				</td>
			</tr>
			
		</table>
		<logic:equal name="customerForm" property="task" value="addPage2">
			<input type="button" value="Previous Page" onclick="openTask('addPage1')"/>
			<input type="button" value="Save" onclick="save('insert')"/>
		</logic:equal>
		<logic:equal name="customerForm" property="task" value="editPage2">
			<input type="button" value="Previous Page" onclick="openTask('editPage1')"/>
			<input type="button" value="Save" onclick="save('update')"/>
			<input type="button" value="Delete" onclick="deleteData()"/>
		</logic:equal>
		
		<html:hidden property="task"/>
		<html:hidden property="id"/>
		<html:hidden property="name"/>
		<html:hidden property="address"/>
	</html:form>
	
	<script language="javascript" type="text/javascript">
		if ( window.history.replaceState ) {
	        window.history.replaceState( null, null, window.location.href );
	    }
		
		function validate() {
			with(document.forms[0]) {
				if(name.value=='') {
					alert("Entry required in Name");
					return false;
				}
				else if (gender[0].checked==false && gender[1].checked==false) {
					alert("Entry required in Gender");
					return false;
				}
				else if (idType.selectedIndex==0) {
					alert("Entry required in Id Type");
					return false;
				}
				return true;
			}
		}
		function save(task) {
			if(validate()){
				if(confirm("Save Data?")) {
					document.forms[0].task.value=task;
					document.forms[0].submit();
				}
			}
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