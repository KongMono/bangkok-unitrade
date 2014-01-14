package com.codefriday.mobile.android.bankkokunitrade.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.codefriday.mobile.android.bangkokunitrade.R;
import com.codefriday.mobile.android.bankkokunitrade.util.Util;

public class ListMainDialogAdapter extends ArrayAdapter<String> {

	protected Context context;
	private String[] itemsData;
	private LayoutInflater inflater;
	ViewHolder holder;
	AQuery aq;

	int textViewResourceId;

	public class ViewHolder {
		public TextView txtTitle;
		public ImageView logo;
		public int position;
	}

	public ListMainDialogAdapter(Context context, int textViewResourceId,String[] str) {
		super(context, textViewResourceId, str);
		inflater = LayoutInflater.from(context);
		this.context = context;
		this.itemsData = str;
		this.textViewResourceId = textViewResourceId;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		View view = convertView;
		if (convertView == null) {
			view = inflater.inflate(textViewResourceId, parent, false);
			holder = new ViewHolder();
			holder.txtTitle = (TextView) view.findViewById(R.id.text);
			holder.txtTitle.setTypeface(Util.getBoldFont(context));
			holder.txtTitle.setTextSize(40f);
			holder.logo = (ImageView) view.findViewById(R.id.logo);
			view.setTag(holder);

		} else {
			holder = (ViewHolder) view.getTag();
		}
		
		holder.txtTitle.setText(itemsData[position]);
		holder.logo.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher));
		return view;
	}
}
