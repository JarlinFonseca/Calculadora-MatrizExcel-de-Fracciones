/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import util.Matriz_Excel;
import modelo.MatrizFraccion;
/**
 *
 * @author madarme
 */
public class PruebaConsola_Excel {
    
    
    public static void main(String args[]) throws Exception
    {
        
        pruebaLeerExcel();
        pruebaLeerMatrizFraccionarios();     
        pruebaLeerMatrizFraccionarios2();
        
    
    }
    
    
    private static void pruebaLeerMatrizFraccionarios() throws Exception
    {
    System.out.println("********************  Leyendo archivo data.xls en una matriz de Fracciones hoja1 ***********************");
     Matriz_Excel mm=new Matriz_Excel("data.xls");
    
     //Creando la matriz de fracciones a partir de la matriz de String
     String matriz[][]=mm.leerExcel(0);

     MatrizFraccion fracciones=new MatrizFraccion(matriz);
    
     //Imprimir matriz Resultante usandola información que retorna el método toString()
     System.out.println(fracciones.toString());
     System.out.println("**********************************************************************************************");
     }
    
    
    private static void pruebaLeerExcel() throws Exception
    {
        
    System.out.println("********************  Leyendo archivo data.xls en una matriz de String hoja1  ***********************");
     Matriz_Excel mm=new Matriz_Excel("data.xls");
     String matrizResultante[][]=mm.leerExcel(0);

    imprimirMatrizString(matrizResultante);

     System.out.println("**********************************************************************************************");
  }
    
    private static void pruebaLeerMatrizFraccionarios2() throws Exception
    {
    System.out.println("********************  Leyendo archivo data.xls en una matriz de Fracciones hoja2 ***********************");
     Matriz_Excel mm=new Matriz_Excel("data.xls");
    
     //Creando la matriz de fracciones a partir de la matriz de String
     String matriz[][]=mm.leerExcel(1);

     MatrizFraccion fracciones=new MatrizFraccion(matriz);
    
     //Imprimir matriz Resultante usandola información que retorna el método toString()
     System.out.println(fracciones.toString());
     System.out.println("**********************************************************************************************");
     }
    
    
    private static void pruebaLeerExcel2() throws Exception
    {
        
    System.out.println("********************  Leyendo archivo data.xls en una matriz de String hoja2 ***********************");
     Matriz_Excel mm=new Matriz_Excel("data.xls");
     String matrizResultante[][]=mm.leerExcel(1);

    imprimirMatrizString(matrizResultante);

     System.out.println("**********************************************************************************************");
  }
    
    
    private static void imprimirMatrizString(String m[][])
    {
     for (String fila[]:m)
    {
        for(String datoColumna: fila)
        {
            System.out.print(datoColumna+"\t");
        }
     System.out.println();
    }
        
    }
    
    
}
