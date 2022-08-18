package com.example.tennispro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {
   EstadisticasFR frag_estadisticas;
   GeneralesFR frag_generales;
   Button btn_estadisticas,btn_generales;
  Personajes pers;
  String idPlayer;
    Resultados1 res1;
    private String recibeNombre;
    private String recibeApellido ;
    private String recibeNacimiento;
   private String  recibeNal ;
    private String recibePais ;
    private String recibeCamiseta ;
    private String recibeEstilo;
   private String  recibeGolpe;
    private String recibeRaqueta ;
    private String recibeCordaje;
    private String recibeId;
    private String recibePass;
    private int recibeRol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        frag_estadisticas= new EstadisticasFR();
        frag_generales= new GeneralesFR();
        btn_estadisticas=(Button)findViewById(R.id.btn_estadisticas);
        btn_generales=(Button)findViewById(R.id.btn_generales);

        getSupportFragmentManager().beginTransaction().add(R.id.frame_id,frag_estadisticas).commit();
        Bundle bundle=getIntent().getExtras();
        idPlayer=getIntent().getStringExtra("user");

        pers=new Personajes();
        //datosGenerales(1);
           try {
               Bundle bundle1=getIntent().getExtras();
               Personajes res2=null;

               if (bundle!=null) {
                   res2 = (Personajes) bundle.getSerializable("usuario");
                   recibeNombre = res2.getNombre();
                   recibeApellido = res2.getL_name();
                   recibeNacimiento = res2.getBirthday();
                   recibeNal = res2.getNal();
                   recibePais = res2.getPais();
                   recibeCamiseta = res2.getSize();
                   recibeEstilo = res2.getStyle();
                   recibeGolpe = res2.getHit();
                   recibeRaqueta = res2.getRacket();
                   recibeCordaje = res2.getCord();
                   recibeId = res2.getId();
                   recibePass=res2.getPass();
                   recibeRol=res2.getRol();
                   //   recibeEfectividad=res1.getEfectividad();
                   Toast.makeText(getApplicationContext(),""+res2.getEfectividad(), Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(getApplicationContext(), "no llego ni madre", Toast.LENGTH_SHORT).show();
               }

                   if (bundle!=null){
                       res1=(Resultados1) bundle.getSerializable("resultados");
                       Toast.makeText(getApplicationContext(), "imagen"+ res1.getUrlImagePrincipal()+"y"+res1.getFirst()+"y"+res1.getSecond()+"y"+
                               res1.getThird()+"y"+res1.getFourth()+"y"+res1.getFifth()+res1.getReassambled()+"y"+
                               res1.getWins()+"y"+res1.getAgaints()+"y"+res1.getSets()+"y"+res1.getGames()+"ademas"+idPlayer, Toast.LENGTH_SHORT).show();
                   //  imagenPrincipal(res1.getUrlImagePrincipal());
                   double porcientoW = (res1.getWins() * 100) / res1.getTotalW();
                   double porcientoS = (res1.getSets() * 100) / res1.getSuperTotalS();
                   double porcientoG = (res1.getGames() * 100) / res1.getSuperTotalG();
                   double porcientoTercer = (res1.getThird_set() * 100) / res1.getRestaTercer();
                   double porcientoTie = (res1.getTie_break() * 100) / res1.getRestaTie();
                   double porcientoRemont = (res1.getReassambled() * 100) / res1.getTotalRemont();
                   double porcientoAgaints = (res1.getAgaints() * 100) / res1.getTotalRemont();
                   res1.getNombre();
                   res1.getTotalW();
                   res1.getWins();
                   res1.getLoses();
                   res1.getWins();
                   res1.getTotalW();

                   res1.getSets();
                   res1.getTotalS();
                   res1.getSets();
                   res1.getSuperTotalS();
                   res1.getReassambled();
                   res1.getAgaints();
                   res1.getReassambled();
                   res1.getTotalRemont();
                   res1.getReassambled();
                   res1.getAgaints();
                   res1.getAgaints();
                   res1.getTotalRemont();
                   res1.getGames();
                   res1.getTotalG();
                   res1.getGames();
                   res1.getSuperTotalG();
                   res1.getTie_break();
                   res1.getTotalTie();
                   res1.getTie_break();
                   res1.getRestaTie();
                   res1.getThird_set();
                   res1.getTotalTercer();
                   res1.getThird_set();
                   res1.getRestaTercer();
                       Toast.makeText(getApplicationContext(), ""+res1.getNombre()+res1.getAgaints()+res1.getReassambled(), Toast.LENGTH_SHORT).show();
               }else{
                       Toast.makeText(getApplicationContext(), "no llego ni madre", Toast.LENGTH_SHORT).show();


                   }
           }catch(Exception e){

           }
    }
public void onClick(View view){
        FragmentTransaction transaccion= getSupportFragmentManager().beginTransaction();
       switch (view.getId()){
           case R.id.btn_estadisticas:
               transaccion.replace(R.id.frame_id,frag_estadisticas);
               break;
           case R.id.btn_generales:
               transaccion.replace(R.id.frame_id,frag_generales);
               break;

       }
    transaccion.commit();
}



    @Override public boolean onCreateOptionsMenu(Menu menu1){
        getMenuInflater().inflate(R.menu.menu_principal,menu1);

        return true;

    }
    @ Override public boolean onOptionsItemSelected(MenuItem opc){

int id=opc.getItemId();
if(id==R.id.id_item1){
    Toast.makeText(getApplicationContext(), "notificaciones", Toast.LENGTH_SHORT).show();
}else if(id==R.id.id_item2){
    Toast.makeText(getApplicationContext(), "configuraciones", Toast.LENGTH_SHORT).show();
}
        return super.onOptionsItemSelected(opc);

    }
}