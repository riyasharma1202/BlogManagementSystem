

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@ComponentScan(basePackages = "com.ncu.blog")
@EnableDiscoveryClient
public class BlogManagementApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(BlogManagementApplication.class, args);
    }
}
