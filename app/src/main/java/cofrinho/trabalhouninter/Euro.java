package cofrinho.trabalhouninter;

public class Euro extends Moeda {
    // Cotação fixa do Euro em relação ao Real
    private static final double COTACAO = 5.50;

    public Euro(double valor) {
        super(valor);
    }

    // Exibe a moeda formatada como Euro
    @Override
    public void info() {
        System.out.printf("Euro: € %.2f%n", valor);
    }

    // Converte o valor em Euro para Real multiplicando pela cotação
    @Override
    public double converter() {
        return valor * COTACAO;
    }
}