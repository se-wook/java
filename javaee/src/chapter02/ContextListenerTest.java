package chapter02;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextListenerTest
 *
 */
@WebListener
public class ContextListenerTest implements ServletContextListener {

    public ContextListenerTest() {}

    /** context가 메모리에서 해제될 때 호출 되는 메서드 */
    public void contextDestroyed(ServletContextEvent event)  { 
    	System.out.println(event + " 가 종료됨... ");
    	
    }
    /** context가 초기화 될때 호출 */
    public void contextInitialized(ServletContextEvent event)  { 
    	System.out.println(event + " 초기화 됨...");
    }
	
}
