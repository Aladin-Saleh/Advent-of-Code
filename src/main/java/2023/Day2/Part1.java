import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Part1 {

    private final int RED_AMOUNT = 12;
    private final int GREEN_AMOUNT = 13;
    private final int BLUE_AMOUNT = 14;

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
        List<Integer> gamesId = new ArrayList<>();

        int game = 0;
        while (this.reader.hasNextLine()) {
            String line = this.reader.nextLine();
            // System.out.println(line);
            game++;
            if (isGamePossible(line)) {
                System.out.println("Game " + game + " is possible");
                gamesId.add(game);                
            }
        }

        return gamesId;
    }

    public boolean isGamePossible(String grabInformation) {
        int r, g, b = 0;

        for (String l : Arrays.asList(grabInformation.split(":")[1].split(";"))) {
            // System.out.println(l);
            r = howManyColors("red", l);
            g = howManyColors("green", l);
            b = howManyColors("blue", l);

            if (r > RED_AMOUNT || g > GREEN_AMOUNT || b > BLUE_AMOUNT) {
                return false;
            }
            
        }

        return true;
    }

    public int howManyColors(String color, String text) {

        String expression = "(?i)(\\d+)\\s+\\b" + color + "\\b";
        Pattern pattern     = Pattern.compile(expression);
        Matcher matcher     = pattern.matcher(text);

        if (matcher.find()) return Integer.parseInt(matcher.group(1));

        return 0;        
    }

    public static void main(String[] args) {
        System.out.println(new Part1("./input.txt").readInput().stream().mapToInt(Integer::intValue).sum());
    }

    
}
