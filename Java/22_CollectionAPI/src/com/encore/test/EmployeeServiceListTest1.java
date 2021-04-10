package com.encore.test;

import java.util.ArrayList;

import com.encore.service.impl.EmployeeListServiceImpl;
import com.encore.vo.Employee;
import com.encore.vo.Engineer;
import com.encore.vo.Manager;

public class EmployeeServiceListTest1 {

	public static void main(String[] args) {
		//1. Service ������ ��ü�� �ϳ� �޾ƿ´�..
		EmployeeListServiceImpl service = EmployeeListServiceImpl.getInstance();
				
		//2. method�� ���� ȣ��..
		System.out.println("======================== 1. add ================================== ");
		Manager m1 = new Manager("111", "��ȣ��", "��赿", 500, "���ߺ�");
		Manager m2 =new Manager("222", "�̼���", "���ǵ�", 400, "������");
		Manager m3 =new Manager("333", "������", "��赿", 600, "���ߺ�");
				
		Engineer eg1 = new Engineer("444", "����ö", "�Ŵ�浿", 450, "Python", 100);
		Engineer eg2 =new Engineer("555", "�̻��", "���¿�", 500, "JS", 300);
				
		service.addEmployee(m1);
		service.addEmployee(m2);		
		service.addEmployee(m3);
		service.addEmployee(eg1);
		service.addEmployee(eg2);
		//service.addEmployee(m3);
				
		service.findEmployees();
				
		System.out.println("======================== 2. delete ================================== ");
		service.deleteEmployee("222");
		
		service.findEmployees();
		
		ArrayList<Employee> returnEmp = service.findEmployees("��赿");
		for(Employee e : returnEmp) {
			if(e==null) continue;
			System.out.println(e);
		}
			
		System.out.println("========================");


	}

}