package br.com.alura.cambio.ApiRequest;

import java.util.Scanner;

public class CalculadoraConversao {
    public void CalculadoraParidade(String moeda1, String moeda2, double paridade) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o valor que deseja converter: ");
        Double valor = sc.nextDouble();
        Double conversao = valor * paridade;

        System.out.println("O valor de " + valor + "(" + moeda1 + "), será de: " + String.format("%.2f", conversao) + "(" + moeda2 + ")");
        System.out.println("Pressione Enter para continuar...");
        sc.nextLine();
        sc.nextLine();
    }
}
