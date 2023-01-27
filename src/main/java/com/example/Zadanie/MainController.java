package com.example.Zadanie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {
    private static final String apiUrl = "https://api.github.com/users/";
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LoginDataDao dao;

    @GetMapping("/employees/{login}")
    public User getUser(@PathVariable String login) {
        UserInput user = restTemplate.getForObject(
                apiUrl + login, UserInput.class);
        float calculations = 6f / user.getFollowers() * (2 + user.getPublic_repos());
        LoginData ld = dao.findByLogin(login);
        if (ld == null) {
            ld = new LoginData(null, login, 1);
        } else {
            ld.setRequestCount(ld.getRequestCount() + 1);
        }
        dao.save(ld);

        User ret= new User();
        ret.setId(user.getId());
        ret.setName(user.getName());
        ret.setLogin(user.getLogin());
        ret.setType(user.getType());
        ret.setAvatarUrl(user.getAvatar_url());
        ret.setCreatedAt(user.getCreated_at());
        ret.setCalculations(calculations);
        return ret;
    }


}
