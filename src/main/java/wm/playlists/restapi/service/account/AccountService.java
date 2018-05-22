package wm.playlists.restapi.service.account;

import wm.playlists.restapi.entity.Account;

public interface AccountService {

    Account getAccountById(Long id);

    Account saveAccount(Account account);

}
