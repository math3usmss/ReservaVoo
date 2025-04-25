package services;

import models.Reserva;
import models.Voo;

import java.util.ArrayList;

public class GerenciadorReservas {

    private ArrayList<Reserva> reservas = new ArrayList<>();
    private  GerenciadorVoos gerenciadorVoos;

    public GerenciadorReservas(GerenciadorVoos gerenciadorVoos){
        this.gerenciadorVoos = gerenciadorVoos;
    }

    public Reserva NovaReserva(String nomePassageiro, String CPF, int codigoVoo) {
        Reserva reserva = null;
        try {
            if (gerenciadorVoos.vooExiste(codigoVoo)) {
                reserva = new Reserva(nomePassageiro, CPF, codigoVoo);
                reservas.add(reserva);
                gerenciadorVoos.reservarAssento(codigoVoo);
                return reserva;
            } else {
                System.out.println("Codigo do Voo indisponível");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return reserva;
    }

    public void Reservas(){
        try{
            if(!reservas.isEmpty()){
                for(Reserva r : reservas){
                    System.out.println("Passageiro: " + r.getPassageiro() + ", CPF: " +  r.getCPF() + ", Voo: " + r.getCodigoVoo());
                }
            }else{
                System.out.println("Não existe reservas feitas.");
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public void CancelarReserva(int codigoVoo, String CPF){
        Reserva r_cancelar = BuscaReserva(CPF);
        if(r_cancelar.getCPF().equalsIgnoreCase(CPF)){
            gerenciadorVoos.cacelarReserva(codigoVoo);
            reservas.remove(r_cancelar);
            System.out.println("Reserva cancelada");
        }
    }

    public Reserva BuscaReserva(String CPF){
        for(Reserva r_buscar : reservas){
            if(r_buscar.getCPF().equalsIgnoreCase(CPF)){
                return r_buscar;
            }
        }
        return null;
    }
}
