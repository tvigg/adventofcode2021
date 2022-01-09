import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Day1 {
    public static void main(String[] args) throws IOException {

        String fileName = "Day1/input.txt";
        Path pathToFile = Paths.get(fileName);
        List<String> sonarSweepReport = Files.readAllLines(pathToFile);

        //Part One
        int count = 0;
        for(int i = 1; i < sonarSweepReport.size(); i++){
            if (Integer.parseInt(sonarSweepReport.get(i)) > Integer.parseInt(sonarSweepReport.get(i-1))){
                count++;
            }
        }
        System.out.println(count);

        //Part Two
        int count2 = 0;
        for(int i = 0; i < sonarSweepReport.size()-3; i++){
            int firstMeasurementWindow =
                    Integer.parseInt(sonarSweepReport.get(i)) +
                    Integer.parseInt(sonarSweepReport.get(i+1)) +
                    Integer.parseInt(sonarSweepReport.get(i+2));
            int secondMeasurementWindow =
                    Integer.parseInt(sonarSweepReport.get(i+1)) +
                            Integer.parseInt(sonarSweepReport.get(i+2)) +
                            Integer.parseInt(sonarSweepReport.get(i+3));
            if (firstMeasurementWindow < secondMeasurementWindow){
                count2++;
            }
        }
        System.out.println(count2);
    }
}
