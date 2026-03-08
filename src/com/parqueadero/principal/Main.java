package com.parqueadero.principal;

import com.parqueadero.dao.VehiculoDAO;
import com.parqueadero.modelo.Vehiculo;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        VehiculoDAO vehiculoDAO = new VehiculoDAO();

        // INSERTAR VEHICULO
        Vehiculo vehiculoNuevo = new Vehiculo("ABC123", "Carro", "Rocio Rojas", "Rojo", "Activo");
        boolean insertado = vehiculoDAO.insertarVehiculo(vehiculoNuevo);
        System.out.println("Vehículo insertado: " + insertado);

        // CONSULTAR VEHICULO
        Vehiculo vehiculoConsultado = vehiculoDAO.consultarVehiculoPorPlaca("ABC123");

        if (vehiculoConsultado != null) {
            System.out.println("Vehículo encontrado:");
            System.out.println("Placa: " + vehiculoConsultado.getPlaca());
            System.out.println("Tipo: " + vehiculoConsultado.getTipo());
            System.out.println("Propietario: " + vehiculoConsultado.getPropietario());
            System.out.println("Color: " + vehiculoConsultado.getColor());
            System.out.println("Estado: " + vehiculoConsultado.getEstado());
        } else {
            System.out.println("Vehículo no encontrado.");
        }

        // ACTUALIZAR VEHICULO
        Vehiculo vehiculoActualizado = new Vehiculo("ABC123", "Carro", "Rocio Rojas", "Negro", "Activo");
        boolean actualizado = vehiculoDAO.actualizarVehiculo(vehiculoActualizado);
        System.out.println("Vehículo actualizado: " + actualizado);

        // LISTAR VEHICULOS
        List<Vehiculo> listaVehiculos = vehiculoDAO.listarVehiculos();
        System.out.println("Lista de vehículos registrados:");

        for (Vehiculo vehiculo : listaVehiculos) {
            System.out.println(
                    vehiculo.getPlaca() + " - " +
                    vehiculo.getTipo() + " - " +
                    vehiculo.getPropietario()
            );
        }

        // ELIMINAR VEHICULO
        boolean eliminado = vehiculoDAO.eliminarVehiculo("ABC123");
        System.out.println("Vehículo eliminado: " + eliminado);
    }
}