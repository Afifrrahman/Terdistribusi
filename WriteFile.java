package st_2111082004;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteFile {
    public static void main(String args[]) throws IOException {
        System.out.println("What is the name of the file to be written to?");
        String filename;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        filename = br.readLine();
        System.out.println("Enter data to write to " + filename + "...");
        System.out.println("Type $q to end.");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(filename);
        } catch (FileNotFoundException ex) {
            System.out.println("File cannot be opened for writing.");
            return; 
        }
        try {
            boolean done = false;
            int data;
            do {
                data = br.read();
                if (data == -1) {
                    break;
                } else if ((char) data == '$') {
                    data = br.read();
                    if (data == 'q') {
                        done = true;
                    } else {
                        fos.write('$');
                        fos.write(data);
                    }
                } else {
                    fos.write(data);
                }
            } while (!done);
        } catch (IOException ex) {
            System.out.println("Problem in writing to the file.");
        } finally {
            if (fos != null) {
                fos.close();
            }
        }
    }
}
