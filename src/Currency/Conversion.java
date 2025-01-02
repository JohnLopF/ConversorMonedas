package Currency;

import java.io.IOException;
import java.text.DecimalFormat;

public class Conversion {
    private String monedaInicial;
    private String monedaFinal;
    private double monto;
    private double tasaDeCambio;
    private double resultado;

    DecimalFormat df = new DecimalFormat("#.########");

    public Conversion() {
    }

    public String obtenerTasaCambio() throws IOException, InterruptedException {

        APIRequest apiRequest = new APIRequest();

        tasaDeCambio = apiRequest.getExchangeRate(monedaInicial, monedaFinal);

        return  df.format(tasaDeCambio);
    }


    public double obtenerResultadoCambio() throws IOException, InterruptedException {
        APIRequest apiRequest = new APIRequest();

        tasaDeCambio = apiRequest.getExchangeRate(monedaInicial, monedaFinal);

            resultado = monto * tasaDeCambio;

        return resultado;
    }

    public Conversion(String monedaInicial, String monedaFinal, double monto, double tasaDeCambio, double resultado) {
        this.monedaInicial = monedaInicial;
        this.monedaFinal = monedaFinal;
        this.monto = monto;
        this.tasaDeCambio = tasaDeCambio;
        this.resultado = resultado;
    }

    public String getMonedaInicial() {
        return monedaInicial;
    }

    public void setMonedaInicial(String monedaInicial) {
        this.monedaInicial = monedaInicial;
    }

    public String getMonedaFinal() {
        return monedaFinal;
    }

    public void setMonedaFinal(String monedaFinal) {
        this.monedaFinal = monedaFinal;
    }

    public double getTasaDeCambio() {
        return tasaDeCambio;
    }

    public void setTasaDeCambio(double tasaDeCambio) {
        this.tasaDeCambio = tasaDeCambio;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Conversion{" +
                "monedaInicial='" + monedaInicial + '\'' +
                ", monedaFinal='" + monedaFinal + '\'' +
                ", monto=" + monto +
                ", tasaDeCambio=" + df.format(tasaDeCambio) +
                ", resultado=" + resultado +
                '}';
    }
}