/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class MatrizFraccion implements OperacionMatriz {

    private Fraccion m[][];

    public MatrizFraccion() {
    }

    public MatrizFraccion(String fracciones_excel[][]) throws Exception {
        try {
            //Crear la matriz con el tamaño de las filas fracciones_excel, se deja el espacio en blanco para el espacio de las columnas:
            this.m = new Fraccion[fracciones_excel.length][];
            for (int i = 0; i < this.m.length; i++) {
                //Para cada fila de fracciones_excel se debe obtener la cantidad de columnas para esa fila "i" y se crea las columnas:
                int cantColumnas = fracciones_excel[i].length;
                this.m[i] = new Fraccion[cantColumnas];
                /*
     Iterar para almacenar en cada columna una fracción,
    para este paso es necesario que utilice el método split de la clase String, esté método parte la cadena por un carácter
    de tal forma que:
        String algo="3/4";
        String partes[]=algo.split("/");
       El resultado sería un vector de dos posiciones:  partes={"3", "4"};
                 */
                for (int j = 0; j < cantColumnas; j++) {
                    String parteFraccion[] = fracciones_excel[i][j].split("/");
                    //Convertir cada parte de la cadena a su correspondiente entero (Envoltorio):

                    int numerador = Integer.parseInt(parteFraccion[0]);
                    int denominador = Integer.parseInt(parteFraccion[1]);

                    //Crear el objeto fraccción:
                    Fraccion nuevaFraccion = new Fraccion(numerador, denominador);
                    //Insertar esa nueva fracción a la matriz de fracciones:
                    this.m[i][j] = nuevaFraccion;

                }

            }

        } catch (java.lang.NumberFormatException a) {
            throw new Exception("La hoja excel tiene celdas vacias");

        }
    }

    @Override
    public String toString() {
        String msg = "";
        for (Fraccion fila[] : this.m) {
            for (Fraccion myF : fila) {
                msg += myF.toString() + "\t ";
            }
            msg += "\n";
        }

        return msg;

    }

    //Otro toString
    public String toString2() {
        String msg = "";
        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < this.m[i].length; j++) {
                msg += this.m[i][j].toString() + "\t ";
            }
            msg = "\n";
        }

        return msg;

    }

    /**
     * Retorna la menor fracción almacenada en la matriz
     *
     * @return un string con la información de la fracción menor
     */
    public String getMenor() {
        return this.getMenor2().toString();
    }

    private Fraccion getMenor2() {
        Fraccion menor = null;
        menor = this.m[0][0];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j].compareTo(menor) == -1) {

                    menor = m[i][j];
                }
            }
        }

        return menor;

    }

    /**
     * Suma dos matrices fraccionarios
     *
     * @param dos matriz de fracción 2
     * @return una matriz con la suma resultante
     */
    private MatrizFraccion getSumar2(MatrizFraccion dos) {
        MatrizFraccion sumar = null;

        if (verificarTamaño(dos)) {
            sumar = new MatrizFraccion();
            sumar.m = new Fraccion[this.m.length][]; //matriz
            for (int i = 0; i < this.m.length; i++) {
                sumar.m[i] = new Fraccion[this.m[i].length]; //por cada fila una cantidad de columnas
                for (int j = 0; j < this.m[i].length; j++) {
                    sumar.m[i][j] = this.m[i][j].getSumar(dos.m[i][j]);
                }
            }

        }
        return sumar;
    }

    /**
     * Suma dos matrices de fracionarios
     *
     * @param dos matriz de fracción 2
     * @return un String que representa el toString() de la matriz de suma
     * resultante
     */
    public String getSumar(MatrizFraccion dos) throws Exception {
        if (!verificarTamaño(dos)) {
            throw new Exception("Error,las matrices tienen tamaños diferentes");
        }
        return this.getSumar2(dos).toString();
    }

    /**
     * Resta dos matrices de fracionarios
     *
     * @param dos matriz de fracción 2
     * @return un String que representa el toString() de la matriz de resta
     * resultante
     */
    public String getRestar(MatrizFraccion dos) throws Exception {
        if (!verificarTamaño(dos)) {
            throw new Exception("Error,las matrices tienen tamaños diferentes");
        }
        return this.getRestar2(dos).toString();
    }

    private MatrizFraccion getRestar2(MatrizFraccion dos) {
        MatrizFraccion restar = null;
        if (verificarTamaño(dos)) {
            restar = new MatrizFraccion();
            restar.m = new Fraccion[this.m.length][]; //matriz
            for (int i = 0; i < this.m.length; i++) {
                restar.m[i] = new Fraccion[this.m[i].length]; //por cada fila una cantidad de columnas
                for (int j = 0; j < this.m[i].length; j++) {
                    restar.m[i][j] = this.m[i][j].getRestar(dos.m[i][j]);
                }
            }
        }
        return restar;
    }

    /**
     * Crea una matriz de 1xM que representa la diagonal principal
     *
     * @return un String con la matriz que almacena la diagonal principal
     */
    public String getDiagonalPrincipal() throws Exception {
        if (!verificarCuadrada()) {
            throw new Exception("Error la Matriz no es cuadrada");
        }

        return this.getDiagPrin().toString();
    }

    /**
     * Obtiene la diagonal principal
     *
     * @return MatrizFraccion de tamaño 1xM
     */
    private MatrizFraccion getDiagPrin() {

        MatrizFraccion diagonal = null;
        if (verificarCuadrada()) {
            diagonal = new MatrizFraccion();
            diagonal.m = new Fraccion[1][m.length];

            for (int i = 0; i < this.m.length; i++) {
                diagonal.m[0][i] = this.m[i][i];
            }
        }
        return diagonal;
    }

    private MatrizFraccion getMultiplicacion2(MatrizFraccion dos) throws Exception {
        MatrizFraccion multiplicar = null;
        if ((this.m[0].length == dos.m.length)
                && !this.verificarDispersa()
                && !dos.verificarDispersa()) {
            int r1 = this.m.length;
            int c2 = dos.m[0].length;
            int c1 = this.m[0].length;
            multiplicar = new MatrizFraccion();
            multiplicar.m = new Fraccion[r1][c2];
            for (int i = 0; i < r1; i++) {
                for (int j = 0; j < c2; j++) {
                    Fraccion aux = this.m[i][0];
                    for (int k = 1; k < c1; k++) {
                        aux = aux.getSumar(this.m[i][k].getMultiplicar(dos.m[k][j]));
                    }
                    multiplicar.m[i][j] = aux;
                }
            }

        }
        return multiplicar;
    }

    private MatrizFraccion getTranspuesta2() {
        MatrizFraccion transpuesta = null;
        if ((verificarCuadrada() || verificarRectangular())) {
            transpuesta = new MatrizFraccion();
            transpuesta.m = new Fraccion[this.m[0].length][this.m.length];
            for (int i = 0; i < transpuesta.m.length; i++) {
                for (int j = 0; j < transpuesta.m[i].length; j++) {

                    transpuesta.m[i][j] = this.m[j][i];

                }

            }

        }
        return transpuesta;

    }

    private void getMatrizSimplificada2() {

        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < this.m[i].length; j++) {
                this.m[i][j].getSimplificar();

            }
        }

    }

    public boolean verificarCuadrada() {
        boolean cuadrada = true;
        for (int i = 0; i < this.m.length; i++) {
            if (m.length != this.m[i].length) {
                cuadrada = false;
            }

        }
        return cuadrada;
    }

    public boolean verificarRectangular() {
        boolean rectangular = true;
        for (int i = 0; i < this.m.length; i++) {
            if (m.length == this.m[i].length) {
                rectangular = false;
            }

        }

        return rectangular;
    }

    public boolean verificarDispersa() {
        return !verificarRectangular() && !verificarCuadrada();
    }

    public boolean verificarTamaño(MatrizFraccion dos) {
        boolean tamaño = true;
        if (this.m.length != dos.m.length) {
            tamaño = false;
        } else {
            for (int i = 0; i < this.m.length; i++) {
                if (this.m[i].length != dos.m[i].length) {
                    tamaño = false;
                }
            }

        }
        return tamaño;
    }

    @Override
    public String getTranspuesta() throws Exception {
        if (!verificarCuadrada() && !verificarRectangular()) {
            throw new Exception("La matriz es dispersa");
        }
        return this.getTranspuesta2().toString();

    }

    @Override
    public String getMatrizSimplificada() {
        getMatrizSimplificada2();
        return this.toString();

    }

    @Override
    public String getMultiplicación(Object matriz) throws Exception {

        MatrizFraccion dos = (MatrizFraccion) matriz;
        if (this.m[0].length != dos.m.length && (this.verificarDispersa())
                && (dos.verificarDispersa())) {
            throw new Exception("La matriz A no tiene igual columnas de las filas de la B");
        }
        return this.getMultiplicacion2(dos).toString();

    }

}
