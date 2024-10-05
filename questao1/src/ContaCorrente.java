public class ContaCorrente extends Conta {
    private final double limiteChequeEspecial = 1000.0;


    public ContaCorrente(String nomeTitular) {
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
        } else if ((saldo + limiteChequeEspecial) >= valor) {
            double diferenca = valor - saldo;
            saldo = 0.0;
            System.out.printf("Saque realizado utilizando o cheque especial de R$%.2f%n", diferenca);
        } else {
            System.out.println("Saldo insuficiente, incluindo o cheque especial.");
        }
    }


    @Override
    public void exibirDados() {
        System.out.println("----- Conta Corrente -----");
        System.out.println("Titular: " + nomeTitular);
        System.out.printf("Saldo: R$%.2f%n", saldo);
        System.out.printf("Cheque Especial Disponível: R$%.2f%n", limiteChequeEspecial);
    }
}
