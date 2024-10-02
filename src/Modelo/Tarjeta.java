package Modelo;

public class Tarjeta {
    private int id;
    private boolean estado;
    private Cuenta cuenta;
    private String password;

    public Tarjeta(int id, Cuenta cuenta, String password) {
        this.id = id;
        this.estado = true;
        this.cuenta = cuenta;
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public Cuenta getCuenta() {
        return cuenta;
    }
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
