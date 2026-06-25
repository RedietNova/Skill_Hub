package file;

import java.io.*;

public class FileManager {

    public void saveText(String fileName,
                         String text) {

        try {

            FileWriter writer =
                    new FileWriter(fileName);

            writer.write(text);

            writer.close();

            System.out.println(
                    "Data saved."
            );

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }

    public void readText(String fileName) {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(fileName));

            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }
    }
}