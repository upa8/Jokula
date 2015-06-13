package com.jokula.hellojokula;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

public class AlertDialogManager  {
	public void showAlertDialog(Context context, String title, String message,
			Boolean status) {
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();

		// Setting Dialog Title
		alertDialog.setTitle(title);

		// Setting Dialog Message
		alertDialog.setMessage(message);

		if(status != null)
			// Setting alert dialog icon
	//		alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

		// Setting OK Button
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				
			}
		});

		// Showing Alert Message
		alertDialog.show();
	}
	public void showThanePoliceDialog(Context context, String title, String message,String phone,
			Boolean status){
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();

		// Setting Dialog Title
		alertDialog.setTitle(title);

		// Setting Dialog Message
		alertDialog.setMessage(message);
		final String number = phone.toString();

		if(status != null)
			// Setting alert dialog icon
	//		alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

		// Setting OK Button
		alertDialog.setButton("Call", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
			//	Intent callIntent = new Intent(Intent.ACTION_CALL);
			//	callIntent.setData(Uri.parse("tel: "+ number));
			//	startActivity(callIntent);
 
				
			}
		});

		// Showing Alert Message
		alertDialog.show();

	}
}
