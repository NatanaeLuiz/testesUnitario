package br.com.natanael.servicos;

import static br.com.natanael.utils.DataUtils.adicionarDias;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.com.natanael.entidades.Filme;
import br.com.natanael.entidades.Locacao;
import br.com.natanael.entidades.Usuario;
import br.com.natanael.utils.DataUtils;


public class LocacaoService {
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) throws Exception {
		Locacao locacao = new Locacao();
		
		
		if (filme.getEstoque() == 0) {
			throw new Exception("Sem estoque para o filme atual");
		}
		
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValor(filme.getPrecoLocacao());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 2);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar método para salvar
		
		return locacao;
	}

	
}