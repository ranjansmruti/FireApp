package com.example.reaper.fireapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private EditText mValue,mName;
    private Button mUp;
    private DatabaseReference mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mName=findViewById( R.id.name );
        mValue=findViewById( R.id.value );
        mUp=findViewById( R.id.update );

        mRef= FirebaseDatabase.getInstance().getReference().child( "user" );
        mRef.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    String name=dataSnapshot.child( "Name" ).getKey().toString();
                    String value=dataSnapshot.child( "name" ).getValue().toString();
                    mName.setText( name );
                    mValue.setText( value );
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        } );
        mUp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=mName.getText().toString();
                String value=mValue.getText().toString();
                mRef.child( "name" ).setValue( "value" );
            }
        } );
    }
}
