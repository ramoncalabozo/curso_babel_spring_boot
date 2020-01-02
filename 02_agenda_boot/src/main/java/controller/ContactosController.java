package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Contacto;
import service.AgendaService;

@RestController
public class ContactosController {
	@Autowired
	AgendaService agenda;
	
	@GetMapping(value="contactos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Contacto> getAllContactos() {
		return this.agenda.mostrarContactos();
	}

	@PostMapping(value="addContacto", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void nuevoContacto(@RequestBody Contacto contacto) {
		if(this.agenda.addContacto(contacto));
	}
	
	@GetMapping(value="buscar/{email}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Contacto buscarPorEmail(@PathVariable("email")String email) {
		return agenda.buscarContacto(email);
	}
	
	@GetMapping(value="contacto/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Contacto searchId(@PathVariable("id") int id) {
		return this.agenda.buscarContacto(id);
	}
	
	@PutMapping(value="modificar", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void modificarContacto(@RequestBody Contacto contacto){
		this.agenda.modificarContacto(contacto);
	}
	
	@DeleteMapping(value="eliminarId/{id}")
	public void eliminarContacto(@PathVariable("id") int id) {
		this.agenda.deleteContacto(id);
	}
	
	@DeleteMapping(value="eliminarEmail/{email}")
	public void eliminarContacto(@PathVariable("email") String email) {
		this.agenda.deleteContacto(email);
	}
}
