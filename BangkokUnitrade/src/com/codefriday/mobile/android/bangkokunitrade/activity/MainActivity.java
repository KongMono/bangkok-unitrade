package com.codefriday.mobile.android.bangkokunitrade.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.codefriday.mobile.android.bangkokunitrade.R;
import com.codefriday.mobile.android.bankkokunitrade.adapters.ListMainDialogAdapter;
import com.codefriday.mobile.android.bankkokunitrade.util.Util;

public class MainActivity extends Activity implements OnClickListener{
	private EditText edittxtUserName,edittxtPassword;
	private Button btnlogin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);
		
		edittxtUserName = (EditText) findViewById(R.id.edittxtUserName);
		edittxtPassword = (EditText) findViewById(R.id.edittxtPassword);
		btnlogin = (Button)findViewById(R.id.btnlogin);
		
		edittxtUserName.setHint("UserName");
		edittxtPassword.setHint("Password");
		
		btnlogin.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		dialogList();
	}
	
	private void dialogList() {
		
		final Builder helpBuilder = new Builder(this);
		final LayoutInflater inflater = getLayoutInflater();
		final View view = inflater.inflate(R.layout.dialog_list, null);
		view.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
		helpBuilder.setView(view);

		final AlertDialog helpDialog = helpBuilder.create();
		helpDialog.show();

		final ListView list = (ListView) view.findViewById(R.id.ls);
		list.setSmoothScrollbarEnabled(true);
		Util.setListViewHeightBasedOnChildren(list);
        String [] station = getResources().getStringArray(R.array.list_array);
        list.setAdapter(new ListMainDialogAdapter(MainActivity.this, R.layout.item_list, station));
        list.setOnItemClickListener(new OnItemClickListener() {
        	
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg) {
				
				list.getItemAtPosition(position).toString();
				Toast.makeText(MainActivity.this, list.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
				helpDialog.dismiss();
			}
		});
	}

}
