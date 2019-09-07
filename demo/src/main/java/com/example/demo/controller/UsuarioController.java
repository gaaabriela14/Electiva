package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(path = "/crear/{nombre}/{edad}", method = RequestMethod.POST)
	String crearUsuario(@PathVariable("nombre") String nombreUsuario, @PathVariable("edad") String edad) {

		return usuarioService.crearUsuario(nombreUsuario, edad);
	}

	@RequestMapping(path = "/actualizar/{nombre}/{nombreNuevo}/{edad}", method = RequestMethod.PUT)
	String actualizarUsuario(@PathVariable("nombre") String nombreActualizado,
			@PathVariable("nombreNuevo") String nombreNew, @PathVariable("edad") String edad) {

		return usuarioService.actualizarUsuario(nombreActualizado, nombreNew, edad);
	}

	@RequestMapping(path = "/eliminar/{nombre}", method = RequestMethod.DELETE)
	String eliminarUsuario(@PathVariable("nombre") String user) {
		return usuarioService.eliminarUsuario(user);
	}

	@RequestMapping(path = "/buscar/{nombre}", method = RequestMethod.GET)
	Usuario buscarUsuario(@PathVariable("nombre") String user) {
		return usuarioService.buscarUsuario(user);
	}

	@RequestMapping(path = "/listar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	List<Usuario> listarUsuarios() {
		return usuarioService.listarUsuarios();
	}
}
