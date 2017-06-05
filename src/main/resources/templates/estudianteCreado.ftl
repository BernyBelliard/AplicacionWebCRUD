<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${titulo}</title>
</head>
<body>
<!--<h1> Estudiante creado </h1> -->
<table>
    <thead>
        <th colspan="2"> Estudiante creado </th>
    </thead>

    <tbody>
        <tr>
            <th>Matricula:</th>
            <td>${estudiante.matricula?string["0"]}</td>
        </tr>
        <tr>
            <th>Nombre:</th>
            <td>${estudiante.nombre}</td>
        </tr>
        <tr>
            <th>Apellido:</th>
            <td>${estudiante.apellido}</td>
        </tr>
        <tr>
            <th>Telefono:</th>
            <td>${estudiante.telefono}</td>
        </tr>


    </tbody>
</table>
    <form action="/listaEstudiantes/" method="get">
        <p>  </p>
    <button name="Ver lista" type="submit">Ver lista de estudiantes </button>
    </form>
</body>
</html>