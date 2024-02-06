import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void saveGame(String path, GameProgress gameProgress) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(gameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void zipFiles(String path, List<String> liststr) {
        try {
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path, true)); ;
            FileInputStream fis ;
            File myFile;
           for(String item :liststr) {
                myFile = new File(item);
                fis = new FileInputStream(item);
                zout.putNextEntry(new ZipEntry(myFile.getName()));
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                fis.close();
                 myFile.delete();
            }
            zout.closeEntry();
            zout.close();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void main(String[] args) {
        GameProgress gameProgress1 = new GameProgress(94, 10, 2, 254.32);
        GameProgress gameProgress2 = new GameProgress(70, 1, 2, 200.32);
        GameProgress gameProgress3 = new GameProgress(55, 10, 9, 11254.32);
        saveGame("C:/Users/Polina/IdeaProjects/filesTask1/Games/savegames/saveData1.dat",gameProgress1);
        saveGame("C:/Users/Polina/IdeaProjects/filesTask1/Games/savegames/saveData2.dat",gameProgress2);
        saveGame("C:/Users/Polina/IdeaProjects/filesTask1/Games/savegames/saveData3.dat",gameProgress3);
        List<String> listfiles = new ArrayList<>();
        listfiles.add("C:/Users/Polina/IdeaProjects/filesTask1/Games/savegames/saveData1.dat");
        listfiles.add("C:/Users/Polina/IdeaProjects/filesTask1/Games/savegames/saveData2.dat");
        listfiles.add("C:/Users/Polina/IdeaProjects/filesTask1/Games/savegames/saveData3.dat");
        zipFiles("C:/Users/Polina/IdeaProjects/filesTask1/Games/savegames/zip.zip", listfiles);

    }
}