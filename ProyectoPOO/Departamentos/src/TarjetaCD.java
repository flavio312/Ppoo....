import javax.swing.*;

public class TarjetaCD {
    private String noTarjeta, pin;

    public TarjetaCD(String noTarjeta, String pin) {
        this.noTarjeta = noTarjeta;
        this.pin = pin;
    }

    public String getNoTarjeta() {
        return noTarjeta;
    }

    public void setNoTarjeta() {
        String nT;
        do {
            nT = JOptionPane.showInputDialog("Ingrese el numero de su tarjeta:");
        }while ( validarNum(nT) || nT.length() != 8);
        this.noTarjeta = nT;
        setPin();
    }

    public boolean validarNum(String num) {
        return !num.matches("\\d+");
    }

    public String getPin() {
        return pin;
    }

    public void setPin() {
        String p;
        do {
            p = JOptionPane.showInputDialog("Ingrese el pin:");
        }while ( validarNum(p) || p.length() != 4);
        this.pin = p;
    }
}
