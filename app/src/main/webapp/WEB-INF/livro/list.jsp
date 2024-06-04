<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <title>Livros</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <h1>Livros</h1>
            <a href="/livros/insert" class="btn btn-primary">Novo Livro</a>
            <table class="table">
                <tr>
                    <th>Id</th>
                    <th>Titulo</th>
                    <th>Genero</th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach var="item" items="${livros}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.titulo}</td>
                        <td>${item.genero.nome}</td>
                        <td>
                            <a href="/livros/update?id=${item.id}" class="btn btn-secondary">Editar</a>
                            <a href="/livros/delete?id=${item.id}" class="btn btn-danger">Excluir</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>