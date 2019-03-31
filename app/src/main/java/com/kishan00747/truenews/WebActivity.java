package com.kishan00747.truenews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = (WebView) findViewById(R.id.web_view);

        String strURL = getIntent().getStringExtra("URL");

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl(strURL);


    }
}
