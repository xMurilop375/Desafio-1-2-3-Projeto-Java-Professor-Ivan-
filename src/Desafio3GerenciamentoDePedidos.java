import java.util.*;

public class Desafio3GerenciamentoDePedidos {

    public static void main(String[] args) {
        System.out.println("---Sistema de Gerenciamento de Pedidos---");
        System.out.println();
        //sumilar fluxo de pedidos em um restaurante, da chegada a entrega, usando pilha e fila
        //Para enviar informações para um metodo, você deve passar uma estrutura de dados (Pilha ou Fila) como parâmetro.
        //Para receber informações de um metodo, utilize o return do metodo para devolver uma nova estrutura de dados (Pilha ou Fila) com os dados processados. Nenhuma estrutura de dados do main deve ser modificada diretamente por outro metodo.
        //array | arraylist proibido.
        // pilha: stack | fila: queue

        Scanner sc = new Scanner(System.in);
        Queue<String> filaDePedidos = new LinkedList<>();
        Stack<String> pilhaDePratosProntos = new Stack<>();

        filaDePedidos = registrarPedidos(sc);
        pilhaDePratosProntos = prepararPratos(filaDePedidos);
        entregarPratos(pilhaDePratosProntos);
        sc.close();
        System.out.println("\nTodos os pedidos foram processados com sucesso.");

    }


    public static Queue<String> registrarPedidos(Scanner sc){
       Queue<String> filaDePedidos = new LinkedList<>();
        System.out.println("------------Registrar pedidos------------");
        System.out.println("-----------------------------------------");
        System.out.print("Quantos pedidos deseja cadastrar?: ");
        int numDePedidos = sc.nextInt(); sc.nextLine();
            for(int i = 0; i < numDePedidos; i++){
                System.out.print("Digite a descrição do seu pedido "+ (i+1)+ ": ");
                System.out.println();
                filaDePedidos.add(sc.nextLine());
            }
            return filaDePedidos;
    }

        public static Stack<String> prepararPratos(Queue<String> filaDePedidos) {
            Stack<String> pilhaDePratos = new Stack<>();

            while (!filaDePedidos.isEmpty()) {
                String pedido = filaDePedidos.poll();
                System.out.println("Preparando: " + pedido);
                pilhaDePratos.push(pedido);

            }
            System.out.println("--- Pratos prontos aguardando na pilha de entrega! ---");

            return pilhaDePratos;
        }

        public static void entregarPratos(Stack<String> pilhaDePratosProntos){
            while (!pilhaDePratosProntos.isEmpty()) {
                String pedido = pilhaDePratosProntos.pop();
                System.out.println("Entregando o prato: " + pedido);
            }
            System.out.println("Todos os pedidos da pilha foram entregues!");
        }

}
