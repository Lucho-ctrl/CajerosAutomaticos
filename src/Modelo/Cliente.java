package Modelo;

import java.util.ArrayList;

public class Cliente {
    private int id;
    private String nombre;
    private String apellidos;
    private String correo;
    private ArrayList<Cuenta> cuentas;

    public Cliente(int id, String nombre, String apellidos, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.cuentas = new ArrayList<>();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public ArrayList<Cuenta> getCuenta() {
        return cuentas;
    }
    public void setCuenta(ArrayList<Cuenta> cuenta) {
        this.cuentas = cuenta;
    }

    public void agregarCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
    }
}
