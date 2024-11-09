/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo_Ventas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author thiag
 */
public class VerificarBotonMenu {
    private final ConexionBDD conexionBDD = new ConexionBDD();

    public boolean existeCategoria() {
        String sql = "SELECT COUNT(*) FROM Categorias";
        try (Connection conn = conexionBDD.Conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true si hay al menos una categoría.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexionBDD.cerrarConexion();
        }
        return false;
    }

    public boolean existeProducto() {
        String sql = "SELECT COUNT(*) FROM Productos";
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
    public boolean existeReembolso() {
        String sql = "SELECT COUNT(*) FROM Reembolso_Pedido;";
        try (Connection conn = conexionBDD.Conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            if (rs.next()) {
                return rs.getInt(1) > 0; // Retorna true si hay al menos un reembolso.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexionBDD.cerrarConexion();
        }
        return false;
    }
}
