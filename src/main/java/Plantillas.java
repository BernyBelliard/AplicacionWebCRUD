import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Berny Belliard on 4/6/2017.
 */
public class Plantillas {

    public void plantillas(List<Estudiante> estudiantes){
        PlantillasFreeMarker(estudiantes);
    }

    public void PlantillasFreeMarker(List<Estudiante> estudiantes) {

        //Indicando la carpeta por defecto que estaremos usando.
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_26);
        configuration.setClassForTemplateLoading(Plantillas.class, "/templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);

        /* http://localhost:1104/crearEstudiante/
        * */

        get("/crearEstudiante/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Creación de estudiantes");
            return new ModelAndView(attributes, "crearEstudiante.ftl");
        }, freeMarkerEngine);


        get("/verEstudiante/:matricula", (request, response) -> {
            //obteniendo la matricula.
            Estudiante estudiante= new Estudiante(Integer.parseInt(request.params("matricula")), "Estudiante", "Apellido", "Telefono");//FakeServices.getInstancia().getEstudianteMatricula(Integer.parseInt(request.params("matricula")));

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("estudiante", estudiante);

            //enviando los parametros a la vista.
            return new ModelAndView(attributes, "verEstudiantes.ftl");
        }, freeMarkerEngine); //

        /* http://localhost:1104/procesarEstudiante/
        * */

        post("/procesarEstudiante/", (request, response) -> {

            int matricula = Integer.parseInt(request.queryParams("matricula").toString());
            String nombre =request.queryParams("nombre");
            String apellido =request.queryParams("apellido");
            String telefono =request.queryParams("telefono");

            Estudiante estudiante= new Estudiante(matricula, nombre, apellido, telefono);
            estudiantes.add(estudiante);
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Creando estudiante");
            attributes.put("estudiante", estudiante);

            return new ModelAndView(attributes, "estudianteCreado.ftl");
        }, freeMarkerEngine); //

        /* http://localhost:1104/listaEstudiantes/
        * */

        get("/listaEstudiantes/", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Lista de estudiantes");
            attributes.put("estudiantes", estudiantes);

            return new ModelAndView(attributes, "listaEstudiantes.ftl");
        }, freeMarkerEngine); //

        get("/listaEstudiantes/:matricula", (request, response) -> {
            String [] x = request.params("matricula").toString().split(":");
            Main.eliminarEstudiante(estudiantes, Integer.parseInt(x[1]));
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Lista de estudiantes");
            attributes.put("estudiantes", estudiantes);

            return new ModelAndView(attributes, "listaEstudiantes.ftl");
        }, freeMarkerEngine);

        get("/modificarEstudiante/:matricula", (request, response) -> {
            String [] x = request.params("matricula").toString().split(":");
            Estudiante estudiante = Main.obtenerEstudiante(estudiantes,Integer.parseInt(x[1]));

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Modificación de estudiante");
            attributes.put("estudiante", estudiante);

            return new ModelAndView(attributes, "modificarEstudiante.ftl");
        }, freeMarkerEngine); //

        post("/modificandoEstudiante/", (request, response) -> {
            int x = Integer.parseInt(request.queryParams("x").toString());
            int matricula = Integer.parseInt(request.queryParams("matricula").toString());
            String nombre =request.queryParams("nombre");
            String apellido =request.queryParams("apellido");
            String telefono =request.queryParams("telefono");

            Main.modificarEstudiante(estudiantes,matricula,nombre,apellido,telefono,Main.buscarEstudiante(estudiantes,x));
            Estudiante estudiante = Main.obtenerEstudiante(estudiantes,matricula);
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("titulo", "Modificando estudiante");
            attributes.put("estudiante", estudiante);

            return new ModelAndView(attributes, "estudianteModificado.ftl");
        }, freeMarkerEngine); //

    }

}
