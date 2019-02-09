package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TestaInsereConta {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("controlefinancas");
		EntityManager manager = factory.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Bruna");
		conta.setBanco("Bradesco");
		conta.setAgencia("0123");
		conta.setNumero("123456-6");
		
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		factory.close();
		
		System.out.println("Conta gravada com sucesso");
		long fim = System.currentTimeMillis();
		System.out.println("Executado em: " + (fim - inicio) + "ms");
	}
	
}
