package aplicacao;

import modelo.dao.DaoFactory;
import modelo.dao.SellerDao;
import modelo.entidade.Departament;
import modelo.entidade.Seller;

import java.util.Date;

public class Principal {
    public static void main(String[] args) {
        Departament obj = new Departament(1, "Books");

        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(seller);


    }
}
