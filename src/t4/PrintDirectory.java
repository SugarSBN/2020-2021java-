package t4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/***********************************************************
 * @author SuBonan
 * 2020年11月10日
 * ProgrammingHomework.t4.PrintDirectory.java
 ***********************************************************/

public class PrintDirectory {
	public static void printFile(File file,int tab) {
        try{
			if (!file.exists() || file == null)   System.out.println("please enter a valid directory"); 
	        else {
	            File[] fileLists = file.listFiles();
	            for (int i = 0; i < fileLists.length; i++) {
	                for (int j = 1; j < tab; j++)       System.out.print("\t");            
	                System.out.println("<" + (fileLists[i].isDirectory() ? "d" : "f") + ">" + fileLists[i].getName());              	                
	                if (fileLists[i].isDirectory())  printFile(fileLists[i],tab + 1);   
	            }
	        }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args) throws IOException {
		Scanner ipt = new Scanner(System.in);
		String directory = ipt.nextLine();
		
	/*	File file = new File("out.txt");  
        file.createNewFile();  
        FileOutputStream fileOutputStream = new FileOutputStream(file);  
        PrintStream printStream = new PrintStream(fileOutputStream);  
        System.setOut(printStream);  */
        
	    printFile(new File(directory),1);
	    ipt.close();
	}
}
