package com.example.homeworktest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private DBOpenHelper mDBOpenHelper;
    private CheckBox remember;                     //记住密码
    private EditText mEtLoginactivityUsername;
    private  SharedPreferences pref;
    private  SharedPreferences.Editor editor;
    private EditText mEtLoginactivityPassword;
    private Button mBtLoginactivityLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mDBOpenHelper=new DBOpenHelper(this);
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        setContentView(R.layout.activity_main_login);
        initView();
        pref= PreferenceManager.getDefaultSharedPreferences(this);
        remember=(CheckBox)findViewById(R.id.cb_remember_login);
        boolean isRemenber =pref.getBoolean("remember_password",false);
        if (isRemenber){
            //将账号和密码都设置到文本框中
            String name=pref.getString("name","");
            String password=pref.getString("password","");
           mEtLoginactivityUsername.setText(name);
           mEtLoginactivityPassword.setText(password);
           remember.setChecked(true);
        }

    }
    /**
     * onCreae()中大的布局已经摆放好了，接下来就该把layout里的东西
     * 声明、实例化对象然后有行为的赋予其行为
     * 这样就可以把视图层View也就是layout 与 控制层 Java 结合起来了
     */
    private void initView() {
        // 初始化控件
        mBtLoginactivityLogin = findViewById(R.id.bt_login_submit);
        mEtLoginactivityUsername = findViewById(R.id.et_login_username);
        mEtLoginactivityPassword = findViewById(R.id.et_login_pwd);
// 设置点击事件监听器
        mBtLoginactivityLogin.setOnClickListener(this);
    }

    public void onClick(View view)  {
        switch (view.getId()) {

            case R.id.bt_register:
                startActivity(new Intent(this, RegisterActivity.class));
                finish();
                break;
            case R.id.bt_login_submit:
                String name = mEtLoginactivityUsername.getText().toString().trim();
                String password = mEtLoginactivityPassword.getText().toString().trim();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
                    ArrayList<User> data = mDBOpenHelper.getAllData();
                    boolean match = false;
                    for (int i = 0; i < data.size(); i++) {
                        User user = data.get(i);
                        if (name.equals(user.getName()) &&
                                password.equals(user.getPassword())) {
                            match = true;
                            break;
                        } else {
                            match = false;
                        }
                    }
                    if (match) {
                        editor=pref.edit();
                        if(remember.isChecked()){//检查复选框是否被选中
                        editor.putBoolean("remember_password",true) ;
                        editor.putString("name",name);
                        editor.putString("password",password);
                        }
                        else{
                            editor.clear();
                        }
                        Intent intent = new Intent(this,HeadActivity.class);
                        startActivity(intent);
                        finish();//销毁此 Activity
                    } else {
                        Toast.makeText(this, "用户名或密码不正确，请重新输入",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "请输入你的用户名和密码",
                            Toast.LENGTH_SHORT).show();
                }
                break;


        } }


}

