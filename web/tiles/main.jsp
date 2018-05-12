<%-- 
    Document   : main
    Created on : 3/05/2018, 11:24:34 AM
    Author     : Erick
--%>

<%@taglib uri="../WEB-INF/struts-tiles.tld" prefix="tiles" %>

<%@page contentType="text/html"%> 
<%@page pageEncoding="UTF-8"%>
<!-- -->
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <!--Icon-->
        <link rel="stylesheet" href="css/dist/font-awesome.css">
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="css/dist/bootstrap.css" >
        
          <!--jquery.js-->
        <script type="text/javascript" src="./js/dist/jquery.js"></script>
        <script type="text/javascript" src="./js/dist/jquery.session.js"></script>
        
        
        
        <!--bootstrap.js-->
        <script type="text/javascript" src="./js/dist/tether.min.js"></script>
        <script type="text/javascript" src="./js/dist/bootstrap.min.js"></script>
        
    </head>
    <body>
        
        <tiles:insert attribute="body"/>
    </body>
</html>
