package com.viagem.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viagem.api.domains.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
