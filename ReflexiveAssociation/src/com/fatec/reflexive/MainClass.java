package com.fatec.reflexive;

public class MainClass {
	
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
		
		System.out.println("Supervisionados por " + aline.getNome() +": " + aline.getSupervisionados().toString());
		System.out.println("Supervisionados por " + antonio.getNome() +": " + antonio.getSupervisionados().toString());
		
		System.out.println("Supervisor de " + rafaela.getNome() +": " + rafaela.getSupervisor().toString());
		System.out.println("Supervisor de " + lucas.getNome() +": " + lucas.getSupervisor().toString());
	}
}
