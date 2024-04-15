package ejercicios.clean.code;

import java.util.ArrayList;

public class Ejercicio5 {
    public void getNumbers(int size, int limit){
        ArrayList<Integer> list = new ArrayList<>();

        while(list.size()<size) {
            int number = (int) ((Math.random() * limit) + 1);
            if(!list.contains(number)) list.add(number);
        }

        for(Integer num: list){
            System.out.print(num+"  ");
        }
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
