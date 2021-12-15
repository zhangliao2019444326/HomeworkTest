package com.example.homeworktest.util;

import android.content.Context;
import android.widget.ImageView;

import com.example.homeworktest.entity.MainMenu;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {
    public static List<ImageView> getHeaderAddInfo(Context context,int icons[]){
        List<ImageView> list=new ArrayList<>();
        for(int i=0;i<icons.length;i++){

            ImageView view =new ImageView(context);
            view.setImageResource(icons[i]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            list.add(view);
        }



        return  list;
    }


    public static List<MainMenu> getMainMenus(int[] icons, String[] menus) {
        List<MainMenu>list=new ArrayList<>();
        for(int i=0;i<icons.length;i++){
            MainMenu MainMenu=new MainMenu(icons[i],menus[i]);
            list.add(MainMenu);
        }
        return  list;
    }
}
