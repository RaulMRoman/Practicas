package ejercicios.clean.code;

public class Ejercicio2Human {

    //He dividido el ejercicio en 2 clases, Ejercicio2Human (ésta) y Ejercicio2Address,
    //donde irán los datos relacionados con la dirección
    private final String name, age;

    //Datos pasados por constructor
    public Ejercicio2Human(String name, String age){
        this.name = name;
        this.age = age;
    }

    //Método que devuelve el String que une nombre y edad
    public String getHuman(){
        return this.name+", "+this.age;
    }


    //Prueba del ejercicio 2
    public static void main(String[] args) {

        Ejercicio2Address address = new Ejercicio2Address("España","Madrid","Gran Vía","59","2");
        String obtainingAddress = address.getAddress();

        Ejercicio2Human human = new Ejercicio2Human("Raúl", "41");
        String obtainingHuman = human.getHuman();

        System.out.println(human.getHuman() + ", "+ obtainingAddress);


    }

}
