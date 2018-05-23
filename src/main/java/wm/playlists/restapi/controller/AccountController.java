package wm.playlists.restapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import wm.playlists.restapi.entity.Account;
import wm.playlists.restapi.service.account.AccountService;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AccountController {

    private final AccountService accountService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/api/account/{id}")
    public Account getAccountById(@PathVariable("id") Long id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/api/account")
    public Account addAccount(@RequestBody Account account) {
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        return accountService.saveAccount(account);
    }

}
