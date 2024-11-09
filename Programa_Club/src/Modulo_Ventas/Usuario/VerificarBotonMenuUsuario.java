/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ventas.Usuario;

/**
 *
 * @author thiag
 */
import Modulo_Ventas.ConexionBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author thiag
 */
public class VerificarBotonMenuUsuario {
    private final ConexionBDD conexionBDD = new ConexionBDD();

    public boolean existeProducto() {
        String sql = "SELECT COUNT(*) FROM Productos WHERE Estado=1";
        try (Connection conn = conexionBDD.Conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true si hay al menos un producto.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexionBDD.cerrarConexion();
        }
        return false;
    }
    public boolean existePedidoUsuario(String usuarioID) {
        String sql = "SELECT COUNT(*) FROM Pedido WHERE IDUsuario=?";
        try (Connection conn = conexionBDD.Conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuarioID); // Asigna el usuarioID al parámetro de la consulta
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexionBDD.cerrarConexion();
        }
        return false;
    }
    public boolean existeReembolsoUsuario(String usuarioID) {
        String sql = "SELECT COUNT(*) FROM Reembolso_Pedido rp " +
                     "JOIN Pedido p ON rp.IDPedido = p.PedidoID " +
                     "WHERE p.IDUsuario = ? AND rp.Estado=1";
        try (Connection conn = conexionBDD.Conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuarioID); // Asigna el usuarioID al parámetro de la consulta
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0; // Retorna true si hay reembolsos para el usuario
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexionBDD.cerrarConexion();
        }
        return false;
    }
}