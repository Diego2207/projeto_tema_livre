package com.br.nome.musical.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.nome.musical.models.NomeMusicaModel;
import com.br.nome.musical.repositories.NomeMusicaRepository;

@Service
public class NomeMusicaService {
	
	@Autowired
	private NomeMusicaRepository nomeMusicaRepository;
	
	public String salvarMusica(NomeMusicaModel musica) {
		
		nomeMusicaRepository.save(musica);
		return "musica criada";
		
	}
	
	public Iterable<NomeMusicaModel> buscarTodasMusicas(){
		
		return nomeMusicaRepository.findAll();
	}
	
	public void deleteMusica(Integer id) {
		
		nomeMusicaRepository.deleteById(id);
	}

	public NomeMusicaModel buscarMusica(Integer id) {
		
		return nomeMusicaRepository.findById(id).get();
	}
	
	public void atualizarMusica(int id, NomeMusicaModel musica) {
		
		musica.setId(id);
		nomeMusicaRepository.save(musica);
	}
}
