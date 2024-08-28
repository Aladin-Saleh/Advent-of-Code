import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Part2 {

    private final static String[] number = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};


    private Scanner reader;
    public Part2(String path) {
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
                if (!Character.isDigit(line.charAt(i))){
                    for (int j = 0; j < number.length; j++) {
                        StringBuilder s = new StringBuilder();
                        for (int j2 = 0; j2 < number[j].length(); j2++) {
                            s.append(line.charAt((i + j2)%line.length()));
                        }

                        if (s.toString().equals(number[j])) {
                            completeDigit.append(j+1);
                        }
                    }
                } else {
                    completeDigit.append(line.charAt(i));
                }

            }

            input.add(Integer.parseInt(completeDigit.charAt(0) +""+ completeDigit.charAt(completeDigit.length() - 1)));
        }
        return input;

    }


    public static void main(String[] args) {
        System.out.println(new Part2("./input.txt").readInput().stream().mapToInt(Integer::intValue).sum());
    }

    
}
