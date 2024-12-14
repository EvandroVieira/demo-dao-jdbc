package aplicacao;

import modelo.dao.DaoFactory;
import modelo.dao.SellerDao;
import modelo.entidade.Departament;
import modelo.entidade.Seller;

import java.util.Date;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Test #1: seller findById");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== Test #2: seller findByDepartment");
        Departament departament = new Departament(2, null);
        List<Seller> list = sellerDao.findByDepartment(departament);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== Test #3: seller findAll");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n=== Test #4: seller insert");
        Seller newseller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, departament);
        sellerDao.insert(newseller);
        System.out.println("Inserido! Novo Id = " + newseller.getId());
    }
}
