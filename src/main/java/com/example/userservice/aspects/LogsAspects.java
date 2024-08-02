package com.example.userservice.aspects;

import com.example.userservice.dto.UserDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogsAspects {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.example.userservice.service..*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        log.info("Entering Method: {} with arguments {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @After("execution(* com.example.userservice.service..*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        log.info("Exiting Method: {}", joinPoint.getSignature());
    }

//    @Around("execution(UserDTO com.example.userservice.service.UserServiceImpl.saveUser(UserDTO))")
//    public Object logAroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        Object[] args = proceedingJoinPoint.getArgs();
//        UserDTO userDTO = (UserDTO) args[0];
//        if(userDTO.getName().length() > 10) {
//            throw new CustomException("User name exceeded the allowed length value.");
//        }
//        else {
//            Object result;
//            try {
//                result = proceedingJoinPoint.proceed();
//            } catch (Throwable throwable) {
//                log.error("Around Method {} execution failed with exception: {}", proceedingJoinPoint.getSignature(), throwable.getMessage());
//                throw throwable;
//            }
//
//            log.info("Around Method {} execution end", proceedingJoinPoint.getSignature());
//            return result;
//        }
//    }

}

class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
