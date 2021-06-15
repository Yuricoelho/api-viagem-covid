package com.viagem.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagem.api.domains.Hotel;
import com.viagem.api.repositories.HotelRepository;

@Service
public class HotelService {

	@Autowired
	private HotelRepository repository;
	
	public List<Hotel> findAll() {
		return repository.findAll();
	}

	public Hotel findById(Long id) { 
		Optional<Hotel> obj = repository.findById(id);
		return obj.orElseThrow();
	}

	public Hotel insert(Hotel obj) { 
		return repository.save(obj);
	}

	public void delete(Long id) { 
		
			repository.deleteById(id);
	}

	public Hotel update(Long id,Hotel obj) {
		
		Hotel entity = findById(id);  
			updateDate(entity, obj);				
			return repository.save(entity);			
		

	}

	private void updateDate(Hotel entity, Hotel obj) {
		entity.setId(obj.getId());
		entity.setNome(obj.getNome());
		entity.setQtdQuartos(obj.getQtdQuartos());
		entity.setOcupacao(obj.getOcupacao());
		
	}
}
