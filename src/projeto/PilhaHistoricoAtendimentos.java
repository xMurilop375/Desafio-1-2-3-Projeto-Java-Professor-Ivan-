package projeto;

import java.util.Stack;

public class PilhaHistoricoAtendimentos {



    private Stack<Paciente> historico;

    public PilhaHistoricoAtendimentos(){
        this.historico = new Stack<>();
    }

    public void adicionarAoHistorico(Paciente p) {
        historico.push(p);
    }

    public Paciente verUltimoAtendido() {
        if (historico.isEmpty()) {
            System.out.println("Não foram encontrados nenhum paciente no histórico");
            return null;
        } else {
            return this.historico.peek();

        }
    }

    public void mostrarHistorico() {
        System.out.println("\n--- Histórico de Atendimentos ---");

        if (this.historico.isEmpty()) {
            System.out.println("Nenhum paciente foi atendido ainda.");
        } else {
            for (int i = this.historico.size() - 1; i >= 0; i--) //diminuindo até chegar no 0
                {
                Paciente p = this.historico.get(i);
                System.out.println(p.exibirInfo());
            }
        }
        System.out.println("-----------------------------------------------------------------");
    }


}
