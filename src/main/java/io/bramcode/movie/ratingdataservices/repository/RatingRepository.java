package io.bramcode.movie.ratingdataservices.repository;

import io.bramcode.movie.ratingdataservices.models.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query(value = "SELECT * FROM RATING \n" +
            "WHERE MOVIE_ID = :movieId \n", nativeQuery = true)
    List<Rating> findByMovieId(Long movieId);

}
