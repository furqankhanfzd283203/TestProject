package com.mindtree.client;

import java.util.Scanner;

import com.mindtree.entity.Student;
import com.mindtree.exception.ApplicationException;
import com.mindtree.service.StudentService;
import com.mindtree.service.StudentServiceImpl;

public class StudentApp {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws ApplicationException {
		StudentService studentService=new StudentServiceImpl();
		int choice=0;
		do{
			System.out.println("1:insert student data");
			System.out.println("2:Display student data by id");
			System.out.println("3:update student name");
			System.out.println("4:delete student data by id");
			System.out.println("5:Exit");
			System.out.println("enter your choice");
			choice=sc.nextInt();
			switch(choice){
			case 1:Student[] students=createStudents();
				boolean isInsert=studentService.insertStudentsIntoDB(students);
				if(isInsert)
					System.out.println("Inserted successfully");
				else
					System.out.println("Inserted got interuppted");
				break;
			case 2:System.out.println("enter id");
			int id=sc.nextByte();
			studentService.displayStudentFromDB(id);
			break;
			case 3:System.out.println("enter id");
			int id1=sc.nextByte();
			System.out.println("enter name to be update");
			String name=sc.next();
			boolean isUpdate=studentService.updateStudentIntoDB(id1,name);
			if(isUpdate)
				System.out.println("Update successfully");
			else
				System.out.println("Update got interuppted");
			break;
			case 4:System.out.println("enter id");
			int id2=sc.nextByte();
			boolean isDelete=studentService.deleteStudentFromDB(id2);
			if(isDelete)
				System.out.println("Delete successfully");
			else
				System.out.println("Delete got interuppted");
			break;
			case 5:System.out.println("you are Exit");
			break;
			default:System.out.println("you enter invalid choice");
			}
		}while(choice!=5);

	}
	private static Student[] createStudents(){
		System.out.println("How many student data you want to insert");
		byte input=sc.nextByte();
		Student[] students=new Student[input];
		for(int i=0;i<students.length;i++){
			System.out.println("enter id");
			byte id=sc.nextByte();
			System.out.println("enter name");
			String name=sc.next();
			System.out.println("enter roll number");
			byte rollNumber=sc.nextByte();
			students[i]=new Student(id,name,rollNumber);
		}
		return students;
	}

}
