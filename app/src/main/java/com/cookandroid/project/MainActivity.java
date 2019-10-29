package com.cookandroid.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Product");

        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);

        final GridView gv = (GridView) findViewById(R.id.gridView);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.product:
                return false;
            case R.id.login:
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                return true;
            case R.id.setting:
                return false;
        }
        return false;
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;
        public MyGridAdapter(Context c) {
            context = c;
        }

        Integer[] dialogID = {
                R.drawable.jewel, R.drawable.jewel, R.drawable.jewel,
                R.drawable.jewel, R.drawable.jewel, R.drawable.jewel,
                R.drawable.jewel, R.drawable.jewel, R.drawable.jewel
        };

        @Override
        public int getCount() {
            return dialogID.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView iv = new ImageView(context);
            iv.setLayoutParams(new GridView.LayoutParams(300,300));
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv.setPadding(20,30,20,30);
            // iv.setBackgroundColor(Color.rgb(240,234,236));
            iv.setImageResource(dialogID[position]);

            final int pos = position;
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View dv = (View) View.inflate(MainActivity.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivDialog = (ImageView) dv.findViewById(R.id.ivDialog);
                    ivDialog.setImageResource(dialogID[pos]);
                    dlg.setTitle("Product");
                    // dlg.setIcon(R.drawable.jewel);
                    dlg.setView(dv);
                    dlg.setNegativeButton("CLOSE", null);
                    dlg.show();
                }
            });

            return iv;
        }
    }
}
