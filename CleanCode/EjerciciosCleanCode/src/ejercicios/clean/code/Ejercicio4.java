package ejercicios.clean.code;

public class Ejercicio4 {
    public float getMonthlySalary(Ejercicio4Employee ejercicio4Employee) {
        // Cambiados los double por float
        //Creada la clase Ejercicio4Employee, de donde establezco y extraigo sus datos con los setter y getter.
        float yearlySalary = ejercicio4Employee.getYearlySalary();
        float awards = ejercicio4Employee.getAwards();
        return (yearlySalary + awards)/12;
    }


    //Prueba del Ejercicio 4
    public static void main(String[] args) {
        Ejercicio4Employee employee1 = new Ejercicio4Employee();
        employee1.setYearlySalary(20000);
        employee1.setAwards(3000);

        Ejercicio4 exercise4 = new Ejercicio4();
        System.out.println(exercise4.getMonthlySalary(employee1));
    }
}
