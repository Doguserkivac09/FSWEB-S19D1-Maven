package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class FruitServiceImpl implements FruitService {
    private final FruitRepository fruitRepository;
    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public Fruit getById(Long id) {
        if (id == null || id <= 0) {
            throw new PlantException(HttpStatus.BAD_REQUEST, "Id must be greater than zero");
        }
        return fruitRepository.findById(id)
                .orElseThrow(() -> new PlantException(HttpStatus.NOT_FOUND,
                        "plant with given id is not exist:" + id));
    }

    @Override
    public Fruit save(Fruit fruit) {
        if (fruit == null) {
            throw new PlantException(HttpStatus.BAD_REQUEST, "Fruit data is not valid");
        }
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit delete(Long id) {
        Fruit fruit = getById(id);
        fruitRepository.delete(fruit);
        return fruit;
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }
}
