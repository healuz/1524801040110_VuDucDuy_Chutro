package kgs.ku.chutro.mAdapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.List;
import kgs.ku.chutro.R;
import kgs.ku.chutro.mDB.DBPhongTro;

public class ADTPhongTro extends ArrayAdapter<DBPhongTro> {
    private Activity context;
    private int layout;
    private List<DBPhongTro> list;
    DatabaseReference mData;

    public ADTPhongTro(@NonNull Context context, int resource, List<DBPhongTro> data) {
        super(context, resource, data);
        this.context = (Activity) context;
        this.layout = resource;
        this.list = data;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater flater = context.getLayoutInflater();
        View row = flater.inflate(layout, parent,false);
        TextView txt1=(TextView) row.findViewById(R.id.tvTenPhong);

        DBPhongTro phong = list.get(position);
        txt1.setText(phong.getName()==null?"":phong.getName().toString());
        return row;
    }


}


