<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>${nomApp}</title>
    </head>
    <body>
        <h1>Bienvenid@ ${requestScope.usuario.nombreCompleto} !!!!!</h1>
        <br />
        <a href="cursoListar">Mantenimiento de Cursos</a>
    </body>
</html>