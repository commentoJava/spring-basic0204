package com.example.lecture.chap04.dto;

import com.example.lecture.chap04.domain.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductCreateDto {

    @NotBlank
    private String name;

    @Min(1000)
    private int price;

    @Min(1)
    private int quantity;

    public static Product from(ProductCreateDto createDto) {
        return new Product(createDto.getName(), createDto.getPrice(), createDto.quantity);
    }
}
