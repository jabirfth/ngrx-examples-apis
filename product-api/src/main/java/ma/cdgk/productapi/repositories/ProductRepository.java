package ma.cdgk.productapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ma.cdgk.productapi.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

}
