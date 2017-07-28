package br.com.upperapps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.upperapps.domain.Conhecimento;
import br.com.upperapps.repository.ConhecimentoRepository;
import br.com.upperapps.services.exceptions.ConhecimentoExistenteException;
import br.com.upperapps.services.exceptions.ConhecimentoNaoEncontradoException;

@Service
public class ConhecimentoService {

	@Autowired
	private ConhecimentoRepository possuiConhecimentolRepository;

	public ConhecimentoService() {

	}

	public Iterable<Conhecimento> listar() {

		return possuiConhecimentolRepository.findAll();
		
	}
	
	public Iterable<Conhecimento> listarPorPessoa(Long id) {

		return possuiConhecimentolRepository.getConhecimentosDaPessoa(id);
		
	}

	public Conhecimento salvar(Conhecimento conhecimento) {

		if (conhecimento.getId() != null) {
			possuiConhecimentolRepository.findOne(conhecimento.getId());

			if (conhecimento != null) {

				throw new ConhecimentoExistenteException("O possuiConhecimento já existe.");
			}
		}

		return possuiConhecimentolRepository.save(conhecimento);

	}

	public void atualizar(Conhecimento conhecimento) {
		verificarExistencia(conhecimento);
		possuiConhecimentolRepository.save(conhecimento);
	}

	public Conhecimento buscar(Long id) {
		Conhecimento conhecimento = possuiConhecimentolRepository.findOne(id);

		if (conhecimento == null) {
			throw new ConhecimentoNaoEncontradoException("Conhecimento não encontrado.");
		}
		return conhecimento;
	}

	public void deletar(Long id) {

		try {
			possuiConhecimentolRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ConhecimentoNaoEncontradoException(
					"O conhecimento do profisisonal não pôde ser encontrado.");
		}

	}

	private void verificarExistencia(Conhecimento conhecimento) {
		buscar(conhecimento.getId());
	}
}
