package service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Item;

@Service
public class ClienteAgendaServiceImp implements ClienteAgendaService {
	private String url = "http://servicio-agenda";
	@Autowired
	private RestTemplate template;

	@Override
	public void procesarContacto(Item item) {
		String email = item.getEmail();
		Item recibido = template.getForObject(url + "/buscar/" + email, Item.class);
		if (recibido == null) {
			template.postForLocation(url + "/addContacto", item);
		} else {
			recibido.setEdad(item.getEdad());
			recibido.setNombre(item.getNombre());
			template.put(url + "/modificar", recibido);
		}
	}
	public List<Item> devolverContactos(){
		ResponseEntity<Item[]> contactos=template.getForEntity(url+"/contactos", Item[].class);
		HttpHeaders headers = contactos.getHeaders();
		System.out.println(headers);
		/*
		 mostramos el valor de un eccabezado
		 */
		System.out.println(headers.get("total").toString());
		return Arrays.asList(contactos.getBody());
	}
}
