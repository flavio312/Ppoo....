import javax.swing.*;

public abstract class Persona {
    private String nombre, apellido, etiqueta, id;
    private int edad;

    public Persona(String nombre, String apellido, String etiqueta, String id, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.etiqueta = etiqueta;
        this.id = id;
        this.edad = edad;
    }
    public void setDatos(){
        int ed = 0;
        boolean f =true;
        setNombre(JOptionPane.showInputDialog(null,"Ingrese el nombre:","Registrarse", JOptionPane.QUESTION_MESSAGE));
        setApellido(JOptionPane.showInputDialog(null,"Ingrese el apellido:","Registrarse", JOptionPane.QUESTION_MESSAGE));
        do {
            try {
                ed = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la edad:","Registrarse", JOptionPane.QUESTION_MESSAGE));
                f = false;
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Error: tipo de dato invalido!!!","", JOptionPane.QUESTION_MESSAGE);
            }
        }while (f);
        setEdad(ed);
    }
    public abstract void verDatos();
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = getEtiqueta()+"-"+getNombre();
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getApellido() {
        return apellido;
    }
}
