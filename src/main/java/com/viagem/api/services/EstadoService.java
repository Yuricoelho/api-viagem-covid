package com.viagem.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagem.api.domains.Estado;
import com.viagem.api.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;
	
	public List<Estado> findAll() {
		return repository.findAll();
	}

	public Estado findById(Long id) { 
		Optional<Estado> obj = repository.findById(id);
		return obj.orElseThrow();
	}

	public Estado insert(Estado obj) { 
		return repository.save(obj);
	}

	public void delete(Long id) { 
		
			repository.deleteById(id);
	}

	public Estado update(Long id, Estado obj) {
		
		Estado entity = findById(id);  
			updateDate(entity, obj);				
			return repository.save(entity);			
		

	}

	private void updateDate(Estado entity, Estado obj) {
		entity.setId(obj.getId());
		entity.setNome(obj.getNome());
	}
}
