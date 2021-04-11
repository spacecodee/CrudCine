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
                    <table class="table table-hover">
                        <thead>
                            <tr class="text-center">
                                <th scope="col" style="visibility: hidden">#</th>
                                <th scope="col">Descripción</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="pel" items="${tablaCate}">
                                <tr class="text-center">
                                    <th scope="row" style="visibility: hidden">${pel.getId()}</th>
                                    <td>${pel.getCategoria()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        
    </body>
</html>
