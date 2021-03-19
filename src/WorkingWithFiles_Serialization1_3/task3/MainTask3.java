package WorkingWithFiles_Serialization1_3.task3;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class MainTask3 {
    public static void main(String[] args) throws FileNotFoundException {

        String pathToTheFile = "D://Games/savegames/archive.zip";
        String dir = "D://Games/savegames/new_";
        String saves = "D://Games/savegames/new_zip_save.dat";

        // считываем архив
        openZip(pathToTheFile, dir);

        // десериализация
        GameProgress savedGame = openProgress(saves);

        System.out.println(savedGame);
    }

    public static void openZip(String pathToTheFile, String dir) {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(pathToTheFile))) {
            ZipEntry entry;
            String name;
            long size;
            while ((entry = zin.getNextEntry()) != null) {

                name = entry.getName();
                size = entry.getSize();
                FileOutputStream fout = new FileOutputStream(dir + name);
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
    }

    public static GameProgress openProgress(String saves) {
        GameProgress gameProgress = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saves))) {
            gameProgress = (GameProgress) ois.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return gameProgress;
    }
}
