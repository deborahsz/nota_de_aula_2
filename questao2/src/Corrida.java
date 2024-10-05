public class Corrida {
    private double distancia;
    private int tempoEspera;
    private double tarifaBase;
    private double fatorDemanda;
    private double valorFinal;

    public Corrida(double distancia, int tempoEspera, double tarifaBase, double fatorDemanda) {
        this.distancia = distancia;
        this.tempoEspera = tempoEspera;
        this.tarifaBase = tarifaBase;
        this.fatorDemanda = fatorDemanda;
    }

    public void calcularValorCorrida() {
        this.valorFinal = (this.distancia * 2) + (this.tempoEspera * 0.5) + (this.tarifaBase * this.fatorDemanda);
    }

    public void exibirDetalhesCorrida() {
        System.out.println("===== Detalhes da Corrida =====");
        System.out.println("Distância Percorrida: " + this.distancia + " km");
        System.out.println("Tempo de Espera: " + this.tempoEspera + " minutos");
        System.out.println("Tarifa Base: R$ " + String.format("%.2f", this.tarifaBase));
        System.out.println("Fator de Demanda: " + this.fatorDemanda);
        System.out.println("Valor Final da Corrida: R$ " + String.format("%.2f", this.valorFinal));
        System.out.println("================================");
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    public double getFatorDemanda() {
        return fatorDemanda;
    }

    public void setFatorDemanda(double fatorDemanda) {
        this.fatorDemanda = fatorDemanda;
    }
}
