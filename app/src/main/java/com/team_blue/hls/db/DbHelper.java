package com.team_blue.hls.db;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.team_blue.hls.activities.Main2Activity;
import com.team_blue.hls.activities.MainActivity;
import com.team_blue.hls.models.Monument;
import com.team_blue.hls.models.User;

import java.util.ArrayList;

import static java.security.AccessController.getContext;


public class DbHelper {
    private Firebase mRootRef;
    private Firebase mMonRef;
    private Firebase mUserRef;
    private ArrayList<Monument> mMon = new ArrayList();

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    public DbHelper(final Context context)
    {
        mRootRef = new Firebase("https://hlsfbproject.firebaseio.com/");
        mMonRef = new Firebase("https://hlsfbproject.firebaseio.com/models/monuments");
        mUserRef = new Firebase("https://hlsfbproject.firebaseio.com/models/users");

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser()!=null)
                {
                    context.startActivity(new Intent(context, MainActivity.class));

                }
            }
        };
        mAuth.addAuthStateListener(mAuthListener);
        mAuth.signInWithEmailAndPassword("sedbars94@gmail.com","k055101145k").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(context,"Signin problem",Toast.LENGTH_LONG).show();
                }
            }
        });
        mRootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //arzheq poxvelu depqum inch ani
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mMonRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Monument val = dataSnapshot.getValue(Monument.class);
                mMon.add(val);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
    //firebase add data
     /*
        Firebase childRef = mRootRef.child("models").child("monuments").child("mon1").child("notes").child("note1").child("name");
        childRef.setValue("AAAAA");*/

}
