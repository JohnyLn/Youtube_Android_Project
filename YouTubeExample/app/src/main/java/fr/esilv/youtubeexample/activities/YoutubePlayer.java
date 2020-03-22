package fr.esilv.youtubeexample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import fr.esilv.youtubeexample.R;

//Helped by the video
//https://www.youtube.com/watch?v=W4hTJybfU7s by CodingWithMitch
public class YoutubePlayer extends AppCompatActivity {


    //Let's try some log to debug our code
    private static final String TAG = "Detail Activity";


    private static final String API_KEY = "AIzaSyALi0Hkmhzqv9iLVMbuy6UQb3hpZutfJ9k";
    YouTubePlayerView mYoutubePlayerView;
    Button btnPlay;
    //Youtube Listener
    YouTubePlayer.OnInitializedListener mOnInitializedListener;

    //Getter because the API_KEY is private
    public static String getApiKey (){
        return API_KEY;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Log.d(TAG,"On Create : Starting the activity");
        //Set the boutton
        btnPlay = (Button) findViewById(R.id.btnPlay);
        mYoutubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlay);

        //We initialized the Listener
        mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG,"On Click : Failed to initialize");

            }
        };

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //initialize(String, OnInitializedListener) with the String the API_KEY
                //https://developers.google.com/youtube/android/player/reference/com/google/android/youtube/player/YouTubePlayerView
                Log.d(TAG,"On Click : Intializing Youtube Player");

                mYoutubePlayerView.initialize(getApiKey(),mOnInitializedListener);

            }
        });



    }


    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_play);

        YouTubePlayerView youTubePlayerView =
                (YouTubePlayerView) findViewById(R.id.player);

        youTubePlayerView.initialize("YOUR API KEY",
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {

                        // do any work here to cue video, play video, etc.
                        youTubePlayer.cueVideo("5xVh-7ywKpE");
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {

                    }
                });
    }

    public class QuickPlayActivity extends YouTubeBaseActivity {


    }*/
}

