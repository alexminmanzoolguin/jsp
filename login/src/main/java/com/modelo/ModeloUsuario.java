package com.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.conexion.Conexion;
import com.entidad.Usuario;

public class ModeloUsuario {
    public Usuario Iniciar(String usuario,String contrasena){
        Usuario usuarios=null;
        Connection cn=null;
        PreparedStatement ptsm=null;
        ResultSet rs=null;
        
        try{
            cn=Conexion.getConexion();
            String sql="Select U.Id_usuario,U.usuario,U.contrasenia From usuario U WHERE U.nombre=? AND U.contrasenia=?";
            ptsm=cn.prepareStatement(sql);
            ptsm.setString(1, usuario);
            ptsm.setString(2, contrasena);
            rs=ptsm.executeQuery();
            while(rs.next()){
                usuarios= new Usuario();
                usuarios.setId_usuario(rs.getInt("id_usuario"));
                usuarios.setNombre(rs.getString("usuario"));
                usuarios.setContrasena(rs.getString("contrasena"));
             }

        }catch(Exception e){
            e.printStackTrace();
            }finally{
            try{
                if(rs !=null){
                    rs.close();
                }
                if(ptsm !=null){
                    ptsm.close();
                }
                if(cn !=null){
                    cn.close();
                }
            }catch(Exception e2){
                e2.printStackTrace();
            }
        }
        return usuarios;
    }
}
