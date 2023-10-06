package com.ejercicio7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ModuloInformes {
    private List<Cliente> clientes;

    private List<Cliente> topClientesAnteriorMes;
    private List<Cliente> topClientes;
    private List<Empleado> topVentasAnteriorMes;
    private List<Empleado> topVentas;
    private List<Empleado> empleados;

    private List<Expendedor> expendedores;

    public ModuloInformes() {
        this.clientes = new ArrayList<>();
        this.topClientes = new ArrayList<>(10);
        this.empleados = new ArrayList<>();
        this.expendedores = new ArrayList<>();
        this.topClientesAnteriorMes = new ArrayList<>();
        this.topVentasAnteriorMes = new ArrayList<>();
        this.topVentas = new ArrayList<>();
    }
    public void agregarExpendedor(Expendedor expendedor){
        this.expendedores.add(expendedor);
    }
    public void agregarCliente(Cliente cliente){
        this.clientes.add(cliente);
        if (this.topClientes.size()>10){
            this.topClientes.add(cliente);
        }

    }

    public void agregarEmpleado(Empleado empleado){
        this.empleados.add(empleado);
    }

    private float calcularTotalVentasCliente(Cliente cliente){
        int i = 0;
        float resultado = 0;
        while (i < cliente.getVentas().size()){
            resultado += cliente.getVentas().get(i).getImporteTotal();
            i++;
        }
        return resultado;
    }

    public void agregarVenta(String patente, String dniEmpleado,int idSurtidor, float litros){
        int i = 0;
        boolean encontradoCliente = false;
        boolean encontradoSurtidor = false;
        boolean encontradoEmpleado = false;
        while (i < clientes.size()){
            if (clientes.get(i).getPatente().equals(patente)){
                encontradoCliente = true;
                break;
            }
            i++;
        }
        int j = 0;
        while (j<this.expendedores.size()){
            if (expendedores.get(j).getCodigo() == idSurtidor){
                encontradoSurtidor = true;
                break;
            }
            j++;
        }
        int k = 0;
        while (k<this.empleados.size()){
            if (empleados.get(k).getDni().equals(dniEmpleado)){
                encontradoEmpleado = true;
                break;
            }
            k++;
        }
        if (encontradoCliente && encontradoSurtidor && encontradoEmpleado){
            Venta venta;
            if (estuvoAnteriorTop(clientes.get(i))){
                 venta = new Venta(LocalDate.now(),this.expendedores.get(j),litros, dniEmpleado, 0.95);
            }
            else {
                 venta = new Venta(LocalDate.now(),this.expendedores.get(j),litros, dniEmpleado);
            }

            this.clientes.get(i).getVentas().add(venta);
            int y = 0;
            float totalventasClienteActual = calcularTotalVentasCliente(clientes.get(i));
            while (y < this.topClientes.size()){
                float totalventasClienteTop = calcularTotalVentasCliente(topClientes.get(y));
                if (totalventasClienteActual > totalventasClienteTop){
                    this.topClientes.set(y,clientes.get(i));
                }
                y++;
            }
        }
        else {
            System.out.println("Error al agregar venta");
        }
    }

    // Si se agrega empleado en agregarVenta se agregara un descuento en el caso de que este en el top anterior y no halla usado su descuento
    public void agregarVenta(String patente, String dniEmpleado,int idSurtidor, float litros, Empleado empleado){
        int i = 0;
        boolean encontradoCliente = false;
        boolean encontradoSurtidor = false;
        boolean encontradoEmpleado = false;
        while (i < clientes.size()){
            if (clientes.get(i).getPatente().equals(patente)){
                encontradoCliente = true;
                break;
            }
            i++;
        }
        int j = 0;
        while (j<this.expendedores.size()){
            if (expendedores.get(j).getCodigo() == idSurtidor){
                encontradoSurtidor = true;
                break;
            }
            j++;
        }
        int k = 0;
        while (k<this.empleados.size()){
            if (empleados.get(k).getDni().equals(dniEmpleado)){
                encontradoEmpleado = true;
                break;
            }
            k++;
        }
        double descuento = 1;
        if (encontradoCliente && encontradoSurtidor && encontradoEmpleado){
            Venta venta;
            if (estuvoAnteriorTop(clientes.get(i))){
                descuento = descuento - 0.05;
            }
            if (this.empleados.get(k).isEstadoDescuento()){
                descuento = descuento - 0.10;
                this.empleados.get(k).setEstadoDescuento(false);
            }
            venta = new Venta(LocalDate.now(),this.expendedores.get(j),litros, dniEmpleado, descuento);
            this.clientes.get(i).getVentas().add(venta);
            int y = 0;
            float totalventasClienteActual = calcularTotalVentasCliente(clientes.get(i));
            while (y < this.topClientes.size()){
                float totalventasClienteTop = calcularTotalVentasCliente(topClientes.get(y));
                if (totalventasClienteActual > totalventasClienteTop){
                    this.topClientes.set(y,clientes.get(i));
                }
                y++;
            }
        }
        else {
            System.out.println("Error al agregar venta");
        }
    }

    private List<Combustible> getCombustibles() {
        List<Combustible> combustibles = new ArrayList<Combustible>();

        for (Expendedor expendedor : this.expendedores) {
            Combustible combustible = expendedor.getCombustible();
            if (!combustibles.contains(combustible)) {
                combustibles.add(combustible);
            }
        }

        return combustibles;
    }

    private float totalRecaudadoPorCombustible(Combustible combustible){
        int i = 0;
        int j = 0;
        float resultado = 0;
        while (i<this.clientes.size()){
            while (j<this.clientes.get(i).getVentas().size()){
                if (this.clientes.get(i).getVentas().get(j).getExpendedor().getCombustible() == combustible){
                    resultado += this.clientes.get(i).getVentas().get(j).getImporteTotal();
                }
                j++;
            }
            j = 0;
            i++;
        }
        return resultado;
    }

    private float totalRecaudadoPorSurtidor(Expendedor expendedor){
        int i = 0;
        int j = 0;
        float resultado = 0;
        while (i<this.clientes.size()){
            while (j<this.clientes.get(i).getVentas().size()){
                if (this.clientes.get(i).getVentas().get(j).getExpendedor() == expendedor){
                    resultado += this.clientes.get(i).getVentas().get(j).getImporteTotal();
                }
                j++;
            }
            j = 0;
            i++;
        }
        return resultado;
    }

    public void generarInformePorCombustible(){
        int i = 0;
        List<Combustible> combustibles = getCombustibles();
        while (i<combustibles.size()){
            System.out.println(combustibles.get(i).getNombre() + " total recaudado: " + totalRecaudadoPorCombustible(combustibles.get(i)) );
            i++;
        }
    }

    public void generarListadoSurtidoresPorVentas(){
        int i = 0;
        while (i<this.expendedores.size()){
            System.out.println(this.expendedores.get(i).getCodigo() + " total recaudado: " + totalRecaudadoPorSurtidor(this.expendedores.get(i)));
            i++;
        }
    }

    public void generarListadoSurtidoresPorLitrosVendidos(){
        int i = 0;
        while (i<this.expendedores.size()){
            System.out.println(this.expendedores.get(i).getCodigo() + " total expendido: " + this.expendedores.get(i).getLitrosExpendidos());
            i++;
        }
    }

    public double totalRecaudadoDeEmpleado(Empleado empleado){
        int i = 0;
        int j = 0;
        double resultado = 0;
        while (i<this.clientes.get(i).getVentas().size()){
            if (this.clientes.get(i).getVentas().get(i).getDniEmpleado().equals(empleado.getDni())){
                while (j<this.clientes.get(i).getVentas().size()){
                    resultado += this.clientes.get(i).getVentas().get(j).getImporteTotal();
                    j++;
                }
            }
            i++;
        }
        return resultado;
    }
    public void generarListadoEmpleadosPorVentas(){
        int i = 0;
        while (i<this.empleados.size()){
            System.out.println(this.empleados.get(i).getDni() + " total vendido: " + totalRecaudadoDeEmpleado(empleados.get(i)));
            i++;
        }
    }

    private float totalRecaudadoDeCliente(Cliente cliente){
        int i = 0;
        float resultado = 0;
        while (i<cliente.getVentas().size()){
            resultado += cliente.getVentas().get(i).getImporteTotal();
            i++;
        }
        return resultado;
    }
    public void generarListadoTopClientes(){
        int i = 0;
        while (i<this.topClientes.size()){
            System.out.println(this.topClientes.get(i).getNombre() +" "+ totalRecaudadoDeCliente(this.topClientes.get(i)));
            i++;
        }
    }

    private void ActualizartopVentas() {
        topVentas.clear();
        int numEmpleados = empleados.size();
        if (numEmpleados<10){
            numEmpleados = 10;
        }
        for (int i = 0; i < numEmpleados; i++) {
            Empleado mejorEmpleado = null;
            double maxVentas = 0;

            for (Empleado empleado : empleados) {
                // Verificamos si este empleado ya está en topVentas
                if (!topVentas.contains(empleado)) {
                    double totalVentas = totalRecaudadoDeEmpleado(empleado);
                    if (totalVentas > maxVentas) {
                        maxVentas = totalVentas;
                        mejorEmpleado = empleado;
                    }
                }
            }

            if (mejorEmpleado != null) {
                topVentas.add(mejorEmpleado);
            }
        }
    }

    private void aplicarDescuentosTopEmpleados(){
        int i = 0;
        while (i<this.topVentas.size()){
            this.topVentas.get(i).setEstadoDescuento(true);
        }
    }

    public void nuevoMes(){
        this.clientes.clear();
        this.topClientesAnteriorMes = this.topClientes;
        this.topClientes.clear();
        this.topVentasAnteriorMes = this.topVentas;
        ActualizartopVentas();
        aplicarDescuentosTopEmpleados();
    }

    public boolean estuvoAnteriorTop(Cliente cliente){
        int i = 0;
        while (i<this.topClientesAnteriorMes.size()){
            if (cliente.getPatente().equals(this.topClientesAnteriorMes.get(i).getNombre())){
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean estuvoAnteriorTop(Empleado empleado){
        int i = 0;
        int j = 0;
        while (i<this.topClientesAnteriorMes.size()){
            while (j<this.topClientesAnteriorMes.get(i).getVentas().size()){
                if (empleado.getDni().equals(this.topClientesAnteriorMes.get(i).getVentas().get(j).getDniEmpleado())){
                    return true;
                }
                j++;
            }
            i++;
        }
        return false;
    }

    public void ActualizarPrecio (Combustible combustible, double precioNuevo){
        int i = 0;
        while (i<this.expendedores.size()){
            if (this.expendedores.get(i).getCombustible().equals(combustible)){
                this.expendedores.get(i).getCombustible().setPrecioVenta(precioNuevo);
            }
        }
    }

}
