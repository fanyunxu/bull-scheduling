package indi.fanyun.bullscheduling.config;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author tshk
 * @date 2021-01-12 14:42
 */
@Component
public class Config {

    @Bean
    public MapperFacade MapperFacade(){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        return mapperFactory.getMapperFacade();
    }
}
