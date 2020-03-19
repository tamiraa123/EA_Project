package edu.miu.cs.cs544.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
//Method security
@EnableGlobalMethodSecurity(
//        The prePostEnabled property enables Spring Security pre/post annotations

        prePostEnabled = true,
//        The securedEnabled property determines if the @Secured annotation should be enabled

        securedEnabled = true,

//        The jsr250Enabled property allows us to use the @RoleAllowed annotation
        jsr250Enabled = true)

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    //Use embeded data source
    DataSource dataSource;

    //different API have different access requirements
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        //by using an object of type httpsecurity

        http.httpBasic()
                .and().csrf().disable().authorizeRequests()
                //Match path to role
                //All pathes to admin
                .antMatchers("/admin").hasRole("ADMIN_ROLE")
                .antMatchers("/students").hasAnyRole("STUDENT_ROLE","ADMIN_ROLE")
                //.permitAll for access some pages to every one
                .anyRequest().authenticated()
                .and()
                //type of login
                .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                  //in memory users -- In memory Authentication
//                .inMemoryAuthentication()
//                .withUser("admin")
//                .password("123")
//                .roles("ADMIN_ROLE")
//                .and()
//                .withUser(
//                        User.withUsername("student1")
//                                .password("123")
//                                .roles("STUDENT_ROLE")
//                )
//                .withUser(
//                        User.withUsername("faculty1")
//                        .password("123")
//                        .roles("FACULTY_ROLE")
//                )

                  //In database Authentication  Java Database Connectivity (JDBC)
                  //use custom tables for authentication
        .jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery("select user_name, password,enabled  from person where user_name = ?")
        .authoritiesByUsernameQuery("select user_name,role from person where user_name = ?");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    //Method security
    public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
    }
}
