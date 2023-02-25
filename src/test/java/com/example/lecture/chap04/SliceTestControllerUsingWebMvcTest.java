package com.example.lecture.chap04;

import com.example.lecture.chap04.dto.ProductCreateDto;
import com.example.lecture.chap04.exception.controller.ProductController;
import com.example.lecture.chap04.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductController.class)
 class SliceTestControllerUsingWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean // web레이어 관련 빈들만 등록되므로 Service는 등록되지않는다. 따라서 가짜로 만들어줄 필요가 있다 (@MockBean)
    private ProductService productService;

    //기본적으로 @SpringBootTest 어노테이션을 사용하면 스프링이 관리하는 모든 빈을 등록시켜서 테스트하기 때문에 무겁다.
    //
    //하지만 @WebMvcTest는 web 레이어 관련 빈들만 등록하므로 비교적 가볍다.
    //
    //web레이어 관련 빈들만 등록되므로 Service는 등록되지않는다. 따라서 가짜로 만들어줄 필요가 있다 (@MockBean)

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("슬라이스 테스트 컨트롤러 BddMockito")
    void sliceTest1() throws Exception {
        ProductCreateDto productCreateDto = ProductCreateDto.builder()
                                                            .name("상품1")
                                                            .price(1000)
                                                            .quantity(10000)
                                                            .build();

        String json = objectMapper.writeValueAsString(productCreateDto);

        given(productService.createProduct(productCreateDto))
            .willReturn(1L);

        mockMvc.perform(post("/product")
                            .content(json)
                            .contentType(APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.body").value(1))
               .andDo(print());
    }

    @Test
    @DisplayName("슬라이스 테스트 컨트롤러 Mockito")
    void sliceTest2() throws Exception {
        ProductCreateDto productCreateDto = ProductCreateDto.builder()
                                                            .name("상품1")
                                                            .price(1000)
                                                            .quantity(10000)
                                                            .build();

        String json = objectMapper.writeValueAsString(productCreateDto);

        Mockito.doReturn(1L).when(productService).createProduct(productCreateDto);

        mockMvc.perform(post("/product")
                            .content(json)
                            .contentType(APPLICATION_JSON))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.body").value(1))
               .andDo(print());
    }
}
