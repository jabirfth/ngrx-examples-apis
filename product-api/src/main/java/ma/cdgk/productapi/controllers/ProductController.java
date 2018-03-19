package ma.cdgk.productapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ma.cdgk.productapi.entities.Product;
import ma.cdgk.productapi.repositories.ProductRepository;

@RestController
@RequestMapping("/products")
@Transactional
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductRepository repo;

	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Product> listproducts() {
		return repo.findAll();
	}

	@GetMapping("/{productId}")
	@ResponseStatus(HttpStatus.OK)
	public Product getProduct(@PathVariable Long productId) {
		return repo.findById(productId).orElse(null);
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@RequestBody Product product) {
		return repo.save(product);
	}

	@PutMapping("/{productId}")
	@ResponseStatus(HttpStatus.OK)
	public Product updateProduct(@PathVariable Long productId, @RequestBody Product product) {
		return repo.save(product);
	}

	@DeleteMapping("/{productId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Long productId) {
		repo.deleteById(productId);
	}
}