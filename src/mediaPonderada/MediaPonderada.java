package mediaPonderada;

import java.util.Locale;
import java.util.Scanner;

public class MediaPonderada {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Deseja adicionar valores X e P para calcular a media Ponderada? [S/N]");
        char answer = sc.next().toUpperCase().charAt(0);

        double calcEnd = 0;
        double calcFirts = 0;
        double calcSecond = 0;

        while (answer == 'S'){
            System.out.print("Informe o valor de X: ");
            double x = sc.nextDouble();

            System.out.print("Informe o valor de P: ");
            double p = sc.nextDouble();

            calcFirts += x * p;
            calcSecond += x;

            calcEnd = calcFirts / calcSecond;

            System.out.print("Deseja adicionar valores X e P para calcular a media Ponderada? [S/N]");
            answer = sc.next().toUpperCase().charAt(0);
        }

        System.out.printf("Media ponderada: %.2f", calcEnd);

        sc.close();
    }
}
