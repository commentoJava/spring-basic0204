package com.example.lecture.chap03.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString(exclude = "members")
//@NoArgsConstructor(access = AccessLevel.PROTECTED) 실무에서는 setter를 열지 않고 다음과 같이 기본생성자를 protected로 하는 것을 권장.
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    @OneToMany(mappedBy = "company")
    private List<Member> members = new ArrayList<>();

}
