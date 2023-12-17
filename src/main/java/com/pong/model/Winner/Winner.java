package com.pong.model.Winner;

import java.util.Arrays;
import java.util.List;

public class Winner {
        int playnumber;
        private final List<String> entries;
        private int currentEntry = 0;

        public Winner(int playnumber) {
            this.entries = Arrays.asList("Play Again", "Return to Menu");
            this.playnumber = playnumber;
        }

    public int getPlaynumber() {
        return playnumber;
    }

    public void nextEntry() {
            currentEntry++;
            if (currentEntry > this.entries.size() - 1)
                currentEntry = 0;
        }

        public void previousEntry() {
            currentEntry--;
            if (currentEntry < 0)
                currentEntry = this.entries.size() - 1;
        }

        public String getEntry(int i) {
            return entries.get(i);
        }

        public boolean isSelected(int i) {
            return currentEntry == i;
        }

        public boolean isSelectedMenu() {
            return isSelected(1);
        }

        public boolean isSelectedPlay() {
            return isSelected(0);
        }

        public int getNumberEntries() {
            return this.entries.size();
        }

    public int getCurrentEntry() {
        return currentEntry;
    }
}

