package br.com.natanael.servicos;


import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.com.natanael.entidades.Filme;
import br.com.natanael.entidades.Locacao;
import br.com.natanael.entidades.Usuario;
import br.com.natanael.servicos.LocacaoService;
import br.com.natanael.utils.DataUtils;

public class LocacaoServiceTest {

	@Test
	public void teste() {
		//Cenario
		LocacaoService servico = new LocacaoService();
		Usuario user = new Usuario("Natanael");
		Filme filme = new Filme("Filme 1", 10, 2.5);
		
		//Acao
		Locacao locacao = servico.alugarFilme(user, filme);
		
		//Verificação
		System.out.println(locacao.getValor());
		Assert.assertEquals(2.5, locacao.getValor(), 0.01);
		System.out.println(locacao.getDataLocacao());
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		System.out.println(locacao.getDataRetorno());
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(2)));
	}
}
