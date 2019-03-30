package com.kishan00747.truenews;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedbackFragment extends Fragment {



    RatingBar mRatingBar ;
    TextView mRatingScale;
    EditText mFeedback ;
    Button mSendFeedback ;
    int rating;
    String feedback;
    int uid;
    Boolean isInserted;
    int pid;

    public FeedbackFragment() {
        // Required empty public constructor
    }

    private void setViews(View view) {

        isInserted = true;
        mRatingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        mRatingScale = (TextView) view.findViewById(R.id.tvRatingScale);
        mFeedback = (EditText) view.findViewById(R.id.etFeedback);
        mSendFeedback = (Button) view.findViewById(R.id.btnSubmit);
        feedback = mFeedback.getText().toString();

        mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                mRatingScale.setText(String.valueOf(v));
                switch ((int) ratingBar.getRating()) {
                    case 1:
                        mRatingScale.setText("Very bad");
                        rating = 1;
                        break;
                    case 2:
                        mRatingScale.setText("Need some improvement");
                        rating = 2;
                        break;
                    case 3:
                        mRatingScale.setText("Good");
                        rating = 3;
                        break;
                    case 4:
                        mRatingScale.setText("Great");
                        rating = 4;
                        break;
                    case 5:
                        mRatingScale.setText("Awesome. I love it");
                        rating = 5;
                        break;
                    default:
                        mRatingScale.setText("");
                }
            }
        });
        mSendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mFeedback.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Please fill in feedback text box", Toast.LENGTH_LONG).show();
                } else {
                    //mFeedback.setText("");
                    //mRatingBar.setRating(0);
                    //isInserted= helper.insertFeedback(feedback,uid,pid,rating);

                    if (isInserted == true) {

                        Toast.makeText(getActivity(), "Thank you for sharing your feedback", Toast.LENGTH_LONG).show();

                    } else
                        Toast.makeText(getActivity(), "Feedback Error", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        setViews(view);



        return view;
    }

}


