/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package st_2111082004;

/**
 *
 * @author ASUS
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class ReadFile {
    public static void main(String args[]) throws IOException {
        System.out.println("What is the name of the file to read from?");
        String filename;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        filename = br.readLine();
        System.out.println("Now reading from " + filename + "...");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filename);
        } catch (FileNotFoundException ex){
            System.out.println("File not found.");
        }
        try {
            char Data;
            int temp;
            do {
                temp = fis.read();
                Data = (char) temp;
            if (temp != -1){
                System.out.print(Data);
            }
            } while (temp != -1);
        } catch (IOException ex){
         System.out.println("Problem in reading from the file.");
        }
    }
}
