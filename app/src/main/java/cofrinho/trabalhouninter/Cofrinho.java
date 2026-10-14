package cofrinho.trabalhouninter;

import java.util.ArrayList;
import java.util.List;

public class Cofrinho {
    // Agregação: o Cofrinho contém uma lista de objetos do tipo Moeda.
    // Usamos polimorfismo aqui: a lista aceita qualquer classe que herde de Moeda (Real, Dolar, Euro).
    private List<Moeda> listaMoedas;

    // Construtor: inicializa a lista vazia ao criar um Cofrinho
    public Cofrinho() {
        this.listaMoedas = new ArrayList<>();
    }

    // Adiciona qualquer moeda recebida à lista interna
    public void adicionar(Moeda moeda) {
        listaMoedas.add(moeda);
    }

    // Remove a moeda correspondente usando o método equals() que implementamos na classe Moeda
    public boolean remover(Moeda moeda) {
        return listaMoedas.remove(moeda);
    }

    // Percorre a lista e chama o método info() de cada elemento.
    // Graças ao polimorfismo, cada moeda sabe se imprimir no formato correto.
    public void listagemMoedas() {
        if (listaMoedas.isEmpty()) {
            System.out.println("O cofrinho está vazio.");
            return;
        }

        System.out.println("--- Moedas no Cofrinho ---");
        for (Moeda moeda : listaMoedas) {
            moeda.info();
        }
    }

    // Acumula a conversão de todas as moedas para Real e retorna a soma total
    public double totalConvertido() {
        double total = 0.0;
        for (Moeda moeda : listaMoedas) {
            // Cada moeda executa sua própria fórmula de converter()
            total += moeda.converter();
        }
        return total;
    }
}