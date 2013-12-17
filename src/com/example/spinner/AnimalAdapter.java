package com.example.spinner;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AnimalAdapter extends ArrayAdapter<String> {
	private TextView text;
	private Context context;

	LayoutInflater layoutInflater;
	List<String> list;

	public AnimalAdapter(Context context, List<String> list) {
		super(context, R.layout.row_spinner);
		this.context = context;
		layoutInflater = LayoutInflater.from(context);
		this.list = list;
	}

	@Override
	public int getCount() {

		return list.size()-1;
	}

	@Override
	public long getItemId(int arg0) {

		return arg0;
	}
	@Override
	public String getItem(int position) {
		
		return (String) list.get(position);
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return getCustomView(position, convertView, parent);
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		return getCustomView(position, convertView, parent);

	};

	public View getCustomView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.row_spinner, parent,
					false);
		}
		text = (TextView) convertView.findViewById(android.R.id.text1);
		if (position == getCount()) {
			text.setText("");
			text.setHint(getItem(getCount())); // "Hint to be displayed"
		}else{
			text.setText(getItem(position));
		}

		return convertView;
	}

}
