package com.codefriday.mobile.android.bangkokunitrade.activity;



import com.codefriday.mobile.android.bangkokunitrade.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends Activity {

	private Handler mHandler = new Handler();
	private ImageView splash;
	boolean forcedStop = false;
	public void onDestroy() {
		super.onDestroy();
	}

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.splashscreen);
		
		
		splash = (ImageView) findViewById(R.id.splashimage);
		mHandler.postDelayed(runFadeIn, 1500);
	}

	private void goToNextActivity() {

		Intent intent = new Intent(SplashActivity.this, MainActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
		finish();
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {

		boolean r = false;
		if (keyCode == 4) {
			System.exit(0);
			r = true;
		}
		return r;
	}

	Runnable runFadeIn = new Runnable() {
		@Override
		public void run() {
			splash.setImageResource(R.drawable.ic_launcher);
			Animation anim = AnimationUtils.loadAnimation(SplashActivity.this,android.R.anim.fade_in);
			anim.setDuration(1500);
			anim.setFillAfter(true);
			splash.startAnimation(anim);
			mHandler.postDelayed(runFadeOut, 1500);
		}
	};

	Runnable runFadeOut = new Runnable() {

		@Override
		public void run() {
			splash.setImageResource(R.drawable.ic_launcher);
			Animation anim = AnimationUtils.loadAnimation(SplashActivity.this,
					android.R.anim.fade_out);
			anim.setDuration(1500);
			anim.setFillAfter(true);
			splash.startAnimation(anim);

			mHandler.postDelayed(runApp, 1500);
		}
	};

	Runnable runopen = new Runnable() {

		@Override
		public void run() {
			splash.setImageResource(R.drawable.ic_launcher);
			Animation anim = AnimationUtils.loadAnimation(SplashActivity.this,
					android.R.anim.fade_out);
			anim.setDuration(1500);
			anim.setFillAfter(true);
			splash.startAnimation(anim);

			mHandler.postDelayed(runApp, 1500);
		}
	};

	Runnable runApp = new Runnable() {
		@Override
		public void run() {
			goToNextActivity();
			
		}
	};
}