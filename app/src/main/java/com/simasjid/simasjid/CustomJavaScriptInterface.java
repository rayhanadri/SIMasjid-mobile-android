package com.simasjid.simasjid;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class CustomJavaScriptInterface {
    Context mContext;

    /**
     * Instantiate the interface and set the context
     */
    CustomJavaScriptInterface(Context c) {
        mContext = c;
    }


    /**
     * retrieve the ids
     */
    public void getIds(final String myIds) {

        //Do somethings with the Ids

    }

    @JavascriptInterface
    public void openScanner() {
        Intent intent = new Intent(mContext, scanner.class);
        mContext.startActivity(intent);
    }

    @JavascriptInterface
    public void showToast() {
        Toast.makeText(mContext, "Hello world", Toast.LENGTH_SHORT).show();
    }


}