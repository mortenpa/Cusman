package mortenpa.com.github.cusman.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String alpha2Code;
    private String alpha3Code;
    private String numericCode;
    private String name;

    protected Country() {}

    public Country(String name, String alpha3Code){
        this.name = name;
        this.alpha3Code = alpha3Code;
    }
    @Override
    public String toString(){
        return name;
    }

    public Country(String name, String alpha3Code, String alpha2Code, String numericCode){
        this.name = name;
        this.alpha3Code = alpha3Code;
        this.alpha2Code = alpha2Code;
        this.numericCode = numericCode;
    }

    public Long getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAlpha3Code(){
        return alpha3Code;
    }

    public String getAlpha2Code(){
        return alpha2Code;
    }

    public String getNumericCode(){
        return numericCode;
    }


}
