import entities.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("C:\\Users\\werle\\Documents\\ProgrammationTests\\FileFolderManipulator\\itens\\itensSold.txt");

        File directory = new File("out");
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Directory created successfully");
            } else {
                System.out.println("Failed to created Directory");return;
            }
        }

            String patch = "out\\summary.csv";
            try {

                BufferedReader leitor = new BufferedReader(new FileReader(file1));
                BufferedWriter bw = new BufferedWriter(new FileWriter(patch, true));
                String line = leitor.readLine();

                while (line != null) {

                    System.out.println(line);
                    String[] parts = line.split(",");
                    String name = parts[0];
                    Double value = Double.parseDouble(parts[1]);
                    Double quantity = Double.parseDouble(parts[2]);
                    Product pc = new Product(name, value, quantity);

                    String summary = pc.getName() + "," + pc.finalPrice();

                    bw.write(summary);
                    bw.newLine();
                    System.out.println("Successfully");
line = leitor.readLine();
                }
bw.close();

            } catch (IOException e) {
                System.out.println("Error" + e.getMessage());
            }


        }
    }