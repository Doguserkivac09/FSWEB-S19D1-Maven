package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import lombok.AllArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class FruitServiceImpl implements FruitService {
    private final FruitRepository fruitRepository;
    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getPriceAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getPriceDesc();
    }

    @Override
    public Fruit getById(Long id) {
        return fruitRepository.findById(id).orElseThrow(() -> new PlantException(
                "plant with given id is not exist:" + id));
    }

    @Override
    public Fruit save(Fruit fruit) {
        return (Fruit) fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(Long id) {
        Fruit fruit = getById(id);
        fruitRepository.delete(fruit);
        return null;
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }
}
