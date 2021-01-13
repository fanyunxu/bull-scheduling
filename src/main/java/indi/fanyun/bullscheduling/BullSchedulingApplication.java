package indi.fanyun.bullscheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "indi.fanyun.bullscheduling.mapper")
@EnableOpenApi
public class BullSchedulingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BullSchedulingApplication.class, args);
    }

}
