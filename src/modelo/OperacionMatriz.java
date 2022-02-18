/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public interface OperacionMatriz<T> {
    /*
    Retorna la matriz transpuesta de la matriz origen. Debe crear una matriz nueva.
    */
    public String getTranspuesta()throws Exception;
    /*
    Simplifica cada elemento de la matriz. Este proceso se realiza sobre la matriz original.
    */
    public String getMatrizSimplificada();
    /*
    Realiza la multiplicación de matrices, el resultado es almacenado en una matriz resultante
    */
    public String getMultiplicación(T matriz)throws Exception;
}