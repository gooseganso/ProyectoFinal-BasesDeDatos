package Gestion;

public class Query {

    private String consulta = "";
    
    public Query() {
    }
    
    public String orderBy(String combo, String ordenar, String limite){
        this.consulta = " order by";
        if(combo.equals("Código"))
            this.consulta += " 1";
        if(combo.equals("Nombre"))
            this.consulta += " 2";
        if(combo.equals("Continente"))
            this.consulta += " 3";
        if(combo.equals("Región"))
            this.consulta += " 4";
        if(combo.equals("Área superficie"))
            this.consulta += " 5";
        if(combo.equals("Año independencia"))
            this.consulta += " 6";
        if(combo.equals("Población"))
            this.consulta += " 7";
        if(combo.equals("Expectativa de vida"))
            this.consulta += " 8";
        if(combo.equals("PIB"))
            this.consulta += " 9";
        if(combo.equals("PIB(2)"))
            this.consulta += " 10";
        if(combo.equals("Nombre local"))
            this.consulta += " 11";
        if(combo.equals("Forma de gobierno"))
            this.consulta += " 12";
        if(combo.equals("Cabeza de estado"))
            this.consulta += " 13";
        if(combo.equals("Capital"))
            this.consulta += " 14";
        if(combo.equals("Codigo(2)"))
            this.consulta += " 15";
        return this.consulta + " " + ordenar + " " + limite;
    }
    
    public String whereContinente(String continente){
        if(continente.equals("Asia"))
            this.consulta += "continent = 'asia'";
        if(continente.equals("Europa"))
            this.consulta += "continent = 'europe'";
        if(continente.equals("América del norte"))
            this.consulta += "continent = 'north America'";
        if(continente.equals("África"))
            this.consulta += "continent = 'africa'";
        if(continente.equals("Oceanía"))
            this.consulta += "continent = 'oceania'";
        if(continente.equals("Antártica"))
            this.consulta += "continent = 'antarctica'";
        if(continente.equals("América del sur"))
            this.consulta += "continent = 'south America'";
        return this.consulta;
    }
    
    public String where(String condicion, int i, boolean and, String number){
        if(and)
            this.consulta = " and ";
        switch(i){
            case 1:
                this.consulta += "surfacearea " + condicion + " " + number;
                break;
            case 2:
                this.consulta += "population " + condicion + " " + number;
                break;
            case 3:
                this.consulta += "indepyear " + condicion + " " + number;
                break;
            case 4:
                this.consulta += "GNP " + condicion + " " + number;
                break;
            case 5:
                this.consulta += "lifeExpectancy " + condicion + " " + number;
                break;
            case 6:
                this.consulta += "c.population " + condicion + " " + number;
                break;
            case 7:
                this.consulta += "percentage " + condicion + " " + number;
                break;
        }
        return this.consulta;
    }
    
}
