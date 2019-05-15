package kgs.ku.chutro;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
    public String title;
    DatabaseReference db;
    private QuanlyFragment quanlyFragment;
    private BaocaoFragment baocaoFragment;
    private NguoidungFragment nguoidungFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db = FirebaseDatabase.getInstance().getReference();
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("getTen");
        this.setTitle(bundle.getString("tenDN"));
        title = this.getTitle().toString();
        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);

        quanlyFragment = new QuanlyFragment();
        baocaoFragment = new BaocaoFragment();
        nguoidungFragment = new NguoidungFragment();

        setFragment(quanlyFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_quanly:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(quanlyFragment);
                        return true;

                    case R.id.nav_baocao:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(baocaoFragment);
                        return true;

                    case R.id.nav_nguoidung:
                        mMainNav.setItemBackgroundResource(R.color.colorPrimary);
                        setFragment(nguoidungFragment);
                        return true;

                    default: return false;

                }
            }


        });

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }
}
