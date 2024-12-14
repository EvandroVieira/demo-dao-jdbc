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

        System.out.println("\n=== Test #5: seller update");
        seller = sellerDao.findById(1);
        System.out.println("Nome antes do Update = " + seller.getName());
        seller.setName("Marta Waine");
        sellerDao.update(seller);
        System.out.println("Update completo!");
        seller = sellerDao.findById(1);
        System.out.println("Nome após o Update = " + seller.getName());
    }
}
