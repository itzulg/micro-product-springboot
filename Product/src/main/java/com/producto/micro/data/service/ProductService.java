package com.producto.micro.data.service;

import java.util.List;

import com.producto.micro.data.model.Producto;

public interface ProductService {
	
	public List<Producto> getListProduct();
	
	public Producto getProductById(Long id);
	
	public void updateProduct(Producto producto);
	
	public void deleteProductRegistrer(Long id);
	
	public void createProduct(Producto producto);
	

}
