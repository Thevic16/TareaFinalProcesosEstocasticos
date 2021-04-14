package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String prueba = "MALAYALAM MADAM";

        /*
        ArrayList<Character> simbolosUnicas = Entropia.getSimbolosUnicos(prueba);
        ArrayList<Integer> frecuencias = Entropia.getFrecuencias(prueba, simbolosUnicas);
        ArrayList<Double> probabilidades = Entropia.getProbabilidad(frecuencias, prueba.length());

        System.out.println(probabilidades);
        System.out.println(Entropia.calcularEntropia(probabilidades));
         */

        ArrayList<Double> probabilidadesPrueba = new ArrayList<Double>();

        probabilidadesPrueba.add(0.05);
        probabilidadesPrueba.add(0.15);
        probabilidadesPrueba.add(0.22);
        probabilidadesPrueba.add(0.28);
        probabilidadesPrueba.add(0.30);

        System.out.println(probabilidadesPrueba);

        ShannonFano shannonFano = new ShannonFano(probabilidadesPrueba);

        System.out.println(shannonFano.getCodigos());

        /*
        ArrayList<Character> a1 = getSimbolosUnicos(prueba);
        ArrayList<Integer> a2 = getFrecuencias(prueba, a1);
        ArrayList<Double> a3 = getProbabilidad(a2, prueba.length());
        double contador = 0;

        for (int i = 0; i < a1.size(); i++) {
            System.out.println("Caracter:"+a1.get(i)+" cantidad:"+a2.get(i) +" Prob:"+a3.get(i));
            contador =contador +a3.get(i);
        }

         */

        /*
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(contador);
         */
    }

}



