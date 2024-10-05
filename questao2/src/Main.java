import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cálculo de Valor Final da Corrida de Uber ===");

        System.out.print("Digite a distância percorrida (km): ");
        double distancia = scanner.nextDouble();

        System.out.print("Digite o tempo de espera (minutos): ");
        int tempoEspera = scanner.nextInt();

        System.out.print("Digite a tarifa base (R$): ");
        double tarifaBase = scanner.nextDouble();

        System.out.print("Digite o fator de demanda (ex: 1.2 para 20% de aumento): ");
        double fatorDemanda = scanner.nextDouble();

        Corrida corrida = new Corrida(distancia, tempoEspera, tarifaBase, fatorDemanda);

        corrida.calcularValorCorrida();
        corrida.exibirDetalhesCorrida();

        scanner.close();
    }
}
