package vastus.sokoban.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Helpers {

    public static String readFileToString(File file) throws FileNotFoundException {
        StringBuilder contents = new StringBuilder();
        Scanner scanner = new Scanner(file, "UTF-8");
        while (scanner.hasNextLine()) {
            contents.append(scanner.nextLine()).append("\n");
        }

        contents.setLength(contents.length() - 1);
        return contents.toString();
    }

}
