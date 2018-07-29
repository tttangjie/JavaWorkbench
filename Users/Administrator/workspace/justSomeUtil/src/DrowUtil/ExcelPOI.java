package DrowUtil;  
  
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
  
// ��дxlsx�ļ�
public class ExcelPOI {  
  
  public static void main( String[] args) throws IOException {  
    ExcelPOI xlsxMain = new ExcelPOI();  
      
    xlsxMain.readXlsx();  
  }  
  
  private void readXlsx() throws IOException{  
    String fileName = "C:\\ytcj.xlsx";  
    XSSFWorkbook xssfWorkbook = new XSSFWorkbook( fileName);  
      
    // ѭ��������Sheet  
    for(int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++){  
      XSSFSheet xssfSheet = xssfWorkbook.getSheetAt( numSheet);  
      if(xssfSheet == null){  
        continue;  
      }  
        
      // ѭ����Row   
      for(int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++ ){  
        XSSFRow xssfRow = xssfSheet.getRow( rowNum);  
        if(xssfRow == null){  
          continue;  
        }  
          
        // ѭ����Cell     
        for(int cellNum = 0; cellNum <= xssfRow.getLastCellNum(); cellNum++){  
          XSSFCell xssfCell = xssfRow.getCell( cellNum);  
          if(xssfCell == null){  
            continue;  
          }  
          System.out.print("   "+getValue(xssfCell));  
        }  
        System.out.println();  
      }  
    }  
  }  
    
  @SuppressWarnings({ "static-access", "deprecation" })  
  private String getValue(XSSFCell xssfCell){  
    if(xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN){  
      return String.valueOf( xssfCell.getBooleanCellValue());  
    }else if(xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC){  
      return String.valueOf( xssfCell.getNumericCellValue());  
    }else{  
      return String.valueOf( xssfCell.getStringCellValue());  
    }  
  }
  // ��ȡxls�ļ�
  private void readXls() throws IOException{  
	    InputStream is = new FileInputStream( "D:\\excel\\xls_test2.xls");  
	    HSSFWorkbook hssfWorkbook = new HSSFWorkbook( is);   
	      
	    // ѭ��������Sheet  
	    for(int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++){  
	      HSSFSheet hssfSheet = hssfWorkbook.getSheetAt( numSheet);  
	      if(hssfSheet == null){  
	        continue;  
	      }  
	        
	      // ѭ����Row   
	      for(int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++){  
	        HSSFRow hssfRow = hssfSheet.getRow( rowNum);  
	        if(hssfRow == null){  
	          continue;  
	        }  
	          
	        // ѭ����Cell    
	        for(int cellNum = 0; cellNum <= hssfRow.getLastCellNum(); cellNum++){  
	          HSSFCell hssfCell = hssfRow.getCell( cellNum);  
	          if(hssfCell == null){  
	            continue;  
	          }  
	            
	          System.out.print("    " + getValue( hssfCell));  
	        }  
	        System.out.println();  
	      }  
	    }  
	  }  
	    
	  @SuppressWarnings("static-access")  
	  private String getValue(HSSFCell hssfCell){  
	    if(hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN){  
	      return String.valueOf( hssfCell.getBooleanCellValue());  
	    }else if(hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC){  
	      return String.valueOf( hssfCell.getNumericCellValue());  
	    }else{  
	      return String.valueOf( hssfCell.getStringCellValue());  
	    }  
	  }  
	  
	 
	 
 
}  