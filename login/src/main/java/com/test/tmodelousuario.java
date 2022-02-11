package com.test;

import com.entidad.Usuario;
import com.modelo.ModeloUsuario;

public class tmodelousuario {
    public static void main(String[] args) {
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		Usuario usuario = modeloUsuario.Iniciar("admin", "123");
		if (usuario == null) {
			System.out.println("No pudo iniciar sesión");
		} else {
			System.out.println("Bienvenido");
		}
	}
}
