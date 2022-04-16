package com.blog.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationPid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.CategoryDto;
import com.blog.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	// create

	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto createCategory = categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createCategory, HttpStatus.CREATED);
	}

	// update

	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,
			@PathVariable("catId") Integer catId) {
		CategoryDto updateCategory = categoryService.updateCategory(categoryDto, catId);
		return new ResponseEntity<CategoryDto>(updateCategory, HttpStatus.OK);
	}
	// delete

	@DeleteMapping("/{catId}")
	public ResponseEntity<?> deleteCategory(@PathVariable("catId") Integer catId) {
		categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully !!", true),
				HttpStatus.OK);
	}
	// get

	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable("catId") Integer catId) {
		return new ResponseEntity<CategoryDto>(categoryService.getCategory(catId), HttpStatus.OK);
	}

	// get all

	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategory() {
		return new ResponseEntity<List<CategoryDto>>(categoryService.getCategories(), HttpStatus.OK);
	}

}
