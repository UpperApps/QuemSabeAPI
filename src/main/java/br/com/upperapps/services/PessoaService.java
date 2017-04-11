package br.com.upperapps.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.upperapps.domain.Conhecimento;
import br.com.upperapps.domain.Pessoa;
import br.com.upperapps.repository.ConhecimentoRepository;
import br.com.upperapps.repository.PessoaRepository;
import br.com.upperapps.services.exceptions.PessoaExistenteException;
import br.com.upperapps.services.exceptions.PessoalNaoEncontradoException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ConhecimentoRepository conhecimentoRepository;

	public PessoaService() {

	}

	public Iterable<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

	public Pessoa salvar(Pessoa pessoa) {

		if (pessoa.getId() != null) {
			pessoaRepository.findOne(pessoa.getId());

			if (pessoa != null && pessoa.getNome() != null) {
				System.out.println(pessoa);
				System.out.println(pessoa.getNome());
				throw new PessoaExistenteException("A pessoa já existe.");
			}
		}

		return pessoaRepository.save(pessoa);

	}

	public void atualizar(Pessoa pessoa) {
		verificarExistencia(pessoa);
		pessoaRepository.save(pessoa);
	}

	public Pessoa buscar(Long id) {
		Pessoa pessoa = pessoaRepository.findOne(id);

		if (pessoa == null) {
			throw new PessoalNaoEncontradoException("Pessoa não encontrada");
		}
		return pessoa;
	}

	public void deletar(Long id) {

		try {
			pessoaRepository.delete(id);
		} catch (EmptyResultDataAccessException e) {
			throw new PessoalNaoEncontradoException("O pessoa não pôde ser encontrada.");
		}

	}

	private void verificarExistencia(Pessoa pessoa) {
		buscar(pessoa.getId());
	}
	
	public Iterable<Conhecimento> buscarConhecimentosDoProfissiinal (Long id){
		
		Iterable<Conhecimento> conhecimentos;
		
		conhecimentos = conhecimentoRepository.getConhecimentosDaPessoa(id);
		
		return conhecimentos;
	}
	
	public Iterable<Conhecimento> buscarPessoasQueConhecemUmAssunto (Long id){
		
		Iterable<Conhecimento> conhecimentos;
		
		conhecimentos = conhecimentoRepository.getPessoasQueConhecemUmAssunto(id);
		
		return conhecimentos;
	}
}
