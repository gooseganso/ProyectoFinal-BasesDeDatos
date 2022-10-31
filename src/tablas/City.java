package tablas;

public class City {
    private int ID;
    private String name;
    private String countryCode;
    private String district;
    private int population;
    private String countryName;

    public City() {
    }

    public City(int ID, String name, String countryCode, String district, int population, String countryName) {
        this.ID = ID;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
        this.countryName = countryName;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return this.district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return this.ID + "_" + this.name + "_" + this.countryCode + "_" + this.district + "_" + this.population + "_" + this.countryName;
    }
}
