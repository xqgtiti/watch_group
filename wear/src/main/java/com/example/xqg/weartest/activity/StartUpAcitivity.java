package com.example.xqg.weartest.activity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.wearable.view.CardFrame;
import android.support.wearable.view.CircledImageView;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Toast;

import com.example.xqg.weartest.R;
import com.example.xqg.weartest.bean.Data;
import com.example.xqg.weartest.bean.UserInfo;
import com.example.xqg.weartest.sql.UserInfoDb;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat.WearableExtender;
import java.util.UUID;

/**
 * Created by xqg on 2017/8/31.
 * 启动界面，动画，选择心情功能
 */

public class StartUpAcitivity extends Activity {

    CircledImageView card_yes, card_no;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);
        initView();
        initDataBase();
    }

    public void showNotification(Context context) {
        int notificationId = 001;
        Intent intent = new Intent();
        intent.setClass(context, MainActivity.class);
        //传递数值
        //viewIntent.putExtra(EXTRA_EVENT_ID, eventId);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_accessibility_white_48dp)//设置notification小图标
                .setContentTitle("久坐提醒")//设置notification标题
                .setContentText("您已经两小时没放松啦，站起来走走吧!")//设置notification文本内容
                .setContentIntent(pendingIntent);//设置点击设置点击action时要跳转的页面（wear设备向左滑动第二个按钮的点击后所做的操作）

        //创建一个notifaicationmanamgercompat实例
        NotificationManagerCompat manager = NotificationManagerCompat.from(context);
        //将通知发送出去
        manager.notify(notificationId, builder.build());
    }

    void initDataBase(){
        UserInfoDb userInfoDb = new UserInfoDb(getApplicationContext());
        if (userInfoDb.getCount() == 0){

            //原来表为空，第一次安装这个应用
            final Data data = (Data)getApplication();

            UserInfo userinfo = new UserInfo();
            userinfo.setDeviceId(getUniquePsuedoID());
            userinfo.setStatusSitLongCall(1);
            userinfo.setStatusCheckMoodCall(0);
            data.setUserInfo(userinfo);

            String uniquePsueDoId = getUniquePsuedoID();
            userInfoDb.insert(uniquePsueDoId,1,0);
       //     Toast.makeText(getApplicationContext(), "存储数据成功!"+userInfoDb.getCount(), Toast.LENGTH_SHORT).show();

        }
        else{
            //原来已有数据
          //  Toast.makeText(getApplicationContext(), "已有数据"+userInfoDb.getCount(), Toast.LENGTH_SHORT).show();
            final Data data = (Data)getApplication();
            UserInfo userinfo = new UserInfo();
            userinfo.setDeviceId(userInfoDb.getDeivceId());
            userinfo.setStatusSitLongCall(userInfoDb.getStatusSitLongCall());
            userinfo.setStatusCheckMoodCall(userInfoDb.getStatusCheckMoodCall());
            data.setUserInfo(userinfo);
        }
    }
    void initView(){
        card_yes = (CircledImageView)findViewById(R.id.card_yes);
        card_no= (CircledImageView)findViewById(R.id.card_no);

        card_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),FirstNoteMoodActicity.class);
                startActivity(intent);
                //showNotification(getApplicationContext());

            }
        });

        card_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });
    }
    //获得独一无二的Psuedo ID
    public static String getUniquePsuedoID() {
        String serial = null;

        String m_szDevIDShort = "35" +
                Build.BOARD.length()%10+ Build.BRAND.length()%10 +

                Build.CPU_ABI.length()%10 + Build.DEVICE.length()%10 +

                Build.DISPLAY.length()%10 + Build.HOST.length()%10 +

                Build.ID.length()%10 + Build.MANUFACTURER.length()%10 +

                Build.MODEL.length()%10 + Build.PRODUCT.length()%10 +

                Build.TAGS.length()%10 + Build.TYPE.length()%10 +

                Build.USER.length()%10 ; //13 位

        try {
            serial = android.os.Build.class.getField("SERIAL").get(null).toString();
            //API>=9 使用serial号
            return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
        } catch (Exception exception) {
            //serial需要一个初始化
            serial = "serial"; // 随便一个初始化
        }
        //使用硬件信息拼凑出来的15位号码
        return new UUID(m_szDevIDShort.hashCode(), serial.hashCode()).toString();
}
}
