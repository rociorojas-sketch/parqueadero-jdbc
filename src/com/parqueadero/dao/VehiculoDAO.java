package com.parqueadero.dao;

import com.parqueadero.conexion.ConexionBD;
import com.parqueadero.modelo.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoDAO {

    public boolean insertarVehiculo(Vehiculo vehiculo) {
        String sql = "INSERT INTO vehiculo (placa, tipo, propietario, color, estado) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, vehiculo.getPlaca());
            ps.setString(2, vehiculo.getTipo());
            ps.setString(3, vehiculo.getPropietario());
            ps.setString(4, vehiculo.getColor());
            ps.setString(5, vehiculo.getEstado());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al insertar vehículo: " + e.getMessage());
            return false;
        }
    }

    public Vehiculo consultarVehiculoPorPlaca(String placa) {
        String sql = "SELECT * FROM vehiculo WHERE placa = ?";
        Vehiculo vehiculo = null;

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, placa);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                vehiculo = new Vehiculo();
                vehiculo.setId(rs.getInt("id"));
                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setTipo(rs.getString("tipo"));
                vehiculo.setPropietario(rs.getString("propietario"));
                vehiculo.setColor(rs.getString("color"));
                vehiculo.setEstado(rs.getString("estado"));
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar vehículo: " + e.getMessage());
        }

        return vehiculo;
    }

    public List<Vehiculo> listarVehiculos() {
        String sql = "SELECT * FROM vehiculo";
        List<Vehiculo> listaVehiculos = new ArrayList<>();

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setId(rs.getInt("id"));
                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setTipo(rs.getString("tipo"));
                vehiculo.setPropietario(rs.getString("propietario"));
                vehiculo.setColor(rs.getString("color"));
                vehiculo.setEstado(rs.getString("estado"));

                listaVehiculos.add(vehiculo);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar vehículos: " + e.getMessage());
        }

        return listaVehiculos;
    }

    public boolean actualizarVehiculo(Vehiculo vehiculo) {
        String sql = "UPDATE vehiculo SET tipo = ?, propietario = ?, color = ?, estado = ? WHERE placa = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, vehiculo.getTipo());
            ps.setString(2, vehiculo.getPropietario());
            ps.setString(3, vehiculo.getColor());
            ps.setString(4, vehiculo.getEstado());
            ps.setString(5, vehiculo.getPlaca());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al actualizar vehículo: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarVehiculo(String placa) {
        String sql = "DELETE FROM vehiculo WHERE placa = ?";

        try (Connection conexion = ConexionBD.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, placa);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error al eliminar vehículo: " + e.getMessage());
            return false;
        }
    }
}