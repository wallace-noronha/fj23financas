package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaListagemConta {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		ContaDao dao = new ContaDao(manager);

		List<Conta> lista = dao.lista();

		for (Conta conta : lista) {
			System.out.println("Encontrado a conta: " + conta.getNumero());
		}
		manager.close();
	}
}
