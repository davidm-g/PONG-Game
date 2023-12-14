package com.aor.pong.model.mode;

import java.util.Arrays;
import java.util.List;

public class Mode {
    private final List<String> entries;
    private int currentEntry = 0;

    public Mode() {
        this.entries = Arrays.asList("Easy", "Medium", "Hard");
    }

    public void nextEntry() {
        if (currentEntry + 1 > this.entries.size() - 1)
            currentEntry = 0;
        else currentEntry++;
    }

    public int getCurrentEntry() {
        return currentEntry;
    }

    public void previousEntry() {
        if (currentEntry - 1 < 0)
            currentEntry = this.entries.size() - 1;
        else currentEntry--;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedEasy() {
        return isSelected(0);
    }

    public boolean isSelectedMedium() {
        return isSelected(1);
    }
    public boolean isSelectedHard() {return isSelected(2);}

    public int getNumberEntries() {
        return this.entries.size();
    }
}
