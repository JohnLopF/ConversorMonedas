package Currency;

import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        int opcion;
        FileWriter escritura = new FileWriter("Conversiones.txt");

        String monedaInicial;
        String monedaFinal = "";
        double monto = 0;

        HistorialConversiones historial = new HistorialConversiones("Conversiones.txt");

        do {
            System.out.println("Bienvenido al conversor de monedas, por favor elija una opción:");
            System.out.println("1: Realizar una conversión");
            System.out.println("2: Revisar historial de conversiones");
            System.out.println("3: Salir de la aplicación");

            opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1:
                    //Solicitar al usuario una moneda inicial:
                    System.out.println("Ingrese una moneda inicial: ");

                    monedaInicial = input.nextLine();
                    Conversion conversion = new Conversion();
                    conversion.setMonedaInicial(monedaInicial.trim().toUpperCase());

                    //Solicitar al usuario una moneda final
                    System.out.println("Ingrese una moneda final a la que cual desea convertir el monto de la moneda inicial: ");
                    monedaFinal = input.nextLine();
                    conversion.setMonedaFinal(monedaFinal.trim().toUpperCase());

                    System.out.println("Usted desea convertir de " + conversion.getMonedaInicial() + " a " + conversion.getMonedaFinal());

                    //Solicitar al usuario el monto a convertir
                    System.out.println("Ingrese el valor a convertir: ");
                    monto = input.nextInt();
                    conversion.setMonto(monto);

                    System.out.println("\nLa tasa de cambio actual de " + monedaInicial.trim().toUpperCase() + " a " + monedaFinal.trim().toUpperCase() + " es: " + conversion.obtenerTasaCambio());

                    System.out.println("\nEl valor del monto multiplicado por la tasa de cambio es: " + conversion.obtenerResultadoCambio() + " " + monedaFinal.trim().toUpperCase());

                    historial.agregarConversion(conversion);

                    break;
                case 2:
                    System.out.println("Revisar historial de conversiones");
                    historial.mostrarHistorial();
                    break;
                case 3:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("\nOpción inválida.\n");
            }
        } while (opcion != 3);

    }
}