package com.challengeappmarceloscaccia.com.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.challengeappmarceloscaccia.com.myapplication.Interfaces.CategoriasAPI;
import com.challengeappmarceloscaccia.com.myapplication.Interfaces.LocalizacionesAPI;
import com.challengeappmarceloscaccia.com.myapplication.Interfaces.OnBudgetCreationListener;
import com.challengeappmarceloscaccia.com.myapplication.Interfaces.SubcategoriasAPI;
import com.challengeappmarceloscaccia.com.myapplication.adapters.CustomAdapterCategorias;
import com.challengeappmarceloscaccia.com.myapplication.adapters.CustomAdapterLocalizaciones;
import com.challengeappmarceloscaccia.com.myapplication.adapters.CustomAdapterSubcategorias;
import com.challengeappmarceloscaccia.com.myapplication.models.Categorias;
import com.challengeappmarceloscaccia.com.myapplication.models.Localizacion;
import com.challengeappmarceloscaccia.com.myapplication.models.Subcategorias;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BudgetsCreationFragment extends Fragment {
    private OnBudgetCreationListener mListener;
    private List<Categorias> categoriesList;
    private List<Subcategorias> subcategoriesList;
    private List<Localizacion> localizacionesList;

    public BudgetsCreationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_budgets_creation, container, false);
        final Spinner spinnerCateg;
        final Spinner spinnersubcat;
        final Spinner spinnerLocaliza;
        final Context context = inflater.getContext();
        spinnerCateg=(Spinner)view.findViewById(R.id.spCategoria);
        spinnersubcat=(Spinner)view.findViewById(R.id.spSubcategoria);
        spinnerLocaliza=(Spinner)view.findViewById(R.id.spLocalizacion);

        spinnerCateg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              Toast.makeText(context,categoriesList.get(position).getId(),Toast.LENGTH_LONG).show();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(SubcategoriasAPI.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                SubcategoriasAPI subcategoriasapi = retrofit.create(SubcategoriasAPI.class);
                Call<List<Subcategorias>> call = subcategoriasapi.getSubcategoria(categoriesList.get(position).getId());

                call.enqueue(new Callback<List<Subcategorias>>() {
                    @Override
                    public void onResponse(Call<List<Subcategorias>> call, Response<List<Subcategorias>> response) {

                        subcategoriesList = response.body();
                        CustomAdapterSubcategorias mCustomAdapterSubcat = new CustomAdapterSubcategorias(context, subcategoriesList);
                        mCustomAdapterSubcat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinnersubcat.setAdapter(mCustomAdapterSubcat);
                    }

                    @Override
                    public void onFailure(Call<List<Subcategorias>> call, Throwable t) {
                        Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(CategoriasAPI.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

        CategoriasAPI categoriasapi = retrofit.create(CategoriasAPI.class);
        Call<List<Categorias>> call = categoriasapi.getCategorias();

        call.enqueue(new Callback<List<Categorias>>() {
            @Override
            public void onResponse(Call<List<Categorias>> call, Response<List<Categorias>> response) {

                categoriesList = response.body();
                CustomAdapterCategorias mCustomAdapter = new CustomAdapterCategorias(context, categoriesList);
                mCustomAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerCateg.setAdapter(mCustomAdapter);
            }

            @Override
            public void onFailure(Call<List<Categorias>> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        retrofit = new Retrofit.Builder()
                .baseUrl(LocalizacionesAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LocalizacionesAPI localizacionesapi = retrofit.create(LocalizacionesAPI.class);
        Call<List<Localizacion>> callLocalizaApi = localizacionesapi.getLocalizaciones();

        callLocalizaApi.enqueue(new Callback<List<Localizacion>>() {
            @Override
            public void onResponse(Call<List<Localizacion>> callLocalizaApi, Response<List<Localizacion>> response) {

                localizacionesList = response.body();
                CustomAdapterLocalizaciones mCustomAdapterLocalizaciones = new CustomAdapterLocalizaciones(context, localizacionesList);
                mCustomAdapterLocalizaciones.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerLocaliza.setAdapter(mCustomAdapterLocalizaciones );
            }

            @Override
            public void onFailure(Call<List<Localizacion>> callLocalizaApi, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onBudgetCreationGuardarClickListener();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBudgetCreationListener) {
            mListener = (OnBudgetCreationListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
