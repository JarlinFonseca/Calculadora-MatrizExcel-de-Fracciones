/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz_excel_ejemplo;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author madarme
 */
public class Matriz_Excel_Ejemplo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        leerExcel();
    }
    
    
     private static void leerExcel() throws Exception {
        HSSFWorkbook archivoExcel = new HSSFWorkbook(new FileInputStream("data.xls"));
        //Obtiene la hoja 1
        HSSFSheet hoja = archivoExcel.getSheetAt(0);
        //Obtiene el número de la última fila con datos de la hoja.
        int canFilas = hoja.getLastRowNum()+1;
        System.out.println("Filas:"+canFilas);
        for (int i = 0; i < canFilas; i++) {
            //Obtiene el índice de la última celda contenida en esta fila MÁS UNO.
            HSSFRow filas = hoja.getRow(i);
            //Obtiene la cantidad de colomunas de esa fila
            int cantCol=filas.getLastCellNum();
            
        for(int j=0;j<cantCol;j++)    
        {
            //Obtiene la celda y su valor respectivo
            //double r=filas.getCell(i).getNumericCellValue();
            String valor=filas.getCell(j).getStringCellValue();
            System.out.print(valor+"\t");
        }
     System.out.println();
       }
    }
    
    
    
}
