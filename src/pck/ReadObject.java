package pck;

import java.io.File ; 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ReadObject {
	
	public static void read() {
		//Student List 
		File file = new File("student_list.bin");
	    try {
	        if (file.createNewFile() ||  (file.length() == 0) ) {General_List.initData();} 
	        else {
	            FileInputStream fi = new FileInputStream(file); 
	            ObjectInputStream os = new ObjectInputStream(fi); 
	            ArrayList<Student> readObject = (ArrayList<Student>) os.readObject();
	            General_List.student_list = readObject; 
	            os.close();
	       }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    

		
		
		//lecture_education

		
        File file2 = new File("lecture_education.bin");
	    try {
	        if (file2.createNewFile() || (file2.length() == 0)) {
	     
	        } else {
	        	
	            FileInputStream fi = new FileInputStream(file2); 
	            ObjectInputStream os = new ObjectInputStream(fi); 
	            HashMap<Lecture,ArrayList<Education>> readObject = (HashMap<Lecture,ArrayList<Education>>) os.readObject();
	            General_List.lecture_education = readObject; 
	            os.close();
	       }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
			
			//List lecture
	 
			File file3 = new File("list_lecture.bin");
	    try {
	        if (file3.createNewFile() || (file3.length() == 0)) {
	     
	        } else {
	        	
	            FileInputStream fi = new FileInputStream(file3); 
	            ObjectInputStream os = new ObjectInputStream(fi); 
	            ArrayList<Lecture> readObject = (ArrayList<Lecture>) os.readObject();
	            General_List.list_lecture = readObject; 
	            os.close();
	       }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
		    
			//List education
	   
			File file4 = new File("list_education.bin");
	    try {
	        if (file4.createNewFile() || (file4.length() == 0)) {
	     
	        } else {
	        	
	            FileInputStream fi = new FileInputStream(file4); 
	            ObjectInputStream os = new ObjectInputStream(fi); 
	            ArrayList<Education>  readObject = (ArrayList<Education> ) os.readObject();
	            General_List.list_education = readObject; 
	            os.close();
	       }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    
			//List education student
			File file5 = new File("list_education_student.bin");
	    try {
	        if (file5.createNewFile() || (file5.length() == 0)) {
	     
	        } else {
	        	
	            FileInputStream fi = new FileInputStream(file5); 
	            ObjectInputStream os = new ObjectInputStream(fi); 
	            HashMap<Education, ArrayList<Student>>readObject = (HashMap<Education, ArrayList<Student>>) os.readObject();
	            General_List.list_education_student = readObject; 
	            os.close();
	       }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    
	    
			//Teacher 	
			File file6 = new File("teacher.bin");
	    try {
	        if (file6.createNewFile() || (file6.length() == 0)) {
	     
	        } else {
	        	
	            FileInputStream fi = new FileInputStream(file6); 
	            ObjectInputStream os = new ObjectInputStream(fi); 
	            Teacher readObject = (Teacher) os.readObject();
	            General_List.teacher = readObject; 
	            os.close();
	       }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
			//project_pair
	    
			File file7 = new File("project_pair.bin");
	    try {
	        if (file7.createNewFile() || (file7.length() == 0)) {
	     
	        } else {
	        	
	            FileInputStream fi = new FileInputStream(file7); 
	            ObjectInputStream os = new ObjectInputStream(fi); 
	            HashMap<Project, ArrayList<Pair>> readObject = (HashMap<Project, ArrayList<Pair>>) os.readObject();
	            General_List.project_pair = readObject; 
	            os.close();
	       }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
			 
		
	    }
	   
	        

	        
}
	
	
    

