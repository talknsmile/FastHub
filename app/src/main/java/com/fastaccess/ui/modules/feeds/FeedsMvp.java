package com.fastaccess.ui.modules.feeds;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;

import com.fastaccess.data.dao.SimpleUrlsModel;
import com.fastaccess.data.dao.model.Event;
import com.fastaccess.provider.rest.loadmore.OnLoadMore;
import com.fastaccess.ui.base.mvp.BaseMvp;
import com.fastaccess.ui.widgets.dialog.ListDialogView;
import com.fastaccess.ui.widgets.recyclerview.BaseRecyclerAdapter;
import com.fastaccess.ui.widgets.recyclerview.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kosh on 11 Nov 2016, 12:35 PM
 */

interface FeedsMvp {
    interface View extends BaseMvp.FAView, SwipeRefreshLayout.OnRefreshListener,
            android.view.View.OnClickListener, ListDialogView.onSimpleItemSelection<SimpleUrlsModel>,
            BaseRecyclerAdapter.GuideListener<Event> {

        void onNotifyAdapter(@Nullable List<Event> events, int page);

        void onOpenRepoChooser(@NonNull ArrayList<SimpleUrlsModel> models);

        @NonNull OnLoadMore getLoadMore();
    }

    interface Presenter extends BaseMvp.FAPresenter,
            BaseViewHolder.OnItemClickListener<Event>,
            BaseMvp.PaginationListener {

        void onCallApi(int page);

        @NonNull ArrayList<Event> getEvents();

        void onWorkOffline();
    }
}
