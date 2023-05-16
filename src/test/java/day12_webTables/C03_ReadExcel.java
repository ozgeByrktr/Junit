package day12_webTables;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {

@Test
    public void test01() throws IOException {

        String dosyaYolu=System.getProperty("user.dir")+"/src/test/java/day12_webTables/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);
        Sheet sheet= workbook.getSheet("Sayfa1");
        Row row= sheet.getRow(1);   //index 0 'dan basliyor
        Cell cell= row.getCell(3);      //index 0'dan basliyor
        System.out.println(cell);
        row= sheet.getRow(5);
        cell= row.getCell(1);
        String expectedData="Luanda";

        Assert.assertEquals(expectedData,cell.toString());

        String actualData=sheet.getRow(11).getCell(1).toString();
         expectedData="Baku";
        Assert.assertEquals(expectedData,actualData);

    }
}
