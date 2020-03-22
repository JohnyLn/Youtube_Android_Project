package fr.esilv.youtubeexample.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import fr.esilv.youtubeexample.R;

public class DetailActivity extends YouTubeBaseActivity {

	private static final String VIDEO_ID = "VIDEO_ID";
	private String videoId;
	private TextView textView;


	//___________YouTube Player____________________
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



	//_______________________________________________________



	public static void start(Context context, String videoId) {
		Intent intent = new Intent(context, DetailActivity.class);
		intent.putExtra(VIDEO_ID, videoId);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		Intent intent = getIntent();
		if (intent != null) {
			videoId = intent.getStringExtra(VIDEO_ID);
		}

		textView = findViewById(R.id.textView);
		textView.setText(videoId);


		//_________Youtube Player_________________

		Log.d(TAG,"On Create : Starting the activity");
		//Set the button
		btnPlay =  findViewById(R.id.btnPlay);
		mYoutubePlayerView = findViewById(R.id.youtubePlay);

		//We initialized the Listener
		mOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
			@Override
			public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
				Log.d(TAG,"On Click : Done initializing");
				youTubePlayer.loadVideo(videoId);

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
		//_____________________________________


	}
}
