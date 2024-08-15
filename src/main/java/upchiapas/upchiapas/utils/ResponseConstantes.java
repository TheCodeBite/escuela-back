package upchiapas.upchiapas.utils;

public class ResponseConstantes {
    //CODIGOS DE ERROR SALON
    public static final int ERROR_NULL_SALON = 1001;
    public static final int ERROR_GRADO_VACIO = 1002;
    public static final int ERROR_GRUPO_VACIO = 1003;

    //MENSAJES DE ERROR SALON
    public static final String MSG_NULL_SALON = "El modelo del salon no puede ser nulo";
    public static final String MSG_GRADO_VACIO = "EL grado no debe ser vacio o nulo";
    public static final String MSG_GRUPO_VACIO = "El grupo no debe ser vacio o nulo";

    //========================== CODIGO Y MENSAJES DE ALUMNO ==========================
    public static final int ERROR_NULL_ALUMNO = 2001;
    public static final int ERROR_NULL_NOMBRE = 2002;
    public static final int ERROR_NULL_APELLIDO = 2003;
    public static final int ERROR_NULL_EDAD = 2004;
    public static final int ERROR_NULL_CALIFICACION = 2005;


    public static final String MSG_NULL_ALUMNO = "El modelo no debe ser nulo";
    public static final String MSG_NULL_NOMBRE = "El nombre del alumno no debe ser nulo o vacio";
    public static final String MSG_NULL_APELLIDO = "El apellido del alumno no debe ser nulo o vacio";
    public static final String MSG_NULL_EDAD = "La edad del alumno no debe ser vacio o nulo";
    public static final String MSG_NULL_CALIFICACION = "La calificacion del alumno no debe ser vacio o nulo";


    //============================= CODIGOS Y MENSAJES ASIGNACION =====================
    public static final int ERROR_ID_NULL = 3001;


    public static final String MSG_ID_NULL = "No hay un salón al cual asignar";
    private ResponseConstantes() {

    }

}
