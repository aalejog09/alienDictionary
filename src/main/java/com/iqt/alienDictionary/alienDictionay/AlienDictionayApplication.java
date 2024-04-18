package com.iqt.alienDictionary.alienDictionay;

import com.iqt.alienDictionary.alienDictionay.data.Dictionary;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;


@SpringBootApplication
public class AlienDictionayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlienDictionayApplication.class, args);

        String[] words = {"habito", "hacer", "sonreir", "lectura"};
        String dictionary = "hlabcdefgijkmnopqrstuvwxyz";
        char wordChar = 0;
        char nextWordChar = 0;
        int valueWordChar = 0;
        int valueNextWordChar = 0;
        boolean result = false;
        //1ero : asignar valores a cada letra (posiciones) conviertiendo el dictionary en un mapa
        Map<String, Integer> dictionaryMapped = new LinkedHashMap<>();
        dictionaryMapped = Dictionary.wordNumberMapping(dictionary);

        //verificando el valor del hashmap
        System.out.println("dictionayMapped:" + dictionaryMapped);

        //2do problema, comparar 1 palabra con la siguiente
        // para saber si estan ordenadas segun el diccionario
        for (int i = 0; i < words.length - 1; i++) {
            //obtener del arreglo 2 palabras para compararlas.
            String word = Arrays.stream(words).toList().get(i);
            String nextWord = Arrays.stream(words).toList().get(i + 1);
            int min = Math.min(word.length(), nextWord.length());
            int iteracion = i + 1;
            System.out.println("iteracion: " + iteracion + ". Palabras a evaluar : word: " + word + " nextWord: " + nextWord);

            //obtener las letras de cada palabra para comprar con el valor de cada letra .
            for (int j = 0; j < min; j++) {
                wordChar = word.charAt(j);
                nextWordChar = nextWord.charAt(j);

                //obtener los valores de las letras de cada palabra
                valueWordChar = dictionaryMapped.get(String.valueOf(wordChar));
                valueNextWordChar = dictionaryMapped.get(String.valueOf(nextWordChar));
                System.out.println("wordChar ={" + wordChar + "=" + valueWordChar + "} --- nextWordChar ={" + nextWordChar + "=" + valueNextWordChar + "}");

                //si las letras son iguales, pasar a las siguiente letra de cada palabra
                while (valueWordChar == valueNextWordChar) {
                    j++;
                    // Si los valores son iguales, itera al siguiente carácter

                    if (j >= min) {
                        break; // Evita desbordamiento de índice
                    }
                    wordChar = word.charAt(j);
                    nextWordChar = nextWord.charAt(j);
                    valueWordChar = dictionaryMapped.get(String.valueOf(wordChar));
                    valueNextWordChar = dictionaryMapped.get(String.valueOf(nextWordChar));
                    System.out.println("nuevos wordChar ={" + wordChar + "=" + valueWordChar + "} --- nextWordChar ={" + nextWordChar + "=" + valueNextWordChar + "}");
                }
                //si son diferentes, entonces evaluar si el valor de la primera letra es menor al de la 2da.
                if (valueWordChar < valueNextWordChar) {
                    result = true;
                }
            }
        }
        System.out.println("ordenado: " + result);
    }
}




