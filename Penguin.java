public class Penguin extends Bird implements Swim {

    private boolean swimming;
    private int depth;

    public Penguin(String name) {
        super(name);
        this.swimming = false;
        this.depth = 0;
    }

    @Override
    public String sing() {
        return "Quack!";
    }

    public int getDepth() {
        return depth;
    }

    public boolean isSwimming() {
        return swimming;
    }

    /**
     * dives, must be on ground
     */
    @Override
    public void dive() {
        if (!this.swimming && this.depth == 0) {
            this.swimming = true;
            System.out.printf("%s dives into the water.%n", this.getName());
        }
    }

    /**
     * swim downward
     * @param meters depth increase
     * @return depth
     */
    @Override
    public int swimDown(int meters) {
        if (this.swimming) {
            this.depth = Math.min(this.depth + meters, 325);
            System.out.printf("%s swims downward, depths : %d%n", this.getName(), this.depth);
        }
        return this.depth;
    }

    /**
     * swin upward
     * @param meters depth decrease
     * @return depth
     */
    @Override
    public int swimUp(int meters) {
        if (this.swimming) {
            this.depth = Math.max(this.depth - meters, 0);
            System.out.printf("%s swims upward, depth : %d%n", this.getName(), this.depth);
        }
        return this.depth;
    }

    /**
     * get out of water, must be on surface
     */
    @Override
    public void getOut() {
        if (this.swimming && this.depth == 0) {
            System.out.printf("%s gets out of the water.%n", this.getName());
        } else {
            System.out.printf("%s is too deep, it can't get out.%n", this.getName());
        }
    }
}
