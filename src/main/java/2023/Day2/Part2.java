import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Part2 {

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
        List<Integer> powers = new ArrayList<>();

        while (this.reader.hasNextLine()) {
            String line = this.reader.nextLine();
            // System.out.println(line);

            int r = 0, g = 0, b = 0;
            for (String l : Arrays.asList(line.split(":")[1].split(";"))) {

                if (howManyColors("red", l) > r )    r = howManyColors("red", l); 
                if (howManyColors("green", l) > g )  g = howManyColors("green", l);
                if (howManyColors("blue", l) > b )   b = howManyColors("blue", l);
                
            }

            System.out.println(r+""+g+""+b +"=" + r*g*b);
            powers.add(r*g*b);

        }

        return powers;
    }

    public int howManyColors(String color, String text) {

        String expression = "(?i)(\\d+)\\s+\\b" + color + "\\b";
        Pattern pattern     = Pattern.compile(expression);
        Matcher matcher     = pattern.matcher(text);

        if (matcher.find()) return Integer.parseInt(matcher.group(1));

        return 0;        
    }

    public static void main(String[] args) {
        System.out.println(new Part2("./input.txt").readInput().stream().mapToInt(Integer::intValue).sum());
    }

    
}
