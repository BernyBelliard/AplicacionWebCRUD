import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;
/**
 * Created by Berny Belliard on 4/6/2017.
 */
public class Main {

    public static void main(String[] args) {


        port(getHerokuAssignedPort());

        staticFiles.location("/bootstrap");

        List<Estudiante> estudiantes = new ArrayList<>();

        Estudiante estudiante1 = new Estudiante(20131009, "José", "Cabrera", "8420394236");
        Estudiante estudiante2 = new Estudiante(20130405, "Carmen", "Gonzalez", "8096494986");
        Estudiante estudiante3 = new Estudiante(20130009, "Michael", "Reyes", "8494507832");

        estudiantes.add(estudiante1);
        estudiantes.add(estudiante2);
        estudiantes.add(estudiante3);

       /* for (int i = 0; i<estudiantes.size();i++){
            System.out.println(estudiantes.get(i).getNombre());
        }*/

        new Plantillas().plantillas(estudiantes);



    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 1104; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static int buscarEstudiante(List<Estudiante> estudiantes, int matricula){
        boolean find = false;

        int i= 0;
        while(!find){
            if(estudiantes.get(i).getMatricula() == matricula){
                find = true;
            }else{
                i++;
            }
        }
        return i;
    }

    public static boolean eliminarEstudiante(List<Estudiante> estudiantes, int matricula){
        boolean deleted = false;
        if(estudiantes.remove(buscarEstudiante(estudiantes,matricula))!=null){
            deleted = true;
        }
        return deleted;
    }

    public static Estudiante obtenerEstudiante(List<Estudiante> estudiantes, int matricula){
        Estudiante estudianteAux = null;
        for (Estudiante estudiante : estudiantes) {
            if(estudiante.getMatricula() == matricula){
                estudianteAux = estudiante;

            }
        }
        return estudianteAux;
    }

    public static void modificarEstudiante(List<Estudiante> estudiantes, int matriucla, String nombre, String apellido, String telefono,int index){

        estudiantes.get(index).setMatricula(matriucla);
        estudiantes.get(index).setNombre(nombre);
        estudiantes.get(index).setApellido(apellido);
        estudiantes.get(index).setTelefono(telefono);

    }

}
