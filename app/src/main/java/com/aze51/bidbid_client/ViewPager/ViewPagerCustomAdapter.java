package com.aze51.bidbid_client.ViewPager;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.aze51.bidbid_client.ApplicationController;
import com.aze51.bidbid_client.MainActivity;
import com.aze51.bidbid_client.Network.NetworkService;
import com.aze51.bidbid_client.Network.Product;
import com.aze51.bidbid_client.R;
import com.xdu.xhin.library.view.ChangeColorTab;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jeon3029 on 16. 6. 28..
 */

public class ViewPagerCustomAdapter extends PagerAdapter {
    private Context mContext;

    ArrayList<ListItemData> itemDatas;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    LinearLayoutManager mLayoutManager;

    NetworkService networkService;
    public ViewPagerCustomAdapter(Context context) {

        mContext = context;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, final int position) {

        ModelObject modelObject = ModelObject.values()[position];
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(modelObject.getLayoutResId(), collection, false);
        collection.addView(layout);
        initNetworkService();

        if(position == 0) {//첫 번째 페이지 일 경우
            recyclerView = (RecyclerView) collection.findViewById(R.id.recyclerView_current);
            //아이템이 일정할 경우 고정
            recyclerView.setHasFixedSize(true);
            //LayoutManager 초기화
            mLayoutManager = new LinearLayoutManager(mContext.getApplicationContext());//Mainactivity 의 this
            mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(mLayoutManager);
            //adapter 설정
            itemDatas = new ArrayList<ListItemData>();
            mAdapter = new RecyclerViewCustomAdapter(mContext,itemDatas);
            recyclerView.setAdapter(mAdapter);
            Call<List<Product>> listCall = networkService.getContents();
            listCall.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                    Log.i("TAG", "0");
                    if (response.isSuccessful()) {
                        Log.i("TAG", "0 succeed");
                        List<Product> products = response.body();

                        //List<Products> listproducts = respose.body()

                        for (Product p : products) {
                            itemDatas.add(new ListItemData(p));
                        }
                        //itemDatas.add(new ListItemData(R.mipmap.b, "이름", "가격", "3:57 남음"));
                    } else {
                        Toast.makeText(mContext.getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<List<Product>> call, Throwable t) {
                    Log.i("TAG","0 fail");
                }
            });
            //itemDatas.add(new ListItemData(R.mipmap.b,"이름111","가격1111","3:57 남음"));
        }
        else if(position == 1){
            recyclerView = (RecyclerView) collection.findViewById(R.id.recyclerView_scheduled);
            //아이템이 일정할 경우 고정
            recyclerView.setHasFixedSize(true);
            //LayoutManager 초기화
            mLayoutManager = new LinearLayoutManager(mContext.getApplicationContext());//Mainactivity 의 this
            mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(mLayoutManager);
            //adapter 설정
            itemDatas = new ArrayList<ListItemData>();
            mAdapter = new RecyclerViewCustomAdapter(mContext,itemDatas);
            recyclerView.setAdapter(mAdapter);

            //itemDatas.add(new ListItemData(R.mipmap.b,"이름222","가격2222","3:57 남음"));
            Call<List<Product>> listCall = networkService.getContents();
            listCall.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                    Log.i("TAG", "1");
                    if (response.isSuccessful()) {
                        Log.i("TAG", "1 succeed");
                        List<Product> products = response.body();
                        for (Product p : products) {
                            itemDatas.add(new ListItemData(p));
                        }
                        //itemDatas.add(new ListItemData(R.mipmap.b, "이름", "가격", "3:57 남음"));
                    } else {
                        Toast.makeText(mContext.getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
                    }

                }
                @Override
                public void onFailure(Call<List<Product>> call, Throwable t) {
                }
            });

        }
        else if(position == 2){
            Log.i("TAG", "2");
            recyclerView = (RecyclerView) collection.findViewById(R.id.recyclerView_approaching);
            //아이템이 일정할 경우 고정
            recyclerView.setHasFixedSize(true);
            //LayoutManager 초기화
            mLayoutManager = new LinearLayoutManager(mContext.getApplicationContext());//Mainactivity 의 this
            mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(mLayoutManager);
            //adapter 설정
            itemDatas = new ArrayList<ListItemData>();
            mAdapter = new RecyclerViewCustomAdapter(mContext,itemDatas);
            recyclerView.setAdapter(mAdapter);
            //itemDatas.add(new ListItemData(R.mipmap.b,"이름333","가격3333","3:57 남음"));
            Call<List<Product>> listCall = networkService.getContents();
            listCall.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                    Log.i("TAG", "2");
                    if (response.isSuccessful()) {
                        Log.i("TAG", "2 succeed");
                        List<Product> products = response.body();
                        for (Product p : products) {
                            itemDatas.add(new ListItemData(p));

                        }
                        //itemDatas.add(new ListItemData(R.mipmap.b, "이름", "가격", "3:57 남음"));
                    } else {
                        Toast.makeText(mContext.getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
                    }

                }
                @Override
                public void onFailure(Call<List<Product>> call, Throwable t) {
                }
            });


        }
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(mContext,
                new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {
                ((MainActivity)mContext).show_detail_list();

                String pos = String.valueOf(position);
                Toast toast = Toast.makeText(mContext,
                        "포지션 : " + pos, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        }));
        return layout;
    }
    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }
    @Override
    public int getCount() {
        return ModelObject.values().length;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        ModelObject customPagerEnum = ModelObject.values()[position];
        return mContext.getString(customPagerEnum.getTitleResId());
    }
    private void initNetworkService(){
        // TODO: 13. ApplicationConoller 객체를 이용하여 NetworkService 가져오기
        networkService = ApplicationController.getInstance().getNetworkService();
    }

}

