import java.io.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
//        File scr = new File("/")
        List<File> folders = Arrays.asList(
                new File("/Users/a0000/Documents/Games"),
                new File("/Users/a0000/Documents/Games/scr"),
                new File("/Users/a0000/Documents/Games/res"),
                new File("/Users/a0000/Documents/Games/savegames"),
                new File("/Users/a0000/Documents/Games/temp"),
                new File("/Users/a0000/Documents/Games/scr/main"),
                new File("/Users/a0000/Documents/Games/scr/test"),
                new File("/Users/a0000/Documents/Games/res/drawables"),
                new File("/Users/a0000/Documents/Games/res/vectors"),
                new File("/Users/a0000/Documents/Games/res/icons"));

        List<File> files = Arrays.asList(
                new File("/Users/a0000/Documents/Games/main/Main.java"),
                new File("/Users/a0000/Documents/Games/main/Utils.java"),
                new File("/Users/a0000/Documents/Games/temp/temp.txt"));
        folders.stream()
                .forEach(folder -> {
                    if (folder.mkdir()) {
                        sb.append("каталог " + folder + " создан");
                    } else {
                        sb.append("каталог " + folder + " НЕ создан");
                    }
                });
        files.stream()
                .forEach(file -> {
                    try {
                        if (file.createNewFile()) {
                            sb.append("файл " + file + " создан");
                        } else {
                            sb.append("файл " + file + " НЕ создан");
                        }

                    } catch (IOException e) {
                        sb.append(e.getMessage());
                    }
                });
        try (FileWriter log = new FileWriter("/Users/a0000/Documents/Games/temp/temp.txt",
                false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException e) {
            sb.append(e.getMessage());
        }
        try (BufferedReader buff = new BufferedReader
                (new FileReader("/Users/a0000/Documents/Games/temp/temp.txt"))) {
            String s;
            while ((s = buff.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}