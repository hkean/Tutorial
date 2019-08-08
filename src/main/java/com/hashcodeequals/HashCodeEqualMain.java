package com.hashcodeequals;

import java.util.ArrayList;
import java.util.List;

import com.model.Dept;
import com.model.Emp;
import com.model.Sal;
import com.model.SubDept;

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
		a.setId(1L);
		Emp b = new Emp();
		b.setId(2L);
		System.out.println(a.equals(b));
		
		b.setId(1L);
		System.out.println(a.equals(b));
		
		b.setA((byte) 1);
		System.out.println(a.equals(b));
		
		a.setId(null);
		System.out.println(a.equals(b));
		
		b.setId(null);
		b.setA(null);
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
