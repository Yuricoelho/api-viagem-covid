package com.viagem.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.viagem.api.domains.Cidade;
import com.viagem.api.domains.Estado;
import com.viagem.api.domains.Hotel;
import com.viagem.api.repositories.CidadeRepository;
import com.viagem.api.repositories.EstadoRepository;
import com.viagem.api.repositories.HotelRepository;

@Configuration  //PARA INFORMAR QUE É UMA CLASSE DE CONFIGURAÇÃO
@Profile("test")  //INFORMAR O PERFIL
public class TestConfig implements CommandLineRunner{

	@Autowired
	private EstadoRepository estado;
	
	@Autowired
	private CidadeRepository cidade;
	
	@Autowired
	private HotelRepository hotel;

	@Override
	public void run(String... args) throws Exception {
		
		Estado est1 = new Estado(null, "Goiás");
		Estado est2 = new Estado(null, "São Paulo");
		Estado est3 = new Estado(null, "Rio de Janeiro");
		Estado est4 = new Estado(null, "Distrito Federal");
		
		Cidade cid1 = new Cidade(null, "Goiania", 1466105.00 , 10.00, est1);
		Cidade cid2 = new Cidade(null, "Goiania", 1466105.00 , 40.00, est1);
		Cidade cid3 = new Cidade(null, "Goiania", 1466105.00 , 40.00, est1);
		
		Hotel hot1 = new Hotel(null, "Golden", 150, 60.00, cid1);
		
		estado.saveAll(Arrays.asList(est1, est2, est3, est4));
		cidade.saveAll(Arrays.asList(cid1, cid2, cid3));
		hotel.saveAll(Arrays.asList(hot1));
	} 

}
