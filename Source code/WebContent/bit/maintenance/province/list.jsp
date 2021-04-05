<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html:html>
<head>
</head>
<body>
	<html:form action="/province">
		<table border="1" width="100%" cellspacing="0" >
			<tr>
				<td colspan="2"> Search Province</td>
			</tr>
			<tr>
				<td>
					Search By 
				</td>
				<td>
					<html:radio property="searchBy" value="PROVINCE_ID"/>Code<br/>
					<html:radio property="searchBy" value="PROVINCE_NAME"/>Description
				</td>
			</tr>
			<tr>
				<td>
					Enter Value
				</td>
				<td>
					<html:text property="searchValue" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" value="Search" onclick="doSearch()"/>
					<input type="button" value="Add" onclick="openAdd()"/>
				</td>
			</tr>
		</table>
		
		<br />
		<br />
		<table border="1" width="100%" cellspacing="0">
			<tr>
				<td>Code</td>
				<td>Description</td>
			</tr>
			<logic:empty name="provinceForm" property="listProvince">
				<tr><td colspan=3>TIDAK ADA DATA</td></tr>
			</logic:empty>
			<logic:notEmpty name="provinceForm" property="listProvince">
				<logic:iterate id="list" name="provinceForm" property="listProvince">
					<tr>
						<td>
							<a href="javascript:openEdit('<bean:write name="list" property="code"/>')">
								<bean:write name="list" property="code"/>
							</a>
						</td>
						<td><bean:write name="list" property="dsc"/></td>
					</tr>
				</logic:iterate>
			</logic:notEmpty>
		</table>
		
		<html:hidden property="task"/>
	</html:form>
	
	<script language="javascript" type="text/javascript">
		
		function doSearch() {
			document.forms[0].task.value='openList';
			document.forms[0].submit();
		}
		
		function openAdd() {
			document.forms[0].task.value='openAdd';
			document.forms[0].submit();
		}
	</script>
</body>
</html:html>