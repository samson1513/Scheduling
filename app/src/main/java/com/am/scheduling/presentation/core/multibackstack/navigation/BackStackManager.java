package com.am.scheduling.presentation.core.multibackstack.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;

import java.util.Stack;

/**
 * Created by Alex Michenko
 * on 08.02.2018.
 */

public class BackStackManager {

    private SparseArray<Stack<BackStackEntry>> backStacks = new SparseArray<>();

    public void push(int hostId, @NonNull BackStackEntry entry) {
        Stack<BackStackEntry> backStack = getBackStack(hostId);
        if (backStack == null) {
            backStack = new Stack<>();
            backStacks.put(hostId, backStack);
        }
        backStack.push(entry);
    }

    public BackStackEntry pop(int hostId) {
        Stack<BackStackEntry> backStack = getBackStack(hostId);
        if (backStack == null) {
            return null;
        } else if (backStack.isEmpty()) {
            return null;
        } else {
            return backStack.pop();
        }
    }

    public void clear(int hostId) {
        Stack<BackStackEntry> backStack = getBackStack(hostId);
        if (backStack != null) {
            backStack.clear();
        }
    }

    public int backStackSize(int hostId) {
        Stack<BackStackEntry> backStack = getBackStack(hostId);
        return backStack != null ? backStack.size() : 0;
    }

    @Nullable
    public BackStackEntry peek(int hostId) {
        Stack<BackStackEntry> backStack = getBackStack(hostId);
        if (backStack == null) {
            return null;
        } else if (backStack.isEmpty()) {
            return null;
        } else {
            return backStack.peek();
        }
    }

    @Nullable
    private Stack<BackStackEntry> getBackStack(int hostId) {
        return backStacks.get(hostId);
    }

    @NonNull
    public Parcelable saveState() {
        return new SavedState(backStacks);
    }

    public void restoreState(@Nullable Parcelable state) {
        if (state != null) {
            SavedState savedState = (SavedState) state;
            backStacks = savedState.stacks;
        }
    }

    static class SavedState implements Parcelable {
        final SparseArray<Stack<BackStackEntry>> stacks;

        public SavedState(SparseArray<Stack<BackStackEntry>> backStacks) {
            this.stacks = backStacks;
        }

        private SavedState(Parcel in) {
            int count = in.readInt();
            this.stacks = new SparseArray<>();
            for (int i = 0; i < count; i++) {
                int key = in.readInt();
                int deep = in.readInt();
                Stack<BackStackEntry> entries = new Stack<>();
                for (int j = 0; j < deep; j++) {
                    entries.add(BackStackEntry.CREATOR.createFromParcel(in));
                }
                stacks.put(key, entries);
            }
        }

        @Override
        public void writeToParcel(Parcel out, int flags) {
            int count = stacks.size();
            out.writeInt(count);
            for (int i = 0; i < count; i++) {
                int key = stacks.keyAt(i);
                int deep = stacks.valueAt(i).size();
                out.writeInt(key);
                out.writeInt(deep);
                for (int j = 0; j < deep; j++) {
                    stacks.get(key).get(j).writeToParcel(out, flags);
                }
            }
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {

            @Override
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in);
            }

            @Override
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }
}
