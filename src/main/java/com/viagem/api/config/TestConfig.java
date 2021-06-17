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
		
		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null, "Rio de Janeiro");
		Estado est3 = new Estado(null, "Distrito Federal");
		
		Cidade cid1 = new Cidade(null, "Santos", 412621.99 , 11.00, est1);
		Cidade cid2 = new Cidade(null, "Niterói", 159899.29 , 7.00, est2);
		Cidade cid3 = new Cidade(null, "Brasília", 30551.49 , 23.00, est3);
		
		
		Hotel hot1 = new Hotel(null, "Golden", 200, 60.00, cid3);
		Hotel hot2 = new Hotel(null, "Excelsior", 175, 40.00, cid3);
		Hotel hot3 = new Hotel(null, "Prime", 500, 20.00, cid1);
		Hotel hot4 = new Hotel(null, "Cooper", 270, 70.00, cid1);
		Hotel hot5 = new Hotel(null, "Plaza", 800, 30.00, cid2);
		Hotel hot6 = new Hotel(null, "Terraço", 320, 60.00, cid2);
		
		estado.saveAll(Arrays.asList(est1, est2, est3));
		cidade.saveAll(Arrays.asList(cid1, cid2, cid3));
		hotel.saveAll(Arrays.asList(hot1, hot2, hot3, hot4, hot5, hot6));
	} 

}
