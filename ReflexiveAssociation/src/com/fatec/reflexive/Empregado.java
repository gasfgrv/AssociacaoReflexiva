package com.fatec.reflexive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Empregado {
	private String nome;
	private Empregado supervisor;
	private List<Empregado> supervisionado;

	public Empregado(String aNome) {
		nome = aNome;
		supervisionado = new ArrayList<Empregado>();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Empregado getSupervisor() {
		return supervisor;
	}

	public boolean hasSupervisor() {
		return supervisor != null;
	}

	public Empregado getSupervisionado(int index) {
		Empregado supervisionado = this.supervisionado.get(index);
		return supervisionado;
	}

	public List<Empregado> getSupervisionados() {
		List<Empregado> supervisionados = Collections.unmodifiableList(supervisionado);
		return supervisionados;
	}


	public boolean hasSupervisionado() {
		return supervisionado.size() > 0;
	}

	public void setSupervisor(Empregado supervisor) {
		Empregado existingSupervisor = supervisor;
		this.supervisor = supervisor;
		if (existingSupervisor != null && !existingSupervisor.equals(supervisor)) {
			existingSupervisor.removeSupervisionado(this);
		}
		if (supervisor != null) {
			supervisor.addSupervisionado(this);
		}
	}


	public boolean addSupervisionado(Empregado supervisionado) {
		boolean adicionado = false;
		if (this.supervisionado.contains(supervisionado)) {
			return false;
		}
		Empregado existingSupervisor = supervisionado.getSupervisor();
		if (existingSupervisor == null) {
			supervisionado.setSupervisor(this);
		} else if (!this.equals(existingSupervisor)) {
			existingSupervisor.removeSupervisionado(supervisionado);
			addSupervisionado(supervisionado);
		} else {
			this.supervisionado.add(supervisionado);	
		}
		adicionado = true;
		return adicionado;
	}

	public boolean removeSupervisionado(Empregado aSupervisionado) {
		boolean wasRemoved = false;
		if (supervisionado.contains(aSupervisionado)) {
			supervisionado.remove(aSupervisionado);
			aSupervisionado.setSupervisor(null);
			wasRemoved = true;
		}
		return wasRemoved;
	}

	public void delete() {
		if (supervisor != null) {
			Empregado placeholderSupervisor = supervisor;
			this.supervisor = null;
			placeholderSupervisor.removeSupervisionado(this);
		}
		while (!supervisionado.isEmpty()) {
			supervisionado.get(0).setSupervisor(null);
		}
	}

	public String toString() {
		return "[" + "nome" + ":" + getNome() + "]";
	}
}