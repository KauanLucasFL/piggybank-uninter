package cofrinho.trabalhouninter;

public class Dolar extends Moeda {
    // Definimos uma taxa de cotação fixa como constante (pode ajustar o valor conforme o exercício pedir)
    private static final double COTACAO = 5.00;

    public Dolar(double valor) {
        super(valor);
    }

    // Exibe a moeda formatada como Dólar
    @Override
    public void info() {
        System.out.printf("Dólar: $ %.2f%n", valor);
    }

    // Converte o valor em Dólar para Real multiplicando pela cotação
    @Override
    public double converter() {
        return valor * COTACAO;
    }
}