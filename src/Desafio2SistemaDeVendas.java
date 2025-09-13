import java.lang.reflect.Array;
import java.util.Scanner;

public class Desafio2SistemaDeVendas {


    public static void main(String[] args) {
        System.out.println("         Sistema de vendas         ");
        System.out.print("Quantos produtos deseja cadastrar?: ");
        Scanner sc = new Scanner(System.in);
        int numDeProdutos = sc.nextInt(); sc.nextLine(); //next line para limpar o enter

        String nomes[] = new String[numDeProdutos];
        double[] precoDeCusto; //vou atribuir os valores destes arrays dentro dos metodos
        double[] precoDeVenda;
        double[] quantidadeVendida; // ele só vai ter INT, porém tive que deixar double para manter o metodo 'coletarDadosNumericos' reutilizavel! Se nao eu teria que criar mais de um metodo para coletar os dados
        double[] lucros;
        String[] status;

        for (int i = 0; i < numDeProdutos; i++) {
            System.out.print("Digite o nome do produto " + (i+1)+": ");
            nomes[i] = sc.nextLine();
        }

        precoDeCusto = coletarDadosNumericos(nomes, "Preço de Custo", sc);
        precoDeVenda = coletarDadosNumericos(nomes, "Preço de Venda", sc);
        quantidadeVendida = coletarDadosNumericos(nomes, "Quantidade Vendida", sc);

        System.out.println();
        for (int i = 0; i < nomes.length; i++){
            System.out.printf("Produto %s custo: R$%.2f | preço de venda: R$%.2f | quantidades vendidas:  %.0f", nomes[i], precoDeCusto[i], precoDeVenda[i], quantidadeVendida[i] );
            System.out.println();
        }
        System.out.println();

        lucros = calcularLucro(precoDeCusto, precoDeVenda, quantidadeVendida);

        status = desempenhoProduto(lucros);

        apresentarRelatorio(nomes, lucros, status);

        sc.close();



    }


    //metodos

    //3. Metodo para Coleta de Dados Numéricos: Crie um único metodo reutilizável para a entrada de valores monetários e de quantidade. Este metodo será a base para coletar o preço de custo, o preço de venda e a quantidade vendida de cada produto.




    public static double[] coletarDadosNumericos(String[] nomes, String tipo, Scanner sc){
       double[] dadosColetados = new double[nomes.length];
       System.out.println("-----Lançamento de " + tipo+"-----");
       for (int i = 0; i < nomes.length; i++) {
           System.out.print("Digite " + tipo+" para o produto " +nomes[i]+": ");
           dadosColetados[i] = sc.nextDouble(); sc.nextLine();
       }
       return dadosColetados ;
    }

    public static double[] calcularLucro(double[] precoCusto, double[] precoVenda, double[] quantidadeVendida){
        double[] lucroTotal = new double[precoCusto.length];
        for (int i = 0; i < precoCusto.length; i++){
            lucroTotal[i] = (precoVenda[i] - precoCusto[i] ) * quantidadeVendida[i];
        }
        return lucroTotal;
    }

    public static String[] desempenhoProduto(double lucros[]){
        String[] status = new String[lucros.length];

        for (int i = 0; i < lucros.length; i++){
            if (lucros[i] > 0){
                status[i] = "Lucro";
            } else if (lucros[i] == 0) {
                status[i] = "Equilíbrio";
            } else {
                status[i] = "Prejuizo";
            }
        }
        return status;
    }

    public static void apresentarRelatorio(String nomes[], double lucros[], String status[]){
        System.out.println("-----Relatório final de vendas-----");
        System.out.println("---------------------------------");
            for (int i = 0; i < nomes.length; i++){
                System.out.printf("Produto: %-15s | Lucro: R$ %8.2f | Status: %s%n",
                        nomes[i],
                        lucros[i],
                        status[i]);
            }
            System.out.println("---------------------------------");

    }

}
