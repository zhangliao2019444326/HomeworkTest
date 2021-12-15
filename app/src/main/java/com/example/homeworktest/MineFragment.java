package com.example.homeworktest;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.homeworktest.adapter.MeAdapter;
import com.example.homeworktest.entity.Me;

import java.util.ArrayList;
import java.util.List;

public class MineFragment extends Fragment  {
    private TextView version, help;
    private View root;
    private static final String TAG = "MineFragment";
    private List<Me> meList =new ArrayList<>();
    private DBOpenHelper mDBOpenHelper;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_mine, container, false);

        initView();
        init();
        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().findViewById(R.id.btn_quit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

                   }




        });
        Log.d(TAG, "onActivityCreated: ");
    }
    private void init() {
        version.setText("开发版本号 V1.0.0");
        help.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(root.getContext());
                builder.setTitle("扫码加微信咨询");
                builder.setView(R.layout.wx_image).show();
            }
        });
    }

    private void initView() {
        version = root.findViewById(R.id.version);
        help = root.findViewById(R.id.help);
    }
}



