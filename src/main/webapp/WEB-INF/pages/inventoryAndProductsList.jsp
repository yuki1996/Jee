<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>InventoryAndProducts List</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
 
</head>
<body>
 
  
   <fmt:setLocale value="en_US" scope="session"/>
 
   <div class="page-title">InventoryAndProducts List</div>
 
<a style="color:green;"
              href="${pageContext.request.contextPath}/inventory">
                add Inventory</a>
 
   <c:forEach items="${paginationInventoryAndProducts.list}" var="inventoryInfo">
       <div class="product-preview-container">
           <ul>
               <li><a style="color:orange;"
              href="${pageContext.request.contextPath}/inventoryAndProductsList?id=${inventoryInfo.id}">
                id: ${inventoryInfo.id}</a></li>
               <li>quantity: ${inventoryInfo.quantity}</li>
                <li>product code: ${inventoryInfo.product.code}</li>
                <li>inventory: ${inventoryInfo.inventory.id}</li>
                <li><a style="color:red;"
              href="${pageContext.request.contextPath}/removeInventory?id=${inventoryInfo.id}">
                delete Inventory</a></li>
           </ul>
       </div>
 
   </c:forEach>
   <br/>
  
 
   <c:if test="${paginationInventoryAndProducts.totalPages > 1}">
       <div class="page-navigator">
          <c:forEach items="${paginationInventoryAndProducts.navigationPages}" var = "page">
              <c:if test="${page != -1 }">
                <a href="inventoryAndProductsList?page=${page}" class="nav-item">${page}</a>
              </c:if>
              <c:if test="${page == -1 }">
                <span class="nav-item"> ... </span>
              </c:if>
          </c:forEach>
          
       </div>
   </c:if>
 
</body>
</html>