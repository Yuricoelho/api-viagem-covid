package com.viagem.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viagem.api.domains.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
