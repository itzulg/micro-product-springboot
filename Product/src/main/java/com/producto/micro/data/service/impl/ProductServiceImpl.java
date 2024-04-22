package com.producto.micro.data.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.producto.micro.data.exceptions.NotFoundException;
import com.producto.micro.data.model.Producto;
import com.producto.micro.data.repository.ProductRepository;
import com.producto.micro.data.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl  implements ProductService{

	private ProductRepository repository;
	
	public ProductServiceImpl(ProductRepository repository) {
      this.repository = repository;
	}

	@Override
	public List<Producto> getListProduct() {
	  Optional<List<Producto>> listProduct	= repository.findListProduct();
	  if(listProduct.isPresent()) {
		return listProduct.get();   
	  } else {
		  return new ArrayList<>();
	  }
		  
	}

	@Override
	public Producto getProductById(Long id) {
		Optional<Producto> productId	= repository.findById(id);
		  if(productId.isPresent()) {
			log.debug("Producto buscado con el id: {}", id);
			return productId.get();   
		  } else {
			  throw new NotFoundException("Este producto no existe");
		  }
		
	}

	@Override
	@Transactional
	public void updateProduct(Producto producto) {
		log.info("Producto: {}", producto);
		repository.save(producto);
		
	}

	@Override
	public void deleteProductRegistrer(Long id) {
		try {
		repository.deleteById(id);
		}catch (NotFoundException e) {
		  log.debug("Error en el Id");
	      throw new  NotFoundException("Id inexistente");
		}catch (Exception e) {
		  log.debug("Error en la base de datos");
          throw new  InternalError("Error en la base");
		}
		
	}

	@Override
	@Transactional
	public void createProduct(Producto producto) {
		log.info("Producto: {}", producto);
		repository.save(producto);
		
	}

}
