package com.bangbangcoding.screenmirror.easybrowser.web.webkit;

import android.os.Handler;
import android.os.Message;

import com.bangbangcoding.screenmirror.easybrowser.contract.IWebView;
import com.bangbangcoding.screenmirror.easybrowser.entity.bo.ClickInfo;

import java.lang.ref.WeakReference;

public class WebViewClickHandler extends Handler {

    public static final String KEY_URL = "url";

    private WeakReference<IWebView> webViewWeakReference;

    public WebViewClickHandler(IWebView webView) {
        webViewWeakReference = new WeakReference<>(webView);
    }

    @Override
    public void handleMessage(Message msg) {
        IWebView webView = webViewWeakReference.get();
        if (webView == null || webView.getOnWebInteractListener() == null) {
            return;
        }
        if (msg.getData() == null) {
            return;
        }
        ClickInfo clickInfo = new ClickInfo();
        clickInfo.url = msg.getData().getString(KEY_URL);
        clickInfo.type = msg.what;
        webView.getOnWebInteractListener().onLongClick(clickInfo);
    }
}
