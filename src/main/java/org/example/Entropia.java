package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Entropia {

    ArrayList<Character> simbolosUnicas;
    ArrayList<Integer> frecuencias;
    ArrayList<Double> probabilidades;

    public Entropia(String texto) {
        calcularSimbolosUnicos(texto);
        calcularFrecuencias(texto,this.simbolosUnicas);
        calcularProbabilidad(this.frecuencias,texto.length());
    }

    public double calcularEntropia(){
        double H = 0;

        for (Double probabilidad:probabilidades) {
            H = H + (-probabilidad*log2(probabilidad));
        }

        return H;
    }


    public void calcularSimbolosUnicos(String str) {
        char[] chArray = str.toCharArray();
        ArrayList<Character> simbolosUnicas = new ArrayList<Character>();
        char ultimaIngresada;

        // Ordenando el arreglo en orden acendiente.
        Arrays.sort(chArray);

        ultimaIngresada = chArray[0];
        simbolosUnicas.add(ultimaIngresada);

        for (int i = 1; i < chArray.length; i++) {
            // if the adjacent elements are not
            // equal, move to next element
            if (chArray[i] != ultimaIngresada){
                ultimaIngresada = chArray[i];
                simbolosUnicas.add(ultimaIngresada);
            }
        }
        this.simbolosUnicas= simbolosUnicas;
    }

    public void calcularFrecuencias(String str, ArrayList<Character> simbolosUnicos) {
        char[] chArray = str.toCharArray();
        ArrayList<Integer> frecuanciaSimbolos = new ArrayList<Integer>(Collections.nCopies(simbolosUnicos.size(), 0));


        // Ordenando el arreglo en orden acendiente.
        Arrays.sort(chArray);
        int j =0;

        for (int i = 0; i < chArray.length; i++) {
            if (chArray[i] == simbolosUnicos.get(j)){
                frecuanciaSimbolos.set(j, (frecuanciaSimbolos.get(j) +1));
            }
            else{
                j = j+1;
                frecuanciaSimbolos.set(j, (frecuanciaSimbolos.get(j) +1));
            }
        }
        this.frecuencias = frecuanciaSimbolos;
    }

    public void calcularProbabilidad(ArrayList<Integer> frecuanciaSimbolos, int logitud) {
        ArrayList<Double> probabilidades = new ArrayList<Double>();

        for (int i = 0; i < frecuanciaSimbolos.size(); i++) {
            probabilidades.add(((double)frecuanciaSimbolos.get(i)/logitud));
        }

       this.probabilidades = probabilidades;
    }

    // Function to calculate the
    // log base 2 of an integer
    public static double log2(double N)
    {

        // calculate log2 N indirectly
        // using log() method
        double result = (double)(Math.log(N) / Math.log(2));

        return result;
    }

    public ArrayList<Character> getSimbolosUnicas() {
        return simbolosUnicas;
    }

    public void setSimbolosUnicas(ArrayList<Character> simbolosUnicas) {
        this.simbolosUnicas = simbolosUnicas;
    }

    public ArrayList<Integer> getFrecuencias() {
        return frecuencias;
    }

    public void setFrecuencias(ArrayList<Integer> frecuencias) {
        this.frecuencias = frecuencias;
    }

    public ArrayList<Double> getProbabilidades() {
        return probabilidades;
    }

    public void setProbabilidades(ArrayList<Double> probabilidades) {
        this.probabilidades = probabilidades;
    }
}
