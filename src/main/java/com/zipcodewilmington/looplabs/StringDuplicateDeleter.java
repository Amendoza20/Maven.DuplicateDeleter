package com.zipcodewilmington.looplabs;

import java.util.*;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    private Set<String> set = new LinkedHashSet<>();

    public StringDuplicateDeleter(String[] array){
        super(array);
        Set<String> set = this.set;
    }
    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<String> list = new ArrayList<>();
        for(String x : set){
            map.put(x,0);
        }
        for(String k : array) {
            map.replace(k, map.get(k) + 1);
            if (map.get(k) < maxNumberOfDuplications){
                for(int i = 0; i < map.get(k); i++){
                    list.add(k);
                }
            }
        }
        return list.toArray(new String[0]);
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<String> list = new ArrayList<>();
        for(String x : set){
            map.put(x,0);
        }
        for(String k : array) {
            map.replace(k, map.get(k) + 1);
            if (!(map.get(k) < exactNumberOfDuplications)){
                for(int i = 0; i < map.get(k); i++){
                    list.add(k);
                }
            }
        }
        return list.toArray(new String[0]);
    }
}
