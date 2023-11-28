package pck;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;




public class WriteObject {
	
	public static void write() {
		//Student List 
			try {
				FileOutputStream fi = new FileOutputStream("student_list.bin") ; 
		        ObjectOutputStream os = new ObjectOutputStream(fi); 
		        os.writeObject(General_List.student_list);
		        os.close() ; 
     
		        } catch (FileNotFoundException e) {
		        		// TODO Auto-generated catch block
		        		e.printStackTrace();
		        } catch (IOException e) {
		        		// TODO Auto-generated catch block
		        		e.printStackTrace();
		        }
			
			//lecture education
			try {
				FileOutputStream fi = new FileOutputStream("lecture_education.bin") ; 
		        ObjectOutputStream os = new ObjectOutputStream(fi); 
		        os.writeObject(General_List.lecture_education);
		        os.close() ; 
     
		        } catch (FileNotFoundException e) {
		        		// TODO Auto-generated catch block
		        		e.printStackTrace();
		        } catch (IOException e) {
		        		// TODO Auto-generated catch block
		        		e.printStackTrace();
		        }
			
			//list lecture
			try {
				FileOutputStream fi = new FileOutputStream("list_lecture.bin") ; 
		        ObjectOutputStream os = new ObjectOutputStream(fi); 
		        os.writeObject(General_List.list_lecture);
		        os.close() ; 
     
		        } catch (FileNotFoundException e) {
		        		// TODO Auto-generated catch block
		        		e.printStackTrace();
		        } catch (IOException e) {
		        		// TODO Auto-generated catch block
		        		e.printStackTrace();
		        }
			
			
			//list education
			try {
				FileOutputStream fi = new FileOutputStream("list_education.bin") ; 
		        ObjectOutputStream os = new ObjectOutputStream(fi); 
		        os.writeObject(General_List.list_education);
		        os.close() ; 
     
		        } catch (FileNotFoundException e) {
		        		// TODO Auto-generated catch block
		        		e.printStackTrace();
		        } catch (IOException e) {
		        		// TODO Auto-generated catch block
		        		e.printStackTrace();
		        }
			
			//list_education_student
			try {
				FileOutputStream fi = new FileOutputStream("list_education_student.bin") ; 
		        ObjectOutputStream os = new ObjectOutputStream(fi); 
		        os.writeObject(General_List.list_education_student);
		        os.close() ; 
     
		        } catch (FileNotFoundException e) {
		        		// TODO Auto-generated catch block
		        		e.printStackTrace();
		        } catch (IOException e) {
		        		// TODO Auto-generated catch block
		        		e.printStackTrace();
		        }
			
			
			//teacher
			try {
				FileOutputStream fi = new FileOutputStream("teacher.bin") ; 
		        ObjectOutputStream os = new ObjectOutputStream(fi); 
		        os.writeObject(General_List.teacher);
		        os.close() ; 
     
		        } catch (FileNotFoundException e) {
		        		// TODO Auto-generated catch block
		        		e.printStackTrace();
		        } catch (IOException e) {
		        		// TODO Auto-generated catch block
		        		e.printStackTrace();
		        }
			
			
			//project pair 
			try {
				FileOutputStream fi = new FileOutputStream("project_pair.bin") ; 
		        ObjectOutputStream os = new ObjectOutputStream(fi); 
		        os.writeObject(General_List.project_pair);
		        os.close() ; 
     
		        } catch (FileNotFoundException e) {
		        		// TODO Auto-generated catch block
		        		e.printStackTrace();
		        } catch (IOException e) {
		        		// TODO Auto-generated catch block
		        		e.printStackTrace();
		        }
			
	}
			
			
		
		
		
		
}
