package ejercicios.clean.code;

public class Ejercicio1 {

    //Método checkMax, le pasamos variables de tipo entero, num1 y num2
    //Nos devuelve el resultado (true o false) al hacer la comparación
    public boolean checkMax(int num1, int num2){
        return num1>num2;
    }

    //Prueba del método checkMax
    public static void main(String[] args){
        Ejercicio1 exercise1 = new Ejercicio1();
        int num1 = 7;
        int num2 = 2;
        boolean resultCheckMax = exercise1.checkMax(num1, num2);
        System.out.println("¿"+num1+" es mayor que "+num2+"? "+resultCheckMax);
    }
}
