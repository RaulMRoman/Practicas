package ejercicios.clean.code;

public class Ejercicio2Address {

    private final String country, city, street, house, quarter;

    //Paso los datos por constructor
    public Ejercicio2Address(String country, String city, String street, String house, String quarter){
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.quarter = quarter;
    }

    //Método que devuelve un String con los datos de la dirección
    public String getAddress(){
        return country +", "+city+", "+street+", "+house+", "+quarter;
    }


}
