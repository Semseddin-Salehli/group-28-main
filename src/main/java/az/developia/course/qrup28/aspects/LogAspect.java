package az.developia.course.qrup28.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
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
        writeLog(joinPoint, "student");
    }

    @Before(value = "allTeacherMethod()")
    public void beforeTeacher(JoinPoint joinPoint) {
        writeLog(joinPoint, "teacher");
    }

    @Before(value = "allSchoolClassMethod())")
    public void beforeSchoolClass(JoinPoint joinPoint) {
        writeLog(joinPoint, "schoolClass");
    }


    @Pointcut(value = "execution( * az.developia.course.qrup28.service.impl.StudentServiceImpl.*(..))")
    public void allStudentMethod() {
    }

    @Pointcut(value = "execution( * az.developia.course.qrup28.service.impl.TeacherServiceImpl.*(..))")
    public void allTeacherMethod() {
    }

    @Pointcut(value = "execution( * az.developia.course.qrup28.service.impl.SchoolClassServiceImpl.*(..))")
    public void allSchoolClassMethod() {
    }

    private void writeLog(JoinPoint joinPoint, String serviceName) {
        String logMessage;
        if (joinPoint.getArgs().length == 0) {
            logMessage = serviceName + " " + joinPoint.getSignature().getName() + " service called";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (Object o : joinPoint.getArgs()) {
                stringBuilder.append(o).append(" ");
            }
            logMessage = serviceName + " " + joinPoint.getSignature().getName() + " service called with arguments : " + stringBuilder;
        }
        log.info(logMessage);
    }
}
