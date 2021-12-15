package com.example.homeworktest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.SaveInfo;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText reg_username;
    private EditText reg_password;
    private EditText reg_password2;
    private Button reg_btn_sure;
    private Button reg_back;
   private  DBOpenHelper mDBOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        getSupportActionBar().hide();//隐藏标题栏
        mDBOpenHelper=new DBOpenHelper(this);
        reg_username = (EditText) findViewById(R.id.reg_username);
        reg_password = (EditText) findViewById(R.id.reg_password);
        reg_password2 = (EditText) findViewById(R.id.reg_password2);
        reg_btn_sure = (Button) findViewById(R.id.reg_btn_sure);
        reg_back = (Button) findViewById(R.id.reg_back);
        reg_btn_sure.setOnClickListener(this);
        reg_back.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reg_back: //返回登录页面
                Intent intent1 = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.reg_btn_sure: //注册按钮

                //获取用户输入的用户名、密码
                String username = reg_username.getText().toString().trim();
                String spassword = reg_password.getText().toString().trim();
                String password = reg_password2.getText().toString().trim();
                //注册验证
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password) ) {
                    //将用户名和密码加入到数据库中
                    if(password.equals(spassword)){
                        mDBOpenHelper.add(username, password);
                        Intent intent2 = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent2);
                        finish();
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();}
                    else
                        Toast.makeText(RegisterActivity.this, "注册失败，两次输入密码不一致", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(this, "账号密码不能输入为空",
                            Toast.LENGTH_SHORT).show();
                }
                break;
    }
}}
