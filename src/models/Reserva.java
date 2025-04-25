package models;

import java.util.Objects;

public class Reserva {

    private String nomePassageiro;
    private String CPF;
    private Integer codigoVoo;

    public Reserva() {
    }

    public Reserva(String nomePassageiro, String CPF, Integer codigoVoo) {
        this.nomePassageiro = nomePassageiro;
        this.CPF = CPF;
        this.codigoVoo = codigoVoo;
    }

    public String getPassageiro() {
        return nomePassageiro;
    }

    public String getCPF() {
        return CPF;
    }

    public Integer getCodigoVoo() {
        return codigoVoo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Reserva reserva)) return false;
        return Objects.equals(CPF, reserva.CPF) && Objects.equals(codigoVoo, reserva.codigoVoo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CPF, codigoVoo);
    }
}
