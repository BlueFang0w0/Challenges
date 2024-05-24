import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class TSPGenerator {
    private int upperBoundX, upperBoundY;
    private int lowerBoundX, lowerBoundY;
    private File cityNamesPath;
    private HashSet<CitySet> cityDataSet = new HashSet<>();

    private TSPGenerator(Builder builder) { // Constructor.
        this.upperBoundX = builder.upperBoundX;
        this.upperBoundY = builder.upperBoundY;
        this.lowerBoundX = builder.lowerBoundX;
        this.lowerBoundY = builder.lowerBoundY;
        this.cityNamesPath = builder.cityNamesPath;
    }

    public static class Builder {
        private int upperBoundX;
        private int upperBoundY;
        private int lowerBoundX = 0;
        private int lowerBoundY = 0;
        private File cityNamesPath;

        public Builder(int upperBoundX, int upperBoundY, File cityNamesPath) { // Remaining un initialised parameters.
            this.upperBoundX = upperBoundX;
            this.upperBoundY = upperBoundY;
            this.cityNamesPath = cityNamesPath;
        }

        public Builder lowerBounds(int lowerBoundX, int lowerBoundY) { // Sets the initialised values.
            this.lowerBoundX = lowerBoundX;
            this.lowerBoundY = lowerBoundY;
            return this;
        }

        public TSPGenerator build() {
            return new TSPGenerator(this);
        }
    }

    private int[] generateXY(){
        int[] XndY = {0,0};
        XndY[0] = (int) (Math.random() * upperBoundX) + lowerBoundX;
        XndY[1] = (int) (Math.random() * upperBoundY) + lowerBoundY;
        return XndY;
    }

    public HashSet<CitySet> generateCityData(){

        try{
            String line;
            Scanner stdin = new Scanner(cityNamesPath);
            while(stdin.hasNextLine()){ // Output the file contents.
                line = stdin.nextLine();
                cityDataSet.add(new CitySet(generateXY(), line));
            }
        }
        catch (
                FileNotFoundException a){
        }

        return cityDataSet;
    }



}
