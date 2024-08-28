import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Part1 {

    private Scanner reader;
    public Part1(String path) {
        try {
            File file = new File(path);
            this.reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Integer> readInput() {

        List<Integer> input = new ArrayList<>();

        while (this.reader.hasNextLine()) {
            String line = this.reader.nextLine();
            StringBuilder completeDigit = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    completeDigit.append(line.charAt(i));
                }
            }
            System.out.println(completeDigit + " ==> " + completeDigit.charAt(0) + completeDigit.charAt(completeDigit.length() - 1));
            input.add(Integer.parseInt(completeDigit.charAt(0) +""+ completeDigit.charAt(completeDigit.length() - 1)));
        }
        return input;

    }






    public static void main(String[] args) {
        System.out.println(new Part1("./input.txt").readInput().stream().mapToInt(Integer::intValue).sum());
    }

    
}
