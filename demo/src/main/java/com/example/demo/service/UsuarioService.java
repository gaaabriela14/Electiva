package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public String crearUsuario(String nombre, String edad) {
		if (nombre.equals("") || edad.equals("")) {
			return "Debe ingresar el nombre y edad del usuario";
		} else {
			Usuario usuario = new Usuario(nombre, Integer.parseInt(edad));
			return usuarioRepository.crearUsuario(usuario);
		}
	}

	public String actualizarUsuario(String nombre, String nombreNuevo, String edad) {
		return usuarioRepository.actualizarUsuario(nombre, nombreNuevo, Integer.parseInt(edad));
	}

	public String eliminarUsuario(String nombreUsuario) {
		if (nombreUsuario.equals("")) {
			return "Debe ingresar el nombre para eliminar";
		} else {
			Usuario usuario = usuarioRepository.buscarUsuario(nombreUsuario);
			return usuarioRepository.eliminarUsuario(usuario);
		}
	}

	public Usuario buscarUsuario(String nombreUsuario) {
		return usuarioRepository.buscarUsuario(nombreUsuario);
	}

	public List<Usuario> listarUsuarios() {
		return usuarioRepository.listarUsuarios();
	}
}
