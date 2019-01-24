<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inventory List</title>
 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css">
 
</head>
<body>
 
  
   <fmt:setLocale value="en_US" scope="session"/>
 
   <div class="page-title">Inventory List</div>
 
 <a style="color:green;"
              href="${pageContext.request.contextPath}/inventory">
                add Inventory</a>
 
   <c:forEach items="${paginationInventories.list}" var="inventoryInfo">
       <div class="product-preview-container">
           <ul>
               <li><a style="color:orange;"
              href="${pageContext.request.contextPath}/inventoryAndProductsList?id=${inventoryInfo.id}">
                id: ${inventoryInfo.id}</a></li>
               <li><fmt:formatDate value="${inventoryInfo.createDate}" pattern="dd-MM-yyyy HH:mm"/></li>
               <li>Crée par: ${inventoryInfo.user.email}</li>
                <li> état :
                <c:if test="${inventoryInfo.etat eq false}">
                       fermé
                  </c:if>
                  <c:if test="${inventoryInfo.etat}">
                       ouvert
                  </c:if>
                </li>
                <li>
                <c:if test="${inventoryInfo.etat eq false}">
                       <a style="color:orange;"
			              href="${pageContext.request.contextPath}/openInventory?id=${inventoryInfo.id}">
			                ouvrir l'inventaire</a>
                  </c:if>
                  <c:if test="${inventoryInfo.etat}">
                       <a style="color:orange;"
			              href="${pageContext.request.contextPath}/closeInventory?id=${inventoryInfo.id}">
			                fermer l'inventaire </a>
                  </c:if>
               </li>
                <li><a style="color:red;"
              href="${pageContext.request.contextPath}/removeInventory?id=${inventoryInfo.id}">
                delete Inventory</a></li>
           </ul>
       </div>
 
   </c:forEach>
   <br/>
  
 
   <c:if test="${paginationInventories.totalPages > 1}">
       <div class="page-navigator">
          <c:forEach items="${paginationInventories.navigationPages}" var = "page">
              <c:if test="${page != -1 }">
                <a href="inventoryList?page=${page}" class="nav-item">${page}</a>
              </c:if>
              <c:if test="${page == -1 }">
                <span class="nav-item"> ... </span>
              </c:if>
          </c:forEach>
          
       </div>
   </c:if>
 
</body>
</html>