/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author JARLIN Y NATALIA
 */


import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;


public class generarPDF{
    public generarPDF(String cadena, String name){
    Document pdf = new Document();
    
    try{
        
    PdfWriter.getInstance(pdf,new FileOutputStream(name+".pdf"));
    pdf.open();
    Paragraph parrafo=new Paragraph(cadena);
    
    pdf.add(parrafo);
    pdf.close();
    Desktop.getDesktop().open(new File(name+".pdf"));
     }catch(Exception e){
    
     }
    }
}
