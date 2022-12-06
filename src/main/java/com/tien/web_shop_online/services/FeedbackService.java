package com.tien.web_shop_online.services;


import com.tien.web_shop_online.entities.Feedback;

import java.util.List;

public interface FeedbackService {
    void saveFeedback(Feedback feedback);
    void deleteFeedbackById(Integer id);
    List<Feedback> findAllFeedback();
    
    List<Feedback> findFeedbackByProductId(Integer id);
}
