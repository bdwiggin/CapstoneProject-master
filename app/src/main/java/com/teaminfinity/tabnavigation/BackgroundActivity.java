package com.teaminfinity.tabnavigation;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by BrandonWiggins on 01/03/2016.
 */
public class BackgroundActivity extends AsyncTask<String,Void,String> {

    Context ctx;

    BackgroundActivity(Context ctx){

        this.ctx=ctx;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {

        String reg_url = "http://10.56.83.22:80/db.soic.indiana.edu/~team50/register.php";
        String login_url = "http://db.soic.indiana.edu/~team50/login.php";


        String method = params[0];
        if(method.equals("register")){


            String firstname = params[1];
            String lastname = params[2];
            String email = params[3];
            String age = params[4];
            String foot = params[5];
            String inches = params[6];
            String weight = params[7];
            String username = params[8];
            String password = params[9];
            try {
                URL url = new URL(reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter =  new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));
                String data = URLEncoder.encode("firstname","UTF-8")+"="+URLEncoder.encode(firstname,"UTF-8")+"&"+
                        URLEncoder.encode("lastname","UTF-8")+"="+URLEncoder.encode(lastname,"UTF-8")+"&"+
                        URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"+
                        URLEncoder.encode("age","UTF-8")+"="+URLEncoder.encode(age,"UTF-8")+"&"+
                        URLEncoder.encode("foot","UTF-8")+"="+URLEncoder.encode(foot,"UTF-8")+"&"+
                        URLEncoder.encode("inches","UTF-8")+"="+URLEncoder.encode(inches,"UTF-8")+"&"+
                        URLEncoder.encode("weight","UTF-8")+"="+URLEncoder.encode(weight,"UTF-8")+"&"+
                        URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Registration Success...";


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
       Toast.makeText(ctx,result, Toast.LENGTH_LONG).show();
    }
}

