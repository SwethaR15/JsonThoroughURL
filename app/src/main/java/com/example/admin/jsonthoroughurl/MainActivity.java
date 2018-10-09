package com.example.admin.jsonthoroughurl;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ProgressDialog mProgressDialog;
    private ListView listView;
    private List<BookGS> bookGS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         listView = findViewById(R.id.list);

        String url = "https://github.com/Thirupathi76/SearchMap/raw/master/Parkingplaces/job_list.json";

        new ResponseAsync().execute(url);


    }

    private class ResponseAsync extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setTitle("get response Tutorial");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();

        }

        @Override
        protected String doInBackground(String... url) {
            String respURL = url[0];

            try {
                // Download Image from URL

                URL ur = new URL(respURL);
                InputStream is = ur.openConnection().getInputStream();

                StringBuffer buffer = new StringBuffer();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }

                Log.e("Why data ", buffer.toString());
                return buffer.toString();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            List<BookGS> bookGSList = new ArrayList<>();

            try {
                Log.i("***************",s);
                JSONObject object=new JSONObject(s);
                JSONArray array = object.getJSONArray("job_list");
                for (int i = 0; i < array.length(); i++) {


                    JSONObject list_obj = array.getJSONObject(i);

                    BookGS item = new BookGS();
                    item.setPosName(list_obj.getString("pos_name"));
                    item.setExperience(list_obj.getString("experience"));
                    item.setLocation(list_obj.getString("location"));
                    item.setSalRange(list_obj.getString("sal_range"));
                    item.setKeySkills(list_obj.getString("key_skills"));

                    bookGSList.add(item);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


            BookBA myAdapter1=new BookBA(getApplicationContext(),bookGSList);
            listView.setAdapter(myAdapter1);

            //progressBar.setVisibility(View.GONE);
            mProgressDialog.dismiss();

        }

    }
}
