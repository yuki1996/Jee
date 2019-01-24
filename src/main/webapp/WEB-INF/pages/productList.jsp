<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
 
</head>
<body>
 
  
   <fmt:setLocale value="en_US" scope="session"/>
 
   <div class="page-title">Product List</div>
 
 <a style="color:green;"
              href="${pageContext.request.contextPath}/product">
                add Product</a>
 
   <c:forEach items="${paginationProducts.list}" var="prodInfo">
       <div class="product-preview-container">
           <ul>
               <li>Code: ${prodInfo.code}</li>
               <li>Name: ${prodInfo.name}</li>
                <li><a style="color:orange;"
              href="${pageContext.request.contextPath}/product?code=${prodInfo.code}">
                Edit Product</a></li>
                <li><a style="color:red;"
              href="${pageContext.request.contextPath}/removeProduct?code=${prodInfo.code}">
                delete Product</a></li>
           </ul>
       </div>
 
   </c:forEach>
   <br/>
  
 
   <c:if test="${paginationProducts.totalPages > 1}">
       <div class="page-navigator">
          <c:forEach items="${paginationProducts.navigationPages}" var = "page">
              <c:if test="${page != -1 }">
                <a href="productList?page=${page}" class="nav-item">${page}</a>
              </c:if>
              <c:if test="${page == -1 }">
                <span class="nav-item"> ... </span>
              </c:if>
          </c:forEach>
          
       </div>
   </c:if>
 
</body>
</html>