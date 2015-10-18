package com.keemono.layout;

import com.keemono.web.WebConfiguration;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by edu on 17/10/2015.
 */
@WebAppConfiguration
@EnableAspectJAutoProxy
@PropertySources({
        @PropertySource("classpath:config/test.properties")
})
@ComponentScan(basePackages = {"com.keemono.web","com.keemono.common","com.keemono.service","com.keemono.integration"} )
//@Import({PersistenceConfiguration.class, ServiceConfiguration.class, IntegrationConfiguration.class, CommonConfiguration.class, SwaggerConfiguration.class})
@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfiguration.class})
public abstract class LayoutITCase {


}
