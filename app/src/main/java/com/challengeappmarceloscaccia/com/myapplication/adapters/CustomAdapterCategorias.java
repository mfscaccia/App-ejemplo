package com.challengeappmarceloscaccia.com.myapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.challengeappmarceloscaccia.com.myapplication.models.Categorias;
import com.challengeappmarceloscaccia.com.myapplication.R;

import java.util.List;

public class CustomAdapterCategorias extends ArrayAdapter {

    String[] spinnerTitles;
    int[] spinnerImages;
    String[] spinnerPopulation;
    Context mContext;
    String[] ItemID;
    List<Categorias> mCategoriesList;

    public CustomAdapterCategorias(Context context, List<Categorias> categoriesList) {
        super(context, R.layout.custom_spinner_row, categoriesList);
        this.mCategoriesList = categoriesList;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mCategoriesList.size();
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
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.mTitulo.setText(mCategoriesList.get(position).getName());
        mViewHolder.mDetalle.setText(mCategoriesList.get(position).getDescription());

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
