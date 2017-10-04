package com.example.root.myapplication;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.ParseException;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.root.myapplication.pojo.earthquakeModel.Earthquake;
import com.example.root.myapplication.retrofit.RetrofitRepository;
import com.example.root.myapplication.retrofit.exception.BaseException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
     private  TextView dateView,dateView1,t;
    SeekBar seekBar;
    private Calendar calendar;
    ProgressDialog progressDialog;
    private  int year,month,day;
    boolean z=false;
    DatePickerDialog.OnDateSetListener from_dateListener,to_datelistener;
    ArrayList<Data_class> dy=new ArrayList<Data_class>();
    int k=1;
    int v1=1,v2=1;
    TextView seekBarValue;
    int chk=1;

    RetrofitRepository retrofitRepository;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent j=getIntent();
        t=(TextView)findViewById(R.id.text);
        dateView=(TextView)findViewById(R.id.text1);
        dateView1=(TextView)findViewById(R.id.text3);
        calendar=Calendar.getInstance();
        year=calendar.get(Calendar.YEAR);
        month=calendar.get(Calendar.MONTH);
        day=calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year,month,day);
        dateView1.setText(dateView.getText().toString());
        SeekBar seekBar = (SeekBar)findViewById(R.id.seek);
        seekBar.setProgress(0);
        seekBar.incrementProgressBy(1);

        seekBar.setMax(40);
        seekBarValue = (TextView)findViewById(R.id.seekbarvalue);
        seekBarValue.setText("5.0");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Double prog = progress / 9.99;
                prog = prog + 5.00;
                prog=Math.floor(prog * 100) / 100;
                seekBarValue.setText(String.valueOf(prog));
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    @Override
    public void onResume(){
        super.onResume();
    }
    public void date1(View view){
        showDialog(999);
    }
    public void date2(View v){
        z=true;
        showDialog(998);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected Dialog onCreateDialog(int id){
     if(id==999){

         DatePickerDialog dpk=new DatePickerDialog(this,myDateListener1,year,month,day);
         //java.text.SimpleDateFormat format=new java.text.SimpleDateFormat("yyyy-MM-dd");
         final Calendar cal=Calendar.getInstance();
         cal.add(Calendar.DATE,-1);
         //format.format(cal.getTime());
          dpk.getDatePicker().setMaxDate(cal.getTimeInMillis());

         return dpk;
     }
     else if(id==998){
         DatePickerDialog dpk=new DatePickerDialog(this,myDateListener2,year,month,day);
         //java.text.SimpleDateFormat format=new java.text.SimpleDateFormat("yyyy-MM-dd");
         final Calendar cal=Calendar.getInstance();
         cal.add(Calendar.DATE,-1);
         //format.format(cal.getTime());
         dpk.getDatePicker().setMaxDate(cal.getTimeInMillis());

         return dpk;
     }
     return  null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener1=new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker arg0,int ar1,int ar2,int arg3 ){


                showDate(ar1, ar2, arg3);


            arg0.updateDate(ar1,ar2,arg3);
        }
    };
    private DatePickerDialog.OnDateSetListener myDateListener2=new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker arg0,int ar1,int ar2,int arg3 ){


                showDate(ar1, ar2, arg3);

            arg0.updateDate(ar1,ar2,arg3);
        }
    };
    private void showDate(int year,int month,int day){
        if(!z){
            dateView.setText(new StringBuilder().append(year).append("-").append(month+1).append("-").append(day));
            z=false;
        }
        else if(z){
            dateView1.setText(new StringBuilder().append(year).append("-").append(month+1).append("-").append(day));
            z=false;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void galpo(View view){

        String h1=dateView.getText().toString();
        String h2=dateView1.getText().toString();
        String h3=seekBarValue.getText().toString();
        Intent i=new Intent(MainActivity.this,List_display.class);
        long tym1,tym2;
        int jup=0;
        SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date d1=form.parse(h1);
            Date d2=form.parse(h2);
            tym1=d1.getTime();
            tym2=d2.getTime();
            if(tym1>=tym2){
                Toast.makeText(MainActivity.this,"Enter the date properly",Toast.LENGTH_LONG).show();
                jup=1;
            }

        }catch(Exception e){
            e.printStackTrace();
        }

       if(jup==0) {
           ConnectivityManager cm=(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
           NetworkInfo active=cm.getActiveNetworkInfo();
           boolean isConn=active!=null&& active.isConnectedOrConnecting();
           if(isConn) {
               i.putExtra("key1", h1); //  we stop the intent for a moment
               i.putExtra("key2", h2);
                i.putExtra("key3",h3);
               finish();
               startActivity(i);


           }
           else
               Toast.makeText(MainActivity.this,"Check the connection",Toast.LENGTH_LONG).show();

       }

        }



    @Override
    public void onBackPressed() {
        //finish();
        //startActivity(new Intent(this,MainActivity.class));
        if(k==1) {
            Toast.makeText(MainActivity.this, "Hit once more to exit", Toast.LENGTH_SHORT).show();
            k += 1;
        }
        else
            finish();
    }

}



























