package services;

import models.Voo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class GerenciadorVoos {

    private  ArrayList<Voo> voos = new ArrayList<>();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

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



}
