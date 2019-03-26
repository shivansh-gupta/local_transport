package Demo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class driver {

	
		//@SuppressWarnings("resource")
		@SuppressWarnings("resource")
		public static void main(String[] args) throws Exception {
			trainnn obj=new trainnn();
			first12 obj2=new first12();

	        Scanner scan = new Scanner(System.in);
	        String dep=new String();
    		String dest=new String();
    		
	       
	        System.out.println("Enter 1 for local\n 2 for outer");
	        int choice=scan.nextInt();
	       if((choice==1)||(choice==2))
	        {Scanner sc=new Scanner(System.in);
	    		System.out.println("Enter Source:");
	    		dep=sc.nextLine();
	    		System.out.println("Enter Destination:");
	    		dest=sc.nextLine();
	        }

	       
			if(choice==1) {
				obj2.test(dep,dest);
			}
			else if(choice==2) {
			 
				obj.fun(dep,dest);
				}
			else {
					System.out.println("Invalid");
			}
		
		}
	}


