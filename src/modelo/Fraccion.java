/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Admin
 */
public class Fraccion implements Comparable {

    int numerador;
    int denominador;

    public Fraccion() {
    }

    public Fraccion(int numerador, int denominador) throws Exception {
        if (denominador == 0) {
            throw new Exception("No se puede crear la fracción con numerador:" + numerador + " y denominador:" + denominador);
        }

        this.numerador = numerador;
        this.denominador = denominador;

    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.numerador;
        hash = 89 * hash + this.denominador;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        final Fraccion fraccion2 = (Fraccion) obj;
        return (this.getDecimal() == fraccion2.getDecimal());

    }

    public float getDecimal() {
        return ((float) this.numerador / (float) this.denominador);
    }

    @Override
    public String toString() {
        return this.numerador + "/" + this.denominador;
    }

    @Override
    public int compareTo(Object o) {
        final Fraccion fraccion2 = (Fraccion) o;

        float rta = this.getDecimal() - fraccion2.getDecimal();
        // Version candida-->return (int)(rta);
        if (rta < 0) {
            return -1;
        } else if (rta > 0) {
            return 1;
        } else {
            return 0;
        }

    }

    public Fraccion getRestar(Fraccion otro) {
        Fraccion respuestaRestar = new Fraccion();
        if (this.denominador == otro.denominador) {
            respuestaRestar.numerador = this.numerador - otro.numerador;
            respuestaRestar.denominador = this.denominador;

        } else {
            respuestaRestar.numerador = this.numerador * otro.denominador - this.denominador * otro.numerador;
            respuestaRestar.denominador = this.denominador * otro.denominador;
        }

        return respuestaRestar;
    }

    public Fraccion getSumar(Fraccion otro) {
        Fraccion respuestaSumar = new Fraccion();
        if (this.denominador == otro.denominador) {
            respuestaSumar.numerador = this.numerador + otro.numerador;
            respuestaSumar.denominador = this.denominador;

        } else {
            respuestaSumar.numerador = this.numerador * otro.denominador + this.denominador * otro.numerador;
            respuestaSumar.denominador = this.denominador * otro.denominador;
        }

        return respuestaSumar;

    }

    public Fraccion getMultiplicar(Fraccion otro) {
        Fraccion respuestaMultiplicar = new Fraccion();
        respuestaMultiplicar.setNumerador(this.numerador * otro.numerador);
        respuestaMultiplicar.setDenominador(this.denominador * otro.denominador);

        return respuestaMultiplicar;
    }

    public void getSimplificar() {
   
        int num = Math.abs(numerador);
        int den = Math.abs(denominador);

        int aux;
        while (den != 0) {
            aux = num % den;
            num = den;
            den = aux;
        }
        int mcd = num;
        this.numerador /= mcd;
        this.denominador /= mcd;

    }
}
