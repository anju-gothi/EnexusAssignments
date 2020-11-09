package KayakAutomation.com.kayak.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    public void writeinExcel() throws IOException {
        //Create blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //create BlankSheet
        XSSFSheet sheet = workbook.createSheet("TextField");
        //create row
        XSSFRow row=sheet.createRow(1);
        //create ArrayList
        List<String> listOfData = new ArrayList<>();
          listOfData.add("San Jose");
          listOfData.add("Hawaii");
          listOfData.add("November 30");
          listOfData.add("December 30");

        // Create cells
        for(int i = 0; i < 4; i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(listOfData.get(i));
        }

        //Write the workbook in file system
        FileOutputStream file = new FileOutputStream("C:\\Users\\prash\\IdeaProjects\\com.enexus.global\\src\\main\\java\\KayakAutomation\\com\\kayak\\data\\xldata.xlsx");
        workbook.write(file);
        file.close();
    }


    //using XLSX classes
    public List<Object[]> readFile() throws IOException {
        //creating new file instance
        File f = new File("C:\\Users\\prash\\IdeaProjects\\com.enexus.global\\src\\main\\java\\KayakAutomation\\com\\kayak\\data\\xldata.xlsx");
        FileInputStream fs = new FileInputStream(f);
        //creating workbook instance that refer tp .xlsx file
        XSSFWorkbook workbookR = new XSSFWorkbook(fs);
        //creating Sheet object to retrieve the sheet
        XSSFSheet sheet = workbookR.getSheet("TextField");//we can give index too


        //iteration over excel file, Row wise
        String[] st= new String[4];
        Iterator<Row> itr= sheet.iterator();
        List<Object[]> list = new ArrayList<>();
        Object[] obj = new Object[1];
        while(itr.hasNext()){
            Row row= itr.next();
            //declare Object Array that will hold all the cell values in a row

            //iterate through cell in each row
            Iterator<Cell> cell = row.iterator();
            int i=0;
            while(cell.hasNext()){
               st[i]= cell.next().getStringCellValue();
                i++;
              // System.out.println("String read from Excel file:"+st);
            }
            obj=st;
            list.add(obj);
        }

         fs.close();
        return list;
    }
}
