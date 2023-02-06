package com.example.lecture.chapter01.homework1;

import com.example.lecture.chapter01.homework1.repository.Lecture11RepositoryImpl;
import com.example.lecture.chapter01.homework1.repository.Lecture1RepositoryNoSpring;
import com.example.lecture.chapter01.homework1.service.Lecture1ServiceNoSpring;
import com.example.lecture.chapter01.homework1.service.Lecture1ServiceNoSpringImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomeWork1_1 {

    Lecture1ServiceNoSpring lecture1ServiceNoSpring;
    Lecture1RepositoryNoSpring lecture1RepositoryNoSpring;

    @BeforeEach
    public void beforeEach() {
        lecture1RepositoryNoSpring = new Lecture11RepositoryImpl();
        lecture1ServiceNoSpring = new Lecture1ServiceNoSpringImpl(lecture1RepositoryNoSpring);
    }



    @Test
    void save() {
        lecture1ServiceNoSpring.save("박병호","박병호");
    }

    @Test
    void findByKey() {
        lecture1ServiceNoSpring.findByKey("박병호");
    }

    @Test
    void homework1_1() {
        lecture1ServiceNoSpring.save("박병호","박병호");
        lecture1ServiceNoSpring.homework("박병호");
    }
}
