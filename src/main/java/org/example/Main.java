package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //String texto = "MALAYALAM MADAM";

        String texto = new Scanner(new File("el_quijote.txt")).useDelimiter("\\Z").next();
        //System.out.println(texto);


        Entropia entropia = new Entropia(texto);

        System.out.println("--------------INFORMACIÓN-----------");
        System.out.println("Simbolos unicos:");
        System.out.println(entropia.getSimbolosUnicas());
        System.out.println("Probabilidades:");
        System.out.println(entropia.getProbabilidades());
        System.out.println("Entropia Teórica:");
        System.out.println(entropia.calcularEntropia());

       ShannonFano shannonFano = new ShannonFano(entropia.getProbabilidades());
        System.out.println(shannonFano.getCodigos());

        ArrayList<Character> simbolosUnicas =entropia.getSimbolosUnicas();
        ArrayList<Integer> frecuencias = entropia.getFrecuencias();
        ArrayList<Double> probabilidades = entropia.getProbabilidades();
        ArrayList<String> codigos = shannonFano.getCodigos();

        for (int i = 0; i < simbolosUnicas.size(); i++) {
            System.out.println("Caracter:"+simbolosUnicas.get(i)+" cantidad:"+frecuencias.get(i) +" Probabilidad:"+probabilidades.get(i)
            + " Código:"+codigos.get(i));
        }


        double entropiaReal = 0;
        for (String codigo:codigos) {
            entropiaReal = entropiaReal + codigo.length();
        }
        System.out.println("Entropia Real: "+(entropiaReal/codigos.size()));


        //Prueba
        /*
        ArrayList<Double> probabilidadesPrueba = new ArrayList<Double>();
        probabilidadesPrueba.add(0.05);
        probabilidadesPrueba.add(0.15);
        probabilidadesPrueba.add(0.22);
        probabilidadesPrueba.add(0.28);
        probabilidadesPrueba.add(0.30);
        System.out.println(probabilidadesPrueba);
         */

        /*
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(contador);
         */
    }

}



