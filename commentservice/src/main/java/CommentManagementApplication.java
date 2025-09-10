
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.ncu.comment")
@EnableDiscoveryClient
public class CommentManagementApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(CommentManagementApplication.class, args);
    }
}