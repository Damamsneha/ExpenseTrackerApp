package grp3;
import java.io.*;
import java.util.Scanner;
public class FileOperationsDemo {
    public static void main(String[] args) {
        FileOperations fo = new FileOperations();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter file name: ");
            String fileName = scanner.nextLine();

            fo.createFile(fileName);

            System.out.print("Enter content to write: ");
            String content = scanner.nextLine();
            fo.writeFile(fileName, content);

            fo.readFile(fileName);

            System.out.print("Do you want to delete the file? (yes/no): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                fo.deleteFile(fileName);
            }

        } catch (FileOperationException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
