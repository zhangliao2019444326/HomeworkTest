package com.example.homeworktest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.HashMap;


public class HeadFragment extends Fragment {
    Switch switch1;
    Switch switch2;
    Switch switch3;
    Switch switch4;
TextView unknown1;
    TextView unknown2;
    TextView unknown3;
    TextView unknown4;
    String key;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_head,container,false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        unknown1=getView().findViewById(R.id.text1);
        unknown2=getView().findViewById(R.id.text2);
        unknown3=getView().findViewById(R.id.text3);
        unknown4=getView().findViewById(R.id.text4);
        switch1=getView().findViewById(R.id.swich1);
        switch2=getView().findViewById(R.id.swich2);
        switch3=getView().findViewById(R.id.swich3);
        switch4=getView().findViewById(R.id.swich4);
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 调用数据库工具类DBUtils的getInfoByName方法获取数据库表中数据
                HashMap<String, Object> map = DBUtils.getInfoByName("five");
                Message message = handler.obtainMessage();
                if(map != null){
                    String s = "";
                    for (String key : map.keySet()){
                        s += key + ":" + map.get(key) + "\n";
                    }
                    key= s;
                }
            }
        }).start();

        switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    //选中时 do some thing
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // 调用数据库工具类DBUtils的getInfoByName方法获取数据库表中数据
                            HashMap<String, Object> map = DBUtils.getInfoByName("three");
                            Message message = handler.obtainMessage();
                            if(map != null){
                                String s = "";
                                for (String key : map.keySet()){
                                    s += key + ":" + map.get(key) + "\n";
                                }
                                message.what = 0x14;
                                message.obj = s;
                            }else {
                                message.what = 0x11;
                                message.obj = "查询结果为空";
                            }
                            // 发消息通知主线程更新UI
                            handler.sendMessage(message);
                        }
                    }).start();

                } else {
                    //非选中时 do some thing
                    unknown3.setText("未知");
                    unknown3.setTextColor(Color.GRAY);
                }
            }
        });
       switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked) {
                   //选中时 do some thing
                   new Thread(new Runnable() {
                       @Override
                       public void run() {
                           // 调用数据库工具类DBUtils的getInfoByName方法获取数据库表中数据
                           HashMap<String, Object> map = DBUtils.getInfoByName("two");
                           Message message = handler.obtainMessage();
                           if(map != null){
                               String s = "";
                               for (String key : map.keySet()){
                                   s += key + ":" + map.get(key) + "\n";
                               }
                               message.what = 0x13;
                               message.obj = s;
                           }else {
                               message.what = 0x11;
                               message.obj = "查询结果为空";
                           }
                           // 发消息通知主线程更新UI
                           handler.sendMessage(message);
                       }
                   }).start();

               } else {
                   //非选中时 do some thing
                   unknown2.setText("未知");
                   unknown2.setTextColor(Color.GRAY);
               }
           }
       });
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    //选中时 do some thing
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // 调用数据库工具类DBUtils的getInfoByName方法获取数据库表中数据
                            HashMap<String, Object> map = DBUtils.getInfoByName("one");
                            Message message = handler.obtainMessage();
                            if(map != null){
                                String s = "";
                                for (String key : map.keySet()){
                                    s += key + ":" + map.get(key) + "\n";
                                }
                                message.what = 0x12;
                                message.obj = s;
                            }else {
                                message.what = 0x11;
                                message.obj = "查询结果为空";
                            }
                            // 发消息通知主线程更新UI
                            handler.sendMessage(message);
                        }
                    }).start();

                } else {
                    //非选中时 do some thing
                    unknown1.setText("未知");
                    unknown1.setTextColor(Color.GRAY);
                }
            }
        });
        switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    //选中时 do some thing
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            // 调用数据库工具类DBUtils的getInfoByName方法获取数据库表中数据
                            HashMap<String, Object> map = DBUtils.getInfoByName("four");
                            Message message = handler.obtainMessage();
                            if(map != null){
                                String s = "";
                                for (String key : map.keySet()){
                                    s += key + ":" + map.get(key) + "\n";
                                }
                                message.what = 0x16;
                                message.obj = s;
                            }else {
                                message.what = 0x11;
                                message.obj = "查询结果为空";
                            }
                            // 发消息通知主线程更新UI
                            handler.sendMessage(message);
                        }
                    }).start();

                } else {
                    //非选中时 do some thing
                    unknown4.setText("未知");
                    unknown4.setTextColor(Color.GRAY);
                }
            }
        });


    }
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case 0x11:
                    String s = (String) msg.obj;
                    Toast.makeText(getActivity(), "检测失败", Toast.LENGTH_SHORT).show();
                    break;
                case 0x12:
                    String ss = (String) msg.obj;
                    if (ss.equals(key)){
                    unknown1.setText("正常");
                    unknown1.setTextColor(Color.GREEN);
                    }
                    else {
                        Log.d("HeadFragment", "handleMessage: "+ss);
                        unknown1.setText("异常");
                        unknown1.setTextColor(Color.RED);
                    }
                    break;
                case 0x13:
                    String sss = (String) msg.obj;
                    if (sss.equals(key)){
                        unknown2.setText("正常");
                        unknown2.setTextColor(Color.GREEN);
                    }
                    else {
                        unknown2.setText("异常");
                        unknown2.setTextColor(Color.RED);
                    }
                    break;
                case 0x14:
                    String ssss = (String) msg.obj;
                    if (ssss.equals(key)){
                        unknown3.setText("正常");
                        unknown3.setTextColor(Color.GREEN);
                    }
                    else {
                        unknown3.setText("异常");
                        unknown3.setTextColor(Color.RED);
                    }
                    break;
                case 0x16:
                    String sssss = (String) msg.obj;
                    if (sssss.equals(key)){
                        unknown4.setText("正常");
                        unknown4.setTextColor(Color.GREEN);
                    }
                    else {
                        unknown4.setText("异常");
                        unknown4.setTextColor(Color.RED);
                    }
                    break;
            }

        }
    };


}
