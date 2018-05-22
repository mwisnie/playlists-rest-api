package wm.playlists.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wm.playlists.restapi.entity.Song;

import javax.transaction.Transactional;

@Repository
@org.springframework.transaction.annotation.Transactional
public interface SongRepository extends JpaRepository<Song, Long> {

}
