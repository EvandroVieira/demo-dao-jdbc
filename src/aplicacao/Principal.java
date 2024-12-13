package aplicacao;

import db.DB;
import modelo.entidade.Departamento;

import java.sql.Connection;

public class Principal {
    public static void main(String[] args) {
        Departamento obj = new Departamento(1, "Books");
        System.out.println(obj);
    }
}
