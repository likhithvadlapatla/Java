import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LaunchApplication {
    public static void main(String args[]){
        /*This line is used to activate the Spring Framework.*/
        ApplicationContext springIoc = new ClassPathXmlApplicationContext("applicationconfig.xml");

        Amazon amz = springIoc.getBean(Amazon.class);
        Boolean status = amz.deliverTheProduct(333.00);

        if(status)
            System.out.println("Product Delivered!");
        else
            System.out.println("Failed to Deliver!");
    }
}
