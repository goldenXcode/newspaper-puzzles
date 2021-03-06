package ws.crandell.newspaperpuzzles.crossword;

import ws.crandell.newspaperpuzzles.crossword.versions.AndroidVersionUtils;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;

import ws.crandell.newspaperpuzzles.R;


public class HTMLActivity extends Activity {
	protected AndroidVersionUtils utils = AndroidVersionUtils.Factory.getInstance();
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        utils.holographic(this);
        utils.finishOnHomeButton(this);
        this.setContentView(R.layout.cw_html_view);

        WebView webview = (WebView) this.findViewById(R.id.webkit);
        Uri u = this.getIntent()
                    .getData();
        webview.loadUrl(u.toString());

        Button done = (Button) this.findViewById(R.id.closeButton);
        done.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    HTMLActivity.this.finish();
                }
            });
    }
}
