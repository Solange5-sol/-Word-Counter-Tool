import java.io.*;
public class WordCounter {
    private String filePath;
    private int lineCount;
    private int wordCount;
    private int charCount;
    public WordCounter(String filePath) {
        this.filePath = filePath;
        this.lineCount = 0;
        this.wordCount = 0;
        this.charCount = 0;
    }
    public void run() {
        try (BufferedReader buffer = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = buffer.readLine()) != null) {
                lineCount++;
                charCount += line.length();

                if (!line.isBlank()) {
                    String[] words = line.split("\\s+");
                    wordCount += words.length;
                }
            }
            result();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
    private void result() {
        System.out.println("\n---- Files ----");
        System.out.println("all Lines: " + lineCount);
        System.out.println("all  Words: " + wordCount);
        System.out.println("all Characters: " + charCount);
    }
}