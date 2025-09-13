import java.util.Scanner;

public class Desafio1Arrays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("    Sistema de Controle de Notas    ");
        System.out.print("Quantos alunos deseja cadastrar? ");
        int numDeAlunos = scanner.nextInt();
        scanner.nextLine();

        String[] nomes = new String[numDeAlunos];
        double[] notasP1; // eu defini o tamanho dos outros arrays nos metodos, pelo nomes.lenght
        double[] notasP2;
        double[] notasTrabalho;
        double[] mediasFinais;
        String[] situacoes;


        for (int i = 0; i < numDeAlunos; i++) {
            System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();
        }

        System.out.println("\n    Lançamento de Notas da Prova 1    ");
        notasP1 = lancarNotas(nomes, "Prova 1", scanner);

        System.out.println("\n--- Lançamento de Notas da Prova 2 ---");
        notasP2 = lancarNotas(nomes, "Prova 2", scanner);

        System.out.println("\n--- Lançamento de Notas dos Trabalhos ---");
        notasTrabalho = lancarNotas(nomes, "Trabalho", scanner);

        mediasFinais = calcularMedias(notasP1, notasP2, notasTrabalho);

        situacoes = verificarSituacoes(mediasFinais);

        apresentarRelatorio(nomes, mediasFinais, situacoes);

        scanner.close();}

    // metodos
    public static double[] lancarNotas(String[] nomes, String tipoAvaliacao, Scanner scanner) {
        double[] notas = new double[nomes.length]; // Cria o novo array que será retornado
        for (int i = 0; i < nomes.length; i++) {
            double nota;
            do {
                System.out.print("Digite a nota do(a) " + nomes[i] + " para [" + tipoAvaliacao + "]: ");
                nota = scanner.nextDouble();
                if (nota < 0 || nota > 10) {
                    System.out.println("Erro: A nota deve ser entre 0 e 10. Tente novamente.");
                }
            } while (nota < 0 || nota > 10); // repete a pergunta while nota for inválida
            notas[i] = nota;}

        scanner.nextLine();
        return notas;}

    public static double[] calcularMedias(double[] notasP1, double[] notasP2, double[] notasTrabalho) {
        double[] medias = new double[notasP1.length];
        for (int i = 0; i < medias.length; i++) {
            // provas = *0.25, trabalho = *0.5
            medias[i] = (notasP1[i] * 0.25) + (notasP2[i] * 0.25) + (notasTrabalho[i] * 0.50);
        }
        return medias;}

    public static String[] verificarSituacoes(double[] mediasFinais) {
        String[] situacoes = new String[mediasFinais.length];
        for (int i = 0; i < situacoes.length; i++) {
            if (mediasFinais[i] >= 7.0) {
                situacoes[i] = "Aprovado";
            } else if (mediasFinais[i] < 4.0) {
                situacoes[i] = "Reprovado";
            } else {
                situacoes[i] = "Exame";
            }}
        return situacoes;}

    public static void apresentarRelatorio(String[] nomes, double[] mediasFinais, String[] situacoes) {
        System.out.println("\n    RELATÓRIO FINAL DA TURMA    ");
        System.out.println("---------------------------------");

        for (int i = 0; i < nomes.length; i++) {

            //pra imprimir a media em 2 casas após o '.', %s para string
            System.out.printf("Aluno: %s | Media: %.2f | Situação: %s%n",
                    nomes[i], mediasFinais[i], situacoes[i]);}}}
