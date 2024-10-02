package Modelo;

public class Cajero {
    private int idCajero;
    private int saldo;
    private int saldoConsignaciones;
    private int numTransacciones;
    private int numRetiros;
    private int numConsignaciones;
    
    public Cajero(int idCajero, int saldo) {
        this.idCajero = idCajero;
        this.saldo = saldo;
        this.saldoConsignaciones = 0;
        this.numTransacciones = 0;
        this.numRetiros = 0;
        this.numConsignaciones = 0;
    }

    public int getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(int idCajero) {
        this.idCajero = idCajero;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldoConsignaciones() {
        return saldoConsignaciones;
    }

    public void setSaldoConsignaciones(int saldoConsignaciones) {
        this.saldoConsignaciones = saldoConsignaciones;
    }

    public int getNumTransacciones() {
        return numTransacciones;
    }

    public void setNumTransacciones(int numTransacciones) {
        this.numTransacciones = numTransacciones;
    }

    public int getNumRetiros() {
        return numRetiros;
    }

    public void setNumRetiros(int numRetiros) {
        this.numRetiros = numRetiros;
    }

    public int getNumConsignaciones() {
        return numConsignaciones;
    }

    public void setNumConsignaciones(int numConsignaciones) {
        this.numConsignaciones = numConsignaciones;
    }

    
}
