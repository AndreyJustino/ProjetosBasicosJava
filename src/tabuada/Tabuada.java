package tabuada;

import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o numero que deseja saber a tabuada: ");
        int number = sc.nextInt();

        for (int i = 0; i <= 10; i++) {
            System.out.printf("%d * %d = %d%n",number, i, number * i);
        }

        sc.close();
    }
}
