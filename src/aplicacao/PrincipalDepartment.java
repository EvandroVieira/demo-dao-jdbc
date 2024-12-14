package aplicacao;

import modelo.dao.DaoFactory;
import modelo.dao.DepartmentDao;
import modelo.entidade.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalDepartment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test #1: department insert");
        Department department = new Department(null, "Food");
        departmentDao.insert(department);
        System.out.println("Inserido! Novo Id = " + department.getId());

        System.out.println("=== Test #2: department findById");
        System.out.print("Informe o ID para pesquisa: ");
        int id = sc.nextInt();
        department = departmentDao.findById(id);
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

        System.out.println("\n=== Test #4: department Delete");
        System.out.print("Informe o ID para deletar: ");
        id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Departamento deletado!");

        System.out.println("\n=== Test #5: department findAll");
        List<Department> departments = departmentDao.findAll();
        for (Department dep : departments) {
            System.out.println(dep);
        }

        sc.close();
    }
}
