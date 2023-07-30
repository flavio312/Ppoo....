import javax.swing.*;

public class Inquilino extends Persona{
    private Departamento departamento;
    private TarjetaCD tarjetaCD;
    public Inquilino(String nombre, String apellido, String etiqueta, String id, int edad, Departamento departamento, TarjetaCD tarjetaCD) {
        super(nombre, apellido, etiqueta, id, edad);
        this.departamento = departamento;
        this.tarjetaCD = tarjetaCD;
    }
    public void setInquilino(){
        setDatos();
        setEtiqueta("Inquilino");
        setId();
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public TarjetaCD getTarjetaCD() {
        return tarjetaCD;
    }

    public void setTarjetaCD(TarjetaCD tarjetaCD) {
        this.tarjetaCD = tarjetaCD;
    }
    public void verDatos(){
        JOptionPane.showMessageDialog(null,"Nombre: " + getNombre() +
                "\nApellido: " + getApellido() +
                "\nEdad: " + getEdad() +
                "\nID: " + getId() +
                "\nNumero de departamento: " + getDepartamento().getNumDepartamento() +
                "\nNumero de Tarjeta:\n" + getTarjetaCD().getNoTarjeta() +
                "\nPin:\n" + getTarjetaCD().getPin());
    }
}
