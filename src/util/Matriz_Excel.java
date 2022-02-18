/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import matriz_excel_ejemplo.*;
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
public class Matriz_Excel {

    private String nombreArchivo;

    public Matriz_Excel() {
    }

    public Matriz_Excel(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String[][] leerExcel(int x) throws Exception {

        try {
            HSSFWorkbook archivoExcel = new HSSFWorkbook(new FileInputStream(this.nombreArchivo));
            //Obtiene la hoja 1
            HSSFSheet hoja = archivoExcel.getSheetAt(x);
            //Obtiene el número de la última fila con datos de la hoja.
            int canFilas = hoja.getLastRowNum() + 1;
            //Se crea la matriz con la cantidad de filas de la matriz en excel
            String[][] m = new String[canFilas][];
            for (int i = 0; i < canFilas; i++) {
                //Obtiene el índice de la última celda contenida en esta fila MÁS UNO.
                HSSFRow filas = hoja.getRow(i);
                //Obtiene la cantidad de colomunas de esa fila

                int cantCol = filas.getLastCellNum();
                //Por cada fila se crea la cantidad de columnas
                m[i] = new String[cantCol];
                for (int j = 0; j < cantCol; j++) {

                    m[i][j] = filas.getCell(j).getStringCellValue();

                }

            }
            return m;

        } catch (java.lang.NullPointerException e) {
            throw new Exception("La hoja " + (++x) + " esta vacia");
        } catch (java.lang.IllegalStateException a) {
            throw new Exception("No puede obtener un valor String de una celda Numeria");

        }
                    

    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

}
