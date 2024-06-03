package br.com.alura.cambio.gerenciador;

import br.com.alura.cambio.ApiRequest.CalculadoraConversao;
import br.com.alura.cambio.ApiRequest.SolicitadorTaxaCambio;

import java.io.IOException;
import java.net.ConnectException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Double paridade = 0.0;

        SolicitadorTaxaCambio solicitadorTaxaCambio = new SolicitadorTaxaCambio();
        CalculadoraConversao calculadoraConversao = new CalculadoraConversao();

        Scanner scanner = new Scanner(System.in);

        boolean sair = false;
        do {
            MenuOpcoes.mostrarMenu();
            try {
                var opcao = scanner.nextLine();
                switch (opcao) {
                    case "1":
                        paridade = solicitadorTaxaCambio.receberValor("USD", "EUR");
                        calculadoraConversao.CalculadoraParidade("USD", "EUR", paridade);
                        break;
                    case "2":
                        paridade = solicitadorTaxaCambio.receberValor("EUR", "ARS");
                        calculadoraConversao.CalculadoraParidade("EUR", "ARS", paridade);
                        break;
                    case "3":
                        paridade = solicitadorTaxaCambio.receberValor("BRL", "USD");
                        calculadoraConversao.CalculadoraParidade("BRL", "USD", paridade);
                        break;
                    case "4":
                        paridade = solicitadorTaxaCambio.receberValor("EUR", "BRL");
                        calculadoraConversao.CalculadoraParidade("EUR", "BRL", paridade);
                        break;
                    case "5":
                        paridade = solicitadorTaxaCambio.receberValor("BRL", "CUP");
                        calculadoraConversao.CalculadoraParidade("BRL", "CUP", paridade);
                        break;
                    case "6":
                        paridade = solicitadorTaxaCambio.receberValor("USD", "RUB");
                        calculadoraConversao.CalculadoraParidade("USD", "RUB", paridade);
                        break;
                    case "0":
                        System.out.println("Saindo do programa....");
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida! Por favor, selecione uma opção válida.");
                        System.out.println("Pressione Enter para continuar...");
                        scanner.nextLine();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, insira um valor numérico válido(Se estiver usando \"ponto\" como casa decima troque pela vírgula!).");
                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();
            } catch (ConnectException e) {
                System.out.println("Erro de conexão, conecte a internet");
                System.out.println("Pressione Enter para continuar...");
                scanner.nextLine();
            }
        } while (!sair);
    }
}
