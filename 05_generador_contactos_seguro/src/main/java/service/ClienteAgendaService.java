package service;

import java.util.List;

import model.Item;

public interface ClienteAgendaService {

	void procesarContacto(Item item);
	public List<Item> devolverContactos();

}