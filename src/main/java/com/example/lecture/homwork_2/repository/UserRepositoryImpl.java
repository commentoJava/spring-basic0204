package com.example.lecture.homwork_2.repository;

import com.example.lecture.homwork_2.doamain.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private static  Map<Long, User> userLists = new ConcurrentHashMap<>();

    private static Long id = 0L;
    @Override
    public Optional<User> findByUserId(Long userId) {
        return Optional.ofNullable(userLists.get(userId));
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        userLists.put(++id, user);
        return user;
    }

    @Override
    public void deleteUser(Long userId) {
        userLists.remove(userId);
    }

    @Override
    public void updateUser(Long userId, User updateUser) {
        userLists.put(userId, updateUser);
    }
}
