package ssst.healthdiary.backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .antMatcher("/**").authorizeRequests()
                .antMatchers(new String[]{"/", "/not-restricted"}).permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER").and()
//                .withUser("user2").password("password2").roles("USER", "ADMIN");
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("patient").password(passwordEncoder().encode("patientpassword")).roles("PATIENT")
//                .and()
//                .withUser("doctor").password(passwordEncoder().encode("doctorpassword")).roles("DOCTOR");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/patient/**").access("hasRole('PATIENT')")
//                .antMatchers("/doctor/**").access("hasRole('DOCTOR')")
//                .and().oauth2Login()
//                .and().logout().invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/logout-success").permitAll();
//    }

//    protected void configure(HttpSecurity http) throws Exception {
//        http.logout();
//    }


//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .anyRequest().authenticated()
//                .and().formLogin()
//                .loginPage("/login").permitAll();
//    }

//protected void configure(HttpSecurity http) throws Exception {
//    http.authorizeRequests()
//            .antMatchers("/patient/**").access("hasRole('PATIENT')")
//            .antMatchers("/doctor/**").hasRole("DOCTOR")
//            .formLogin();
//}


}