package Modelo;

public class Cuenta {
    private int numCuenta;
    private double saldo;
    private Cliente titular;
    private Tarjeta tarjetaDebito;
    private int intentosFallidos;
    private int limiteDiario;

    public Cuenta(int numCuenta, double saldo, Cliente titular, int limiteDiario) {
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        this.titular = titular;
        this.intentosFallidos = 0;
        this.limiteDiario = limiteDiario;
    }
    public int getNumCuenta() {
        return numCuenta;
    }
    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }
    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
    public Tarjeta getTarjetaDebito() {
        return tarjetaDebito;
    }

    public void asignarTarjeta(Tarjeta tarjetaDebito) {
        this.tarjetaDebito = tarjetaDebito;
    }
    public int getIntentosFallidos() {
        return intentosFallidos;
    }
    public void setIntentosFallidos(int intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }
    public int getLimiteDiario() {
        return limiteDiario;
    }
    public void setLimiteDiario(int limiteDiario) {
        this.limiteDiario = limiteDiario;
    }

    
}
