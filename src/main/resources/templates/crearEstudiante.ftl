<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${titulo}</title>
</head>
<body>
    <!--<h1>Crear estudiante</h1> -->
    <form action="/procesarEstudiante/" method="post">
        <table>

            <thead>
                <th colspan="2"> Crear estudiante </th>
            </thead>
            <tbody>
                <tr>
                    <th>Matricula:</th>
                    <td><input name="matricula" type="number"/><br/></td>
                </tr>

                <tr>
                    <th> Nombre: </th>
                    <td> <input name="nombre" type="text"/><br/> </td>
                </tr>

                <tr>
                    <th> Apellido: </th>
                    <td> <input name="apellido" type="text"/><br/> </td>
                </tr>

                <tr>
                    <th> Telefono: </th>
                    <td> <input name="telefono" type="text"/><br/> </td>
                </tr>
            </tbody>
        </table>
    <button name="Enviar" type="submit">Enviar</button>
        <a href="/listaEstudiantes/"> <button name="Cancelar" type="button">Cancelar</button> </a>
    </form>

</body>
</html>