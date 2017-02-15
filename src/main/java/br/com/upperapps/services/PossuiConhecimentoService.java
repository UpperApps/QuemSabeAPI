package br.com.upperapps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.upperapps.domain.PossuiConhecimento;
import br.com.upperapps.repository.PossuiConhecimentoRepository;
import br.com.upperapps.services.exceptions.PossuiConhecimentoExistenteException;
import br.com.upperapps.services.exceptions.PossuiConhecimentoNaoEncontradoException;

@Service
public class PossuiConhecimentoService {

	@Autowired
	private PossuiConhecimentoRepository possuiConhecimentolRepository;

	public PossuiConhecimentoService() {

	}

	public Iterable<PossuiConhecimento> listar() {
		return possuiConhecimentolRepository.findAll();
	}

	public PossuiConhecimento salvar(PossuiConhecimento possuiConhecimento) {

		if (possuiConhecimento.getId() != null) {
			possuiConhecimentolRepository.findOne(possuiConhecimento.getId());

			if (possuiConhecimento != null) {

				throw new PossuiConhecimentoExistenteException("O possuiConhecimento já existe.");
			}
		}

		return possuiConhecimentolRepository.save(possuiConhecimento);

	}

	public void atualizar(PossuiConhecimento possuiConhecimento) {
		verificarExistencia(possuiConhecimento);
		possuiConhecimentolRepository.save(possuiConhecimento);
	}

	public PossuiConhecimento buscar(Long id) {
		PossuiConhecimento possuiConhecimento = possuiConhecimentolRepository.findOne(id);

		if (possuiConhecimento == null) {
			throw new PossuiConhecimentoNaoEncontradoException("Conhecimento não encontrado para o profissional");
		}
		return possuiConhecimento;
	}

	public void deletar(Long id) {

		try {
			possuiConhecimentolRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new PossuiConhecimentoNaoEncontradoException("O conhecimento do profisisonal não pôde ser encontrado.");
		}

	}

	private void verificarExistencia(PossuiConhecimento possuiConhecimento) {
		buscar(possuiConhecimento.getId());
	}
}
