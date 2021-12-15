package io.bramcode.movie.ratingdataservices.service;

import io.bramcode.movie.ratingdataservices.models.MovieRating;
import io.bramcode.movie.ratingdataservices.models.UserRatingComment;
import io.bramcode.movie.ratingdataservices.models.entity.Rating;
import io.bramcode.movie.ratingdataservices.repository.RatingRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    RatingRepository ratingRepository;

    public Rating execute(Rating rating){
        return ratingRepository.save(rating);
    };

    public Rating retreiveById(long ratingId) throws NotFoundException{
        Optional<Rating> optRating = ratingRepository.findById(ratingId);

        var response = optRating.map(value -> {
                    Rating rating = new Rating();
                    rating.setRatingId(value.getRatingId());
                    rating.setUserName(value.getUserName());
                    rating.setUserRating(value.getUserRating());
                    rating.setMovieId(value.getMovieId());
                    rating.setUserComment(value.getUserComment());

                    return rating;
                }
        ).orElseThrow(() -> new NotFoundException(ratingId + " Not Found"));

        return response;
    }

    public MovieRating retreiveByMovieId(Long movieId) throws NotFoundException {
        List<Rating> listRating = ratingRepository.findByMovieId(movieId);

        List<UserRatingComment> listUserRatingComment = new ArrayList<>();
        final MovieRating movieRating = new MovieRating();

        if(!listRating.isEmpty()){
            movieRating.setMovieId(listRating.get(0).getMovieId());
            listRating.stream().forEach(
                    value -> {
                        UserRatingComment userRatingComment = new UserRatingComment();
                        userRatingComment.setUserName(value.getUserName());
                        userRatingComment.setUserRating(value.getUserRating());
                        userRatingComment.setUserComment(value.getUserComment());

                        listUserRatingComment.add(userRatingComment);

                    }
            );

            movieRating.setUserRatingCommentList(listUserRatingComment);

            return movieRating;
        }

        throw new NotFoundException(movieId +" Not Found");

    }
}
