package annotation.aop1;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect //<aop:aspect
public class Common {//aop1패키지의 모든 메소드 수행시 같이 수행
	@Pointcut(("execution(* annotation.aop1.*.*(..))"))
	public void pc() {}
	
	
	@Pointcut(("execution(* annotation.memberService.*Service.*Member(..))"))
	public void pc2() {}
/*//메소드 시작시간 출력
	@Before("pc()")
	public void a() {
		System.out.println(new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초에 시작하였습니다").format(new Date()));
	}
	
	long start = System.currentTimeMillis();
	
//메소드 종료시간 출력
	@After("pc()")
	public void b() {
		long end = System.currentTimeMillis();
		System.out.println("메소드 수행시간=" +(end - start));
		System.out.println(new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초에 끝났습니다").format(new Date()));
	}
*/	
	@Around("pc() || pc2()")
	public void c(ProceedingJoinPoint joinpoint) {
		try {
		//전 후 출력
		System.out.println("target메소드 수행 이전입니다");
		
		Object obj = joinpoint.proceed();
		if(obj != null) {
			System.out.println("메소드의 리턴값 = "+ obj);
		}
		System.out.println("target클래스이름" + joinpoint.getTarget());
		System.out.println("target클래스이름" + joinpoint.toShortString());
		
		Object[] args = joinpoint.getArgs();
		for(Object o : args) {
			System.out.println("메개변수 = " + o);
		}
		
		
		System.out.println("terget메소드 수행 이후입니다");
		}catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
}
