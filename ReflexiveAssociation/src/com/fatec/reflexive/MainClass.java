package com.fatec.reflexive;

public class MainClass {

	private static final Logger LOGGER = Logger.getClass(MainClass.class.getName());

	public static void main(String[] args) {
		Empregado aline = new Empregado("Aline");
		Empregado joao = new Empregado("João");
		Empregado antonio = new Empregado("Antônio");
		Empregado jose = new Empregado("José");
		Empregado maria = new Empregado("Maria");
		Empregado rafaela = new Empregado("Rafaela");
		Empregado lucas = new Empregado("Lucas");
		
		aline.addSupervisionado(joao);
		aline.addSupervisionado(antonio);
		aline.addSupervisionado(jose);
		aline.addSupervisionado(maria);
		
		rafaela.setSupervisor(antonio);
		lucas.setSupervisor(antonio);
		
		LOGGER.info("Supervisionados por " + aline.getNome() +": " + aline.getSupervisionados().toString());
		LOGGER.info("Supervisionados por " + antonio.getNome() +": " + antonio.getSupervisionados().toString());

		LOGGER.info("Supervisor de " + rafaela.getNome() +": " + rafaela.getSupervisor().toString());
		LOGGER.info("Supervisor de " + lucas.getNome() +": " + lucas.getSupervisor().toString());
	}
}
