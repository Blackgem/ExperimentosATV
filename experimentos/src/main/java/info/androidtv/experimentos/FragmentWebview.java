package info.androidtv.experimentos;

//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//public class Webview extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_webview);
//    }
//}

import android.content.Intent;
import android.net.Uri;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * <uses-permission android:name="android.permission.INTERNET"/>
 * Ponerlo en manifiest porque sino no tendra permiso para conexion.
 * Puedo inicialmente moverme por los menus pero luego pierdo el foco o no puedo pinchar, no se.
 * Puedo navegar pero no interactuar con una descarga al parecer.
 */


//public class Webview extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {

public class FragmentWebview extends Fragment {


    public FragmentWebview() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webview, container, false);
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_webview);

        WebView myWebView = (WebView) view.findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("https://www.amazon.es/appstore");

        return view;
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        WebView mWebView;
//        mWebView = (WebView) getActivity().findViewById(R.id.webView);
//        if (event.getAction() == KeyEvent.ACTION_DOWN) {
//            switch (keyCode) {
//                case KeyEvent.KEYCODE_BACK:
//                    if (mWebView.canGoBack()) {
//                        mWebView.goBack();
//                    } else {
//                        finish();
//                    }
//                    return true;
//            }
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}