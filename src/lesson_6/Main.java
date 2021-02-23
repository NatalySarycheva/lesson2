package lesson_6;

public class Main {
    public static void main(String[] args) {
        FileParser fp = new FileParser("src/lesson_6/");

        fp.generateFile(10, "file1" );
        fp.printFile("file1");
        System.out.println();

        fp.generateFile(5, "file2" );
        fp.printFile("file2");
        System.out.println();

        fp.mergeFile("file1", "file2", "file3");
        fp.printFile("file3");

        boolean isWordInFile = fp.findWord("MPMVV", "file2");
        System.out.println(isWordInFile);
    }

}