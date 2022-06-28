// package thehv.config;

// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Map;
// import java.util.Set;
// import javax.servlet.http.Cookie;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.DefaultRedirectStrategy;
// import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
// import org.springframework.stereotype.Component;
// import org.springframework.transaction.annotation.Transactional;

// @Configuration
// @EnableWebSecurity
// public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//     @Autowired
//     AuthSuccessHandler authSuccessHandler;

//     @Autowired
//     AuthService authService;

//     @Autowired
//     JdbcTemplate jdbcTemplate;

//     public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//         auth.userDetailsService(authService).passwordEncoder(new BCryptPasswordEncoder());
//     }

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.authorizeRequests().antMatchers("/*").authenticated().and().formLogin().loginPage("/login").permitAll()
//                 .usernameParameter("email").passwordParameter("password").successHandler(authSuccessHandler)
//                 .failureUrl("/login?error").and().exceptionHandling().accessDeniedPage("/403").and().csrf().disable();
//     }

//     @Component
//     class AuthService implements UserDetailsService {

//         @Override
//         @Transactional
//         public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//             List<Map<String, Object>> users = jdbcTemplate.queryForList(
//                     "SELECT x.id, x.email, x.`password`, z.`name` from `user` x join user_role y on x.id = y.user_id join role z on z.id = y.role_id WHERE x.email = ?",
//                     username);
//             System.out.println(users);
//             if (users == null || users.isEmpty()) {
//                 throw new UsernameNotFoundException("User not found");
//             }

//             Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//             users.forEach(x -> {
//                 grantedAuthorities.add(new SimpleGrantedAuthority(x.get("name").toString()));
//             });
//             return new org.springframework.security.core.userdetails.User(users.get(0).get("email").toString(),
//                     users.get(0).get("password").toString(), grantedAuthorities);
//         }
//     }

//     @Component
//     class AuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//         @Override
//         protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
//                 throws IOException {
//             if (!response.isCommitted()) {
//                 response.addCookie(new Cookie("authName", authentication.getName()));
//                 Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//                 List<String> roles = new ArrayList<>();
//                 for (GrantedAuthority a : authorities) {
//                     roles.add(a.getAuthority());
//                 }
//                 if (roles.size() > 0) {
//                     response.addCookie(new Cookie("authRoles", String.join(":", roles)));
//                 }
//                 String targetUrl = roles.size() > 0 ? "/" : "/access-denied";
//                 new DefaultRedirectStrategy().sendRedirect(request, response, targetUrl);
//             }
//         }
//     }
// }