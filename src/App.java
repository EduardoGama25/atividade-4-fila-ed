import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenuPrincipal();
            opcao = lerInteiro(scanner, "Escolha uma opcao: ");

            switch (opcao) {
                case 1:
                    executarExercicio01();
                    break;
                case 2:
                    executarExercicio02();
                    break;
                case 3:
                    executarExercicio03(scanner);
                    break;
                case 4:
                    executarExercicio04(scanner);
                    break;
                case 5:
                    executarExercicio05(scanner);
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }

            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("=== Exercicios com Fila ===");
        System.out.println("1 - Fila com valores fixos");
        System.out.println("2 - Fila de nomes");
        System.out.println("3 - Remover 10 numeros da fila");
        System.out.println("4 - Fila de atendimento");
        System.out.println("5 - Fila de impressao");
        System.out.println("0 - Sair");
    }

    private static int lerInteiro(Scanner scanner, String mensagem) {
        while (true) {
            System.out.print(mensagem);

            if (scanner.hasNextInt()) {
                int valor = scanner.nextInt();
                scanner.nextLine();
                return valor;
            }

            System.out.println("Entrada invalida. Digite um numero inteiro.");
            scanner.nextLine();
        }
    }

   
    // EXERCICIO 01

    public static Queue<Integer> criarFilaValoresFixos() {
        Queue<Integer> fila = new LinkedList<>();
        fila.add(10);
        fila.add(20);
        fila.add(30);
        fila.add(40);
        fila.add(50);
        
        return fila;
    }


    private static void executarExercicio01() {
        System.out.println("\n--- Exercicio 01 ---");
        Queue<Integer> fila = criarFilaValoresFixos();


        System.out.println("Fila completa: " + fila);
        fila.poll();
        System.out.println("Fila apos remover o primeiro elemento: " + fila);
        
    }



    // EXERCICIO 02

    public static Queue<String> criarFilaNomes() {
        Queue<String> fila = new LinkedList<>();
        fila.add("Ana");
        fila.add("Carlos");
        fila.add("Pedro");
        fila.add("Juliana");
        
        return fila;
    }


    private static void executarExercicio02() {
        System.out.println("\n--- Exercicio 02 ---");
        Queue<String> fila = criarFilaNomes();

        System.out.println("Primeiro elemento da fila: " + fila.peek());
        System.out.println("Quantidade de elementos armazenados: " + fila.size());
    }



    // EXERCICIO 03

    public static List<Integer> removerTodosElementos(Queue<Integer> fila) {
        List<Integer> listaRemovidos = new ArrayList<>();
        while (!fila.isEmpty()) {
            listaRemovidos.add(fila.poll());
        }
        return listaRemovidos;
    }


    private static void executarExercicio03(Scanner scanner) {
        System.out.println("\n--- Exercicio 03 ---");
        Queue<Integer> fila = new LinkedList<>();
        System.out.println("Digite 10 numeros inteiros para inserir na fila:");
        for (int i = 1; i <= 10; i++) {
            int num = lerInteiro(scanner, "Numero " + i + ": ");
            fila.add(num);
        }

        System.out.println("Removendo elementos da fila:");
        List<Integer> removidos = removerTodosElementos(fila);
        for (Integer num : removidos) {
            System.out.println("Elemento removido: " + num);
        }
    }



    // EXERCICIO 04

    public static List<String> atenderClientes(Queue<String> fila) {
        List<String> clientesAtendidos = new ArrayList<>();
        while (!fila.isEmpty()) {
            clientesAtendidos.add(fila.poll());
        }
        return clientesAtendidos;
    }

    private static void executarExercicio04(Scanner scanner) {
        System.out.println("\n--- Exercicio 04 (Fila de Atendimento) ---");
        Queue<String> filaAtendimento = new LinkedList<>();
        int subOpcao;

        do {
            System.out.println("\n1 - Cadastrar cliente");
            System.out.println("2 - Atender todos os clientes da fila");
            System.out.println("3 - Mostrar proximo cliente");
            System.out.println("4 - Exibir fila completa");
            System.out.println("0 - Voltar ao menu principal");
            subOpcao = lerInteiro(scanner, "Escolha uma opcao: ");

            switch (subOpcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    filaAtendimento.add(nome);
                    System.out.println("Cliente " + nome + " adicionado a fila.");
                    break;
                case 2:
                    if (filaAtendimento.isEmpty()) {
                        System.out.println("Nao ha clientes na fila para atender.");
                    } else {
                        System.out.println("Atendendo clientes...");
                        List<String> atendidos = atenderClientes(filaAtendimento);
                        for (String cliente : atendidos) {
                            System.out.println("Cliente atendido: " + cliente);
                        }
                    }
                    break;
                case 3:
                    if (!filaAtendimento.isEmpty()) {
                        System.out.println("Proximo cliente a ser atendido: " + filaAtendimento.peek());
                    } else {
                        System.out.println("A fila de atendimento esta vazia.");
                    }
                    break;
                case 4:
                    System.out.println("Fila de atendimento completa: " + filaAtendimento);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
        } while (subOpcao != 0);
    }



    // EXERCICIO 05

    public static void adicionarDocumento(Queue<String> fila, String documento) {
        fila.add(documento);
        System.out.println("Documento \"" + documento + "\" adicionado a fila de impressao.");
    }

    public static String imprimirDocumento(Queue<String> fila) {
        if (!fila.isEmpty()) {
            return fila.poll();
        }
        System.out.println("Nao ha documentos na fila para imprimir.");
        return null;
    }

    public static String proximoDocumento(Queue<String> fila) {
        if (!fila.isEmpty()) {
            return fila.peek();
        }
        System.out.println("Fila de impressao vazia.");
        return null;
    }

    private static void executarExercicio05(Scanner scanner) {
        System.out.println("\n--- Exercicio 05 (Fila de Impressao) ---");
        Queue<String> filaImpressao = new LinkedList<>();
        int subOpcao;

        do {
            System.out.println("\n1 - Adicionar documento");
            System.out.println("2 - Imprimir primeiro documento");
            System.out.println("3 - Mostrar proximo documento");
            System.out.println("4 - Exibir documentos pendentes");
            System.out.println("0 - Voltar ao menu principal");
            subOpcao = lerInteiro(scanner, "Escolha uma opcao: ");

            switch (subOpcao) {
                case 1:
                    System.out.print("Digite o nome/titulo do documento: ");
                    String doc = scanner.nextLine();
                    adicionarDocumento(filaImpressao, doc);
                    break;
                case 2:
                    String impresso = imprimirDocumento(filaImpressao);
                    if (impresso != null) {
                        System.out.println("Imprimindo documento: " + impresso);
                    }
                    break;
                case 3:
                    String proximo = proximoDocumento(filaImpressao);
                    if (proximo != null) {
                        System.out.println("Proximo documento na fila: " + proximo);
                    }
                    break;
                case 4:
                    System.out.println("Documentos pendentes na fila: " + filaImpressao);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida.");
                    break;
            }
        } while (subOpcao != 0);
    }
}