<%-- 
    Document   : login
    Created on : 3/05/2018, 11:24:21 AM
    Author     : WUNDERTEC
--%>
<!--login.css-->
<link rel="stylesheet" href="css/login.css">


<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <h1>Inicia Sesion!</h1>
    </div>
    <div class="col-md-4"></div>
</div>
<br>

<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4 login">
        <div class="form-group">
            <label for="exampleInputEmail1">Email</label>
            <input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Ingreda tu email">
            <small id="emailHelp" class="form-text text-muted">Correo con el que estas registrado.</small>
        </div>
        <div class="form-group">
            <label for="exampleInputEmail1">Password</label>
            <input type="password" class="form-control" id="pass" placeholder="Password">
            <small id="emailHelp" class="form-text text-muted">No compartas tu password con ninguna persona.</small>
            <button class="btn btn-info pull-right" name="btnLogin" id="btnLogin">enviar</button>
            <div class="row" style="height: 30px;"></div>
        </div>
        
    </div>
    <div class="col-md-4"></div>
</div>


<!--login.js-->
<script type="text/javascript" src="./js/login.js"></script>
