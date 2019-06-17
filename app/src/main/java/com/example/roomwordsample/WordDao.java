package com.example.roomwordsample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

    @Dao
    public interface WordDao{

        @Query("SELECT * from word_table Order By word ASC")
        LiveData<List<Word>> getAllWords();

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        void insert(Word word);

        @Query("DELETE FROM word_table")
        void deleteAll();
    }


