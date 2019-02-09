package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereMovimentacaoComConta {
	
	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setAgencia("0349");
		conta.setBanco("Santander");
		conta.setNumero("03493450-4");
		conta.setTitular("Mariazinha");
		
		Movimentacao movimentacao = new Movimentacao();
		manager.persist(conta);
		movimentacao.setConta(conta);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Conta de agua - Fevereiro/2019");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal(100.0));
		
		MovimentacaoDao dao = new MovimentacaoDao(manager);
		dao.salva(movimentacao);
		
		
		manager.getTransaction().commit();
		manager.close();
	}
	
}
