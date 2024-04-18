package com.iqt.alienDictionary.alienDictionay.data;

import lombok.Getter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Dictionary {

    /**
     * Funcion que asigna valores a cada letra.
     * @param word
     * @return un mapa de Letra,Valor
     */
    public static Map<String,Integer> wordNumberMapping(String word){
        Map<String,Integer> stringDesc = new LinkedHashMap<>();
        for (int i=0; i<word.length();i++){
            stringDesc.put(word.substring(i,i+1),i+1);
        }
        return stringDesc;
    }







}
