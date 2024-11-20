import java.util.Scanner;

public class TablasMultiplicar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Se repite el proceso mientras el usuario desee continuar
        while (continuar) {
            // Solicitar al usuario el número para la tabla de multiplicar
            System.out.print("Introduce un número para generar su tabla de multiplicar: ");
            int numero = scanner.nextInt();

            // Generar la tabla de multiplicar del número
            System.out.println("Tabla de multiplicar de " + numero + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println(numero + " x " + i + " = " + (numero * i));
            }

            // Preguntar al usuario si desea continuar
            System.out.print("¿Deseas generar otra tabla de multiplicar? (si/no): ");
            char respuesta = scanner.next().charAt(0);

            // Si la respuesta no es 's', se termina el ciclo
            if (respuesta != 'si' && respuesta != 'Si') {
                continuar = false;
            }
        }

        // Mensaje de despedida
        scanner.close();
    }
}