package eci.ieti.taskplannerAPI.RestControllers;


import eci.ieti.taskplannerAPI.Model.User;
import eci.ieti.taskplannerAPI.Services.UserService;
import eci.ieti.taskplannerAPI.utils.StringUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService service;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Token login(@RequestBody User login)
            throws ServletException {

        String jwtToken = "";

        if (login.getEmail() == null || login.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }

        String email = login.getEmail();
        String password = login.getPassword();
        User user = service.getUser(email);

        if (user == null) {
            throw new ServletException("User email not found.");
        }

        String passwordHash = user.getPassword();

        if (!StringUtils.isPasswordValid(password, passwordHash)) {
            throw new ServletException("Invalid login. Please check your email and password.");
        }
        //
        jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date()).signWith(
                SignatureAlgorithm.HS256, "secretkey").compact();

        user.setPassword(null);
        return new Token(jwtToken, user);
    }

    public class Token {

        String accessToken;
        User user;

        public Token(String accessToken, User user) {
            this.accessToken = accessToken;
            this.user = user;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }


        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String access_token) {
            this.accessToken = access_token;
        }
    }



    @PostMapping
    public ResponseEntity<?> createUserHandler(@RequestBody User user) {
        try {

            return new ResponseEntity<>(service.createUser(user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }




}
