package br.com.upperapps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.upperapps.domain.Conhecimento;
import br.com.upperapps.domain.Profissional;
import br.com.upperapps.repository.ConhecimentoRepository;
import br.com.upperapps.repository.ProfissionalRepository;
import br.com.upperapps.services.exceptions.ProfissionalExistenteException;
import br.com.upperapps.services.exceptions.ProfissionalNaoEncontradoException;

@Service
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	@Autowired
	private ConhecimentoRepository conhecimentoRepository;

	public ProfissionalService() {

	}

	public Iterable<Profissional> listar() {
		return profissionalRepository.findAll();
	}

	public Profissional salvar(Profissional profissional) {

		if (profissional.getId() != null) {
			profissionalRepository.findOne(profissional.getId());

			if (profissional != null) {

				throw new ProfissionalExistenteException("O profissional já existe.");
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
			throw new ProfissionalNaoEncontradoException("Profissional não encontrado");
		}
		return profissional;
	}

	public void deletar(Long id) {

		try {
			profissionalRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ProfissionalNaoEncontradoException("O profissional não pôde ser encontrado.");
		}

	}

	private void verificarExistencia(Profissional profissional) {
		buscar(profissional.getId());
	}
	
	public Iterable<Conhecimento> buscarConhecimentosDoProfissiinal (Long id){
		
		Iterable<Conhecimento> conhecimentos;
		
		conhecimentos = conhecimentoRepository.getConhecimentosDoProfissional(id);
		
		return conhecimentos;
	}
	
	public Iterable<Conhecimento> buscarProfissionaisQueConhecemAssunto (Long id){
		
		Iterable<Conhecimento> conhecimentos;
		
		conhecimentos = conhecimentoRepository.getProfissionaisQueConhecemAssunto(id);
		
		return conhecimentos;
	}
}
