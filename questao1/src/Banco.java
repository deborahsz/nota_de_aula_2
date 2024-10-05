import java.util.Scanner;

public class Banco {
    private Scanner scanner;

    public Banco() {
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Bem-vindo ao Sistema Bancário!");

        String nomeTitular = solicitarNomeTitular();
        int tipoConta = selecionarTipoConta();
        Conta conta = criarConta(nomeTitular, tipoConta);

        executarOperacoes(conta, tipoConta);

        System.out.println("Obrigado por usar o Sistema Bancário. Até logo!");
    }

    private String solicitarNomeTitular() {
        System.out.print("Digite o nome do titular da conta: ");
        return scanner.nextLine();
    }

    private int selecionarTipoConta() {
        System.out.println("Selecione o tipo de conta:");
        System.out.println("1. Conta Corrente");
        System.out.println("2. Conta Poupança");
        return lerOpcao(1, 2);
    }

    private Conta criarConta(String nomeTitular, int tipoConta) {
        if (tipoConta == 1) {
            return new ContaCorrente(nomeTitular);
        } else {
            return new ContaPoupanca(nomeTitular);
        }
    }

    private void executarOperacoes(Conta conta, int tipoConta) {
        boolean continuar = true;

        while (continuar) {
            exibirMenu(tipoConta);
            System.out.print("Escolha uma opção: ");
            int opcao = lerOpcao(tipoConta == 1 ? 1 : 1, tipoConta == 1 ? 4 : 5);

            if (tipoConta == 1) {
                continuar = tratarOpcoesContaCorrente((ContaCorrente) conta, opcao);
            } else {
                continuar = tratarOpcoesContaPoupanca((ContaPoupanca) conta, opcao);
            }
        }
    }

    private void exibirMenu(int tipoConta) {
        System.out.println("\n--- Menu de Opções ---");
        if (tipoConta == 1) { // Conta Corrente
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Exibir Dados da Conta");
            System.out.println("4. Sair");
        } else { // Conta Poupança
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Calcular Rendimento");
            System.out.println("4. Exibir Dados da Conta");
            System.out.println("5. Sair");
        }
    }

    private boolean tratarOpcoesContaCorrente(ContaCorrente conta, int opcao) {
        switch (opcao) {
            case 1:
                realizarDeposito(conta);
                break;
            case 2:
                realizarSaque(conta);
                break;
            case 3:
                conta.exibirDados();
                break;
            case 4:
                return false; // Sair
            default:
                System.out.println("Opção inválida.");
        }
        return true;
    }

    private boolean tratarOpcoesContaPoupanca(ContaPoupanca conta, int opcao) {
        switch (opcao) {
            case 1:
                realizarDeposito(conta);
                break;
            case 2:
                realizarSaque(conta);
                break;
            case 3:
                calcularRendimento(conta);
                break;
            case 4:
                conta.exibirDados();
                break;
            case 5:
                return false; // Sair
            default:
                System.out.println("Opção inválida.");
        }
        return true;
    }

    private void realizarDeposito(Conta conta) {
        System.out.print("Digite o valor a depositar: R$");
        double valor = lerValor();
        conta.depositar(valor);
    }

    private void realizarSaque(Conta conta) {
        System.out.print("Digite o valor a sacar: R$");
        double valor = lerValor();
        conta.sacar(valor);
    }

    private void calcularRendimento(ContaPoupanca contaPoupanca) {
        System.out.print("Digite a taxa Selic atual (% ao ano): ");
        double selic = lerValor();
        contaPoupanca.calcularRendimento(selic);
    }

    private int lerOpcao(int min, int max) {
        int opcao;
        while (true) {
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (opcao >= min && opcao <= max) {
                    break;
                } else {
                    System.out.print("Opção inválida. Tente novamente: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número: ");
            }
        }
        return opcao;
    }

    private double lerValor() {
        double valor;
        while (true) {
            try {
                valor = Double.parseDouble(scanner.nextLine());
                if (valor >= 0) {
                    break;
                } else {
                    System.out.print("Valor não pode ser negativo. Tente novamente: R$");
                }
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Digite um número válido: R$");
            }
        }
        return valor;
    }
}
