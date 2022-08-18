package com.example.tennispro;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class EstadisticasFR extends Fragment {
    public TextView txt_nombre,txt_efectividad,txt_nivel,txt_partido,txt_res1,txt_res2,txt_res3,txt_res4,txt_res5;
    private TextView txt_win1,txt_win2,title_partidosGanados,txt_set1,txt_set2,title_setGanados,txt_remont1,txt_remont2;
    private TextView txt_remontC1,txt_remontC2,txt_games1,txt_games2,text_ganados,txt_tercer_set1,txt_tercer_set2,txt_tercer_set;
    private TextView txt_tie_break1,txt_tie_break2,txt_tie_break,txt_remontadas,txt_contra,res_1,res_2,res_3,res_4,res_5;
    private ImageView civ1;
    private CardView c1D,c1L,c2D,c2L,c3D,c3L,c4L,c4D;
    private GaleriaFR frag_galeria;
    private RequestQueue requestQueueImage,requestQueueID,requestQueueGenerales;
    private double porcientoW=0,porcientoS=0,porcientoG=0,porcientoTie=0,porcientoTercer=0,remontadas=0,porcientoRemont=0,porcientoAgaints;
    private String idPlayer;
    private ProgressDialog progress;
    private Url urlx;
    private String urlId,urlgenerales;
    Personajes pers;




    public static EstadisticasFR newInstance(String param1, String param2) {
        EstadisticasFR fragment = new EstadisticasFR();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_estadisticas_f_r, container, false);

        urlx = new Url();
        pers = new Personajes();
        requestQueueID = Volley.newRequestQueue(getActivity());

        txt_res1 = (TextView) vista.findViewById(R.id.res_1);
        txt_res2 = (TextView) vista.findViewById(R.id.res_2);
        txt_res3 = (TextView) vista.findViewById(R.id.res_3);
        txt_res4 = (TextView) vista.findViewById(R.id.res_4);
        txt_res5 = (TextView) vista.findViewById(R.id.res_5);
        txt_win1 = (TextView) vista.findViewById(R.id.txt_win1);
        txt_win2 = (TextView) vista.findViewById(R.id.txt_win2);
        title_partidosGanados = (TextView) vista.findViewById(R.id.text_partidos_ganados);
        txt_set1 = (TextView) vista.findViewById(R.id.txt_set1);
        txt_set2 = (TextView) vista.findViewById(R.id.txt_set2);
        title_setGanados = (TextView) vista.findViewById(R.id.text_setGanados);
        txt_remont1 = (TextView) vista.findViewById(R.id.txt_remont1);
        txt_remont2 = (TextView) vista.findViewById(R.id.txt_remont2);
        txt_remontC1 = (TextView) vista.findViewById(R.id.txt_remontC1);
        txt_remontC2 = (TextView) vista.findViewById(R.id.txt_remontC2);
        txt_games1 = (TextView) vista.findViewById(R.id.txt_games1);
        txt_games2 = (TextView) vista.findViewById(R.id.txt_games2);
        text_ganados = (TextView) vista.findViewById(R.id.text_ganados);
        txt_tercer_set1 = (TextView) vista.findViewById(R.id.txt_tercer_set1);
        txt_tercer_set2 = (TextView) vista.findViewById(R.id.text_tercer_set2);
        txt_tercer_set = (TextView) vista.findViewById(R.id.text_tercerSet);
        txt_tie_break1 = (TextView) vista.findViewById(R.id.txt_tie_break1);
        txt_tie_break2 = (TextView) vista.findViewById(R.id.txt_tie_break2);
        txt_tie_break = (TextView) vista.findViewById(R.id.text_tie_break);
        txt_remontadas = (TextView) vista.findViewById(R.id.text_remontadasF);
        txt_contra = (TextView) vista.findViewById(R.id.text_remontadasC);
        res_1 = (TextView) vista.findViewById(R.id.res_1);
        res_2 = (TextView) vista.findViewById(R.id.res_2);
        res_3 = (TextView) vista.findViewById(R.id.res_3);
        res_4 = (TextView) vista.findViewById(R.id.res_4);
        res_5 = (TextView) vista.findViewById(R.id.res_5);
        c1D = (CardView) vista.findViewById(R.id.card1D);
        civ1 = (ImageView) vista.findViewById(R.id.CIV_id);
        requestQueueImage = Volley.newRequestQueue(getActivity());
        requestQueueGenerales = Volley.newRequestQueue(getActivity());
        //  Bundle bundle=getIntent().getExtras();
        //idPlayer=getIntent().getStringExtra("user");
        Resultados1 res1 = null;
        pers = new Personajes();
     //   datosGenerales(1);





            return vista;
        }

}