<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
 
</head>
<body>
 
  
   <fmt:setLocale value="en_US" scope="session"/>
 
   <div class="page-title">User List</div>
 
 
 
   <c:forEach items="${paginationUsers.list}" var="userInfo">
       <div class="product-preview-container">
           <ul>
               <li>id: ${userInfo.id}</li>
               <li>email: ${userInfo.email}</li>
               <li>password: ${userInfo.password}</li>
               <li>role: ${userInfo.userRole}</li>
                <li><a style="color:red;"
              href="${pageContext.request.contextPath}/user?id=${userInfo.id}">
                edit user</a></li>
           </ul>
       </div>
 
   </c:forEach>
   <br/>
  
 
   <c:if test="${paginationUsers.totalPages > 1}">
       <div class="page-navigator">
          <c:forEach items="${paginationUsers.navigationPages}" var = "page">
              <c:if test="${page != -1 }">
                <a href="userList?page=${page}" class="nav-item">${page}</a>
              </c:if>
              <c:if test="${page == -1 }">
                <span class="nav-item"> ... </span>
              </c:if>
          </c:forEach>
          
       </div>
   </c:if>
 
</body>
</html>