package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class shannonFano {
    private ArrayList<Double> probabilidades;
    private ArrayList<ArrayList<Integer> > codigos;
    private double ultimaDiferencia;
    private int l1;
    private int l2;
    private int r;

    public shannonFano(ArrayList<Double> probabilidades, ArrayList<ArrayList<Integer>> codigos) {
        Collections.sort(probabilidades);
        this.probabilidades = probabilidades;
        this.codigos = new ArrayList<ArrayList<Integer> >(probabilidades.size());;
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

        return (suma1 - suma2);
    }

    private void agregarCeros(int l1, int l2){
        for (int i = l1; i < l2; i++) {
            codigos.get(i).add(0);
        }
    }

    private void agregarUnos(int l1, int l2){
        for (int i = l1; i < l2; i++) {
            codigos.get(i).add(0);
        }
    }

    private void calcularShannonFano(int l1p, int l2p, int rp){
        double diferencia;
        boolean parada = false;
        int l1 = l1p;
        int l2 = l2p;
        int r = rp;

        while(parada){
            diferencia = getDiferencia(l1,l2,r);

            if(diferencia < ultimaDiferencia){
                ultimaDiferencia = diferencia;
                l2 = l2 +1;
            }
            else{
                parada = true;
            }
        }

        if ((l2-l1)>1){
            agregarCeros(l1,l2);
            calcularShannonFano(l1,l1+1,l2);
        }

        if ((r-l2)>1){
            agregarUnos(l2,r);
            calcularShannonFano(l2,l2+1,r);
        }
    }

}
