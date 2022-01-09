import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day2 {
    public static void main(String[] args) throws IOException {

        String fileName = "Day2/input.txt";
        Path pathToFile = Paths.get(fileName);
        List<String> commands = Files.readAllLines(pathToFile);

        //Part One
        int position = 0;
        int depth = 0;
        for(String command : commands){
            if (command.charAt(0) == 'f') {
                position += Character.getNumericValue(command.charAt(8));
            } else if (command.charAt(0) == 'd') {
                depth += Character.getNumericValue(command.charAt(5));
            } else if (command.charAt(0) == 'u') {
                depth -= Character.getNumericValue(command.charAt(3));
            }
        }
        System.out.println(position*depth);

        //Part Two
        position = 0;
        depth = 0;
        int aim = 0;
        for(String command : commands){
            if (command.charAt(0) == 'f') {
                int X = Character.getNumericValue(command.charAt(8));
                position += X;
                depth += aim * X;
            } else if (command.charAt(0) == 'd') {
                aim += Character.getNumericValue(command.charAt(5));
            } else if (command.charAt(0) == 'u') {
                aim -= Character.getNumericValue(command.charAt(3));
            }
        }
        System.out.println(position*depth);
    }
}
