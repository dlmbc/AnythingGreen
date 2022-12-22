package com.example.anythinggreen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.view_pager2);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Set up the ViewPager2 with a FragmentStateAdapter
        viewPager2.setAdapter(new MyFragmentStateAdapter(this));

        // Set up the BottomNavigationView with a OnNavigationItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        viewPager2.setCurrentItem(0);
                        return true;
                    case R.id.information:
                        viewPager2.setCurrentItem(1);
                        return true;
                    case R.id.rewards:
                        viewPager2.setCurrentItem(2);
                        return true;
                    case R.id.settings:
                        viewPager2.setCurrentItem(3);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private static class MyFragmentStateAdapter extends FragmentStateAdapter {
        MyFragmentStateAdapter(FragmentActivity fragmentActivity){
            super(fragmentActivity);
        }

        public Fragment createFragment(int position){
            switch (position){
                case 0:
                    return new HomeFragment();
                case 1:
                    return new InfoFragment();
                case 2:
                    return new RewardsFragment();
                case 3:
                    return new SettingsFragment();
                default:
                    throw new IllegalStateException("Invalid position: "+ position);
            }
        }

        public int getItemCount(){
            return 4;
        }
    }
}