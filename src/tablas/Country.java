package tablas;

public class Country {
    private String code;
    private String name;
    private String continent;
    private String region;
    private float surfaceArea;
    private int indepYear;
    private int population;
    private float lifeExpectancy;
    private float GNP;
    private float GNPOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private String capital;
    private String code2;
 

    public Country() {
        this.code = "";
        this.name = "";
        this.continent = "";
        this.region = "";
        this.surfaceArea = 0;
        this.indepYear = 0;
        this.population = 0;
        this.lifeExpectancy = 0;
        this.GNP = 0;
        this.GNPOld = 0;
        this.localName = "";
        this.governmentForm = "";
        this.headOfState = "";
        this.capital = "";
        this.code2 = "";
  
    }

    public Country(String code, String name, String continent, String region, float surfaceArea, int indepYear, int population, float lifeExpectancy, float GNP, float GNPOld, String localName, String governmentForm, String headOfState, String capital, String code2) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.indepYear = indepYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.GNP = GNP;
        this.GNPOld = GNPOld;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.capital = capital;
        this.code2 = code2;
     
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return this.continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public float getSurfaceArea() {
        return this.surfaceArea;
    }

    public void setSurfaceArea(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getIndepYear() {
        return this.indepYear;
    }

    public void setIndepYear(int indepYear) {
        this.indepYear = indepYear;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public float getLifeExpectancy() {
        return this.lifeExpectancy;
    }

    public void setLifeExpectancy(float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public float getGNP() {
        return this.GNP;
    }

    public void setGNP(float GNP) {
        this.GNP = GNP;
    }

    public float getGNPOld() {
        return this.GNPOld;
    }

    public void setGNPOld(float GNPOld) {
        this.GNPOld = GNPOld;
    }

    public String getLocalName() {
        return this.localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return this.governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return this.headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public String getCapital() {
        return this.capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return this.code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

   

    

    @Override
    public String toString() {
        return this.code + "_" + this.name + "_" + this.continent + "_" + this.region + "_" + this.surfaceArea + "_" + this.indepYear + "_" + this.population + "_" + this.lifeExpectancy + "_" + this.GNP + "_" + this.GNPOld + "_" + this.localName + "_" + this.governmentForm + "_" + this.headOfState + "_" + this.capital + "_" + this.code2;
    }
}
