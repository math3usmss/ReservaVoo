import models.Voo;
import services.GerenciadorReservas;
import services.GerenciadorVoos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GerenciadorVoos gv = new GerenciadorVoos();
        GerenciadorReservas gr = new GerenciadorReservas();

        int option = menu();

        do {
            switch (option) {
                case 1:
                    System.out.println("Digite a origem do voo:");
                    String origem = sc.nextLine();
                    System.out.println("Digite o destino do voo:");
                    String destino = sc.nextLine();
                    System.out.println("Digite a data do voo(dia/mês/ano):");
                    String data = sc.next();
                    System.out.println("Digite o horario do voo(hora:minuto):");
                    String horario = sc.next();
                    System.out.println("Quantos assentos disponíveis o voo terá:");
                    int assentos = sc.nextInt();
                    sc.nextLine();

                    gv.CriarVoo(origem, destino, data, horario, assentos);
                    option = menu();
                    break;
                case 2:
                    gv.VoosDisponiveis();
                    option = menu();
                    break;
                case 3:
                    System.out.println("Digite o nome do passageiro:");
                    String nome_passageiro = sc.nextLine();
                    System.out.println("Digite o CPF do passageiro:");
                    String CPF = sc.nextLine();
                    System.out.println("Digite codigo do voo:");
                    int codigo_voo = sc.nextInt();
                    sc.nextLine();

                    gr.NovaReserva(nome_passageiro, CPF, codigo_voo);
                    option = menu();
                    break;
                case 4:
                    gr.Reservas();
                    option = menu();
                    break;
                case 7:
            }

        } while (option != 0);

        sc.close();

    }

    public static Integer menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("----------------");
        System.out.println("0 - Sair");
        System.out.println("1 - Cadastrar um novo Voo");
        System.out.println("2 - Listar todos os voos disponíveis");
        System.out.println("3 - Reservar assento");
        System.out.println("4 - Listar todos os reservas disponíveis");
        System.out.println("7 - Buscar voo por cidade");
        System.out.println("----------------");

        return sc.nextInt();
    }
}