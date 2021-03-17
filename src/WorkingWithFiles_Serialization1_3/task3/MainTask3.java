package WorkingWithFiles_Serialization1_3.task3;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class MainTask3 {
    public static void main(String[] args) throws FileNotFoundException {

        GameProgress gameProgress = null;
        String pathToTheFile = "D://Games/savegames/archive.zip";
        String dir = "D://Games/savegames/save.dat";

        // считываем архив
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(pathToTheFile))) {
            ZipEntry entry;
            String name;
            long size;
            while ((entry = zin.getNextEntry()) != null) {

                name = entry.getName();
                size = entry.getSize();
                FileOutputStream fout = new FileOutputStream("D://Games/savegames/new_" + name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // десериализация
        try (FileInputStream fis = new FileInputStream("D://Games/savegames/new_zip_save.dat");
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            gameProgress = (GameProgress) ois.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(gameProgress);
    }
}
