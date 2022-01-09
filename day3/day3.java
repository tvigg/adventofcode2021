import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3 {
    public static void main(String[] args) throws IOException {

        String fileName = "Day3/input.txt";
        Path pathToFile = Paths.get(fileName);
        List<String> commands = Files.readAllLines(pathToFile);

        //Part One ----------------------------------------------------------------
        int[] rate = new int[commands.get(0).length()];
        for(String command : commands){
            for(int i = 0; i < command.length(); i++){
                rate[i] += Character.getNumericValue(command.charAt(i));
            }
        }
        int[] binary = Arrays.stream(rate)
                .map(v -> valueToBinary(v, commands.size(), false))
                .toArray();
        int[] binaryComplement = Arrays.stream(rate)
                .map(v -> valueToBinary(v, commands.size(), true))
                .toArray();

        System.out.println("Part one: " + binaryToInt(binary) * binaryToInt(binaryComplement));

        //Part Two------------------------------------------------------------------

        List<String> commandsCopy = new ArrayList<>(commands);
        sieve(commandsCopy, 0, 1);
        int ogr = binaryToInt(commandsCopy.get(0));
        List<String> commandsCopy2 = new ArrayList<>(commands);
        sieve(commandsCopy2, 1, 0);
        int CO2sr = binaryToInt(commandsCopy2.get(0));
        System.out.println("Part two: " + ogr * CO2sr);
    }

    private static void sieve(List<String> commands, int first, int second) {
        for (int i = 0; i < commands.get(0).length(); i++) {    //12
            if(commands.size() == 1){
                break;
            }
            if (oneOrZero(commands, i) * 2 >= (commands.size())) {   //1
                for (int j = 0; j < commands.size(); j++) {      //1000
                    if (Character.getNumericValue(commands.get(j).charAt(i)) == first) {
                        commands.remove(j);
                        j = 0;
                    }
                }
            } else {                                            //0
                for (int j = 0; j < commands.size(); j++) {
                    if (Character.getNumericValue(commands.get(j).charAt(i)) == second) {
                        commands.remove(j);
                        j = 0;
                    }
                }
            }
        }
    }

    static int oneOrZero(List<String> arrs, int pos){
        int sum = 0;
        for(String arr : arrs){
            sum += Character.getNumericValue(arr.charAt(pos));
        }
        return sum;
    }
    
    static int valueToBinary(int value, int sizeOfDiagnostic, boolean complement){
        if (value * 2 > sizeOfDiagnostic){
            if(complement){
                return 0;
            } else {
                return 1;
            }
        } else {
            if(complement){
                return 1;
            } else {
                return 0;
            }
        }
    }

    static int binaryToInt(String numbers){
        int decimal = 0;
        for(int i = 0; i < numbers.length(); i++){
            if(numbers.charAt(i) == '1'){
                decimal = decimal << 1;
                decimal++;
            } else {
                decimal = decimal << 1;
            }
        }
        return decimal;
    }

    static int binaryToInt(int[] arr){
        int decimal = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                decimal = decimal << 1;
                decimal++;
            } else {
                decimal = decimal << 1;
            }
        }
        return decimal;
    }
}
