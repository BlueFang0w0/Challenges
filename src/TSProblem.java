import java.io.File;
import java.util.Arrays;
import java.util.HashSet;

public class TSProblem {
    public void run(){

        File textFile = new File("src/files/UK City Names.txt");
        TSPGenerator problemGenerator = new TSPGenerator.Builder(100,100, textFile)
                .lowerBounds(5,5)
                .build();
        HashSet<CitySet> cities = problemGenerator.generateCityData();
        for(CitySet city : cities){
            System.out.println("Location: " + city.getCityName() + " || Coordinates: " + Arrays.toString(city.getLoc()));
        }

    }
}
