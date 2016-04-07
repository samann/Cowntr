package droidowl.cowcounter;

/**
 * Created by droidowl on 3/3/16.
 */
public class TeamCount {
    int red;
    int blue;
    int prevRed;
    int prevBlue;

    public TeamCount() {
        red = 0;
        blue = 0;
        prevBlue = blue;
        prevRed = red;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public void incBlue(int x) {
        blue += x;
    }

    public void incRed(int x) {
        red += x;
    }

    public int getPrevRed() {
        return prevRed;
    }

    public void setPrevRed(int prevRed) {
        this.prevRed = prevRed;
    }

    public int getPrevBlue() {
        return prevBlue;
    }

    public void setPrevBlue(int prevBlue) {
        this.prevBlue = prevBlue;
    }
}
