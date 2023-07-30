import javax.swing.*;

public class Administrador extends Persona{
    private final String claveAcceso;
    private String noCuenta;

    public Administrador(String nombre, String apellido, String etiqueta, String id, int edad) {
        super(nombre, apellido, etiqueta, id, edad);
        this.claveAcceso = "Bancyto4231";
        this.noCuenta = "0194829837";
    }

    public void setAdministrador(){
        setNombre("Leonardo Favio");
        setApellido("Najera Morales");
        setEdad(20);
        setEtiqueta("Administrador");
        setId();
    }

    public void setNoCuenta() {
            String nT;
            do {
                nT = JOptionPane.showInputDialog("Numero de cuenta actual:\n"+noCuenta+"\nIngrese el numero de su tarjeta:");
            }while ( !validarNum(nT) || nT.length() != 8);
            this.noCuenta = nT;

    }
    public boolean validarNum(String num) {
        return num.matches("\\d+");
    }
    public void verDatos(){}
    public String getClaveAcceso() {
        return claveAcceso;
    }
}
