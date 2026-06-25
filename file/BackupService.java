package file;

import java.io.*;

public class BackupService {

    public void backupObject(
            Object object,
            String fileName) {

        try {

            ObjectOutputStream output =
                    new ObjectOutputStream(
                            new FileOutputStream(fileName));

            output.writeObject(object);

            output.close();

            System.out.println(
                    "Backup created."
            );

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    public Object restoreObject(
            String fileName) {

        try {

            ObjectInputStream input =
                    new ObjectInputStream(
                            new FileInputStream(fileName));

            Object obj = input.readObject();

            input.close();

            return obj;

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return null;
    }
}