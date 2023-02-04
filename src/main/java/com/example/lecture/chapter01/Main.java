package com.example.lecture.chapter01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@Slf4j
public class Main {
    public static void main(String[] args) {
        // 자바 설정에서 정보를 읽어와서 빈 객체를 생성하고 관리하는 클래스
        AnnotationConfigApplicationContext appctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SamSungElecMemberService samSungElecMemberSerivce1 = appctx.getBean("samSungElecMemberSerivce",SamSungElecMemberService.class);
        SamSungElecMemberService samSungElecMemberSerivce2 = appctx.getBean("samSungElecMemberSerivce",SamSungElecMemberService.class);


        SamSungSdsMemberService samSungSdsMemberService1 = appctx.getBean("samSungSdsMemberService",SamSungSdsMemberService.class);
        SamSungSdsMemberService samSungSdsMemberService2 = appctx.getBean("samSungSdsMemberService",SamSungSdsMemberService.class);

//        log.info("\n 둘은 같은 객체인가요 ? {} ",samSungElecMemberSerivce1 == samSungElecMemberSerivce2);

        log.info("\n 둘은 같은 객체인가요 ? {} ",samSungSdsMemberService1 == samSungSdsMemberService2);

    }
}
