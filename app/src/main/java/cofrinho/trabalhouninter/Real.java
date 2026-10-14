package cofrinho.trabalhouninter;

// "extends Moeda" indica herança: Real herda atributos e comportamentos de Moeda.
public class Real extends Moeda {

    // O construtor recebe o valor e passa para o construtor da classe mãe através de "super(valor)".
    public Real(double valor) {
        super(valor);
    }

    // Implementação obrigatória do método info() para Real.
    @Override
    public void info() {
        System.out.printf("Real: R$ %.2f%n", valor);
    }

    // Como a moeda já é Real, o valor convertido para Real é o próprio valor da moeda.
    @Override
    public double converter() {
        return valor;
    }
}