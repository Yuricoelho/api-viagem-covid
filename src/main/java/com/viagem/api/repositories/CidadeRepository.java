package com.viagem.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viagem.api.domains.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
