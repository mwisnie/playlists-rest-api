package wm.playlists.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wm.playlists.restapi.entity.Account;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {

}
