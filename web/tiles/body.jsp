<%-- 
    Document   : body
    Created on : 3/05/2018, 11:25:13 AM
    Author     : WUNDERTEC
--%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


Bodyyyy
<a href="login.do">login</a> 
 

<c:if test="${user.id  == null }">
  
</c:if>
<c:if test="${user.id  != null }">
    <button class="btn btn-info" id="btnCerrarSesion">Cerrar Sesion</button>
    <h2>Hola  ${user.nombre}</h2>
</c:if>
<!--login.js-->
<script type="text/javascript" src="./js/login.js"></script>
