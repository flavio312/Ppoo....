import javax.swing.*;

public class Departamento {
    private int numDepartamento;
    private final String condicionesDepartamento;
    private boolean ocupado;

    public Departamento() {
        this.numDepartamento = getNumDepartamento();
        this.condicionesDepartamento = "En Buenas Condiciones";
        this.ocupado = false;
    }

    public int getNumDepartamento() {
        return numDepartamento;
    }

    public void setNumDepartamento(int numDepartamento) {

        this.numDepartamento = numDepartamento;
    }

    public String getCondicionesDepartamento() {
        return condicionesDepartamento;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    public void verDepartamento(){
        JOptionPane.showMessageDialog(null,"Departamento numero: "+getNumDepartamento()+
                "\nEstado del departamento: "+getCondicionesDepartamento()+
                "\nocupado: " + isOcupado());
    }
}
