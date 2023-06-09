package electro.store.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import electro.store.entity.Review;

public interface ReviewService {

	void save(Review review);

	Page<Review> findByProduct(Integer id, Pageable pageable);

	Review create(Review review);

}
