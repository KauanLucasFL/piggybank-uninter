package cofrinho.trabalhouninter;

import java.util.Scanner;

public class App {

    public String getGreeting() {
        return "Bem-vindo ao Cofrinho!";
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Cofrinho cofrinho = new Cofrinho();
        int opcao = 0;

        // Loop que mantém o menu ativo até a opção 5 (Encerrar)
        while (opcao != 5) {
            System.out.println("\n===== COFRINHO =====");
            System.out.println("1 - Adicionar moeda");
            System.out.println("2 - Remover moeda");
            System.out.println("3 - Listar moedas");
            System.out.println("4 - Calcular total convertido para Real");
            System.out.println("5 - Encerrar");
            System.out.print("Escolha uma opção: ");

            // Previne erros caso digitem letras no menu principal
            if (!teclado.hasNextInt()) {
                System.out.println("Opção inválida! Digite um número.");
                teclado.next();
                continue;
            }
            opcao = teclado.nextInt();

            switch (opcao) {
                // Requisito 1: Adicionar moedas
                case 1:
                    System.out.println("\nEscolha a moeda:");
                    System.out.println("1 - Real | 2 - Dólar | 3 - Euro");
                    System.out.print("Tipo: ");
                    if (!teclado.hasNextInt()) {
                        System.out.println("Tipo de moeda inválido!");
                        teclado.next();
                        break;
                    }
                    int tipoAdicionar = teclado.nextInt();

                    System.out.print("Digite o valor: ");
                    if (!teclado.hasNextDouble()) {
                        System.out.println("Valor inválido!");
                        teclado.next();
                        break;
                    }
                    double valorAdicionar = teclado.nextDouble();

                    Moeda moedaAdd = null;
                    if (tipoAdicionar == 1) {
                        moedaAdd = new Real(valorAdicionar);
                    } else if (tipoAdicionar == 2) {
                        moedaAdd = new Dolar(valorAdicionar);
                    } else if (tipoAdicionar == 3) {
                        moedaAdd = new Euro(valorAdicionar);
                    } else {
                        System.out.println("Tipo de moeda inválido!");
                        break;
                    }

                    cofrinho.adicionar(moedaAdd);
                    System.out.println("Moeda adicionada com sucesso!");
                    break;

                // Requisito 2: Remover moedas
                case 2:
                    System.out.println("\nEscolha a moeda que deseja remover:");
                    System.out.println("1 - Real | 2 - Dólar | 3 - Euro");
                    System.out.print("Tipo: ");
                    if (!teclado.hasNextInt()) {
                        System.out.println("Tipo de moeda inválido!");
                        teclado.next();
                        break;
                    }
                    int tipoRemover = teclado.nextInt();

                    System.out.print("Digite o valor: ");
                    if (!teclado.hasNextDouble()) {
                        System.out.println("Valor inválido!");
                        teclado.next();
                        break;
                    }
                    double valorRemover = teclado.nextDouble();

                    Moeda moedaRemover = null;
                    if (tipoRemover == 1) {
                        moedaRemover = new Real(valorRemover);
                    } else if (tipoRemover == 2) {
                        moedaRemover = new Dolar(valorRemover);
                    } else if (tipoRemover == 3) {
                        moedaRemover = new Euro(valorRemover);
                    } else {
                        System.out.println("Tipo de moeda inválido!");
                        break;
                    }

                    if (cofrinho.remover(moedaRemover)) {
                        System.out.println("Moeda removida com sucesso!");
                    } else {
                        System.out.println("Moeda não encontrada no cofrinho!");
                    }
                    break;

                // Requisito 3: Listar todas as moedas
                case 3:
                    cofrinho.listagemMoedas();
                    break;

                // Requisito 4: Calcular total convertido para Real
                case 4:
                    System.out.printf("%nTotal no cofrinho convertido em Real: R$ %.2f%n", cofrinho.totalConvertido());
                    break;

                case 5:
                    System.out.println("Encerrando o programa... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha entre 1 e 5.");
            }
        }

        teclado.close();
    }
}
