public class CitySet {
    private final int[] xy;
    private final String cityName;

    CitySet(int[] xy, String cityName){
        this.xy = xy;
        this.cityName = cityName;
    }

    public int[] getLoc(){
        return xy;
    }

    public String getCityName(){
        return cityName;
    }
}
