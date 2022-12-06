package com.tien.web_shop_online.controllers.api;

import com.tien.web_shop_online.services.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/products")
public class ProductAPI {

    @Autowired
    UploadFileService storageService;

    @GetMapping(value = "/resources/images/{image}")
    public ResponseEntity<byte[]> readDetailFile(@PathVariable String image){
        try {
            byte[] bytes = storageService.readFileContent(image);
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(bytes);
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
}
