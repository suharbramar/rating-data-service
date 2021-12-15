package io.bramcode.movie.ratingdataservices.controller;

import io.bramcode.movie.ratingdataservices.models.*;

import io.bramcode.movie.ratingdataservices.models.entity.Rating;
import io.bramcode.movie.ratingdataservices.service.RatingService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rating/list")
public class RatingsResource {

    @Autowired
    RatingService ratingService;

    @PostMapping("/save")
    public Rating createRating(@Valid @RequestBody Rating rating){
        return ratingService.execute(rating);
    }

    @RequestMapping("/{ratingId}")
    public Rating getRating(@PathVariable("ratingId") long ratingId) throws NotFoundException {
        return ratingService.retreiveById(ratingId);
    }

    @RequestMapping("/movie/{movieId}")
    public MovieRating getRatingByMovie(@PathVariable("movieId") long movieId) throws NotFoundException {
        return ratingService.retreiveByMovieId(movieId);
    }



//    @RequestMapping("/{movieId}")
//    public Rating getRating(@PathVariable("movieId") String movieId){
//
//    return new Rating(movieId,4);
//    }
//
//    @RequestMapping("user/{userId}")
//    public UserRating getUserRating(@PathVariable("userId") String movieId){
//
//    //    return Arrays.asList(
//    //         new Rating("1234",5),
//    //         new Rating("5678",4)
//    //         );
//    List<Rating> rating = Arrays.asList(
//                new Rating("1234",5),
//                new Rating("5678",4)
//                );
//    UserRating userRating = new UserRating();
//    userRating.setUserRating(rating);
//
//    return userRating;
//
//    }
}
