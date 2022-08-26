import edu.java.spring.AppConfig;
import edu.java.spring.HelloClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class App2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext() ;
        ctx.register(AppConfig.class);
        ctx.refresh();
        HelloClass myBean = (HelloClass) ctx.getBean("bean2");
        myBean.printMessage() ;
    }
}

