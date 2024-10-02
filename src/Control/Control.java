package Control;

import Modelo.Cajero;
import Modelo.Cliente;
import Modelo.Cuenta;
import Modelo.Tarjeta;


public class Control {
    private Cajero cajero;
    private Cliente cliente;
    private Cuenta cuenta;
    private Tarjeta tarjeta;

    public Control(){
        cajero = new Cajero(8998, 10000000);
    }
}
