package com.example.android.todolist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private LiveData<List<TaskEntry>>tasks;
    public MainViewModel(@NonNull Application application) {
        super(application);
        AppDatabase appDatabase=AppDatabase.getInstance(this.getApplication());
        tasks=appDatabase.taskDao().loadAllTasks();

    }

    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }
}
