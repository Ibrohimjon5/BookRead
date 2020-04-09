package com.ibrohimjon.bookreader.Asosiy.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.ibrohimjon.bookreader.R;

import java.io.File;

public class Kitob_oqish extends AppCompatActivity {

    PDFView pdfView;
    private SharedPreferences pdfReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitob_oqish);

        pdfView = findViewById(R.id.pdfview);

    }

    String book_url = "";

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences setting2 = getSharedPreferences("read", 0);
        book_url = setting2.getString("book", "");
        final String book_id = setting2.getString("id", "");
        final String categ_id = setting2.getString("categ", "");
        String iconsStoragePath = Environment.getExternalStorageDirectory() + "/GoldReader/" + book_id + "_" + categ_id + ".pdf";
        File sdIconStorageDir = new File(iconsStoragePath);
        if (sdIconStorageDir.exists()) {
            pdfReader = this.getSharedPreferences("Kitoblar", Context.MODE_PRIVATE);
            pdfView.fromFile(sdIconStorageDir)
                    .defaultPage(pdfReader.getInt(book_id + "_" + categ_id,0))
                    .swipeHorizontal(false)
                    .enableAnnotationRendering(true)
                    .scrollHandle(null)
                    .onLoad(new OnLoadCompleteListener() {
                        @Override
                        public void loadComplete(int nbPages) {

                        }
                    })
                    .onDraw(new OnDrawListener() {
                        @Override
                        public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {

                        }
                    })
                    .enableSwipe(true)
                    .onPageChange(new OnPageChangeListener() {
                        @Override
                        public void onPageChanged(int page, int pageCount) {
                            SharedPreferences.Editor edit = pdfReader.edit();
                            edit.putInt(book_id + "_" + categ_id, page);
                            edit.commit();
                        }
                    })
                    .enableDoubletap(true)
                    .scrollHandle(new DefaultScrollHandle(this))
                    .spacing(10)
                    .load();

        }
    }
}
