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
	private ConhecimentoRepository conhecimentoRepository;
	
	public ConhecimentoService(){
		
	}
	
	public Iterable<Conhecimento> listar() {
		return conhecimentoRepository.findAll();
	}

	public Conhecimento salvar(Conhecimento conhecimento) {

		if (conhecimento.getId() != null) {
			conhecimentoRepository.findOne(conhecimento.getId());

			if (conhecimento != null) {

				throw new ConhecimentoExistenteException("O conhecimento já existe.");
			}
		}

		return conhecimentoRepository.save(conhecimento);

	}

	public void atualizar(Conhecimento conhecimento) {
		verificarExistencia(conhecimento);
		conhecimentoRepository.save(conhecimento);
	}

	public Conhecimento buscar(Long id) {
		Conhecimento conhecimento = conhecimentoRepository.findOne(id);

		if (conhecimento == null) {
			throw new ConhecimentoNaoEncontradoException("Conhecimento não encontrada");
		}
		return conhecimento;
	}

	public void deletar(Long id) {

		try {
			conhecimentoRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ConhecimentoNaoEncontradoException("O conhecimento não pôde ser encontrado.");
		}

	}

	private void verificarExistencia(Conhecimento conhecimento) {
		buscar(conhecimento.getId());
	}
}
