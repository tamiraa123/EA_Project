package cs544.exercise13_2.bank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;


@Aspect

public class LogAdvice {
	

	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	@After("execution(* cs544.exercise13_1.EmailSender.sendEmail(..)) && args(email, message)")
	public void log(JoinPoint joinpoint,String email, String message) {
		
		Date date = new Date();
//	System.out.println(date+" method= address");
		System.out.println(date+" method= address="+email+" message= "+message);
//		System.out.println("outgoing mail server = "+((EmailSender)joinpoint.getTarget()).getOutgoingMailServer());
		
	}
	
	@Around("execution(* cs544.exercise13_1.CustomerDAO.save(..))")
	public Object invoke(ProceedingJoinPoint call ) throws Throwable
	{
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName()); 
		Object retVal = call.proceed(); sw.stop();
		long totaltime = sw.getLastTaskTimeMillis(); 
		// print the time to the console
		System.out.println("Time to execute save:" + totaltime );
		return retVal;
	}
	 

}
