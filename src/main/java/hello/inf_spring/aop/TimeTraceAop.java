package hello.inf_spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Aspect
//@Component 사용이 가능하지만 나는 빈으로 직접 등록해서 진행하였다.
public class TimeTraceAop {

    // 빈을 직접 등록해서 사용했을 때 순환참조 오류가 SpringConfig 클래스에서 발생 AOP 타겟에서 SpringConfig 를 빼주기 위해 추가 작성한 코드
    @Around("execution(* hello.inf_spring..*(..)) && !target(hello.inf_spring.SpringConfig)\")")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        System.out.println("START: " + joinPoint.toString());

        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
