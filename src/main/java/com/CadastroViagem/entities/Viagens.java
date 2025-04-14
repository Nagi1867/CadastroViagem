package com.CadastroViagem.entities;

import com.CadastroViagem.enums.Status;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Viagens implements Serializable {
    private static final long SerialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomePassageiro;
    private String local;
    private String transporte;
    private Integer status;

    public Viagens() {}

    public Viagens(Long id, String nomePassageiro, String local, String transporte, Status status) {
        this.id = id;
        this.nomePassageiro = nomePassageiro;
        this.local = local;
        this.transporte = transporte;
        setStatus(status);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePassageiro() {
        return nomePassageiro;
    }

    public void setNomePassageiro(String nomePassageiro) {
        this.nomePassageiro = nomePassageiro;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }

    public Status getStatus() {
        return Status.valueOf(status);
    }

    public void setStatus(Status status) {
        if (status != null) {
            this.status = status.getCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Viagens viagens = (Viagens) o;
        return Objects.equals(id, viagens.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
