import edu.java.spring.HelloClass;
import edu.java.spring.HelloWorld;
import edu.java.spring.JavaClass;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class App {
    private final static Logger logger = Logger.getLogger(JavaClass.class) ;

    public static void main(String[] args) {

//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml") ;
//        HelloClass obj = (HelloClass) context.getBean("helloJavaClass");
//        obj.printMessage() ;
//
//        HelloClass obj2 = (HelloClass) context.getBean("helloJavaClass") ;
//        obj2.printMessage();
////        System.out.println( obj == obj2 );
//         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml") ;
//         context.registerShutdownHook();

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml") ;
        JavaClass javaClass = (JavaClass) context.getBean("jee01") ;
        Map<String , Integer > map = javaClass.getStudents() ;
        HelloClass helloClass = (HelloClass) context.getBean("helloJavaClass");

        logger.info("Map implement is " + javaClass.getStudents().size() );
        logger.info("Total class is " +helloClass.getClazz().size());
    }
}