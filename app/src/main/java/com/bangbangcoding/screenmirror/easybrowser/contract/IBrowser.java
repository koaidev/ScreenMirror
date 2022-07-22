package com.bangbangcoding.screenmirror.easybrowser.contract;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;

import com.bangbangcoding.screenmirror.easybrowser.entity.bo.TabInfo;
import com.bangbangcoding.screenmirror.easybrowser.entity.dao.History;


public interface IBrowser {

    @UiThread
    @NonNull
    IComponent provideBrowserComponent(String componentName);

    interface IComponent {
    }


    interface INavController extends IComponent {
        void goBack();

        void goForward();

        void goHome();

        void showTabs();

        void showAddress(String current);

        void showSetting();

        void showHistory();
    }

    interface IHistoryController extends IComponent {
        void addHistory(History entity);
    }

    interface IDownloadController extends IComponent {

    }

    interface IBookmarkController extends IComponent {

    }

    interface ITabController extends ITabQuickView.Subject, IComponent {
        void onTabSelected(TabInfo tabInfo);

        void onTabClose(TabInfo tabInfo);

        void onTabCreate(TabInfo tabInfo, boolean backstage);

        void onTabGoHome();

        void onTabGoForward();

        void onTabLoadUrl(String url);

        void onRestoreTabCache(TabInfo infoCopy, @Nullable Fragment fragment);

        void onCloseAllTabs();

        void onDestroy();

        TabInfo getCurrentTab();

        Bitmap getPreviewForTab(TabInfo tabInfo);
    }
}
