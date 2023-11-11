package javaAdvanced.streamsFilesAndDirectoriesE;

import java.io.*;

public class AllCapitals {
    public static void main(String[] args) throws IOException {

PrintWriter printWriter = new PrintWriter(new FileWriter("javaAdvanced/streamsFilesAndDirectoriesE/output.txt"));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(
                "javaAdvanced/streamsFilesAndDirectoriesE/input.txt"));
        bufferedReader.lines().forEach(line -> printWriter.println(line.toUpperCase()));
        bufferedReader.close();
        printWriter.close();
    }
}
