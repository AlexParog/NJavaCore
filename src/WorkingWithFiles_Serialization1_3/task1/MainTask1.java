package WorkingWithFiles_Serialization1_3.task1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class MainTask1 {
    public static void main(String[] args) {

        StringBuilder sBuilder = new StringBuilder("");

        // директории
        File dirGames = new File("D://Games");
        File dirSrc = new File("D://Games/src");
        File dirRes = new File("D://Games/res");
        File dirSaveGames = new File("D://Games/savegames");
        File dirTemp = new File("D://Games/temp");
        File dirMain = new File("D://Games/src/main");
        File dirTest = new File("D://Games/src/test");
        File dirDrawables = new File("D://Games/res/drawables");
        File dirVectors = new File("D://Games/res/vectors");
        File dirIcons = new File("D://Games/res/icons");

        // файлы
        File fileMain = new File("D://Games/src/main/Main.java");
        File fileUtils = new File("D://Games/src/main/Utils.java");
        File fileTemp = new File("D://Games/temp/temp.txt");

        // хранилище директорий
        List<File> dirList = Arrays.asList(
                dirGames, dirSrc, dirRes, dirSaveGames,
                dirTemp, dirMain, dirTest, dirDrawables,
                dirVectors, dirIcons);

        // хранилище файлов
        List<File> fileList = Arrays.asList(fileMain, fileUtils, fileTemp);

        // для директорий
        addDir(dirList, sBuilder);

        // для файлов
        addFile(fileList, sBuilder);

        // перепись в файл temp.txt
        try (FileOutputStream fos = new FileOutputStream("D://Games/temp/temp.txt")) {
            byte[] bytes = sBuilder.toString().getBytes();
            fos.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void addDir(List<File> dirList, StringBuilder sBuilder) {
        for (File elem : dirList) {
            if (elem.mkdir()) {
                sBuilder = sBuilder.append(elem.getName() + " каталог создан \n");
                System.out.println(elem.getName() + " каталог был создан");
            }
        }
    }

    public static void addFile(List<File> fileList, StringBuilder sBuilder) {
        for (File file : fileList) {
            try {
                if (file.createNewFile()) {
                    sBuilder = sBuilder.append(file.getName() + " файл был создан \n");
                    System.out.println(file.getName() + " файл был создан");
                }
            } catch (IOException ex) {
                sBuilder = sBuilder.append(file.getName() +" файл не был создан \n");
                System.out.println(file.getName() + " файл не был создан");
            }
        }
    }
}
