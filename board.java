import java.util.Scanner;

public class BoardTarefas {
    // Array para armazenar as tarefas
    private static String[] tarefas = new String[10];
    private static int quantidadeTarefas = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Board de Tarefas Simples!");
        
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            
            switch(opcao) {
                case 1:
                    adicionarTarefa();
                    break;
                case 2:
                    listarTarefas();
                    break;
                case 3:
                    removerTarefa();
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while(opcao != 4);
        
        scanner.close();
    }
    
    private static void exibirMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Adicionar Tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Remover Tarefa");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private static void adicionarTarefa() {
        if(quantidadeTarefas >= tarefas.length) {
            System.out.println("Limite de tarefas atingido! Não é possível adicionar mais.");
            return;
        }
        
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        
        tarefas[quantidadeTarefas] = descricao;
        quantidadeTarefas++;
        
        System.out.println("Tarefa adicionada com sucesso!");
    }
    
    private static void listarTarefas() {
        if(quantidadeTarefas == 0) {
            System.out.println("Nenhuma tarefa cadastrada ainda.");
            return;
        }
        
        System.out.println("\n=== LISTA DE TAREFAS ===");
        for(int i = 0; i < quantidadeTarefas; i++) {
            System.out.println((i+1) + ". " + tarefas[i]);
        }
    }
    
    private static void removerTarefa() {
        if(quantidadeTarefas == 0) {
            System.out.println("Não há tarefas para remover.");
            return;
        }
        
        listarTarefas();
        System.out.print("Digite o número da tarefa a ser removida: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        
        if(numero < 1 || numero > quantidadeTarefas) {
            System.out.println("Número inválido!");
            return;
        }
        
        // Ajusta a posição das tarefas após a remoção
        for(int i = numero-1; i < quantidadeTarefas-1; i++) {
            tarefas[i] = tarefas[i+1];
        }
        
        quantidadeTarefas--;
        System.out.println("Tarefa removida com sucesso!");
    }
}