package controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Persona;

@RestController
public class SaludoController {

	@GetMapping(value="saludar",produces=MediaType.TEXT_PLAIN_VALUE)
	public String generarSaludo() {
		return "Hola Mundo";
	}
	
	@GetMapping(value="saludar/{nombre}",produces=MediaType.TEXT_PLAIN_VALUE)
	public String generarSaludo(@PathVariable("nombre") String n) {
		return "Bienvenido " + n;
	}
	
	@GetMapping(value="saludar",produces=MediaType.APPLICATION_JSON_VALUE)
	public Persona enviarPersona() {
		return new Persona("prueba","dfgh",632);
		
	}
	@PostMapping(value="saludar",produces=MediaType.APPLICATION_JSON_VALUE)
	public void altaPersona(@RequestBody Persona persona) {//transforma el json que llega a un objeto de tipo persona
		System.out.println("Se a�ade la persona " + persona.getNombre());
	}
}
