package l00lgamescommunity.movingsquares;

/**
 * A POJO representing the state of a cow.
 */
public class Cow {
    private float xPos = 0;
    private float yPos = 0;
    private float initialX = 0;
    private boolean dead = false;
    private int imageId;
    private int deadImageId;
    private int score;

    public Cow(int imageId, int deadImageId, int score) {
        this.imageId = imageId;
        this.deadImageId = deadImageId;
        this.score = score;
    }

    public float getXPos() {
        return xPos;
    }

    public void setXPos(float xPos) {
        this.xPos = xPos;
    }

    public float getYPos() {
        return yPos;
    }

    public void setYPos(float yPos) {
        this.yPos = yPos;
    }

    public float getInitialX() {
        return initialX;
    }

    public void setInitialX(float initialX) {
        this.initialX = initialX;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getDeadImageId() {
        return deadImageId;
    }

    public void setDeadImageId(int deadImageId) {
        this.deadImageId = deadImageId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
