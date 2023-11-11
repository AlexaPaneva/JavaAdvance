package javaAdvanced.streamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLine {
    public static void main(String[] args)throws IOException {
        Path path = Paths.get( "JavaAdvanced\\StreamsFilesAndDirectories\\input.txt");

        List<String> lines = Files.readAllLines(path).stream()
                .sorted()
                .collect(Collectors.toList());

        Path outputPath = Paths.get("javaAdvanced/streamsFilesAndDirectories/sort-lines-output.txt");

        Files.write(outputPath, lines);
    }
}
