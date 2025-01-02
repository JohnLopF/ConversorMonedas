package Currency;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HistorialConversiones {

    private List<Conversion> historial;
    private String filename;


    public HistorialConversiones(String filename) {
        this.historial = new ArrayList<>();
        this.filename = filename;
    }

    public void agregarConversion(Conversion conversion) throws IOException {
        historial.add(conversion);
        guardarConversionEnArchivo(conversion);
    }

    private void guardarConversionEnArchivo (Conversion conversion) throws IOException {
        FileWriter writer = new FileWriter(filename, true);
        writer.write(conversion.toString() + "\n");
        writer.close();
    }

    public List<Conversion> getHistorial() {
        return historial;
    }

    public void mostrarHistorial() {
        for (Conversion conversion : historial) {
            System.out.println(conversion); // Suponiendo que la clase Conversion sobreescribe toString()
        }
    }




}
