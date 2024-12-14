package aplicacao;

import modelo.dao.DaoFactory;
import modelo.dao.SellerDao;
import modelo.entidade.Seller;

import java.util.Date;

public class Principal {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Test #1: seller findById");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
    }
}
