package com.example.appreview;

import android.app.Activity;
import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewException;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
public class InAppReview {

    public static void askUserForReview(Activity activity) {

        ReviewManager manager = ReviewManagerFactory.create(activity);
        Task<ReviewInfo> request = manager.requestReviewFlow();
        request.addOnCompleteListener(task -> {
            try {
                if (task.isSuccessful()) {
                    Log.i("inAppReview", "requestReviewFlow: Success ");
                    // We can get the ReviewInfo object
                    ReviewInfo reviewInfo = task.getResult();
                    Task<Void> flow = manager.launchReviewFlow(activity, reviewInfo);
                    flow.addOnCompleteListener(task2 -> {
                        // The flow has finished. The API does not indicate whether the user
                        // reviewed or not, or even whether the review dialog was shown. Thus, no
                        // matter the result, we continue our  app flow.
                        Log.i("inAppReview", "launchReviewFlow: Success ");
                    }).addOnFailureListener(e -> {
                        // There was some problem, continue regardless of the result.
                        Log.i("inAppReview", "launchReviewFlow: Failed ");
                    });

                } else {
                    // There was some problem, continue regardless of the result.
                    String reviewErrorCode = ((ReviewException) task.getException()).getMessage();
                    Log.i("inAppReview", "launchReviewFlow: Failed " + reviewErrorCode);
                }
            } catch (Exception ex) {
                Log.i("inAppReview", "requestReviewFlow Exception: " + ex);
            }
        }).addOnFailureListener(e -> Log.i("inAppReview", "requestReviewFlow Exception: " + e));
    }
}
