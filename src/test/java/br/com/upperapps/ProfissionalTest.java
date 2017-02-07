package br.com.upperapps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.upperapps.domain.Profissional;
import br.com.upperapps.services.ProfissionalService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {QuemSabeApiApplication.class})
public class ProfissionalTest {
	
	@Autowired
	private ProfissionalService profissionalService;
	private Profissional profissional;

	@Before
	public void criaProfissional() {
		profissional = new Profissional("Renato", "renato@gmail.com");
	}

	@Test
	public void naoDeveSalvarProfissionalComNomeVazioOuNulo() {
		
		try {
			profissional.setNome("");
			profissionalService.salvar(profissional);
			
			//Se o método salvar não falhar, irá lançar a falha do teste.
			Assert.fail("Não deveria permitir salvar sem o nome.");
			
		} catch (RuntimeException e) {
			System.out.println(e);
		}
	}

}
