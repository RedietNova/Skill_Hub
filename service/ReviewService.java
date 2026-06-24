package Skill_Hub.service;
ReviewService

import model.Review;
import java.util.ArrayList;

public class  ReviewService {

    private ArrayList<Review> reviews;

    public ReviewService() {
        reviews = new ArrayList<>();
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void displayReviews() {

        for (Review review : reviews) {

            System.out.println(
                review.getRating()
                + " Stars : "
                + review.getComment()
            );
        }
    }
} 
