package com.github.tutorial.hashcodeequals;

import java.util.ArrayList;
import java.util.List;

import com.github.tutorial.model.Dept;
import com.github.tutorial.model.Emp;
import com.github.tutorial.model.Sal;
import com.github.tutorial.model.SubDept;

public class HashCodeEqualMain {

	public static void main(String[] args) {		
		new HashCodeEqualMain();
	}

	public HashCodeEqualMain() {
//		EmpTest();
//		DeptTest();
//		SalTest();
		SubDeptTest();
	}
	
	public void EmpTest() {
		Emp a = new Emp();
		a.setEmpId(1L);
		Emp b = new Emp();
		b.setEmpId(2L);
		System.out.println(a.equals(b));
		
		b.setEmpId(1L);
		System.out.println(a.equals(b));
		
		b.setRefPosition((byte) 1);
		System.out.println(a.equals(b));
		
		a.setEmpId(null);
		System.out.println(a.equals(b));
		
		b.setEmpId(null);
		b.setRefPosition(null);
		System.out.println(a.equals(b));
		
		//toString
		System.out.println(a.toString());
	}

	public void DeptTest() {
		Dept a = new Dept();
		Dept b = new Dept();
		a.setId(1L);
		b.setId(2L);
		System.out.println(a.equals(b));

		b.setId(1L);
		System.out.println(a.equals(b));
		
		List<Dept> dList = new ArrayList<Dept>();
		dList.add(a);
		System.out.println(dList.contains(new Dept(1L)));
		
		b.setDesc("b");
		System.out.println(a.equals(b));
		
		a.setDesc("b");
		System.out.println(a.equals(b));
		
		a.setAlive(true);
		System.out.println(a.equals(b));
	}
	
	public void SalTest() {
		Sal a = new Sal(1L, 10.0);
		Sal b = new Sal(2L, 10.0);
		System.out.println(a.equals(b));
	
		Sal c = new Sal(1L, 10.0);
		System.out.println(a.equals(c));
		
	}
	
	public void SubDeptTest() {
		SubDept a = new SubDept();
		SubDept b = new SubDept();
		a.setId(1L);
		b.setId(1L);
		System.out.println(a.equals(b));

		b.setId(2L);
		System.out.println(a.equals(b));
		
		a.setSubName("subA");
		System.out.println(a.equals(b));
		
		b.setSubName("subA");
		System.out.println(a.equals(b));
		
		b.setDesc("descB");
		System.out.println(a.equals(b));

		b.setSubName("subB");
		System.out.println(a.equals(b));

		b.setDesc(null);
		System.out.println(a.equals(b));
		
	}
}
