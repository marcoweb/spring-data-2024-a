<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <title>Remover Livro</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <h1>Remover Livro</h1>
            <form action="/livros/delete" method="post">
                <input type="hidden" name="id" value="${livro.id}" />
                <p>Tem certeza que deseja remover o livro ${livro.titulo} ?</p>
                <hr />
                <a href="/livros/list" class="btn btn-secondary">Voltar</a>
                <button type="submit" class="btn btn-danger">Excluir</button>
            </form>
        </div>
    </body>
</html>

