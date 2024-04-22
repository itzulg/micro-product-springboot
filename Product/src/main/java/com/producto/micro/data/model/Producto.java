package com.producto.micro.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product", schema = "market")
public class Producto implements Serializable{
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Pattern(regexp = "[a-zA-Z]*")
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Size(max = 180)
	@Column(name = "description")
	private String description;
	
	@NotNull
	@Positive
	@Column(name = "quantity")
	private Integer quantity;
	
	@NotNull
	@Positive	
	@NumberFormat(pattern = "00.00")
	@Column(name = "price")
	private Double price;
	
	@NotNull(message = "Invalid date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@Column(name = "date")
	private Date date;
	
	@NotNull
	@Size(max = 16, min = 16)
	@Pattern(regexp = "[0-9]+")
	@Column(name = "code")
	private String code;
	
	
	private static final long serialVersionUID = -7774312886344765191L;
  

}
