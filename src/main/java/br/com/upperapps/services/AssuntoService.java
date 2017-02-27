package br.com.upperapps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.upperapps.domain.Categoria;
import br.com.upperapps.domain.Assunto;
import br.com.upperapps.repository.CategoriaRepository;
import br.com.upperapps.repository.AssuntoRepository;
import br.com.upperapps.services.exceptions.CategoriaNaoEncontradaException;
import br.com.upperapps.services.exceptions.AssuntoExistenteException;
import br.com.upperapps.services.exceptions.AssuntoNaoEncontradoException;

@Service
public class AssuntoService {

	@Autowired
	private AssuntoRepository assuntoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	public AssuntoService() {

	}

	public Iterable<Assunto> listar() {
		return assuntoRepository.findAll();
	}

	public Assunto salvar(Assunto assunto) {

		Long idCategoria = assunto.getCategoria().getId();

		verificarExistenciaCategoria(idCategoria);

		if (assunto.getId() != null) {
			assuntoRepository.findOne(assunto.getId());

			if (assunto != null) {

				throw new AssuntoExistenteException("O conhecimento já existe.");
			}
		}

		return assuntoRepository.save(assunto);

	}

	public void atualizar(Assunto assunto) {
		verificarExistencia(assunto);
		assuntoRepository.save(assunto);
	}

	public Assunto buscar(Long id) {
		Assunto assunto = assuntoRepository.findOne(id);

		if (assunto == null) {
			throw new AssuntoNaoEncontradoException("Conhecimento não encontrado.");
		}
		return assunto;
	}

	public void deletar(Long id) {

		try {
			assuntoRepository.delete(id);
		} catch (Exception e) {
			throw new AssuntoNaoEncontradoException("O conhecimento não pôde ser encontrado." + e);
		}

	}

	private void verificarExistencia(Assunto assunto) {
		buscar(assunto.getId());
	}

	private void verificarExistenciaCategoria(Long id) {

		Categoria categoria = categoriaRepository.findOne(id);
		
		if (categoria == null) {
			throw new CategoriaNaoEncontradaException("A categoria informada não existe.");
		}

	}
}
