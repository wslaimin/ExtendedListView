package lm.com.extendedlistview;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ExtendedListView.OnPositionChangedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ExtendedListView listView=(ExtendedListView)findViewById(R.id.listView);
        String[] strings=new String[20];
        for(int i=0;i<strings.length;i++){
            strings[i]=""+i;
        }

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,strings);
        listView.setAdapter(adapter);
        listView.setOnPositionChangedListener(this);
    }

    @Override
    public void onPositionChanged(ExtendedListView listView, int position, View scrollBarPanel) {
        ((TextView)listView.getScrollBarPanel()).setText(listView.getAdapter().getItem(position).toString());
    }
}
