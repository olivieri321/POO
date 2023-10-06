package com.ejercicio14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaTurismo {
    private List<Proveedor> proveedores;
    private List<PaqueteTurismo> paquetesTurismo;
    private List<Cliente> clientes;

    public SistemaTurismo() {
        proveedores = new ArrayList<>();
        paquetesTurismo = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public void agregarPaqueteTurismo(PaqueteTurismo paqueteTurismo) {
        paquetesTurismo.add(paqueteTurismo);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void realizarCompra(Cliente cliente, PaqueteTurismo paqueteTurismo) {
        cliente.agregarSubcripcion(paqueteTurismo);
    }

    public int ventasPorDestino(String destino) {
        int i = 0;
        int j = 0;
        int resultado = 0;
        while (i<this.clientes.size()){
            while (j<this.clientes.get(i).getPaqueteTurismoSubcritos().size()){
                if (this.clientes.get(i).getPaqueteTurismoSubcritos().get(j).getDestino().equals(destino)){
                    resultado++;
                }
                j++;
            }
            i++;
        }
        return resultado;
    }

    public String obtenerDestinoFavorito() {
        List<String> destinos = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i<this.clientes.size()){
            while (j<this.clientes.get(i).getPaqueteTurismoSubcritos().size()){
                if (!destinos.contains(this.clientes.get(i).getPaqueteTurismoSubcritos().get(j).getDestino())){
                    destinos.add(this.clientes.get(i).getPaqueteTurismoSubcritos().get(j).getDestino());
                }
                j++;
            }
            i++;
        }
        i = 0;
        String maxDestino = "Ninguno";
        int maxDestinocontador = 0;
        while (i<destinos.size()){
            if (ventasPorDestino(destinos.get(i))>maxDestinocontador){
                maxDestinocontador = ventasPorDestino(destinos.get(i));
                maxDestino = destinos.get(i);
            }
        }
        return maxDestino;
    }

    public void mostrarProveedores(){
        int i = 0;
        while (i<this.proveedores.size()){
            System.out.println(i+". Nombre: " + this.proveedores.get(i).getNombre()+" tipo: "+ this.proveedores.get(i).getClasificacion());
        }
    }
}
