import javax.swing.*;

public class Casero extends Persona{
        private String curp;
        private int noCuenta;

        public Casero(String nombre, String apellido, String etiqueta, String id, int edad, String curp, int noCuenta) {
                super(nombre, apellido, etiqueta, id, edad);
                this.curp = curp;
                this.noCuenta = noCuenta;
        }
        public void setCasero(){
                setDatos();
                setEtiqueta("Casero");
                setId();
                setCurp(JOptionPane.showInputDialog(null,"Ingrese la CURP:","Registrarse", JOptionPane.QUESTION_MESSAGE));
                setNoCuenta();
        }

        public void setCurp(String curp) {
                this.curp = curp;
        }
        public void verDatos(){
                switch (JOptionPane.showInputDialog("Nombre: " + getNombre() +
                        "\nApellido: " + getApellido() +
                        "\nEdad: " + getEdad() +
                        "\nID: " + getId() +
                        "\nCURP: " + getCurp() +
                        "\nNumero de Cuenta:\n" +  getNoCuenta() +
                        "\nCambiar datos del Casero?\n" +
                        "1.-Si" +
                        "\n2.-No")){
                        case "1":
                                setCasero();
                                break;
                        case "2":
                                JOptionPane.showMessageDialog(null,"Opcion invalida!!!");
                                break;
                        default:
                                JOptionPane.showMessageDialog(null,"Opcion invalida!!!");
                }

        }

        public String getCurp() {
                return curp;
        }

        public int getNoCuenta() {
                return noCuenta;
        }

        public void setNoCuenta() {
                boolean f = true;
                int nC = 0;
                do {
                        try {
                                nC = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese su numero de cuenta:","Registrarse", JOptionPane.QUESTION_MESSAGE));
                                f = false;
                        }catch (NumberFormatException e){
                                JOptionPane.showMessageDialog(null,"Error: tipo de dato invalido!!!","", JOptionPane.QUESTION_MESSAGE);
                        }
                }while (f);
                this.noCuenta = nC;
        }
}
