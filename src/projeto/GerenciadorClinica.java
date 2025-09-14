package projeto;
import java.util.Scanner;

public class GerenciadorClinica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        FilaDeAtendimento fila = new FilaDeAtendimento();
        PilhaHistoricoAtendimentos historico = new PilhaHistoricoAtendimentos();

        // opções
        while (true) {
            exibirMenu();

            System.out.print("Escolha uma opção: ");
            while (!sc.hasNextInt()) { // Enquanto a entrada NÃO for um número inteiro...
                System.out.println("Erro: Entrada inválida. Por favor, digite um número de 1 a 5.");
                System.out.print("Escolha uma opção: ");
                sc.next(); // Limpa a entrada inválida do buffer (o texto que o usuário digitou)
            }
            int opcao = sc.nextInt();sc.nextLine();

            if (opcao == 1) {
                System.out.println("\n--- Adicionar Novo Paciente ---");

                System.out.print("Digite o nome: ");
                String nome = sc.nextLine();

                System.out.print("Digite a idade: ");
                while (!sc.hasNextInt()) { // Enquanto a entrada NÃO for um número inteiro...
                    System.out.println("Idade inválida, digite um número inteiro.");
                    System.out.print("Digite a idade novamente: "); sc.next();
                }
                int idade = sc.nextInt();
                sc.nextLine();

                System.out.print("Digite os sintomas: ");
                String sintoma = sc.nextLine();

                Paciente novoPaciente = new Paciente(nome, idade, sintoma);
                fila.adicionarPaciente(novoPaciente);

                System.out.println("Paciente " + nome + " adicionado à fila com sucesso!");
            }

            else if (opcao == 2) {
            System.out.println("\n--- Atender Próximo Paciente ---");

            if (!fila.estaVazia()) {
                Paciente pacienteAtendido = fila.atenderPaciente();
                historico.adicionarAoHistorico(pacienteAtendido);
                System.out.println("Atendimento realizado para:");
                System.out.println(pacienteAtendido.exibirInfo());
            } else {
                System.out.println("A fila de atendimento está vazia. Não há pacientes para atender.");
            }

        } else if (opcao == 3) {
            fila.mostrarFila();


        } else if (opcao == 4) {
                historico.mostrarHistorico();

            } else if (opcao == 5) {

                System.out.println("\nEncerrando!");
                break; //comando para encerrar

            } else {
                System.out.println("Opção inválida, escolha um número entre 1 e 5.");
            }

            System.out.println("\nPressione Enter para continuar...");
            sc.nextLine();


        }
    }



        private static void exibirMenu() {
            System.out.println();
            System.out.println("      Clínica Médica - Sistema de Gestão");
            System.out.println();
            System.out.println("1. Adicionar novo paciente à fila");
            System.out.println("2. Atender próximo paciente");
            System.out.println("3. Exibir fila de atendimento");
            System.out.println("4. Exibir histórico de atendimentos");
            System.out.println("5. Sair");
            System.out.println("---------------------------------------------------");
        }
}