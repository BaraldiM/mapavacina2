package vacina;

import classes.cidadao;
import classes.enfermeira;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.Duration;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MAPA2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<cidadao> lista = new ArrayList<>();
        System.out.print("Nome enfermeira(o): ");
        String nome = scan.nextLine();
        System.out.print("Cpf enfermeira(o): ");
        String cpf = scan.nextLine();
        System.out.println();
        menu();
        int option = scan.nextInt();
        scan.nextLine();
        while (option != 3) {
            if (option == 1) {
                int menu = 0;
                System.out.print("Nome cidadão: ");
                nome = scan.nextLine();
                System.out.print("CPF cidadão: ");
                cpf = scan.nextLine();
                do {
                    System.out.printf("Quando tomou a 1ª dose? (dd/MM/yyyy): %n");
                    String date1 = scan.nextLine();
                    System.out.printf("Quando tomou a 2ª dose? (dd/MM/yyyy): %n");
                    String date2 = scan.nextLine();
                    if (calc(date2, date1) == 1) {
                        System.out.println("Não tem dose disponivel ainda, cadastro cancelado");
                        break;
                    }
                    System.out.printf("Quando tomou a 3ª dose? (dd/MM/yyyy): %n");
                    String date3 = scan.nextLine();
                    if (calc(date3, date2) == 1) {
                        System.out.println("Não tem dose disponivel ainda, cadastro cancelado");
                        break;
                    }
                    System.out.printf("Quando tomou a 4ª dose? (dd/MM/yyyy): %n");
                    String date4 = scan.nextLine();
                    if (calc(date3, date2) == 1) {
                        System.out.println("Não tem dose disponivel ainda, cadastro cancelado");
                        break;
                    }
                    if (calc(date4, date3) == 1) {
                        System.out.println("Não tem dose disponivel ainda, cadastro cancelado");
                        break;
                    }
                    lista.add(new cidadao(nome, cpf, date1, date2, date3, date4));
                    System.out.println("Cadastro finalizado");
                    menu = 1;

                } while (menu != 1);
            } else {
                System.out.println("------------------------");
                for (cidadao to : lista) {
                    System.out.println(to);
                }
            }
            menu();
            option = scan.nextInt();
            scan.nextLine();
        }
        scan.close();
    }

    public static void menu() {
        System.out.println("----------MENU----------");
        System.out.println("1 - Vacinar cidadão");
        System.out.println("2 - Listar Cidadões");
        System.out.println("3 - Sair");

    }

    public static int calc(String data, String data2) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate caldate1 = LocalDate.parse(data, format);
        LocalDate caldate2 = LocalDate.parse(data2, format);
        Duration tempo = Duration.between(caldate2.atStartOfDay(), caldate1.atStartOfDay());
        if (tempo.toDays() < 120) {
            return 1;
        } else {
            return 0;
        }

    }
}

