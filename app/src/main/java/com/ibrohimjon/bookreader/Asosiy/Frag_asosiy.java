package com.ibrohimjon.bookreader.Asosiy;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ibrohimjon.bookreader.R;
import com.ibrohimjon.bookreader.Splash;
import com.ibrohimjon.bookreader.q_r_l_c;

import java.util.ArrayList;

import static com.ibrohimjon.bookreader.Splash.XATOLIK_YOZISH;
import static com.ibrohimjon.bookreader.Splash.d_w_d_t;

public class Frag_asosiy extends Fragment {

    RecyclerView recyclerView;
    Asosiy_recyclerView_adapter myAdapter;
    ArrayList<Asosiy_list> asosiy_list = new ArrayList<>();

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_asosiy, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);

        myAdapter = new Asosiy_recyclerView_adapter(getContext(), asosiy_list);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int soni = (int) dpWidth / 150;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), soni));
        recyclerView.setAdapter(myAdapter);

        Get_data get_data = new Get_data(getContext());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            get_data.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } else {
            get_data.execute();
        }

        return view;
    }

    private class Get_data extends AsyncTask<String, String, String> {
        Context context;
        ProgressDialog dialog;

        Get_data(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            try {
                asosiy_list.clear();
                dialog = new ProgressDialog(context);
                dialog.setTitle("");
                dialog.setCancelable(false);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setMessage("Маълумот юкланмоқда...");
                dialog.show();
            } catch (Exception e) {
                XATOLIK_YOZISH(e);
            }
        }

        @Override
        protected void onProgressUpdate(String... values) {
            if (dialog != null) {
                dialog.setMessage(values[0] + "");
            }
        }

        @Override
        protected String doInBackground(String... strings) {

            if (Splash.i_s_o_n(context)) {

                try {
                    String g_r_F_f_h = null;
                    g_r_F_f_h = Splash.tz_r() + q_r_l_c.get_book + q_r_l_c.p_s;
                    String k_a_j = "";
                    try {
                        k_a_j = d_w_d_t(g_r_F_f_h);
                    } catch (Exception e) {
                        XATOLIK_YOZISH(e);
                    }

                    if (k_a_j != null && !k_a_j.equals("") && !k_a_j.equals("no") && !k_a_j.equals("no_c")) {
                        if (!k_a_j.equals("no_c")) {
                            try {
                                String[] tv_l = k_a_j.split("~");
                                publishProgress("Китоблар юкланмоқда... (" + tv_l.length + " та )");

                                if (tv_l.length > 0) {
                                    for (int i = 0; i < tv_l.length; i++) {
                                        String s = tv_l[i];
                                        if (!s.equals("")) {
                                            try {
                                                String[] tovar = s.split("\\^");
                                                if (tovar.length > 4) {
                                                    String id = tovar[0];
                                                    String nomi = tovar[1].replace("'", "`").replace("\"", "`").replace("\n", " ");
                                                    String categ_id = tovar[2];
                                                    String izox = tovar[3];
                                                    String rasm = tovar[4];
                                                    String kitob = tovar[5];
                                                    String yuklandi = tovar[6];

                                                    asosiy_list.add(new Asosiy_list(id, nomi, categ_id, izox, rasm, kitob, yuklandi));
                                                }
                                            } catch (Exception e) {
                                                XATOLIK_YOZISH(e);
                                            }
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                XATOLIK_YOZISH(e);
                            }
                        }
                    }

                } catch (Exception e) {
                    XATOLIK_YOZISH(e);
                }

            }
            return "ok";
        }

        @Override
        protected void onPostExecute(String result) {
            try {
                if (dialog != null) {
                    dialog.dismiss();
                }
            } catch (Exception e) {
                XATOLIK_YOZISH(e);
            }
            if (myAdapter != null) {
                myAdapter.notifyDataSetChanged();
            }
            if (result.equals("no")) {
                Snackbar snackbar1 = Snackbar.make(recyclerView, "Юкланишда хатолик бўлди!", Snackbar.LENGTH_SHORT);
                snackbar1.show();
            } else if (result.equals("inter")) {
                Snackbar snackbar1 = Snackbar.make(recyclerView, "Интернет билан алоқа паст ёки алоқа йўқ!", Snackbar.LENGTH_SHORT);
                snackbar1.show();
            } else {
                Snackbar snackbar1 = Snackbar.make(recyclerView, "Муваффаққиятли юкланди!", Snackbar.LENGTH_SHORT);
                snackbar1.show();
            }
        }
    }
}
