package kgs.ku.chutro;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import kgs.ku.chutro.mDB.DBChuTro;

public class ChiTietPhong extends AppCompatActivity {

    EditText edtNguoitro,edtSodien,edtSonuoc;
    TextView tvThanhTien;
    Button btnTinh, btnXong;
    DatabaseReference mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_phong);

        edtNguoitro = (EditText) findViewById(R.id.edtNguoiThue);
        edtSodien = (EditText) findViewById(R.id.edtSoDien);
        edtSonuoc = (EditText) findViewById(R.id.edtSoNuoc);
        tvThanhTien = (TextView) findViewById(R.id.tvTongTien);
        btnTinh = (Button) findViewById(R.id.btnTinhTien);
        btnXong = (Button) findViewById(R.id.btnXong);



        Intent intent1 = getIntent();
        Bundle bundle = intent1.getBundleExtra("chitietphong");
        final String nguoithue = bundle.getString("nguoitro");
        final String giaphong = bundle.getString("giaphong");
        final String giadien = bundle.getString("giadien");
        final String gianuoc = bundle.getString("gianuoc");

        edtNguoitro.setText(nguoithue);

        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tiendien = Integer.parseInt(giadien)*Integer.parseInt(edtSodien.getText().toString());
                int tiennuoc = Integer.parseInt(gianuoc)*Integer.parseInt(edtSonuoc.getText().toString());

                tvThanhTien.setText(Integer.parseInt(giaphong)+tiendien+tiennuoc+"");
            }
        });

        btnXong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData = FirebaseDatabase.getInstance().getReference();
                Query query = mData.child("NguoiTro").orderByChild("username").equalTo(nguoithue);
                query.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                        DBChuTro account = dataSnapshot.getValue(DBChuTro.class);
                        String no = account.getKeyid();
                        mData.child("NguoiTro").child(no).child("thongbao").setValue("Tiền tháng này là : "+ tvThanhTien.getText().toString());
                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                finish();
            }
        });





    }
}
