package com.example.lecture.homework02.repository;

import com.example.lecture.homework02.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private static final Map<Long, User> userDB = new ConcurrentHashMap<>();

    private Long id = 0L;

    @Override
    public void save(User user) {
        id += 1L;
        userDB.put(id, user);
    }

    @Override
    public User findById(Long id) {
        //  Optional.ofNullable(userDB.get(id));
        return userDB.get(id);
    }

    @Override
    public List<User> findAll() {
        return userDB.values().stream().collect(Collectors.toList());
    }

    @Override
    public void update(Long id, User user) {
        userDB.put(id, user);
    }

    @Override
    public void delete(Long id) {
        userDB.remove(id);
    }
}
