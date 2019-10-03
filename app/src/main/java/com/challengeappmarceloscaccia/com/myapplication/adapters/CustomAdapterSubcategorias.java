package com.challengeappmarceloscaccia.com.myapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.challengeappmarceloscaccia.com.myapplication.R;
import com.challengeappmarceloscaccia.com.myapplication.models.Subcategorias;

import java.util.List;

public class CustomAdapterSubcategorias extends ArrayAdapter {

    String[] spinnerTitles;
    int[] spinnerImages;
    String[] spinnerPopulation;
    Context mContext;
    String[] ItemID;
    List<Subcategorias> mSubcategoriesList;

    public CustomAdapterSubcategorias(Context context, List<Subcategorias> subcategoriesList) {
        super(context, R.layout.custom_spinner_row, subcategoriesList);
        this.mSubcategoriesList = subcategoriesList;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mSubcategoriesList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.custom_spinner_row, parent, false);
            mViewHolder.mTitulo = (TextView) convertView.findViewById(R.id.tvTitulo);
            mViewHolder.mDetalle = (TextView) convertView.findViewById(R.id.tvDetalle);
            mViewHolder.mDetalle.setVisibility(View.GONE);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.mTitulo.setText(mSubcategoriesList.get(position).getName());
        mViewHolder.mDetalle.setText(mSubcategoriesList.get(position).getDescription());

        return convertView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    private static class ViewHolder {
        TextView mTitulo;
        TextView mDetalle;
    }
}
