package models;

import java.util.Objects;

public class Reserva {

    private String passageiro;
    private String CPF;
    private Voo voo;

    public Reserva(){}

    public Reserva(String passageiro, String CPF, Voo voo) {
        this.passageiro = passageiro;
        this.CPF = CPF;
        this.voo = voo;
    }

    public String getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(String passageiro) {
        this.passageiro = passageiro;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Reserva reserva)) return false;
        return Objects.equals(CPF, reserva.CPF) && Objects.equals(voo, reserva.voo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CPF, voo);
    }
}
