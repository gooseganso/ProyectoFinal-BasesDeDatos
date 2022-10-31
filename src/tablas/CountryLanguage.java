package tablas;

public class CountryLanguage {
    private String countryCode;
    private String language;
    private char isOfficial;
    private float percentage;

    public CountryLanguage() {
    }

    public CountryLanguage(String countryCode, String language, char isOfficial, float percentage) {
        this.countryCode = countryCode;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public char getIsOfficial() {
        return this.isOfficial;
    }

    public void setIsOfficial(char isOfficial) {
        this.isOfficial = isOfficial;
    }

    public float getPercentage() {
        return this.percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return this.countryCode + "_" + this.language + "_" + this.isOfficial + "_" + this.percentage;
    }
}
