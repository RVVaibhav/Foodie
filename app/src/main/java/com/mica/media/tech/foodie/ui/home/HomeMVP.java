package com.mica.media.tech.foodie.ui.home;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public interface HomeMVP {

   /* public interface HomeView extends BaseView{
        void onSuccessImages(List<GalleryData> model);
        void onShowPaginationLoading(boolean show);

        void onGetListAvailable(List<Datum> o);

        void onNoMoreList();

        void onFail(String message);

        void onError(Object t);



    }
    public  interface HomePresenter {
        void onDownloadImages(String tbleName);
        void onDestroy();

        void onLoadMore();

        void onLoadMoreItem();

        RecyclerView.OnScrollListener scrollListener(LinearLayoutManager layoutManager);


        void setAllViewAvailable(HomeView view);
    }

    public interface HomeListener {
        void onFail(String message);

        void onError(Object t);


        void onPaginationError();

        void onGetList(List<Datum> message);
        void onGetImagesGallery(List<GalleryData> models);
    }

    public interface HomeModule {
        void onGetUpdateListFromServer(String tableName, int perPage, int PageNumber, HomeListener listener);
        void onGetGalleryModels(String tbleName, HomeListener listener);

        void onDestroy();

    }*/
}
