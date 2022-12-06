package com.tien.web_shop_online.repositories;

import com.tien.web_shop_online.entities.Feedback;
import com.tien.web_shop_online.entities.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
	
	List<Feedback> findFeedbacksByProductId(Product productId);
}
