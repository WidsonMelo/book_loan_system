package com.mert.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mert.model.Amigo;
import com.mert.repository.AmigoRepository;

@Service
@Transactional
public class AmigoService {

	private final AmigoRepository amigoRepository;

	public AmigoService(AmigoRepository amigoRepository) {
		this.amigoRepository = amigoRepository;
	}

	public List<Amigo> findAll() {
		List<Amigo> amigos = new ArrayList<>();
		amigos = amigoRepository.findAll();
		return amigos;
	}

	public Amigo findAmigo(int id) {
		return amigoRepository.findOne(id);
	}

	public void save(Amigo amigo) {
		amigoRepository.save(amigo);
	}

	public void delete(int id) {
		amigoRepository.delete(id);

	}
}
