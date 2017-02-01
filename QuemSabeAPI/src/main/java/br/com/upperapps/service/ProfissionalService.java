package br.com.upperapps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.upperapps.domain.Profissional;
import br.com.upperapps.repository.ProfissionalRepository;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository repository;

	public ProfissionalService() {
		// TODO Auto-generated constructor stub
	}

	public Iterable<Profissional> listar() {
		return repository.findAll();
	}

	public Profissional salvar(Profissional profissional) {

		if (profissional.getId() != null) {
			Profissional prof = repository.findOne(profissional.getId());

			if (prof != null) {
				
			//TODO Fazer a implementação de uma classe de exceção customizada.
				throw new RuntimeException("O profissional já existe.");
			}
		}

		return repository.save(profissional);
	}

}
