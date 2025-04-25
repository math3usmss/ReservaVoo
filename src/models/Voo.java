package models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class Voo {

    static Integer codigoInicial = 100;

    private Integer codigo;
    private String origem;
    private String destino;
    private LocalDate data;
    private LocalTime horario;
    private Integer assentos;

    public Voo() {
    }

    public Voo(String origem, String destino, LocalDate data, LocalTime horario, Integer assentos) {
        this.codigo = codigoInicial++;
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.horario = horario;
        this.assentos = assentos;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public Integer getAssentos() {
        return assentos;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Voo voo)) return false;
        return Objects.equals(codigo, voo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    @Override
    public String toString() {
        return "Voo{" +
                "codigo=" + codigo +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", data=" + data +
                ", horario=" + horario +
                ", assentos=" + assentos +
                '}';
    }
}
