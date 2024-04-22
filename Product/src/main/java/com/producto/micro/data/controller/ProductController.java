package com.producto.micro.data.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.producto.micro.data.model.Producto;
import com.producto.micro.data.service.ProductService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Validated
@RequestMapping("/api")
@Slf4j
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(value = "/product/list/retrieve")
	public ResponseEntity<?> getList(){
		productService.getListProduct();
		return new ResponseEntity<List<Producto>>(productService.getListProduct(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/product/id/retrieve", params = {"id"})
	public ResponseEntity<?> getProductId(@RequestParam Long id){
		return new ResponseEntity<Producto>(productService.getProductById(id), HttpStatus.OK);
	}
	
	@PutMapping(value = "/product")
	public ResponseEntity<?> updateProduct(@RequestBody @Valid Producto producto){ 
		log.info("Start process to update - request: {}", producto);
		productService.updateProduct(producto);
		return new ResponseEntity<String>("Updated Product", HttpStatus.OK);
	}
	
	@PostMapping(value = "/product/create")
	public ResponseEntity<?> createProduct(@RequestBody @Valid Producto producto){ 
		productService.createProduct(producto);
		return new ResponseEntity<String>("Created Product", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/product/remove", params = {"id"})
	public ResponseEntity<?> deleteProduct(@RequestParam Long id){
		productService.deleteProductRegistrer(id);
		return new ResponseEntity<String>("Deleted Product", HttpStatus.OK);
	}
	
	
}
