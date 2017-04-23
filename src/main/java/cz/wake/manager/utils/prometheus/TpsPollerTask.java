package cz.wake.manager.utils.prometheus;

import java.util.LinkedList;

public class TpsPollerTask implements Runnable {

    /**
     * Max amount of ticks that should happen per second
     */
    static final int TICKS_PER_SECOND = 20;
    /**
     * Every 40 ticks (2s ideally) the server will be polled
     */
    static final int POLL_INTERVAL = 40;
    /**
     * The amount of TPS values to keep for calculating the average
     */
    static final int TPS_QUEUE_SIZE = 10;

    private long lastPoll = System.currentTimeMillis();
    private LinkedList<Float> tpsQueue = new LinkedList<>();

    @Override
    public void run() {
        final long now = System.currentTimeMillis();
        long timeSpent = (now - this.lastPoll) / 1000;
        timeSpent = timeSpent == 0 ? 1 : timeSpent;

        final float tps = (float) POLL_INTERVAL / (float) timeSpent;

        log(tps > TICKS_PER_SECOND ? TICKS_PER_SECOND : tps);

        this.lastPoll = now;
    }

    private void log(float tps) {
        tpsQueue.add(tps);
        if (tpsQueue.size() > TPS_QUEUE_SIZE) {
            tpsQueue.poll();
        }
    }

    public float getAverageTPS() {
        if (tpsQueue.size() < TPS_QUEUE_SIZE) {
            return 20;
        }

        float sum = 0F;
        for (Float f : tpsQueue) {
            sum += f;
        }
        return sum / tpsQueue.size();
    }
}
