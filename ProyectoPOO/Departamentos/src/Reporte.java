import javax.swing.*;

public class Reporte {
    private String titulo, informe, justificante, creadorReporte, etiqueta;
    private boolean dano, accidental;
    private int idReporte;

    public Reporte(String titulo, String informe, String justificante, String creadorReporte, String etiqueta, boolean dano, boolean accidental, int idReporte) {
        this.titulo = titulo;
        this.informe = informe;
        this.justificante = justificante;
        this.creadorReporte = creadorReporte;
        this.etiqueta = etiqueta;
        this.dano = dano;
        this.accidental = accidental;
        this.idReporte = idReporte;
    }

    public void setReporte(String tipoReporte){
        setTitulo(JOptionPane.showInputDialog("Ingrese el titulo de " + tipoReporte));
        setInforme(JOptionPane.showInputDialog("Ingrese los detalles de " + tipoReporte));
        setDano(validarTF("""
                Hubieron daños en el departamento?
                1.-Si
                2.-No"""));
        if (isDano()){
            setAccidental(validarTF("""
                    Fue accidental?
                    (SI NO HUBIERON DAÑOS ELIJA LA OPCION 2)
                    1.-Si
                    2.-No"""));
            if (isAccidental()){
                setJustificante(JOptionPane.showInputDialog("Justifique que fue un accidente"));
            }
        }


    }
    public boolean validarTF(String menu){
        boolean siNo = true, t;
        do {
            t=false;
            switch (JOptionPane.showInputDialog(menu)){
                case "1":
                    break;
                case "2":
                    siNo = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion inexistente!!!","", JOptionPane.ERROR_MESSAGE);
                    t=true;
            }
        }while (t);

        return siNo;
    }
    public void verReporte(){
        String j = "";
        if (!justificante.equals("")){
            j = j + "Justificacion:\n" + justificante;
        }
        JOptionPane.showMessageDialog(null,"Titulo: " + getTitulo() +
                "\nInforme:\n" + getInforme() +
                "\nDaños: " + isDano() +
                "\nAccidental: " + isAccidental() +
                "\nCreador del reporte: " + getCreadorReporte() +
                j +
                "\nUsuario: " + getEtiqueta(),"Id Reporte: "+getIdReporte(), JOptionPane.QUESTION_MESSAGE);
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public void setJustificante(String justificante) {
        this.justificante = justificante;
    }

    public String getCreadorReporte() {
        return creadorReporte;
    }

    public void setCreadorReporte(String creadorReporte) {
        this.creadorReporte = creadorReporte;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public boolean isDano() {
        return dano;
    }

    public void setDano(boolean dano) {
        this.dano = dano;
    }

    public boolean isAccidental() {
        return accidental;
    }

    public void setAccidental(boolean accidental) {
        this.accidental = accidental;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }
}
