package services;

import models.Reserva;
import models.Voo;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class GerenciadorVoos {

    private String path = "./Voos.txt";

    private  ArrayList<Voo> voos = new ArrayList<>();
    private  GerenciadorReservas gerenciadorReservas;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public GerenciadorVoos(){

    }

    public GerenciadorVoos(GerenciadorReservas gerenciadorReservas){
        this.gerenciadorReservas = gerenciadorReservas;
    }

    public Voo CriarVoo( String origem, String destino, String data, String horario, int assentos){
        try{
            LocalDate dataFormatada = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalTime horarioFormatada = LocalTime.parse(horario, DateTimeFormatter.ofPattern("HH:mm"));

            Voo voo = new Voo(origem, destino, dataFormatada, horarioFormatada, assentos);
            voos.add(voo);
            return voo;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void VoosDisponiveis(){
        try{
            if(!voos.isEmpty()){
                for(Voo v : voos){
                    System.out.println("Voo: " + v.getCodigo() + ", De: " +  v.getOrigem() + ", Para: " + v.getDestino() + ", Data: " + v.getData() + " " +  v.getHorario() + ", Assentos disponíveis: " + v.getAssentos());
                }
            }else{
                System.out.println("Não existe voos disponívies no momento.");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean vooExiste(int codigoVoo){
        return voos.stream().anyMatch(v -> v.getCodigo() == codigoVoo);
    }

    public void reservarAssento(int codigoVoo){
        for(Voo v_reserva : voos){
            if(v_reserva.getCodigo().equals(codigoVoo)){
                v_reserva.reservarAssentos();
            }
        }
    }

    public void cacelarReservaVoo(int codigoVoo){
        for(Voo v_CancelarReserva : voos){
            if(v_CancelarReserva.getCodigo().equals(codigoVoo)){
               v_CancelarReserva.cancelarReserva();
            }
        }
    }

    public void DeletarVoo(int codigoVoo){
        Voo vooDeletar = null;
        for(Voo v_deletarVoo : voos){
           if(gerenciadorReservas.verificaReserva(codigoVoo)){
               if(v_deletarVoo.getCodigo().equals(codigoVoo)){
                   vooDeletar = v_deletarVoo;
                   vooDeletar.cancelarReserva();
               }
           }else{
               System.out.println("Não pode apagar Voo que possui reservas abertas");
           }
        }
        voos.remove(vooDeletar);
    }

    public void buscarVooCidade(String NomeCidade){
        for(Voo v_cidade : voos){
            if(v_cidade.getOrigem().equalsIgnoreCase(NomeCidade) || v_cidade.getDestino().equalsIgnoreCase(NomeCidade)){
               System.out.println(v_cidade);
            }
        }
    }

    public void importVoos(){
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
            for(Voo importVoos : voos){
                String dataFormatada = importVoos.getData().format(formatoData);
                String horarioFormatado = importVoos.getHorario().format(formatoHora);

                String linha = importVoos.getCodigo() + "##" + importVoos.getOrigem()+ "##" + importVoos.getDestino()+ "##" + dataFormatada + "##" + horarioFormatado + "##" + importVoos.getAssentos();
                bw.write(linha);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void exportVoos(){
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String linha;
            while((linha = br.readLine()) != null){
                String[] vooSalvos = linha.split("##");

                LocalDate dataFormatada = LocalDate.parse(vooSalvos[3], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalTime horarioFormatada = LocalTime.parse(vooSalvos[4], DateTimeFormatter.ofPattern("HH:mm"));

                Voo vooSalvo = new Voo(vooSalvos[1], vooSalvos[2],dataFormatada ,horarioFormatada , Integer.parseInt(vooSalvos[5]));
                voos.add(vooSalvo);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
