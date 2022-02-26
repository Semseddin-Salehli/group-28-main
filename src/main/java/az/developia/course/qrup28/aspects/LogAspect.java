package az.developia.course.qrup28.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {


    @Before(value = "allStudentMethod()")
    public void beforeStudent(JoinPoint joinPoint) {
        String logMessage;
        if (joinPoint.getArgs().length == 0) {
            logMessage = joinPoint.getSignature().getName() + " service called";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (Object o : joinPoint.getArgs()) {
                stringBuilder.append(o).append(" ");
            }
            logMessage = joinPoint.getSignature().getName() + " service called with arguments : " + stringBuilder;
        }
        log.info(logMessage);
    }


    @Pointcut(value = "execution( * az.developia.course.qrup28.service.impl.StudentServiceImpl.*(..))")
    public void allStudentMethod() {

    }

}
