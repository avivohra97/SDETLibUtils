import org.apache.poi.ss.usermodel.Row;
import org.example.ExcelUtil;

import java.io.IOException;

public class RunnerExcelPoi {
    public static void main(String[] args) throws IOException {
        ExcelUtil excelUtil = new ExcelUtil(System.getProperty("user.dir")+"/Book.xlsx");
        excelUtil.ColumnDictionary();
        int rc = excelUtil.getWrksheet().getLastRowNum();
        System.out.println("rc :"+rc);
        for(int i = 0;i<=rc;i++){
            Row currRow = excelUtil.getWrksheet().getRow(i);
            System.out.println("on row :"+i);
            int col = currRow.getLastCellNum();
            System.out.println("last col num is "+col);
            for(int j =0;j<col;j++){


                if(j == 2 && i != 0){
                    System.out.print(excelUtil.getWrksheet().getRow(i).getCell(j).getBooleanCellValue()+"  ");
                }else{
                    System.out.print(excelUtil.ReadCell(j,i)+"  ");
                }
            }
            System.out.println();
        }

    }
}
