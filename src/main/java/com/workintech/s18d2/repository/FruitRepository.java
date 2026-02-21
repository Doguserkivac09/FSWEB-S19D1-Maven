package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Fruit;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FruitRepository extends JpaRepository {
@Query(value="SELECT f.id,f.name,f.price,f.fruit_type FROM fsweb.fruit f ORDER by f.price DESC",nativeQuery = true)
    List<Fruit> getPriceDesc();

    @Query(value="SELECT f.id,f.name,f.price,f.fruit_type FROM fsweb.fruit f ORDER by f.price DESC",nativeQuery = true)
    List<Fruit> getPriceAsc();

    @Query("SELECT f FROM f where f.name LIKE %:name%")
    List<Fruit> searchByName(String name);
}
