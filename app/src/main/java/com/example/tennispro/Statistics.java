package com.example.tennispro;

import android.app.ProgressDialog;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
    private List<Resultados> result;
    private List<Integer>enteros;

    private ArrayList<Personajes> ListDatos;
    private Resultados1 res;

    public int g1=0,g2=0,s1=0,s2=0,w1=0,w2=0,l1=0,l2=0,tie1=0,tie2=0,tercer1=0,tercer2=0,remont1=0,remont2=0,contra1=0,contra2=0,gamesT1=0,gamesT2=0,setsT1=0,setsT2=0,tieT1=0,tieT2=0,tercerT1=0,tercerT2=0,x=0;
    public int gx=0,sx=0,wx=0,lx=0,tiex=0,tercerx=0,remontx=0,contrax=0,c=0,porcientoEfe=0;
    public int totalW=0,totalRemont=0,totalTercer=0,totalG=0,totalS=0,totalTie=0, superTotalG=0, superTotalS=0,restaTercer=0,restaTie=0;
    private Button grid,list,generales;
    private RequestQueue requestQueue,requestQueueGames1,requestQueueGames2,requestQueueSets1,requestQueueSets2;
    private RequestQueue requestQueueWinner1,requestQueueWinner2,requestQueueLoser1,requestQueueLoser2,requestQueueTie_break1;
    private RequestQueue requestQueueTie_break2,requestQueueTercer1,requestQueueTercer2,requestQueueRemontada1,requestQueueRemontada2;
    private RequestQueue requestQueueContra1,requestQueueContra2,requestQueuegamesT1,requestQueuegamesT2,requestQueueSetsT1,requestQueueSetsT2;
    private RequestQueue requestQueueTercerT1,requestQueueTercerT2,requestQueueTieT1,requestQueueTieT2,requestQueueLast;
    private RequestQueue requestQueueGenerales;
    private String url="/",deber,error,conect,charge,nombre,apellido;
    private String uno="",dos="",urlImagen;
    private List<String>title1,title2,title3,title4;
    private List<Integer>title;
    private Personajes personaje=null;
    private Personajes pers=null;
    private static  Url urlx=new Url();

    private static final String urlGames1=urlx.getUrl()+"/padel/consulta_games1.php?player1=";
    private static final String urlGames2=urlx.getUrl()+"/padel/consulta_games2.php?player2=";
    private static final String urlSets1=urlx.getUrl()+"/padel/consulta_sets1.php?player1=";
    private static final String urlSets2=urlx.getUrl()+"/padel/consulta_sets2.php?player2=";
    private static final String urlWinner1=urlx.getUrl()+"/padel/consulta_winner1.php?player1=";
    private static final String urlWinner2=urlx.getUrl()+"/padel/consulta_winner2.php?player2=";
    private static final String urlLoser1=urlx.getUrl()+"/padel/consulta_loser1.php?player1=";
    private static final String urlLoser2=urlx.getUrl()+"/padel/consulta_loser2.php?player2=";
    private static final String urlTie_break1=urlx.getUrl()+"/padel/consulta_tie_break1.php?player1=";
    private static final String urlTie_break2=urlx.getUrl()+"/padel/consulta_tie_break2.php?player2=";
    private static final String urlTercer1=urlx.getUrl()+"/padel/consulta_tercer_set1.php?player1=";
    private static final String urlTercer2=urlx.getUrl()+"/padel/consulta_tercer_set2.php?player2=";
    private static final String urlRemontada1=urlx.getUrl()+"/padel/consulta_remontada1.php?player1=";
    private static final String urlRemontada2=urlx.getUrl()+"/padel/consulta_remontada2.php?player2=";
    private static final String urlContra1=urlx.getUrl()+"/padel/consulta_remontadaContra1.php?player1=";
    private static final String urlContra2=urlx.getUrl()+"/padel/consulta_remontadaContra2.php?player2=";
    private static final String urlGamesT1=urlx.getUrl()+"/padel/consulta_gamesT1.php?player1=";
    private static final String urlGamesT2=urlx.getUrl()+"/padel/consulta_gamesT2.php?player2=";
    private static final String urlSetsT1=urlx.getUrl()+"/padel/consulta_setsT1.php?player1=";
    private static final String urlSetsT2=urlx.getUrl()+"/padel/consulta_setsT2.php?player2=";
    private static final String urlTercerT1=urlx.getUrl()+"/padel/consulta_tercer_setT1.php?player1=";
    private static final String urlTercerT2=urlx.getUrl()+"/padel/consulta_tercer_setT2.php?player2=";
    private static final String urlTieT1=urlx.getUrl()+"/padel/consulta_tie_breakT1.php?player1=";
    private static final String urlTieT2=urlx.getUrl()+"/padel/consulta_tie_breakT2.php?player2=";
    private static final String urlgenerales=urlx.getUrl()+"/padel/consulta_jugador4.php?id=";
    private static  String urlLast=urlx.getUrl()+"/padel/consulta_last.php?player1=";
    private ProgressDialog progress;
    private JsonObjectRequest jsonObjectRequest;

    private String idPlayer;

    Button btn_nuevoUsuario, btn_json;
    EditText user;
    EditText pass;

    RequestQueue queue;
    //    JsonObjectRequest jsonObjectRequest;
    //  String url="";
    ProgressDialog progreso;
    private Url urlX;

    public Statistics() {


        /**/
    }
    public void game1(){

        JsonObjectRequest jsonObjectRequestG1=new JsonObjectRequest(Request.Method.GET, urlGames1+c, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray arrG1 = response.getJSONArray("games1");
                    for (int i = 0; i < arrG1.length(); i++) {
                        JSONObject jsonG1 = null;
                        jsonG1 = new JSONObject(arrG1.get(i).toString());

                        String title = jsonG1.getString("suma");
                        g1 = Integer.parseInt(title);
                    }
                  //  Toast.makeText(estadisticas.getContext(), "clase "+g1, Toast.LENGTH_SHORT).show();
                } catch (Exception er) {
                    //Toast.makeText(estadisticas.getContext(), "" + er, Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        requestQueueGames1.add(jsonObjectRequestG1);


    }
}
