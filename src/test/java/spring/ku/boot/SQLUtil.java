package spring.ku.boot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SQLUtil {
    public static void main(String[] args) throws FileNotFoundException {
        String dataSql = Paths.get(".").toAbsolutePath().normalize().toString() + "/src/test/resources/data.sql";

        String str = "";
        try (Stream<String> stream = Files.lines(Paths.get(dataSql))){
            str = stream.map(line -> line.replace("\\", "")).collect(Collectors.joining("\n"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter printWriter = new PrintWriter(dataSql)){
            printWriter.write(str);
        }

    }
}
