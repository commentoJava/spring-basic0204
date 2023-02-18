package com.example.lecture.chap03.domain.repository;

import com.example.lecture.chap03.domain.Member;
import com.example.lecture.chap03.domain.dto.MemberCompanyDto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberSpringDataRepository extends JpaRepository<Member, Long> {

    // 이름으로 찾는 기능
    List<Member> findByName(String name);

    //  이름이 같으면서 나이가 이것보다 큰
    List<Member> findByNameAndAgeGreaterThan(String name, int age);

    @Query("select m from Member m where m.name = :name and m.age > :age")
    List<Member> findCustomName(@Param("name") String name, @Param("age") int age);

    // jpa의 한계
    @Query("select new com.example.lecture.chap03.domain.dto.MemberCompanyDto(m.name, c.companyName) " +
        "from Member m join m.company c")
    List<MemberCompanyDto> findDto();

    List<Member> findByNameIn(List<String> names);


    List<Member> findByNameLike(String name);

}
