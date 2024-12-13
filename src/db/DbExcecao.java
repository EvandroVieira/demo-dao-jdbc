package db;

public class DbExcecao extends RuntimeException {
    public DbExcecao(String msg) {
        super(msg);
    }
}