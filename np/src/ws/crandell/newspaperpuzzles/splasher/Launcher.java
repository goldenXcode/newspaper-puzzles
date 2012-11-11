package ws.crandell.newspaperpuzzles.splasher;




import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import ws.crandell.newspaperpuzzles.crossword.BrowseActivity;
import ws.crandell.newspaperpuzzles.sudoku.gui.FolderListActivity;
import ws.crandell.newspaperpuzzles.wordsearch.view.WordSearchActivity;

import ws.crandell.newspaperpuzzles.R;

public class Launcher extends Activity{


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher_layout);
//        toSplashScreen();
        
//        Button button = (Button) findViewById(R.id.imageButton1);
//        button.setOnClickListener(this);
//        LinearLayout layout = (LinearLayout)findViewById(R.id.linearLayout);
//        
//        // Create the adView
//        // Please replace MY_BANNER_UNIT_ID with your AdMob Publisher ID
//        AdView adView = new AdView(this, AdSize.BANNER, "a14f2dc47c5ade3");
//      
//        // Add the adView to it
//        layout.addView(adView);
//         
//        // Initiate a generic request to load it with an ad
//        AdRequest request = new AdRequest();
//        request.setTesting(true);
//
//        adView.loadAd(request);       

        
        final ImageButton mybutton = (ImageButton) findViewById(R.id.imageButton); 
        mybutton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				String str ="https://play.google.com/store/apps/details?id=ws.crandell.newspaperpuzzles";
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(str)));
				
			} 
            
        });
        
        
        final ImageButton mybutton1 = (ImageButton) findViewById(R.id.imageButton1);
        mybutton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	startActivity(new Intent(Launcher.this, BrowseActivity.class));
            	
            }
        });
        final ImageButton mybutton2 = (ImageButton) findViewById(R.id.imageButton2);
        mybutton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	startActivity(new Intent(Launcher.this, FolderListActivity.class));
            	
            }
        });
        final ImageButton mybutton3 = (ImageButton) findViewById(R.id.imageButton3);
        mybutton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	startActivity(new Intent(Launcher.this, WordSearchActivity.class));
            	
            }
        });
        

        
//        final Button button2 = (Button) findViewById(R.id.imageButton2);
//        button2.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Perform action on click
//            	startActivity(new Intent(Launcher.this, FolderListActivity.class));
//            }
//        });
//        final Button button3 = (Button) findViewById(R.id.imageButton3);
//        button3.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Perform action on click
//            	startActivity(new Intent(Launcher.this, WordSearchActivity.class));
//            }
//        });
        
    }
	
	
}
