package com.example.omantrip;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class netrip extends AppCompatActivity {
DBHelper aDB;
EditText numed,nameed,car860,id860;
Button clearbtn,cal860,submitbtn860,deletebtn,vie860,updat860;
TextView pricetext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_netrip);

        aDB = new DBHelper(this);

        numed = findViewById(R.id.numed);
        nameed = findViewById(R.id.nameed);
        clearbtn = findViewById(R.id.clearbtn);
        pricetext = findViewById(R.id.pricetext);
        cal860 = findViewById(R.id.cal860);
        car860 = findViewById(R.id.car860);
        submitbtn860 = findViewById(R.id.submitbtn860);
        deletebtn = findViewById(R.id.deletebtn);
        vie860 = findViewById(R.id.vie860);
        updat860 = findViewById(R.id.updat860);
        id860 = findViewById(R.id.id860);


        //define the methods
        addData();
        updateData();
        deleteData();
        viewData();




//this button will clear all fields
        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numed.setText("");
                nameed.setText("");
                car860.setText("");
            }
        });
        //this button will calculate the fees of trip
        cal860.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameed.getText().toString().isEmpty()||numed.getText().toString().isEmpty()||
                        car860.getText().toString().isEmpty())
                {
                    Toast.makeText(netrip.this, "PLease filed required", Toast.LENGTH_SHORT).show();
                }
                else {
                    double pri= 5.0;
                    double personnum =
                            Double.parseDouble(numed.getText().toString());
                    double thepri=(pri * personnum);
                    pricetext.setText(Double.toString(thepri));

                    pricetext.setText("The price is "+ thepri+" RO");
                }
            }
        });



    }

    //link addData method with the button
    public void addData(){
        submitbtn860.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean insert=aDB.insertData(numed.getText().toString(),id860.getText().toString(),
                        nameed.getText().toString(),car860.getText().toString());
                if(insert==true)
                    Toast.makeText(netrip.this, "Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(netrip.this,"Data not inserted",Toast.LENGTH_LONG).show();
            }
        });
    }

    //link update data method with update info button
    public void updateData(){
        updat860.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean update=aDB.updateData(nameed.getText().toString(),car860.getText().toString(),numed.getText().toString(),id860.getText().toString());
                if(update==true)
                    Toast.makeText(netrip.this,"Data has ben updated",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(netrip.this, "Data not updated",Toast.LENGTH_LONG).show();

            }
        });

    }

    //link delete data method with delete button
  public void deleteData(){
        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer del=aDB.deleteData(id860.getText().toString());
                if(del>0)
                    Toast.makeText(netrip.this,"Data deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(netrip.this,"Data not deleted",Toast.LENGTH_LONG).show();

            }
        });

  }
  //this method will show up user data
  public void viewData(){

        vie860.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor r=aDB.getAllData();
                if(r.getCount()==0)
                {
                    Toast.makeText(netrip.this, "No Details Available", Toast.LENGTH_SHORT).show();
                }

                StringBuffer b=new StringBuffer();
                while(r.moveToNext())
                {
                    b.append("numed:"+r.getString(0)+"\n");
                    b.append("id860:"+r.getString(1)+"\n");
                    b.append("nameed:"+r.getString(2)+"\n");
                    b.append("car860:"+r.getString(3)+"\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(netrip.this);
                builder.setCancelable(true);
                builder.setTitle("Adventure Details");
                builder.setMessage(b.toString());
                builder.show();

            }


        });
  }


}