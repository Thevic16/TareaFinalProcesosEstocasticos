package org.example;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.abs;

public class ShannonFano {
    private ArrayList<Double> probabilidades;
    private ArrayList<String> codigos;
    private double ultimaDiferencia;
    private int l1;
    private int l2;
    private int r;



    public ShannonFano(ArrayList<Double> probabilidades) {
        Collections.sort(probabilidades,Collections.reverseOrder());
        this.probabilidades = probabilidades;
        this.codigos = new ArrayList<String>(Collections.nCopies(probabilidades.size(), ""));;
        this.ultimaDiferencia = 2000000000;
        this.l1 =0;
        this.l2 =1;
        this.r = probabilidades.size();

        calcularShannonFano(l1,l2,r);
    }

    private double getDiferencia(int l1, int l2, int r){
        double suma1 = 0;
        double suma2 = 0;

        for (int i = l1; i < l2; i++) {
            suma1 = suma1 + probabilidades.get(i);
        }

        for (int i = l2; i < r; i++) {
            suma2 = suma2 + probabilidades.get(i);
        }

        return abs(suma1 - suma2);
    }



    private void agregarCeros(int l1, int l2){
        for (int i = l1; i < l2; i++) {
            codigos.set(i,codigos.get(i)+"0");
        }
    }

    private void agregarUnos(int l1, int l2){
        for (int i = l1; i < l2; i++) {
            codigos.set(i,codigos.get(i)+"1");
        }
    }

    private void calcularShannonFano(int l1p, int l2p, int rp){
        double diferencia;
        boolean parada = false;
        int l1 = l1p;
        int l2 = l2p;
        int r = rp;

        while(!parada){
            diferencia = getDiferencia(l1,l2,r);

            if(diferencia < ultimaDiferencia){
                ultimaDiferencia = diferencia;
                l2 = l2 +1;
            }
            else{
                parada = true;
                l2 = l2 - 1;
            }
        }

        this.ultimaDiferencia = 2000000000; //Reiniciando a un valor muy grande

        if ((l2-l1)>1){ //lado izquierdo
            agregarCeros(l1,l2);
            calcularShannonFano(l1,l1+1,l2);
        }
        else{
            agregarCeros(l1,l2);
        }

        if ((r-l2)>1){ //lado derecho
            agregarUnos(l2,r);
            calcularShannonFano(l2,l2+1,r);
        }
        else{
            agregarUnos(l2,r);
        }
    }

    public ArrayList<Double> getProbabilidades() {
        return probabilidades;
    }

    public void setProbabilidades(ArrayList<Double> probabilidades) {
        this.probabilidades = probabilidades;
    }

    public ArrayList<String> getCodigos() {
        return codigos;
    }

    public void setCodigos(ArrayList<String> codigos) {
        this.codigos = codigos;
    }

    public double getUltimaDiferencia() {
        return ultimaDiferencia;
    }

    public void setUltimaDiferencia(double ultimaDiferencia) {
        this.ultimaDiferencia = ultimaDiferencia;
    }

    public int getL1() {
        return l1;
    }

    public void setL1(int l1) {
        this.l1 = l1;
    }

    public int getL2() {
        return l2;
    }

    public void setL2(int l2) {
        this.l2 = l2;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

}
