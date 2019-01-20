package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);

        ViewGroup root = findViewById(R.id.root_layout);
        int count = getAllChildViewCount(root);
        Toast.makeText(this,"View的总个数:"+count+"\n除了根布局个数:"+(count-1),Toast.LENGTH_LONG).show();
    }

    public int getAllChildViewCount(View view) {
        //todo 补全你的代码
        /*
        * 思路：
        * ViewGroup与View实际上是多叉树中父节点与子节点的关系
        * 对根布局进行一次先序遍历，记录遍历到的ViewGroup和View的总数
        * */

        //递归截止条件
        if(view == null)
            return 0;
        if(!(view instanceof ViewGroup))
            return 1;
        //若是ViewGroup,对其所有子view递归遍历，sum记录子树总节点数
        int i,sum = 1;
        ViewGroup vg = (ViewGroup) view;
        for (i=0;i<vg.getChildCount();++i){
            sum += getAllChildViewCount(vg.getChildAt(i));
        }

        return sum;
    }
}
