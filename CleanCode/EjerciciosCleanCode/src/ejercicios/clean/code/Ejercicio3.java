package ejercicios.clean.code;

public class Ejercicio3 {

    /*He cambiado el nombre a las variables para que sea más explícito
    * También he creado el nombre del método más detallado
    * El método ahora devuelve un String. Evito la repetición de varios System.out.println en el mismo método
    * He puesto las condiciones en dos if separados. En caso de que las condiciones no se cumplan
    * el método devolverá el último return*/

    public String quadraticEquation(double num1, double num2, double num3) {
        double D = (num2 * num2) - (4 * num1 * num3);

        if (D > 0) {
            double x1 = (-num2 - Math.sqrt(D)) / (2 * num1);
            double x2 = (-num2 + Math.sqrt(D)) / (2 * num1);
            return "x1 = " + x1 + ", x2 = " + x2;
        }

        if (D == 0) {
            double x = -num2 / (2 * num1);
            return "x = " + x;
        }

        return "Equation has no roots";
    }


    //Prueba del método
    public static void main(String[] args) {

        Ejercicio3 ejercicio3 = new Ejercicio3();
        System.out.println(ejercicio3.quadraticEquation(2,50,2));
    }
}
