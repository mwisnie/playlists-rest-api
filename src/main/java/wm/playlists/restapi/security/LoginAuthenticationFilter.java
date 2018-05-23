package wm.playlists.restapi.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import wm.playlists.restapi.entity.Account;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {


        System.out.println("inside login filter\n\n\n");

        try {
            Account accountToLogin = new ObjectMapper().readValue(request.getInputStream(), Account.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(accountToLogin.getLogin(),
                                                        accountToLogin.getPassword(),
                                                        new ArrayList<>()));
        } catch (IOException exc) {
            throw new RuntimeException(exc);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authentication)
                                            throws IOException, ServletException {

        System.out.println("succesful authentication");
        //generate token here
    }


}
