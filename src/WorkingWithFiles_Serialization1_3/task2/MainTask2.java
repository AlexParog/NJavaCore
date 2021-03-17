package WorkingWithFiles_Serialization1_3.task2;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MainTask2 {
    public static void main(String[] args) throws IOException {

        GameProgress yesterday = new GameProgress(94, 10, 2, 254.32);
        GameProgress today = new GameProgress(50, 12, 3, 280);
        GameProgress tomorrow = new GameProgress(30, 15, 6, 349.88);

        List<GameProgress> saves = Arrays.asList(yesterday, today, tomorrow);

        // сохранение игры
        saveGame(saves);

        // архивация
        File fileZip = new File("D://Games/savegames/archive.zip");
        fileZip.createNewFile();
        zipSave(fileZip);

        // удаление ненужных сохранений
        File delSavesGame = new File("D://Games/savegames/save.dat");
        if (delSavesGame.delete())
            System.out.println("File deleted!");
    }

    public static void saveGame(List<GameProgress> saves) {
        for (GameProgress save : saves) {
            try (FileOutputStream fos = new FileOutputStream("D://Games/savegames/save.dat");
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                oos.writeObject(save);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void zipSave(File fileZip) {
        try (FileOutputStream fos = new FileOutputStream(fileZip);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            try (FileInputStream fis = new FileInputStream("D://Games/savegames/save.dat")) {
                ZipEntry entry = new ZipEntry("zip_save.dat");
                zos.putNextEntry(entry);
                byte[] bytes = new byte[fis.available()];
                fis.read();
                zos.write(bytes);
                zos.closeEntry();
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
