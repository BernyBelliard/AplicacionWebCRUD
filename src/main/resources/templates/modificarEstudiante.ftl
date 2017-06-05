<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${titulo}</title>
</head>
<body>
    <form action="/modificandoEstudiante/" method="post">
        <table>
            <thead>
                <th colspan="5"> Modificar estudiante </th>
            </thead>

            <tbody>
                <tr>
                    <th>Matricula:</th>
                    <td>${estudiante.matricula?string["0"]}</td>
                    <td><input name="matricula" type="number" value="${estudiante.matricula?string["0"]}"/><br/></td>
                    <td><input name="x" type="number" value="${estudiante.matricula?string["0"]}" hidden="hidden"/><br/></td>
                </tr>
                <tr>
                    <th>Nombre:</th>
                    <td>${estudiante.nombre}</td>
                    <td> <input name="nombre" type="text" value="${estudiante.nombre}"/><br/> </td>
                </tr>
                <tr>
                    <th>Apellido:</th>
                    <td>${estudiante.apellido}</td>
                    <td> <input name="apellido" type="text" value="${estudiante.apellido}"/><br/> </td>
                </tr>
                <tr>
                    <th>Telefono:</th>
                    <td>${estudiante.telefono}</td>
                    <td> <input name="telefono" type="text" value="${estudiante.telefono}"/><br/> </td>
                </tr>
    </tbody>
        </table>
        <button name="Modificar" type="submit">Modificar</button>
        <a href="/listaEstudiantes/"> <button name="Cancelar" type="button">Cancelar</button> </a>
    </form>

</body>
</html>