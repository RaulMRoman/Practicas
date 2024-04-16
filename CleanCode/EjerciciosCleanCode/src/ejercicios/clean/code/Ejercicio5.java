package ejercicios.clean.code;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Ejercicio5 {

    private ArrayList<Integer> list;

    //Método para leer las listas que creemos
    public void readNumbers(){
        Collections.sort(list);
        for(Integer num: list){
            System.out.print(num+"  ");
        }
    }

    //Método que creará la lista, estableciedo el tamaño de la lista, y el rango de números
    public void getNumbers(int size, int limit){
        list = new ArrayList<>();

        //Creación de la lista
        while(list.size()<size) {
            int number = (int) ((Math.random() * limit) + 1);
            if(!list.contains(number)) list.add(number);
        }

        //Lectura de números
        readNumbers();
    }



    public static void main(String[] args){
        Ejercicio5 e = new Ejercicio5();
        System.out.println("Números");
        e.getNumbers(5, 50);
        System.out.println();
        System.out.println("Estrellas");
        e.getNumbers(2, 12);

    }
}
