package com.example.homeworktest;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.graphics.Color;
        import android.os.Bundle;

        import android.view.View;
        import android.view.View.OnClickListener;
        import android.view.Window;
        import android.view.WindowManager;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.Toast;

        import androidx.appcompat.app.AlertDialog;
        import androidx.fragment.app.FragmentActivity;
        import androidx.fragment.app.FragmentManager;
        import androidx.fragment.app.FragmentTransaction;



        import java.util.ArrayList;
        import java.util.List;

public class HeadActivity extends FragmentActivity implements OnClickListener{

    private LinearLayout ll_home;
    private LinearLayout ll_message;
    private LinearLayout ll_more;
    private ImageView image_home;
    private ImageView image_message;
    private ImageView image_more;

    //Fragment管理器
    private FragmentManager fm = this.getSupportFragmentManager();
    private FragmentTransaction ft;
    private HeadFragment headFragment;
    private FindFragment findFragment;
    private MineFragment mineFragment;
    private  DBOpenHelper mDBOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
//取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_head);
        mDBOpenHelper=new DBOpenHelper(this);
        initView();
        //开始事务（每次改变Fragment管理器之后都要提交）
        ft = fm.beginTransaction();
        home();
        //提交事务
        ft.commit();

    }

    private void initView(){
        ll_home = (LinearLayout)findViewById(R.id.ll_home);

        ll_message = (LinearLayout)findViewById(R.id.ll_message);
        ll_more = (LinearLayout)findViewById(R.id.ll_more);

        image_home = (ImageView)findViewById(R.id.image_home);
        image_message = (ImageView)findViewById(R.id.image_message);
        image_more = (ImageView)findViewById(R.id.image_more);



        ll_home.setOnClickListener(this);
        ll_message.setOnClickListener(this);
        ll_more.setOnClickListener(this);
        ll_home.setSelected(true);
        image_home.setSelected(true);

    }

    @Override
    public void onClick(View v) {
        //每次点击时都需要重新开始事务
        ft = fm.beginTransaction();
        //把显示的Fragment隐藏
        setSelected();
        switch (v.getId()) {
            case R.id.ll_home:
                ll_home.setSelected(true);
                image_home.setSelected(true);
                home();
                break;

            case R.id.ll_message:
                ll_message.setSelected(true);
                image_message.setSelected(true);
                message();
                break;
            case R.id.btn_cance:
                dialog();
      /*
                Intent  intent1=getIntent();
                Intent intent = new Intent(this,LoginActivity.class);
                String name=intent1.getStringExtra("name");
                String password=intent1.getStringExtra("password");
                mDBOpenHelper.delete(name,password);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);     */
                break;
            case R.id.ll_more:
                ll_more.setSelected(true);
                image_more.setSelected(true);
                more();
                break;
        }
        ft.commit();

    }

    public void dialog() {
        // 弹出框类
      AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setIcon(R.mipmap.ic_launcher);//设置弹出框图标
        alert.setTitle("警告");//设置标题
        alert.setMessage("你确定要注销本账号吗？");//设置内容
        alert.setCancelable(true);//点击其他位置是否消失，默认true可以消失
        alert.setPositiveButton("确认",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent  intent1=getIntent();
                Intent intent = new Intent(HeadActivity.this,LoginActivity.class);
                String name=intent1.getStringExtra("name");
                String password=intent1.getStringExtra("password");
                mDBOpenHelper.delete(name,password);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Toast.makeText(HeadActivity.this, "确认成功", Toast.LENGTH_LONG).show();
                startActivity(intent);
                dialog.dismiss();//关闭弹出框
            }
        });
        alert.setNegativeButton("取消",new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        } );
        alert.show();//显示弹出框
    }


    private void setSelected(){
        ll_home.setSelected(false);
        ll_message.setSelected(false);
        ll_more.setSelected(false);
        image_home.setSelected(false);
        image_message.setSelected(false);
        image_more.setSelected(false);
        if(headFragment != null){
            //隐藏Fragment
            ft.hide(headFragment);
        }
        if(findFragment != null){
            ft.hide(findFragment);
        }
        if(mineFragment != null){
            ft.hide(mineFragment);
        }
    }

    private void home(){
        if(headFragment == null){
            headFragment = new HeadFragment();
            ft.add(R.id.fl_content, headFragment);
        }else{
            //显示Fragment
            ft.show(headFragment);
        }
    }
    private void message(){
        if(findFragment == null){
            findFragment = new FindFragment();
            ft.add(R.id.fl_content, findFragment);
        }else{
            ft.show(findFragment);
        }

    }
    private void more(){
        if(mineFragment == null){
            mineFragment = new MineFragment();
            ft.add(R.id.fl_content, mineFragment);
        }else{
            ft.show(mineFragment);
        }

    }

}