package lesson_6;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Random;

public class FileParser {
    private String baseDir;

    public FileParser(String baseDir){
        this.baseDir = baseDir;
    }

    public void printFile(String fileName){
        try {
            InputStream file = Files.newInputStream(Path.of(baseDir + fileName));
            int symbol = file.read();
            while (symbol > 0){
                System.out.print((char)symbol);
                symbol = file.read();
            }
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateFile(int strCount, String fileName){
        try {
            OutputStream file = Files.newOutputStream(Path.of(baseDir + fileName));
            Random rnd = new Random();
            int i = 0;
            while (i < strCount){
                String str = generateString(5 + rnd.nextInt(10));
                file.write(str.getBytes());
                file.write("\r\n".getBytes());
                i++;
            }
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mergeFile(String fileName1, String fileName2, String output){
        try {
            OutputStream os = Files.newOutputStream(Path.of(baseDir + output));
            InputStream is = Files.newInputStream(Path.of(baseDir + fileName1));
            int symbol = is.read();
            while (symbol > 0){
                os.write(symbol);
                symbol = is.read();
            }
            is.close();
            is = Files.newInputStream(Path.of(baseDir + fileName2));
            symbol = is.read();
            while (symbol > 0){
                os.write(symbol);
                symbol = is.read();
            }
            is.close();
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String generateString(int wordCount){
        StringBuilder builder = new StringBuilder();
        Random rnd = new Random();
        for (int w = 0; w < wordCount; w++){
            int wordLength = rnd.nextInt(5) + 2;
            for (int c = 0; c < wordLength; c++){
                int symbol = 65 + rnd.nextInt(90 - 65);
                builder.append((char)symbol);
            }
            if (w < wordCount - 1) {
                builder.append(" ");
            } else {
                builder.append(".");
            }
        }
        return builder.toString();
    }

    public boolean findWord(String word, String fileName){
        try {
            InputStream is = Files.newInputStream(Path.of(baseDir + fileName));
            StringBuilder builder = new StringBuilder();
            int symbol = is.read();
            while (symbol > 0){
                if (symbol != 46 && symbol != 32 && symbol!= 10 && symbol != 13) {
                    builder.append((char) symbol);
                } else {
                    if (builder.toString().equalsIgnoreCase(word)){
                        return true;
                    }
                    builder.delete(0, builder.length());
                }
                symbol = is.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
