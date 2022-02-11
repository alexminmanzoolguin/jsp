package com.modelo;

import java.sql.Connection;
import java.sql.ResultSet;

import com.conexion.Conexion;
import com.entidad.Usuario;


import java.sql.PreparedStatement;


public class ModeloUsuario {
    public String Iniciar(String usuario,String contrasena){
         Usuario usuarios=null;
        Connection con=null;
        PreparedStatement pstm = null;
        ResultSet rs=null;
    
    try {
			con = Conexion.getConexion();
			String sql = "SELECT U.id_usuario, U.usuario, U.contrasena FROM usuario U WHERE U.nombre = ? AND U.contrasena = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, usuario);
			pstm.setString(2, contrasena);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				usuarios = new Usuario();
				usuarios.setId_usuario(rs.getInt("id_Usuario"));
				usuarios.setusuario(rs.getString("usuario"));
				usuarios.setContrasena(rs.getString("contrasena"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				
				if (pstm != null) {
					pstm.close();
				}
				
				if (con != null) {
					con.close();
				}
			} catch (Exception e2) {
			}
		}
		
		return usuario;
    }

    
}