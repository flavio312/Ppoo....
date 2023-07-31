import javax.swing.*;
import java.util.*;

public class Main {
    static ArrayList<Reporte> reportes = new ArrayList<>();
    static Departamento departamento = new Departamento();
    static TarjetaCD tarjetaCD = new TarjetaCD("","");
    static ArrayList<Departamento> departamentos = new ArrayList<>();
    static Inquilino inquilino = new Inquilino("","","","",0,departamento,tarjetaCD);
    static Casero casero = new Casero("","","","",0,"",0);
    static Administrador administrador = new Administrador("","","","",0);
    static ArrayList<Persona> usuarios = new ArrayList<>();
    static int intentos = 3;
    static String usuarioEnUso, nombre, dato;
    public static void main(String[] args) {
        administrador.setAdministrador();
        usuarios.add(administrador);
        for (int i = 0; i<10;i++){
            Departamento departamento = new Departamento();
            departamento.setNumDepartamento(i+1);
            departamentos.add(departamento);
        }


        iniciarSesion();
        do {
            switch (usuarioEnUso) {
                case "Inquilino" -> menuInquilino();
                case "Casero" -> menuCasero();
                case "Administrador" -> menuAdministrador();
            }
        }while (!usuarioEnUso.equals(""));


    }
    public static void menuInquilino(){
        do {
            dato = JOptionPane.showInputDialog(usuarioEnUso+"\nBienvenido "+nombre+"\n"+
                    "Que desea hacer?\n" +
                    "1.-Cambiar metodo de pago\n" +
                    "2.-Reportar anomalia\n" +
                    "3.-Desalojar Departamento\n" +
                    "4.-Cambiar de Departamento\n" +
                    "5.-Cerrar Sesion");
            switch (dato) {
                case "1" -> cambiarMetodoPago();
                case "2" -> {
                    generarReporte("la anomalia:");
                    JOptionPane.showMessageDialog(null, "Reporte enviado!!!", "", JOptionPane.QUESTION_MESSAGE);
                }
                case "3" -> {
                    generarReporte("la solicitud:");
                    JOptionPane.showMessageDialog(null, "Solicitud enviada!!!\nTiene hasta la fecha del siguiente corte para desalojar.\nGracias por su estancia.", "", JOptionPane.QUESTION_MESSAGE);
                    iniciarSesion();
                }
                case "4" -> {
                    generarReporte("la solicitud:");
                    cambiarDepartamento();
                    JOptionPane.showMessageDialog(null, "Solicitud enviada!!!\nPuede empezar a mudarse", "", JOptionPane.QUESTION_MESSAGE);
                }
                case "5" -> iniciarSesion();
                default -> JOptionPane.showMessageDialog(null, "Opcion inexistente!!!", "", JOptionPane.ERROR_MESSAGE);
            }
        }while (!dato.equals("5"));
    }
    public static void menuCasero(){
        do {
            dato = JOptionPane.showInputDialog(usuarioEnUso+"\nBienvenido "+nombre+"\n"+
                    "Que desea hacer?\n" +
                    "1.-Ver Departamentos\n" +
                    "2.-Ver Inquilinos\n" +
                    "3.-Reportar anomalia\n" +
                    "4.-Ver Reportes de inquilinos\n" +
                    "5.-Cerrar Sesion");
            switch (dato) {
                case "1" -> verDepartamentos();
                case "2" -> verInquilinos();
                case "3" -> generarReporte("la anomalia:");
                case "4" -> verReportes("Inquilino");
                case "5" -> iniciarSesion();
                default -> JOptionPane.showMessageDialog(null, "Opcion inexistente!!!", "", JOptionPane.ERROR_MESSAGE);
            }
        }while (!dato.equals("5"));
    }
    public static void menuAdministrador(){
        do {
            dato = JOptionPane.showInputDialog(usuarioEnUso+"\nBienvenido "+nombre+"\n"+
                    "Que desea hacer?\n" +
                    "1.-Ver Departamentos\n" +
                    "2.-Ver Inquilinos\n" +
                    "3.-Ver Reportes del Casero\n" +
                    "4.-Agregar Casero\n" +
                    "5.-Cambiar numero de cuenta\n" +
                    "6.-Ver Casero\n" +
                    "7.-Cerrar Sesion");
            switch (dato) {
                case "1" -> verDepartamentos();
                case "2" -> verInquilinos();
                case "3" -> verReportes("Casero");
                case "4" -> {
                    casero.setCasero();
                    usuarios.add(casero);
                    JOptionPane.showMessageDialog(null, "Casero guardado!!!", "", JOptionPane.QUESTION_MESSAGE);
                }
                case "5" -> administrador.setNoCuenta();
                case "6" -> casero.verDatos();
                case "7" -> iniciarSesion();
                default -> JOptionPane.showMessageDialog(null, "Opcion inexistente!!!", "", JOptionPane.ERROR_MESSAGE);
            }
        }while (!dato.equals("7"));
    }
    public static void iniciarSesion(){
        String usuario, password;
        boolean sesionValida = false;
        intentos=3;
        usuarioEnUso = "";
        nombre = "";
        do {
            usuario = JOptionPane.showInputDialog(null,"Ingrese su Nombre:","Iniciar Sesion", JOptionPane.QUESTION_MESSAGE);
            password = JOptionPane.showInputDialog(null,"Ingrese su ID:","Iniciar Sesion", JOptionPane.QUESTION_MESSAGE);

            for (Persona persona : usuarios) {
                if (persona instanceof Inquilino) {
                    inquilino = (Inquilino) persona;
                    if (inquilino.getNombre().equals(usuario) && inquilino.getId().equals(password)) {
                        sesionValida = true;
                        usuarioEnUso = inquilino.getEtiqueta();
                        nombre = inquilino.getNombre();
                        break;
                    }
                }
                if (persona instanceof Casero) {
                    casero = (Casero) persona;
                    if (casero.getNombre().equals(usuario) && casero.getId().equals(password)) {
                        sesionValida = true;
                        usuarioEnUso = casero.getEtiqueta();
                        nombre = casero.getNombre();
                        break;
                    }
                }
                if (persona instanceof Administrador) {
                    administrador = (Administrador) persona;
                    if (administrador.getNombre().equals(usuario) && administrador.getClaveAcceso().equals(password)) {

                        sesionValida = true;
                        usuarioEnUso = administrador.getEtiqueta();
                        nombre = administrador.getNombre();
                        break;
                    }
                }
            }

            if (sesionValida) {
                // Realizar acciones para sesión iniciada exitosamente
                JOptionPane.showMessageDialog(null,"Inicio de sesión exitoso.","", JOptionPane.QUESTION_MESSAGE);
                break;
            } else {
                // Mostrar mensaje de error y volver a solicitar credenciales
                intentos--;
                JOptionPane.showMessageDialog(null, "Credenciales inválidas. Inténtelo de nuevo.\nQuedan "+intentos + " intentos.","", JOptionPane.ERROR_MESSAGE);
            }
            if (intentos==0){
                do {
                    switch (JOptionPane.showInputDialog(null, """
                            Sobrepaso los intentos desea registrarse?
                            1.-Si
                            2.-No""", "", JOptionPane.QUESTION_MESSAGE)) {
                        case "1" -> registrarse();
                        case "2" -> {}
                        default -> {
                            JOptionPane.showMessageDialog(null, "Opcion inexistente!!!", "", JOptionPane.ERROR_MESSAGE);
                            sesionValida = true;
                        }
                    }
                }while (sesionValida);
                break;
            }

        } while (true);
    }
    public static void registrarse(){
        int noDepa;
        nombre = "";

        usuarioEnUso = "";

        inquilino.setInquilino();
        verDepartamentosDesocupados();

        do {
            try {
                noDepa = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero del departamento de desea"));
                break;
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Error: tipo de dato invalido!!!","", JOptionPane.QUESTION_MESSAGE);
            }
        }while (true);

        departamentos.get(noDepa-1).setOcupado(true);
        inquilino.setDepartamento(departamentos.get(noDepa-1));
        tarjetaCD.setNoTarjeta();
        inquilino.setTarjetaCD(tarjetaCD);
        usuarios.add(inquilino);
        usuarioEnUso = inquilino.getEtiqueta();
        nombre = inquilino.getNombre();
    }
    public static void modificarTarjeta(){
        for (Persona persona : usuarios) {
            if (persona instanceof Inquilino) {
                inquilino = (Inquilino) persona;
                if (inquilino.getNombre().equals(nombre) && inquilino.getId().equals(usuarioEnUso+"-"+nombre)) {
                    tarjetaCD.setNoTarjeta();
                    inquilino.setTarjetaCD(tarjetaCD);
                    break;
                }
            }
        }
    }
    public static void verDepartamentosDesocupados(){
        for (Departamento d: departamentos){
            if (!d.isOcupado()){
                d.verDepartamento();
            }

        }
    }
    public static void verDepartamentos(){
        for (Departamento d: departamentos){
            d.verDepartamento();
        }
    }
    public static void verInquilinos(){
        for (Persona persona : usuarios) {
            if (persona instanceof Inquilino) {
                inquilino = (Inquilino) persona;
                inquilino.verDatos();
            }
        }
    }
    public static void cambiarMetodoPago(){
        boolean terminar;
        do {
            terminar = false;
            switch (JOptionPane.showInputDialog("""
                    Que desea hacer?
                    1.-Pagar Fisicamente
                    2.-Modificar Tarjeta""")) {
                case "1" ->
                        JOptionPane.showMessageDialog(null, "Se le asignara una fecha y hora para el pago en efectivo.\n" +
                                "Este pendiente de su correo los proximos dias.", "", JOptionPane.ERROR_MESSAGE);
                case "2" -> {
                    modificarTarjeta();
                    JOptionPane.showMessageDialog(null, "Cambios guardados!!!", "Modificacion exitosa", JOptionPane.QUESTION_MESSAGE);
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Opcion inexistente!!!", "", JOptionPane.ERROR_MESSAGE);
                    terminar = true;
                }
            }
        }while(terminar);
    }
    public static void generarReporte(String tipoReporte){
        Reporte reporte = new Reporte("","","","","",false,false,0);
        reporte.setReporte(tipoReporte);
        reporte.setIdReporte(reportes.size()+1);
        reporte.setCreadorReporte(nombre);
        reporte.setEtiqueta(usuarioEnUso);
        reportes.add(reporte);
    }
    public static void verReportes(String etiqueta){
        for (Reporte r: reportes) {
            if (r.getEtiqueta().equals(etiqueta)){
                r.verReporte();
            }
        }
    }
    public static void cambiarDepartamento(){
        int noDepa;
        for (Persona persona : usuarios) {
            if (persona instanceof Inquilino) {
                inquilino = (Inquilino) persona;
                if (inquilino.getNombre().equals(nombre) && inquilino.getId().equals(usuarioEnUso+"-"+nombre)) {
                    verDepartamentosDesocupados();
                    noDepa = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero del departamento de desea"));
                    departamentos.get(noDepa-1).setOcupado(true);
                    for (Departamento d: departamentos){
                        if (inquilino.getDepartamento().getNumDepartamento() == d.getNumDepartamento()){
                            d.setOcupado(false);
                        }
                    }
                    inquilino.setDepartamento(departamentos.get(noDepa-1));
                    break;
                }
            }
        }
    }
}
