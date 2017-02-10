package br.com.upperapps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.upperapps.domain.Categoria;
import br.com.upperapps.repository.CategoriaRepository;
import br.com.upperapps.services.exceptions.CategoriaExistenteException;
import br.com.upperapps.services.exceptions.CategoriaNaoEncontradaException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public CategoriaService() {

	}

	public Iterable<Categoria> listar() {
		return categoriaRepository.findAll();
	}

	public Categoria salvar(Categoria categoria) {

		if (categoria.getId() != null) {
			categoriaRepository.findOne(categoria.getId());

			if (categoria != null) {

				throw new CategoriaExistenteException("O categoria já existe.");
			}
		}

		return categoriaRepository.save(categoria);

	}

	public void atualizar(Categoria categoria) {
		verificarExistencia(categoria);
		categoriaRepository.save(categoria);
	}

	public Categoria buscar(Long id) {
		Categoria categoria = categoriaRepository.findOne(id);

		if (categoria == null) {
			throw new CategoriaNaoEncontradaException("Categoria não encontrada");
		}
		return categoria;
	}

	public void deletar(Long id) {

		try {
			categoriaRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new CategoriaNaoEncontradaException("O categoria não pôde ser encontrado.");
		}

	}

	private void verificarExistencia(Categoria categoria) {
		buscar(categoria.getId());
	}
}
