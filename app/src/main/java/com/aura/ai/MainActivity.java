package com.aura.ai;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Hide top action bar
        if (getActionBar() != null) {
            getActionBar().hide();
        }

        WebView webView = findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        
        // CRITICAL: Enable Javascript and LocalStorage for the React App!
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        
        // Prevents links from opening in the external Chrome app
        webView.setWebViewClient(new WebViewClient()); 
        
        // Load the massive UI file from the assets folder
        webView.loadUrl("file:///android_asset/index.html");
    }
}
