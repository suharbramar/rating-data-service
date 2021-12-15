package io.bramcode.movie.ratingdataservices.models;

import java.util.List;

public class MovieRating {
    private Long movieId;
    private List<UserRatingComment> userRatingCommentList;

    public MovieRating(){}

    public MovieRating(Long movieId, List<UserRatingComment> userRatingCommentList) {
        this.movieId = movieId;
        this.userRatingCommentList = userRatingCommentList;
    }

    public Long getMovieId() {
        return movieId;
    }

    public MovieRating setMovieId(Long movieId) {
        this.movieId = movieId;
        return this;
    }

    public List<UserRatingComment> getUserRatingCommentList() {
        return userRatingCommentList;
    }

    public MovieRating setUserRatingCommentList(List<UserRatingComment> userRatingCommentList) {
        this.userRatingCommentList = userRatingCommentList;
        return this;
    }
}
