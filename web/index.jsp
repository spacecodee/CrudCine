<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/simple-sidebar.css" rel="stylesheet">
        <title>Crud cine</title>
    </head>
    <body>
        <div class="d-flex" id="wrapper">

            <!-- Sidebar -->
            <div class="text-black bg-dark border-right" id="sidebar-wrapper">
                <div class="sidebar-heading" style="color: #FFF">
                    Examen
                </div>
                <div class="list-group list-group-flush">
                    <a href="C_Pelicula?menuPelicula=menu&accionPelicula=Listar" style="color: #FFF"
                       class="list-group-item list-group-item-action bg-dark" target="myFrame">
                        Peliculas
                    </a>
                    <a href="C_Categoria?menuCategoria=menu&accionCategoria=Listar" style="color: #FFF"
                       class="list-group-item list-group-item-action bg-dark" target="myFrame">
                        Categorias
                    </a>
                </div>
            </div>
            <!-- /#sidebar-wrapper -->

            <!-- Page Content -->
            <div id="page-content-wrapper">

                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <button class="btn btn-primary bg-dark" id="menu-toggle">
                        Menú
                    </button>

                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </nav>

                <div class="m-4" style="height: 1000px">
                    <iframe name="myFrame" style="height: 100%; width: 100%; border: none">

                    </iframe>
                </div>
            </div>
            <!-- /#page-content-wrapper -->

        </div>
        <!-- /#wrapper -->

        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="js/main.js" type="text/javascript"></script>
    </body>
</html>
