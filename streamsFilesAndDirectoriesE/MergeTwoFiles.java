package javaAdvanced.streamsFilesAndDirectoriesE;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        //1. четем всички редове от файл 1
        String pathFileOne = "javaAdvanced/streamsFilesAndDirectoriesE/inputOne.txt";
        //2. четем всички редове от файл 2
        String pathFileTwo = "javaAdvanced/streamsFilesAndDirectoriesE/inputTwo.txt";
        //3. записваме всички редове във файл 3
        PrintWriter writer = new PrintWriter("javaAdvanced/streamsFilesAndDirectoriesE/outputMerge.txt");

        List<String> allLinesFileOne = Files.readAllLines(Path.of(pathFileOne)); //всички редове от файл 1
        allLinesFileOne.forEach(line -> writer.println(line));
        List<String> allLinesFileTwo = Files.readAllLines(Path.of(pathFileTwo)); //всички редове от файл 2
        allLinesFileTwo.forEach(line -> writer.println(line));

        writer.close();


    }
}
