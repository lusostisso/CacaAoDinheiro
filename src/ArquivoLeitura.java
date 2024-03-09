import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ArquivoLeitura {
    private BufferedReader reader;
    public void open(String nome){
        Path path1 = Paths.get(nome);
        try {
            reader = Files.newBufferedReader(path1, Charset.defaultCharset());
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }
    }
    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }
    }

    public int[] tam() {
        try {
            String line;
            if ((line = reader.readLine()) != null) {
                return Arrays.stream(line.trim().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro na leitura: " + e.getMessage());
        }
        return null;
    }

    public String lerLinha () {
        try {
            String line;
            if ((line = reader.readLine()) != null) {
                return line;
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro na leitura ler: " + e.getMessage());
        }
        return "";
    }


}
