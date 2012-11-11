package ws.crandell.newspaperpuzzles.splasher;

import ws.crandell.newspaperpuzzles.R;
import ws.crandell.newspaperpuzzles.splasher.Launcher;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splasher extends Activity {
	

	
    /** Called when the activity is first created. */
	/**
	 * Animation Starts First. see other for final output or app start(fixMe)
	 */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splasher_layout);

        beginAnimation();
//        toSplashScreen();
    }
    /**
     * Here it is the animation is starting...
     */
	private void beginBackAnimation() {
		

		ImageView imageback = (ImageView) findViewById(R.id.SplasherPencil);
		Animation imageAnimback = AnimationUtils.loadAnimation(this, R.anim.splasher_pencil);
		

		imageback.startAnimation(imageAnimback);
		
				/**
				 * Android stuff
				 */
				//Prepare end of animation event
				imageAnimback.setAnimationListener(new AnimationListener(){
					/**
					 * Open a new activity
					 */
					public void onAnimationEnd(Animation animation){
						//All Done Open Main Menu 
						startActivity(new Intent(Splasher.this, Launcher.class));
						// editor.putString("PlayING", "Now");
						// editor.commit();
					}
					/**
					 * doNothing();
					 */
					public void onAnimationRepeat(Animation animation){
					}
					/**
					 * doNothing();
					 */
					public void onAnimationStart(Animation animation){
					}		
				});
		
	}

    /**
     * Here it is the animation is starting...
     */
	private void beginAnimation() {


		
		ImageView pencil = (ImageView) findViewById(R.id.SplasherPencil);
		Animation pencilAnim = AnimationUtils.loadAnimation(this, R.anim.splasher_pencilout);
		pencil.startAnimation(pencilAnim);
		
		//Header animation
		TextView header = (TextView) findViewById(R.id.SplasherTop);
		Animation headerAnim = AnimationUtils.loadAnimation(this, R.anim.splasher_text);
		header.startAnimation(headerAnim);

		//Footer animation
		TextView footer = (TextView) findViewById(R.id.SplasherBottom);
		Animation footerAnim = AnimationUtils.loadAnimation(this, R.anim.splasher_text);
		footer.startAnimation(footerAnim);

		//Image animation
		ImageView image = (ImageView) findViewById(R.id.SplasherPaper);
		Animation imageAnim = AnimationUtils.loadAnimation(this, R.anim.splasher_news);
		image.startAnimation(imageAnim);
		
		/**
		 * Android stuff
		 */
		//Prepare end of animation event
		pencilAnim.setAnimationListener(new AnimationListener(){
			/**
			 * Open a new activity
			 */
			public void onAnimationEnd(Animation animation){
				//All Done Open Main Menu PlayING
//				startActivity(new Intent(Splasher.this, WordSearchActivity.class));
//		        editor.putString("PlayING", "Now");
//		        editor.commit();


				beginBackAnimation();
				
			}
			/**
			 * doNothing();
			 */
			public void onAnimationRepeat(Animation animation){
			}
			/**
			 * doNothing();
			 */
			public void onAnimationStart(Animation animation){
			}		
		});
		
		
		
	}
	/**
	 * onPause use to release resources.
	 * Always Android 
	 */
	@Override
	protected void onPause() {
		super.onPause();

//		
		//Clear Animation for next time
		
		TextView header = (TextView) findViewById(R.id.SplasherTop);
		header.clearAnimation();
		
		TextView footer = (TextView) findViewById(R.id.SplasherBottom);
		footer.clearAnimation();
		
		ImageView paper = (ImageView) findViewById(R.id.SplasherPaper);
		paper.clearAnimation();
		
		ImageView pencil = (ImageView) findViewById(R.id.SplasherPencil);
		pencil.clearAnimation();
	}

	/**
	 * Use to set preference to start splasher
	 */
	@Override
	protected void onResume() {
		super.onResume();
//		beginAnimation();
		toSplashScreen();

//		this.finish();
	
		
	}
	
	/**
	 * Use to set preference to stop splasher
	 */
	@Override
	protected void onRestart() {
		super.onRestart();
//		beginAnimation();
//		toSplashScreen();

		startActivity(new Intent(this, Launcher.class));
//		this.finish();
	
		
	}
	
	/**
	 * setup to check for running the splash or the app.
	 */
	  private void toSplashScreen() {
		  	
		  beginAnimation();
		  

		  }
	
}