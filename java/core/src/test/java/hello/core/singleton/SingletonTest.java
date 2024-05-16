package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {


    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {

        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);


        Assertions.assertThat(instance1).isSameAs(instance2);
    }

    @Test
    @DisplayName("스핑 컨테이너와 싱글톤")
    AppConfig appConfig = new AppConfig();

    @Test
    @DisplayName('스프링 컨테이너와 싱글톤')
    void springContainer() {
        AppConfig appConfig = new AppConfig();

        // 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

    }






}