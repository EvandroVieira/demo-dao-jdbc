package aplicacao;

import modelo.dao.DaoFactory;
import modelo.dao.DepartmentDao;
import modelo.entidade.Department;

import java.util.Scanner;

public class PrincipalDepartment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        /*
        System.out.println("=== Test #1: department insert");
        Department department = new Department(null, "Food");
        departmentDao.insert(department);
        System.out.println("Inserido! Novo Id = " + department.getId());*/

        System.out.println("=== Test #2: department findById");
        System.out.print("Informe o ID para pesquisa: ");
        int id = sc.nextInt();
        Department department = departmentDao.findById(id);
        System.out.println(department);

        System.out.println("\n=== Test #3: department Update");
        System.out.print("Informe o ID para atualização: ");
        id = sc.nextInt();
        sc.nextLine();
        department = departmentDao.findById(id);
        System.out.println(department);
        System.out.print("Informe o NOME para atualização: ");
        String name = sc.nextLine();
        department.setName(name);
        departmentDao.update(department);
        System.out.println("Departamento atualizado!");
        department = departmentDao.findById(id);
        System.out.println(department);

        sc.close();
    }
}
