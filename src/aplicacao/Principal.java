package aplicacao;

import db.DB;

import java.sql.Connection;

public class Principal {
    public static void main(String[] args) {
        Connection conn = DB.getConnection();
        DB.closeConnection();
    }
}
