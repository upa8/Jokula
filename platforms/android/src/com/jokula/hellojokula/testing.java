package com.jokula.hellojokula;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import im.delight.android.webview.AdvancedWebView;

@SuppressLint("NewApi")
public class testing extends Activity implements AdvancedWebView.Listener {

    private AdvancedWebView mWebView;
    ProgressDialog progressDialog;
    AlertDialogManager alert;
    ConnectionDetector cd;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my);
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
       
        mWebView = (AdvancedWebView) findViewById(R.id.webview);
        mWebView.setListener(this, this);
        mWebView.addHttpHeader("X-Requested-With", "GSTORE");
    	 
    	cd = new ConnectionDetector(getApplicationContext());
    	if (!cd.isConnectingToInternet()) {
					alert.showAlertDialog(testing.this,
					"Internet Connection Error",
					"Please connect to working Internet connection", false);
			// stop executing code by return
			return;
		}else{

	        mWebView.loadUrl("http://jokula.cupidic.com");
	        mAdView.loadAd(adRequest);
	        
		} 
    	

        // ...
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWebView.onResume();
        // ...
    }

    @Override
    protected void onPause() {
        mWebView.onPause();
        // ...
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mWebView.onDestroy();
        // ...
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        mWebView.onActivityResult(requestCode, resultCode, intent);
        // ...
    }

    @Override
    public void onBackPressed() {
        if (!mWebView.onBackPressed()) { return; }
        // ...
        super.onBackPressed();
    }


    @Override
    public void onPageFinished(String url) {
    	try {
			if (progressDialog.isShowing()) {
				progressDialog.dismiss();
				progressDialog = null;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
    	
    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {
    	cd = new ConnectionDetector(getApplicationContext());
    	if (!cd.isConnectingToInternet()) {
			// Internet Connection is not present
			// startWebView("file:///android_asset/index.html");

			alert.showAlertDialog(testing.this,
					"Internet Connection Error",
					"Please connect to working Internet connection", false);
			// stop executing code by return
			return;
		} 
    	
    	
    	
    }

    @Override
    public void onDownloadRequested(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) { }

    @Override
    public void onExternalPageRequest(String url) {
    	
    	
    }

	@Override
	public void onPageStarted(String url, Bitmap favicon) {
		// TODO Auto-generated method stub
    	cd = new ConnectionDetector(getApplicationContext());
    	if (!cd.isConnectingToInternet()) {
			// Internet Connection is not present
			// startWebView("file:///android_asset/index.html");

			alert.showAlertDialog(testing.this,
					"Internet Connection Error",
					"Please connect to working Internet connection", false);
			// stop executing code by return
			return;
		} 
    	

		if (progressDialog == null) {
			// in standard case YourActivity.this
		
			progressDialog = new ProgressDialog(testing.this);
			progressDialog.setMessage("Loading...");
			progressDialog.show();
		}
		

	}

}