package com.example.demo.db;


import com.example.demo.entity.Entity;

import java.util.*;
import java.util.stream.Collectors;

public abstract class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID> {

    private List<T> dataList = new ArrayList<T>();

    private static long index = 0;

    private Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };

    @Override
    // create and update
    public T save(T data) {

        if(Objects.isNull(data)){
            throw new RuntimeException("Data is null");
        }

        // db exist check
        var prevData = dataList.stream()
                .filter(it-> {
                    return it.getId().equals(data.getId());
                })
                .findFirst();

        if(prevData.isPresent()){
            // existed
            dataList.remove(prevData);
            dataList.add(data);


        }else {
            // new
            // unique id
            index++;
            data.setId(index);
            dataList.add(data);
        }

        return data;
    }

    // read
    @Override
    public Optional<T> findById(ID id){
        return dataList.stream()
                .filter(it -> {
                    return (it.getId().equals(id));
                })
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList
                .stream()
                .sorted(sort)
                .collect(Collectors.toList());
    }

    // delete
    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream()
                .filter(it -> {
                    return (it.getId().equals(id));
                })
                .findFirst();

        if(deleteEntity.isPresent()){
            dataList.remove(deleteEntity);
        }
    }
}
