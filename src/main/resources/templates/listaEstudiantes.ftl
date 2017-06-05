<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lista de estudiantes</title>
</head>
    <body>
        <h2> Listado de estudiantes </h2>
        <table>
            <tbody>
                <thead>
                    <th> Matricula </th>
                    <th> Nombre </th>
                    <th> Apellido </th>
                    <th> Telefono </th>
                </thead>
                <#list estudiantes as estudiante>
                    <tr>
                        <td> ${estudiante.matricula?string["0"]}</td>
                        <td> ${estudiante.nombre} </td>
                        <td> ${estudiante.apellido} </td>
                        <td> ${estudiante.telefono}</td>
                        <td> <a href="/modificarEstudiante/:${estudiante.matricula?string["0"]}"> <button name="Modificar" type="button">Modificar</button></a></td>
                        <td><a href="/listaEstudiantes/:${estudiante.matricula?string["0"]}"> <button name="Eliminar" type="submit">Eliminar</button> </a></td>
                    </tr>
                </#list>
            </tbody>
        </table>
        <p></p>
        <a href="/crearEstudiante/"> <button name="Crear" type="button">Crear</button> </a>

    </body>
</html>