package grp3;
import java.io.*;
import java.util.Scanner;
public class FileOperations{
public void createFile(String fileName) throws FileOperationException {
    try {
        File file = new File(fileName);
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        } else {
            throw new FileOperationException("File already exists.");
        }
    } catch (IOException e) {
        throw new FileOperationException("Error creating file: " + e.getMessage());
    }
}

// Method to write to a file
public void writeFile(String fileName, String content) throws FileOperationException {
    try (FileWriter writer = new FileWriter(fileName)) {
        writer.write(content);
        System.out.println("Content written to file.");
    } catch (IOException e) {
        throw new FileOperationException("Error writing to file: " + e.getMessage());
    }
}

// Method to read a file
public void readFile(String fileName) throws FileOperationException {
    try (Scanner reader = new Scanner(new File(fileName))) {
        System.out.println("File content:");
        while (reader.hasNextLine()) {
            System.out.println(reader.nextLine());
        }
    } catch (FileNotFoundException e) {
        throw new FileOperationException("File not found: " + fileName);
    }
}

// Method to delete a file
public void deleteFile(String fileName) throws FileOperationException {
    File file = new File(fileName);
    if (file.exists() && file.delete()) {
        System.out.println("File deleted: " + fileName);
    } else {
        throw new FileOperationException("File could not be deleted or does not exist.");
    }
}
}
