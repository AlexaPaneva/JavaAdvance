package javaAdvanced.streamsFilesAndDirectoriesE;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String pathFolder = "javaAdvanced/streamsFilesAndDirectoriesE/Exercises Resources";
        File folder = new File(pathFolder);

        File[] allFilesInFolder = folder.listFiles();
        int folderSize = 0; 
        if (allFilesInFolder != null) {
            for (File file : allFilesInFolder) {
                folderSize += file.length();
            }
        }


        System.out.println("Folder size: " + folderSize);
    }
}
