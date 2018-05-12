$(document).ready(function () {
    let session = window.localStorage;

    $("#btnLogin").click(function () {

        var email = $("#email").val();
        var contrasenia = $("#pass").val();
       

        $.ajax({
            async: true,
            method: "POST",
            url: "./buscarEmail.do",
            dataType: "json",
            data: {
                email: email
            },
            success: function (data) {
                if (data == true || data == 'true') {
                    $.ajax({
                        async: true,
                        method: "POST",
                        url: "./loginUser.do",
                        dataType: "json",
                        data: {
                            email: email,
                            contrasenia: contrasenia
                        },
                        success: function (data) {
                            console.log(data);
                            if (data.nombre != null) {
                                $.session.set('user', data.nombre);
                                $.session.get('user');
                                console.log("BIENVENIDO: " + $.session.get('user'));
                                $("#iniciarSesion").html("");
                                window.location.href = "main.do";

                                $('#spinLoader').removeClass('blur');
                                $(".loader").remove();
                            } else if (data.id == 0) {
                                alert("contraseña invalida!");
                            }


                        }

                    });
                } else {
                    console.log("else");
                    
                    alert("usuario no existe!");
                    alert("");
                }


            }

        });


    });
    
    $("#btnCerrarSesion").click(function () {
        
        $.ajax({
            async: true,
            type: "POST",
            url: "./logout.do",
            dataType: "json",

        });
        location.reload();
    });
    
});
