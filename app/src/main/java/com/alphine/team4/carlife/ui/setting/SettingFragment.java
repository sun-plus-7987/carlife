package com.alphine.team4.carlife.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.alphine.team4.carlife.R;
import com.alphine.team4.carlife.ui.notifications.NotificationsViewModel;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class SettingFragment extends Fragment {

    private SettingViewModel settingViewModel;
    private NavController navController;
    private AppBarConfiguration appBarConfiguration;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingViewModel =
                ViewModelProviders.of(this).get(SettingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_setting, container, false);
        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        navController = Navigation.findNavController(requireActivity(),R.id.fragment);
        // drawerLayout 包含背景 HostFragment 以及导航 navigationView
        DrawerLayout drawerLayout = getActivity().findViewById(R.id.Drawerlayout);
        appBarConfiguration = new AppBarConfiguration
//                .Builder(navController.getGraph())
                .Builder(R.id.wifiFragment,R.id.bluetoothFragment)
                .setDrawerLayout(drawerLayout)
                .build();
        // 将 toolbar 和 navController 关联
        NavigationUI.setupActionBarWithNavController((AppCompatActivity) getActivity(),
                navController, appBarConfiguration);
        // 将 navigationView 和 navController 关联
        // navigationView 中的 menu 将会自动根据 navigation.xml 中的各 id 来绑定对应的 Fragment
        NavigationView navigationView = getActivity().findViewById(R.id.NavigationView);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

}