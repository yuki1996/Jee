<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
 
</head>
<body>
 
   <div class="page-title">User</div>
  
   <c:if test="${not empty errorMessage }">
     <div class="error-message">
         ${errorMessage}
     </div>
   </c:if>
 
   <form:form modelAttribute="userForm" method="POST" enctype="multipart/form-data">
       <table style="text-align:left;">
 
           <tr>
               <td>Email *</td>
               <td><form:input path="email" /></td>
               <td><form:errors path="email" class="error-message" /></td>
           </tr>
 			<tr>
               <td>Password *</td>
               <td><form:input path="password" /></td>
               <td><form:errors path="password" class="error-message" /></td>
           </tr>
           <tr>
               <td>role utilisateur *</td>
               <td><form:select path="userRole">
               			<form:option value="USER">Utilisateur</form:option>
        				<form:option value="ADMIN">Administrateur</form:option>
               		</form:select></td>
               <td><form:errors path="userRole" class="error-message" /></td>
           </tr>
           
        
 
 
           <tr>
               <td>&nbsp;</td>
               <td><input type="submit" value="Submit" /> <input type="reset"
                   value="Reset" /></td>
           </tr>
       </table>
   </form:form>
 
</body>
</html>