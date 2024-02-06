import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static  StringBuilder log;
    public static void writeLog(String path, String log){
        try (FileWriter writer = new FileWriter(path, true)) {
            writer.append(log);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
    public static void makeDirectory(String path){
        File dir = new File(path);
        if (dir.exists()){
            log.append(String.format("%s Каталог %s уже существует %n",
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")).toString(),
                    path));
        }else{
            if (dir.mkdir())
                log.append(String.format("%s Каталог %s создан %n",
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")).toString(), path));
        }
       }
    public static void makeFile(String path){
        File myFile = new File(path);
        try {
            if (myFile.exists()){
                log.append(String.format("%s Файл %s уже существует %n",
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")).toString(),
                        path));
            }else{
                if (myFile.createNewFile())
                    log.append(String.format("%s Файл %s создан %n",
                            LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")).toString(),
                            path));
            }

        } catch (IOException ex) {
            log.append(String.format("%s при создании файла %s, произошла ошибка %s %n",
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS")).toString(),
                    path,ex.getMessage()));
        }
    }
    public static void main(String[] args) {
        log = new StringBuilder();
        makeDirectory( "Games/res");
        makeDirectory( "Games/res/drawables");
        makeDirectory( "Games/res/vectors");
        makeDirectory( "Games/res/icons");
        makeDirectory( "Games/src");
        makeDirectory( "Games/src/main");
        makeDirectory( "Games/src/test");
        makeDirectory( "Games/savegames");
        makeDirectory( "Games/temp");
        makeFile("Games/temp/temp.txt");
        makeFile("Games/src/main/Main.java");
        makeFile("Games/src/main/Utils.java");
        writeLog("Games/temp/temp.txt", log.toString());
    }
}