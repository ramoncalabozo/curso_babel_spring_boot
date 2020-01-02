package controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Item;
import service.ClienteAgendaService;
@RestController

public class GeneradorContactosController {
	@Autowired
	ClienteAgendaService agenda;

	@GetMapping(value="actualizar/{nombre}/{email}/{edad}")
	public void procesarContacto(@PathVariable("nombre")String nombre,
			@PathVariable("email")String email,
			@PathVariable("edad")int edad) {
		Item item = new Item(0,edad,email,nombre);
		agenda.procesarContacto(item);
	}
}
