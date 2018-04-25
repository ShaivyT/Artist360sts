package com.jga.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.Param;

import com.jga.models.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {
	
	@Query("SELECT a FROM Artist a WHERE a.username=:username AND a.password=:password")
	Iterable<Artist> findArtistByUsername(@Param("username") String username,
										  @Param("password") String password);
	
}
