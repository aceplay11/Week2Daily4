package com.example.roomwordsample;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private WordDao mWoadDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWoadDao = db.wordDao();
        mAllWords = mWoadDao.getAllWords();

    }
    LiveData<List<Word>> getAllWords(){

        return mAllWords;
    }

    public void insert (Word word){

        new insertAsyncTask(mWoadDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void>{
        private  WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
