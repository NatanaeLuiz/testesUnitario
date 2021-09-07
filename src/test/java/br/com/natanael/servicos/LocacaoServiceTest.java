package br.com.natanael.servicos;


import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.natanael.entidades.Filme;
import br.com.natanael.entidades.Locacao;
import br.com.natanael.entidades.Usuario;
import br.com.natanael.servicos.LocacaoService;
import br.com.natanael.utils.DataUtils;

public class LocacaoServiceTest {

	private LocacaoService servico;
	private Usuario user;
	private static int contadorTestes = 0;
	
	/*
	 * Metodo executado antes de cada teste
	 */
	@Before
	public void antes() {
		servico = new LocacaoService();
		user = new Usuario("Natanael");
		contadorTestes++;
		System.out.println("=====TESTE " + contadorTestes +"=====");
	}
	
	/*
	 * Metodo executado depois de cada teste
	 */
	@After
	public void depois() {
		System.out.println("=====FIM TESTE " + contadorTestes + "=====");
	}
	
	@Test
	public void testeLocacao() {
		//Cenario
		Filme filme = new Filme("Filme 1", 10, 2.5);
		
		//Acao
		Locacao locacao;
		try {
			locacao = servico.alugarFilme(user, filme);
			
			//Verificação
			
			System.out.println(locacao.getValor());
			Assert.assertEquals(2.5, locacao.getValor(), 0.01);
			System.out.println(locacao.getDataLocacao());
			Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
			System.out.println(locacao.getDataRetorno());
			Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(2)));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Esperado uma exeção para esse teste, pois está sendo passo um estoque zerado.
	 */
	@Test(expected = Exception.class)
	public void testeLocacaoSemEstoque() throws Exception {
		
		//Cenario
		Filme filme = new Filme("Filme 1", 0, 2.5);
		
		//Acao
		Locacao locacao = servico.alugarFilme(user, filme);
	}
	
}
