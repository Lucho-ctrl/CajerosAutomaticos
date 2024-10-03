package Control;

import Modelo.Cajero;
import Modelo.Cliente;
import Modelo.Cuenta;
import Modelo.Tarjeta;
import java.util.ArrayList;
import java.util.Scanner;


public class Control {
    private Cajero cajero;
    private Cliente cliente;
    private Cuenta cuenta;
    private Tarjeta tarjeta;
    private ArrayList<Cliente> clientes;
    private ArrayList<Tarjeta> tarjetasExpedidas;
    private Scanner scan;

    public Control(){
        cajero = new Cajero(8998, 10000000);
        scan = new Scanner(System.in);
        tarjetasExpedidas = new ArrayList<>();
        creacionEntidades();
        interfazCajero(cajero);
        System.out.println("El pepe haciendo pruebas pa GitHub");
    }

    //!---------Acciones cajero---------
    public void interfazCajero(Cajero cajero){
        while(true){
            System.out.println("¡Bienvenido a tu cajero!");
            System.out.println("¿Que deseas hacer?");
            System.out.println("1. Consultar saldo");
            System.out.println("22. Consultar saldo cajero");
            System.out.println("2. Consignar");
            System.out.println("3. Retirar");
            System.out.println("4. mas acciones");

            System.out.print("Opcion: ");
            int accion = scan.nextInt();
            switch(accion){
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    consignar();
                    break;
                case 3:
                    retirar(cajero);
                    break;
                case 22:
                    System.out.println(cajero.getSaldo());
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }
        
    }

    public void consultarSaldo(){

    }

    public void consignar(){

    }

    //!------------------------Acciones para retirar------------------------

    public  void retirar(Cajero cajero){
        System.out.println("");
        System.out.println("Retiros");
        System.out.print("Ingrese el numero de su tarjeta: ");
        int numeroTarjeta = scan.nextInt();
        if(verificacionTarjeta(numeroTarjeta) == true){
            for(Tarjeta tarjeta : tarjetasExpedidas){
                if(tarjeta.getId() == numeroTarjeta){ //* Busca la cuenta asosciada a esa tarjeta */
                    cuenta = tarjeta.getCuenta();
                    System.out.print("Ingrese el monto a retirar: ");
                    int monto = scan.nextInt();
                    if(monto <= cuenta.getSaldo()){ //** verificacion de fondos en la cuenta del cliente */
                        if(monto <= cajero.getSaldo()){ //** verificacion de fondos en el cajero */
                            if(monto <= cuenta.getLimiteDiario()){ //* Verificacion del limite diario */
                                if (verificacionPassword(tarjeta) == true) {
                                    cuenta.setSaldo(cuenta.getSaldo() - monto);
                                    cajero.setSaldo(cajero.getSaldo() - monto);
                                    cajero.setNumRetiros(cajero.getNumRetiros() + 1);
                                    cajero.setNumTransacciones(cajero.getNumTransacciones() + 1);
                                    System.out.println("Retiro exitoso");
                                } else if(verificacionPassword(tarjeta) == false){
                                    System.out.println("Tarjeta bloqueada.");
                                }
                            } else if(monto > cuenta.getLimiteDiario()){
                                System.out.println("No se puede retirar. Limite permitido excedido");
                            }
                        } else if(monto > cajero.getSaldo()){
                            System.out.println("Saldo insuficiente"); //** no hay fondos suficientes en el cajero */
                        }
                    } else if(monto > cuenta.getSaldo()){
                        System.out.println("Fondos insuficientes"); //** no hay fondos suficientes en la cuenta */
                    }
                }
            }
        } else if (verificacionTarjeta(numeroTarjeta) == false){
            System.out.println("Tarjeta invalida");
        }
        System.out.println("");
    }

    public boolean verificacionTarjeta(int numeroTarjeta){
        for(int i = 0; i < tarjetasExpedidas.size(); i++){ //** verificacion de tarjetas */
            if(numeroTarjeta == tarjetasExpedidas.get(i).getId()){
                return true;
            }
        }
        return false;
    }

    //! Método para verificar la contraseña
    public boolean verificacionPassword(Tarjeta tarjeta) {
        if (!tarjeta.getEstado()) {
            System.out.println("La tarjeta está bloqueada.");
            return false; // Tarjeta bloqueada
        }

        int numIntentos = 0;
        boolean accesoPermitido = false;

        while (numIntentos < 3 && !accesoPermitido) {
            System.out.print("Ingresa su contraseña: ");
            String passwordIngresada = scan.next();

            if (passwordIngresada.equals(tarjeta.getPassword())) {
                accesoPermitido = true;
                return true; // * Contraseña correcta, se permite continuar
            } else {
                numIntentos++;
                System.out.println("Contraseña incorrecta. Intento " + numIntentos + " de 3.");
            }
        }

        // * Si no se logró acceso después de 3 intentos, la tarjeta se bloquea
        if (!accesoPermitido) {
            System.out.println("Has superado el número máximo de intentos. La tarjeta está bloqueada.");
            tarjeta.setEstado(false); // Bloquear la tarjeta
        }

        return false; //* No se permite continuar el proceso
    }
    //!------------------------Fin Acciones para retirar------------------------

    //!------------------------Metodos auxiliares------------------------

    public void creacionEntidades(){
        cliente = new Cliente(20231020166L, "Luis", "Ramirez", "jg@jg.com");
        cuenta = new Cuenta(100001,10000000, cliente, 500000);
        tarjeta = new Tarjeta(100001, cuenta, "1234lm");
        agregarTarjetasExpedidas(tarjeta);

    }

    public void agregarTarjetasExpedidas(Tarjeta tarjeta){
        tarjetasExpedidas.add(tarjeta);
    }
}
