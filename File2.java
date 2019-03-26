package Demo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

public class File2 {
	void test() throws Exception {
        @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		 File source=new File("C:\\Users\\shivansh\\Desktop\\ROUTES.xls");
	        FileInputStream input=new FileInputStream(source);
			@SuppressWarnings("resource")
			HSSFWorkbook wb=new HSSFWorkbook(input);
			DataFormatter df = new DataFormatter();
			HSSFSheet sheet_o=wb.getSheetAt(0);  
			HSSFSheet sheet=wb.getSheetAt(1);  
			int totalrows=sheet.getLastRowNum();
	        int[][] cost=new int[9][9];
			 int i,j,n,startnode = 0;
		       	n= totalrows+1;
				
				for(i=0;i<n;i++) {
					for(j=0;j<n;j++) {
						HSSFCell result=sheet.getRow(i).getCell(j);
						int res=(int)(result.getNumericCellValue());

						cost[i][j]=res;
						
					}
						
				}
				int dest =0;
				System.out.println("Enter the starting node:");
				String start=scan.nextLine();
				System.out.println("Enter the dest node:");
				String last=scan.nextLine();
				
					
				for(i=0;i<n;i++) {
					HSSFCell ter=sheet_o.getRow(i+1).getCell(0);
					String sdf=df.formatCellValue(ter);
					if(sdf.equalsIgnoreCase(start)) {
						startnode=i;
					}

				}
				for(i=0;i<n;i++) {
					HSSFCell ter2=sheet_o.getRow(0).getCell(i+1);
					String sdf2=df.formatCellValue(ter2);
					if(sdf2.equalsIgnoreCase(last)) {
						dest=i;
					}

				}
				HSSFCell result4=sheet_o.getRow(0).getCell(startnode+1);

				HSSFCell result3=sheet_o.getRow(dest+1).getCell(0);
				String str3=df.formatCellValue(result3);
				int [] distance=new int[totalrows+1];
				int [] pred=new int [totalrows+1];
				int [] visited= new int[totalrows+1];		
				int count,mindistance,nextnode=0,a,b;
				 for(a=0;a<n;a++)
				        for(b=0;b<n;b++)
				            if(cost[a][b]==0)
				                cost[a][b]= 999;
				            
				    
				
				
				 for(i=0;i<n;i++)
				    {
				        distance[i]=cost[startnode][i];
				        pred[i]=startnode;
				        visited[i]=0;
				    }
				 
				 distance[startnode]=0;
				 visited[startnode]=1;
				 count=1;
				 while(count<n-1)
				    {
				        mindistance=999;
				        
				        //nextnode gives the node at minimum distance
				        for(i=0;i<n;i++)
				            if(distance[i]<mindistance&& visited[i]!=1)
				            {
				                mindistance=distance[i];
				                nextnode=i;
				               
				            }
				            
				            visited[nextnode]=1;
				            for(i=0;i<n;i++)
				                if(visited[i]!=1)
				                    if(mindistance+cost[nextnode][i]<distance[i])
				                    {
				                        distance[i]=mindistance+cost[nextnode][i];
				                        pred[i]=nextnode;
				                    }
				        count++;
				    }
		      
				 String[] arr= new String[n];
				 int k =0;
				 arr[k]=str3;
				 k=1;
				 for(i=0;i<n;i++) {
				        if(i!=startnode)
				        {
				        	if(i==dest) {
				        		

				            System.out.print("\nDistance of "+ str3 + " from " + result4 + " = "+distance[i]+" km");
				            System.out.print("\nFare= Rs." + (distance[i]* 5)+"(Rs.5/km)");
				            System.out.print("\nPath=");
				            
			    	//		System.out.print(str3);
				            j=i;
				            do
				            {
				                j=pred[j];
				                
				            	//System.out.print(" <- ");
				                HSSFCell result2=sheet_o.getRow(j+1).getCell(0);
				    			String str2=df.formatCellValue(result2);
				    		arr[k]=str2;
				    		k++;
				    	//		System.out.print(str2);
				            }while(j!=startnode);
				           
				    }}}
				// System.out.println();
				 for(i=k-1;i>=0;i--) {
					 System.out.print("-> " +arr[i]);
				 }
				 
			
			
			}

		}
