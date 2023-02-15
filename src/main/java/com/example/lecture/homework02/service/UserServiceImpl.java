package com.example.lecture.homework02.service;

import com.example.lecture.homework02.domain.User;
import com.example.lecture.homework02.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        //validateUser(id);
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void update(Long id, User user) {
        //validateUser(id);
        userRepository.update(id, user);
    }

    @Override
    public void delete(Long id) {

        //validateUser(id);
        userRepository.delete(id);
    }

//    private void validateUser(Long id) {
//        User user = userRepository.findById(id);
//        if (user == null) {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        }
//    }


}
