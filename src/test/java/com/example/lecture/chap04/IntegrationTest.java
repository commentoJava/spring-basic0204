package com.example.lecture.chap04;

import com.example.lecture.chap04.exception.controller.ProductController;
import com.example.lecture.chap04.domain.Product;
import com.example.lecture.chap04.dto.ProductCreateDto;
import com.example.lecture.chap04.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class IntegrationTest {

    @Autowired
    ProductController productController;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ProductRepository productRepository;


    @BeforeEach
    public void setUp(){
        productRepository.save(new Product("상품1", 1000, 100000));
    }

    @AfterEach
    public void fin() {
        productRepository.deleteAll();
    }

    @Test
    @DisplayName("상품 통합 테스트")
    void integrationTest() throws Exception {

        ProductCreateDto productCreateDto = ProductCreateDto.builder()
                                               .name("상품2")
                                               .price(2000)
                                               .quantity(100)
                                               .build();

        String s = objectMapper.writeValueAsString(productCreateDto);

        mockMvc.perform(post("/product").content(s).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print());

        List<Product> product2 = productRepository.findByProductName("상품2");

        for (Product product : product2) {
            log.info("\n name :{} price: {} quantity:{}",product.getProductName(), product.getPrice(), product.getQuantity());
        }
    }

    @Test
    @DisplayName("상품 통합 테스트 실패 ")
    void integrationTestFail() throws Exception {

        ProductCreateDto productCreateDto = ProductCreateDto.builder()
                                                            .name("상품2")
                                                            .price(0)
                                                            .quantity(0)
                                                            .build();

        String s = objectMapper.writeValueAsString(productCreateDto);

        mockMvc.perform(post("/product").content(s).contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isBadRequest())
               .andDo(print());

        List<Product> product2 = productRepository.findByProductName("상품2");

        for (Product product : product2) {
            log.info("\n name :{} price: {} quantity:{}",product.getProductName(), product.getPrice(), product.getQuantity());
        }
    }

    @Test
    @DisplayName("조회")
    void integrationTest2() throws Exception {
        mockMvc.perform(get("/product/{productId}",1).contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.body.id").value(1))
            .andExpect(jsonPath("$.body.productName").value("상품1"))
            .andExpect(jsonPath("$.body.quantity").value(100000))
            .andDo(print());
    }





}
