package wm.playlists.restapi.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

        public JWTAuthorizationFilter(AuthenticationManager authManager) {
            super(authManager);
        }

        @Override
        protected void doFilterInternal(HttpServletRequest req,
                                        HttpServletResponse res,
                                        FilterChain chain) throws IOException, ServletException {

            System.out.println("inside basic filter;\nreading data from token login will be here");

            chain.doFilter(req, res);

        }
}
