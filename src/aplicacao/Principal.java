package aplicacao;

import modelo.dao.DaoFactory;
import modelo.dao.SellerDao;
import modelo.entidade.Department;
import modelo.entidade.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Test #1: seller findById");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== Test #2: seller findByDepartment");
        Department departament = new Department(2, null);
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

        System.out.println("\n=== Test #6: seller delete");
        System.out.println("Entre com ID para delete: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completo!");

        sc.close();
    }
}
