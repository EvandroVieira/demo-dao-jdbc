package aplicacao;

import modelo.dao.DaoFactory;
import modelo.dao.DepartmentDao;
import modelo.entidade.Departament;

import java.util.Scanner;

public class PrincipalDepartment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test #1: department insert");
        Departament departament = new Departament(null, "Food");
        departmentDao.insert(departament);
        System.out.println("Inserido! Novo Id = " + departament.getId());

        sc.close();
    }
}
