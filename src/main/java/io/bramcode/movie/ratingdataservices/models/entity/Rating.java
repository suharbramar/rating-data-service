package io.bramcode.movie.ratingdataservices.models.entity;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "Rating")
@Table(name = "rating")
public class Rating {

    @Id
    @SequenceGenerator(
            name = "rating_sequence",
            sequenceName = "rating_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rating_sequence"
    )
    @Column(
            name = "rating_id",
            updatable = false
    )
    private Long ratingId;

    @Column(name = "movie_id", nullable = false)
    private Long movieId;

    @Column(name = "user_name", length = 50, nullable = false)
    private String userName;

    @Column(name = "user_rating", precision = 2, scale = 1, nullable = false)
    private BigDecimal userRating;

    @Column(name = "user_comment", length = 100, nullable = false)
    private String userComment;

    public Rating(){}

    public Rating(Long ratingId, Long movieId, String userName, BigDecimal userRating, String userComment) {
        this.ratingId = ratingId;
        this.movieId = movieId;
        this.userName = userName;
        this.userRating = userRating;
        this.userComment = userComment;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public Rating setRatingId(Long ratingId) {
        this.ratingId = ratingId;
        return this;
    }

    public Long getMovieId() {
        return movieId;
    }

    public Rating setMovieId(Long movieId) {
        this.movieId = movieId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Rating setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public BigDecimal getUserRating() {
        return userRating;
    }

    public Rating setUserRating(BigDecimal userRating) {
        this.userRating = userRating;
        return this;
    }

    public String getUserComment() {
        return userComment;
    }

    public Rating setUserComment(String userComment) {
        this.userComment = userComment;
        return this;
    }
}
