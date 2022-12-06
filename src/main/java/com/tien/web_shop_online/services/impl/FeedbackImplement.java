package com.tien.web_shop_online.services.impl;

import com.tien.web_shop_online.entities.Feedback;
import com.tien.web_shop_online.repositories.FeedbackRepository;
import com.tien.web_shop_online.services.FeedbackService;
import com.tien.web_shop_online.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FeedbackImplement implements FeedbackService {

    @Autowired
    private FeedbackRepository rp;
    
    @Autowired
    private ProductService productService;

    @Override
    public void saveFeedback(Feedback feedback) {
        rp.save(feedback);
    }

    @Override
    public void deleteFeedbackById(Integer id) {
        rp.deleteById(id);
    }

    @Override
    public List<Feedback> findAllFeedback() {
        return rp.findAll();
    }

	@Override
	public List<Feedback> findFeedbackByProductId(Integer id) {
		return rp.findFeedbacksByProductId(productService.findProductById(id));
	}
}
