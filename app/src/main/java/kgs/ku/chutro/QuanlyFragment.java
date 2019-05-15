package kgs.ku.chutro;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

import kgs.ku.chutro.mAdapter.ADTPhongTro;
import kgs.ku.chutro.mDB.DBChuTro;
import kgs.ku.chutro.mDB.DBPhongTro;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuanlyFragment extends Fragment {

    DatabaseReference db;

    List<DBPhongTro> arrPhong = null;
    ADTPhongTro adtPhongTro = null;

    DatabaseReference mData;
    GridView gridView;
    View v;

    public QuanlyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quanly, container, false);
        setHasOptionsMenu(true);


        return  v;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.addchutro, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.v = view;

        init();
        loadPhong();
        clickListItem();
    }

    private void init() {

        gridView = (GridView) v.findViewById(R.id.grid_phongtro);
        arrPhong = new ArrayList<DBPhongTro>();

        adtPhongTro = new ADTPhongTro(this.getActivity(), R.layout.custom_phongtro, arrPhong);
        gridView.setAdapter(adtPhongTro);
        adtPhongTro.notifyDataSetChanged();
    }

    private void clickListItem() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mData = FirebaseDatabase.getInstance().getReference();



                Intent intent1 = new Intent(getActivity(), ChiTietPhong.class);
                Bundle bundle = new Bundle();
                bundle.putString("tenphong", arrPhong.get(position).getName());
                bundle.putString("nguoitro", arrPhong.get(position).getNguoithue());
                bundle.putString("giaphong", arrPhong.get(position).getGiaphong());
                bundle.putString("giadien", arrPhong.get(position).getGiadien());
                bundle.putString("gianuoc", arrPhong.get(position).getGianuoc());



                intent1.putExtra("chitietphong", bundle);
                startActivity(intent1);
            }
        });
    }
    private void loadPhong(){
        db = FirebaseDatabase.getInstance().getReference();

                //adtPhongTro.clear();
                final String title = this.getActivity().getTitle().toString();
                Query query = db.child("PhongTro").orderByChild("chuphong").equalTo(title);
                query.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        DBPhongTro phongtro = dataSnapshot.getValue(DBPhongTro.class);

                        arrPhong.add(phongtro);
                        adtPhongTro.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                        arrPhong.clear();
//                        adtPhongTro.clear();
//                        db.child("PhongTro").orderByChild("nguoithue").equalTo("healuz").addChildEventListener(new ChildEventListener() {
//                            @Override
//                            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                                DBPhongTro phong = dataSnapshot.getValue(DBPhongTro.class);
//
//                                arrPhong.add(phong);
//                                adtPhongTro.notifyDataSetChanged();
//                            }
//
//                            @Override
//                            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                            }
//
//                            @Override
//                            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//                            }
//
//                            @Override
//                            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                            }
//                        });
//                        adtPhongTro.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//                        arrPhong.clear();
//                        adtPhongTro.clear();
//                        db.child("PhongTro").orderByChild("chutro").equalTo("healuz").addChildEventListener(new ChildEventListener() {
//                            @Override
//                            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                                DBPhongTro ban = dataSnapshot.getValue(DBPhongTro.class);
//
//                                arrPhong.add(ban);
//                                adtPhongTro.notifyDataSetChanged();
//                            }
//
//                            @Override
//                            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                            }
//
//                            @Override
//                            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//                            }
//
//                            @Override
//                            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//                            }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                            }
//                        });
//                        adtPhongTro.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.add_area:
                Intent intent = new Intent(this.getActivity(), ThemPhongTro.class);

                intent.putExtra("title", this.getActivity().getTitle().toString());
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
