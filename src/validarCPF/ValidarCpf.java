package validarCPF;

import java.util.Scanner;

public class ValidarCpf {

    public static boolean validaGeral(String cpf){

        int cont = 0;
        for (int i = 0; i < 10; i++) {
            if (cpf.charAt(i) - '0' == cpf.charAt(i+1) - '0'){
                cont += 1;

            }
        }

        if (cont == 10){
            return false;
        }

        return true;
    }

    public static boolean validaPrimeiroDigito(String cpf){
        int calc = 0;
        int suport = 10;

        for (int i = 0; i <= 8; i++) {
            int number = cpf.charAt(i) - '0';

            if (suport >= 2){
                calc += number * suport;
                suport -= 1;
            }
        }

        int resto = calc * 10 % 11;

        if (resto != cpf.charAt(9) - '0'){
            return false;
        }

        return true;
    }

    public static boolean validaSegundoDigito(String cpf){
        int calc = 0;
        int suport = 11;

        for (int i = 0; i <= 9; i++) {
            int number = cpf.charAt(i) - '0';

            if (suport >= 2){
                calc += number * suport;
                suport -= 1;
            }

        }

        int resto = calc * 10 % 11;

        if (resto != cpf.charAt(10) - '0'){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Infome seu cpf (APENAS NUMEROS): ");
        String cpf = sc.next();

        if(validaGeral(cpf) && validaPrimeiroDigito(cpf) && validaSegundoDigito(cpf)){
            System.out.println("CPF Valido");
            return;
        }

        System.out.println("CPF Invalido");

        sc.close();
    }
}
