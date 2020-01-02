package controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Item;
import service.ClienteAgendaService;
@CrossOrigin(origins="*")
@RestController
public class GeneradorContactosController {
	@Autowired
	ClienteAgendaService agenda;

	@GetMapping(value="actualizar/{nombre}/{email}/{edad}")
	public List<Item> procesarContacto(@PathVariable("nombre")String nombre,
			@PathVariable("email")String email,
			@PathVariable("edad")int edad) {
		Item item = new Item(0,edad,email,nombre);
		agenda.procesarContacto(item);
		List<Item> lista =  agenda.devolverContactos();
		System.out.println(lista);
		return lista;
	}
}
