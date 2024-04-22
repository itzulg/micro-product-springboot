package com.producto.micro.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.producto.micro.data.model.Producto;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Long> {

  @Query("SELECT  p from Producto p")  
  public Optional<List<Producto>> findListProduct();
  
  public Optional<Producto> findById(Long id);

}
