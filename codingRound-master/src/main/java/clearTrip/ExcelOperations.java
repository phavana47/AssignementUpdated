package clearTrip;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {
	
	private Workbook workbook;
	
	public ExcelOperations(String excelPath) {
		try {
			File src = new File(excelPath);

			FileInputStream fis = new FileInputStream(src);

			workbook = new XSSFWorkbook(fis);
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private int getColNo(Sheet sheet,String colName) 
	{
		Row row =null;
		int total_rows =sheet.getLastRowNum();
		int colm_no=16380;
		boolean flag=false;
		for (int i=0; i<=total_rows;i++)
		{
			row=sheet.getRow(i);
			for(int j=0;j<=row.getLastCellNum();j++)
			{
				if(row.getCell(j)!=null)
				{
					if(row.getCell(j).toString().trim().equals(colName))
					{
						flag = true;
						colm_no=j;
						break;
					}
				}
			}
			if (flag==true)
			break;
		}
		
		
		return colm_no;
	}
	
	public String getCellContentRowNo(String SheetName, int RowNo, String ColName) throws IOException
	{
		String CellContent = null;
		Sheet sheet=null;
		sheet = workbook.getSheet(SheetName);
		Cell cell  = sheet.getRow(RowNo).getCell(getColNo(sheet,ColName));
		if(cell==null || cell.getCellType() == Cell.CELL_TYPE_BLANK)
		{

			CellContent = "";
		}
		else
		{
			CellContent = cell.toString().trim();
		}
		return CellContent;
		
	}
	

}
