package com.example.jediscache;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// user라는 테이블을 만들어서 정보를 캐시에 저장
// 1. User 클래스 생성
//  + hibernate.ddl-auto : create 설정으로 User 엔터티를 자동으로 DB에 테이블을 만들어줌
// 2. 어플리케이션 시작하는 시점에 값을 자동으로 채워줌
//  + ApplicationRunner를 사용해서 어플리케이션 시작하는 시점에 데이터를 insert
// 3. RDB에 데이터 저장 됐음. Redis 관련 로직 작성
//  + Jedis 사용하기 위한 컴포넌트 생성


@SpringBootApplication
@RequiredArgsConstructor
public class JediscacheApplication implements ApplicationRunner {


	// 해당 UserRepository 객체에 대해서 생성자로 전달받음. (DI)
	private final UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(JediscacheApplication.class, args);
	}
	// 어플리케이션 시작하는 시점에서 테이블 스키마 생성 후
	// 시작할 때 userRepository.save()로 데이터 저장
	@Override
	public void run(ApplicationArguments args) throws Exception {
		userRepository.save(User.builder().name("greg").email("greg@fastcampus.co.kr").build());
		userRepository.save(User.builder().name("tony").email("tony@fastcampus.co.kr").build());
		userRepository.save(User.builder().name("bob").email("bob@fastcampus.co.kr").build());
		userRepository.save(User.builder().name("ryan").email("ryan@fastcampus.co.kr").build());
	}
}