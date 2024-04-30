<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8" />
        <title>Novo Gênero</title>
    </head>
    <body>
        <h1>Novo Gênero</h1>
        <form action="/generos/insert" method="post">
            <div>
                <label>Nome:</label>
                <input type="text" name="nome" />
            </div>
            <a href="/generos/list">Voltar</a>
            <button type="submit">Salvar</button>
        </form>
    </body>
</html>

