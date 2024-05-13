package com.akp.android.Basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.akp.android.R;

public class ChangePasswordScreen extends AppCompatActivity {

//    EditText edt_new_pass;
//    private EditText edt_old_pass, edt_conf_pass;
//    private Button btn_sendotp;
//    String UserId;
//
ImageView sliding_menu;
    private WebView myWebView;
    String UserId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password_screen);
        SharedPreferences sharedPreferences = getSharedPreferences("login_preference",MODE_PRIVATE);
         UserId = sharedPreferences.getString("U_id", "");
        sliding_menu = findViewById(R.id.back_img);
        myWebView = findViewById(R.id.myWebView);
        sliding_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        // Configure related browser settings
        myWebView.getSettings().setLoadsImagesAutomatically(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        // Configure the client to use when opening URLs
        myWebView.setWebViewClient(new WebViewClient());
        // Load the initial URL
        myWebView.loadUrl("http://dhriti.signaturesoftware.org/API/ChangePassword?EmpId="+ UserId);
    }
}
    /*    edt_new_pass = (EditText) findViewById(R.id.edt_new_pass);
        edt_old_pass = (EditText) findViewById(R.id.edt_old_pass);
        edt_conf_pass = (EditText) findViewById(R.id.edt_conf_pass);
        btn_sendotp = (Button) findViewById(R.id.btn_sendotp);

        findViewById(R.id.back_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_sendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_old_pass.getText().toString().equalsIgnoreCase("")) {
                    edt_old_pass.setError("Fields can't be blank!");
                    edt_old_pass.requestFocus();
                } else if (edt_new_pass.getText().toString().equalsIgnoreCase("")) {
                    edt_new_pass.setError("Fields can't be blank!");
                    edt_new_pass.requestFocus();
                } else if (edt_conf_pass.getText().toString().equalsIgnoreCase("")) {
                    edt_conf_pass.setError("Fields can't be blank!");
                    edt_conf_pass.requestFocus();
                }
                else if(!edt_new_pass.getText().toString().equals(edt_conf_pass.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Password Not matched!", Toast.LENGTH_LONG).show();
                }
                else {
//                    changePassword();
                } }});
    }

    public void changePassword() {
        final ProgressDialog progressDialog = new ProgressDialog(ChangePasswordScreen.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, AppUrls.baseUrl + "ChangePassword", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressDialog.dismiss();
                String jsonString = response;
                jsonString = jsonString.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", " ");
                jsonString = jsonString.replace("<string xmlns=\"http://examcoach.in/\">", " ");
                jsonString = jsonString.replace("</string>", " ");
                try {
                    JSONObject object = new JSONObject(jsonString);
                    if (object.getString("msg").equalsIgnoreCase("Success")) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ChangePasswordScreen.this, object.getString("msg"), Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(ChangePasswordScreen.this, "Internet connection is slow Or no internet connection", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                HashMap<String, String> params = new HashMap<>();
                params.put("UserId", UserId);
                params.put("OldPassword", edt_old_pass.getText().toString().trim());
                params.put("NewPassword", edt_new_pass.getText().toString().trim());
//                params.put("confirm_password", edt_conf_pass.getText().toString().trim());
                return params;
                // return super.getParams();
            }
        };
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                30000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        RequestQueue requestQueue = Volley.newRequestQueue(ChangePasswordScreen.this);
        requestQueue.add(stringRequest);

    }
}*/