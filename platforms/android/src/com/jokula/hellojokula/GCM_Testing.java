package com.jokula.hellojokula;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gcm.GCMRegistrar;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.plugin.gcm.GCMIntentService;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;


public class GCM_Testing extends Activity  {
	private GoogleCloudMessaging gcm =null;
	private String regid = null;
	private Context context= null;
	SharedPreferences pref ; 
	Editor editor ;
	protected void onCreate(Bundle savedInstanceState){
		  super.onCreate(savedInstanceState);
		 // setContentView(R.layout.gcm_testing);
		//  GCM_Token = (TextView)findViewById(R.id.gcm_testname);
		  pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
			
		   if( pref.getString("regId", null) == null){
				editor = pref.edit();
			    gcm = GoogleCloudMessaging.getInstance(this);
			    new Load_RegId().execute();
		   }else{
			  	startActivity(new Intent(GCM_Testing.this, testing.class));      
		   }
		    
		
	}
	
	class Load_RegId extends AsyncTask<String, String, String> {

		/**
		 * Before starting background thread Show Progress Dialog
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}


		/**
		 * getting Category JSON
		 * */
		protected String doInBackground(String... args) {
			// Building Parameters
			 if (gcm == null) 
             {
                      gcm = GoogleCloudMessaging.getInstance(context);
             }
			try {
				regid = gcm.register("639540991935");
			    HttpClient httpclient = new DefaultHttpClient();
		   	    HttpPost httppost = new HttpPost("http://testing.cupidic.com/register.php");
		   	 try {
		   	   List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		       nameValuePairs.add(new BasicNameValuePair("name", "jokula"));
		       nameValuePairs.add(new BasicNameValuePair("email", "email"));
		       nameValuePairs.add(new BasicNameValuePair("regId", regid));
		       httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		   	   httpclient.execute(httppost);
		   	    // clear text box
		     } catch (ClientProtocolException e) {
		         // TODO Auto-generated catch block
		     } catch (IOException e) {
		         // TODO Auto-generated catch block
		     }			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}     
			return null;
		}

		/**
		 * After completing background task Dismiss the progress dialog
		 * **/
		protected void onPostExecute(String file_url) {
			


			runOnUiThread(new Runnable() {
				public void run() {
					/**
					 * Updating parsed JSON data into ListView
					 * */
				//	GCM_Token.setText(regid+"What is this ?");
					if(regid==null){
						startActivity(new Intent(GCM_Testing.this, testing.class));
						
					}else{
						editor.putString("regId", regid);  // Saving string
					    editor.commit(); 
						startActivity(new Intent(GCM_Testing.this, testing.class));
						
					}
				  	
					
				}
			});

		}

	}
		
	

}


