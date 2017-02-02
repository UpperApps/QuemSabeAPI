package br.com.upperapps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.upperapps.domain.Profissional;
import br.com.upperapps.repository.ProfissionalRepository;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository profissionalRepository;

	public ProfissionalService() {
		// TODO Auto-generated constructor stub
	}

	public Iterable<Profissional> listar() {
		return profissionalRepository.findAll();
	}

	public Profissional salvar(Profissional profissional) {

		if (profissional.getId() != null) {
			Profissional prof = profissionalRepository.findOne(profissional.getId());

			if (prof != null) {
				
			//TODO Fazer a implementação de uma classe de exceção customizada.
				throw new RuntimeException("O profissional já existe.");
			}
		}

		return profissionalRepository.save(profissional);
	}
	
	public void atualizar(Profissional profissional) {
		verificarExistencia(profissional);
		profissionalRepository.save(profissional);
	}


	public Profissional buscar(Long id) {
		Profissional profissional = profissionalRepository.findOne(id);
		
		if (profissional == null) {
			throw new RuntimeException("Profissional não encontrado");
		}
		return profissional;
	}

	public void deletar(Long id) {
		
		try {
			profissionalRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RuntimeException("O profissional não pôde ser encontrado.");
		}
		
	}

	private void verificarExistencia(Profissional profissional) {
		buscar(profissional.getId());
	}
}
