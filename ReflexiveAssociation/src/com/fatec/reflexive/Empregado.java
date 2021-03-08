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
        supervisionado = new ArrayList<>();
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
        return this.supervisionado.get(index);
    }

    public List<Empregado> getSupervisionados() {
        return Collections.unmodifiableList(supervisionado);
    }

    public boolean hasSupervisionado() {
        return supervisionado.isEmpty();
    }

    public void setSupervisor(Empregado supervisor) {
        Empregado existingSupervisor = supervisor;
        this.supervisor = supervisor;

        existingSupervisor.removeSupervisionado(this);
        supervisor.addSupervisionado(this);
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