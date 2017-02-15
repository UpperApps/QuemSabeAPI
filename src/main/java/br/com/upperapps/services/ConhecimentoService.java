package br.com.upperapps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.upperapps.domain.Categoria;
import br.com.upperapps.domain.Conhecimento;
import br.com.upperapps.repository.CategoriaRepository;
import br.com.upperapps.repository.ConhecimentoRepository;
import br.com.upperapps.services.exceptions.CategoriaNaoEncontradaException;
import br.com.upperapps.services.exceptions.ConhecimentoExistenteException;
import br.com.upperapps.services.exceptions.ConhecimentoNaoEncontradoException;

@Service
public class ConhecimentoService {

	@Autowired
	private ConhecimentoRepository conhecimentoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	public ConhecimentoService() {

	}

	public Iterable<Conhecimento> listar() {
		return conhecimentoRepository.findAll();
	}

	public Conhecimento salvar(Conhecimento conhecimento) {

		Long idCategoria = conhecimento.getCategoria().getId();

		verificarExistenciaCategoria(idCategoria);

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
			throw new ConhecimentoNaoEncontradoException("Conhecimento não encontrado.");
		}
		return conhecimento;
	}

	public void deletar(Long id) {

		try {
			conhecimentoRepository.delete(id);
		} catch (Exception e) {
			throw new ConhecimentoNaoEncontradoException("O conhecimento não pôde ser encontrado." + e);
		}

	}

	private void verificarExistencia(Conhecimento conhecimento) {
		buscar(conhecimento.getId());
	}

	private void verificarExistenciaCategoria(Long id) {

		Categoria categoria = categoriaRepository.findOne(id);
		
		if (categoria == null) {
			throw new CategoriaNaoEncontradaException("A categoria informada não existe.");
		}

	}
}
