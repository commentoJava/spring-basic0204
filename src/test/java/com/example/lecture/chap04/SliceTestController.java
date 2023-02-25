package com.example.lecture.chap04;

import com.example.lecture.chap04.exception.controller.ProductController;
import com.example.lecture.chap04.dto.ProductCreateDto;
import com.example.lecture.chap04.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class SliceTestController {


    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController)
            .build();

        objectMapper = new ObjectMapper();
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

        BDDMockito.given(productService.createProduct(productCreateDto))
                      .willReturn(1L);

        mockMvc.perform(post("/product").content(s).contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isOk())
            .andExpect(jsonPath("$.body").value(1))
               .andDo(print());


    }
}
