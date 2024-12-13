package modelo.entidade;

import java.io.Serializable;
import java.util.Objects;

public class Departamento implements Serializable {
    private Integer id;
    private String name;

    public Departamento() {}

    public Departamento(Integer id, String nome) {
        this.id = id;
        this.name = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}