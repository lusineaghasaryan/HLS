package com.team_blue.hls.firebase;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;
import com.team_blue.hls.models.Monument;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FbHelper {

    private DatabaseReference mDatabase;
    private StorageReference mStorage;
    private HashMap<String,Monument> mMon = new HashMap<>();

    public FbHelper()
    {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("models").child("monuments").addChildEventListener(childEventListener);
    }

     private ChildEventListener childEventListener = new ChildEventListener() {
         @Override
         public void onChildAdded(DataSnapshot dataSnapshot, String s) {
             Monument addVal = dataSnapshot.getValue(Monument.class);
             String key = dataSnapshot.getKey();
             mMon.put(key,addVal);
         }

         @Override
         public void onChildChanged(DataSnapshot dataSnapshot, String s) {
            Monument changeVal = dataSnapshot.getValue(Monument.class);
             String key = dataSnapshot.getKey();
             mMon.put(key,changeVal);
         }

         @Override
         public void onChildRemoved(DataSnapshot dataSnapshot) {

         }

         @Override
         public void onChildMoved(DataSnapshot dataSnapshot, String s) {

         }

         @Override
         public void onCancelled(DatabaseError databaseError) {

         }
     };

     public ArrayList<Monument> getMonuments(double pLatitude, double pLongitude, double pRadius)
     {
         ArrayList<Monument> monumentList = new ArrayList<>();
         ArrayList<Monument> monList = new ArrayList<>();
         monumentList.addAll(mMon.values());
         for(int i = 0 ; i < monumentList.size(); ++i )
         {
             double lat = monumentList.get(i).getLatitude();
             double lon = monumentList.get(i).getLongitude();
             double x = lat - pLatitude;
             double y = lon - pLongitude;
             if(x*x + y*y <= pRadius*pRadius)
             {
                 monList.add(monumentList.get(i));
             }
         }

         return monList;
     }
}
