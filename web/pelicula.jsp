<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" 
              integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

        <link href="css/usu.css" rel="stylesheet" type="text/css"/>
        <title>Crud cine</title>
    </head>
    <body>
        <div class="col-sm-12">
            <div class="card">
                <div class="card-body">
                    <br>
                    <div class="d-flex col-sm-12 ml-auto">
                        <a class="btn btn-primary" data-toggle="modal" 
                           data-target="#agregar" href="#">
                            Agregar
                        </a>

                        <div class="ml-auto">
                            <form class="form-inline" action="C_Pelicula?menuPelicula=menu" method="POST">
                                <input minlength="1" maxlength="4" type="search" name="txtBuscar" class="form-control" 
                                      pattern="[0-9]+">
                                <input type="submit" name="accionPelicula" value="Buscar" class="btn btn-outline-success">
                            </form>
                        </div>

                    </div>
                    <br>
                    <table class="table table-hover">
                        <thead>
                            <tr class="text-center">
                                <th scope="col" style="visibility: hidden">#</th>
                                <th scope="col">Titulo</th>
                                <th scope="col">Duración</th>
                                <th scope="col">Categoria</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="pel" items="${tablaPeli}">
                                <tr class="text-center">
                                    <th scope="row" style="visibility: hidden">${pel.getId()}</th>
                                    <td>${pel.getTitulo()}</td>
                                    <td>${pel.getDuracion()}</td>
                                    <td>${pel.getCategoria()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <div class="modal fade" id="agregar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" 
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">
                            Agregar
                        </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>

                    <div class="modal-body">

                        <form action="C_Pelicula?menuPelicula=menu" method="POST">
                            <div class="form-group">
                                <div class="container">
                                    
                                    <label class="col-form-label">Título de la Pelicula</label>
                                    <input minlength="1" maxlength="50" type="text" name="txtTitulo" class="form-control" required 
                                           placeholder="Título">

                                    <label class="col-form-label">Duracion: </label>
                                    <input minlength="1" maxlength="50" type="number" name="txtDuracion" class="form-control" required 
                                           placeholder="Duración" pattern="[0-9]+">
                                    
                                     <div>
                                        <label class="col-form-label">Categoria </label>
                                        <select name="sel_quantity" id="sel_quantity" class="custom-select my-1 mr-sm-2"
                                                onChange="mostrarProv(this.value);">
                                            <c:forEach var="comI" items="${comboCate}">
                                                <option value="${comI.getId()}">${comI.getDescripcion()}</option>
                                            </c:forEach>
                                        </select>
                                        <input type="text" name="inte" id="inte" class="form-control" 
                                               value="1" style="visibility: collapse"/>
                                    </div>
                                </div>
                            </div>

                            <div class="modal-footer">                        
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                    Cerrar
                                </button>

                                <button type="submit" name="accionPelicula" value="Agregar"
                                        class="btn btn-primary">
                                    Guardar
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <script>
            var mostrarProv = function (x) {
                document.getElementById('inte').value = x;
            }

            var mostrarProd = function (x) {
                document.getElementById('usu').value = x;
            }

            var mostrarProvC = function (x) {
                document.getElementById('intec').value = x;
            }

            var mostrarProdC = function (x) {
                document.getElementById('usuc').value = x;
            }
        </script>
        <script src="js/main.js" type="text/javascript"></script>
        <script src="vendor/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    </body>
</html>
