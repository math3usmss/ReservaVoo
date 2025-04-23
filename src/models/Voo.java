package models;

import java.util.Date;
import java.util.Objects;

public class Voo {

    private Integer codigo;
    private String origem;
    private String destino;
    private Date data;
    private Date horario;
    private Integer assentos;

    public Voo(){}

    public Voo(Integer codigo, String origem, String destino, Date data, Date horario, Integer assentos) {
        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
        this.data = data;
        this.horario = horario;
        this.assentos = assentos;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Integer getAssentos() {
        return assentos;
    }

    public void setAssentos(Integer assentos) {
        this.assentos = assentos;
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
}
