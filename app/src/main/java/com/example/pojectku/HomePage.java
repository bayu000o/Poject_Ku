package com.example.pojectku;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomePage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomePage extends Fragment {

    private LinearLayout lainnya;
    private LinearLayout iconTambahan;

    private ViewPager2 viewPager2;
    private List<ImageSlide> imageList;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public HomePage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomePage.
     */
    // TODO: Rename and change types and number of parameters
    public static HomePage newInstance(String param1, String param2) {
        HomePage fragment = new HomePage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home_page, container, false);

        lainnya = rootView.findViewById(R.id.lainnya);
        iconTambahan = rootView.findViewById(R.id.icon_tambahan);




        ViewPager2 viewPager2 = rootView.findViewById(R.id.view_page);

        List<ImageSlide> sliderItems = new ArrayList<>();
        sliderItems.add(new ImageSlide(R.drawable.image1));
        sliderItems.add(new ImageSlide(R.drawable.image2));
        sliderItems.add(new ImageSlide(R.drawable.image3));


        viewPager2.setAdapter(new ImageSlideAdapter(sliderItems, viewPager2, 3000, v -> {
            viewPager2.setCurrentItem(1);
        }));

        // Menambahkan jarak antar gambar
        int marginPx = (int) (15 * getResources().getDisplayMetrics().density); // 16dp ke pixel
        viewPager2.addItemDecoration(new ItemDecoration(marginPx));

        viewPager2.setCurrentItem(1);



        lainnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iconTambahan.getVisibility() == View.GONE) {
                    iconTambahan.setVisibility(View.VISIBLE);
                } else {
                    iconTambahan.setVisibility(View.GONE);
                }
            }
        });
        return rootView;
    }


}