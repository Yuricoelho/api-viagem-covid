package com.viagem.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viagem.api.domains.Cidade;
import com.viagem.api.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;
	
	public List<Cidade> findAll() {
		return repository.findAll();
	}

	public Cidade findById(Long id) { 
		Optional<Cidade> obj = repository.findById(id);
		return obj.orElseThrow();
	}

	public Cidade insert(Cidade obj) { 
		return repository.save(obj);
	}

	public void delete(Long id) { 
		
			repository.deleteById(id);
	}

	public Cidade update(Long id, Cidade obj) {
		
			Cidade entity = findById(id);  
			updateDate(entity, obj);				
			return repository.save(entity);			
		

	}

	private void updateDate(Cidade entity, Cidade obj) {
		entity.setId(obj.getId());
		entity.setNome(obj.getNome());
		entity.setQtdHabitantes(obj.getQtdHabitantes());
		entity.setQtdVacinados(obj.getQtdVacinados());
		;
	}
}
