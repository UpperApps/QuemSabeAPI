package br.com.upperapps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.upperapps.domain.Pessoa;
import br.com.upperapps.services.PessoaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {QuemSabeApiApplication.class})
public class ProfissionalTest {
	
	@Autowired
	private PessoaService pessoaService;
	private Pessoa pessoa;

	@Before
	public void criaProfissional() {
		pessoa = new Pessoa("Renato", "renato@gmail.com");
	}

	@Test
	public void naoDeveSalvarProfissionalComNomeVazioOuNulo() {
		
		try {
			pessoa.setNome("");
			pessoaService.salvar(pessoa);
			
			//Se o método salvar não falhar, irá lançar a falha do teste.
			Assert.fail("Não deveria permitir salvar sem o nome.");
			
		} catch (RuntimeException e) {
			System.out.println(e);
		}
	}

}
