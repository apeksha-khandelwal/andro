package com.example.apekshakhandelwal.news;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.app.LoaderManager;
import android.content.Loader;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.apekshakhandelwal.news.news;

public class MActivity extends AppCompatActivity implements SearchView.OnQueryTextListener,
        LoaderManager.LoaderCallbacks<List<news>>
{

        private adapt mAdapter;
        private RecyclerView.LayoutManager mLayoutManager;
        private String mSearchQuery;
        @BindView(R.id.recycler_view) RecyclerView mRecyclerView;
        @BindView(R.id.empty_view)TextView mEmptyStateTextView;
        @BindView(R.id.loading_indicator)View mLoadingIndicator;

        private static final int NEWS_LOADER_ID = 1;

        public static final String LOG_TAG = MActivity.class.getName();
        private static final String NEWS_REQUEST_URL = "http://content.guardianapis.com/search";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_m);
            ButterKnife.bind(this);

            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);

            mAdapter = new adapt(new ArrayList<news>(), new adapt.OnItemClickListener() {
                @Override public void onItemClick(news news) {
                    String url = news.getUrl();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
            });

            mRecyclerView.setAdapter(mAdapter);

            ConnectivityManager connMgr = (ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

            if (networkInfo != null && networkInfo.isConnected())
            {
                android.app.LoaderManager loaderManager = getLoaderManager();
                loaderManager.initLoader(NEWS_LOADER_ID, null, this);
            } else {
                mLoadingIndicator.setVisibility(View.GONE);
                mRecyclerView.setVisibility(View.GONE);
                mEmptyStateTextView.setVisibility(View.VISIBLE);
                mEmptyStateTextView.setText(R.string.no_internet_connection);
            }
        }

        @Override
        public Loader<List<news>> onCreateLoader(int i, Bundle bundle)
        {
            mLoadingIndicator.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);

            Uri baseUri = Uri.parse(NEWS_REQUEST_URL);
            Uri.Builder uriBuilder = baseUri.buildUpon();
            uriBuilder.appendQueryParameter("api-key", "31348b4c-ec34-4a51-98d4-dfc8471f2a6c");
            if(mSearchQuery!=null)
                uriBuilder.appendQueryParameter("q", mSearchQuery);
            return new load(this, uriBuilder.toString());
        }



    @Override
        public void onLoadFinished(Loader<List<news>> loader, List<news> newsList) {
            mLoadingIndicator.setVisibility(View.GONE);
            mEmptyStateTextView.setVisibility(View.VISIBLE);
            mEmptyStateTextView.setText(R.string.no_news);

            mAdapter.clear();

            if (newsList != null && !newsList.isEmpty()) {
                mRecyclerView.setVisibility(View.VISIBLE);
                mEmptyStateTextView.setVisibility(View.GONE);
                mAdapter.addAll(newsList);
            }
        }

        @Override
        public void onLoaderReset(Loader<List<news>> loader) {
            mAdapter.clear();
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            return true;
        }

        @Override
        public boolean onQueryTextSubmit(String query) {
            mSearchQuery = query;
            getLoaderManager().restartLoader(NEWS_LOADER_ID, null, this);
            return true;
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu, menu);
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.btn_search));
            searchView.setOnQueryTextListener(this);

            return true;
        }

    }
