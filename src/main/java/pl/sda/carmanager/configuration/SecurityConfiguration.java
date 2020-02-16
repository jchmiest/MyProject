package pl.sda.carmanager.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import pl.sda.carmanager.entity.Privilage;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //metoda abstrakcyjna ma w argumencie http i mozemy zmienic uprawnienia
        http
                .authorizeRequests()
                .antMatchers("/car/front").hasRole(Privilage.USER.name())
                .antMatchers("/abc").hasRole(Privilage.ADMIN.name())
                .and()
                .formLogin();
        //xyz ma uprawnienia usera
    }
}
