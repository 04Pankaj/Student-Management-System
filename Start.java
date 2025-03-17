package StudentManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

	public static void main(String[] args)throws IOException {
		System.out.println("Welcome to Student Magagement App");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			System.out.println("press 1 to ADD student");
			System.out.println("press 2 to DELETE student");
			System.out.println("press 3 to DISPLAY student");
			System.out.println("press 4 to EXIT");
			int c=Integer.parseInt(br.readLine());
			
			if(c==1)
			{
				//add element
				System.out.println("enter user name :");
				String name=br.readLine();
				
				System.out.println("enter user phone :");
				String phone=br.readLine();
				
				System.out.println("enter user city :");
				String city=br.readLine();
				
				//create student object to store student
				Student st=new Student(name,phone,city);
				boolean answer=StudentDao.insertStudentToDB(st);
				if(answer)
				{
					System.out.println("Student data is added successfully");
				}
				else
				{
					System.out.println("Something went wrong");
				}
				System.out.println(st);
			}
			else if(c==2)
			{
			 //delete
				System.out.println("enter user id to delete :");
				int userId=Integer.parseInt(br.readLine());
				boolean f=StudentDao.deleteStudent(userId);
				if(f)
				{
					System.out.println("Deleted...");
				}else {
					System.out.println("Something went wrong...");
				}
		}
			else if(c==3)
			{
				//dispaly
				StudentDao.showAllStudent();
			}
			else if(c==4)
			{
				//exit
				break;
			}
			else
			{
				
			}
		}
		
           System.out.println("Thankyou for using my application");
           System.out.println("See you soon....bye bye");
	}

}
