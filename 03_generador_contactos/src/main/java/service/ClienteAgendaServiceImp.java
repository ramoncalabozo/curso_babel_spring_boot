package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import model.Item;

@Service
public class ClienteAgendaServiceImp implements ClienteAgendaService {
	private String url = "http://localhost:8080";
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
}
