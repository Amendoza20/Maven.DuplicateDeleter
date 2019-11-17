package com.zipcodewilmington.looplabs;

import java.util.*;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    Set<Integer> set = new LinkedHashSet<>(Arrays.asList(array));
    public IntegerDuplicateDeleter(Integer[] array){
        super(array);
        Set<Integer> set = this.set;
    }
    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        List<Integer> list = new ArrayList<>();
        for(Integer x : set){
            map.put(x,0);
        }
        for(Integer j : array){
            map.replace(j, map.get(j) + 1);
        }
        for(Integer k : set){
            if(map.get(k) < maxNumberOfDuplications){
                for(int i = 0; i < map.get(k);i++){
                    list.add(k);
                }
            }
        }

        return list.toArray(new Integer[0]);
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        List<Integer> list = new ArrayList<>();
        for(Integer x : set){
            map.put(x,0);
        }
        for(Integer j : array){
            map.replace(j, map.get(j) + 1);
        }
        for(Integer k : set){
            if(!map.get(k).equals(exactNumberOfDuplications)){
                for(int i = 0; i < map.get(k);i++){
                    list.add(k);
                }
            }
        }

        return list.toArray(new Integer[0]);
    }
}
