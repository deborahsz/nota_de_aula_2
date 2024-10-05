public class ContaPoupanca extends Conta {


    public ContaPoupanca(String nomeTitular) {
        super(nomeTitular);
    }


    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return;
        }

        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }


    public void calcularRendimento(double selic) {
        double rendimento;
        if (selic > 8.5) {
            rendimento = 0.005 * saldo; // 0,5% ao mês
        } else {
            rendimento = 0.007 * selic * saldo; // 70% da Selic
        }
        saldo += rendimento;
        System.out.printf("Rendimento calculado: R$%.2f%n", rendimento);
    }


    @Override
    public void exibirDados() {
        System.out.println("----- Conta Poupança -----");
        System.out.println("Titular: " + nomeTitular);
        System.out.printf("Saldo: R$%.2f%n", saldo);
    }
}
