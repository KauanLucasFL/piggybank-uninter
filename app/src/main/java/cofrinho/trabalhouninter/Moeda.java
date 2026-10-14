package cofrinho.trabalhouninter;

import java.util.Objects;

// "abstract" indica que esta classe serve apenas como modelo base.
// Não da pra instanciar diretamente "new Moeda()", apenas suas subclasses (Real, Dolar, Euro).
public abstract class Moeda {
    
    // "protected" permite que as classes filhas (Dolar, Euro, Real) acessem esse atributo diretamente.
    protected double valor;

    // Construtor: inicializa o valor da moeda ao ser criada.
    public Moeda(double valor) {
        this.valor = valor;
    }

    // Método abstrato: não tem corpo {} aqui.
    // Obriga toda subclasse a criar sua própria forma de imprimir seus dados.
    public abstract void info();

    // Método abstrato: obriga toda subclasse a implementar sua regra de conversão para Real.
    public abstract double converter();

    // Sobrescrita do método equals():
    // Por padrão no Java, o método remove() de uma lista compara se os dois objetos estão no mesmo endereço de memória.
    // Sobrescrevendo equals, dizemos ao Java que duas moedas são iguais se tiverem a mesma classe (tipo) e o mesmo valor.
    @Override
    public boolean equals(Object o) {
        // Se ambos apontarem para o mesmo endereço de memória, são iguais
        if (this == o) return true;
        // cOpara objeto for nulo ou de uma classe diferente (ex: Real comparado com Dolar), não são iguais
        if (o == null || getClass() != o.getClass()) return false;
        
        // Faz a conversão (cast) e compara o valor
        Moeda moeda = (Moeda) o;
        return Double.compare(moeda.valor, valor) == 0;
    }

    // Sempre que sobrescrever equals, deve sobrescrever hashCode para manter a consistência de coleções no Java.
    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}