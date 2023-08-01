package com.example.jediscache;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class UserController {

    // 생성자를 외부에서 주입받기 위해 @RequiredArgsConstructor 사용
    // userRepository에 대한 DI를 받을 수 있음.
    private final UserRepository userRepository;

    // UserController에서 DB에 있는 사용자 정보(email)를 읽고 응답
    @GetMapping("/users/{id}/email")
    public String getUserEmail(@PathVariable Long id){
        // User 객체에 대해서 optional로  받음
        return userRepository.findById(id).orElse(User.builder().build()).getEmail();
    }
}
