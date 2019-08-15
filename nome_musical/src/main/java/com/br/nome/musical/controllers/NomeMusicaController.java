package com.br.nome.musical.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.nome.musical.models.NomeMusicaModel;
import com.br.nome.musical.services.NomeMusicaService;

@RestController
@RequestMapping("/api/musica")
public class NomeMusicaController {
	
	@Autowired
	private NomeMusicaService nomeMusicaService;
	
	@GetMapping
	public ResponseEntity<?> exibirMusicas(){
		
		return ResponseEntity.ok(nomeMusicaService.buscarTodasMusicas());
		
	}
	
	@PostMapping
	public ResponseEntity<?> salvarMusica(@RequestBody NomeMusicaModel musica){
		
		nomeMusicaService.salvarMusica(musica);
		return ResponseEntity.status(HttpStatus.CREATED).body(musica);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarMusicaPeloId(@PathVariable int id){
		
		return ResponseEntity.ok(nomeMusicaService.buscarMusica(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarMusicas(@PathVariable int id, @RequestBody NomeMusicaModel musica){
		
		nomeMusicaService.atualizarMusica(id, musica);
		return ResponseEntity.ok(musica);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarMusica(@PathVariable int id){
		
		nomeMusicaService.deleteMusica(id);
		return ResponseEntity.ok().build();
	}
	

}
