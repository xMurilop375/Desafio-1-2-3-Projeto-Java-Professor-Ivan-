package projeto;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FilaDeAtendimento {

    private Queue<Paciente> fila;


    public FilaDeAtendimento() {
        this.fila = new LinkedList<>();
    }

    public void adicionarPaciente(Paciente p) {
        this.fila.add(p);
    }

    public Paciente atenderPaciente() {
        return this.fila.poll();
    }

    public boolean estaVazia() {
        return this.fila.isEmpty();
    }

    public void mostrarFila() {
        System.out.println("\n--- Fila de Atendimento Atual ---");
        if (estaVazia()){
            System.out.println("A fila de pacientes está vazia!!");
        } else {
            for (Paciente p : this.fila) {
                System.out.println(p.exibirInfo());
            }
        }
        System.out.println();
    }


}
