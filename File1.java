package Demo;

import java.io.File;
import java.util.Scanner; 

import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class File1 {
	void fun() throws Exception {
        File source=new File("C:\\Users\\shivansh\\Desktop\\ROUTES.xls");
		DataFormatter df = new DataFormatter();
		FileInputStream input=new FileInputStream(source);
		@SuppressWarnings("resource")
		HSSFWorkbook wb=new HSSFWorkbook(input);
		HSSFSheet sheet=wb.getSheetAt(2);
		String dep;
		String dest;
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Source:");
		dep=sc.nextLine();
		System.out.println("Enter Destination:");
		dest=sc.nextLine();
		
		System.out.println("-----------");
		
		System.out.println("Code\tSource\tDestination\tTrain\t\tFare\tTimings");
		int totalrows=sheet.getLastRowNum();
		
		for(int i=1;i<=totalrows;i++) {
		 
		HSSFCell result23=sheet.getRow(i).getCell(2);
		HSSFCell result24=sheet.getRow(i).getCell(3);
		String str=df.formatCellValue(result23);
		String str2=df.formatCellValue(result24);
		if (dep.equalsIgnoreCase(str)&& dest.equalsIgnoreCase(str2))  {
			for(int j=1;j<=6;j++) {
			HSSFCell text=sheet.getRow(i).getCell(j);
			String str3=df.formatCellValue(text);
			System.out.print(str3+"\t");
			
			}
			System.out.println();
		}}

		
	}

	public static void main(String[] args) throws Exception {
	
		
	
	}
	

}
