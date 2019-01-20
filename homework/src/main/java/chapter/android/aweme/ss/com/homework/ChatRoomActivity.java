package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * 点击item跳转的聊天室活动
 */
public class ChatRoomActivity extends AppCompatActivity {

    public static final String CHAT_OBJECT = "CHAT_OBJECT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);

        TextView tv_with_name = findViewById(R.id.tv_with_name);
        Intent intent = getIntent();
        String chat_object = intent.getStringExtra(CHAT_OBJECT);
        tv_with_name.setText("我和"+chat_object+"的对话");
    }
}
