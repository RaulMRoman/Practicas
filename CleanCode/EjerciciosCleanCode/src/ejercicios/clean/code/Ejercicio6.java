package ejercicios.clean.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio6 {

    Scanner teclado;
    private final ArrayList<String> randomList = new ArrayList<>();
    private ArrayList<String> chosenList = new ArrayList<>();
    private int tryings=0;
    private int white, black;
    private String color1, color2, color3, color4;

    //Método con el que obtenemos la lista de colores en orden aleatorio.
    public void getSequence(){
        //Añadidos los valores en la misma declaración por ser escasos.
        // Si fueran más elementos, mejor añadir con list.add
        ArrayList<String> coloursList = new ArrayList<>(Arrays.asList("Azul", "Rojo", "Verde", "Amarillo"));

        while(randomList.size()<4){
            randomList.add(coloursList.get((int) (Math.random()*4)).toLowerCase());
        }

        getRandomList();
    }

    //Método para mostrar la lista de colores en orden aleatorio, para hacer comprobacioens
    //En el juego real no habría que mostrarlo
    public void getRandomList(){
        for(String colour: randomList) System.out.print(colour+" ");
        System.out.println();
    }

    public void userSelectsColors(){
        teclado = new Scanner(System.in);
        System.out.print("Color 1: ");
        this.color1 = teclado.nextLine().toLowerCase().trim();
        System.out.print("Color 2: ");
        this.color2 = teclado.nextLine().toLowerCase().trim();
        System.out.print("Color 3: ");
        this.color3 = teclado.nextLine().toLowerCase().trim();
        System.out.print("Color 4: ");
        this.color4 = teclado.nextLine().toLowerCase().trim();
    }

    //Método para comprobar las dos listas y actualizar el conteo de bolas blancas y negras.
    public void checkingLists(){
        this.chosenList = new ArrayList<>(Arrays.asList(color1, color2, color3, color4));
        for (int i = 0; i < chosenList.size(); i++) {

            if (this.chosenList.get(i).equals(this.randomList.get(i))) this.white++;
            else if (this.randomList.contains(this.chosenList.get(i))) this.black++;
        }
        System.out.println("Bolas Blancas: " + this.white + "\nBolas Negras: " + this.black);
    }

    //Método para actualizar y mostrar el número de intentos
    public void updateTryings(){
        this.tryings++;
        System.out.println("Número de intentos: " + this.tryings+"\n");
    }

    //Método para mostrar los resultados finales (Victoa o Derrota)
    public void results(){
        if(this.white==4) System.out.println("¡Enhorabuena! Has ganado. " +
                "La secuencia correcta es: " + randomList.toString());

        if(this.tryings==10 & this.white<4) System.out.println("Lo sentimos. Has llegado al máximo de intentos"+
                "La secuencia correcta es: " + randomList.toString());
    }

    //Método general donde se llama al resto de métodos con los que se forman la mecánica del juego.
    public void checkChosenColours(){
        System.out.println("Elige los colores");

        while(this.tryings<10 && this.white<4) {
            this.white=0;
            this.black=0;
            userSelectsColors();
            checkingLists();
            updateTryings();
            results();
        }
    }

    public static void main(String[] args){
        Ejercicio6 e6 = new Ejercicio6();
        e6.getSequence();
        e6.checkChosenColours();
    }
}